package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Alignment;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@SuppressWarnings("deprecation")
public class Print {
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	protected void set() throws FileNotFoundException,
			UnsupportedEncodingException {
		File file = new File("C:\\Schedule");
		if (!file.exists()) {
			if (file.mkdir())
				JOptionPane.showMessageDialog(null, "Directory is created!");
			else
				JOptionPane.showMessageDialog(null,
						"Failed to create directory!");

		}
		File text = new File("C:/Schedule/teacher_info.txt");
		if (!text.exists()) {
			PrintWriter writer = new PrintWriter(text, "UTF-8");
			JOptionPane.showMessageDialog(null, "Textfield is created!");
			writer.close();
		}
	}

	/**
	 * 
	 * @param teacherList
	 * @throws IOException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printTeacher(ArrayList<Teacher> teacherList)
			throws IOException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Teacher teacher : teacherList) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + teacher.getName() + ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, teacher.getName());
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4,
							teacher.getTeacherSchedule()[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);

					sheet.addCell(label);
				}

			}
			copy.write();
			copy.close();
		}

		workbook.close();

	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printATerm2(ArrayList<Classes.A_Term2> classes)
			throws IOException, RowsExceededException, WriteException,
			BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.A_Term2 cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(
					new File("C:\\Schedule\\" + "A-"
							+ Classes.A_Term2_CLASS.indexOf(cls) + ".xls"),
					workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "A-"
					+ Classes.A_Term2_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
		workbook.close();
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printARTerm2(ArrayList<Classes.AR_Term2> classes)
			throws IOException, RowsExceededException, WriteException,
			BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.AR_Term2 cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(
					new File("C:\\Schedule\\" + "AR-"
							+ Classes.AR_Term2_CLASS.indexOf(cls) + ".xls"),
					workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "AR-"
					+ Classes.AR_Term2_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printB(ArrayList<Classes.B> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.B cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "B-" + Classes.B_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "B-" + Classes.B_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
		workbook.close();
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printBR(ArrayList<Classes.BR> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.BR cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "BR-" + Classes.BR_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "BR-" + Classes.BR_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printC(ArrayList<Classes.C> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.C cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "C-" + Classes.C_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "C-" + Classes.C_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printCR(ArrayList<Classes.CR> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.CR cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "CR-" + Classes.CR_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "CR-" + Classes.CR_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printA(ArrayList<Classes.A> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.A cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "A-" + Classes.A_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "A-" + Classes.A_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}

	/**
	 * @param classes
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	protected void printAR(ArrayList<Classes.AR> classes) throws IOException,
			RowsExceededException, WriteException, BiffException {
		Workbook workbook = Workbook.getWorkbook(new File(
				"Teacher_ORIGINAL.xls"));
		for (Classes.AR cls : classes) {
			WritableWorkbook copy = Workbook.createWorkbook(new File(
					"C:\\Schedule\\" + "AR-" + Classes.AR_CLASS.indexOf(cls)
							+ ".xls"), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label name = new Label(1, 1, "AR-" + Classes.AR_CLASS.indexOf(cls));
			WritableCellFormat nameFormat = new WritableCellFormat();
			nameFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			name.setCellFormat(nameFormat);
			sheet.addCell(name);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 5; k++) {
					Label label = new Label(k + 1, j + 4, cls.schedule[k][j]);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setBackground(Colour.ICE_BLUE);
					cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					label.setCellFormat(cellFormat);
					sheet.addCell(label);

				}

			}
			copy.write();
			copy.close();
		}
	}
}
