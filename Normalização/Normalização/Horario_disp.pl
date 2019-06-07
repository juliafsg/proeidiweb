% Relação Horário Disponibilidade

horario_disp( [idPessoa, horariodisp, ano, periodo]  ).

fds(  [  [[], [idPessoa, horariodisp, ano, periodo]]  ]  ).

% Query: horario_disp(R), fds(F), threenf(R,F,T).

% Resultado: R == T
% F = [[[], [idPessoa, horariodisp, ano, periodo]]],
% R = [idPessoa, horariodisp, ano, periodo],
% T = [[ano, horariodisp, idPessoa, periodo]]
