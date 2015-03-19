package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Offdays extends JFrame {

	private JPanel Panel;
	private static JButton btnMon1, btnMon2, btnMon3, btnMon4, btnMon5,
			btnMon6;
	private static JButton btnTues1, btnTues2, btnTues3, btnTues4, btnTues5,
			btnTues6;
	private static JButton btnWed1, btnWed2, btnWed3, btnWed4, btnWed5,
			btnWed6;
	private static JButton btnThur1, btnThur2, btnThur3, btnThur4, btnThur5,
			btnThur6;
	private static JButton btnFri1, btnFri2, btnFri3, btnFri4, btnFri5,
			btnFri6;

	private static boolean toggleMon1 = false;
	private static boolean toggleMon2 = false;
	private static boolean toggleMon3 = false;
	private static boolean toggleMon4 = false;
	private static boolean toggleMon5 = false;
	private static boolean toggleMon6 = false;

	private static boolean toggleTues1 = false;
	private static boolean toggleTues2 = false;
	private static boolean toggleTues3 = false;
	private static boolean toggleTues4 = false;
	private static boolean toggleTues5 = false;
	private static boolean toggleTues6 = false;

	private static boolean toggleWed1 = false;
	private static boolean toggleWed2 = false;
	private static boolean toggleWed3 = false;
	private static boolean toggleWed4 = false;
	private static boolean toggleWed5 = false;
	private static boolean toggleWed6 = false;

	private static boolean toggleThur1 = false;
	private static boolean toggleThur2 = false;
	private static boolean toggleThur3 = false;
	private static boolean toggleThur4 = false;
	private static boolean toggleThur5 = false;
	private static boolean toggleThur6 = false;

	private static boolean toggleFri1 = false;
	private static boolean toggleFri2 = false;
	private static boolean toggleFri3 = false;
	private static boolean toggleFri4 = false;
	private static boolean toggleFri5 = false;
	private static boolean toggleFri6 = false;

	protected static String[][] teacherSchedule = new String[5][6];

	/**
	 * Create the frame.
	 */
	public Offdays() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 405);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);

		btnMon1 = new JButton("1");
		btnMon1.setBackground(SystemColor.scrollbar);
		btnMon1.setForeground(Color.BLACK);
		btnMon1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon1) {
					toggleMon1 = false;
					btnMon1.setBackground(SystemColor.scrollbar);
				} else {
					toggleMon1 = true;
					btnMon1.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnMon1.setBounds(43, 67, 89, 23);
		Panel.add(btnMon1);

		btnMon2 = new JButton("2");
		btnMon2.setBackground(SystemColor.scrollbar);
		btnMon2.setForeground(Color.BLACK);
		btnMon2.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon2) {
					toggleMon2 = false;
					btnMon2.setBackground(SystemColor.scrollbar);
				} else {
					toggleMon2 = true;
					btnMon2.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnMon2.setBounds(43, 101, 89, 23);
		Panel.add(btnMon2);

		btnMon3 = new JButton("3");
		btnMon3.setBackground(SystemColor.scrollbar);
		btnMon3.setForeground(Color.BLACK);
		btnMon3.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon3) {
					toggleMon3 = false;
					btnMon3.setBackground(SystemColor.scrollbar);
				} else {
					toggleMon3 = true;
					btnMon3.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnMon3.setBounds(43, 135, 89, 23);
		Panel.add(btnMon3);

		btnMon4 = new JButton("4");
		btnMon4.setBackground(SystemColor.scrollbar);
		btnMon4.setForeground(Color.BLACK);
		btnMon4.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon4) {
					toggleMon4 = false;
					btnMon4.setBackground(SystemColor.scrollbar);
				} else {
					toggleMon4 = true;
					btnMon4.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnMon4.setBounds(43, 169, 89, 23);
		Panel.add(btnMon4);

		btnMon5 = new JButton("5");
		btnMon5.setBackground(SystemColor.scrollbar);
		btnMon5.setForeground(Color.BLACK);
		btnMon5.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon5) {
					toggleMon5 = false;
					btnMon5.setBackground(SystemColor.scrollbar);
				} else {
					toggleMon5 = true;
					btnMon5.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnMon5.setBounds(43, 203, 89, 23);
		Panel.add(btnMon5);

		btnMon6 = new JButton("6");
		btnMon6.setBackground(SystemColor.scrollbar);
		btnMon6.setForeground(Color.BLACK);
		btnMon6.setFont(new Font("Verdana", Font.BOLD, 14));
		btnMon6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleMon6) {
					btnMon6.setBackground(SystemColor.scrollbar);
					toggleMon6 = false;
				} else {
					toggleMon6 = true;
					btnMon6.setBackground(new Color(255, 0, 0));
				}
			}
		});

		btnMon6.setBounds(43, 237, 89, 23);
		Panel.add(btnMon6);

		btnTues1 = new JButton("1");
		btnTues1.setBackground(SystemColor.scrollbar);
		btnTues1.setForeground(Color.BLACK);
		btnTues1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues1) {
					toggleTues1 = false;
					btnTues1.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues1 = true;
					btnTues1.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues1.setBounds(172, 67, 89, 23);
		Panel.add(btnTues1);

		btnTues2 = new JButton("2");
		btnTues2.setBackground(SystemColor.scrollbar);
		btnTues2.setForeground(Color.BLACK);
		btnTues2.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues2) {
					toggleTues2 = false;
					btnTues2.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues2 = true;
					btnTues2.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues2.setBounds(172, 101, 89, 23);
		Panel.add(btnTues2);

		btnTues3 = new JButton("3");
		btnTues3.setBackground(SystemColor.scrollbar);
		btnTues3.setForeground(Color.BLACK);
		btnTues3.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues3) {
					toggleTues3 = false;
					btnTues3.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues3 = true;
					btnTues3.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues3.setBounds(172, 135, 89, 23);
		Panel.add(btnTues3);

		btnTues4 = new JButton("4");
		btnTues4.setBackground(SystemColor.scrollbar);
		btnTues4.setForeground(Color.BLACK);
		btnTues4.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues4) {
					toggleTues4 = false;
					btnTues4.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues4 = true;
					btnTues4.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues4.setBounds(172, 169, 89, 23);
		Panel.add(btnTues4);

		btnTues5 = new JButton("5");
		btnTues5.setBackground(SystemColor.scrollbar);
		btnTues5.setForeground(Color.BLACK);
		btnTues5.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues5) {
					toggleTues5 = false;
					btnTues5.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues5 = true;
					btnTues5.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues5.setBounds(172, 203, 89, 23);
		Panel.add(btnTues5);

		btnTues6 = new JButton("6");
		btnTues6.setBackground(SystemColor.scrollbar);
		btnTues6.setForeground(Color.BLACK);
		btnTues6.setFont(new Font("Verdana", Font.BOLD, 14));
		btnTues6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleTues6) {
					toggleTues6 = false;
					btnTues6.setBackground(SystemColor.scrollbar);
				} else {
					toggleTues6 = true;
					btnTues6.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnTues6.setBounds(172, 237, 89, 23);
		Panel.add(btnTues6);

		btnWed1 = new JButton("1");
		btnWed1.setBackground(SystemColor.scrollbar);
		btnWed1.setForeground(Color.BLACK);
		btnWed1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed1) {
					toggleWed1 = false;
					btnWed1.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed1 = true;
					btnWed1.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed1.setBounds(301, 67, 89, 23);
		Panel.add(btnWed1);

		btnWed2 = new JButton("2");
		btnWed2.setBackground(SystemColor.scrollbar);
		btnWed2.setForeground(Color.BLACK);
		btnWed2.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed2) {
					toggleWed2 = false;
					btnWed2.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed2 = true;
					btnWed2.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed2.setBounds(301, 101, 89, 23);
		Panel.add(btnWed2);

		btnWed3 = new JButton("3");
		btnWed3.setBackground(SystemColor.scrollbar);
		btnWed3.setForeground(Color.BLACK);
		btnWed3.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed3) {
					toggleWed3 = false;
					btnWed3.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed3 = true;
					btnWed3.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed3.setBounds(301, 135, 89, 23);
		Panel.add(btnWed3);

		btnWed4 = new JButton("4");
		btnWed4.setBackground(SystemColor.scrollbar);
		btnWed4.setForeground(Color.BLACK);
		btnWed4.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed4) {
					toggleWed4 = false;
					btnWed4.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed4 = true;
					btnWed4.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed4.setBounds(301, 169, 89, 23);
		Panel.add(btnWed4);

		btnWed5 = new JButton("5");
		btnWed5.setBackground(SystemColor.scrollbar);
		btnWed5.setForeground(Color.BLACK);
		btnWed5.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed5) {
					toggleWed5 = false;
					btnWed5.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed5 = true;
					btnWed5.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed5.setBounds(301, 203, 89, 23);
		Panel.add(btnWed5);

		btnWed6 = new JButton("6");
		btnWed6.setBackground(SystemColor.scrollbar);
		btnWed6.setForeground(Color.BLACK);
		btnWed6.setFont(new Font("Verdana", Font.BOLD, 14));
		btnWed6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleWed6) {
					toggleWed6 = false;
					btnWed6.setBackground(SystemColor.scrollbar);
				} else {
					toggleWed6 = true;
					btnWed6.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnWed6.setBounds(301, 237, 89, 23);
		Panel.add(btnWed6);

		btnThur1 = new JButton("1");
		btnThur1.setBackground(SystemColor.scrollbar);
		btnThur1.setForeground(Color.BLACK);
		btnThur1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur1) {
					toggleThur1 = false;
					btnThur1.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur1 = true;
					btnThur1.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur1.setBounds(428, 67, 89, 23);
		Panel.add(btnThur1);

		btnThur2 = new JButton("2");
		btnThur2.setBackground(SystemColor.scrollbar);
		btnThur2.setForeground(Color.BLACK);
		btnThur2.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur2) {
					toggleThur2 = false;
					btnThur2.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur2 = true;
					btnThur2.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur2.setBounds(428, 101, 89, 23);
		Panel.add(btnThur2);

		btnThur3 = new JButton("3");
		btnThur3.setBackground(SystemColor.scrollbar);
		btnThur3.setForeground(Color.BLACK);
		btnThur3.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur3) {
					toggleThur3 = false;
					btnThur3.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur3 = true;
					btnThur3.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur3.setBounds(428, 135, 89, 23);
		Panel.add(btnThur3);

		btnThur4 = new JButton("4");
		btnThur4.setBackground(SystemColor.scrollbar);
		btnThur4.setForeground(Color.BLACK);
		btnThur4.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur4) {
					toggleThur4 = false;
					btnThur4.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur4 = true;
					btnThur4.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur4.setBounds(428, 169, 89, 23);
		Panel.add(btnThur4);

		btnThur5 = new JButton("5");
		btnThur5.setBackground(SystemColor.scrollbar);
		btnThur5.setForeground(Color.BLACK);
		btnThur5.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur5) {
					toggleThur5 = false;
					btnThur5.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur5 = true;
					btnThur5.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur5.setBounds(428, 203, 89, 23);
		Panel.add(btnThur5);

		btnThur6 = new JButton("6");
		btnThur6.setBackground(SystemColor.scrollbar);
		btnThur6.setForeground(Color.BLACK);
		btnThur6.setFont(new Font("Verdana", Font.BOLD, 14));
		btnThur6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleThur6) {
					toggleThur6 = false;
					btnThur6.setBackground(SystemColor.scrollbar);
				} else {
					toggleThur6 = true;
					btnThur6.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnThur6.setBounds(428, 237, 89, 23);
		Panel.add(btnThur6);

		btnFri1 = new JButton("1");
		btnFri1.setBackground(SystemColor.scrollbar);
		btnFri1.setForeground(Color.BLACK);
		btnFri1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri1) {
					toggleFri1 = false;
					btnFri1.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri1 = true;
					btnFri1.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri1.setBounds(555, 67, 89, 23);
		Panel.add(btnFri1);

		btnFri2 = new JButton("2");
		btnFri2.setBackground(SystemColor.scrollbar);
		btnFri2.setForeground(Color.BLACK);
		btnFri2.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri2) {
					toggleFri2 = false;
					btnFri2.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri2 = true;
					btnFri2.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri2.setBounds(555, 101, 89, 23);
		Panel.add(btnFri2);

		btnFri3 = new JButton("3");
		btnFri3.setBackground(SystemColor.scrollbar);
		btnFri3.setForeground(Color.BLACK);
		btnFri3.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri3) {
					toggleFri3 = false;
					btnFri3.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri3 = true;
					btnFri3.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri3.setBounds(555, 135, 89, 23);
		Panel.add(btnFri3);

		btnFri4 = new JButton("4");
		btnFri4.setBackground(SystemColor.scrollbar);
		btnFri4.setForeground(Color.BLACK);
		btnFri4.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri4) {
					toggleFri4 = false;
					btnFri4.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri4 = true;
					btnFri4.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri4.setBounds(555, 169, 89, 23);
		Panel.add(btnFri4);

		btnFri5 = new JButton("5");
		btnFri5.setBackground(SystemColor.scrollbar);
		btnFri5.setForeground(Color.BLACK);
		btnFri5.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri5) {
					toggleFri5 = false;
					btnFri5.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri5 = true;
					btnFri5.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri5.setBounds(555, 203, 89, 23);
		Panel.add(btnFri5);

		btnFri6 = new JButton("6");
		btnFri6.setBackground(SystemColor.scrollbar);
		btnFri6.setForeground(Color.BLACK);
		btnFri6.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFri6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleFri6) {
					toggleFri6 = false;
					btnFri6.setBackground(SystemColor.scrollbar);
				} else {
					toggleFri6 = true;
					btnFri6.setBackground(new Color(255, 0, 0));
				}
			}
		});
		btnFri6.setBounds(555, 237, 89, 23);
		Panel.add(btnFri6);

		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setFont(new Font("Verdana", Font.BOLD, 13));
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setBounds(43, 26, 89, 23);
		Panel.add(lblMonday);

		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setFont(new Font("Verdana", Font.BOLD, 13));
		lblTuesday.setBounds(172, 26, 89, 23);
		Panel.add(lblTuesday);

		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setFont(new Font("Verdana", Font.BOLD, 13));
		lblWednesday.setBounds(301, 26, 89, 23);
		Panel.add(lblWednesday);

		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setFont(new Font("Verdana", Font.BOLD, 13));
		lblThursday.setBounds(428, 26, 89, 23);
		Panel.add(lblThursday);

		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setFont(new Font("Verdana", Font.BOLD, 13));
		lblFriday.setBounds(555, 26, 89, 23);
		Panel.add(lblFriday);

		JButton SAVE = new JButton("SAVE");
		SAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set();
				reset();
				dispose();
			}
		});
		SAVE.setFont(new Font("Verdana", Font.BOLD, 14));
		SAVE.setBounds(263, 296, 166, 59);
		Panel.add(SAVE);
	}

	private static void set() {
		if (toggleMon1)
			teacherSchedule[0][0] = "OFFDAY";
		if (toggleMon2)
			teacherSchedule[0][1] = "OFFDAY";
		if (toggleMon3)
			teacherSchedule[0][2] = "OFFDAY";
		if (toggleMon4)
			teacherSchedule[0][3] = "OFFDAY";
		if (toggleMon5)
			teacherSchedule[0][4] = "OFFDAY";
		if (toggleMon6)
			teacherSchedule[0][5] = "OFFDAY";

		if (toggleTues1)
			teacherSchedule[1][0] = "OFFDAY";
		if (toggleTues2)
			teacherSchedule[1][1] = "OFFDAY";
		if (toggleTues3)
			teacherSchedule[1][2] = "OFFDAY";
		if (toggleTues4)
			teacherSchedule[1][3] = "OFFDAY";
		if (toggleTues5)
			teacherSchedule[1][4] = "OFFDAY";
		if (toggleTues6)
			teacherSchedule[1][5] = "OFFDAY";

		if (toggleWed1)
			teacherSchedule[2][0] = "OFFDAY";
		if (toggleWed2)
			teacherSchedule[2][1] = "OFFDAY";
		if (toggleWed3)
			teacherSchedule[2][2] = "OFFDAY";
		if (toggleWed4)
			teacherSchedule[2][3] = "OFFDAY";
		if (toggleWed5)
			teacherSchedule[2][4] = "OFFDAY";
		if (toggleWed6)
			teacherSchedule[2][5] = "OFFDAY";

		if (toggleThur1)
			teacherSchedule[3][0] = "OFFDAY";
		if (toggleThur2)
			teacherSchedule[3][1] = "OFFDAY";
		if (toggleThur3)
			teacherSchedule[3][2] = "OFFDAY";
		if (toggleThur4)
			teacherSchedule[3][3] = "OFFDAY";
		if (toggleThur5)
			teacherSchedule[3][4] = "OFFDAY";
		if (toggleThur6)
			teacherSchedule[3][5] = "OFFDAY";

		if (toggleFri1)
			teacherSchedule[4][0] = "OFFDAY";
		if (toggleFri2)
			teacherSchedule[4][1] = "OFFDAY";
		if (toggleFri3)
			teacherSchedule[4][2] = "OFFDAY";
		if (toggleFri4)
			teacherSchedule[4][3] = "OFFDAY";
		if (toggleFri5)
			teacherSchedule[4][4] = "OFFDAY";
		if (toggleFri6)
			teacherSchedule[4][5] = "OFFDAY";

	}

	private static void reset() {
		btnMon1.setBackground(SystemColor.scrollbar);
		btnMon2.setBackground(SystemColor.scrollbar);
		btnMon3.setBackground(SystemColor.scrollbar);
		btnMon4.setBackground(SystemColor.scrollbar);
		btnMon5.setBackground(SystemColor.scrollbar);
		btnMon6.setBackground(SystemColor.scrollbar);
		btnTues1.setBackground(SystemColor.scrollbar);
		btnTues2.setBackground(SystemColor.scrollbar);
		btnTues3.setBackground(SystemColor.scrollbar);
		btnTues4.setBackground(SystemColor.scrollbar);
		btnTues5.setBackground(SystemColor.scrollbar);
		btnTues6.setBackground(SystemColor.scrollbar);
		btnWed1.setBackground(SystemColor.scrollbar);
		btnWed2.setBackground(SystemColor.scrollbar);
		btnWed3.setBackground(SystemColor.scrollbar);
		btnWed4.setBackground(SystemColor.scrollbar);
		btnWed5.setBackground(SystemColor.scrollbar);
		btnWed6.setBackground(SystemColor.scrollbar);
		btnThur1.setBackground(SystemColor.scrollbar);
		btnThur2.setBackground(SystemColor.scrollbar);
		btnThur3.setBackground(SystemColor.scrollbar);
		btnThur4.setBackground(SystemColor.scrollbar);
		btnThur5.setBackground(SystemColor.scrollbar);
		btnThur6.setBackground(SystemColor.scrollbar);
		btnFri1.setBackground(SystemColor.scrollbar);
		btnFri2.setBackground(SystemColor.scrollbar);
		btnFri3.setBackground(SystemColor.scrollbar);
		btnFri4.setBackground(SystemColor.scrollbar);
		btnFri5.setBackground(SystemColor.scrollbar);
		btnFri6.setBackground(SystemColor.scrollbar);

		toggleMon1 = false;
		toggleMon2 = false;
		toggleMon3 = false;
		toggleMon4 = false;
		toggleMon5 = false;
		toggleMon6 = false;

		toggleTues1 = false;
		toggleTues2 = false;
		toggleTues3 = false;
		toggleTues4 = false;
		toggleTues5 = false;
		toggleTues6 = false;
		toggleWed1 = false;
		toggleWed2 = false;
		toggleWed3 = false;
		toggleWed4 = false;
		toggleWed5 = false;
		toggleWed6 = false;
		toggleThur1 = false;
		toggleThur2 = false;
		toggleThur3 = false;
		toggleThur4 = false;
		toggleThur5 = false;
		toggleThur6 = false;
		toggleFri1 = false;
		toggleFri2 = false;
		toggleFri3 = false;
		toggleFri4 = false;
		toggleFri5 = false;
		toggleFri6 = false;
	}
}
