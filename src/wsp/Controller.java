package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Controller implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -945061607412662250L;
	static User u;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Data data = Data.getInstance();
    static User user;
	
	
	public static void question() throws ClassNotFoundException, IOException {
		while(true) {
			System.out.println("If you admin write 'Admin',if User write 'User':");
			String action = br.readLine();
			
			switch (action) {
			case "Admin":
				AdminController.adminType();
			case "User":
				start();
		    default:
			    System.out.println("Oops error,repeat please");
			
			}}		
		
	}
	
	
	public static void start() throws IOException, ClassNotFoundException {
		System.out.println("Welcome to WSP!!!");
		System.out.println("Please write your login and password");
		System.out.println("Login: ");
		String login = br.readLine();
		System.out.println("Password: ");
		String password = br.readLine();
		
		
		log(login,password);
	}
	
	 static void log(String login, String password) throws IOException, ClassNotFoundException {
			data.desUser();
			System.out.print("---------------------------------");
			System.out.print(Data.Teachers);
			System.out.print(Data.Executors);
			System.out.print(Data.Managers);
			System.out.print(Data.Students);
			System.out.print("---------------------------------");
			
			HashSet<User> users = new HashSet<>();
			
			users.addAll(Data.Executors);
			users.addAll(Data.Teachers);
			users.addAll(Data.Students);
			users.addAll(Data.Managers);
			
			
			for(User u:users) {
				System.out.println("-------------------");
				System.out.println(u);
				System.out.println("--------------------");
				if(u.getLogin().equals(login) && u.getPassword().equals(password) && !u.getLogin().equals(null) && !u.getPassword().equals(null)) {
					user = u;
					System.out.println("You are successfully logged in WSP!" + u.getLogin());
					
				if(user instanceof Manager) {
						Manager m = (Manager) user;
						ManagerController.managerType(m);
						
				}
				else if(user instanceof Executor) {	
						Executor e = (Executor) user;
						ExecutorController.executorType(e);
						
				}
				else if(user instanceof Teacher) {
						Teacher t = (Teacher) user;
						TeacherController.teacherType(t);
						
				}
				else if(user instanceof Student) {
						Student s = (Student) user;
						StudentController.studentType(s);
						
				}	
						
				else 
					System.out.println("Incorrect login or password,try again");
					start();
			}	
		
			}}}
		
	
