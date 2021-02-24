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
public class Volunteer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String phone;

    private String wechat;

    private String sex;

    /**
     * 所在地区
     */
    private String location;

    /**
     * 紧急联系人姓名
     */
    private String emergencyname;

    /**
     * 紧急联系人电话
     */
    private String emergencyphone;

    /**
     * 专业能力
     */
    private String ability;

    /**
     * 志愿者经历
     */
    private String experience;

    private String startime;

    private String endtime;

    /**
     * 期望服务内容
     */
    private String servicecontent;

    /**
     * 备注
     */
    private String remark;


}
