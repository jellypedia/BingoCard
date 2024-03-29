BingoCard
fields: 
- random list of integers from 1-75
	- 5 each from B, I, N, G, O (only 4 for N)
	- first 5 must be 1-15 in random order
	- second 5 must be 16-30, etc
	- third must have its 3rd element as 0 (FREE) 31-45
	- and so on
- integer id

BingoGame - Runnable
fields: 
- boolean array of 76 elements (result)
	- index 0 reserved for FREE
	- all initialized to false, except for 0 (FREE)
- boolean variable to identify bingo
- list of BingoCard
run method:
- asks for the number of players/cards
- creates the list of cards
- creates a list of threads containing BingoPattern
- starts all threads at once
- loops while it is not bingo
	- generate a random number
	- outputs the number chosen
	- prints out all numbers chosen numerically
	- notifies those waiting for result
	- sleeps for 300 milliseconds
- if bingo
	- prints out all numbers again
	- interrupts all threads since game is over

BingoPattern - abstract Runnable
- only to be extended from actual pattern checkers
fields:
- list of BingoCheckers
- the BingoCard to check against, initialized at constructor

run method:
- creates threads for BingoCheckers
- starts them all at once
- waits for all the threads to finish and when done,
	- declare bingo 
	- output "Card [id] completes pattern" while printing all elements in card form
	- stops all other threads
- can be interrupted and when so, output "Card [id] loses"

BingoPatternPlus - extends BingoPattern
- only has constructor
- adds BingoCheckers at middle row and middle column

BingoPatternHash - extends BingoPattern
- only has constructor
- adds BingoCheckers at second and fourth rows and columns	


BingoChecker - abstract Runnable
- only to be extended from actual cell checkers
fields:
- BingoCard initialized at constructor

BingoRowChecker - extends BingoChecker
fields:
- int row initialized at constructor
run method:
- loops through all card's elements at the specified row
- waits for the game to release result
- can be interrupted and when so, declare what element it was waiting for

BingoColumnChecker - extends BingoChecker
fields:
- int col initialized at constructor
run method:
- loops through all card's elements at the specified col
- waits for the game to release result
- can be interrupted and when so, declare what element it was waiting for
