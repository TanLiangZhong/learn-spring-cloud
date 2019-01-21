package com.ml.jpademo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页 - Bo
 *
 * @author liangzhong
 * @date 2019/1/21 10:38
 */
@Data
@ApiModel(description = "分页Bo")
public class PageBo<T> {

    @ApiModelProperty(value = "当前页数", required = true, example = "1")
    private Integer page;

    @ApiModelProperty(value = "每页显示数", required = true, example = "30")
    private Integer size;

    @ApiModelProperty(value = "参数")
    private T param;
}
