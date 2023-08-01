create table jogadores(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    clube varchar(100) not null unique,
    camisa varchar(6) not null unique,
    nacionalidade varchar(100) not null,
    posicao varchar(100) not null,
    altura double not null,
    mercado varchar(50) not null,

    primary key(id)

);