package com.ysh.Pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty(value = "id", hidden = true)
    private int id;
   // @Pattern(regexp = "^[-_a-zA-Z0-9]{2,16}$",message = "用户名格式不正确")
    @ApiModelProperty("用户名")
    private String username;
    // 密码至少包含 数字和英文，长度6-20
   // @Pattern(regexp="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,20}$",message = "密码不合要求")
    @ApiModelProperty("密码")
    private String password;
    //private String tempPassword;
    @ApiModelProperty(hidden = true)
    private int statu;
    @ApiModelProperty( hidden = true)
    private List<String> prem;

}
