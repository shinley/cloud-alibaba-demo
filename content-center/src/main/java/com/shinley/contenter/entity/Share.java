package com.shinley.contenter.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "share")
public class Share {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 发布人Id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否原创：0 否 1 是 
     */
    @Column(name = "is_original")
    private Boolean isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载数
     */
    @Column(name = "buy_count")
    private Integer buyCount;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    private String downloadUrl;

    /**
     * 是否显示 0 否 1 是
     */
    @Column(name = "show_flag")
    private Byte showFlag;

    /**
     * 审核状态 NOT_YET 待审核 PASSED 审核通过
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 审核不通过的原因
     */
    private String reson;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}