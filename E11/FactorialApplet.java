package E11;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class FactorialApplet extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;
	static JPanel numPanel;
	static JPanel opPanel;

	// create a textfield
	static JTextField fld;

	// store operator and operands
	String s0, s1, s2;

	static int getFactorial(int num) {
		int fac = 1;
		while (num > 0)
			fac *= num--;

		return fac;
	}

	// default constructor
	FactorialApplet() {
		s0 = "";
	}

	// main function
	public static void main(String args[]) {
		f = new JFrame("FactorialApplet");
		numPanel = new JPanel();
		opPanel = new JPanel();
		FactorialApplet c = new FactorialApplet();
		fld = new JTextField(18);
		fld.setEditable(false);
		JButton buttons[] = new JButton[10];
		JButton bClear;
		JButton bCompute;
		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton(i + "");
		}
		bClear = new JButton("Clear");
		bCompute = new JButton("Compute");
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		numPanel.setLayout(new GridLayout(4, 4));
		opPanel.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < 10; i++) {
			buttons[i].addActionListener(c);
		}
		bClear.addActionListener(c);
		bCompute.addActionListener(c);
		for (int i = 1; i < 10; i++) {
			numPanel.add(buttons[i]);
		}
		numPanel.add(buttons[0]);
		opPanel.add(bClear);
		opPanel.add(bCompute);

		p.add(fld, BorderLayout.PAGE_START);
		p.add(numPanel, BorderLayout.LINE_START);

		p.add(opPanel, BorderLayout.LINE_END);

		f.add(p);
		f.setSize(350, 200);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.print(s);

		if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
			s0 += s;
			fld.setText(s0);
		} else if (s.charAt(1) == 'l') {
			s0 = "";
			fld.setText(s0);
		} else {
			System.out.print("Compute");
			int op = getFactorial(Integer.parseInt(s0));

			fld.setText(Integer.toString(op));

			s0 = Integer.toString(op);
		}
	}
}