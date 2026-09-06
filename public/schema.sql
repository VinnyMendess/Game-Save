Create database projeto_individual;
use projeto_individual;
create table usuario (
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nameTag Varchar(60),
email varchar(60),
senha varchar(60)
);

create table bibliotecaJogo (
idBibliotecaJogo INT PRIMARY KEY,
titulo VARCHAR(150),
horasJogadas INT,
dataConclusao DATE,
plataforma VARCHAR(45),
statuss VARCHAR(45),
nota INT CHECK(nota>= 0 AND nota <= 10),
midia VARCHAR(45) CONSTRAINT chk_midia CHECK(midia in("Fisíco", "Digital")),
idUsuario INT,
CONSTRAINT fkUsuario
FOREIGN KEY (idUsuario)
REFERENCES usuario(idUsuario)
);



INSERT INTO usuario(nameTag, email, senha) VALUES
("teste", "teste@t.com", "teste");

SELECT * FROM usuario;
