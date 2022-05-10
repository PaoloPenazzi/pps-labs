search_two(X,[X,_,X|_]).
search_two(X,[_|Xs]) :- search_two(X,Xs).
% search_two is fully relational.

search_anytwo(X,[X|T]) :- search(X,T).
search_anytwo(X,[_|Xs]) :- search_anytwo(X,Xs).
% search_anytwo is fully relational.

size([], zero).
size([_|Xs],s(N)) :- size(Xs,N).
