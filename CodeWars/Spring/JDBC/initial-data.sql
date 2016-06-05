/*

create table EMPLOYEE (
  EMPNO BIGSERIAL not NULL ,
  EMPNAME varchar(20),
  DEPARTMENT varchar(20),
  EMAIL varchar(20),
  PHONE varchar(10),
  constraint PK_EMPLOYEE primary key (EMPNO)
);

Insert into EMPLOYEE (EMPNO,EMPNAME,DEPARTMENT,EMAIL,PHONE) values (100,'Chuck Coordinator','Administration','chuck@colorado.edu','3-1111');
Insert into EMPLOYEE (EMPNO,EMPNAME,DEPARTMENT,EMAIL,PHONE) values (101,'Mary Manager','Football','mary@colorado.edu','5-1111');
Insert into EMPLOYEE (EMPNO,EMPNAME,DEPARTMENT,EMAIL,PHONE) values (102,'Sally Supervisor','Planning','sally@colorado.edu','3-2222');
Insert into EMPLOYEE (EMPNO,EMPNAME,DEPARTMENT,EMAIL,PHONE) values (103,'Alan Administrator','Administration','alan@colorado.edu','3-3333');
*/


/*
create table emp.RESOURCETBL (
  RESNO varchar(4),
  RESNAME varchar(15),
  RATE int,
  constraint PK_RESOURCETBL primary key (RESNO)
);

Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R100','attendant',10);
Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R101','police',15);
Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R102','usher',10);
Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R103','nurse',20);
Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R104','janitor',15);
Insert into emp.RESOURCETBL (RESNO,RESNAME,RATE) values ('R105','food service',10);

create table emp.FACILITY(
  FACNO varchar(4),
  FACNAME varchar(20),
  constraint PK_FACILITY primary key (FACNO)
);

Insert into emp.FACILITY (FACNO,FACNAME) values ('F100','Football stadium');
Insert into emp.FACILITY (FACNO,FACNAME) values ('F101','Basketball arena');
Insert into emp.FACILITY (FACNO,FACNAME) values ('F102','Baseball field');
Insert into emp.FACILITY (FACNO,FACNAME) values ('F103','Recreation room');

create table emp.CUSTOMER (
  CUSTNO varchar(4),
  CUSTNAME varchar(20),
  ADDRESS varchar(20),
  INTERNAL varchar(1),
  CONTACT varchar(20),
  PHONE varchar(10),
  CITY varchar(10),
  STATE varchar(2),
  ZIP varchar(10),
  constraint PK_CUSTOMER primary key (CUSTNO)
);

Insert into emp.CUSTOMER (CUSTNO,CUSTNAME,ADDRESS,INTERNAL,CONTACT,PHONE,CITY,STATE,ZIP) values ('C100','Football','Box 352200','Y','Mary Manager','6857100','Boulder','CO','80309');
Insert into emp.CUSTOMER (CUSTNO,CUSTNAME,ADDRESS,INTERNAL,CONTACT,PHONE,CITY,STATE,ZIP) values ('C101','Men''s Basketball','Box 352400','Y','Sally Supervisor','5431700','Boulder','CO','80309');
Insert into emp.CUSTOMER (CUSTNO,CUSTNAME,ADDRESS,INTERNAL,CONTACT,PHONE,CITY,STATE,ZIP) values ('C103','Baseball','Box 352020','Y','Bill Baseball','5431234','Boulder','CO','80309');
Insert into emp.CUSTOMER (CUSTNO,CUSTNAME,ADDRESS,INTERNAL,CONTACT,PHONE,CITY,STATE,ZIP) values ('C104','Women''s Softball','Box 351200','Y','Sue Softball','5434321','Boulder','CO','80309');
Insert into emp.CUSTOMER (CUSTNO,CUSTNAME,ADDRESS,INTERNAL,CONTACT,PHONE,CITY,STATE,ZIP) values ('C105','High School Football','123 AnyStreet','N','Coach Bob','4441234','Louisville','CO','80027');

create table emp.LOCATION (
  LOCNO varchar(4),
  FACNO varchar (4),
  LOCNAME varchar(20),
  constraint PK_LOCATION primary key (LOCNO),
  constraint FK_LOCATION foreign key (FACNO)
  references emp.facility (FACNO)
);

Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L100','F100','Locker room');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L101','F100','Plaza');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L102','F100','Vehicle gate');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L103','F101','Locker room');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L104','F100','Ticket Booth');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L105','F101','Gate');
Insert into emp.LOCATION (LOCNO,FACNO,LOCNAME) values ('L106','F100','Pedestrian gate');
*/

/*
create table emp.EVENTREQUEST(
  EVENTNO int,
  DATEHELD date,
  DATEREQ date,
  CUSTNO varchar(4),
  FACNO varchar(4),
  DATEAUTH date,
  STATUS varchar(20),
  ESTCOST int,
  ESTAUDIENCE int,
  BUDNO varchar (7),
  constraint PK_EVENTREQUEST primary key (EVENTNO),
  constraint FK_EVENTRQCUSTNO foreign key (CUSTNO)
  references emp.CUSTOMER (CUSTNO),
  constraint FK_EVENTRQFACNO foreign key (FACNO)
  references emp.FACILITY (FACNO)
);

Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (100, to_date('25 OCT 2013','DD Mon YYYY'), to_date('06 JUN 2013','DD Mon YYYY'),'C100','F100', to_date('08 JUN 2013','DD Mon YYYY'),'Approved',5000,80000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (101, to_date('26 OCT 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C100','F100',null,'Pending',5000,80000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (103, to_date('21 SEP 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C100','F100', to_date('01 AUG 2013','DD Mon YYYY'),'Approved',5000,80000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (102, to_date('14 SEP 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C100','F100', to_date('31 JUL 2013','DD Mon YYYY'),'Approved',5000,80000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (104, to_date('03 DEC 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C101','F101', to_date('31 JUL 2013','DD Mon YYYY'),'Approved',2000,12000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (105, to_date('05 DEC 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C101','F101', to_date('01 AUG 2013','DD Mon YYYY'),'Approved',2000,10000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (106, to_date('12 DEC 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C101','F101', to_date('31 JUL 2013','DD Mon YYYY'),'Approved',2000,10000,'B1000');
Insert into emp.EVENTREQUEST (EVENTNO,DATEHELD,DATEREQ,CUSTNO,FACNO,DATEAUTH,STATUS,ESTCOST,ESTAUDIENCE,BUDNO) values (107, to_date('23 NOV 2013','DD Mon YYYY'), to_date('28 JUL 2013','DD Mon YYYY'),'C105','F100', to_date('31 JUL 2013','DD Mon YYYY'),'Denied',10000,5000,null);
*/


create table EVENTPLAN(
  PLANNO BIGSERIAL NOT NULL ,
  EVENTNO int,
  WORKDATE date,
  NOTES varchar(30),
  ACTIVITY varchar(10),
  EMPNO int,
  constraint PK_EVENTPLAN primary key (PLANNO),
  constraint FK_EVENTPLANRQ foreign key (EVENTNO)
  references EVENTREQUEST (EVENTNO),
  constraint FK_EVENTPLANEM foreign key (EMPNO)
  references EMPLOYEE (EMPNO)
);

Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (100,100,to_date('25 OCT 2013','DD Mon YYYY'),'Standard operation','Operation',102);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (101,104,to_date('03 DEC 2013','DD Mon YYYY'),'Watch for gate crashers','Operation',100);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (102,105,to_date('05 DEC 2013','DD Mon YYYY'),'Standard operation','Operation',102);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (103,106,to_date('12 DEC 2013','DD Mon YYYY'),'Watch for seat switching','Operation',null);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (104,101,to_date('26 OCT 2013','DD Mon YYYY'),'Standard cleanup','Cleanup',101);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (105,100,to_date('25 OCT 2013','DD Mon YYYY'),'Light cleanup','Cleanup',101);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (199,102,to_date('10 DEC 2013','DD Mon YYYY'),'ABC','Operation',101);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (299,101,to_date('26 OCT 2013','DD Mon YYYY'),null,'Operation',101);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (349,106,to_date('12 DEC 2013','DD Mon YYYY'),null,'Setup',101);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (85,100,to_date('25 OCT 2013','DD Mon YYYY'),'Standard operation','Cleanup',102);
Insert into EVENTPLAN (PLANNO,EVENTNO,WORKDATE,NOTES,ACTIVITY,EMPNO) values (95,101,to_date('26 OCT 2013','DD Mon YYYY'),'Extra security','Cleanup',102);


/*
create table EVENTPLANLINE(
  PLANNO varchar(4),
  LINENO int(1),
  TIMESTART date,
  TIMEEND date,
  NUMBERFLD int(1),
  LOCNO varchar(4),
  RESNO varchar(4),
  constraint PK_EVENTPLLINENO primary key (PLANNO,LINENO),
  constraint FK_EVENTPLLOCNO foreign key (LOCNO)
  references LOCATION (LOCNO),
  constraint FK_EVENTPLRESNO foreign key (RESNO)
  references RESOURCETBL (RESNO),
  constraint FK_PLANNO foreign key (PLANNO)
  references EVENTPLAN (PLANNO)
  ON DELETE CASCADE
);


Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P100',1, str_to_date('25,OCT,13 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P100',2, str_to_date('25,OCT,13 12:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'), 2,'L101','R101');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P100',3, str_to_date('25,OCT,13 7:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,13 16:30:00','%d,%b,%y %H:%i:%s'), 1,'L102','R102');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P100',4, str_to_date('25,OCT,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,13 22:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R102');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P101',1, str_to_date('3,DEC,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,13 20:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P101',2, str_to_date('3,DEC,13 18:30:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,13 19:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P101',3, str_to_date('3,DEC,13 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,13 20:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P102',1, str_to_date('5,DEC,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,13 19:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P102',2, str_to_date('5,DEC,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,13 21:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P102',3, str_to_date('5,DEC,13 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,13 22:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P103',1, str_to_date('12,DEC,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,13 21:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P103',2, str_to_date('12,DEC,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,13 21:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P103',3, str_to_date('12,DEC,13 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,13 22:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P104',1, str_to_date('26,OCT,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('26,OCT,13 22:00:00','%d,%b,%y %H:%i:%s'),4,'L101','R104');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P104',2, str_to_date('26,OCT,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('26,OCT,13 22:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R104');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P105',1, str_to_date('25,OCT,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,13 22:00:00','%d,%b,%y %H:%i:%s'),4,'L101','R104');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P105',2, str_to_date('25,OCT,13 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,13 22:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R104');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P199',1, str_to_date('10,DEC,13 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('10,DEC,13 12:00:00','%d,%b,%y %H:%i:%s'),1,'L100','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P349',1, str_to_date('12,DEC,13 12:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,13 15:30:00','%d,%b,%y %H:%i:%s'),1,'L103','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P85',1,  str_to_date('25,OCT,13 9:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),5,'L100','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P85',2,  str_to_date('25,OCT,13 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),2,'L102','R101');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P85',3, str_to_date('25,OCT,13 10:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,13 15:00:00','%d,%b,%y %H:%i:%s'),3,'L104','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P95',1, str_to_date('26,OCT,13 8:00:00','%d,%b,%y %H:%i:%s'),  str_to_date('26,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P95',2, str_to_date('26,OCT,13 9:00:00','%d,%b,%y %H:%i:%s'),  str_to_date('26,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),4,'L102','R101');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P95',3, str_to_date('26,OCT,13 10:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,13 15:00:00','%d,%b,%y %H:%i:%s'),4,'L106','R100');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P95',4, str_to_date('26,OCT,13 13:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R103');
Insert into EVENTPLANLINE (PLANNO,LINENO,TIMESTART,TIMEEND,NUMBERFLD,LOCNO,RESNO) values ('P95',5, str_to_date('26,OCT,13 13:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,13 17:00:00','%d,%b,%y %H:%i:%s'),2,'L101','R104');



























/*

DROP TABLE Enrollment;
DROP TABLE offering;
DROP TABLE Student;
DROP TABLE Course;
DROP TABLE Faculty;

-------------------- Student --------------------------------

CREATE TABLE Student (
  stdNo char(11) not null,
  stdFirstName varchar(30) not null,
  stdLastName varchar(30) not null,
  stdCity varchar(30) not null,
  stdState char(2) not null,
  stdZip char(10) not null,
  stdMajor char(6),
  stdClass char(2),
  stdGPA decimal(3,2),
  CONSTRAINT StudentPk PRIMARY KEY (StdNo) );


-------------------- Course --------------------------------

CREATE TABLE Course(
  CourseNo	char(6) not null,
  crsDesc		varchar(50) not null,
  CrsUnits	integer,
  CONSTRAINT CoursePK PRIMARY KEY (CourseNo) );


-------------------- Faculty --------------------------------

CREATE TABLE Faculty(
  FacNo			char(11) not null,
  FacFirstName	varchar(30) not null,
  FacLastName		varchar(30) not null,
  FacCity			varchar(30) not null,
  FacState		char(2) not null,
  FacZipCode		char(10) not null,
  FacRank			char(4),
  FacHireDate		date,
  FacSalary		decimal(10,2),
  FacSupervisor	char(11),
  FacDept			char(6),
  CONSTRAINT FacultyPK PRIMARY KEY (FacNo) );


-------------------- Offering --------------------------------

CREATE TABLE Offering(
  OfferNo INTEGER not null,
  CourseNo char(6) not null,
  OffTerm char(6) not null,
  OffYear INTEGER not null,
  OffLocation varchar(30),
  OffTime varchar(10),
  FacNo char(11),
  OffDays char(4),
  CONSTRAINT OfferingPK PRIMARY KEY (OfferNo),
  CONSTRAINT CourseFK FOREIGN KEY (CourseNo) REFERENCES Course (CourseNo),
  CONSTRAINT FacultyFK FOREIGN KEY (FacNo) REFERENCES Faculty (FacNo) );


-------------------- Enrollment --------------------------------

CREATE TABLE Enrollment (
  OfferNo		INTEGER not null,
  StdNo		char(11) not null,
  EnrGrade	decimal(3,2),
  CONSTRAINT EnrollmentPK PRIMARY KEY (OfferNo, StdNo),
  CONSTRAINT OfferingFK FOREIGN KEY (OfferNo) REFERENCES Offering (OfferNo)
  ON DELETE CASCADE,
  CONSTRAINT StudentFK FOREIGN KEY (StdNo) REFERENCES Student (StdNo) ON DELETE CASCADE );












INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('124-56-7890','BOB','NORBERT','BOTHELL','WA','FIN','JR',2.70,'98011-2121');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('123-45-6789','JAMES','GRIN','WASHINGTON','WA','PHYS','SR',4.50,'98123-1141');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('234-56-7890','CANDY','KENDALL','TACOMA','WA','ACCT','JR',3.50,'99042-3321');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('345-67-8901','WALLY','KENDALL','SEATTLE','WA','IS','SR',2.80,'98123-1141');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('456-78-9012','JOE','ESTRADA','SEATTLE','WA','FIN','SR',3.20,'98121-2333');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('567-89-0123','MARIAH','DODGE','SEATTLE','WA','IS','JR',3.60,'98114-0021');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('678-90-1234','TESS','DODGE','REDMOND','WA','ACCT','SO',3.30,'98116-2344');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('789-01-2345','ROBERTO','MORALES','SEATTLE','WA','FIN','JR',2.50,'98121-2212');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('876-54-3210','CRISTOPHER','COLAN','SEATTLE','WA','IS','SR',4.00,'98114-1332');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('890-12-3456','LUKE','BRAZZI','SEATTLE','WA','IS','SR',2.20,'98116-0021');

INSERT INTO Student
(stdNo, stdFirstName, stdLastName, stdCity,
 stdState, stdMajor, stdClass, stdGPA, stdZip)
VALUES ('901-23-4567','WILLIAM','PILGRIM','BOTHELL','WA','IS','SO',3.80,'98113-1885');





INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ( 'FIN300','FUNDAMENTALS OF FINANCE',4);

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ( 'FIN450','PRINCIPLES OF INVESTMENTS',4);

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ( 'FIN480','CORPORATE FINANCE',4);

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ('IS320','FUNDAMENTALS OF BUSINESS PROGRAMMING',4 );

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ( 'IS460','SYSTEMS ANALYSIS',4);

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ( 'IS470','BUSINESS DATA COMMUNICATIONS',4);

INSERT INTO Course
(CourseNo, crsDesc, CrsUnits)
VALUES ('IS480','FUNDAMENTALS OF DATABASE MANAGEMENT',4 );





INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('543-21-0987','VICTORIA','EMMANUEL','BOTHELL','WA','MS','PROF',120000.0,'','2001-04-15','98011-2242');

INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('765-43-2109','NICKI','MACON','BELLEVUE','WA','FIN','PROF',65000.00,'','2002-04-11','98015-9945');

INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('654-32-1098','LEONARD','FIBON','SEATTLE','WA','MS','ASSC',70000.00,'543-21-0987','1999-05-01','98121-0094');

INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('098-76-5432','LEONARD','VINCE','SEATTLE','WA','MS','ASST',35000.00,'654-32-1098','2000-04-10','98111-9921');

INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('876-54-3210','CRISTOPHER','COLAN','SEATTLE','WA','MS','ASST',40000.00,'654-32-1098','2004-03-01','98114-1332');

INSERT INTO Faculty
(FacNo, FacFirstName, FacLastName, FacCity, FacState,
 FacDept, FacRank, FacSalary, FacSupervisor, FacHireDate, FacZipCode)
VALUES ('987-65-4321','JULIA','MILLS','SEATTLE','WA','FIN','ASSC',75000.00,'765-43-2109','2005-03-15','98114-9954');






INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (1111,'IS320','SUMMER',2013,'BLM302','10:30:00',NULL,'MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (1234,'IS320','FALL',2012,'BLM302','10:30:00','098-76-5432','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (2222,'IS460','SUMMER',2012,'BLM412','13:30:00',NULL,'TTH');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (3333,'IS320','SPRING',2013,'BLM214','08:30:00','098-76-5432','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (4321,'IS320','FALL',2012,'BLM214','15:30:00','098-76-5432','TTH');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (4444,'IS320','WINTER',2013,'BLM302','15:30:00','543-21-0987','TTH');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (5555,'FIN300','WINTER',2012,'BLM207','08:30:00','765-43-2109','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (5678,'IS480','WINTER',2013,'BLM302','10:30:00','987-65-4321','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (5679,'IS480','SPRING',2013,'BLM412','15:30:00','876-54-3210','TTH');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (6666,'FIN450','WINTER',2013,'BLM212','10:30:00','987-65-4321','TTH');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (7777,'FIN480','SPRING',2013,'BLM305','13:30:00','765-43-2109','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (8888,'IS320','SUMMER',2013,'BLM405','13:30:00','654-32-1098','MW');

INSERT INTO Offering
(OfferNo, CourseNo, OffTerm, OffYear, OffLocation, OffTime, FacNo, OffDays)
VALUES (9876,'IS460','SPRING',2013,'BLM307','13:30:00','654-32-1098','TTH');






INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'123-45-6789',3.30);


INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'234-56-7890',3.50);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'345-67-8901',3.20);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'456-78-9012',3.10);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'567-89-0123',3.80);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(1234,'678-90-1234',3.40);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'123-45-6789',3.50);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'124-56-7890',3.20);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'789-01-2345',3.50);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'876-54-3210',3.10);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'890-12-3456',3.40);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(4321,'901-23-4567',3.10);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5555,'123-45-6789',3.20);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5555,'124-56-7890',2.70);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5678,'123-45-6789',3.20);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5678,'234-56-7890',2.80);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5678,'345-67-8901',3.30);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5678,'456-78-9012',3.40);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5678,'567-89-0123',2.60);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'123-45-6789',2.00);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'124-56-7890',3.70);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'678-90-1234',3.30);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'789-01-2345',3.80);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'890-12-3456',2.9);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(5679,'901-23-4567',3.1);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(6666,'234-56-7890',3.1);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(6666,'567-89-0123',3.6);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(7777,'876-54-3210',3.4);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(7777,'890-12-3456',3.7);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(7777,'901-23-4567',3.4);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'124-56-7890',3.5);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'234-56-7890',3.2);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'345-67-8901',3.2);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'456-78-9012',3.4);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'567-89-0123',2.6);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'678-90-1234',3.3);

INSERT INTO Enrollment
(OfferNO, StdNo, EnrGrade)
VALUES(9876,'901-23-4567',4);
