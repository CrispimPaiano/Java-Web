DROP DATABASE IF EXISTS exemplo_web_01;
CREATE DATABASE IF NOT EXISTS exemplo_web_01;
USE exemplo_web_01;

CREATE TABLE alimentos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	preco DOUBLE,
	quantidade SMALLINT,
	descricao VARCHAR(100)
);

INSERT INTO alimentos (nome, preco, quantidade) VALUES
("maçã à calabresa", 3, 10),
("calabresa a milanesa", 30, 1),
("suco de calabresa", 1.50, 2),
("sopa de calabresa", 15, 1);