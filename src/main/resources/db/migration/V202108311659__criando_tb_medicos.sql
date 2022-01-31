CREATE SEQUENCE med_id_seq;

CREATE TABLE tb_medicos(
    med_codigo integer NOT NULL DEFAULT nextval('med_id_seq'),
    med_nome VARCHAR(30),
   	med_sobrenome VARCHAR(15),
   	med_dtnascimento INTEGER,
   	logradouro VARCHAR(30),
   	numero VARCHAR(30),
   	cep VARCHAR(30),
   	bairro VARCHAR(30),
   	complemento VARCHAR(30),
   	cidade VARCHAR(30),
   	estado VARCHAR(30),
   	ativo BOOLEAN NOT NULL,
    primary key(med_codigo)
);

    INSERT INTO tb_medicos (med_nome, med_sobrenome,med_dtnascimento, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João', 'Silva', 242343, 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
   