package project;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class AR {

	protected static boolean control = true;

	public static void addMCAR(ArrayList<Teacher> teacherList2) {
		int teacherCount = 1;
		Random rnd = new Random();
		if (Classes.AR_CLASS.size() != 0) {
			for (Classes.AR cls : Classes.AR_CLASS) {
				if (teacherList2.size() != 0) {

					Teacher teacher = teacherList2.get((int) rnd
							.nextInt(teacherList2.size() + 0));
					while (!canTakeThisLevel(teacher, "AR")
							|| !canTakeThisLessonType(teacher, "MC")
							|| teacher.getCourseHour() < 15) {
						teacher = teacherList2.get((int) rnd
								.nextInt(teacherList2.size() + 0));

					}
					boolean[] array = { false, false, false, false, false };
					int counter = 0;

					int type = -1;
					int day = rnd.nextInt(5);

					while (!isEmptyAR(teacher, type, day)
							|| !isLessonOK_UpperAR(cls, type, day, array,
									teacherCount)) {
						type = rnd.nextInt(2);
						day = rnd.nextInt(5);
					}
					if (type == 0) {
						teacher.getTeacherSchedule()[day][0] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][1] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][2] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][3] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						cls.schedule[day][0] = "MC / " + teacher.getName();
						cls.schedule[day][1] = "MC / " + teacher.getName();
						cls.schedule[day][2] = "MC / " + teacher.getName();
						cls.schedule[day][3] = "MC / " + teacher.getName();
						teacher.setRestHour(teacher.getRestHour() + 4);
						array[day] = true;
						cls.lesson[day] = 4;

					} else if (type == 1) {
						teacher.getTeacherSchedule()[day][2] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][3] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][4] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][5] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						cls.schedule[day][2] = "MC / " + teacher.getName();
						cls.schedule[day][3] = "MC / " + teacher.getName();
						cls.schedule[day][4] = "MC / " + teacher.getName();
						cls.schedule[day][5] = "MC / " + teacher.getName();
						teacher.setRestHour(teacher.getRestHour() + 4);
						array[day] = true;
						cls.lesson[day] = 4;
					}
					counter = 0;
					while (counter != 3) {
						type = -1;
						day = rnd.nextInt(5) + 0;
						while (!isEmptyAR(teacher, type, day)
								|| !isLessonOK_UpperAR(cls, type, day, array,
										teacherCount)) {
							type = rnd.nextInt(2) + 2;
							day = rnd.nextInt(5);
						}

						if (type == 2) {
							teacher.getTeacherSchedule()[day][0] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][1] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][2] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							cls.schedule[day][0] = "MC / " + teacher.getName();
							cls.schedule[day][1] = "MC / " + teacher.getName();
							cls.schedule[day][2] = "MC / " + teacher.getName();
							teacher.setRestHour(teacher.getRestHour() + 3);
							array[day] = true;
							counter++;
							cls.lesson[day] = 3;

						} else if (type == 3) {

							teacher.getTeacherSchedule()[day][3] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][4] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][5] = "MC / AR-"
									+ Classes.AR_CLASS.indexOf(cls);
							cls.schedule[day][3] = "MC / " + teacher.getName();
							cls.schedule[day][4] = "MC / " + teacher.getName();
							cls.schedule[day][5] = "MC / " + teacher.getName();

							teacher.setRestHour(teacher.getRestHour() + 3);
							array[day] = true;
							counter++;
							cls.lesson[day] = 3;
						}
					}
					counter = 0;
					type = -1;
					day = rnd.nextInt(5) + 0;

					while (!isEmptyAR(teacher, type, day)
							|| !isLessonOK_UpperAR(cls, type, day, array,
									teacherCount)) {
						type = rnd.nextInt(3) + 4;
						day = rnd.nextInt(5);
					}
					if (type == 4) {
						teacher.getTeacherSchedule()[day][0] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][1] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						cls.schedule[day][0] = "MC / " + teacher.getName();
						cls.schedule[day][1] = "MC / " + teacher.getName();
						teacher.setRestHour(teacher.getRestHour() + 2);
						array[day] = true;
						cls.lesson[day] = 2;

					} else if (type == 5) {

						teacher.getTeacherSchedule()[day][2] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][3] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						cls.schedule[day][2] = "MC / " + teacher.getName();
						cls.schedule[day][3] = "MC / " + teacher.getName();
						teacher.setRestHour(teacher.getRestHour() + 2);
						array[day] = true;
						cls.lesson[day] = 2;

					} else if (type == 6) {

						teacher.getTeacherSchedule()[day][4] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						teacher.getTeacherSchedule()[day][5] = "MC / AR-"
								+ Classes.AR_CLASS.indexOf(cls);
						cls.schedule[day][4] = "MC / " + teacher.getName();
						cls.schedule[day][5] = "MC / " + teacher.getName();

						teacher.setRestHour(teacher.getRestHour() + 2);
						array[day] = true;
						cls.lesson[day] = 2;
					}
					teacher.setRestHour(0);
					teacher.setCourseHour(teacher.getCourseHour() + 10);
					cls.t1 = teacher;
					teacherList2.remove(cls.t1);
				}

			}
		}
	}

	public static void addRWAR(ArrayList<Teacher> teacherList2) {
		int teacherCount = 2;
		int totalCount = 0;
		ArrayList<Teacher> list = new<Teacher> ArrayList();

		Random rnd = new Random();
		if (Classes.AR_CLASS.size() != 0) {
			for (Classes.AR cls : Classes.AR_CLASS) {
				list.addAll(teacherList2);
				if (teacherList2.size() != 0 && list.size() != 0) {
					while (totalCount != 4) {
						totalCount = 0;
						Teacher teacher;
						if (list.size() > 0)
							teacher = list
									.get((int) rnd.nextInt(list.size() + 0));
						else {
							control = false;
							break;
						}

						while (!canTakeThisLevel(teacher, "AR")
								|| !canTakeThisLessonType(teacher, "RW")
								|| teacher.getCourseHour() < 10
								|| teacher.getName().equals(cls.t1.getName())) {
							list.remove(teacher);
							if (list.size() > 0)
								teacher = list.get((int) rnd.nextInt(list
										.size() + 0));
							else {
								control = false;
								break;
							}

						}
						if (control == false)
							break;
						boolean[] array = { false, false, false, false, false };
						int[][] days = new int[4][2];
						int counter = 0;
						totalCount = 0;
						int type = 0;
						int day = 0;
						for (int i = 0; i < 5; i++) {
							type = 2;
							if (counter == 2)
								break;
							if (cls.lesson[i] == 3) {
								day = i;
								while (!isEmptyAR(teacher, type, day)
										|| !isLessonOK_UpperAR(cls, type, day,
												array, teacherCount)) {

									type++;
									if (type == 4) {
										control = false;
										break;
									}
								}
								if (type == 4)
									break;
								if (type == 2) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								} else if (type == 3) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								}
							}
						}
						if (type == 4)
							continue;
						counter = 0;
						for (int i = 0; i < 5; i++) {
							type = 4;
							if (counter == 2)
								break;
							if (cls.lesson[i] == 2 || cls.lesson[i] == 4) {
								day = i;
								while (!isEmptyAR(teacher, type, day)
										|| !isLessonOK_UpperAR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 7) {
										control = false;
										break;
									}
								}
								if (type == 7)
									break;
								if (type == 4) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								} else if (type == 5) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								} else if (type == 6) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;

								}
							}
						}
						// /////////////////////////////////////////////////////////////////////////////////////////////
						if (totalCount == 4) {
							for (int i = 0; i < 4; i++) {
								if (days[i][1] == 2) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][2] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][2] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 3) {

									teacher.getTeacherSchedule()[days[i][0]][3] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][5] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][3] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][5] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 4) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;

								} else if (days[i][1] == 5) {

									teacher.getTeacherSchedule()[days[i][0]][2] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][3] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][2] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][3] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;
								} else if (days[i][1] == 6) {
									teacher.getTeacherSchedule()[days[i][0]][4] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][5] = "RW / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][4] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][5] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;
								}
							}

							teacher.setRestHour(0);
							teacher.setCourseHour(teacher.getCourseHour() + 10);
							cls.t2 = teacher;
							teacherList2.remove(cls.t2);

						}
						list.remove(teacher);
						if (control == false)
							break;
					}
					totalCount = 0;
				}

				list.clear();
			}

		} else {
			control = false;
		}
	}

	public static void addLSAR(ArrayList<Teacher> teacherList2) {
		int teacherCount = 3;
		int totalCount = 0;
		ArrayList<Teacher> list = new<Teacher> ArrayList();
		Random rnd = new Random();
		if (Classes.AR_CLASS.size() != 0) {
			for (Classes.AR cls : Classes.AR_CLASS) {
				list.addAll(teacherList2);
				if (teacherList2.size() != 0 && list.size() != 0
						&& check(cls.lesson)) {

					while (totalCount != 2) {
						totalCount = 0;
						Teacher teacher;
						if (list.size() != 0)
							teacher = list
									.get((int) rnd.nextInt(list.size() + 0));
						else {
							control = false;
							break;
						}
						while (!canTakeThisLevel(teacher, "AR")
								|| !canTakeThisLessonType(teacher, "LS")
								|| teacher.getCourseHour() < 5
								|| (teacher.getName().equals(cls.t1.getName()) && teacher
										.getName().equals(cls.t2.getName()))) {
							list.remove(teacher);
							if (list.size() != 0)
								teacher = list.get((int) rnd.nextInt(list
										.size() + 0));
							else {
								control = false;
								break;
							}

						}
						boolean[] array = { false, false, false, false, false };
						int[][] days = new int[2][2];
						int counter = 0;
						totalCount = 0;
						int type = 0;
						int day = 0;

						for (int i = 0; i < 5; i++) {
							type = 2;
							if (counter == 1)
								break;
							if (cls.lesson[i] == 3) {
								day = i;
								while (!isEmptyAR(teacher, type, day)
										|| !isLessonOK_UpperAR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 4) {
										break;
									}
								}
								if (type == 2 || type == 3) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;

								}
							}
						}

						counter = 0;
						for (int i = 0; i < 5; i++) {
							type = 4;
							if (counter == 1)
								break;
							if (cls.lesson[i] == 4) {
								day = i;
								while (!isEmptyAR(teacher, type, day)
										|| !isLessonOK_UpperAR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 7) {
										break;
									}
								}
								if (type == 4 || type == 5 || type == 6) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								}
							}
						}
						if (totalCount == 2) {
							for (int i = 0; i < 2; i++) {
								if (days[i][1] == 2) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][2] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][2] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 3) {
									teacher.getTeacherSchedule()[days[i][0]][2] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][3] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][3] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][5] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 4) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;

								} else if (days[i][1] == 5) {
									teacher.getTeacherSchedule()[days[i][0]][2] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][3] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][2] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][3] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;

								} else if (days[i][1] == 6) {
									teacher.getTeacherSchedule()[days[i][0]][4] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][5] = "LS / AR-"
											+ Classes.AR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][4] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][5] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;
								}
							}

							teacher.setRestHour(0);
							teacher.setCourseHour(teacher.getCourseHour() + 5);
							cls.t3 = teacher;
							teacherList2.remove(cls.t3);

						}
						list.remove(teacher);

					}
				}
				totalCount = 0;
				if (control == false)
					break;
				if (check(cls.lesson) == false) {
					control = false;
					list.clear();
					break;

				} else {
					control = true;
					list.clear();
				}

			}

		} else {
			control = false;

		}
	}

	private static boolean check(int array[]) {
		for (int i : array) {
			if (i == 0)
				return false;
		}
		return true;
	}

	private static boolean isEmptyAR(Teacher teacher, int type, int day) {
		if (type == 0)
			if (teacher.getTeacherSchedule()[day][0] == null
					&& teacher.getTeacherSchedule()[day][1] == null
					&& teacher.getTeacherSchedule()[day][2] == null
					&& teacher.getTeacherSchedule()[day][3] == null)
				return true;
		if (type == 1)
			if (teacher.getTeacherSchedule()[day][2] == null
					&& teacher.getTeacherSchedule()[day][3] == null
					&& teacher.getTeacherSchedule()[day][4] == null
					&& teacher.getTeacherSchedule()[day][5] == null)
				return true;
		if (type == 2)
			if (teacher.getTeacherSchedule()[day][0] == null
					&& teacher.getTeacherSchedule()[day][1] == null
					&& teacher.getTeacherSchedule()[day][2] == null)
				return true;
		if (type == 3)
			if (teacher.getTeacherSchedule()[day][3] == null
					&& teacher.getTeacherSchedule()[day][4] == null
					&& teacher.getTeacherSchedule()[day][5] == null)
				return true;
		if (type == 4)
			if (teacher.getTeacherSchedule()[day][0] == null
					&& teacher.getTeacherSchedule()[day][1] == null)
				return true;
		if (type == 5)
			if (teacher.getTeacherSchedule()[day][2] == null
					&& teacher.getTeacherSchedule()[day][3] == null)
				return true;
		if (type == 6)
			if (teacher.getTeacherSchedule()[day][4] == null
					&& teacher.getTeacherSchedule()[day][5] == null)
				return true;
		return false;

	}

	private static boolean canTakeThisLevel(Teacher t, String s) {
		if (t.getCourseLevel().indexOf(s) == -1)
			return false;
		else
			return true;

	}

	private static boolean canTakeThisLessonType(Teacher t, String s) {
		if (t.getLessonType().indexOf(s) == -1)
			return false;
		else
			return true;
	}

	private static boolean isLessonOK_UpperAR(Classes.AR cls, int type,
			int day, boolean[] array, int teacherCount) {
		if (type == 0) {
			if (cls.schedule[day][0] == null && cls.schedule[day][1] == null
					&& cls.schedule[day][2] == null
					&& cls.schedule[day][3] == null && array[day] == false)
				return true;
		}
		if (type == 1) {
			if (cls.schedule[day][2] == null && cls.schedule[day][3] == null
					&& cls.schedule[day][4] == null
					&& cls.schedule[day][5] == null && array[day] == false)
				return true;
		}
		if (type == 2) {
			if (teacherCount == 1) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null
						&& cls.schedule[day][2] == null && array[day] == false)
					return true;
			} else if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null
						&& cls.schedule[day][2] == null && array[day] == false
						&& cls.schedule[day][3] != null
						&& cls.schedule[day][4] != null
						&& cls.schedule[day][5] != null)
					return true;
			}
		}
		if (type == 3) {
			if (teacherCount == 1) {
				if (cls.schedule[day][3] == null
						&& cls.schedule[day][4] == null
						&& cls.schedule[day][5] == null && array[day] == false)
					return true;
			} else if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][3] == null
						&& cls.schedule[day][4] == null
						&& cls.schedule[day][5] == null && array[day] == false
						&& cls.schedule[day][0] != null
						&& cls.schedule[day][1] != null
						&& cls.schedule[day][2] != null)
					return true;
			}
		}
		if (type == 4) {
			if (teacherCount == 1) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null && array[day] == false)
					return true;

			} else if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null
						&& array[day] == false
						&& (cls.schedule[day][2] != null || cls.schedule[day][3] == null))
					return true;
			}
		}
		if (type == 5) {
			if (cls.schedule[day][2] == null && cls.schedule[day][3] == null
					&& array[day] == false)
				return true;
		}
		if (type == 6) {

			if (teacherCount == 1) {
				if (cls.schedule[day][4] == null
						&& cls.schedule[day][5] == null && array[day] == false)
					return true;

			} else if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][4] == null
						&& cls.schedule[day][5] == null
						&& array[day] == false
						&& (cls.schedule[day][3] != null || cls.schedule[day][2] == null))
					return true;
			}
		}

		return false;
	}
}
