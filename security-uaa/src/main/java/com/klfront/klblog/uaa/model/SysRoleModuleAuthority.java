package com.klfront.klblog.uaa.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRoleModuleAuthority implements Serializable {
    /**
     * 角色功能id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer sysRoleId;

    /**
     * 模块id
     */
    private Integer sysModuleId;

    /**
     * 操作权限
     */
    private String function;

    /**
     * 可用状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 模块name
     */
    private String sysModuleName;

    /**
     * 模块code
     */
    private String sysModuleCode;

    private static final long serialVersionUID = 1L;
}