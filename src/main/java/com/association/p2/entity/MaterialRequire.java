package com.association.p2.entity;

import java.util.HashMap;
import java.util.List;

public class MaterialRequire {
    private String id;
    //接收组织名称
    private String receivename;
    //地址
    private String address;
    //组织类型
    private String type;
    //物资对接情况
    private String docksituation;
    //需求表 list(map<name:num>)
    private List<HashMap<String, String>> require;
    //联系信息 list(map<name:phoneNum>)
    private List<HashMap<String, String>> contact;
    //需求发布时间
    private String posttime;
    //需求截止时间
    private String endtime;
    //需求来源
    private String demandfrom;
    //官方链接
    private String url;
    //需求证明
    private String prove;
    //当前状态：进行中 已过期
    private String state;
}
