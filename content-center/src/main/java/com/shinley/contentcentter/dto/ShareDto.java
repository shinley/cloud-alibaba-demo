package com.shinley.contentcentter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShareDto {
    private Integer id;

    /**
     * 发布人Id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否原创：0 否 1 是
     */
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
    private Integer buyCount;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 是否显示 0 否 1 是
     */
    private Byte showFlag;

    /**
     * 审核状态 NOT_YET 待审核 PASSED 审核通过
     */
    private String auditStatus;

    /**
     * 审核不通过的原因
     */
    private String reson;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
