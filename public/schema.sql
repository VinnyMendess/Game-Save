Create database projeto_individual;
use projeto_individual;
create table usuario (
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nameTag Varchar(60),
email varchar(60),
senha varchar(60)
);

create table bibliotecaJogo (
idBibliotecaJogo INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(150) NOT NULL,
horasJogadas INT NULL,
dataConclusao DATE NULL,
plataforma VARCHAR(45) NULL,
midia VARCHAR(45) CONSTRAINT chk_midia CHECK(midia in("fisíco", "digital")) NULL,
statuss VARCHAR(45) NULL,
nota INT CHECK(nota>= 0 AND nota <= 10) NULL,
favorito BOOLEAN NULL,
genero VARCHAR(255) NULL,
imagem VARCHAR(500) NOT NULL,
idUsuario INT NOT NULL,
CONSTRAINT fkUsuario
FOREIGN KEY (idUsuario)
REFERENCES usuario(idUsuario)
);



INSERT INTO usuario(nameTag, email, senha) VALUES
("teste", "teste@t.com", "teste");

SELECT * FROM bibliotecajogo;
