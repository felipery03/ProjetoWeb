create database listacasamento;
create user 'listacasamento'@'localhost' identified by 'Listacasamento@3';
grant all privileges on listacasamento.* to 'listacasamento'@'localhost';

use listacasamento;

create table tblPasseio(
   id        int not null auto_increment,
   titulo    varchar(50),
   preco     float,
   urlFoto  varchar(100),
   constraint pk_produto primary key (id)
);

create table tblConvidado(
   id int not null auto_increment,
   nome varchar(100),
   email varchar(70) unique,
   tel varchar(20),
   msg varchar(300),
   privilegio int,

   constraint pk_convidado primary key(id)

);

create table tblPedido(
    id int not null auto_increment,
    data Date,
    status int,
    valortotal float,
    idconvidado int not null,
    constraint pk_pedido primary key (id),
    constraint fk_convidado foreign key (idconvidado) references
           tblConvidado(id)
);
create table tblPedidoHasPasseio(
    idpedido int not null,
    idpasseio int not null,
    qtd int,
    valortotal float,
    constraint pk_itempedido primary key(idpedido, idpasseio),
    constraint fk_pedido foreign key (idpedido) references tblPedido(id),
    constraint fk_produto foreign key (idpasseio) references tblPasseio(id)
);


insert into tblConvidado values (null, 'convidado1', null, null, null, 0);

insert into tblConvidado values (null, 'convidado2', null, null, null, 0);

insert into tblConvidado values (null, 'convidado3', null, null, null, 0);

insert into tblConvidado values (null, 'admin', null, null, null, 1);

###########################


insert into tblPasseio values(null, 'Passeio pelas belas praias de Mauritius', 120.00, 'images/passeio1.jpg');
insert into tblPasseio values(null, 'Visita a Reserva Natural do parque do Cabo de Boa Esperança', 55.00, 'images/passeio2.jpg');
insert into tblPasseio values(null, 'Compra de vinhos para o casal com degustação', 300.00, 'images/passeio3.jpg');

insert into tblPasseio values(null, 'Safari de balão no parque Kruger para o casal', 500.00, 'images/passeio4.jpg');

insert into tblPasseio values(null, 'Almoço no Beau Rivage em Mauritius', 210.00, 'images/passeio5.jpg');
insert into tblPasseio values(null, 'Café da manhã a beira da piscina em Mauritius', 135.00, 'images/passeio6.jpg');







