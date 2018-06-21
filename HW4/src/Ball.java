import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

public class Ball implements Runnable{
	
	private float radius;
	private float midX;
	private float midY;
	private float speedX;
	private float speedY;
	private Color color;
	private final JPanel board;
	private static final Random rand = new Random();
	
	public Ball(JPanel board) {
		// TODO Auto-generated constructor stub
		this.board = board;
		radius = rand.nextInt(50)+10;
		midX = rand.nextInt(board.getWidth()) + radius;
		midY = rand.nextInt(board.getHeight()) + radius;
		speedX = rand.nextInt(15)+1;
		speedY = rand.nextInt(15)+1;
		color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		final float HEIGHT = board.getHeight();
		final float WIDTH = board.getWidth();
		
		midX += speedX;
		midY += speedY;
		if(midX - radius < 0) {
			speedX = -speedX;
			midX = radius;
		}
		else if(midX + radius > WIDTH) {
			speedX = -speedX;
			midX = WIDTH - radius;
		}
		if(midY - radius < 0) {
			speedY = -speedY;
			midY = radius;
		}
		else if(midY + radius > HEIGHT) {
			speedY = -speedY;
			midY = HEIGHT - radius;
		}
	}

	public Color getColor() {
		return color;
	}
	
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(midX-radius, midY-radius, 2*radius, 2*radius);
	}
}
