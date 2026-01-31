
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

public class DataManager{
	
	// going to save each students information in words then next student on next line
public static void saveStudentsToFile(ArrayList<Student> students, String fileName){
	try(PrintWriter fileS=new PrintWriter(fileName)){
		for(Student s: students){
			fileS.println(s.getName()+ " "+ s.getID()+" "+s.calculateTuition());
			
		}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
		
}

public static void saveProfessorsToFile(ArrayList<Professor> professors, String fileName){
	try(PrintWriter fileS=new PrintWriter(fileName)){
		for(Professor p: professors){
			fileS.println(p.getName()+ " "+ p.getID());
			
		}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
}

public static void saveCoursesToFile(ArrayList<Course> courses,String fileName){
	try(PrintWriter fileS = new PrintWriter(fileName)){
		for(Course p: courses){
			fileS.println(p.getCourseTitle()+ " " + p.getCourseCredits());
		}
	}catch(FileNotFoundException e){
		System.out.println("There was an error: " + e.getMessage());
	}
}



public ArrayList<Student> loadStudentsFromFile(String filename) {
    ArrayList<Student> students = new ArrayList<>();
    File file = new File(filename);

    try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("[,\\s]+"); // handles comma or space separation
            if (parts.length != 3) {
                
                continue;
            }

            String name = parts[0];
            String id = parts[1];
            double tuition;

            try {
                tuition = Double.parseDouble(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid tuition value in line: " + line);
                continue;
            }

            students.add(new Student(name, id, tuition));
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found - " + filename);
    }

    return students;
}

public ArrayList<Professor> loadProfessorFromFile(String fileName){
	ArrayList<Professor> professors = new ArrayList<>();
	File file = new File(fileName);
	
	try(Scanner sc = new Scanner(file)){
		while(sc.hasNextLine()){
			String line = sc.nextLine().trim();
			if(line.isEmpty()) continue;
			
			String[] parts = line.split("[,//s]+");
			if(parts.length!=2) continue;
			
			String name = parts[0];
			String id = parts[1];
			
			professors.add(new Professor(name, id));
		}
	}catch (FileNotFoundException e){
		System.out.println("Error: File not found - " + fileName);
	}
	return professors;
}

public ArrayList<Course> loadCourseFromFile(String fileName){
	ArrayList<Course> loadedCourses = new ArrayList<>();
	File file = new File(fileName);
	
	try(Scanner sc = new Scanner(file)){
		while(sc.hasNextLine()){
			String line = sc.nextLine().trim();
			if(line.isEmpty()) continue;
			
			String[] parts = line.split("[,//s]+");
			if(parts.length != 2) continue;
			
			String name = parts[0];
			int credits;
			
		
		try{ 
			credits = Integer.parseInt(parts[1]);
		}catch(NumberFormatException e){
			System.out.println("Invalid credit number in line " + line);
			continue;
		}
		loadedCourses.add(new Course(name,credits));
	}
	}catch(FileNotFoundException e){
		System.out.println("Error: File not found - " + fileName);
	}
	return loadedCourses;
}

public static void listAllCourses(ArrayList<Course> allCourses){
	System.out.println("");
	if(allCourses.isEmpty()) System.out.println("There are no courses in list");
	for(Course c: allCourses){
		System.out.printf("Course: %s | Credits: %d \n", c.getCourseTitle(), c.getCourseCredits());
	}
	System.out.println("");
}
public static void listAllProfessors(ArrayList<Professor> allProfessors){
	System.out.println("");
	if(allProfessors.isEmpty()) System.out.println("There are no professors in list");
	for(Professor p: allProfessors){
		System.out.printf("Professor: %s | ID: %s", p.getName(), p.getID());
	}
	System.out.println("");
}

}





