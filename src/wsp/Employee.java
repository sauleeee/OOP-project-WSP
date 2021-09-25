package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Employee extends User implements Cloneable,Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = -1263713271692624880L;
	
		protected int salary;
		protected int age;
		protected int phoneNumber;
		protected Date date;
		static Data data = Data.getInstance();
		
		Employee(){}
		public Employee(String login,String password,String firstName, String lastName,int age,int phoneNumber) {
			super(login,password,firstName,lastName);
			this.phoneNumber = phoneNumber;
			this.age = age;
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

		void sendOrder(String topic,String text,Date dateOfSend,String sender) throws IOException, ClassNotFoundException {
			Order o = new Order(topic,text,dateOfSend,sender);

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
			
			
			}
		
		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
		
		

		public int hashCode() {
			return super.hashCode() + Objects.hash(salary);
		}
		
		public String toString() {
			return super.toString() + " Age:" + this.getAge() + " Phone number:" + this.getPhoneNumber() + " Salary:" + this.getSalary() ;	
		}
		
		public boolean equals(Object o) {
			if(!super.equals(o)) return false;
			Employee e = (Employee)o;
			return  this.login.equals(e.login);
		}
		
		public int compareTo(Employee o) {
			if(salary > o.salary) return 1;
			else if(salary == o.salary) return 0;
			return -1;
		}
		public Object clone() throws CloneNotSupportedException {
			Employee e = (Employee) super.clone();
			e.date = (Date)date.clone();
			return e;
		}
		
}
