
% Relação Turma

turma([idTurma, numeroTurma, tVagas, idSala, consolidada]).

fds([ [[idTurma, numeroTurma], [tVagas, idSala, consolidada]] ]).


% Query :   turma(R), fds(F), threenf(R, F, T)


% Resultado: R == T

% F = [[[idTurma, numeroTurma], [tVagas, idSala, consolidada]]],
% R = [idTurma, numeroTurma, tVagas, idSala, consolidada],
% T = [[idTurma, numeroTurma, consolidada, idSala, tVagas]]
