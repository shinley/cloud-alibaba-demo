CREATE DATABASE `content_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
use content_center;

create table if not exists `notice` (
    `id` int not null auto_increment primary key,
    `content` varchar(255) not null default '' comment '内容',
    `show_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否显示0 否  1 是',
    `create_time` datetime not null  default current_timestamp comment '创建时间'
)comment '公告表';

create table if not exists `share` (
    id int not null auto_increment primary key ,
    user_id int not null default 0 comment '发布人Id',
    title varchar(80) not null default '' comment '标题',
    is_original tinyint(1) not null default 0 comment '是否原创：0 否 1 是 ',
    author varchar(45) not null default '' comment '作者',
    cover varchar(256) not null default '' comment '封面',
    summary varchar(256) not null default '' comment '概要信息',
    price int not null  default 0 comment '价格（需要的积分）',
    buy_count int not null default 0 comment '下载数',
    download_url varchar(256) not null default '' comment '下载地址',
    show_flag tinyint not null  default 0 comment '是否显示 0 否 1 是',
    audit_status varchar(10) not null default '' comment '审核状态 NOT_YET 待审核 PASSED 审核通过',
    reson varchar(200) not null  default '' comment '审核不通过的原因',
    create_time datetime not null default current_timestamp comment '创建时间',
    update_time datetime not null default current_timestamp on update current_timestamp comment '更新时间'
);


INSERT INTO content_center.share (id, user_id, title, is_original, author, cover, summary, price, buy_count, download_url, show_flag, audit_status, reson, create_time, update_time) VALUES (1, 1, 'spring cloud 与 Docker微服务实战', 0, '小目', 'xxx', '', 0, 1, '', 0, '', '', '2020-11-09 18:44:49', '2020-11-11 09:00:46');
INSERT INTO content_center.share (id, user_id, title, is_original, author, cover, summary, price, buy_count, download_url, show_flag, audit_status, reson, create_time, update_time) VALUES (2, 1, 'Spring cloud alibaba小程序实战', 0, '中目', 'xxx', '', 0, 1, '', 0, '', '', '2020-11-09 18:47:07', '2020-11-11 09:00:46');
INSERT INTO content_center.share (id, user_id, title, is_original, author, cover, summary, price, buy_count, download_url, show_flag, audit_status, reson, create_time, update_time) VALUES (3, 1, 'kubernetes实战', 0, '大目', 'xxx', '', 0, 1, '', 0, '', '', '2020-11-09 18:50:18', '2020-11-11 09:00:33');


create table if not exists `mid_user_share` (
    id int not null auto_increment primary key ,
    share_id int not null default 0,
    user_id int not null default 0
) comment '用户-分享中间表[描述用户购买的分享]';

CREATE DATABASE `user_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ ;
use user_center;

create table `user` (
    id int not null auto_increment primary key ,
    wx_id varchar(54) not null default '' comment '微信id',
    wx_nickname varchar(64) not null default '' comment '微信昵称',
    roles varchar(100) not null default '' comment '角色',
    avatr_url varchar(255) not null default '' comment '头像',
    bonus int not null default 0 comment '积分',
    create_time datetime not null default current_timestamp comment '创建时间',
    update_time datetime not null default current_timestamp on update current_timestamp comment '修改时间'
);

INSERT INTO user_center.user (id, wx_id, wx_nickname, roles, avatr_url, bonus, create_time, update_time) VALUES (1, 'sfaasf', '大目', 'admin', 'xxx', 100, '2020-11-09 18:23:56', '2020-11-10 09:18:27');
INSERT INTO user_center.user (id, wx_id, wx_nickname, roles, avatr_url, bonus, create_time, update_time) VALUES (2, 'ffdasf', '大目他爸', 'user', 'xxx', 0, '2020-11-10 09:13:57', '2020-11-10 09:18:27');

create table bonus_event_log (
    id int not null auto_increment primary key,
    user_id int not null default 0 comment 'user.id',
    value int not null  default 0 comment '积分的值',
    event varchar(20) not null default 0 comment '发生的事件',
    description varchar(100) not null default '' comment '描述',
    create_time datetime not null default current_timestamp comment '创建时间'
) comment '积分变更记录表';