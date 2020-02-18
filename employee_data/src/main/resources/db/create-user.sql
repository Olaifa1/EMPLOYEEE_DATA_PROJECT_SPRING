create user 'employee_user'@'localhost' identified by 'employee123';

grant all privileges on employee_db.* to 'employee_user'@'localhost';

flush privileges;

create database employee_db;