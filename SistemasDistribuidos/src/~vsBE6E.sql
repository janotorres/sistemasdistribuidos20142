--EmailManager

create table EmailUser
(
id int primary key identity not null,
userName varchar(150),
userPassword varchar(10)
)

create table EmailSent
(
id int primary key identity not null,
sender int references EmailUser(id),
dt datetime,
toEmail varchar(150),
messageEmail varchar(max)
)




