% Relação Data

data( [idTurma,dataAula]  ).

fds(  [ [[], [idTurma,dataAula]] ]  ).

% Query: data(R), fds(F), threenf(R,F,T).

% Resultado: R == T
F = [[[], [idTurma, dataAula]]],
R = [idTurma, dataAula],
T = [[dataAula, idTurma]]
