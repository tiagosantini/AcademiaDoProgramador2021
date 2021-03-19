CREATE DATABASE estoque;
USE estoque;

CREATE TABLE equipamentos(
	id int AUTO_INCREMENT PRIMARY KEY,
    nomeProduto varchar(30) NOT NULL,
    precoAquisicao double NOT NULL,
    numeroSerie varchar(30) NOT NULL,
    dataFabricacao date NOT NULL,
    fabricante varchar(30) NOT NULL
);

INSERT INTO equipamentos VALUES
	(id, 'Impressora', 300.90, '10A99L', '2020/04/25', 'HP'),
    (id, 'Roteador', 150.25, '29XLL1', '2019/11/14', 'TP-LINK'),
    (id, 'Monitor', 950.50, '11X021', '2013/12/22', 'LG');
