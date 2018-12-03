package com.ml.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liangzhong
 * @version 1.0
 * @date 2018/12/2
 */
@Data
@ApiModel("登陆参数")
public class LoginBo {

    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("密码")
    private String password;


}
