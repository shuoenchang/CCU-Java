public class BallRunnable implements Runnable {

	private Ball ball;
	private BallPanel board;
	
	public BallRunnable(Ball ball, BallPanel board) {
		this.ball = ball;
		this.board = board;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			ball.run();
			board.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
