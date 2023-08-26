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
    create_use_id int                            not null comment '创建人',
    create_dt     datetime   default (curdate()) not null comment '创建时间',
    update_dt     datetime null comment '更新时间'
);





