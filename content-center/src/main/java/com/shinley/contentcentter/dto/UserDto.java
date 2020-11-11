package com.shinley.contentcentter.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private Integer id;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像
     */
    private String avatrUrl;

    /**
     * 积分
     */
    private Integer bonus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
