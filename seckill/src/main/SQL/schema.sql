--数据库初始化脚本

--创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
--创建秒杀库存表
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
`end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

--初始化数据
 insert into
 seckill(name, number, start_time, end_time)
 values
     ('1000元秒杀iPhone x', 100, '2019-07-15 00:00:00', '2019-08-16 00:00:00'),
     ('500元秒杀iPad air', 200, '2019-07-15 00:00:00', '2019-08-16 00:00:00'),
     ('800元秒杀小米8', 300, '2019-07-15 00:00:00', '2019-08-16 00:00:00'),
     ('2000元秒杀红米', 400, '2019-07-15 00:00:00', '2019-08-16 00:00:00');

--秒杀成功明细表
--用户登录认证相关信息
create table success_killed(
`seckill_id` bigint NOT NULL COMMENT 'product id',
`user_phone` bigint NOT NULL COMMENT 'phone nummber',
`state` tinyint NOT NULL DEFAULT -1 COMMENT 'state:-1:invalid 0:successful 1:paid 2:sent',
`create_time` timestamp NOT NULL COMMENT 'create time',
primary key(seckill_id, user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seckill success list';

--连接数据库控制台
mysql -uroot -p

