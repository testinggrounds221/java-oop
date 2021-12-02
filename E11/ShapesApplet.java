package E11;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.geom.Ellipse2D;

public class ShapesApplet extends Canvas {
	// line,
	// rectangle,
	// rounded rectangle,
	// filled rectangle,
	// filled rounded rectangle,
	// circle,
	// ellipse,
	// arc,
	// filled arc
	// polygon,
	// in different colors
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 50, 50);

		g.setColor(Color.BLUE);
		g.drawRect(20, 20, 100, 50);

		g.setColor(Color.CYAN);
		g.drawRoundRect(40, 40, 100, 50, 5, 10);

		g.setColor(Color.YELLOW);
		g.fillRect(130, 30, 100, 80);

		g.setColor(Color.BLACK);
		g.fillRoundRect(120, 120, 100, 150, 20, 20);

		g.setColor(Color.GREEN);
		g.drawOval(30, 30, 30, 30);

		g2.setPaint(Color.MAGENTA);
		g2.fill(new Ellipse2D.Double(300, 300, 40, 40));

		g.setColor(Color.ORANGE);
		g.drawArc(30, 200, 40, 50, 90, 60);

		g.setColor(Color.RED);
		g.fillArc(30, 130, 40, 50, 180, 40);

		int xCoord[] = { 110, 310, 410, 510, 810, };

		int yCoord[] = { 910, 910, 510, 410, 310, };
		g.setColor(Color.blue);

		g.drawPolygon(xCoord, yCoord, 5);

	}

	public static void main(String[] args) {
		ShapesApplet m = new ShapesApplet();
		JFrame f = new JFrame();
		f.add(m);
		f.setSize(700, 700);
		// f.setLayout(null);
		f.setVisible(true);
	}

}