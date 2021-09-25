package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;


public class Admin extends Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3998840202673599825L;
	static Admin admin = (Admin) Controller.u;
	static Data data = Data.getInstance();
	
	public Admin() {}
	public Admin(String login,String password,String firstName, String lastName,int age,int phoneNumber) {
		super(login,password,firstName,lastName,age,phoneNumber);
	}

	
	 void addManager(String login, String password, String firstName, String lastName,int age,int phoneNumber) throws IOException, ClassNotFoundException {
		Manager m = new Manager(login, password, firstName, lastName,age,phoneNumber);


		if(Data.Managers.isEmpty()) {
			Data.Managers.add(m);
			data.serializeManager();
			System.out.println("Succesfully!!!");
		}
		else {
			data.deserializeManager();
			for (User u: Data.Managers) {
				if(u.getLogin().equals(login) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
					System.out.println("We have this account!");
					break;
				
		}
				else {
					Data.Managers.add(m);
					data.serializeManager();
					System.out.println("Succesfully!!!");
				}}
		}
		
		
		}
	
	 
	void addExecutor(String login, String password, String firstName, String lastName,int age,int phoneNumber) throws IOException, ClassNotFoundException {
		Executor e = new Executor(login, password, firstName, lastName,age,phoneNumber);

		if(Data.Executors.isEmpty()) {
			Data.Executors.add(e);
			data.serializeExecutor();
			System.out.println("Succesfully!!!");
		}
		else {
			data.deserializeExecutor();
			for (User u: Data.Executors) {
				if(u.getLogin().equals(login) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
					System.out.println("We have this account!");
				break;
		}
				else {
					Data.Executors.add(e);
					data.serializeExecutor();
					System.out.println("Succesfully!!!");
				}}
		}
		
		
		}
	
	
	void addTeacher(String login, String password, String firstName, String lastName,int age,int phoneNumber,Vector<CourseFile> files) throws IOException, ClassNotFoundException {
		Teacher t = new Teacher(login, password, firstName, lastName,age,phoneNumber,files);
		
		if(Data.Teachers.isEmpty()) {
			Data.Teachers.add(t);
			data.serializeTeacher();
			System.out.println("Succesfully!!!");
		}
		else {
			data.deserializeTeacher();
			for (User u: Data.Teachers) {
				if(u.getLogin().equals(login) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
					System.out.println("We have this account!");
					break;
		}
				else {
					Data.Teachers.add(t);
					data.serializeTeacher();
					System.out.println("Succesfully!!!");
				}}
		}
		
		
		}
		
	

	void addStudent(String login, String password,String firstName, String lastName,int age,int phoneNumber, Vector<Mark> mark) throws IOException, ClassNotFoundException {
		Student s = new Student(login, password, firstName, lastName,age,phoneNumber,mark);
			if(Data.Students.isEmpty()) {
				Data.Students.add(s);
				data.serializeStudent();
				System.out.println("Succesfully!!!");
			}
			else {
				data.deserializeStudent();
				
				for (User u: Data.Students) {
					if(u.getLogin().equals(login) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
						System.out.println("We have this account!");
						break;
			
					}
					else {
						Data.Students.add(s);
						data.serializeStudent();
						System.out.println("Succesfully!!!");
					}
					}}}
		
	
	public boolean removeUser(String login) throws ClassNotFoundException, IOException {
		data.deserializeStudent();
		for (User u: Data.Students) {
			if (u.getLogin().equals(login)) {
			Data.Students.remove(u);
			data.serializeStudent();
			return true;
			
		}
			}
		data.deserializeManager();
		for (User u: Data.Managers) {
			if (u.getLogin().equals(login)) {
				Data.Managers.remove(u);
				data.serializeManager();
				return true;
		}
		}
		data.deserializeExecutor();
		for (User u: Data.Executors) {
			if (u.getLogin().equals(login)) {
				Data.Executors.remove(u);
				data.serializeExecutor();
				return true;
		}
		}
		data.deserializeTeacher();
		for (User u: Data.Teachers) {
			if (u.getLogin().equals(login)) {
				Data.Teachers.remove(u);
				data.serializeTeacher();
				return true;
			}
		}
			
	System.out.println("We don't have this account");
	return false;
	}
	
	
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public String toString() {
		return "Admin:" + super.toString();	
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Admin a = (Admin)o;
		return this.login.equals(a.login);
	}
	
	public int compareTo(Admin a){
	     return firstName.compareTo(a.getFirstName());
   }

	
}
