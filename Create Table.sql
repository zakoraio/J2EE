CREATE TABLE `useraccessdetails` (
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `accesslevel` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `username` varchar(30) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(6) DEFAULT NULL,
  `apt` varchar(45) DEFAULT NULL,
  `yearattended` int(11) NOT NULL,
  `reviewsgiven` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `useraccessdetails` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `instructor` (
  `instructorid` varchar(20) NOT NULL,
  `instructorname` varchar(150) NOT NULL,
  `deptname` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`instructorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `coursedetails` (
  `courseid` varchar(20) NOT NULL,
  `coursename` varchar(150) NOT NULL,
  `deptname` varchar(150) NOT NULL,
  `level` varchar(3) NOT NULL,
  PRIMARY KEY (`courseid`),
  UNIQUE KEY `courseid_UNIQUE` (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Contains Course Details';


CREATE TABLE `courseofferingdetails` (
  `courseid` varchar(20) NOT NULL,
  `instructorid` varchar(20) NOT NULL,
  `yeartaken` varchar(20) NOT NULL,
  `offeringid` int(11) NOT NULL,
  PRIMARY KEY (`offeringid`),
  KEY `fk_courseid_idx` (`courseid`),
  KEY `fk_instructorid_idx` (`instructorid`),
  CONSTRAINT `fk_courseid` FOREIGN KEY (`courseid`) REFERENCES `coursedetails` (`courseid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructorid` FOREIGN KEY (`instructorid`) REFERENCES `instructor` (`instructorid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `coursestaken` (
  `username` varchar(30) NOT NULL,
  `courseid` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `review` (
  `reviewid` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `type` char(1) NOT NULL,
  `reviewdate` date NOT NULL,
  PRIMARY KEY (`reviewid`),
  KEY `fk_uname_idx` (`username`),
  CONSTRAINT `fk_uname` FOREIGN KEY (`username`) REFERENCES `useraccessdetails` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reviewcourse` (
  `reviewid` int(10) NOT NULL,
  `offeringid` int(11) NOT NULL,
  `reviewcomment` varchar(500) NOT NULL,
  `numberofquiz` int(5) DEFAULT NULL,
  `numberofexams` int(5) DEFAULT NULL,
  `numberofproj` int(5) DEFAULT NULL,
  `workload` int(5) NOT NULL,
  `numberofassignment` int(5) DEFAULT NULL,
  PRIMARY KEY (`reviewid`),
  KEY `fk_offer_idx` (`offeringid`),
  CONSTRAINT `fk_offer_c` FOREIGN KEY (`offeringid`) REFERENCES `courseofferingdetails` (`offeringid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_c` FOREIGN KEY (`reviewid`) REFERENCES `review` (`reviewid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reviewinstructor` (
  `reviewid` int(10) NOT NULL,
  `offeringid` int(11) NOT NULL,
  `reviewcomment` varchar(500) NOT NULL,
  `teachingaptitude` int(5) NOT NULL,
  `subjectcommand` int(5) NOT NULL,
  `interaction` int(5) NOT NULL,
  PRIMARY KEY (`reviewid`),
  KEY `fk_offer_idx` (`offeringid`),
  CONSTRAINT `fk_offer_i` FOREIGN KEY (`offeringid`) REFERENCES `courseofferingdetails` (`offeringid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_i` FOREIGN KEY (`reviewid`) REFERENCES `review` (`reviewid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `question_course` (
  `Question id` varchar(10) NOT NULL,
  `Question` VARCHAR(250) NOT NULL,
  `courseid` varchar(20) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Question id`),
  Foreign key(`username`) references student(`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  Foreign Key(`courseid`) references coursedetails(`courseid`)ON DELETE CASCADE ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `question_instructor` (
  `Question id` varchar(10) NOT NULL,
  `Question` varchar(250) NOT NULL,
  `instructorid` varchar(20) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  Foreign key(`username`) references student(`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  Foreign Key(`instructorid`) references instructor(`instructorid`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`Question id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `answerstable` (
  `question id` VARCHAR(10) NOT NULL,
  `answer id` VARCHAR(10) NOT NULL,
  `Answers` VARCHAR(500) NOT NULL,
  `username` VARCHAR(30) ,
  PRIMARY KEY (`question id`, `answer id`),
  Foreign key(`username`) references student(`username`)ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=utf8;