package wsp;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6269328832061972716L;
	private String name;
	private int credit;
	private String faculties;
	HashSet<CourseFile> files;
	
	
	public HashSet<CourseFile> getFiles() {
		return files;
	}
	public void setFiles(HashSet<CourseFile> files) {
		this.files = files;
	}


	public Course() {}
	public Course(String name,int credit,String faculties){
		this.name = name;
		this.credit = credit;
		this.faculties = faculties;
	}
	
	
	
	public void addCourseFile(CourseFile coursefile) {
		files.add(coursefile);	
	}
	public void deleteCourseFile(String topic) {
		for(CourseFile cs: files) {
			if(cs.getTopic().equals(topic)) {
				files.remove(cs);	
	}
			}}
	
	public CourseFile getFile(String topic) {
		for(CourseFile cs: files) {
			if(cs.getTopic().equals(topic));
			   return cs;
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
	public int compareTo(Course c){
	     return name.compareTo(c.getName());
	}
	public String getFaculties() {
		return faculties;
	}
	public void setFaculties(String faculties) {
		this.faculties = faculties;
	}
	public String toString() {
		return "Course:" + this.getName() + " Credit:" + this.getCredit() + "  Faculty:" + this.getFaculties();
	}
}
