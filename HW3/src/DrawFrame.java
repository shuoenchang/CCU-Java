import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame {
	private final JPanel control = new JPanel();
	private final JButton undo = new JButton("Undo");
	private final JButton clear = new JButton("Clear");
	private static final Color[] colors = 
		{Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
		 Color.BLUE, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY};
	private static final String[] colorNames = 
		{"Black", "White", "Red", "Orange", "Yellow", "Green", "Cyan", 
		 "Blue", "Magenta", "Pink", "Light gray", "Gray", "Dark Gray"};
	private final JComboBox<String> colorsChoose = new JComboBox<String>(colorNames);
	private static final String[] shapeNames = {"Line", "Rectangle", "Oval"};
	private final JComboBox<String> shapesChoose = new JComboBox<String>(shapeNames);
	private final JCheckBox filled = new JCheckBox("Filled");
	private final JLabel status = new JLabel();
	private final DrawPanel draw = new DrawPanel(status);
	
	public DrawFrame() {
		super("Draw");
		control.setLayout(new GridLayout(1, 5));
		undo.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					draw.clearLastShape();
				}
			}
		);
		clear.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					draw.clearDrawing();
				}
			}
		);
		colorsChoose.setMaximumRowCount(5);
		colorsChoose.addItemListener(
			new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent event) {
					draw.setCurrentColor(colors[colorsChoose.getSelectedIndex()]);
				}
			}
		);
		shapesChoose.setMaximumRowCount(3);
		shapesChoose.addItemListener(
			new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent event) {
					draw.setShapeType(shapesChoose.getSelectedIndex());
				}
			}
		);
		filled.addItemListener(
			new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent event) {
					draw.setFilledShape(filled.isSelected());;
				}	
			}
		);
		
		control.add(undo);
		control.add(clear);
		control.add(colorsChoose);
		control.add(shapesChoose);
		control.add(filled);
		add(control, BorderLayout.NORTH);
		add(draw, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
	}
}
