import javax.swing.JFrame;

public class BallFrame extends JFrame {
	private BallPanel board;
	
	public BallFrame() {
		super("Bouncing Ball");
		board = new BallPanel();
		add(board);
		board.repaint();
	}
}
