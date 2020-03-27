import java.util.List;
import java.util.Random;

public class OthelloPlayerInput extends OthelloPlayer {

    public OthelloMove getMove(OthelloState state) {
		List<OthelloMove> moves = state.generateMoves(state.nextPlayerToMove);
		OthelloMove m = new OthelloMove(0,0, state.nextPlayerToMove);

		boolean displayHelp = false;
		while(true) {
			m.inputMove(state);
			if(m.getX() == -999) {
				System.out.println("Here's a list of possible moves.");
				displayHelp = true;
			}
			else {
				displayHelp = false;
			}

			for (OthelloMove mi : moves) {
				if(displayHelp) {
					System.out.println("(" + mi.getX() + "," + mi.getY() + ")");
				}
				if(mi.getX() == m.getX() && mi.getY() == m.getY()) {
					return m;
				}
			}
		}
    }
}
