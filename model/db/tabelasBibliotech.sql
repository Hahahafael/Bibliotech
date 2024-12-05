CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    login VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    email VARCHAR(40) NOT NULL,
    telefone CHAR(15),
    multa_acumulada DECIMAL(3, 2),
    status_da_conta VARCHAR(20),
    tipo VARCHAR(20)
);

CREATE TABLE Comentario (
    id_comentario SERIAL PRIMARY KEY,
    data_comentario DATE,
    texto VARCHAR(255),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Categoria (
    numero SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Documento (
    cod_documento VARCHAR(30) PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    data_publicacao DATE,
    num_paginas INT,
    idioma VARCHAR(13),
    editora VARCHAR (20),
    edicao INT,
    orientador VARCHAR(50),
    instituicao VARCHAR(60),
    tipo_documento VARCHAR(10),
    num_categoria INT,
    FOREIGN KEY (num_categoria) REFERENCES Categoria(numero)
);

CREATE TABLE Recebe (
    id_comentario INT,
    cod_documento VARCHAR(30),
    PRIMARY KEY (id_comentario, cod_documento),
    FOREIGN KEY (id_comentario) REFERENCES Comentario(id_comentario),
    FOREIGN KEY (cod_documento) REFERENCES Documento(cod_documento)
);

CREATE TABLE Autor (
    id_autor SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Escreve (
    cod_documento VARCHAR(30),
    id_autor INT,
    PRIMARY KEY (cod_documento, id_autor),
    FOREIGN KEY (cod_documento) REFERENCES Documento(cod_documento),
    FOREIGN KEY (id_autor) REFERENCES Autor(id_autor)
);


CREATE TABLE Emprestimo (
    cod_emprestimo SERIAL PRIMARY KEY,
    data_retirada DATE,
    data_devolucao DATE,
    multa DECIMAL(3, 2),
    status VARCHAR(20),
    quant_renovacao INT,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Emprestado (
    cod_emprestimo INT,
    cod_documento VARCHAR(30),
    PRIMARY KEY (cod_emprestimo, cod_documento),
    FOREIGN KEY (cod_emprestimo) REFERENCES Emprestimo(cod_emprestimo),
    FOREIGN KEY (cod_documento) REFERENCES Documento(cod_documento)
);

INSERT INTO Usuario
VALUES (1,'admin','admin','admin','admin@email.com', null, null,'Ativo','Administrador');