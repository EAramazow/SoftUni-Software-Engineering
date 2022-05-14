CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR (30),
`password` VARCHAR (26),
`profile_picture` LONGBLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (`id`, `username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
VALUES (1, 'emil_emil', 'asdasd', 100, 00-05-25, true),
 (2, 'emil_emil2', 'asdasdaasd', '100', 00-05-26, true),
 (3, 'emil_emil3', 'asd123asd', '100', 00-05-27, true),
 (4, 'emil_emil4', 'as123dasd', '100', 00-05-28, true),
 (5, 'emil_emil5', 'asdas###d', '100', 00-05-29, true);