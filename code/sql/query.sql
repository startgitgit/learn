SELECT
	* 
FROM
	hr
	LEFT JOIN hr_role ON hr.id = hr_role.hrid
	LEFT JOIN role ON role.id = hr_role.rid 
WHERE
	hr.id = 3 
	
	-- 分析SQL性能,on为打开，默认是OFF的
	SHOW VARIABLES LIKE 'profiling';
	
	
-- SHOW PROFILES显示最近发给服务器的多条语句，条数根据会话变量profiling_history_size定义，默认是15，最大值为100。设为0等价于关闭分析功能。	
SHOW PROFILES;

-- 查看上一条SQL语句的开销信息
SHOW PROFILE;

-- 添加只读锁
LOCK TABLE employee READ 

-- 解锁
UNLOCK TABLES

-- 显示所有锁
SHOW OPEN TABLES

UPDATE employee 
SET NAME = '江南一点雨1' 
WHERE
	employee.id = 1 UNLOCK TABLES