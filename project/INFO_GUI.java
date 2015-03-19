package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class INFO_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_A;
	private JTextField textField_AR;
	private JTextField textField_B;
	private JTextField textField_BR;
	private JTextField textField_Teacher;
	private JLabel lblALevelClasses;
	private JLabel lblARLevelClasses;
	private JLabel lblBLevelClasses;
	private JLabel lblBRLevelClasses;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	private JTextField textField_C;
	private JTextField textField_CR;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public INFO_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 420);
		setTitle("INFORMATIONS");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblALevelClasses = new JLabel("Number Of -A- Level Classes  :");
		lblALevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblALevelClasses.setBackground(SystemColor.activeCaption);
		lblALevelClasses.setBounds(10, 58, 259, 21);
		contentPane.add(lblALevelClasses);

		lblARLevelClasses = new JLabel("Number Of -AR- Level Classes  :");
		lblARLevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblARLevelClasses.setBackground(Color.LIGHT_GRAY);
		lblARLevelClasses.setBounds(10, 90, 259, 21);
		contentPane.add(lblARLevelClasses);

		lblBLevelClasses = new JLabel("Number Of -B- Level Classes  :");
		lblBLevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBLevelClasses.setBackground(SystemColor.activeCaption);
		lblBLevelClasses.setBounds(10, 122, 259, 21);
		contentPane.add(lblBLevelClasses);

		lblBRLevelClasses = new JLabel("Number Of -BR- Level Classes  :");
		lblBRLevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBRLevelClasses.setBackground(SystemColor.activeCaption);
		lblBRLevelClasses.setBounds(10, 154, 259, 21);
		contentPane.add(lblBRLevelClasses);

		textField_A = new JTextField();
		textField_A.setFont(new Font("Calibri", Font.BOLD, 18));
		textField_A.setBounds(279, 59, 41, 20);
		contentPane.add(textField_A);
		textField_A.setColumns(10);

		textField_AR = new JTextField();
		textField_AR.setBounds(279, 91, 41, 20);
		textField_AR.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(textField_AR);
		textField_AR.setColumns(10);

		textField_B = new JTextField();
		textField_B.setBounds(279, 123, 41, 20);
		textField_B.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(textField_B);
		textField_B.setColumns(10);

		textField_BR = new JTextField();
		textField_BR.setBounds(279, 155, 41, 20);
		textField_BR.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(textField_BR);
		textField_BR.setColumns(10);

		btnLogin = new JButton("OKEY");
		btnLogin.setForeground(new Color(0, 153, 255));
		btnLogin.setFont(new Font("Vani", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_A.getText().toString().equals("")
						&& !textField_AR.getText().toString().equals("")
						&& !textField_B.getText().toString().equals("")
						&& !textField_BR.getText().toString().equals("")
						&& !textField_C.getText().toString().equals("")
						&& !textField_CR.getText().toString().equals("")
						&& !textField_Teacher.getText().toString().equals("")) {
					if (Integer.parseInt(textField_Teacher.getText()) == 0) {
						JOptionPane.showMessageDialog(null,
								"YOU CANNOT USE '0' NUMBER FOR TEACHER");

					} else {
						Classes classes = new Classes();
						classes.setALevel(Integer.parseInt(textField_A
								.getText()));
						classes.setARLevel(Integer.parseInt(textField_AR
								.getText()));
						classes.setBLevel(Integer.parseInt(textField_B
								.getText()));
						classes.setBRLevel(Integer.parseInt(textField_BR
								.getText()));
						classes.setCLevel(Integer.parseInt(textField_C
								.getText()));
						classes.setCRLevel(Integer.parseInt(textField_CR
								.getText()));
						MAIN_GUI.setNumberOfTeachers(Integer
								.parseInt(textField_Teacher.getText()));
						MAIN_GUI.term = comboBox.getSelectedItem().toString();
						if (comboBox.getSelectedItem().toString()
								.equals("1. Term")) {
							createClassTerm_1(
									Integer.parseInt(textField_A.getText()),
									Integer.parseInt(textField_AR.getText()),
									Integer.parseInt(textField_B.getText()),
									Integer.parseInt(textField_BR.getText()),
									Integer.parseInt(textField_C.getText()),
									Integer.parseInt(textField_CR.getText()));

						} else {
							createClassTerm_2_3(
									Integer.parseInt(textField_A.getText()),
									Integer.parseInt(textField_AR.getText()),
									Integer.parseInt(textField_B.getText()),
									Integer.parseInt(textField_BR.getText()),
									Integer.parseInt(textField_C.getText()),
									Integer.parseInt(textField_CR.getText()));
						}
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									dispose();
									MAIN_GUI frame = new MAIN_GUI();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});
		btnLogin.setBounds(110, 326, 119, 44);
		contentPane.add(btnLogin);

		lblNewLabel = new JLabel("Number Of The Teachers  :");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 239, 19);
		contentPane.add(lblNewLabel);

		textField_Teacher = new JTextField();
		textField_Teacher.setBounds(279, 28, 41, 20);
		textField_Teacher.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(textField_Teacher);
		textField_Teacher.setColumns(10);

		JLabel lblCLevelClasses = new JLabel("Number Of -C- Level Classes  :");
		lblCLevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCLevelClasses.setBackground(SystemColor.activeCaption);
		lblCLevelClasses.setBounds(10, 186, 259, 21);
		contentPane.add(lblCLevelClasses);

		JLabel lblCRLevelClasses = new JLabel("Number Of -CR- Level Classes  :");
		lblCRLevelClasses.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCRLevelClasses.setBackground(SystemColor.activeCaption);
		lblCRLevelClasses.setBounds(10, 218, 259, 21);
		contentPane.add(lblCRLevelClasses);

		textField_C = new JTextField();
		textField_C.setFont(new Font("Calibri", Font.BOLD, 18));
		textField_C.setColumns(10);
		textField_C.setBounds(279, 186, 41, 20);
		contentPane.add(textField_C);

		textField_CR = new JTextField();
		textField_CR.setFont(new Font("Calibri", Font.BOLD, 18));
		textField_CR.setColumns(10);
		textField_CR.setBounds(279, 220, 41, 20);
		contentPane.add(textField_CR);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 14));
		comboBox.setBounds(10, 267, 106, 20);
		comboBox.addItem("1. Term");
		comboBox.addItem("2. Term");
		comboBox.addItem("3. Term");
		contentPane.add(comboBox);
	}

	static void createClassTerm_2_3(int a, int ar, int b, int br, int c, int cr) {

		for (int i = 0; i < a; i++)
			Classes.A_Term2_CLASS.add(new Classes.A_Term2());

		for (int i = 0; i < ar; i++)
			Classes.AR_Term2_CLASS.add(new Classes.AR_Term2());

		for (int i = 0; i < b; i++)
			Classes.B_CLASS.add(new Classes.B());

		for (int i = 0; i < br; i++)
			Classes.BR_CLASS.add(new Classes.BR());

		for (int i = 0; i < c; i++)
			Classes.C_CLASS.add(new Classes.C());

		for (int i = 0; i < cr; i++)
			Classes.CR_CLASS.add(new Classes.CR());

	}

	static void createClassTerm_1(int a, int ar, int b, int br, int c, int cr) {

		for (int i = 0; i < a; i++)
			Classes.A_CLASS.add(new Classes.A());

		for (int i = 0; i < ar; i++)
			Classes.AR_CLASS.add(new Classes.AR());

		for (int i = 0; i < b; i++)
			Classes.B_CLASS.add(new Classes.B());

		for (int i = 0; i < br; i++)
			Classes.BR_CLASS.add(new Classes.BR());

		for (int i = 0; i < c; i++)
			Classes.C_CLASS.add(new Classes.C());

		for (int i = 0; i < cr; i++)
			Classes.CR_CLASS.add(new Classes.CR());

	}

}
