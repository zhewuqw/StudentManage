DROP DATABASE  IF EXISTS  db_sm;
create DATABASE db_sm character set utf8;
use db_sm;



DROP TABLE IF EXISTS t_students;
CREATE TABLE t_students(
		id int primary key auto_increment, 
		name varchar(40), 
        email varchar(40), 
		phone varchar(40), 
		sex varchar(20), 
		age int,
		address varchar(255) 
);

INSERT into t_students values(1,'James','lbj@nba.com','18800006666','mail',31,'Cleveland');
INSERT into t_students values(2,'Kobe','kobe@nba.com','18800008888','mail',36,'Los Angeles');
INSERT into t_students values(3,'Vanessa','vanessa@gmail.com','15800006688','femail',33,'Los Angeles');
INSERT into t_students values(4,'Kurry','kurry@nba.com','11900006688','mail',28,'The golden state');










