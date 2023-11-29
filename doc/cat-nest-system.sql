-- auto-generated definition
create schema `cat-nest-system` collate utf8mb4_0900_ai_ci;

use
`cat-nest-system`;

create table cat_nest_record
(
    nest_id       int auto_increment
        primary key,
    nest_name     varchar(20)                    not null comment '猫窝名字',
    nest_desc     varchar(50) null comment '猫窝描述',
    nest_type     varchar(2) default '03' null comment '猫窝类型 0聊天 1文件 03聊天+文件',
    nest_sts      int        default 0           not null comment '猫窝状态 默认0',
    lock_status   bit        default 0           not null comment '锁状态',
    lock_password varchar(50) comment '锁密码',
    create_use_id int                            not null comment '创建人',
    create_dt     datetime   default (curdate()) not null comment '创建时间',
    update_dt     datetime null comment '更新时间'
);


create table cn_dict
(
    id          int auto_increment comment '主键'
        primary key,
    dic_key     varchar(20) null comment '字典key',
    dic_desc    varchar(20) null comment '字典内容',
    enable      bit null comment '启用状态',
    create_dt   datetime null comment '创建时间',
    create_user varchar(20) null comment '创建人'
) comment '系统字典表';






