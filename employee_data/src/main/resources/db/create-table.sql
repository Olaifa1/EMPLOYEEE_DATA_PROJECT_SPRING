use employee_db;
create table `employee`(
	employee_id INT(11) not null auto_increment,
	`firstname` varchar(45) not null,
	`lastname` varchar(45) not null,
	`date_of_birth` date default null,
	`email` varchar(45) not null,
	`phonenumber` varchar(45) not null,
	
	
	
	primary key(`employee_id`)
	
)Engine=InnoDB;