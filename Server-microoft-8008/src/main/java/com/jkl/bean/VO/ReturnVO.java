package com.jkl.bean.VO;

/**
 * @author zhongxin
 * @date 2020/10/8/008 14:47
 */
public class ReturnVO<E> {
    private Boolean success = true;//请求成功与否
    private String msg;//错误消息
    private E datas;

    public ReturnVO() {
    }

    public ReturnVO(Boolean success, String msg, E datas) {
        this.success = success;
        this.msg = msg;
        this.datas = datas;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        //有错误消息则请求错误
        this.success = false;
    }

    public E getDatas() {
        return datas;
    }

    public void setDatas(E datas) {
        this.datas = datas;
    }
}
