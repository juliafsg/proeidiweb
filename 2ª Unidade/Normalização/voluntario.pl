% Relação Voluntário

aluno([idpessoa, ddd, telefone, gerenciador]).

fds([ [[idpessoa], [ddd, telefone, gerenciador]]  ]).	


% Query: voluntario(R), fds(F), threenf(R, F, T).


% Resultado: R == T
% F = [[[idpessoa], [ddd, telefone, gerenciador]]]
% R = [idpessoa, ddd, telefone, gerenciador]
% T = [[idpessoa, ddd, gerenciador, telefone]]