package assgn3;

import javax.swing.*;
import java.awt.event.*;

public class back extends JFrame implements ActionListener {
	static JFrame f;
	// create a textfield
	static JTextField fld;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	back() {
		s0 = s1 = s2 = "";
	}

	static int getFactorial(int num) {
		int fac = 1;
		while (num > 0)
			fac *= num--;

		return fac;
	}

	public static void main(String[] args) {
		f = new JFrame("back");

		back c = new back();
		fld = new JTextField(18);

		fld.setEditable(false);
		JButton bAdd, bSubtract, bDivide, bMultiply, bDecimal, bClear, bEqual;
		bEqual = new JButton("Compute");
		bAdd = new JButton("+");
		bSubtract = new JButton("-");
		bDivide = new JButton("/");
		bMultiply = new JButton("*");
		bClear = new JButton("C");
		bDecimal = new JButton(".");

		JPanel p = new JPanel();

		bMultiply.addActionListener(c);
		bDivide.addActionListener(c);
		bSubtract.addActionListener(c);
		bAdd.addActionListener(c);

		bDecimal.addActionListener(c);
		bClear.addActionListener(c);
		bEqual.addActionListener(c);

		// add elements to panel

		p.add(fld);
		p.add(bEqual);

		f.add(p);
		f.setSize(350, 200);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;
			fld.setText(s0 + s1 + s2);
		} else if (s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";
			fld.setText(s0 + s1 + s2);
		} else if (s.charAt(0) == '=') {
			double op;

			if (s1.equals("+"))
				op = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				op = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				op = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				op = (Double.parseDouble(s0) * Double.parseDouble(s2));

			fld.setText(s0 + s1 + s2 + "=" + op);

			s0 = Double.toString(op);

			s1 = s2 = "";
		} else {

			if (s1.equals("") || s2.equals(""))
				s1 = s;

			else {
				double op;

				if (s1.equals("+"))
					op = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					op = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					op = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					op = (Double.parseDouble(s0) * Double.parseDouble(s2));

				s0 = Double.toString(op);
				s1 = s;
				s2 = "";
			}
			fld.setText(s0 + s1 + s2);
		}

	}
}
