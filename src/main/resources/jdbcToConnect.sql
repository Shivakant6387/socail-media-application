USE `datablock`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
                         `username` varchar(80) NOT NULL,
                         `password` varchar(80) NOT NULL,
                         `enabled` tinyint NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
    ('user','{bcrypt}$2a$12$kDdS5XTf8RFjjXlHwJf0/ev3/E1AAa0lMTCRTzuKeuFDbxdpi0rgO',1),
    ('manager','{bcrypt}$2a$12$Mp2sgCpF4VbYYARbfgaNeuK06SwDxx6CV/jMX.ZyvoYi4agGFFdNq',1),
    ('admin','{bcrypt}$2a$12$Eh3DPf7FtYBMupzAquz/rut98aJmZPC6gloP2rj3gMou64j10Nqva',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
                               `username` varchar(80) NOT NULL,
                               `authority` varchar(80) NOT NULL,
                               UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
    ('user','ROLE_USER'),
    ('manager','ROLE_USER'),
    ('manager','ROLE_MANAGER'),
    ('admin','ROLE_USER'),
    ('admin','ROLE_MANAGER'),
    ('admin','ROLE_ADMIN');

