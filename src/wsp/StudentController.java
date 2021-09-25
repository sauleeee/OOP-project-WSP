package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;

public class StudentController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6889601276401473969L;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Student student = (Student) Controller.u;
	static Course course;
	static Data data = Data.getInstance();
	
	
	public static void studentType(Student student) throws ClassNotFoundException, IOException {
		System.out.println("Welcome student: " + student.getFirstName());
		action(student);
	}
	
		
		public static void action(Student student) throws ClassNotFoundException, IOException{
			System.out.println("What action would you want? ");
		
			while(true) {
			System.out.println("1. View My Profile");
			System.out.println("2. View Courses");
			System.out.println("3. Register for a course");
			System.out.println("4. View Marks");
			System.out.println("5. View Teachers");
			System.out.println("6. View Course File");
			System.out.println("7. View Transcript");
			System.out.println("8. Logout");
			String action = br.readLine();

			if (action == null) {
				break;
			}

			switch (action) {
			case "1":
				viewMyProfile(student);
				break;
			case "2":
				viewCourses();
				break;
			case "3":
				registerForCourse(student);
				break;
			case "4":
				viewMarks(student);
				break;
			case "5":
				viewTeachers();
				break;
			case "6":
				viewCourseFile();
				break;
			case "7":
				viewTranscript();
			case "8":
				logOut();
			default:
			System.out.println("There is no such index,repeat please");
			}
			}

	}
		
		private static void viewMyProfile(Student student) throws IOException, ClassNotFoundException {
			System.out.println("Student: " + student.toString());
			System.out.println("Please,press Q to quit profile");
			String action = br.readLine();
			if(action.equals("Q"))
				action(student);
			
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

			System.out.println("Please,press Q if you want to quit");
			String action2 = br.readLine();
			if(action2.equals("Q")) {
				action(student);
			}
		}
		
		
		private static void registerForCourse(Student student) throws IOException, ClassNotFoundException {
			data.deserializeCourses();
			for(Course c: Data.Courses) {
				System.out.println(c);
			}
			int c = Integer.parseInt(br.readLine());
			Course selectedCourse = Data.Courses.get(c-1);
			student.course.add(selectedCourse);
			data.serializeStudent();
			
		}
		
		
		
		private static void viewMarks(Student student) {
			for(Mark m: student.mark) {
				System.out.println(m);
			}
			
			
			
		}
		
		
		private static void viewTeachers() throws IOException, ClassNotFoundException {
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
					action(student);
		}
		
		
		
		private static void viewCourseFile() throws IOException {
			System.out.println("Write the name and lastname of the teacher to get INFORMATION:");
			String firstName = br.readLine();
			String lastName = br.readLine();
			Teacher t = new Teacher();
			for(Teacher teacher :Data.Teachers) {
				if(teacher.getFirstName().equals(firstName) && teacher.getLastName().equals(lastName)) {
					  t = teacher;
				}
				}
			for(CourseFile c: t.files) {
				System.out.println(c);
			}
			
			}
				
		
		
		
		private static void viewTranscript() {
			System.out.println("Student transcript:");
			
		}
		

			
		
		private static void logOut() throws ClassNotFoundException, IOException {
			Controller.question();
			System.out.println("You are logget out");
			
		}
}
