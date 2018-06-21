import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallPanel extends JPanel {
	
	private ArrayList<Ball> balls;
	
	public BallPanel() {
		balls = new ArrayList<Ball>();
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Ball b: balls) {
			g2d.setColor(b.getColor());
			g2d.fill(b.getShape());
		}
	}
	
	public void add(Ball b) {
		balls.add(b);
	}
	
	private final class MouseHandler extends MouseAdapter implements MouseMotionListener {
		public void mousePressed(MouseEvent event) {

			Runnable r = new Ball(BallPanel.this, event.getX(), event.getY());
			add((Ball) r);
			Thread t = new Thread(r);
			t.start();
		}
	}

}
