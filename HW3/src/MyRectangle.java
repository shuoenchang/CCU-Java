import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	private boolean filled;
	
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.filled = filled;
	}
	
	public int getUpperLeftX() {
		return Math.min(x1, x2);
	}
	
	public int getUpperLeftY() {
		return Math.min(y1, y2);
	}
	
	public int getWidth() {
		return Math.abs(x1-x2);
	}
	
	public int getHeight() {
		return Math.abs(y1-y2);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		if(filled)
			g.fillRect(getUpperLeftX(), getUpperLeftX(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}
