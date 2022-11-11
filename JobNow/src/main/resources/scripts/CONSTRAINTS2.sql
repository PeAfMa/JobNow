-- PK"S  --
ALTER TABLE "Trabalhador" ADD CONSTRAINT PK_TRABALHADOR PRIMARY KEY ("ID");
ALTER TABLE "Ordem de Servico" ADD CONSTRAINT PK_ORDSERV PRIMARY KEY ("Empregador", "ID");
ALTER TABLE "Empregador" ADD CONSTRAINT PK_EMPREGADOR PRIMARY KEY ("ID");
ALTER TABLE "Contrata" ADD CONSTRAINT PK_CONTRATA PRIMARY KEY ("Trabalhador", "Empregador");
ALTER TABLE "Area de Atuacao" ADD CONSTRAINT PK_AREAATUA PRIMARY KEY ("ID", "Trabalhador");
ALTER TABLE "Aceita" ADD CONSTRAINT PK_ACEITA PRIMARY KEY ("Ordem de Serviço_ID","Ordem de Serviço_Empregador", "Trabalhador");

--FK"S --
ALTER TABLE "Ordem de Servico" ADD CONSTRAINT FK_ORDSERV FOREIGN KEY ("Empregador") REFERENCES "Empregador" ("ID") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "Contrata" ADD CONSTRAINT FK_CONTRATA1 FOREIGN KEY ("Trabalhador") REFERENCES "Trabalhador" ("ID") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "Contrata" ADD CONSTRAINT FK_CONTRATA2 FOREIGN KEY ("Empregador") REFERENCES "Empregador" ("ID") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "Area de Atuacao" ADD CONSTRAINT FK_AREAATUA FOREIGN KEY ("Trabalhador") REFERENCES "Trabalhador" ("ID") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "Aceita" ADD CONSTRAINT FK_ACEITA1 FOREIGN KEY ("Ordem de Serviço_ID", "Ordem de Serviço_Empregador") REFERENCES "Ordem de Servico" ("ID","Empregador") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "Aceita" ADD CONSTRAINT FK_ACEITA2 FOREIGN KEY ("Trabalhador") REFERENCES "Trabalhador" ("ID") ON DELETE CASCADE ON UPDATE CASCADE;
