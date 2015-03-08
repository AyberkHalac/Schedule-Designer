package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {

	private JPanel contentPane;

	private JLabel userName;
	private JLabel password;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel icon;

	private final String ID = "root";
	private final int PASSWORD = 123456;

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TOBB ETU FOREIGN LANGUAGES");
		setBounds(100, 100, 690, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		userName = new JLabel("USERNAME  :");
		userName.setFont(new Font("Calibri", Font.BOLD, 20));
		userName.setBounds(225, 133, 150, 30);
		contentPane.add(userName);

		password = new JLabel("PASSWORD  :");
		password.setFont(new Font("Calibri", Font.BOLD, 20));
		password.setBounds(225, 196, 150, 30);
		contentPane.add(password);

		textField = new JTextField();
		textField.setBounds(385, 129, 200, 40);
		textField.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(385, 192, 200, 40);
		passwordField.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (!textField.getText().toString().equals(ID)
						|| Integer.parseInt(passwordField.getText().toString()) != PASSWORD) {
					JOptionPane.showMessageDialog(null,
							"WRONG ID OR PASSWORD, PLEASE TRY AGAIN");
				} else {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								dispose();
								INFO_GUI frame = new INFO_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnNewButton.setBounds(428, 273, 129, 40);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("PREPARE SCHEDULE");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(216, 29, 304, 40);
		contentPane.add(lblNewLabel);

		icon = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(
				"/images/tobbSymbol.png")).getImage();
		icon.setIcon(new ImageIcon(img));
		icon.setBounds(20, 80, 250, 194);
		contentPane.add(icon);

	}
}
