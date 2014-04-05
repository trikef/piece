DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
	id SERIAL,
	email VARCHAR(200),
	name VARCHAR(50) UNIQUE NOT NULL,
	pass VARCHAR(200),
	sex CHAR(1),
	birth DATE,
	img VARCHAR(100),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role(
	id SERIAL,
	name TEXT NOT NULL,
	description TEXT NOT NULL,
	mode CHAR(3) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS status;
CREATE TABLE status(
	id SERIAL,
	description TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS project;
CREATE TABLE project(
	id SERIAL,
	user_id INTEGER NOT NULL,
	title TEXT NOT NULL,
	description TEXT NOT NULL,
	goal TEXT NOT NULL,
	img VARCHAR(100),
	status_id INTEGER DEFAULT 1,
	target_date DATE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS project_role;
CREATE TABLE project_role(
	id SERIAL,
	project_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS piece;
CREATE TABLE piece(
	id SERIAL,
	project_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	title TEXT NOT NULL,
	description TEXT NOT NULL,
	goal TEXT NOT NULL,
	skill TEXT,
	status_id INTEGER DEFAULT 1,
	priority INTEGER DEFAULT 100,
	img VARCHAR(100),
	url VARCHAR(255),
	target_date TIMESTAMP,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS piece_net;
CREATE TABLE piece_net(
	id SERIAL,
	project_id INTEGER NOT NULL,
	parent_id INTEGER NOT NULL,
	child_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS piece_tag;
CREATE TABLE piece_tag(
	id SERIAL,
	piece_id INTEGER NOT NULL,
	tag_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS tag;
CREATE TABLE tag(
	id SERIAL,
	name VARCHAR(100) NOT NULL,
	description TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS tag_net;
CREATE TABLE tag_net(
	id SERIAL,
	parent_id INTEGER NOT NULL,
	child_id INTEGER NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS chat;
CREATE TABLE chat(
	id SERIAL,
	project_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	text TEXT NOT NULL,
	priority INTEGER,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product(
	id SERIAL,
	piece_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	name VARCHAR(255),
	status INTEGER DEFAULT 1,
	star DOUBLE PRECISION,
	star_count INTEGER,
	type_id INTEGER DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS product_type;
CREATE TABLE product_type(
	id SERIAL,
	name VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS product_text;
CREATE TABLE product_text(
	text_id SERIAL,
	product_id INTEGER NOT NULL,
	data TEXT,
	comment TEXT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	PRIMARY KEY(text_id)
);

DROP TABLE IF EXISTS product_chat;
CREATE TABLE product_chat(
	id SERIAL,
	product_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	text TEXT NOT NULL,
	star INTEGER,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);