CREATE TABLE `h_goods` (
`goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`goods_name` varchar(50) NULL COMMENT '物品名称',
`goods_type` int(5) NULL COMMENT '物品类型',
`create_time` datetime NULL COMMENT '创建时间',
`creator` int(11) NULL COMMENT '创建人',
`modify_time` datetime NULL COMMENT '修改时间',
`is_valid` int(1) NULL COMMENT '是否有效',
`modifier` int(11) NULL COMMENT '修改者',
PRIMARY KEY (`goods_id`) 
)
COMMENT='物品表';

CREATE TABLE `h_goods_stock` (
`goods_stock_id` int(11) NOT NULL AUTO_INCREMENT,
`goods_id` int  NULL COMMENT '物品id',
`qty` decimal(10,2) NULL COMMENT '数量(原子)',
PRIMARY KEY (`goods_stock_id`) 
)
COMMENT='库存表';

CREATE TABLE `h_stock_flow` (
`stock_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`goods_id` int(11) NULL COMMENT '物品id',
`room_id` int(11) NULL COMMENT '厅号id',
`qty` decimal(10,2) NULL COMMENT '进出数量',
`goods_unit_id` int(11) NULL COMMENT '录入库存时的单位',
`atomic_qty` decimal(10,2) NULL COMMENT '原子数量',
`create_time` datetime NULL COMMENT '操作时间',
`creator` int(11) NULL COMMENT '操作人',
`modify_time` datetime NULL,
`modifier` int(11) NULL,
PRIMARY KEY (`stock_flow_id`) 
)
COMMENT='库存流动记录表';

CREATE TABLE `h_room` (
`room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注解',
`room_name` varchar(50) NULL COMMENT '厅名字',
`seating_capacity` int(11) NULL COMMENT '最大容纳人数',
`custodian` int NULL COMMENT '厅管理人',
`create_time` datetime NULL COMMENT '创建时间',
`modify_time` datetime NULL COMMENT '更新时间',
`creator` int(11) NULL COMMENT '创建人',
`modifier` int(11) NULL COMMENT '修改者',
`is_valid` int(1) NULL COMMENT '是否有效',
PRIMARY KEY (`room_id`) 
)
COMMENT='厅房表';

CREATE TABLE `h_goods_unit` (
`goods_unit_id` int(11) NOT NULL AUTO_INCREMENT,
`goods_id` int(11) NULL COMMENT '物品Id',
`unit` varchar(50) NULL COMMENT '单位',
`conversion_rate` int(11) NULL COMMENT '换算率 {箱 x 换算率 = 瓶（标准单位）}',
`unit_price` decimal(10,2) NULL COMMENT '该单位下的 价格',
`is_atomic` int(1) NULL COMMENT '是否原子单位',
`create_time` datetime NULL,
`modify_time` datetime NULL,
`creator` int(11) NULL,
`modifier` int(11) NULL,
`is_valid` int(1) NULL COMMENT '是否有效',
PRIMARY KEY (`goods_unit_id`) 
)
COMMENT='物品--单位表  一个物品可以有多个单位';

