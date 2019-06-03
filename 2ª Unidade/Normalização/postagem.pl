% Relação Postagem

postagem([idPostagem, idPessoa, texto, data, assunto]).

fds([ [[idPostagem], [idPessoa, texto, data, assunto]] ]).


% Query :   postagem(R), fds(F), threenf(R, F, T)


% Resultado: R == T

% F = [[[idPostagem], [idPessoa, texto, data, assunto]]],
% R = [idPostagem, idPessoa, texto, data, assunto],
% T = [[idPostagem, assunto, data, idPessoa, texto]]
