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
    @ApiModelProperty(value = "应用返回编码", name = "code")
    private String code;

    /**
     * 应用返回消息
     */
    @ApiModelProperty(value = "应用返回消息", name = "message")
    private String message;

    /**
     * 应用返回结果
     */
    @ApiModelProperty(value = "应用返回结果", name = "data")
    private T data;


    public RestVo() {
        ResultMsg result = ResultMsg.SUCCESS;
        this.code = result.getCode();
        this.message = result.getName();
    }

    public static RestVo SUCCESS() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setCode(result.getCode());
        restVo.setMessage(result.getName());
        return restVo;
    }

    public static RestVo SUCCESS(Object obj) {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.SUCCESS;
        restVo.setCode(result.getCode());
        restVo.setMessage(result.getName());
        restVo.setData(obj);
        return restVo;
    }

    public static RestVo FAIL() {
        RestVo<Object> restVo = new RestVo<>();
        ResultMsg result = ResultMsg.FAIL;
        restVo.setCode(result.getCode());
        restVo.setMessage(result.getName());
        return restVo;
    }

}
