package project;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class BR {

	protected static boolean control = true;
	private static int FAULT = 0;

	/**
	 * @param teacherList2
	 */
	public static void addMCBR(ArrayList<Teacher> teacherList2) {
		ArrayList<Teacher> list = new<Teacher> ArrayList();
		Random rnd = new Random();
		if (Classes.BR_CLASS.size() != 0) {
			for (Classes.BR cls : Classes.BR_CLASS) {
				list.addAll(teacherList2);
				while (teacherList2.size() != 0 && list.size() != 0
						&& control != false) {
					control = true;
					Teacher teacher;

					if (list.size() != 0) {
						teacher = list.get((int) rnd.nextInt(list.size() + 0));
						list.remove(teacher);
					} else {
						control = false;
						break;
					}
					while (canTakeThisLevel(teacher, "BR") == false
							|| canTakeThisLessonType(teacher, "MC") == false
							|| teacher.getCourseHour() < 10) {
						if (list.size() != 0)
							teacher = list
									.get((int) rnd.nextInt(list.size() + 0));
						else {
							control = false;
							break;
						}
						list.remove(teacher);
					}
					if (control == false)
						break;

					boolean[] array = { false, false, false, false, false };
					int counter = 0;
					int saveTeacher[][] = new int[4][2];
					FAULT = 0;
					while (counter != 2) {
						int type = -1;
						int day = rnd.nextInt(5) + 0;

						while (isEmpty(teacher, type, day) == false
								|| isLessonOK_UpperBR(cls, type, day, array, 1) == false) {
							type = rnd.nextInt(2) + 0;
							day = rnd.nextInt(5) + 0;
							FAULT++;
							if (FAULT == 20)
								break;
						}
						if (FAULT == 20)
							break;
						if (type == 0) {
							teacher.getTeacherSchedule()[day][0] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][1] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][2] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							cls.schedule[day][0] = "MC / " + teacher.getName();
							cls.schedule[day][1] = "MC / " + teacher.getName();
							cls.schedule[day][2] = "MC / " + teacher.getName();
							teacher.setRestHour(teacher.getRestHour() + 3);
							array[day] = true;
							counter++;
							cls.lesson[day] = 3;
							saveTeacher[counter][0] = day;
						}
						if (type == 1) {
							teacher.getTeacherSchedule()[day][2] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][3] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][4] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							cls.schedule[day][2] = "MC / " + teacher.getName();
							cls.schedule[day][3] = "MC / " + teacher.getName();
							cls.schedule[day][4] = "MC / " + teacher.getName();
							teacher.setRestHour(teacher.getRestHour() + 3);
							array[day] = true;
							counter++;
							cls.lesson[day] = 3;
							saveTeacher[counter][0] = day;
						}
					}
					if (FAULT == 20) {
						for (int i = 0; i < 2; i++) {
							if (saveTeacher[i][1] == 0) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][0] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][1] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][2] = null;
								cls.schedule[saveTeacher[i][0]][0] = null;
								cls.schedule[saveTeacher[i][0]][1] = null;
								cls.schedule[saveTeacher[i][0]][2] = null;
								teacher.setRestHour(teacher.getRestHour() - 3);
								cls.lesson[saveTeacher[i][0]] = 0;

							} else if (saveTeacher[i][1] == 1) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][2] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][3] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][4] = null;
								cls.schedule[saveTeacher[i][0]][2] = null;
								cls.schedule[saveTeacher[i][0]][3] = null;
								cls.schedule[saveTeacher[i][0]][4] = null;
								teacher.setRestHour(teacher.getRestHour() - 3);
								cls.lesson[saveTeacher[i][0]] = 0;

							}
						}

						continue;
					}
					FAULT = 0;
					counter = 0;
					while (counter != 2) {
						int type = -1;
						int day = rnd.nextInt(5) + 0;

						while (isEmpty(teacher, type, day) == false
								|| isLessonOK_UpperBR(cls, type, day, array, 1) == false) {
							type = rnd.nextInt(2) + 2;
							day = rnd.nextInt(5) + 0;
							FAULT++;
							if (FAULT == 20)
								break;
						}
						if (FAULT == 20)
							break;
						if (type == 2) {
							teacher.getTeacherSchedule()[day][0] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][1] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							cls.schedule[day][0] = "MC / " + teacher.getName();
							cls.schedule[day][1] = "MC / " + teacher.getName();
							teacher.setRestHour(teacher.getRestHour() + 2);
							array[day] = true;
							counter++;
							cls.lesson[day] = 2;
							saveTeacher[counter + 1][0] = day;
						}
						if (type == 3) {
							teacher.getTeacherSchedule()[day][3] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							teacher.getTeacherSchedule()[day][4] = "MC / BR-"
									+ Classes.BR_CLASS.indexOf(cls);
							cls.schedule[day][3] = "MC / " + teacher.getName();
							cls.schedule[day][4] = "MC / " + teacher.getName();
							teacher.setRestHour(teacher.getRestHour() + 2);
							array[day] = true;
							counter++;
							cls.lesson[day] = 2;
							saveTeacher[counter + 1][0] = day;
						}
					}
					if (FAULT == 20) {
						for (int i = 0; i < 4; i++) {
							if (saveTeacher[i][1] == 0) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][0] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][1] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][2] = null;
								cls.schedule[saveTeacher[i][0]][0] = null;
								cls.schedule[saveTeacher[i][0]][1] = null;
								cls.schedule[saveTeacher[i][0]][2] = null;
								teacher.setRestHour(teacher.getRestHour() - 3);
								cls.lesson[saveTeacher[i][0]] = 0;

							} else if (saveTeacher[i][1] == 1) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][2] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][3] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][4] = null;
								cls.schedule[saveTeacher[i][0]][2] = null;
								cls.schedule[saveTeacher[i][0]][3] = null;
								cls.schedule[saveTeacher[i][0]][4] = null;
								teacher.setRestHour(teacher.getRestHour() - 3);
								cls.lesson[saveTeacher[i][0]] = 0;

							} else if (saveTeacher[i][1] == 2) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][0] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][1] = null;
								cls.schedule[saveTeacher[i][0]][0] = null;
								cls.schedule[saveTeacher[i][0]][1] = null;
								teacher.setRestHour(teacher.getRestHour() - 2);
								cls.lesson[saveTeacher[i][0]] = 0;

							} else if (saveTeacher[i][1] == 3) {
								teacher.getTeacherSchedule()[saveTeacher[i][0]][3] = null;
								teacher.getTeacherSchedule()[saveTeacher[i][0]][4] = null;
								cls.schedule[saveTeacher[i][0]][3] = null;
								cls.schedule[saveTeacher[i][0]][4] = null;
								teacher.setRestHour(teacher.getRestHour() - 2);
								cls.lesson[saveTeacher[i][0]] = 0;

							}
						}
						continue;
					}
					teacher.setRestHour(0);
					teacher.setCourseHour(teacher.getCourseHour() - 10);
					cls.t1 = teacher;
					teacherList2.remove(cls.t1);
					list.remove(teacher);
					break;

				}
				if (list.size() == 0 || control == false || cls.t1 == null) {
					control = false;
					break;
				}

				list.clear();
			}

		}

	}

	/**
	 * @param teacherList2
	 */
	public static void addRWBR(ArrayList<Teacher> teacherList2) {

		int teacherCount = 2;
		int totalCount = 0;
		ArrayList<Teacher> list = new<Teacher> ArrayList();
		Random rnd = new Random();
		if (Classes.BR_CLASS.size() != 0 && control == true) {
			for (Classes.BR cls : Classes.BR_CLASS) {
				list.addAll(teacherList2);
				if (teacherList2.size() != 0 && list.size() != 0) {
					while (totalCount != 4 && control == true) {
						totalCount = 0;
						Teacher teacher;
						if (list.size() > 0)
							teacher = list
									.get((int) rnd.nextInt(list.size() + 0));
						else {
							control = false;
							break;
						}

						while (!canTakeThisLevel(teacher, "BR")
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
						if (cls.t1.equals(teacher))
							continue;
						if (control == false)
							break;
						list.remove(teacher);
						boolean[] array = { false, false, false, false, false };
						int[][] days = new int[4][2];
						int counter = 0;
						totalCount = 0;
						int type = 0;
						int day = 0;

						for (int i = 0; i < 5; i++) {
							type = 0;
							if (counter == 2)
								break;
							if (cls.lesson[i] == 2 || cls.lesson[i] == 0) {
								day = i;
								while (!isEmpty(teacher, type, day)
										|| !isLessonOK_UpperBR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 2) {
										break;
									}
								}
								if (type == 2)
									continue;
								if (type == 0 || type == 1) {
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
							type = 2;
							if (counter == 2)
								break;
							if (cls.lesson[i] == 3 || cls.lesson[i] == 0) {
								day = i;
								while (!isEmpty(teacher, type, day)
										|| !isLessonOK_UpperBR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 4) {
										break;
									}
								}
								if (type == 4)
									continue;
								if (type == 2 || type == 3) {
									days[totalCount][0] = day;
									days[totalCount][1] = type;
									array[day] = true;
									counter++;
									totalCount++;
								}
							}
						}

						if (totalCount == 4) {
							for (int i = 0; i < 4; i++) {
								if (days[i][1] == 0) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][2] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][2] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 1) {
									teacher.getTeacherSchedule()[days[i][0]][2] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][3] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][2] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][3] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 2) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;

								} else if (days[i][1] == 3) {
									teacher.getTeacherSchedule()[days[i][0]][3] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "RW / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][3] = "RW / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "RW / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;
								}
							}

							teacher.setRestHour(0);
							teacher.setCourseHour(teacher.getCourseHour() - 10);
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

	/**
	 * @param teacherList2
	 */
	public static void addLSBR(ArrayList<Teacher> teacherList2) {

		int teacherCount = 3;
		int totalCount = 0;
		ArrayList<Teacher> list = new<Teacher> ArrayList();
		Random rnd = new Random();
		if (Classes.BR_CLASS.size() != 0 && control == true) {
			for (Classes.BR cls : Classes.BR_CLASS) {
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
						while (!canTakeThisLevel(teacher, "BR")
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
						if (cls.t1.equals(teacher) || cls.t2.equals(teacher))
							continue;
						if (control == false)
							break;
						list.remove(teacher);
						boolean[] array = { false, false, false, false, false };
						int[][] days = new int[2][2];
						int counter = 0;
						totalCount = 0;
						int type = 0;
						int day = 0;

						for (int i = 0; i < 5; i++) {
							type = 0;
							if (counter == 1)
								break;
							if (cls.lesson[i] == 2) {
								day = i;
								while (!isEmpty(teacher, type, day)
										|| !isLessonOK_UpperBR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 2) {
										break;
									}
								}
								if (type == 2)
									break;
								if (type == 0 || type == 1) {
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
							type = 2;
							if (counter == 1)
								break;
							if (cls.lesson[i] == 3) {
								day = i;
								while (!isEmpty(teacher, type, day)
										|| !isLessonOK_UpperBR(cls, type, day,
												array, teacherCount)) {
									type++;
									if (type == 4) {
										break;
									}
								}
								if (type == 4)
									continue;
								if (type == 2 || type == 3) {
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
								if (days[i][1] == 0) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][2] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][2] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 1) {
									teacher.getTeacherSchedule()[days[i][0]][2] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][3] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][2] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][3] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 3);
									cls.lesson[days[i][0]] += 3;

								} else if (days[i][1] == 2) {
									teacher.getTeacherSchedule()[days[i][0]][0] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][1] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][0] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][1] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;

								} else if (days[i][1] == 3) {
									teacher.getTeacherSchedule()[days[i][0]][3] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									teacher.getTeacherSchedule()[days[i][0]][4] = "LS / BR-"
											+ Classes.BR_CLASS.indexOf(cls);
									cls.schedule[days[i][0]][3] = "LS / "
											+ teacher.getName();
									cls.schedule[days[i][0]][4] = "LS / "
											+ teacher.getName();
									teacher.setRestHour(teacher.getRestHour() + 2);
									cls.lesson[days[i][0]] += 2;
								}
							}

							teacher.setRestHour(0);
							teacher.setCourseHour(teacher.getCourseHour() - 5);
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

	/**
	 * @param cls
	 * @param type
	 * @param day
	 * @param array
	 * @param teacherCount
	 * @return
	 */
	private static boolean isLessonOK_UpperBR(Classes.BR cls, int type,
			int day, boolean[] array, int teacherCount) {
		if (type == 0) {

			if (cls.schedule[day][0] == null && cls.schedule[day][1] == null
					&& cls.schedule[day][2] == null && array[day] == false)
				return true;

		}
		if (type == 1) {
			if (cls.schedule[day][2] == null && cls.schedule[day][3] == null
					&& cls.schedule[day][4] == null && array[day] == false)
				return true;

		}
		if (type == 2) {
			if (teacherCount == 1) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null && array[day] == false)
					return true;
			}
			if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][0] == null
						&& cls.schedule[day][1] == null
						&& array[day] == false
						&& (cls.schedule[day][2] != null || cls.schedule[day][3] == null))
					return true;
			}
		}
		if (type == 3) {
			if (teacherCount == 1) {
				if (cls.schedule[day][3] == null
						&& cls.schedule[day][4] == null && array[day] == false)
					return true;
			}
			if (teacherCount == 2 || teacherCount == 3) {
				if (cls.schedule[day][3] == null
						&& cls.schedule[day][4] == null
						&& array[day] == false
						&& (cls.schedule[day][2] != null || cls.schedule[day][3] == null))
					return true;
			}
		}

		return false;
	}

	/**
	 * @param t
	 * @param s
	 * @return
	 */
	private static boolean canTakeThisLevel(Teacher t, String s) {
		if (t.getCourseLevel().indexOf(s) == -1)
			return false;
		else
			return true;

	}

	/**
	 * @param t
	 * @param s
	 * @return
	 */
	private static boolean canTakeThisLessonType(Teacher t, String s) {
		if (t.getLessonType().indexOf(s) == -1)
			return false;
		else
			return true;
	}

	/**
	 * @param teacher
	 * @param type
	 * @param day
	 * @return
	 */
	private static boolean isEmpty(Teacher teacher, int type, int day) {
		if (type == 0)
			if (teacher.getTeacherSchedule()[day][0] == null
					&& teacher.getTeacherSchedule()[day][1] == null
					&& teacher.getTeacherSchedule()[day][2] == null)
				return true;
		if (type == 1)
			if (teacher.getTeacherSchedule()[day][2] == null
					&& teacher.getTeacherSchedule()[day][3] == null
					&& teacher.getTeacherSchedule()[day][4] == null)
				return true;
		if (type == 2)
			if (teacher.getTeacherSchedule()[day][0] == null
					&& teacher.getTeacherSchedule()[day][1] == null)
				return true;
		if (type == 3)
			if (teacher.getTeacherSchedule()[day][3] == null
					&& teacher.getTeacherSchedule()[day][4] == null)
				return true;
		return false;

	}

	/**
	 * @param array
	 * @return
	 */
	private static boolean check(int array[]) {
		for (int i : array) {
			if (i == 0)
				return false;
		}
		return true;
	}
}
