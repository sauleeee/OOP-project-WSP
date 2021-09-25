package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

public class Manager extends Employee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8599193573759449031L;
	static Data data = Data.getInstance();
	static Manager manager = (Manager) Controller.u;
	
	public Manager() {}
	public Manager(String login,String password,String firstName, String lastName,int age,int phoneNumber) {
		super(login,password,firstName,lastName,age,phoneNumber);	
	}
	
	
	public void addCourseForRegistration(String name,int credit,String faculties) throws ClassNotFoundException, IOException {
		Course c = new Course(name,credit,faculties);

		if(Data.Courses.isEmpty()) {
			Data.Courses.add(c);
			data.serializeCourses();
			System.out.println("Succesfully!!!");
		}
		else {
			data.deserializeCourses();
			for (Course u: Data.Courses) {
				if(u.getName().equals(name) && u.getName().equals(credit) && u.getFaculties().equals(faculties)) {
					System.out.println("We have this course!");
				break;
		}
				else {
					Data.Courses.add(c);
					data.serializeCourses();
					System.out.println("Succesfully!!!");
				}}
		}
		
	}
	
	
	public String toString() {
		return super.toString();	
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Manager m= (Manager)o;
		return this.login.equals(m.login);
	}
	
	public int compareTo(Manager m){
	     return firstName.compareTo(m.getFirstName());
  }


}
