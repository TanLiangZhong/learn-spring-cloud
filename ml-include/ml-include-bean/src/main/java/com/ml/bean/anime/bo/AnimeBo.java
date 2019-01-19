package com.ml.bean.anime.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 动漫 - Bo
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Data
@ApiModel("动漫Bo")
public class AnimeBo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
