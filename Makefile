JAVAC=java

all: OTHELLO 

OTHELLO:
	javac -cp ./  Othello.java SecretAgentMonteCarlo.java OthelloPlayer.java OthelloRandomPlayer.java OthelloPlayerInput.java GodlikeOthelloPlayer.java OthelloRandomPlayer.java OthelloState.java OthelloMove.java 
	jar cvf OTHELLO SecretAgentMonteCarlo.class OthelloPlayer.class OthelloRandomPlayer.class OthelloMove.class OthelloState.class OTHELLO.class GodlikeOthelloPlayer.class OthelloPlayerInput.class ./org/apache/commons/cli/*.class;
clean:
	rm *.class OTHELLO;
