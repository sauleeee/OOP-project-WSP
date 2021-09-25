package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;



public class Teacher extends Employee implements Comparable<Teacher>,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4577626666306380581L;
	private Rank rank;
	Vector<CourseFile> files;
	static HashSet<String> course;
	static HashMap<Course,Mark> mark = new HashMap<>();
 

	public Teacher() {}
	public Teacher(String login,String password,String firstName, String lastName,int age,int phoneNumber,Vector<CourseFile> files) {
		super(login,password,firstName,lastName,age,phoneNumber);
		this.files = files;
	}
	

	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	
	public String toString() {
		return "Teacher:" + super.toString();	
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Teacher t  = (Teacher)o;
		return this.login.equals(t.login);
	}
	
	public int compareTo(Teacher t){
	     return firstName.compareTo(t.getFirstName());
	}
	public int hashCode() {
		return Objects.hash(firstName,lastName,login,password);
	}
	
	
}
