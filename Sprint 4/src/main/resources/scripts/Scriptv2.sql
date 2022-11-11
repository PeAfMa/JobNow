CREATE TABLE "Trabalhador"(
    "ID" INT NOT NULL,
    "Email" VARCHAR(100) NOT NULL,
    "Telefone" VARCHAR(100) NOT NULL,
    "Login" VARCHAR(100) NOT NULL,
    "Senha" VARCHAR(100) NOT NULL,
    "Premium" BOOLEAN NOT NULL,
    "Nome" VARCHAR(100) NOT NULL,
    "Sobrenome" VARCHAR(100) NOT NULL,
    "CPF" VARCHAR(100) NOT NULL,
    "Avaliação" VARCHAR(500) NOT NULL,
    "Recomendação" INT NOT NULL,
    "Local" VARCHAR(100) NOT NULL
);

CREATE TABLE "Ordem de Servico"(
    "Empregador" INT NOT NULL,
    "ID" INT NOT NULL,
    "Local" VARCHAR(100) NOT NULL,
    "Trabalho" VARCHAR(100) NOT NULL,
    "Preço" FLOAT NOT NULL
);


CREATE TABLE "Empregador"(
    "ID" INT NOT NULL,
    "Email" VARCHAR(100) NOT NULL,
    "Telefone" VARCHAR(20) NOT NULL,
    "Login" VARCHAR(100) NOT NULL,
    "Senha" VARCHAR(100) NOT NULL,
    "Premium" BOOLEAN NOT NULL,
    "Nome" VARCHAR(100) NOT NULL,
    "Sobrenome" VARCHAR(100) NOT NULL,
    "CPF/CNPJ" VARCHAR(20) NOT NULL,
    "Avaliação" VARCHAR(500) NOT NULL,
    "Recomendação" INT NULL
);

CREATE TABLE "Contrata"(
    "Trabalhador" INT NOT NULL,
    "Empregador" INT NOT NULL,
    "Pago" BOOLEAN NOT NULL,
    "Local" VARCHAR(100) NOT NULL
);

CREATE TABLE "Area de Atuacao"(
    "Trabalhador" INT NOT NULL,
    "ID" INT NOT NULL

);

CREATE TABLE "Aceita"(
    "Ordem de Serviço_ID" INT NOT NULL,
    "Ordem de Serviço_Empregador" INT NOT NULL,
    "Trabalhador" INT NOT NULL,
    "Pago" BOOLEAN NOT NULL

);
