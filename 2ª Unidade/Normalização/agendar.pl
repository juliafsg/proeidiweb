% Relação Agendar

agendar([idaluno, idvoluntario, confirmado, horario, data]).

fds([ [[idaluno, idvoluntario, data, horario], [confirmado]]  ]).


% Query: agendar(R), fds(F), threenf(R, F, T).


% Resultado: R == T
% F = [[[idaluno, idvoluntario, data, horario], [confirmado]]]
% R = [idaluno, idvoluntario, confirmado, horario, data]
% T = [[idaluno, idvoluntario, data, horario, confirmado]]