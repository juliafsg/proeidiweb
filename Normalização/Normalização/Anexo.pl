% Relação Anexo

anexo( [idPostagem, enderecoAnexo]  ).

fds(  [ [[],[idPostagem,enderecoAnexo]  ]]  ).

% Query: anexo(R), fds(F), threenf(R,F,T).

% Resultado: R == T
F = [[[], [idPostagem, enderecoAnexo]]],
R = [idPostagem, enderecoAnexo],
T = [[enderecoAnexo, idPostagem]]
