package com.ml.bean.common.vo;

import com.ml.bean.common.constant.ResultMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
@ApiModel(value = "业务响应实体")
public class RestVo<T> implements Serializable {

    private static final long serialVersionUID = -5668554152671000203L;

    /**
     * 应用返回编码
     */
    @ApiModelProperty(value = "应用返回编码", name = "appCode")
    private String appCode;

    /**
     * 应用返回消息
     */
    @ApiModelProperty(value = "应用返回消息", name = "appMesg")
    private String appMesg;

    /**
     * 应用返回结果
     */
    @ApiModelProperty(value = "应用返回结果", name = "result")
    private T result;

    @ApiModelProperty(value = "应用返回结果", name = "success")
    private boolean success = true;

    public RestVo() {
        ResultMsg result = ResultMsg.SUCCESS;
        this.appCode = result.getCode();
        this.appMesg = result.getName();
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
        if (StringUtils.isBlank(this.appCode) || !ResultMsg.SUCCESS.getCode().equals(this.appCode)) {
            this.success = false;
        }
    }

    public void setAppCode(ResultMsg result) {
        this.appCode = result.getCode();
        this.appMesg = result.getName();
        if (StringUtils.isBlank(this.appCode) || !ResultMsg.SUCCESS.getCode().equals(this.appCode)) {
            this.success = false;
        }
    }

    public String getAppMesg() {
        return appMesg;
    }

    public void setAppMesg(String appMesg) {
        this.appMesg = appMesg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static RestVo success() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        return restVo;
    }

    public static RestVo success(Object obj) {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setResult(obj);
        return restVo;
    }

    public static RestVo FAIL() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(String msg) {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(ResultMsg result) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(result.getName());
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo ERROR() {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(ResultMsg.ERROR);
        return restVo;
    }

    public static RestVo FAIL(String code, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(code);
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }

    public static RestVo FAIL(ResultMsg result, String msg) {
        RestVo<Object> restVo = new RestVo<>();
        restVo.setAppCode(result.getCode());
        restVo.setAppMesg(msg);
        restVo.setSuccess(false);
        return restVo;
    }

    /**
     * 如果接口对象不为空并且返回码为成功(SUCCESS.getCode()), 返回true，否则返回false
     *
     * @param restVo
     * @return
     * @Author: lan.xiangjian
     * @Date: 2018/12/27 18:23
     */
    public static boolean checkSuccessCode(RestVo restVo) {
        return restVo != null && ResultMsg.SUCCESS.getCode().equals(restVo.getAppCode());
    }

    public boolean isSuccess() {
        return success;
    }
}
