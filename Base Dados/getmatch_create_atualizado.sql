create table users(
	usr_id serial not null,
	usr_name varchar(30),
	usr_telefone int,
	usr_data_nasc date not null,
	usr_emaill varchar(30),
	usr_senha varchar(30),
	primary key (usr_id)
);

create table modalidade_jogo(
modalidade_jogo_id serial not null,
modalidade_nome varchar(100),
modalidade_tipo varchar(100),
jogador_numero_maximo int,
	primary key(modalidade_jogo_id)

);

Create table jogo(
jogo_id serial not null,
	primary key(jogo_id),
	usr_id int not null,
	modalidade_jogo_id int not null,
	FOREIGN KEY (usr_id) REFERENCES users(usr_id)
	on delete no action on update no action,
	FOREIGN KEY (modalidade_jogo_id) REFERENCES modalidade_jogo(modalidade_jogo_id)
	on delete no action on update no action
);

create table estado_participante_jogo(
estado_participante_jogo_id serial not null,
	   estado_jogo_nome varchar(30),
	primary key(estado_participante_jogo_id)
);

create table participante(
participante_id serial not null,
	part_nome varchar(30),
	part_tipo_desporto varchar(30),
	jogo_id int not null,
	usr_id int not null,
	primary key(participante_id),
	FOREIGN KEY (usr_id) REFERENCES users(usr_id)
	on delete no action on update no action,
	FOREIGN KEY (jogo_id) REFERENCES jogo(jogo_id)
	on delete no action on update no action

);

create table participante_jogo(
	participante_jogo_id serial not null,
	usr_id int not null,
	jogo_id int not null,
	estado_participante_jogo_id int not null,
	primary key(participante_jogo_id),
	FOREIGN KEY (usr_id) REFERENCES users(usr_id)
	on delete no action on update no action,
	FOREIGN KEY (jogo_id) REFERENCES jogo(jogo_id)
	on delete no action on update no action,
	FOREIGN KEY (estado_participante_jogo_id) REFERENCES estado_participante_jogo(estado_participante_jogo_id)
	on delete no action on update no action
);

create table tipo_campo(
tipo_campo_id serial not null,
	estrutura_tipo_campo varchar(100),
	pag_tipo_campo varchar(100),
	primary key(tipo_campo_id)
);


create table campo(
campo_id serial not null,
	campo_nome varchar(40),
	campo_localizacao varchar(255),
	campo_telefone int,
	campo_endereco varchar(500),
	longitude double,
	latitude double, 
	tipo_campo_id int not null,
	primary key(campo_id),
	FOREIGN KEY (tipo_campo_id) REFERENCES tipo_campo(tipo_campo_id)
	on delete no action on update no action

);


create table modalidade_campo(
modalidade_campo_id serial not null,
campo_id int not null,
	primary key(modalidade_campo_id),
	FOREIGN KEY (campo_id) REFERENCES campo(campo_id)
	on delete no action on update no action
);


