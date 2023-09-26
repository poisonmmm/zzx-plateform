package com.association.utils;

import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LUMING
 * @since 2023/9/26 16:10
 */
@Component
@Slf4j
public class IPUtils {
    private static Searcher searcher;

    public static Map<String,String> getCityInfo(String ip) {
        //数据格式： 国家|区域|省份|城市|ISP
        //192.168.31.160 0|0|0|内网IP|内网IP
        //47.52.236.180 中国|0|香港|0|阿里云
        //220.248.12.158 中国|0|上海|上海市|联通
        //164.114.53.60 美国|0|华盛顿|0|0
        HashMap<String, String> cityInfo = new HashMap<>();
        try {
            String searchIpInfo = searcher.search(ip);
            System.out.println("searchInfo:"+searchIpInfo);
            String[] splitIpInfo = searchIpInfo.split("\\|");
            cityInfo.put("ip",ip);
            cityInfo.put("searchInfo", searchIpInfo);
            cityInfo.put("country",splitIpInfo[0]);
            cityInfo.put("region",splitIpInfo[1]);
            cityInfo.put("province",splitIpInfo[2]);
            cityInfo.put("city",splitIpInfo[3]);
            cityInfo.put("ISP",splitIpInfo[4]);
            return cityInfo;
        } catch (Exception e) {
            log.info("【log:parse ip】failed to search"+ip+",error"+e);
        }
        return null;
    }

    /**
     * 在服务启动时加载 ip2region.db 到内存中
     * 解决打包jar后找不到 ip2region.db 的问题
     */
    @PostConstruct
    public static void initIp2regionResource() {
        try {
            InputStream inputStream = new ClassPathResource("/ipdb/ip2region.xdb").getInputStream();
            byte[] dbBinStr = FileCopyUtils.copyToByteArray(inputStream);
            // 创建一个完全基于内存的查询对象
            searcher = Searcher.newWithBuffer(dbBinStr);
        } catch (Exception e) {
            log.info("【log:load ip to cache】failed to create content cached searcher: %s\n", e);
        }
    }

}
