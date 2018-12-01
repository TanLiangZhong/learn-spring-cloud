package com.ml.system.vo;

import com.ml.system.constant.ResultMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/12/1
 */
@Data
@ApiModel(value = "业务响应实体")
public class RestVo<T> implements Serializable {

    /**
     * 应用返回编码
     */
    @ApiModelProperty(value = "应用返回编码", name = "appCode")
    private String appCode;

    /**
     * 应用返回消息
     */
    @ApiModelProperty(value = "应用返回消息", name = "appMsg")
    private String appMsg;

    /**
     * 应用返回结果
     */
    @ApiModelProperty(value = "应用返回结果", name = "result")
    private T result;


    public RestVo() {
        ResultMsg result = ResultMsg.SUCCESS;
        this.appCode = result.getCode();
        this.appMsg = result.getName();
    }

    public static RestVo SUCCESS() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMsg(result.getName());
        return restVo;
    }

    public static RestVo SUCCESS(Object obj) {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setAppCode(result.getCode());
        restVo.setAppMsg(result.getName());
        restVo.setResult(obj);
        return restVo;
    }

    public static RestVo FAIL() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.FAIL;
        restVo.setAppCode(result.getCode());
        restVo.setAppMsg(result.getName());
        return restVo;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public void setAppMsg(String appMsg) {
        this.appMsg = appMsg;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
