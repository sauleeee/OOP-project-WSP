package wsp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Vector;

public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3687448572749462892L;
	private static  Data Instance = new Data();
	
	private Data(){}
	
	public static Data getInstance() {
		return Instance;
	}
	
	
	
	public static HashSet<Employee> Employees = new HashSet<Employee>();
	public static HashSet<Admin> Admins = new HashSet<Admin>();
	public static HashSet<Manager> Managers = new HashSet<Manager>();
	public static HashSet<Teacher> Teachers = new HashSet<Teacher>();	
	public static HashSet<Executor> Executors = new HashSet<Executor>();	
	public static HashSet<Student> Students = new HashSet<Student>();	
	public static Vector<Course> Courses = new Vector<Course>();	
	public static HashSet<Order> Orders = new HashSet<Order>();	

	
	
	public  void serAll() throws IOException {
		serializeAdmin();
		serializeManager();
		serializeExecutor();
		serializeTeacher();
		serializeStudent();
		serializeCourses();
		serializeOrder();
	}	
	
	public void desAll() throws ClassNotFoundException, IOException {
		deserializeAdmin();
		deserializeManager();
		deserializeExecutor();
		deserializeTeacher();
		deserializeStudent();
		deserializeCourses();
		deserializeOrder();
	}
	
	public  void serUser() throws IOException {
		serializeManager();
		serializeExecutor();
		serializeTeacher();
		serializeStudent();
	}	
	
	public void desUser() throws ClassNotFoundException, IOException {
		deserializeManager();
		deserializeExecutor();
		deserializeTeacher();
		deserializeStudent();
	}
	
	
/*SERIALIZATION*/	
	/*USERS*/
	public void serializeAdmin() throws IOException {
		FileOutputStream fos = new FileOutputStream("admins");
		ObjectOutputStream admin = new ObjectOutputStream(fos);
		admin.writeObject(Admins);
		admin.flush();
		admin.close();
	}
	public void serializeManager() throws IOException {
		FileOutputStream fos = new FileOutputStream("managers");
		ObjectOutputStream manager = new ObjectOutputStream(fos);
		manager.writeObject(Managers);
		manager.flush();
		manager.close();
	}
	public void serializeExecutor() throws IOException {
		FileOutputStream fos = new FileOutputStream("executors");
		ObjectOutputStream executor = new ObjectOutputStream(fos);
		executor.writeObject(Executors);
		executor.flush();
		executor.close();
	}
	public void serializeTeacher() throws IOException {
		FileOutputStream fos = new FileOutputStream("teachers");
		ObjectOutputStream teacher = new ObjectOutputStream(fos);
		teacher.writeObject(Teachers);
		teacher.flush();
		teacher.close();
	}
	public  void serializeStudent() throws IOException {
		FileOutputStream fos = new FileOutputStream("students");
		ObjectOutputStream student = new ObjectOutputStream(fos);
		student.writeObject(Students);
		student.flush();
		student.close();
	}
	
	/*OTHER*/
	public void serializeCourses() throws IOException {
		FileOutputStream fos = new FileOutputStream("courses");
		ObjectOutputStream course = new ObjectOutputStream(fos);
		course.writeObject(Courses);
		course.flush();
		course.close();
	}
	public void serializeOrder() throws IOException {
		FileOutputStream fos = new FileOutputStream("orders");
		ObjectOutputStream order = new ObjectOutputStream(fos);
		order.writeObject(Orders);
		order.flush();
		order.close();
	}
	
	
/*DESERIALIZATION*/
	/*USERS*/
	public HashSet<Admin> deserializeAdmin() throws IOException, ClassNotFoundException {
		try {
		FileInputStream fis = new FileInputStream("admins");
		ObjectInputStream admin = new ObjectInputStream(fis);
		Admins= (HashSet<Admin>)admin.readObject();
		admin.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Admins;
	}
	public HashSet<Manager> deserializeManager() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("managers");
		ObjectInputStream manager = new ObjectInputStream(fis);
		Managers = (HashSet<Manager>)manager.readObject();
		manager.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Managers;
	}
	public HashSet<Executor> deserializeExecutor() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("executors");
		ObjectInputStream executor = new ObjectInputStream(fis);
		Executors = (HashSet<Executor>)executor.readObject();
		executor.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Executors;
	}
	
	public HashSet<Teacher> deserializeTeacher() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("teachers");
		ObjectInputStream teacher = new ObjectInputStream(fis);
		Teachers = (HashSet<Teacher>)teacher.readObject();
		teacher.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Teachers;
	}

	public  HashSet<Student> deserializeStudent() throws IOException, ClassNotFoundException {
		try {
		FileInputStream fis = new FileInputStream("students");
		ObjectInputStream student  = new ObjectInputStream(fis);
		Students = (HashSet<Student>)student.readObject();
		student.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Students;
	}
	
	
	/*OTHER*/	
	public Vector<Course> deserializeCourses() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("courses");
		ObjectInputStream course = new ObjectInputStream(fis);
		Courses = (Vector<Course>)course.readObject();
		course.close();
		}
		catch(EOFException e) {}
		return Courses;
	}	
	
	public HashSet<Order> deserializeOrder() throws IOException, ClassNotFoundException {
		try {
		FileInputStream fis = new FileInputStream("orders");
		ObjectInputStream order = new ObjectInputStream(fis);
		Orders= (HashSet<Order>)order.readObject();
		order.close();
		}
		catch(EOFException e) {}
		return Orders;
	}
	
	public static Admin admin = new Admin();
	public static Manager manager = new Manager();
	public static Teacher teacher = new Teacher();
	public static Student student = new Student();
	public static Executor executor = new Executor();
	public static Course course = new Course();
	public static Order order = new Order();
	
}
