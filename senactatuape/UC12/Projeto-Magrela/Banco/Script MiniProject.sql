/**
 * Sistema para gestão de Serviços
 *
 * @author Allan Gomes
   @author Igor Oliveira
 * @version 1.2
 */
 
drop database dbmecanica;
create database dbmecanica;
use dbmecanica;

create table tbusuarios(
	iduser int primary key auto_increment,
    usuario varchar(15) not null,
    fone varchar(15),
    login varchar(15) not null unique,
    senha varchar(250) not null,
    perfil varchar(20) not null
);

select * from tbusuarios;

-- login (usuário: admin | senha: admin)
insert into tbusuarios(iduser,usuario,fone,login,senha,perfil)
values(1,'Administrador','1111-1111','admin',md5('admin'),'admin');

insert into tbusuarios(iduser,usuario,login,senha,perfil)
values(2,'Usuario','user',md5('123@senac'),'user');

-- Selecionar todos os clientes
select * from tbusuarios;

-- pesquisa avançada 
select iduser, usuario, fone, login, senha, perfil from tbusuarios where usuario like ('A%');

create table tbclientes(
	idcli int primary key auto_increment,
    npcli varchar(50),
    nomecli varchar(50)unique,
    endcli varchar(50)not null,
    cepcli varchar(10) unique,
    bairrocli varchar(50) not null,
    cidadecli varchar(50),
    ufcli char(2) not null,
    fonecli varchar(15) not null,
    emailcli varchar(50) unique,
    cpfcli varchar(12) unique
);

insert into tbclientes (nomecli,endcli,cepcli,bairrocli,cidadecli,ufcli,fonecli,emailcli,cpfcli) 
values ('Allan','Rua Tal','cep','bairro','cidade','SP','1111-1111','TESTE@teste.com','11111111111');

-- Selecionar todos os clientes
select * from tbclientes;

-- pesquisa avançada 
select idcli, nomecli, endcli, endcli, fonecli, emailcli, cpfcli from tbclientes where nomecli like ('A%');

drop table tbos;
create table tbos(
	os int primary key auto_increment,
    dataent timestamp default current_timestamp,
    datafin date,
    cliente varchar (45) not null,
    telefone varchar (14) not null,
    email varchar (45) not null,
    veiculo varchar(150) not null,
    km varchar(7) not null,
    problema varchar(40) not null,
    situacao varchar(40) not null,
    mecanico varchar(40) not null,
    tprodutos decimal(10,2),
    tservicos decimal(10,2),
    desconto decimal(10,2),
    adiantamento decimal(10,2),
    tpagamento decimal(10,2),
    modop varchar(30),
    idcli int not null,
    foreign key(idcli) references tbclientes(idcli)
);

select * from tbos;

-- relatório 1 (clientes)
select * from tbclientes order by nomecli;

-- relatório 2 (serviços pendentes)
select tbos.os as Ordem_Servico, tbclientes.nomecli as Cliente, date_format(tbos.dataent,'%d/%m/%Y - %H:%i') as Data_Protocolo, 
veiculo as Modelo_Veiculo,
situacao as Situacao
from tbos inner join tbclientes
on tbos.os = tbclientes.idcli
where situacao = 'Servico Pendente';

-- relatório 3 (serviços Concluido)
select tbos.os as Ordem_Servico, tbclientes.nomecli as Cliente, date_format(tbos.dataent,'%d/%m/%Y - %H:%i') as Data_Protocolo, 
veiculo as Modelo_Veiculo,
situacao as Situacao
from tbos inner join tbclientes
on tbos.os = tbclientes.idcli
where situacao = 'Servico Entregue';

-- impressão da OS
select 
tbos.os as OS,date_format(tbos.dataent,'%d/%m/%Y - %H:%i') as data,
tbos.veiculo,
tbos.problema as Problema,tbos.tpagamento,
situacao as Situacao,
mecanico as Mecanico,
tbclientes.nomecli as Cliente,tbclientes.fonecli as Fone
from tbos inner join tbclientes on tbos.idcli = tbclientes.idcli
where os=1;
