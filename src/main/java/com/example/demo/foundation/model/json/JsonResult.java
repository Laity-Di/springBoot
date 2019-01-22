package com.example.demo.foundation.model.json;

import com.example.demo.constant.CommonConstants;

import java.io.Serializable;

/**
 * @author: Ryan
 * @since: 2018/11/13 11:27
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class JsonResult implements Serializable {

    private static final Long SUCCESS_CODE = 0L;

    private static final Long ERROR_STATE_CODE = 1L;

    private static final Long SUCCESS_BUSSINESS_CODE = 0L;

    private static final Long ERROR_BUSSINESS_CODE = 1L;

    private static final long serialVersionUID = -1L;

    private String msg = "";

    /**
     * 调用接口是否成功，并不代表返回业务代码
     * 仅仅表示接口调用是否成功
     * 0成功，1失败
     */
    private String code = "200";

    /**
     * 接口处理逻辑返回业务代码
     * 根据编码规则说明业务逻辑处理结果
     */
    private String businessCode = "200";

    /**
     * 接口调用是否成功
     */
    private Boolean success;

    /**
     * 业务返回数据
     */
    private Object data = null;

    public JsonResult() {}

    /**
     *
     * @param msg
     * @param code
     * @param data
     */
    public JsonResult(String msg, Long code, Object data) {
        this.msg = msg;
        this.code = String.format(CommonConstants.ZERO_FILL_TEMPLATE, code);
        this.data = data;
    }

    /**
     *
     * @param msg
     * @param code
     * @param data
     * @param businessCode
     */
    public JsonResult(String msg, Long code, Object data, Long businessCode) {
        this.msg = msg;
        this.code = String.format(CommonConstants.ZERO_FILL_TEMPLATE, code);
        this.data = data;
        this.businessCode = String.format(CommonConstants.ZERO_FILL_TEMPLATE, businessCode);
    }

    /**
     * 构造成功的JsonResult
     * 返回默认业务代码
     * @param msg
     * @param data
     * @return
     */
    public static JsonResult buildSuccessResult(String msg, Object data) {
        return new JsonResult(msg, SUCCESS_CODE, data, SUCCESS_BUSSINESS_CODE);
    }

    /**
     * 构造成功的JsonResult
     * 返回自定义业务代码
     * @param msg
     * @param data
     * @param bussinessId
     * @return
     */
    public static JsonResult buildSuccessResult(String msg, Object data, Long bussinessId) {
        return new JsonResult(msg, SUCCESS_CODE, data, bussinessId);
    }

    /**
     * 构造状态不正确的JsonResult
     * 返回默认业务代码
     * @param msg
     * @param data
     * @return
     */
    public static JsonResult buildErrorStateResult(String msg, Object data) {
        return new JsonResult(msg, ERROR_STATE_CODE, data, ERROR_BUSSINESS_CODE);
    }

    /**
     * 构造状态不正确的JsonResult
     * 返回自定义业务代码
     * @param msg
     * @param data
     * @param businessId
     * @return
     */
    public static JsonResult buildErrorStateResult(String msg, Object data, Long businessId) {
        return new JsonResult(msg, ERROR_STATE_CODE, data, businessId);
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "businessCode='" + businessCode + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        success = "0000".equals(code);
        return success;
    }
}
