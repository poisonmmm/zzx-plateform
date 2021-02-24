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
public class Moneyrequire implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 需求方
     */
    private String requirename;

    /**
     * 需求金额
     */
    private String requireprice;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    private String email;

    /**
     * 微信公众号
     */
    private String publicwechat;

    /**
     * 账户名
     */
    private String accountname;

    /**
     * 开户行
     */
    private String depositbank;

    /**
     * 账号
     */
    private String accountnumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 发布时间
     */
    private String posttime;

    private String url;

    private String state;


}
