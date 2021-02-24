package com.association.platform.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author luming
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Materialrequire implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 接收组织名称
     */
    private String receivename;

    private String address;

    /**
     * 组织类型
     */
    private String type;

    /**
     * 物资对接情况
     */
    private String docksituation;

    /**
     * 需求表
     */
    private String require;

    /**
     * 联系信息
     */
    private String contact;

    /**
     * 需求发布时间
     */
    private String posttime;

    /**
     * 需求截止时间
     */
    private String endtime;

    /**
     * 需求来源
     */
    private String demandfrom;

    /**
     * 官方链接
     */
    private String url;

    /**
     * 需求证明
     */
    private String prove;

    private String state;


}
