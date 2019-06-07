% Relação Curso

curso( [idCurso, cNome, cDescricao, cargaHoraria]  ).

fds(  [ [[idCurso], [ cNome, cDescricao, cargaHoraria]] ]  ).

% Query: curso(R), fds(F), threenf(R,F,T).

% Resultado: R == T
% F = [[[idCurso], [cNome, cDescricao, cargaHoraria]]],
% R = [idCurso, cNome, cDescricao, cargaHoraria],
% T = [[idCurso, cDescricao, cNome, cargaHoraria]]

