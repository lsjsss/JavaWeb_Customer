CREATE TABLE `tuser`(
		`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
		`loginName` varchar(20) DEFAULT NULL COMMENT '登录名称',
		`realName` varchar(20) DEFAULT NULL COMMENT '真实姓名',
		`password` varchar(50) DEFAULT NULL COMMENT '密码',
		`roleId` int(11) DEFAULT NULL COMMENT '角色编号',
		PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;