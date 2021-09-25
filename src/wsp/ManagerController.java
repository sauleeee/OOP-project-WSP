package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

public class ManagerController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7952417352989091195L;
	static Course course ;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Manager manager = (Manager) Controller.u;
	static Data data = Data.getInstance();
	static Student student;
	
	
	
	static void managerType(Manager manager) throws IOException, ClassNotFoundException {
		System.out.println("Welcome manager: " + manager.getFirstName());
		action(manager);
	}
	
	
	private static void action(Manager manager) throws IOException, ClassNotFoundException {
		System.out.println("What action would you want? ");

		while(true) {
			System.out.println("1. View profile");
			System.out.println("2. Add course for registration");
			System.out.println("3. View courses");
			System.out.println("4. View teachers");
			System.out.println("5. View students");
			System.out.println("6. Send order to Executor");
			System.out.println("7. LogOut");
			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			viewMyProfile(manager);
			break;
		case "2":
			addCourseForRegistration();
			break;
		case "3":
			viewCourses();	 
			break;
		case "4":
			viewTeacher();	 
			break;
		case "5":
			viewStudents();	 
			break;
		case "6":
			sendOrder();
			break;
		case "7":
			logOut();
		default:
			System.out.println("There is no such index,repeat please");
			action(manager);
		}
		}
	}
	
	private static void viewMyProfile(Manager manager) throws IOException, ClassNotFoundException {
		System.out.println("Manager: " + manager.toString());
		System.out.println("Please,press Q to quit profile");
		String action = br.readLine();
		if(action.equals("Q"))
			action(manager);
		
	}
	private static void addCourseForRegistration() throws IOException, ClassNotFoundException {
		while(true) {
			System.out.println("If you want to add course,write 'add'");
			String action = br.readLine();
	 
		switch (action) {
			case "add":
				System.out.println("Course name:");
		    	String name = br.readLine();
			    System.out.println("Course credit:");
			    int credit = Integer.parseInt(br.readLine());
			    
		    	Faculty[] f = Faculty.values();
		    	for(Faculty faculty:f) {
		    		System.out.println(faculty);
		    	}
		    	
		    	System.out.println("Choose faculty:");
		    	String faculties = br.readLine();
		    	
				Data.manager.addCourseForRegistration(name,credit,faculties);
				break;
				
		default:
				System.out.println("------");
				
			}
		
		System.out.println("Please,press Q to quit profile");
		String action2 = br.readLine();
		if(action2.equals("Q"))
			action(manager);
			}
		
	}
	
	private static void viewCourses() throws IOException, ClassNotFoundException {
		data.deserializeCourses();
		for (Course u : Data.Courses) {
			System.out.println(u.getName());
		}
		
		
		System.out.println("Write the name of the course to get INFORMATION:");
		String name = br.readLine();
		
		  for(Course course :Data.Courses) {
			if(course.getName().equals(name)) {
				  System.out.println(course.toString());
				
			}
			}
		  System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(manager);
				
		
	}
	
	private static void viewTeacher() throws IOException, ClassNotFoundException {
		data.deserializeTeacher();
		for (Teacher u : Data.Teachers) {
			System.out.println(u.getFirstName());
		}
		
		System.out.println("Write the name and lastname of the teacher to get INFORMATION:");
		String firstName = br.readLine();
		String lastName = br.readLine();
		
		for(Teacher teacher :Data.Teachers) {
			if(teacher.getFirstName().equals(firstName) && teacher.getLastName().equals(lastName)) {
				  System.out.println(teacher.toString());
				
			}
			}
		
		 System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(manager);
		
	}
	
	
	
	private static void viewStudents() throws IOException, ClassNotFoundException {
		data.deserializeStudent();
		for (Student u : Data.Students) {
			System.out.println(u.getFirstName());
		}
		
		System.out.println("Write the name and lastname of the student to get INFORMATION:");
		String firstName = br.readLine();
		String lastName = br.readLine();
		
		for(Student student :Data.Students) {
			if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				  System.out.println(student.toString());
				
			}
			}
		 System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(manager);
		
	}

	
	public static void sendOrder() throws IOException, ClassNotFoundException {
		System.out.println("Your topic: ");
		String topic = br.readLine();
		System.out.println("Your text: ");
		String text = br.readLine();
		Date date = new Date();
		System.out.println("Are you teacher,manager or admin?: ");
		String sender = br.readLine();
		
		Order o = new Order(topic,text,date,sender);

		if(Data.Orders.isEmpty()) {
			Data.Orders.add(o);
			data.serializeOrder();
			System.out.println("Succesfully!!!");
		}
		else {
			data.deserializeOrder();
			for (Order u: Data.Orders) {
				if(u.getTopic().equals(topic)) {
					System.out.println("We have this order!");
					break;
				
		}
				else {
					Data.Orders.add(o);
					data.serializeOrder();
					System.out.println("Succesfully!!!");
				}}
		}
		
		
		System.out.println("Please,press Q to quit profile");
		String action = br.readLine();
		if(action.equals("Q"))
			action(manager);
		}
	
	
	private static void logOut() throws ClassNotFoundException, IOException {
		Controller.question();
		
	}
	
}
