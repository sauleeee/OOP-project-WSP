package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class AdminController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5234959297156540220L;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Admin admin = (Admin) Controller.u;
	static Type type;
	static Data data = Data.getInstance();
	static Admin a = new Admin("S_akkalieva", "Parol", "Saule", "Akkalieva",18,8775915);
	
	
	static void adminType() throws ClassNotFoundException, IOException{
		System.out.println("Welcome admin: " + a.getFirstName());
		action();
	};
	
	
	public static void action() throws IOException, ClassNotFoundException{
		System.out.println("What action would you want? ");
		try {
		while(true) {
			System.out.println("1. View profile");
			System.out.println("2. Add User");
			System.out.println("3. Delete user");
			System.out.println("4. Update user");
			System.out.println("5. Send order to Executor");
			System.out.println("6. LogOut");
			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			viewMyProfile();
			break;
		case "2":
			addUser();
			break;
		case "3":
			deleteUser();	 
			break;
		case "4":
			updateUser();
		case "5":
			sendOrder();
			break;
		case "6":
			logOut();
		default:
			System.out.println("There is no such index,repeat please");
			action();
		}}
		}
	catch(Exception e) {
			System.out.println("Some problem happened... Saving data");
			data.serUser();
		}
	}



	private static void viewMyProfile() throws IOException, ClassNotFoundException {
		System.out.println("Admin: " + a.toString());
		System.out.println("Please,press Q to quit profile");
		String action = br.readLine();
		if(action.equals("Q"))
			action();
	}
	
	static void addUser() throws IOException, ClassNotFoundException {
		System.out.println("First name of user:");
		String firstName = br.readLine();
		System.out.println("Lastname of user:");
		String lastName = br.readLine();
		System.out.println("Login of user:");
		String login = br.readLine();
		System.out.println("Password of user:");
		String password = br.readLine();
		System.out.println("Age of user:");
		int age = Integer.parseInt(br.readLine());
		System.out.println("Phone number of user:");
		int phoneNumber = Integer.parseInt(br.readLine());
		
		System.out.println("Please,can you write who you want to ADD:");		
		while(true) {
			System.out.println("1. Manager");
			System.out.println("2. Executor");
			System.out.println("3. Teacher");
			System.out.println("4. Student");
			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			Data.admin.addManager(login, password, firstName, lastName,age,phoneNumber);
			break;
			
		case "2":
			Data.admin.addExecutor(login, password, firstName, lastName,age,phoneNumber);
			break;
		case "3":
			Vector<CourseFile> files = new Vector<CourseFile>();
			Data.admin.addTeacher(login, password, firstName, lastName,age,phoneNumber,files);
			break;
		case "4":
			Vector<Mark> mark = new Vector<Mark>();
			Data.admin.addStudent(login, password, firstName, lastName,age,phoneNumber,mark);
			break;
		default:
			System.out.println("Oops error,repeat please");
			action();
		}
		break;
		}
	}
	
	private static void deleteUser() throws IOException, ClassNotFoundException {
		System.out.println("You are trying to delete a user. Write login: ");
		System.out.println("If you want to quit press Q");
		String login = br.readLine();
		if(login.equals("Q")) {
			action();}
		else 
			Data.admin.removeUser(login);
			System.out.println("Successfully!!!");
			action();
		}
	
	
	private static void updateUser() throws ClassNotFoundException, IOException {
		data.desUser();
//		System.out.println("Login of user:");
//		String login = br.readLine();
//		Executor e = Data.Executors.get(login);
//		
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
			action();
		}
	

	private static void logOut() throws ClassNotFoundException, IOException {
		data.desUser();
	    data.serUser();
		Controller.question();
		
	}
}
