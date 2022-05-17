dropAny(X, [X | T], T).
dropAny(X, [H | Xs], [H | L]) :- dropAny(X, Xs, L).

dropFirst(X, [X | T], T) :- !.
dropFirst(X, [H | Xs], [H | L]) :- dropFirst(X, Xs, L).

?- dropFirst(10,[10,20,10,30,10],L)

dropLast(X, [H | Xs], [H | L]) :- dropLast(X, Xs, L), !.
dropLast(X, [X | T], T).
?-dropLast(10,[10,20,10,30,10],L)

dropAll(X, [], []).
dropAll(X, [X | Xs], L) :- dropAll(X, Xs, L), !.
dropAll(X, [H | Xs], [H | L]) :- dropAll(X, Xs, L).
?- dropAll(10,[10,20,30,10,20],L).

fromCircList([E],e(E,E)).
fromCircList([H1,H2|T],[e(H1,H2)|L]) :- fromCircle([H1,H2|T],[e(H1,H2)|L], H1).
fromCircle([H1,H2|T],[e(H1,H2)|L], E) :- fromCircle([H2|T], L, E).
fromCircle([H1,H2], [e(H1,H2), e(H2,E)], E).
?-fromCircList([1,2,3,4],L).
% Fully relational

in_degree([], E, 0).
in_degree(e(_,E), E, 1).
in_degree([e(_,E)|T], E, N) :- in_degree(T, E, M), N is M + 1, !.
in_degree([H|T], E, M) :- in_degree(T, E, M).
?- in_degree([e(1,2), e(1,3), e(3,2)], 3, X).

% Solution without using findall and member
reaching([e(X,T)], X, T).
reaching([e(X, N)|T], X, [N|L]) :- reaching(T, X, L), !.
reaching([_|T], X, L) :- reaching(T, X, L).

% Using findall and member
reaching(L, N, O) :- findall(X, member(e(N,X), L), O).

anypath(L, N1, N2, O) :- anypath(L, N1, N2, O, L).
anypath([e(N1,N2)|_], N1, N2, e(N1,N2), IL).
anypath([e(N,N2)|_], N1, N2, [Z|e(N,N2)], IL) :- anypath(IL, N1, N, Z).
anypath([_|T], N1, N2, Z, IL) :- anypath(T, N1, N2, Z, IL).
?- anypath([e(1,3),e(2,5),e(3,8),e(1,8),e(8,7),e(1,7)], 1, 7, O)

allreaching([], N, []).
allreaching(L, N, Bag) :- findall(e(N,X), member(e(N,X),L), Bag).

allreaching([], N, []).
allreaching(L, N, Bag) :-
    findall(X, member(e(N,X),L), [B1|B2]),
    allreaching(e(X,Y), member(e(X,Y), L), B2).


?- findall(e(1,X), member(X,[1,2,3,4]), Bag)


