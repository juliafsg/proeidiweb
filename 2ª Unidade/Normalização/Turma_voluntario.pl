% Relação Turma Voluntário

turma_voluntario( [idTurma, idPessoa, ano, semestre]  ).

fds(  [ [[idTurma, idPessoa], [ano, semestre]] ]  ).

% Query: turma_voluntario(R), fds(F), threenf(R,F,T).

% Resultao: R == T
% F = [[[idTurma, idPessoa], [ano, semestre]]],
% R = [idTurma, idPessoa, ano, semestre],
% T = [[idTurma, idPessoa, ano, semestre]]
