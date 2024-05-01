CREATE TABLE animal
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_provisorio   VARCHAR(255)                         NOT NULL,
    idade_estimada    INT                                  NOT NULL,
    data_entrada      date                                 NOT NULL,
    data_adocao       date,
    data_obito        date,
    condicoes_chegada VARCHAR(255)                         NOT NULL,
    nome_receber      VARCHAR(255)                         NOT NULL,
    porte             VARCHAR(255)                         NOT NULL,
    especie           VARCHAR(255)                         NOT NULL
);

CREATE TABLE cachorro (
                          id INT PRIMARY KEY,
                          raca VARCHAR(255),
                          comportamento VARCHAR(255),
                          FOREIGN KEY (id) REFERENCES animal(id)
);

CREATE TABLE gato (
                      id INT PRIMARY KEY,
                      cor VARCHAR(255),
                      temperamento VARCHAR(255),
                      FOREIGN KEY (id) REFERENCES animal(id)
);
