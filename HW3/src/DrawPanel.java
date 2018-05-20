import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DrawPanel extends JPanel{
	private static final int LINE=0;
	
	private MyShape[] shapes;
	private int shapeCount;
	private int shapeType;
	private MyShape currentShape;
	private Color currentColor;
	private boolean filledShape;
	private JLabel statusLabel;
	
	public DrawPanel(JLabel label) {
		statusLabel = label;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = LINE;
		currentShape = null;
		currentColor = Color.BLACK;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=1; i<=shapeCount; i++) {
			if(shapes[i]!=null)
				shapes[i].draw(g);
		}
	}
	
	public void setShapeType(int type) {
		shapeType = type;
	}
	public void setCurrentColor(Color color) {
		currentColor = color;
	}
	public void setFilledShape(boolean filled) {
		filledShape = filled;
	}
	public boolean getFilledShape() {
		return filledShape;
	}
	public void clearLastShape() {
		if(shapeCount>0) shapeCount--;
		repaint();
	}
	
	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}
	
	private final class MouseHandler extends MouseAdapter implements MouseMotionListener {
		
		/* new currentShape by shapeType, initial both points to mouse point */
		@Override
		public void mousePressed(MouseEvent event) {
			switch(shapeType) {
				case 0: 
					currentShape = new MyLine(); 
					break;
				case 1: 
					currentShape = new MyRectangle(getFilledShape()); 
					break;
				case 2: 
					currentShape = new MyOval(getFilledShape()); 
					break;
			}
			currentShape.setColor(currentColor);
			currentShape.setX1(event.getX());
			currentShape.setY1(event.getY());
			if(shapeCount+1 > 99)
				JOptionPane.showMessageDialog(DrawPanel.this, "Only 99 shapes are allowed!");
			else
				shapeCount++;
		}
		
		/* finish drawing, place it in array, currentShape to null*/
		@Override
		public void mouseReleased(MouseEvent event) {
			mouseMoved(event);
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			currentShape = null;
			repaint();
		}
		
		/* set position for mouse at JLabel */
		@Override
		public void mouseMoved(MouseEvent event) {
			statusLabel.setText(
					String.format(("Mouse=(%d, %d), shape count = %d"), 
							event.getX(), event.getY(), shapeCount));
		}
		
		/* set second point for current shape, and call repaint */
		@Override
		public void mouseDragged(MouseEvent event) {
			mouseMoved(event);
			currentShape.setX2(event.getX());
			currentShape.setY2(event.getY());
			shapes[shapeCount] = currentShape;
			repaint();
		}
		
	}	// end MouseHandler
	
}	// end DrawPanel
