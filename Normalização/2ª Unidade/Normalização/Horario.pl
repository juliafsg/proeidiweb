% Relação Horário

horario( [idTurma,horaInicio, horaFim, data]  ).

fds(  [ [[],[idTurma, horaInicio, horaFim, data]] ]  ).

% Query: horario(R), fds(F), threenf(R,F,T).

% Resultado: R == T
F = [[[], [idTurma, horaInicio, horaFim, data]]],
R = [idTurma, horaInicio, horaFim, data],
T = [[data, horaFim, horaInicio, idTurma]]
