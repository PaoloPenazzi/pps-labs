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
