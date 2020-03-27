Othello AI

I grew up playing video games. 

In certain games, players employed 'bots': In gaming, a bot is an autonomous agent which gives the player an advantage in game. For games like Runescape, Farmville, and World of Warcraft, bots were commonly used to gather resources for a player. 

For strategy games such as Chess, League of Legends, and Go, engineers developed bots with the purpose of creating unbeatable artificial players. 

The purpose of OthelloAI is to Build an AI-powered Othello bot. In some cultures, Othello is known as "Reversi". 

Othello is a two player game, and one can win with the consistent application of a few key strategies. It may take years for a human to develop a high level of consistency, but my bot can apply these strategies perfectly every time. 

Here's a guide to Othello, for those curious: http://samsoft.org.uk/reversi/strategy.htm

Here are instructions to run OthelloAI from the command line on a POSIX System:

git clone https://github.com/Samuel-Nathanson/OthelloAI.git # clone this repo 

cd OthelloAI 

make # compiles the program 

java Othello 

options:

  -simulation : View a simulation of a battle between two bots

  -board-size <integer> : Use a custom board size (Only sizes of 8+ are supported)
  
  -difficulty <integer> Sets the difficulty of the Othello AI. The range is between 1 and 8, Default is 5.



