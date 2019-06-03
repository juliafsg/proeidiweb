% Relação Aluno

aluno([idpessoa, ddd, telefone]).

fds([ [[idpessoa], [ddd,telefone]]  ]).	


% Query: aluno(R), fds(F), threenf(R, F, T).


% Resultado: R == T
% F = [[[idpessoa], [ddd, telefone]]]
% R = [idpessoa, ddd, telefone]
% T = [[idpessoa, ddd, telefone]]