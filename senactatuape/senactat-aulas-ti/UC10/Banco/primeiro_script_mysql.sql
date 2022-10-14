/**
* Agenda de Contatos
*@author Allan Gomes
*/

-- Comando para verificar os bancos criados 
show databases;

-- Comando para criar um novo banco de dados
create database agenda;

-- Comando para selecionar um banco de dados
use agenda;



-- Comando Usado para excluir um banco de dados
drop database nome_do_banco;

-- Comando Usado para criar uma tabela
-- int (tipo de dados: números inteiros)
-- primary key (chave primária - identificador)
-- auto increment (numeração automatica)
-- varchar (50) (tipo de dados string - 50 caracteres)
-- not null (campo obrigatório)

create table contatos(
      id int primary key auto_increment,
      nome varchar(50) not null,
      fone varchar(15) not null,
      email varchar(50)
      );

-- Verificar tabela do banco de dados      
show tables;

-- Descrever/Mostrar a Tabela
describe contatos;

-- Aula 3

-- O Comando a abaixo altera o nome do campo(coluna) da tabela
alter table contatos change nome contato varchar(50) not null;

-- O comando abaixo adiciona uma coluna a tabela
alter table contatos add column obs varchar(250);

-- O comando abaixo adiciona uma coluna a tabela em um local especifico
alter table contatos add column fone2 varchar(15) after fone; 

-- O comando abaixo modifica os atributos de um campo da tabela
alter table contatos modify column fone varchar(20);

-- O comando abaixo exclui uma coluna da tabela
alter table contatos drop column obs;

-- O comando abaixo exclui a tabela e tudo que tem nela
drop table contatos;

/************ CRUD ************/
-- CRUD Create (insert)
insert into contatos (nome,fone,email)
values ('Allan Gomes','99999-1234','allan@outlook.com');
insert into contatos (nome,fone,email)
values ('Elon Musk','99999-2345','elon@outlook.com');
insert into contatos (nome,fone,email) 
values ('Erick Jacquin','99999-3456','eric@outlook.com');
insert into contatos (nome,fone,email) 
values ('Eliana Michaelichen','99999-4567','eliana@outlook.com');
insert into contatos (nome,fone,email) 
values ('Eike Batista','99999-5678','eike@outlook.com');
-- CRUD Create (insert) sem email
insert into contatos (nome,fone)
values ('Neymar Junior','99999-6789');
insert into contatos (nome,fone)
values ('Jose','9999-7891');
insert into contatos (nome,fone)
values ('abc','11111-1111');


-- CRUD Read (select)
-- A linha abaixo seleciona todos os registros da tabela (e Mostra)
select * from contatos;
--
-- A linha abaixo cria apelidos aos campos (cabeçalho) da tabela
select id as Código, nome as Contato, fone as Telefone,
email as Email from contatos;
-- A linha abaixo seleciona campos especificos da tabela
select nome,fone from contatos;
-- A linha abaixo ordena os registros da tabela (nome)(A-Z)
select * from contatos order by nome;
-- A linha abaixo ordena os registros da tabela (nome)(Z-A)
select * from contatos order by nome desc;
-- A linha abaixo filtra nomes especificos da tabela
select * from contatos where nome like 'A%';
-- As linhas abaixo selecionam de acordo com um criterio
select * from contatos where nome = 'Allan Gomes';
select * from contatos where id = '2';

-- CRUD Update (Jamais faça sem o Comando "where", e utiliza o ID)
update contatos set nome = 'Allan R. Gomes' where id = '2';
update contatos set email = 'neymar@outlook.com' where id = '7';
-- CRUD Update (Muda Tudo)
update contatos set nome = 'José de Assis',fone = '99999-2123',email = 'jose.assis' where id = 8;

-- CRUD Delete (Usar where,Prestar muita atenção no id)
delete from contatos where id = 9;

