package project;

import java.util.ArrayList;

public class Teacher {

	int getCourseHour() {
		return courseHour;
	}

	void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}

	String getOffDay() {
		return offDay;
	}

	void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	ArrayList<String> getCourseLevel() {
		return courseLevel;
	}

	String[][] getTeacherSchedule() {
		return teacherSchedule;
	}

	ArrayList<String> getLessonType() {
		return lessonType;
	}

	int getRestHour() {
		return restHour;
	}

	void setRestHour(int restHour) {
		this.restHour = restHour;
	}

	int getCourseHourORG() {
		return courseHourORG;
	}

	void setCourseHourORG(int courseHourORG) {
		this.courseHourORG = courseHourORG;
	}

	private int courseHour;
	private int courseHourORG;
	private String offDay;
	private String name;
	private int restHour;
	private ArrayList<String> lessonType = new ArrayList<String>();
	private ArrayList<String> courseLevel = new ArrayList<String>();// FILL IT
	private String[][] teacherSchedule = new String[5][6];

}
