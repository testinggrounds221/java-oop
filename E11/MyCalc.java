package E11;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class MyCalc extends JFrame implements ActionListener {
	static JFrame f;
	static JPanel numPanel;
	static JPanel opPanel;

	static JTextField fld;

	String s0, s1, s2;

	void handleException(String err) {
		fld.setText(err);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		fld.setText("");
	}

	MyCalc() {
		s0 = s1 = s2 = "";
	}

	public static void main(String args[]) {
		f = new JFrame("MyCalc");
		numPanel = new JPanel();
		opPanel = new JPanel();
		MyCalc c = new MyCalc();
		fld = new JTextField(18);
		fld.setEditable(false);
		JButton buttons[] = new JButton[10];
		JButton bAdd, bSubtract, bDivide, bMultiply, bDecimal, bClear, bEqual;
		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton(i + "");
		}
		bEqual = new JButton("=");
		bAdd = new JButton("+");
		bSubtract = new JButton("-");
		bDivide = new JButton("/");
		bMultiply = new JButton("*");
		bClear = new JButton("C");
		bDecimal = new JButton(".");
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		numPanel.setLayout(new GridLayout(4, 4));
		opPanel.setLayout(new GridLayout(2, 2));
		bMultiply.addActionListener(c);
		bDivide.addActionListener(c);
		bSubtract.addActionListener(c);
		bAdd.addActionListener(c);
		for (int i = 0; i < 10; i++) {
			buttons[i].addActionListener(c);
		}
		bDecimal.addActionListener(c);
		bClear.addActionListener(c);
		bEqual.addActionListener(c);
		for (int i = 1; i < 10; i++) {
			numPanel.add(buttons[i]);
		}
		numPanel.add(buttons[0]);
		opPanel.add(bAdd);
		opPanel.add(bSubtract);
		opPanel.add(bMultiply);
		opPanel.add(bDivide);
		opPanel.add(bDecimal);
		opPanel.add(bClear);
		opPanel.add(bEqual);

		p.add(fld, BorderLayout.PAGE_START);
		p.add(numPanel, BorderLayout.LINE_START);

		p.add(opPanel, BorderLayout.LINE_END);

		f.add(p);
		f.setSize(350, 200);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		try {
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

		} catch (ArithmeticException ee) {
			handleException("Divide By 0 not allowed");
		} catch (Exception ee) {
			handleException("Divide By 0 not allowed");
		}
	}
}