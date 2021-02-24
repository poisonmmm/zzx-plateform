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
public class Materialsupply implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品品牌
     */
    private String band;

    /**
     * 产品标准
     */
    private String stander;

    /**
     * 产品型号/规格
     */
    private String model;

    /**
     * 适用环境
     */
    private String suitableenvironment;

    /**
     * 产品材料及其他信息
     */
    private String other;

    /**
     * 供应方单位名称
     */
    private String supplyname;

    /**
     * 供应方单位类别
     */
    private String supplytype;

    /**
     * 联络人姓名
     */
    private String contactname;

    /**
     * 联络人电话
     */
    private String contactophone;

    /**
     * 医疗经营资质
     */
    private String businessqualification;

    /**
     * 医疗内销产品注册证
     */
    private String productregistrationcertificate;

    /**
     * 厂家医疗生产资质
     */
    private String medicalproductionqualification;

    /**
     * 信息有效期
     */
    private String validity;

    /**
     * 状态
     */
    private String state;


}
