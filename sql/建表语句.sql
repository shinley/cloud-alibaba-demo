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

create table if not exists `mid_user_share` (
    id int not null auto_increment primary key ,
    share_id int not null default 0,
    user_id int not null default 0
) comment '用户-分享中间表[描述用户购买的分享]';

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

create table bonus_event_log (
    id int not null auto_increment primary key,
    user_id int not null default 0 comment 'user.id',
    value int not null  default 0 comment '积分的值',
    event varchar(20) not null default 0 comment '发生的事件',
    description varchar(100) not null default '' comment '描述',
    create_time datetime not null default current_timestamp comment '创建时间'
) comment '积分变更记录表';