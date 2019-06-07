% Relação Responsável

responsavel( [idTurma, idPessoa ]  ).

fds(  [ [[],[idTurma, idPessoa]] ]  ).

% Query: responsavel(R), fds(F), threenf(R,F,T).

% Resultado: R == T
F = [[[], [idTurma, idPessoa]]],
R = [idTurma, idPessoa],
T = [[idPessoa, idTurma]]
