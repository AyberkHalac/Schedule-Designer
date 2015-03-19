package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * @author AyberkHalac
 *
 */
@SuppressWarnings({ "serial", "unused", "rawtypes", "unchecked" })
public class MAIN_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JScrollPane scrollpane;

	private JButton programButton;

	private JComboBox<String> comboBox;
	private MutableComboBoxModel mCmodel;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnAr;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnCr;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnBr;
	private JRadioButton radioMainCourse;
	private JRadioButton radioReading;
	private JRadioButton radioListenning;

	private JLabel icon;

	private JLabel lblCourses;
	private JLabel lblOffDays;
	private JLabel TOBB;
	private JLabel lblTeachers;
	private static int numberOfTeachers;
	private JTextField lessonHour;

	public MAIN_GUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 813);
		setTitle("TOBB ETU FOREIGN LANGUAGES");
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		icon = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(
				"/images/tobbSymbol.png")).getImage();
		icon.setIcon(new ImageIcon(img));
		icon.setBounds(76, 72, 182, 194);
		contentPane.add(icon);

		// ////////////////////////////////////COMBO_BOX/////////////////////////////////////////////
		comboBox = new<String> JComboBox();
		mCmodel = (MutableComboBoxModel) comboBox.getModel();
		comboBox.setBackground(SystemColor.scrollbar);
		comboBox.setBounds(37, 258, 303, 34);
		contentPane.add(comboBox);
		IO_ops();
		// ///////////////////////////////////PAST_COURSES_RadioButton///////////////////////////////
		rdbtnA = new JRadioButton("A");
		rdbtnA.setBackground(SystemColor.scrollbar);
		rdbtnA.setBounds(460, 168, 48, 23);
		contentPane.add(rdbtnA);

		rdbtnAr = new JRadioButton("AR");
		rdbtnAr.setBackground(SystemColor.scrollbar);
		rdbtnAr.setBounds(460, 215, 48, 23);
		contentPane.add(rdbtnAr);

		rdbtnB = new JRadioButton("B");
		rdbtnB.setBackground(SystemColor.scrollbar);
		rdbtnB.setBounds(460, 264, 48, 23);
		contentPane.add(rdbtnB);

		rdbtnBr = new JRadioButton("BR");
		rdbtnBr.setBackground(SystemColor.scrollbar);
		rdbtnBr.setBounds(460, 312, 48, 23);
		contentPane.add(rdbtnBr);

		rdbtnC = new JRadioButton("C");
		rdbtnC.setBackground(SystemColor.scrollbar);
		rdbtnC.setBounds(460, 358, 48, 23);
		contentPane.add(rdbtnC);

		rdbtnCr = new JRadioButton("CR");
		rdbtnCr.setBackground(SystemColor.scrollbar);
		rdbtnCr.setBounds(460, 404, 48, 23);
		contentPane.add(rdbtnCr);
		// ///////////////////////////////////LABELS/////////////////////////////////////////////////
		lblCourses = new JLabel("COURSES");
		lblCourses.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC,
				12));
		lblCourses.setBounds(449, 131, 102, 14);
		contentPane.add(lblCourses);

		lblOffDays = new JLabel("OFFDAYS");
		lblOffDays.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC,
				12));
		lblOffDays.setBounds(692, 131, 86, 26);
		contentPane.add(lblOffDays);

		JLabel lblCourseType = new JLabel("COURSE TYPE");
		lblCourseType.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblCourseType.setBounds(937, 131, 102, 14);
		contentPane.add(lblCourseType);
		// ///////////////////////////////////TBL_FILES///////////////////////////////////////////////
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Name");
		model.addColumn("Course Levels");
		model.addColumn("Courses");
		model.addColumn("Off Days / Hours");
		model.addColumn("Total Lessons");

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(37, 483, 947, 263);
		contentPane.add(scrollpane);
		// ////////////////////////////SAVE_BUTTON////////////////////////////////////////////////////
		JButton saveButton = new JButton("SAVE");
		saveButton.setForeground(new Color(0, 0, 51));
		saveButton.setBackground(new Color(153, 153, 255));
		saveButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReady()) {

					model.addRow(new Object[] {
							comboBox.getSelectedItem().toString(), courses(),
							courseType(), "OFFDAYS", lessonHour.getText() });
					//
					Teacher teacher = new Teacher();
					teacher.setName(comboBox.getSelectedItem().toString());
					teacher.setCourseHour(Integer.parseInt(lessonHour.getText()));
					teacher.setCourseHourORG(Integer.parseInt(lessonHour
							.getText()));
					teacher.setRestHour(Integer.parseInt(lessonHour.getText()));
					teacher.getCourseLevel().addAll(course());
					if (radioListenning.isSelected())
						teacher.getLessonType().add("LS");
					if (radioMainCourse.isSelected())
						teacher.getLessonType().add("MC");
					if (radioReading.isSelected())
						teacher.getLessonType().add("RW");
					teacherList.add(teacher);
					//
					int weekDay = 0;
					for (int i = 0; i < 6; i++)
						for (int j = 0; j < 5; j++)
							teacher.getTeacherSchedule()[j][i] = Offdays.teacherSchedule[j][i];
					//
					for (int j = 0; j < 6; j++) {
						for (int k = 0; k < 5; k++) {
							Offdays.teacherSchedule[k][j] = null;
						}
					}
					//
					reset();
					//
					if (mCmodel.getSize() == 0) {
						programButton.setEnabled(true);
						saveButton.setEnabled(false);
					}
				}

			}
		});
		saveButton.setBounds(1177, 220, 117, 72);
		contentPane.add(saveButton);
		/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
		programButton = new JButton("BUILD SCHEDULE");
		programButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		programButton.setBackground(new Color(255, 153, 153));
		programButton.setForeground(new Color(255, 0, 0));
		programButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				teacherList2.addAll(teacherList);
				Classes c = new Classes();

				if (term.equals("1. Term")) {
					// int counter = 0;
					// do {
					// if (A.control == false || AR.control == false
					// || B.control == false || BR.control == false
					// || C.control == false || CR.control == false) {
					//
					// for (Teacher teacher : teacherList) {
					// for (int j = 0; j < 6; j++) {
					// for (int k = 0; k < 5; k++) {
					// if (teacher.getTeacherSchedule()[k][j] != null
					// || !(teacher
					// .getTeacherSchedule()[k][j] == "OFFDAY")) {
					// teacher.getTeacherSchedule()[k][j] = null;
					// }
					// }
					// }
					//
					// teacher.setCourseHour(teacher
					// .getCourseHourORG());
					// teacher.setRestHour(0);
					// }
					// teacherList2.clear();
					// teacherList2.addAll(teacherList);
					//
					// Classes.A_CLASS.clear();
					// Classes.AR_CLASS.clear();
					// Classes.B_CLASS.clear();
					// Classes.BR_CLASS.clear();
					// Classes.C_CLASS.clear();
					// Classes.CR_CLASS.clear();
					// A.control = true;
					// AR.control = true;
					// B.control = true;
					// BR.control = true;
					// C.control = true;
					// CR.control = true;
					//
					// INFO_GUI.createClassTerm_2_3(c.getALevel(),
					// c.getARLevel(), c.getBLevel(),
					// c.getBRLevel(), c.getCLevel(),
					// c.getCRLevel());
					// }
					//
					// if (Classes.A_CLASS.size() != 0) {
					// A.addMCA(teacherList2);
					// A.addRWA(teacherList2);
					// A.addLSA(teacherList2);
					// }
					// if (Classes.AR_CLASS.size() != 0 && A.control) {
					// AR.addMCAR(teacherList2);
					// AR.addRWAR(teacherList2);
					// AR.addLSAR(teacherList2);
					// }
					// if (Classes.B_CLASS.size() != 0 && A.control
					// && AR.control && B.control && C.control
					// && BR.control) {
					// B.addMCB(teacherList2);
					// B.addRWB(teacherList2);
					// B.addLSB(teacherList2);
					// }
					// if (Classes.BR_CLASS.size() != 0 && A.control
					// && AR.control && B.control) {
					// BR.addMCBR(teacherList2);
					// BR.addRWBR(teacherList2);
					// BR.addLSBR(teacherList2);
					// }
					// if (Classes.C_CLASS.size() != 0 && A.control
					// && AR.control && B.control && BR.control) {
					// C.addMCC(teacherList2);
					// C.addRWC(teacherList2);
					// C.addLSC(teacherList2);
					// }
					// if (Classes.CR_CLASS.size() != 0 && A.control
					// && AR.control && B.control && C.control
					// && BR.control) {
					// CR.addMCCR(teacherList2);
					// CR.addRWCR(teacherList2);
					// CR.addLSCR(teacherList2);
					// }
					//
					// if (counter == 40)
					// break;
					// else {
					// counter++;
					//
					// }
					// } while (A.control == false || AR.control == false
					// || B.control == false || BR.control == false
					// || C.control == false || CR.control == false);
					//
					// if (A.control && AR.control && B.control && BR.control
					// && C.control && CR.control) {
					//
					// Print print = new Print();
					// try {
					// JOptionPane
					// .showMessageDialog(null,
					// "Please, wait! Evaluating Available Possibilities");
					// print.printTeacher(teacherList);
					// print.printA(Classes.A_CLASS);
					// print.printAR(Classes.AR_CLASS);
					// print.printB(Classes.B_CLASS);
					// print.printBR(Classes.BR_CLASS);
					// print.printC(Classes.C_CLASS);
					// print.printCR(Classes.CR_CLASS);
					// JOptionPane.showMessageDialog(null,
					// "Done! Please open C:\\Schedule");
					// } catch (WriteException | BiffException | IOException e1)
					// {
					// e1.printStackTrace();
					// }
					// } else {
					// JOptionPane
					// .showMessageDialog(null,
					// "There is no option to make program. Plase start again.");
					// }

				}
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
				/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/

				if (term.equals("2. Term") || term.equals("3. Term")) {

					int counter = 0;
					do {
						if (A_Term2.control == false
								|| AR_Term2.control == false
								|| B.control == false || BR.control == false
								|| C.control == false || CR.control == false) {

							for (Teacher teacher : teacherList) {
								for (int j = 0; j < 6; j++) {
									for (int k = 0; k < 5; k++) {
										if (teacher.getTeacherSchedule()[k][j] != null
												|| !(teacher
														.getTeacherSchedule()[k][j] == "OFFDAY")) {
											teacher.getTeacherSchedule()[k][j] = null;
										}
									}
								}

								teacher.setCourseHour(teacher
										.getCourseHourORG());
								teacher.setRestHour(0);
							}
							teacherList2.clear();
							teacherList2.addAll(teacherList);

							Classes.A_Term2_CLASS.clear();
							Classes.AR_Term2_CLASS.clear();
							Classes.B_CLASS.clear();
							Classes.BR_CLASS.clear();
							Classes.C_CLASS.clear();
							Classes.CR_CLASS.clear();
							A_Term2.control = true;
							AR_Term2.control = true;
							B.control = true;
							BR.control = true;
							C.control = true;
							CR.control = true;
							INFO_GUI.createClassTerm_2_3(c.getALevel(),
									c.getARLevel(), c.getBLevel(),
									c.getBRLevel(), c.getCLevel(),
									c.getCRLevel());
						}

						if (Classes.A_Term2_CLASS.size() != 0) {
							A_Term2.addMCA(teacherList2);
							if (A_Term2.control)
								A_Term2.addRWA(teacherList2);
							if (A_Term2.control)
								A_Term2.addLSA(teacherList2);
						}
						if (Classes.AR_Term2_CLASS.size() != 0
								&& A_Term2.control) {
							AR_Term2.addMCAR(teacherList2);
							if (AR_Term2.control)
								AR_Term2.addRWAR(teacherList2);
							if (AR_Term2.control)
								AR_Term2.addLSAR(teacherList2);
						}
						if (Classes.B_CLASS.size() != 0 && A_Term2.control
								&& AR_Term2.control) {
							B.addMCB(teacherList2);
							if (B.control)
								B.addRWB(teacherList2);
							if (B.control)
								B.addLSB(teacherList2);

						}
						if (Classes.BR_CLASS.size() != 0 && B.control
								&& BR.control && A_Term2.control
								&& AR_Term2.control) {
							BR.addMCBR(teacherList2);
							if (BR.control)
								BR.addRWBR(teacherList2);
							if (BR.control)
								BR.addLSBR(teacherList2);
						}
						if (Classes.C_CLASS.size() != 0 && B.control
								&& BR.control && C.control && A_Term2.control
								&& AR_Term2.control) {
							C.addMCC(teacherList2);
							if (C.control)
								C.addRWC(teacherList2);
							if (C.control)
								C.addLSC(teacherList2);
						}
						if (Classes.CR_CLASS.size() != 0 && B.control
								&& BR.control && C.control && CR.control
								&& A_Term2.control && AR_Term2.control) {
							CR.addMCCR(teacherList2);
							if (CR.control)
								CR.addRWCR(teacherList2);
							if (CR.control)
								CR.addLSCR(teacherList2);
						}

						if (counter == 40)
							break;
						else {
							counter++;

						}
					} while (A_Term2.control == false
							|| AR_Term2.control == false || B.control == false
							|| BR.control == false || C.control == false
							|| CR.control == false);

					if (A_Term2.control && AR_Term2.control && B.control
							&& BR.control && C.control && CR.control) {

						Print print = new Print();
						try {
							JOptionPane
									.showMessageDialog(null,
											"Please, wait! Evaluating Available Possibilities");
							print.printTeacher(teacherList);
							print.printATerm2(Classes.A_Term2_CLASS);
							print.printARTerm2(Classes.AR_Term2_CLASS);
							print.printB(Classes.B_CLASS);
							print.printBR(Classes.BR_CLASS);
							print.printC(Classes.C_CLASS);
							print.printCR(Classes.CR_CLASS);
							JOptionPane.showMessageDialog(null,
									"Done! Please open C:\\Schedule");
						} catch (WriteException | BiffException | IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"There is no option to make program. Plase start again.");

					}
				}

			}

		});
		programButton.setBounds(1099, 547, 170, 71);
		programButton.setEnabled(false);
		contentPane.add(programButton);
		/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
		radioMainCourse = new JRadioButton("Main Course");
		radioMainCourse.setBackground(SystemColor.scrollbar);
		radioMainCourse.setBounds(918, 168, 158, 23);
		contentPane.add(radioMainCourse);

		radioListenning = new JRadioButton("Listening & Speaking");
		radioListenning.setBackground(SystemColor.scrollbar);
		radioListenning.setBounds(918, 215, 158, 23);
		contentPane.add(radioListenning);

		radioReading = new JRadioButton("Reading & Writing");
		radioReading.setBackground(SystemColor.scrollbar);
		radioReading.setBounds(918, 264, 158, 23);
		contentPane.add(radioReading);

		TOBB = new JLabel("Department of Foreign Languages");
		TOBB.setVerticalAlignment(SwingConstants.BOTTOM);
		TOBB.setFont(new Font("Tahoma", Font.BOLD, 17));
		TOBB.setBounds(37, 58, 375, 34);
		contentPane.add(TOBB);

		lblTeachers = new JLabel("TEACHERS :");
		lblTeachers.setFont(new Font("Tempus Sans ITC",
				Font.BOLD | Font.ITALIC, 12));
		lblTeachers.setBounds(37, 233, 109, 14);
		contentPane.add(lblTeachers);

		JLabel lblLessonsHour = new JLabel("Total Lesson Hour :");
		lblLessonsHour.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLessonsHour.setBounds(37, 343, 140, 14);
		contentPane.add(lblLessonsHour);

		lessonHour = new JTextField();
		lessonHour.setFont(new Font("Calibri", Font.BOLD, 16));
		lessonHour.setBounds(226, 341, 43, 20);
		contentPane.add(lessonHour);
		lessonHour.setColumns(10);

		JButton btnNewButton = new JButton("OFFDAYS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Offdays frame = new Offdays();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

		});
		btnNewButton.setBounds(675, 198, 89, 40);
		contentPane.add(btnNewButton);

	}

	/**
	 * 
	 */
	private void reset() {
		rdbtnA.setSelected(false);
		rdbtnAr.setSelected(false);
		rdbtnB.setSelected(false);
		rdbtnBr.setSelected(false);
		rdbtnC.setSelected(false);
		rdbtnCr.setSelected(false);
		radioMainCourse.setSelected(false);
		radioReading.setSelected(false);
		radioListenning.setSelected(false);
		lessonHour.setText("");
		mCmodel.removeElement(mCmodel.getSelectedItem());
		if (mCmodel.getSize() != 0)
			comboBox.setSelectedIndex(0);
	}

	/**
	 * 
	 * @throws IOException
	 */
	private synchronized void IO_ops() throws IOException {

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"C:/Schedule/teacher_info.txt"));
			// IT
			String line;
			while ((line = in.readLine()) != null) {

				((MutableComboBoxModel) mCmodel).addElement(line);

			}
			in.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "FILE NOT FOUND");
			e.printStackTrace();
		}

	}

	/**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**
	 * 
	 * @return
	 */
	static int getNumberOfTeachers() {
		return numberOfTeachers;
	}

	/**
	 * @param numberOfTeachers
	 */
	static void setNumberOfTeachers(int numberOfTeachers) {
		MAIN_GUI.numberOfTeachers = numberOfTeachers;
	}

	/**
	 * @return
	 */
	private String courseType() {
		String courseType = "";
		if (radioListenning.isSelected())
			courseType += "Listening & Speaking-";
		if (radioMainCourse.isSelected())
			courseType += "Main Course-";
		if (radioReading.isSelected())
			courseType += "Reading & Writing-";
		if (courseType.charAt(courseType.length() - 1) == '-')
			courseType = (String) courseType.subSequence(0,
					courseType.lastIndexOf('-'));
		return courseType;

	}

	/**
	 * @return
	 */
	private String courses() {
		String courses = "";
		if (rdbtnA.isSelected())
			courses += "A-";
		if (rdbtnAr.isSelected())
			courses += "AR-";
		if (rdbtnB.isSelected())
			courses += "B-";
		if (rdbtnBr.isSelected())
			courses += "BR-";
		if (rdbtnC.isSelected())
			courses += "C-";
		if (rdbtnCr.isSelected())
			courses += "CR-";
		if (courses.charAt(courses.length() - 1) == '-')
			courses = (String) courses.subSequence(0, courses.lastIndexOf('-'));
		return courses;

	}

	/**
	 * @return
	 */
	private ArrayList<String> course() {
		ArrayList<String> List = new ArrayList<String>();
		if (rdbtnA.isSelected())
			List.add("A");
		if (rdbtnAr.isSelected())
			List.add("AR");
		if (rdbtnB.isSelected())
			List.add("B");
		if (rdbtnBr.isSelected())
			List.add("BR");
		if (rdbtnC.isSelected())
			List.add("C");
		if (rdbtnCr.isSelected())
			List.add("CR");
		return List;

	}

	/**
	 * @return
	 */
	private boolean isReady() {
		if ((rdbtnA.isSelected() || rdbtnAr.isSelected() || rdbtnB.isSelected()
				|| rdbtnBr.isSelected() || rdbtnC.isSelected() || rdbtnCr
					.isSelected())
				&& (radioMainCourse.isSelected() || radioReading.isSelected() || radioListenning
						.isSelected()) && !lessonHour.getText().equals("")

		)
			return true;
		else
			return false;
	}

	protected static String term;
	private static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	private static ArrayList<Teacher> teacherList2 = new ArrayList<Teacher>();
}