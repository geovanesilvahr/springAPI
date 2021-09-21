CREATE SEQUENCE med_id_seq;

CREATE TABLE tb_medicos(
    med_codigo integer NOT NULL DEFAULT nextval('med_id_seq'),
    med_nome VARCHAR(30),
   	med_sobrenome VARCHAR(15),
   	med_dtnascimento INTEGER,
    primary key(med_codigo)
);