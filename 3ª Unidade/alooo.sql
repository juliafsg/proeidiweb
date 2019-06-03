use proeidiweb;

# Pessoa
INSERT INTO pessoa VALUES(261211, 'Aroldo Felix Pereira Junior', '1997-11-26', '11822764408', 'junioraroldo37@gmail.com', TRUE);
INSERT INTO pessoa VALUES(1, 'Júlia Ferreira de Souza Glória', '2000-04-01', '01675902437', 'juliafsg@ufrn.edu.br', TRUE);
INSERT INTO pessoa VALUES(2, 'Abmael Dantas Gomes', '1999-03-27', '10709064411', 'abmaeld@gmail.com', FALSE);

# Postagem
INSERT INTO postagem VALUES();

# Anexo
INSERT INTO anexo VALUES();

# Voluntário
INSERT INTO voluntario VALUES(261211, 84, '994900120', TRUE);

# Horário Disponibilidade
INSERT INTO horario_disponibilidade VALUES(261211,'2M1',2019,1);

# Aluno
INSERT INTO aluno VALUES(1, 84, '997070687');

# Agendar
INSERT INTO agendar VALUES(1, 261211, FALSE, '2019-11-06');

# Curso
INSERT INTO curso VALUES();

# Sala
INSERT INTO sala VALUES();

# Responsável
INSERT INTO responsavel VALUES();

# Turma
INSERT INTO turma VALUES();

# Data
INSERT INTO data VALUES();

# Horário
INSERT INTO horario VALUES();

# Turma - Voluntário
INSERT INTO responsavel VALUES();

# Frequência
INSERT INTO frequencia VALUES();

select * from horario_disponibilidade;