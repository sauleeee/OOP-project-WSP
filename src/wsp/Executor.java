package wsp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Executor extends Employee implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1410722204404616554L;
		Data data = Data.getInstance();
		
		public Executor() {}
		public Executor(String login,String password,String firstName, String lastName,int age,int phoneNumber) {
			super(login,password,firstName,lastName,age,phoneNumber);
		}
	
		
		
		
		public boolean equals(Object o) {
			if(!super.equals(o)) return false;
			Executor e = (Executor)o;
			return this.login.equals(e.login);
		}
		
		public int compareTo(Executor e){
		     return firstName.compareTo(e.getFirstName());
	   }
		
		public int hashCode() {
			return super.hashCode();	
		}
		public String toString() {
			return "Executor:" + super.toString();	
		}

		
}
