
/**
 *
 */

 import java.util.Scanner;

public class OthelloMove {
    
    int player;
    int x,y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
    
    public OthelloMove(int a_player, int a_x, int a_y) {
        player = a_player;
        x = a_x;
        y = a_y;
    }
    
    
    public String toString() {
        return "Player " + OthelloState.PLAYER_NAMES[player] + " to " + x + ", " + y;
    }

	public void inputMove(OthelloState state) {
		System.out.println("Enter your next move x, y (Enter 'h' for a hint)");
		Scanner sc = new Scanner(System.in);
		String moveStr = sc.nextLine();
		if(moveStr.equals("h")) {
			this.x = -999;
			return;
		}
		int[] move = parseToCoord(moveStr);
		this.x = move[0];
		this.y = move[1];
	}

	private static int[] parseToCoord(String s) {
    	String[] xy = s.replaceAll("[^\\w\\d]", "").toLowerCase().split("");
		if(xy.length != 2) {
			return new int[]{1,-1};
		}
    	int[] res = new int[2];
    	res[0] = xy[0].matches("\\d") ? Integer.parseInt(xy[0]) : xy[0].charAt(0) - 'a' + 1;
    	res[1] = xy[1].matches("\\d") ? Integer.parseInt(xy[1]) : xy[1].charAt(0) - 'a' + 1;
   	 	return res;
	}
    
}
