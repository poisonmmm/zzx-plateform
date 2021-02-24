package com.association.platform.util;

public enum ResultMsg {
    OK("成功"),
    ParameterMissing("参数缺失"),
    ApplySuccess("申请成功"),
    DeleteSuccess("删除成功")
    ;
    public String msg;
    ResultMsg(String msg){
        this.msg=msg;
    }
}
