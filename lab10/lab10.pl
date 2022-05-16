search_two(X,[X,_,X|_]).
search_two(X,[_|Xs]) :- search_two(X,Xs).
% search_two is fully relational.

search_anytwo(X,[X|T]) :- search(X,T).
search_anytwo(X,[_|Xs]) :- search_anytwo(X,Xs).
% search_anytwo is fully relational.

size([], zero).
size([_|Xs],p(N)) :- size(Xs,N).
% size is fully relational. (size with p(p(zero)))

sum([], 0).
sum([H|T], M) :- sum(T, N), M is N + H.
% sum is not fully relational.

max([], 0).
max([H|T], M) :- max(T, C), (H > C -> M is H ; M is C).

minmax([A],A,A).
minmax([H|T], MIN, MAX) :- minmax(T, X, Y),
    (H > Y -> MAX is H ; MAX is Y),
    (H < X -> MIN is H ; MIN is X).


greater(A,B) :- (A > B ; true ; false).

all_greater([A],[B]) :- greater(A,B).
all_greater([H1|T1],[H2|T2]) :-
    greater(H1,H2),
    all_greater(T1, T2).

all_bigger([L1],[L2]) :- all_bigger([L1],[L2], F).
all_bigger([A],[B],F) :-
    (A > B ; F is true ; F is false).
all_bigger([H1|T1],[H2|T2], F) :-
    (H1 > H2 ; all_bigger(T1,T2, true) ; F is false).
