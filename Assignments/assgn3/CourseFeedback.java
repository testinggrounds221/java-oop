package assgn3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class CourseFeedback extends JFrame {
	static JFrame frame;

	public static void main(String[] args) {
		JTextField textField;
		JTextField emailField;
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 489);
		frame.setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 28, 86, 20);
		frame.add(textField);
		// frame.add(textField);
		textField.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(65, 31, 46, 14);
		frame.add(lblName);

		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(65, 115, 46, 14);
		// frame.add(textField);
		frame.add(lblEmailId);

		emailField = new JTextField();
		emailField.setBounds(128, 112, 247, 17);
		frame.add(emailField);
		emailField.setColumns(10);

		JLabel lblFeedBack = new JLabel("FeedBack");
		lblFeedBack.setBounds(65, 162, 46, 14);
		frame.add(lblFeedBack);

		JTextArea feedBackArea = new JTextArea();
		feedBackArea.setBounds(126, 157, 212, 40);
		frame.add(feedBackArea);

		JButton btnClear = new JButton("Clear");

		btnClear.setBounds(312, 387, 89, 23);
		frame.add(btnClear);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(65, 228, 46, 14);
		frame.add(lblSex);

		JLabel lblMale = new JLabel("Male");
		lblMale.setBounds(128, 228, 46, 14);
		frame.add(lblMale);

		JLabel lblFemale = new JLabel("Female");
		lblFemale.setBounds(292, 228, 46, 14);
		frame.add(lblFemale);

		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(337, 224, 109, 23);
		frame.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(162, 224, 109, 23);
		frame.add(radioButton_1);

		JLabel lblOccupation = new JLabel("Select Category of Feedback");
		lblOccupation.setBounds(65, 288, 67, 14);
		frame.add(lblOccupation);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Choose Category");
		comboBox.addItem("Meeting Course Outcome");
		comboBox.addItem("Relevancy of Course in current trend");
		comboBox.addItem("Interaction in Classroom");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(180, 285, 91, 20);
		frame.add(comboBox);

		JButton btnSubmit = new JButton("Submit");

		btnSubmit.setBackground(Color.green);
		btnSubmit.setForeground(Color.white);
		btnClear.setBackground(Color.red);
		btnClear.setForeground(Color.white);
		btnSubmit.setBounds(65, 387, 89, 23);

		frame.add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().isEmpty()
						|| (emailField.getText().isEmpty()) || (feedBackArea.getText().isEmpty())
						|| ((radioButton_1.isSelected()) && (radioButton.isSelected()))
						|| (comboBox.getSelectedItem().equals("Choose Category")))
					JOptionPane.showMessageDialog(null, "Some required Fields are Missing");
				else
					JOptionPane.showMessageDialog(null, "Feedback Saved");
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailField.setText(null);
				textField.setText(null);
				feedBackArea.setText(null);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				comboBox.setSelectedItem("Choose Category");

			}
		});
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}
}