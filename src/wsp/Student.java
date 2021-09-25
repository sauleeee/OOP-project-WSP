package wsp;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Vector;

public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6860660265750071533L;
	private HashMap<Course,Teacher> teachers;
	private Faculty faculty;
	private Transcript transcript;
	protected int age;
	protected int phoneNumber;
	Vector<Course> course = new Vector<Course>();
	Vector<Mark> mark;
	Data data = Data.getInstance();
	
	public Student() {}
	public Student(String login,String password,String firstName, String lastName,int age,int phoneNumber,Vector<Mark> mark) {
		super(login,password,firstName,lastName);
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.mark = mark;
	}
	
	
	
	public void viewStudentTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public HashMap<Course,Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(HashMap<Course,Teacher> teachers) {
		this.teachers = teachers;
	}
	public Vector<Course> getCourse() {
		return course;
	}

	public void setCourse(Vector<Course> course) {
		this.course = course;
	}
	
	
	
	public String toString() {
		return "Student:" + super.toString() + " Age:" + this.getAge() + " Phone number:" + this.getPhoneNumber() + " registered courses:"+(course==null? "No courses! ":course);
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public int compareTo(Student s){
	     return firstName.compareTo(s.getFirstName());
	}
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s  = (Student)o;
		return this.login.equals(s.login);
	}

	
}
