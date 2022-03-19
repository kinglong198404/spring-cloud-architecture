package com.klfront.klblog.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 知识库
 */
@ApiModel(value = "com-klfront-klblog-common-entity-KnowledgeBase")
@Data
public class KnowledgeBase implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String tag;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String author;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "")
    private Date createTime;

    @ApiModelProperty(value = "")
    private Date editTime;

    /**
     * 是否已删除。0 未删除，1 已删除。
     */
    @ApiModelProperty(value = "是否已删除。0 未删除，1 已删除。")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;
}