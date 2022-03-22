package com.klfront.klblog.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@ApiModel(value = "cn-gxhunter-supplydemand-common-entity-User")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 用户名(登录账号)
     */
    @ApiModelProperty(value = "用户名(登录账号)")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 名称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 微信关联的手机号
     */
    @ApiModelProperty(value = "微信关联的手机号")
    private String phone;

    /**
     * 微信授权open_id。如果开发者拥有多个移动应用、网站应用、和公众帐号（包括小程序），则存在多个openId。
     */
    @ApiModelProperty(value = "微信授权open_id。如果开发者拥有多个移动应用、网站应用、和公众帐号（包括小程序），则存在多个openId。")
    private String wxOpenId;

    /**
     * 微信授权unionid。可通过 UnionID 来区分微信用户的唯一性。
     */
    @ApiModelProperty(value = "微信授权unionid。可通过 UnionID 来区分微信用户的唯一性。")
    private String wxUnionId;

    /**
     * 微信用户昵称
     */
    @ApiModelProperty(value = "微信用户昵称")
    private String wxNickname;

    /**
     * 微信用户头像地址
     */
    @ApiModelProperty(value = "微信用户头像地址")
    private String wxAvatarUrl;

    /**
     * 逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    private static final long serialVersionUID = 1L;
}