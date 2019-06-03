% Relação Turma e Alunos

turma_aluno( [idTurma, idPessoa ]  ).

fds(  [ [[],[idTurma, idPessoa]] ]  ).

% Query: turma_aluno(R), fds(F), threenf(R,F,T).

% Resultado: R == T
F = [[[], [idTurma, idPessoa]]],
R = [idTurma, idPessoa],
T = [[idPessoa, idTurma]]
