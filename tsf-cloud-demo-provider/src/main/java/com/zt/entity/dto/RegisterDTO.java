package com.zt.entity.dto;

import com.zt.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 封装注册请求
 * @author zt.赵童
 * @since 2019-01-14
 */
@Data
public class RegisterDTO {
    @NotNull(message = "uid不能为空")
    @NotBlank(message = "uid不能为空")
    private String uId;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String uPassword;

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String uName;

    @NotNull(message = "性别不能为空")
    @NotBlank(message = "性别不能为空")
    private String uSex;

    @NotNull(message = "电话号码不能为空")
    @NotBlank(message = "电话号码不能为空")
    private String uPhone;

    /**
     * 转化为User对象
     * @return User实体
     */
    public User toUser() {
        return new User()
                .setUId(this.uId)
                .setUName(this.uName)
                .setUPassword(this.uPassword)
                .setUSex(this.uSex)
                .setUPhone(this.uPhone);
    }
}
