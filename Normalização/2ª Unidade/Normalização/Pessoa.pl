% Relação Pessoa

pessoas( [idpessoa, nome, datanascimento, cpf, email, ativo]  ).

fds(  [   [[idpessoa],[nome, datanascimento, cpf, email, ativo]], 
      [[cpf],[idpessoa, nome, datanascimento, email, ativo]]   ]  ).


% Query: pessoas(R), fds(F), threenf(R,F).

% Resultado: R == T
% F = [[[idpessoa], [nome, datanascimento, cpf, email, ativo]], [[cpf], [idpessoa, nome, datanascimento, email, ativo]]],
% R = [idpessoa, nome, datanascimento, cpf, email, ativo],
% T = [[cpf, ativo, datanascimento, email, idpessoa, nome]]
