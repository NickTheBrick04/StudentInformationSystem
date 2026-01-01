import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Create some courses
        Course c1 = new Course("COP3330", 3);
        Course c2 = new Course("CEN3031", 3);
        Course c3 = new Course("CNT4007", 4);

        // 2. Create students
        Student s1 = new Student("Nick", "S123",0);
        Student s2 = new Student("Alice", "S456",0);

        // Register courses
        s1.registerCourse(c1);
        s1.registerCourse(c2);
        s2.registerCourse(c3);
     

        // 3. Create professors
        Professor p1 = new Professor("Dr. Smith", "P987");
        Professor p2 = new Professor("Dr. Johnson", "P654");

        // Assign courses
        p1.assignCourse(c1);
        p2.assignCourse(c3);

        // 4. Create a university and add people/courses
        University ucf = new University("University of Central Florida");
        ucf.addStudent(s1);
        ucf.addStudent(s2);
        ucf.addProfessor(p1);
        ucf.addProfessor(p2);
        ucf.addCourse(c1);
        ucf.addCourse(c2);
        ucf.addCourse(c3);

        // 5. List people in the university
        System.out.println("=== University People ===");
        ucf.listPeople();
        s1.listCourses();

        // 6. Show student tuition calculations
        System.out.println("\n=== Tuition ===");
        System.out.printf("%s owes $%.2f%n", s1.getName(), s1.calculateTuition());
        System.out.printf("%s owes $%.2f%n", s2.getName(), s2.calculateTuition());
        
        Scanner in = new Scanner(System.in);
        //selectable menu
        System.out.println("=== University Database ===");
        System.out.println("What would you like to do?");
        System.out.println("1. Import Menu");
        System.out.println("2. Add Course");
        System.out.println("3. Add Professor");
        System.out.println("4. Add Student");
        System.out.println("5. Enter Student Interface");
        System.out.println("6. Enter Professor Interface");
        System.out.println("7. Exit");
		int answer = 0;
		answer = in.nextInt();
		
		ArrayList<Student> allStudents = new ArrayList<>();
		ArrayList<Professor> allProfessors = new ArrayList<>();
		ArrayList<Course> allCourses = new ArrayList<>();
		
		while(answer != 7){
        //create response repository 
		switch(answer){
			//Access files containing information from previous sessions and add to arrayLists
			case 1:
				System.out.println("=== Import Menu ===");
				System.out.println("1. Import previous student data");
				System.out.println("2. Import previous professor data");
				System.out.println("3. Import previous course data");
				System.out.println("4. Import previous University");
				System.out.println("5. Back");
				int answer3 = 0;
				answer3 = in.nextInt();
				
				while(answer3 != 5){
					switch(answer3){
						case 1:
							
						
			// Add new course to allCourses and ucf
			case 2:
				answer=0;
				System.out.println("What is the title and number?");
				String courseName = in.next();
				System.out.println("How many credit hours?");
				int courseNumber = in.nextInt();
				in.nextLine();
				Course d1 = new Course(courseName , courseNumber);
				allCourses.add(d1);
				ucf.addCourse(d1);
				break;
				
			//Add new Professor to allProfessors and ucf
			case 3:
				answer=0;
				System.out.println("What is the professors name?");
				String profName = in.next();
				System.out.println("What is their ID number?");
				String profID = in.next();
				Professor f1 = new Professor(profName, profID);
				allProfessors.add(f1);
				ucf.addProfessor(f1);
				break;
				
			//Add new student to allStudents and to ucf
			case 4: 
				answer=0;
				System.out.println("What is the students name?");
				String studName = in.next();
				System.out.println("What is their ID number?");
				String studID = in.next();
				System.out.println("How much tuition are they paying now?");
				int studTuition = in.nextInt();
				Student g1 = new Student(studName, studID, studTuition);
				allStudents.add(g1);
				ucf.addStudent(g1);
				break;
				
			// access student specific menu, view all, search specific, and save current students
			case 5:
				System.out.println("=== Student Database ===");
				System.out.println("1. View all students");
				System.out.println("2. Search student");
				System.out.println("3. Load current students");
				System.out.println("3. Save current students");
				System.out.println("4. Back");
				int answer2 = 0;
				answer2 = in.nextInt();
				
				while(answer2 != 4){
					switch(answer2){
						case 1:
							ArrayList<Student> loadedStudents = new DataManager().loadStudentsFromFile("students_file.txt");
							System.out.println("\n=== Loaded Students from File ===");
							for (Student s : loadedStudents) {
								System.out.printf("%s (%s) tuition: %.2f %n", s.getName(), s.getID(), s.getTuition());
        }
			
			}
			
			System.out.println("=== University Database ===");
			System.out.println("What would you like to do?");
			System.out.println("1. Add Course");
			System.out.println("2. Add Professor");
			System.out.println("3. Add Student");
			System.out.println("4. Enter Student Interface");
			System.out.println("5. Enter Professor Interface");
			System.out.println("6. Exit");
			answer = 0;
			answer = in.nextInt();
		}
			
			
			
			
		
		
        // 7. Save students to file

        allStudents.add(s1);
        allStudents.add(s2);
        DataManager.saveStudentsToFile(allStudents, "students_file.txt");
        
        // 8. save professors to file
       // ArrayList<Professor> allProfessors = new ArrayList<>();
       // for(Professor s: allProfessors){
		//	allprofessors 

        // 9. Load students back from file
        ArrayList<Student> loadedStudents = new DataManager().loadStudentsFromFile("students_file.txt");

        System.out.println("\n=== Loaded Students from File ===");
        for (Student s : loadedStudents) {
            System.out.printf("%s (%s) tuition: %.2f %n", s.getName(), s.getID(), s.getTuition());
        }
    }
}
}
}
}
}


