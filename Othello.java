import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
/**
 *
 */
public class Othello {


    public static void main(String args[]) throws ParseException {
		
		/* Parse Arguments */ 
		int d = 5;
		boolean interactive = true;
		int bs = 8;

		Options options = new Options();

		Option difficulty = Option.builder()
		.longOpt("difficulty")
		.argName("difficulty")
		.hasArg()
		.desc("Sets the difficulty of the bot (1-8)")
		.build();

		Option boardSize = Option.builder()
		.longOpt("board-size")
		.argName("board-size")
		.hasArg()
		.desc("Sets the board size (8+)")
		.build();

		options.addOption("simulate", false, "Simulate a battle between two othello bots");
		options.addOption(boardSize);
		options.addOption(difficulty);

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		if(cmd.hasOption("difficulty")) {
			d = Integer.parseInt(cmd.getOptionValue("difficulty"));
			System.out.println("Attempting to set difficulty level to " + d);
			d = d <= 8 ? d : 8;
			d = d >= 1 ? d : 1;
			System.out.println("Setting difficulty level to " + d);
		} 
		if(cmd.hasOption("board-size")) {
			bs = Integer.parseInt(cmd.getOptionValue("board-size"));
			System.out.println("Attempting to set board size to " + bs);
			bs = bs >= 8 ? bs * printWithReturnOne("Board Size must be greater than 8") : 8;
			System.out.println("Setting board size to " + bs);
		} 
		if(cmd.hasOption("simulate")) {
			System.out.println("Running simulation of two bots with difficulty " + d);
			interactive = false;
		}

    	// Create the game state with the initial position for an 8x8 board:
        OthelloState state = new OthelloState(bs);
        OthelloPlayer players[] = {interactive ? new OthelloPlayerInput() : new GodlikeOthelloPlayer(d), 
        							new GodlikeOthelloPlayer(d)};
        
        do{
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state.nextPlayerToMove] + " to move:");
            System.out.print(state);
            
            // Get the move from the player:
            OthelloMove move = players[state.nextPlayerToMove].getMove(state);            
            System.out.println(move);
            state = state.applyMoveCloning(move);            
        } while(!state.gameOver());

        // Show the result of the game:
        System.out.println("\nFinal state with score: " + state.score());
        System.out.println(state);
    }    

	static int printWithReturnOne(String s) {
		System.out.println(s);
		return 1;
	}

}
