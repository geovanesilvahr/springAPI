create sequence esp_id_seq;

create table tb_especialidades(
    esp_codigo integer NOT NULL DEFAULT nextval('esp_id_seq'),
    esp_descricao VARCHAR(30),
    esp_nomereduzido VARCHAR(15),
    primary key(esp_codigo)
);