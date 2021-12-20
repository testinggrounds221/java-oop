import javax.swing.*;
import java.awt.*;

public class Factorial extends JFrame {

	static JFrame f;

	public static void main(String[] args) {
		f = new JFrame("Shree");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JTextField t1 = new JTextField();

		panel.add(new JLabel("Heyy"));
		panel.add(t1);

		f.add(panel);
		f.setSize(300, 300);
		f.setVisible(true);
	}
}
