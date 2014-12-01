--EmailManager

create table EmailUser
(
id int primary key AUTO_INCREMENT not null,
userName char(150),
userPassword char(10)
)

create table EmailSent
(
id int primary key AUTO_INCREMENT not null,
sender int,
dt datetime,
toEmail char(150),
messageEmail char(max)
)




