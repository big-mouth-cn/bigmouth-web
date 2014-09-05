CREATE SEQUENCE SEQ_WEB_ADMIN
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999999999
  START 1
  CACHE 1;

CREATE TABLE TBL_WEB_ADMIN (
	id NUMERIC(19, 0) not null default nextval('SEQ_WEB_ADMIN'),
	login_name VARCHAR(128) not null,
	password VARCHAR(32) not null,
	name VARCHAR(32) not null,
	create_user VARCHAR(128) not null,
	create_time TIMESTAMP WITHOUT TIME ZONE default now(),
	modify_user VARCHAR(128),
	modify_time TIMESTAMP WITHOUT TIME ZONE,
	CONSTRAINT WEB_ADMIN_KEY PRIMARY KEY (id),
	CONSTRAINT WEB_ADMIN_LOGIN_NAME_UNIQUE UNIQUE (login_name)
);
COMMENT ON TABLE TBL_WEB_ADMIN IS '管理员信息表';

INSERT INTO TBL_WEB_ADMIN(login_name, password, name, create_user, create_time)
VALUES ('allen', '2b5e7a8239f884dcd155d94b64d1b3cc', '胡大嘴', 'SYSTEM', now());


CREATE SEQUENCE SEQ_WEB_TAG
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999999999
  START 1
  CACHE 1;
  
CREATE TABLE TBL_WEB_TAG (
	id NUMERIC(19, 0) not null default nextval('SEQ_WEB_TAG'),
	name VARCHAR(128) not null,
	create_user VARCHAR(128) not null,
	create_time TIMESTAMP WITHOUT TIME ZONE default now(),
	modify_user VARCHAR(128),
	modify_time TIMESTAMP WITHOUT TIME ZONE,
	CONSTRAINT WEB_TAG_KEY PRIMARY KEY (id),
	CONSTRAINT WEB_TAG_NAME_UNIQUE UNIQUE (name)
);
COMMENT ON TABLE TBL_WEB_TAG IS 'Tag标签;';

CREATE SEQUENCE SEQ_WEB_NOTE
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999999999
  START 1
  CACHE 1;
  
CREATE TABLE TBL_WEB_NOTE (
	id NUMERIC(19, 0) not null default nextval('SEQ_WEB_NOTE'),
	name VARCHAR(512),
	tags VARCHAR(1024) not null,
	content TEXT not null,
	create_user VARCHAR(128) not null,
	create_time TIMESTAMP WITHOUT TIME ZONE default now(),
	modify_user VARCHAR(128),
	modify_time TIMESTAMP WITHOUT TIME ZONE,
	deleted NUMERIC(1, 0) not null default 0,
	CONSTRAINT WEB_NOTE_KEY PRIMARY KEY (id)
);
COMMENT ON TABLE TBL_WEB_NOTE IS '日志; 文章; 说说;';

CREATE SEQUENCE SEQ_WEB_PHOTO
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999999999
  START 1
  CACHE 1;
  
CREATE TABLE TBL_WEB_PHOTO (
	id NUMERIC(19, 0) not null default nextval('SEQ_WEB_PHOTO'),
	name VARCHAR(512),
	tags VARCHAR(1024) not null,
	relative VARCHAR(256) not null,
	absolute VARCHAR(256) not null,
	description VARCHAR(1024),
	create_user VARCHAR(128) not null,
	create_time TIMESTAMP WITHOUT TIME ZONE default now(),
	modify_user VARCHAR(128),
	modify_time TIMESTAMP WITHOUT TIME ZONE,
	deleted NUMERIC(1, 0) not null default 0,
	CONSTRAINT WEB_PHOTO_KEY PRIMARY KEY (id)
);
COMMENT ON TABLE TBL_WEB_PHOTO IS '相片; ';
