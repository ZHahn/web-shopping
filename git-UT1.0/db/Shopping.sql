create table user_main(
	id int not null,
	name varchar(30) not null,
	email varchar(50) not null,
	nick_name varchar(30) not null,
	role int not null,
	primary key(id),
	unique(name),
	unique(email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_detail(
	id int not null,
	password varchar(20) not null,
	phone_number varchar(20) not null,
	sex int not null,
	birthday varchar(20) not null,
	post_number varchar(10) not null,
	address varchar(50) not null,
	register_time varchar(20) not null,
	primary key(id),
	foreign key(id) references user_main(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table products(
	id int not null,
	name varchar(50) not null,
	description varchar(1000) not null,
	key_word varchar(1000) not null,
	price int not null,
	counts int not null,
	type int not null,
	primary key(id),
	unique(name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table shopping_car(
	user_id int not null,
	product_id int not null,
	product_price int not null,
	counts int not null,
	primary key (user_id,product_id),
	foreign key (user_id) references user_main(id),
	foreign key (product_id) references products(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table shopping_record(
	user_id int not null,
	product_id int not null,
	time varchar(20) not null,
	order_status int not null,
	product_price int not null,
	counts int not null,
	primary key (user_id,product_id,time),
	foreign key (user_id) references user_main(id),
	foreign key (product_id) references products(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table evaluation(
	user_id int not null,
	product_id int not null,
	time varchar(20) not null,
	content varchar(1000) not null,
	primary key (user_id,product_id,time),
	foreign key (user_id) references user_main(id),
	foreign key (product_id) references products(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

