package project;

import java.awt.Color;
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
	private JButton btnLesson1;
	private JButton btnLesson2;
	private JButton btnLesson3;
	private JButton btnLesson4;
	private JButton btnLesson5;
	private JButton btnLesson6;

	private JComboBox<String> comboBox;
	private JComboBox<String> comboBoxDays;
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

	private boolean toogleB1 = false;
	private boolean toogleB2 = false;
	private boolean toogleB3 = false;
	private boolean toogleB4 = false;
	private boolean toogleB5 = false;
	private boolean toogleB6 = false;

	public MAIN_GUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 813);
		setTitle("TOBB ETU FOREIGN LANGUAGES");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
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
		lblCourses = new JLabel("COURSES *");
		lblCourses.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC,
				12));
		lblCourses.setBounds(441, 131, 102, 14);
		contentPane.add(lblCourses);

		lblOffDays = new JLabel("OFFDAYS");
		lblOffDays.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC,
				12));
		lblOffDays.setBounds(684, 131, 86, 14);
		contentPane.add(lblOffDays);

		JLabel lblCourseType = new JLabel("COURSE TYPE");
		lblCourseType.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblCourseType.setBounds(928, 131, 102, 14);
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
							courseType(), offDay(), lessonHour.getText() });
					//
					Teacher teacher = new Teacher();
					teacher.setName(comboBox.getSelectedItem().toString());
					teacher.setCourseHour(Integer.parseInt(lessonHour.getText()));
					teacher.setCourseHourORG(Integer.parseInt(lessonHour
							.getText()));
					teacher.setRestHour(Integer.parseInt(lessonHour.getText()));
					teacher.setOffDay(comboBoxDays.getSelectedItem().toString());
					teacher.getCourseLevel().addAll(course());
					String offDay = comboBoxDays.getSelectedItem().toString();
					if (radioListenning.isSelected())
						teacher.getLessonType().add("LS");
					if (radioMainCourse.isSelected())
						teacher.getLessonType().add("MC");
					if (radioReading.isSelected())
						teacher.getLessonType().add("RW");
					teacherList.add(teacher);
					//
					int weekDay = 0;

					switch (offDay) {
					case "Monday":
						weekDay = 0;
						break;
					case "Tuesday":
						weekDay = 1;
						break;
					case "Wednesday":
						weekDay = 2;
						break;
					case "Thursday":
						weekDay = 3;
						break;
					case "Friday":
						weekDay = 4;
						break;
					}
					//
					if (toogleB1)
						teacher.getTeacherSchedule()[weekDay][0] = "OFFDAY";
					if (toogleB2)
						teacher.getTeacherSchedule()[weekDay][1] = "OFFDAY";
					if (toogleB3)
						teacher.getTeacherSchedule()[weekDay][2] = "OFFDAY";
					if (toogleB4)
						teacher.getTeacherSchedule()[weekDay][3] = "OFFDAY";
					if (toogleB5)
						teacher.getTeacherSchedule()[weekDay][4] = "OFFDAY";
					if (toogleB6)
						teacher.getTeacherSchedule()[weekDay][5] = "OFFDAY";
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
		programButton = new JButton("MAKE PROGRAM");
		programButton.setBackground(SystemColor.control);
		programButton.setForeground(new Color(255, 0, 0));
		programButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//
				//
				//
				//
				teacherList2.addAll(teacherList);
				Classes c = new Classes();

				if (term.equals("1. Term")) {
					if (A_Term2.control && AR_Term2.control && B.control
							&& BR.control && C.control && CR.control) {

						Print print = new Print();
						try {
							print.printTeacher(teacherList);
							print.printATerm2(Classes.A_Term2_CLASS);
							print.printARTerm2(Classes.AR_Term2_CLASS);
							print.printB(Classes.B_CLASS);
							print.printBR(Classes.BR_CLASS);
							print.printC(Classes.C_CLASS);
							print.printCR(Classes.CR_CLASS);
						} catch (WriteException | BiffException | IOException e1) {
							e1.printStackTrace();
						}
					}
					// /////////////////////////////////////////////////////***********/////////////////////////////////////
				}
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
							INFO_GUI.createClass(c.getALevel(), c.getARLevel(),
									c.getBLevel(), c.getBRLevel(),
									c.getCLevel(), c.getCRLevel());
						}

						if (Classes.A_Term2_CLASS.size() != 0) {
							A_Term2.addMCA(teacherList2);
							A_Term2.addRWA(teacherList2);
							A_Term2.addLSA(teacherList2);
						}
						if (Classes.AR_Term2_CLASS.size() != 0
								&& A_Term2.control) {
							AR_Term2.addMCAR(teacherList2);
							AR_Term2.addRWAR(teacherList2);
							AR_Term2.addLSAR(teacherList2);
						}
						if (Classes.B_CLASS.size() != 0 && A_Term2.control
								&& AR_Term2.control) {
							B.addMCB(teacherList2);
							B.addRWB(teacherList2);
							B.addLSB(teacherList2);

						}
						if (Classes.BR_CLASS.size() != 0 && B.control
								&& BR.control && A_Term2.control
								&& AR_Term2.control) {
							BR.addMCBR(teacherList2);
							BR.addRWBR(teacherList2);
							BR.addLSBR(teacherList2);
						}
						if (Classes.C_CLASS.size() != 0 && B.control
								&& BR.control && C.control && A_Term2.control
								&& AR_Term2.control) {
							C.addMCC(teacherList2);
							C.addRWC(teacherList2);
							C.addLSC(teacherList2);
						}
						if (Classes.CR_CLASS.size() != 0 && B.control
								&& BR.control && C.control && CR.control
								&& A_Term2.control && AR_Term2.control) {
							CR.addMCCR(teacherList2);
							CR.addRWCR(teacherList2);
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
							print.printTeacher(teacherList);
							print.printATerm2(Classes.A_Term2_CLASS);
							print.printARTerm2(Classes.AR_Term2_CLASS);
							print.printB(Classes.B_CLASS);
							print.printBR(Classes.BR_CLASS);
							print.printC(Classes.C_CLASS);
							print.printCR(Classes.CR_CLASS);
						} catch (WriteException | BiffException | IOException e1) {
							e1.printStackTrace();
						}
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
		TOBB.setFont(new Font("Tahoma", Font.BOLD, 15));
		TOBB.setBounds(53, 72, 266, 34);
		contentPane.add(TOBB);

		lblTeachers = new JLabel("TEACHERS :");
		lblTeachers.setFont(new Font("Tempus Sans ITC",
				Font.BOLD | Font.ITALIC, 12));
		lblTeachers.setBounds(37, 233, 109, 14);
		contentPane.add(lblTeachers);

		JLabel lblLessonsHour = new JLabel(
				"Hocanin almasi gereken toplam ders saati  :");
		lblLessonsHour.setBounds(37, 343, 266, 14);
		contentPane.add(lblLessonsHour);

		lessonHour = new JTextField();
		lessonHour.setFont(new Font("Calibri", Font.BOLD, 16));
		lessonHour.setBounds(313, 340, 27, 20);
		contentPane.add(lessonHour);
		lessonHour.setColumns(10);
		// ////////////////////////////////////////////////////////////////////////////////////////
		btnLesson1 = new JButton("LESSON -1-");
		btnLesson1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB1 == false) {
					toogleB1 = true;
					btnLesson1.setBackground(Color.red);
				} else {
					toogleB1 = false;
					btnLesson1.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson1.setBounds(670, 215, 117, 23);
		btnLesson1.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson1);

		btnLesson2 = new JButton("LESSON -2-");
		btnLesson2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB2 == false) {
					toogleB2 = true;
					btnLesson2.setBackground(Color.red);
				} else {
					toogleB2 = false;
					btnLesson2.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson2.setBounds(670, 258, 117, 23);
		btnLesson2.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson2);

		btnLesson3 = new JButton("LESSON -3-");
		btnLesson3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB3 == false) {
					toogleB3 = true;
					btnLesson3.setBackground(Color.red);
				} else {
					toogleB3 = false;
					btnLesson3.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson3.setBounds(670, 297, 117, 23);
		btnLesson3.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson3);

		btnLesson4 = new JButton("LESSON -4-");
		btnLesson4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB4 == false) {
					toogleB4 = true;
					btnLesson4.setBackground(Color.red);
				} else {
					toogleB4 = false;
					btnLesson4.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson4.setBounds(670, 339, 117, 23);
		btnLesson4.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson4);

		btnLesson5 = new JButton("LESSON -5-");
		btnLesson5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB5 == false) {
					toogleB5 = true;
					btnLesson5.setBackground(Color.red);
				} else {
					toogleB5 = false;
					btnLesson5.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson5.setBounds(670, 380, 117, 23);
		btnLesson5.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson5);

		btnLesson6 = new JButton("LESSON -6-");
		btnLesson6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toogleB6 == false) {
					toogleB6 = true;
					btnLesson6.setBackground(Color.red);
				} else {
					toogleB6 = false;
					btnLesson6.setBackground(SystemColor.scrollbar);
				}
			}
		});
		btnLesson6.setBounds(670, 419, 117, 23);
		btnLesson6.setBackground(SystemColor.scrollbar);
		contentPane.add(btnLesson6);

		comboBoxDays = new JComboBox();
		comboBoxDays.setBackground(SystemColor.scrollbar);
		comboBoxDays.setBounds(638, 168, 182, 23);
		comboBoxDays.addItem("Monday");
		comboBoxDays.addItem("Tuesday");
		comboBoxDays.addItem("Wednesday");
		comboBoxDays.addItem("Thursday");
		comboBoxDays.addItem("Friday");
		contentPane.add(comboBoxDays);

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
		toogleB1 = false;
		btnLesson1.setBackground(SystemColor.scrollbar);
		toogleB2 = false;
		btnLesson2.setBackground(SystemColor.scrollbar);
		toogleB3 = false;
		btnLesson3.setBackground(SystemColor.scrollbar);
		toogleB4 = false;
		btnLesson4.setBackground(SystemColor.scrollbar);
		toogleB5 = false;
		btnLesson5.setBackground(SystemColor.scrollbar);
		toogleB6 = false;
		btnLesson6.setBackground(SystemColor.scrollbar);
		comboBoxDays.setSelectedIndex(0);
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
						.isSelected())
				&& (toogleB1 || toogleB2 || toogleB3 || toogleB4 || toogleB5 || toogleB6)
				&& !lessonHour.getText().equals("")

		)
			return true;
		else
			return false;
	}

	/**
	 * @return
	 */
	private String offDay() {
		String offDay = "";

		offDay += comboBoxDays.getSelectedItem().toString() + " - ";
		if (toogleB1)
			offDay += "1. Lesson-";
		if (toogleB2)
			offDay += "2. Lesson-";
		if (toogleB3)
			offDay += "3. Lesson-";
		if (toogleB4)
			offDay += "4. Lesson-";
		if (toogleB5)
			offDay += "5. Lesson-";
		if (toogleB6)
			offDay += "6. Lesson-";

		if (offDay.charAt(offDay.length() - 1) == '-')
			offDay = (String) offDay.subSequence(0, offDay.lastIndexOf('-'));
		return offDay;
	}

	protected static String term;
	private static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	private static ArrayList<Teacher> teacherList2 = new ArrayList<Teacher>();

}