package com.ml.bean.anime.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动漫 - Vo
 *
 * @author liangzhong
 * @date 2019-01-14 22:28
 */
@Data
@ApiModel("动漫Vo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimeVo implements Serializable {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
