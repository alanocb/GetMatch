insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Alano Baptista','933242627',to_date('2000.01.01','YYYY.MM.DD'),'alanobaptista@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Paulino Muya','933242628',to_date('2001.01.02','YYYY.MM.DD'),'paulino@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Luquenia Galiano','935352702',to_date('2000.02.10','YYYY.MM.DD'),'luqueniagaliano@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Omar Dias','932624244',to_date('2000.06.12','YYYY.MM.DD'),'omardias@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Ivano Neto','937242629',to_date('2003.10.03','YYYY.MM.DD'),'ivanoneto@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Vanilson Zeu','933252630',to_date('2000.04.04','YYYY.MM.DD'),'vanilsonzeu@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Guilherme Galiano','933272628',to_date('2005.09.03','YYYY.MM.DD'),'guilhermegaliano@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Rui Miguel','922328262',to_date('2004.08.03','YYYY.MM.DD'),'ruimiguel@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Ricardo Dias','938272640',to_date('2002.09.07','YYYY.MM.DD'),'ricardodias@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Ricardo Galiano','943272620',to_date('2005.02.06','YYYY.MM.DD'),'ricardogaliano@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Guilherme Lopes','943272645',to_date('2002.09.05','YYYY.MM.DD'),'guilhermelopes@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Dawton Santos','933303028',to_date('1999.09.03','YYYY.MM.DD'),'dawtonsantos@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('David Nzala','925253030',to_date('2006.03.20','YYYY.MM.DD'),'davidnzala@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Luan Nelumba','913272620',to_date('2006.10.09','YYYY.MM.DD'),'luannelumba@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Kiame Pedro','916272628',to_date('2006.11.06','YYYY.MM.DD'),'kiamepedro@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Xiame Nelumba','947272629',to_date('2002.09.08','YYYY.MM.DD'),'xiamenelumba@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Patricio Silva','953272668',to_date('2004.04.09','YYYY.MM.DD'),'patriciosilva@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Adriel Silvestre','967272650',to_date('006.02.05','YYYY.MM.DD'),'adrielsilvestre@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Nicolas Paixao','914327264',to_date('2006.02.17','YYYY.MM.DD'),'nicolaspaixao@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Elias David','923242424',to_date('2006.10.17','YYYY.MM.DD'),'eliasdavid@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Fabio Lemos','912272620',to_date('2006.07.28','YYYY.MM.DD'),'fabiolemos@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Helio Mariel','91827277',to_date('2003.09.14','YYYY.MM.DD'),'heliomariel@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Benvindo Mariel','938303030',to_date('1998.01.18','YYYY.MM.DD'),'benvindo@gmail.com','12345');
insert into users(usr_name, usr_telefone, usr_data_nasc, usr_emaill, usr_senha)values('Fernando Jorge','913202020',to_date('1999.12.27','YYYY.MM.DD'),'fernandojorge@gmail.com','12345');

insert into modalidade_jogo(modalidade_nome, modalidade_tipo, jogador_numero_maximo)values('Futebol','7x7','14');
insert into modalidade_jogo(modalidade_nome, modalidade_tipo, jogador_numero_maximo)values('Futebol','5x5','10');
insert into modalidade_jogo(modalidade_nome, modalidade_tipo, jogador_numero_maximo)values('Basquete','3x3','6');
insert into modalidade_jogo(modalidade_nome, modalidade_tipo, jogador_numero_maximo)values('Basuete','5x5','10');
insert into modalidade_jogo(modalidade_nome, modalidade_tipo, jogador_numero_maximo)values('Padel','2x2','4');


insert into jogo(modalidade_jogo_id, usr_id)values('1','1');
insert into jogo(modalidade_jogo_id, usr_id)values('1','2');
insert into jogo(modalidade_jogo_id, usr_id)values('3','2');
insert into jogo(modalidade_jogo_id, usr_id)values('4','1');
insert into jogo(modalidade_jogo_id, usr_id)values('5','3');

insert into estado_participante_jogo(estado_jogo_nome)values('Confirmado');
insert into estado_participante_jogo(estado_jogo_nome)values('Desistente');

insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Paulino Muya','Futebol','1','2');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Alano Baptista','Futebol','1','1');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Ivano Neto','Futebol','1','5');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Fernando Jorge','Futebol','1','24');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Benvindo Mariel','Futebol','1','23');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Rui Miguel','Futebol','1','8');
insert into participante(part_nome, part_tipo_desporto, jogo_id, usr_id)values('Ricardo Galiano','Futebol','1','10');

insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('2','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('1','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('5','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('24','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('23','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('8','1','1');
insert into participante_jogo(usr_id, jogo_id, estado_participante_jogo_id)values('10','1','1');
 

insert into tipo_campo(estrutura_tipo_campo, pag_tipo_campo)values('Aberto','Publico');
insert into tipo_campo(estrutura_tipo_campo, pag_tipo_campo)values('Fechado','Publico');
insert into tipo_campo(estrutura_tipo_campo, pag_tipo_campo)values('Variado','Publico');

insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone, campo_endereco, longitude, latitude)
values('Campo de basquetebol do Parque das Mamas','Lisboa','1','218540690','Praça Cidade São Salvador, Lisboa, Portugal','-9.115304569727813','38.764870893392064');
insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone, campo_endereco, longitude, latitude)
values('Parque de Jogos 1. º de Maio','Lisboa','3','218453470','Av. Rio de Janeiro, 1700-330 Lisboa','-9.137877831642417','38.75145522012976');
insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone ,campo_endereco, longitude, latitude)
values('Padel Factory Expo','Lisboa','3','91228167','Passeio do Tejo, 1990-281','-9.092789491162804','38.78601416537734');
insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone, campo_endereco, longitude, latitude)
values('LX Indoor Padel','Lisboa','3','927609220','R. Palmares, 2680-159','-9.140123294770648','38.80141104623797');
insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone, campo_endereco , longitude,  latitude)
values('Rackets Pro EUL','Lisboa','3',' 965091010','Azinhaga das Galhardas 18, 1600-209','-9.161276694770649','38.753344816501894');
insert into campo(campo_nome, campo_localizacao, tipo_campo_id, campo_telefone, campo_endereco, longitude, latitude);
values('UrbanSoccer','Lisboa','3',' 965091010','Azinhaga das Galhardas 18, 1600-209','-9.199079050353568','38.73227758864936');

insert into modalidade_campo(campo_id)values('1');
