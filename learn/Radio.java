import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Radio extends JFrame {
	Radio() {
		JFrame f = new JFrame("My Frame");
		JLabel l1 = new JLabel("Combo Value");
		JLabel l2 = new JLabel("Button Value");
		JLabel l3 = new JLabel("Button2 Value");
		f.add(l1);
		f.add(l2);
		f.add(l3);

		ButtonGroup bg = new ButtonGroup();
		ButtonGroup bg2 = new ButtonGroup();

		String items[] = { "1", "2", "3" };
		JComboBox<String> jc = new JComboBox<String>(items);
		jc.setBounds(100, 50, 100, 100);
		f.add(jc);

		JRadioButton jbArr[] = new JRadioButton[3];
		int i = 0;
		for (int j = 0; j < jbArr.length; j++) {
			jbArr[j] = new JRadioButton("OptionA" + j++);
			f.add(jbArr[j]);
			bg.add(jbArr[j]);

		}
		// for (JRadioButton jb : jbArr) {
		// jb = new JRadioButton("OptionA" + i++);
		// bg.add(jb);
		// f.add(jb);
		// }

		JRadioButton jbArr2[] = new JRadioButton[3];
		i = 0;
		for (JRadioButton jb : jbArr2) {
			jb = new JRadioButton("OptionB" + i++);
			bg2.add(jb);
			f.add(jb);
		}

		JButton b1 = new JButton("Cick a me");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JRadioButton jb : jbArr) {
					if (jb.isSelected())
						l2.setText(l2.getText() + jb.getText());
				}
				for (JRadioButton jb : jbArr2) {
					if (jb.isSelected())
						l3.setText(l3.getText() + jb.getText());
				}
				l1.setText(jc.getItemAt(jc.getSelectedIndex()));
			}
		});
		f.add(b1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout());
		f.setSize(600, 600);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Radio();
	}
}
