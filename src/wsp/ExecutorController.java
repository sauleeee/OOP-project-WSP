package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;

public class ExecutorController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7175546630004480665L;
	static Data data = Data.getInstance();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Executor executor = (Executor) Controller.u;
	static HashSet<Order> Orders = new HashSet<Order>();

	public static void executorType(Executor executor) throws IOException, ClassNotFoundException {
		System.out.println("Welcome executor: " + executor.getFirstName());
		action(executor);
		
	}

	private static void action(Executor executor) throws IOException, ClassNotFoundException {
		System.out.println("What action would you want? ");

		while(true) {
			System.out.println("1. View MyProfile");
			System.out.println("2. View Order");
			System.out.println("3. View new Order");
			System.out.println("4. view Executed Order()");
			System.out.println("5. View order in process");
			System.out.println("6. Logout");
			String action = br.readLine();
		
		if (action == null) {
			break;
		}

		switch (action) {
		case "1":
			viewMyProfile(executor);
			break;
		case "2":
			viewOrder();
			break;
		case "3":
			viewNewOrder();	 
			break;
		case "4":
			viewExecutedOrder();	 
			break;
		case "6":
			logOut();
		default:
			System.out.println("There is no such index,repeat please");
			action(executor);
		}
		}
	}
	
	private static void viewMyProfile(Executor executor) throws IOException, ClassNotFoundException {
		System.out.println("Executor: " + executor.toString());
		System.out.println("Please,press Q to quit profile");
		String action = br.readLine();
		if(action.equals("Q"))
			action(executor);
		
	}
	private static void viewOrder() throws IOException, ClassNotFoundException {
		data.deserializeOrder();
		for (Order u : Data.Orders) {
			System.out.println(u.getTopic());
		}
		
		
		System.out.println("Write the name of the order to get INFORMATION:");
		String topic = br.readLine();
		
		  for(Order order :Data.Orders) {
			if(order.getTopic().equals(topic)) {
				  System.out.println(order.toString());
				
			}
			}
		  System.out.println("Please,press Q to quit profile");
			String action2 = br.readLine();
			if(action2.equals("Q"))
				action(executor);
		
	}
		private static void viewNewOrder() throws ClassNotFoundException, IOException {
			data.deserializeOrder();
			for (Order u : Data.Orders) {
				if(u.getType()!= OrderType.ACCEPTED) {
					System.out.println(u);
		}}
	}
	
		public void addOrder(Order order) throws IOException {
			Data.Orders.add(order);
			data.serializeOrder();
		}
		
		
		public static void viewExecutedOrder() {
			for(Order o: Data.Orders) {
				if(o.getType() == OrderType.DONE) {
					System.out.println(o);
				}
			}
			
		}
		
	
		private static void reject(Order order) throws ClassNotFoundException, IOException {
			data.deserializeOrder();
			Data.Orders.add(order);
			data.serializeOrder();
		
		}

		private static void accept(Order order) throws ClassNotFoundException, IOException {
			if(order.getType() != OrderType.ACCEPTED) {
			//	order.accept();
			}
		
		}



	private static void logOut() throws ClassNotFoundException, IOException {
		Controller.question();
		
	}

	
}
