package com.klfront.klblog.uaa.model;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class SysRole implements Serializable {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色编号
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

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

    private static final long serialVersionUID = 1L;
}