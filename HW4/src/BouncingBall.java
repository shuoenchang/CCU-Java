import javax.swing.JFrame;

public class BouncingBall {

	public static void main(String[] args) {
		BallFrame ballFrame = new BallFrame();
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ballFrame.setSize(800, 600);
		ballFrame.setVisible(true);
		
	}

}
