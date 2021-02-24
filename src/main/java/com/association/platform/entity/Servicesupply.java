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
public class Servicesupply implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 供应方名称
     */
    private String supplyname;

    /**
     * 供应方类别
     */
    private String supplytype;

    /**
     * 联系人姓名
     */
    private String contactname;

    /**
     * 联系人电话
     */
    private String contactphone;

    /**
     * 服务内容
     */
    private String servicecontent;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 服务覆盖区域
     */
    private String area;

    /**
     * 可服务时间
     */
    private String serviceabletime;

    /**
     * 状态
     */
    private String state;


}
