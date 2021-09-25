package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public class TeacherController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6461538415756102545L;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashSet<Course> courses;
	static Data data = Data.getInstance();
	static Course course;
	static Employee employee;
	Student student;
	
	
	public static void teacherType(Teacher teacher) throws ClassNotFoundException, IOException {
		System.out.println("Welcome teacher: " + teacher.getFirstName());
		action(teacher);
	}
	

	public static void action(Teacher teacher) throws IOException, ClassNotFoundException{
		System.out.println("What action would you want? ");

		while(true) {
			System.out.println("1. View MyProfile");
			System.out.println("2. Manage Courses");
			System.out.println("3. Send order to Executor");
			System.out.println("4. Logout");
			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			viewMyProfile(teacher);
			break;
		case "2":
			courseTeacher(teacher);
			break;
		case "3":
			sendOrder(teacher);	 
			break;
		case "4":
			logOut();
		default:
			System.out.println("There is no such index,repeat please");
			action(teacher);
		}
		}
	}
	


	private static void viewMyProfile(Teacher teacher) throws IOException, ClassNotFoundException {
		System.out.println("Teacher: " + teacher.toString());
		System.out.println("Please,press Q to quit course");
		String action = br.readLine();
		if(action.equals("Q")) {
			action(teacher);
		
		}
	}
	


	public static void sendOrder(Teacher teacher) throws IOException, ClassNotFoundException {
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
			action(teacher);
		}
	

	private static void logOut() throws ClassNotFoundException, IOException {
		Controller.question();
		
	}


	public static void courseTeacher(Teacher teacher) throws ClassNotFoundException, IOException{
		System.out.println("What action would you want? ");

		while(true) {
			System.out.println("1. View courses");
			System.out.println("2. Put Mark");
			System.out.println("3. Add course file");
			System.out.println("4. Delete course file");
			System.out.println("5. Logout");

			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			viewCourses(teacher);
			break;
		case "2":
			putMark(teacher);
			break;
		case "3":
			addCourseFile(teacher);
			break;
		case "4":
			deleteCourseFile(teacher);
			break;
		case "5":
			action(teacher);
			break;
		default:
			System.out.println("There is no such index,repeat please");
			action(teacher);
		}
}
	}
	
	private static void viewCourses(Teacher teacher) throws IOException, ClassNotFoundException {
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

		System.out.println("Please,press Q if you want to quit");
		String action2 = br.readLine();
		if(action2.equals("Q")) {
			courseTeacher(teacher);
		}
	}
	
	
	
	private static void putMark(Teacher teacher) throws IOException, ClassNotFoundException {
		System.out.println("List of the students:");
		data.deserializeStudent();
		for (Student u : Data.Students) {
			System.out.println(u.getFirstName());
		}
		
		System.out.println("Write the name and lastname of the student to get INFORMATION:");
		String firstName = br.readLine();
		String lastName = br.readLine();
		Student s = new Student();
		
		
		for(Student student :Data.Students) {
			if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				  System.out.println(student.toString());
				  s = student;
			}
			}
		System.out.println("Write courses name:");
		String name = br.readLine();
		
		data.deserializeCourses();
		Mark m = new Mark();
		for(Course c: Data.Courses) {
			if(c.getName().equals(name)) {
				System.out.println("Please, write mark for 1 st attestation:");
				int firstAttestation = Integer.parseInt(br.readLine());
				System.out.println("Please, write mark for 2 st attestation:");
				int secondAttestation = Integer.parseInt(br.readLine());
				System.out.println("Please, write mark for final:");
				int finall = Integer.parseInt(br.readLine());


				m.setFirstAttestation(firstAttestation);
				m.setSecondAttestation(secondAttestation);
				m.setFinal(finall);
			}
		}
		System.out.println(m);
		s.mark.add(m);
		data.serializeStudent();
		System.out.println("Please,press Q to quit profile");
		String action = br.readLine();
		if(action.equals("Q"))
			action(teacher);
		
		}
	
	
	
	
	
	public static void addCourseFile(Teacher teacher) throws IOException, ClassNotFoundException {
	
		System.out.println("Your topic for file: ");
		String topic = br.readLine();
		System.out.println("Your text for file: ");
		String text = br.readLine();
		
		System.out.println(topic);
		System.out.println(teacher.firstName);
		CourseFile coursefile = new CourseFile(topic,text);
		
		 teacher.files.add(coursefile);
		 data.serializeTeacher();
		 
		 System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(teacher);
		 
	 }
		
	
		
	
	public static void deleteCourseFile(Teacher teacher) throws IOException, ClassNotFoundException {	
		System.out.println("Please,can you write the topic,which you want to delete:");
		String topic = br.readLine();
		
		int i = 0;
		for(CourseFile c: teacher.files) {
			if(c.getTopic().equals(topic)) {
				break;
			}
			i++;
		}
		 teacher.files.remove(i);
		 data.serializeTeacher();
		 
		 System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(teacher);
	}
	
	
}
