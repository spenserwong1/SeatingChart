
public class Teacher implements Comparable<Teacher> {
	private String name;
	private int number;
	private int grade;

	public Teacher(String name, int number, int grade) {
		this.name = name;
		this.number = number;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public int getGrade() {
		return grade;
	}

	public void setNumber(int in) {
		number = in;
	}

	@Override
	public int compareTo(Teacher arg0) {
		return arg0.getGrade() - grade;
	}
}
