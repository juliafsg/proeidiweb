
% Relação Frequencia

frequencia([idTurma, idPessoa, data, estavaFrequente]).

fds([ [[idTurma, idPessoa, data], [estavaFrequente]] ]).


% Query :   frequencia(R), fds(F), threenf(R, F, T)


% Resultado: R == T

% F = [[[idTurma, idPessoa, data], [estavaFrequente]]],
% R = [idTurma, idPessoa, data, estavaFrequente],
% T = [[idTurma, idPessoa, data, estavaFrequente]]
