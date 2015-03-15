package project;

import java.util.ArrayList;

public class Classes {
	private static int ALevel;
	private static int ARLevel;
	private static int BLevel;
	private static int BRLevel;
	private static int CLevel;
	private static int CRLevel;

	protected static ArrayList<A> A_CLASS = new ArrayList<A>();
	protected static ArrayList<AR> AR_CLASS = new ArrayList<AR>();
	protected static ArrayList<B> B_CLASS = new ArrayList<B>();
	protected static ArrayList<BR> BR_CLASS = new ArrayList<BR>();
	protected static ArrayList<C> C_CLASS = new ArrayList<C>();
	protected static ArrayList<CR> CR_CLASS = new ArrayList<CR>();
	// --//
	protected static ArrayList<A_Term2> A_Term2_CLASS = new ArrayList<A_Term2>();
	protected static ArrayList<AR_Term2> AR_Term2_CLASS = new ArrayList<AR_Term2>();

	public static class A_Term2 {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][5];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class AR_Term2 {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][5];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class A {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class AR {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class B {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class BR {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class C {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	public static class CR {
		Teacher t1;// MainCourse
		Teacher t2;// Listening
		Teacher t3;// Writing
		String[][] schedule = new String[5][6];
		int[] lesson = { 0, 0, 0, 0, 0 };

	}

	int getALevel() {
		return ALevel;
	}

	void setALevel(int aLevel) {
		ALevel = aLevel;
	}

	int getARLevel() {
		return ARLevel;
	}

	void setARLevel(int aRLevel) {
		ARLevel = aRLevel;
	}

	int getBLevel() {
		return BLevel;
	}

	void setBLevel(int bLevel) {
		BLevel = bLevel;
	}

	int getBRLevel() {
		return BRLevel;
	}

	void setBRLevel(int bRLevel) {
		BRLevel = bRLevel;
	}

	int getCLevel() {
		return CLevel;
	}

	void setCLevel(int cLevel) {
		CLevel = cLevel;
	}

	int getCRLevel() {
		return CRLevel;
	}

	void setCRLevel(int cRLevel) {
		CRLevel = cRLevel;
	}

}
