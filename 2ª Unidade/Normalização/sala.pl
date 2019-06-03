
% Relação Sala

sala([idSala, sDescricao]).

fds([ [[idSala], [sDescricao]] ]).


% Query :   sala(R), fds(F), threenf(R, F, T)


% Resultado: R == T

% F = [[[idSala], [sDescricao]]],
% R = [idSala, sDescricao],
% T = [[idSala, sDescricao]]
