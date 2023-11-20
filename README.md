# Uno Game
## 🛠 set-up
1. [Get started with Java in VSCode](https://code.visualstudio.com/docs/java/java-tutorial)
2. Clone the Repository

## 🚀 build and run for production
1. Run `./GameRunner.java`

## Rules:
- 100 cards instead of 108 because there’s no reverse card
- 7 cards are dealt facing down to 2 players
- Cards need to match either by color, number, or action
- Player put "WILD" card on every card
- At the moment a player has just 1 card they must say "UNO". If not, player has to draw 2 more cards
- A player may always draw a card from the deck.
- If the entire deck is used during play, the top discard is set aside and the rest of the pile is shuffled to create a new deck
### Deck:
- 19 [blue, red, yellow, green] cards that are numbered from 0 to 9
- 8 “Draw Two” cards (two of each color)
- 8 “Skip” cards - two of each color (8 “Reverse” cards- two of each color)
- 4 “Wild” cards
- 4 “Wild Draw Four” cards
### Identity or Action cards:  
- Skip (Reverse)
- Draw 2 - If turned up at the beginning of play, player draws two cards and gets skipped
- Wild 
- Wild Draw 4 - if turned up at the beginning of play, return this card to the Draw pile, shuffle, and turn up to the next player 2 players game: if you play a Draw 2 and Wild Draw 4 cards, your opponent has to draw the number of cards required, and then play immediately resumes back on your turn
### SCORING: (under contruction)
- All number cards are the same value as the number on the card
- Draw 2 and Skip(Reverse) - 20 pts
- Wild and Wild Draw 4 - 50 pts
- First player to attain 100 ints wins the game (The player with the most points received from opponents wins the game)

