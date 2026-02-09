
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager{

private static String ensureCSV(String fileName){
    if(!fileName.endsWith(".csv")){
	fileName += ".csv";
	}
	return "data/" + fileName; 
}
	
	// going to save each students information to .csv file
public static void saveStudentsToFile(ArrayList<Student> students, String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS=new PrintWriter(fileName)){
		fileS.println("name,id,tuition");
		for(Student s: students){
			fileS.printf("%s,%s,%.2f\n",s.getName(),s.getID(),s.getTuition());
		}
	}
		catch(FileNotFoundException e){
			System.out.println("Error: "+ e.getMessage());
		}
}


public static void saveProfessorsToFile(ArrayList<Professor> professors, String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS=new PrintWriter(fileName)){
		fileS.println("name,id");
		for(Professor p: professors){
    		fileS.printf("%s,%s\n", p.getName(), p.getID());
}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
}

public static void saveCoursesToFile(ArrayList<Course> courses,String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS = new PrintWriter(fileName)){
		fileS.println("title,credits");
		for(Course p: courses){
			fileS.printf("%s,%d\n",p.getCourseTitle(), p.getCourseCredits());
		}
	}catch(FileNotFoundException e){
		System.out.println("There was an error: " + e.getMessage());
	}
}



public static ArrayList<Student> loadStudentsFromFile(String filename) {
    ArrayList<Student> students = new ArrayList<>();
    File file = new File(DataManager.ensureCSV(filename));

    try (Scanner sc = new Scanner(file)) {
		//skip header
		if(sc.hasNextLine()) sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(","); // handles comma or space separation
            if (parts.length != 3) continue;

            String name = parts[0].trim();
            String id = parts[1].trim();
            double tuition = Double.parseDouble(parts[2].trim());

            students.add(new Student(name, id, tuition));
        }
    } catch (Exception e) {
        System.out.println("Error loading file: " + e.getMessage());
    }

    return students;
}

public static ArrayList<Professor> loadProfessorFromFile(String fileName){
	ArrayList<Professor> professors = new ArrayList<>();
	File file = new File(DataManager.ensureCSV(fileName));

	try(Scanner sc = new Scanner(file)){
		if(sc.hasNextLine()) sc.nextLine();
		while(sc.hasNextLine()){
			String line = sc.nextLine().trim();
			if(line.isEmpty()) continue;
			
			String[] parts = line.split(",");
			if(parts.length!=2) continue;
			
			String name = parts[0];
			String id = parts[1];
			
			professors.add(new Professor(name, id));
		}
	}catch (FileNotFoundException e){
		System.out.println("Error loading file: " + fileName);
	}
	return professors;
}

public static ArrayList<Course> loadCourseFromFile(String fileName){
	ArrayList<Course> loadedCourses = new ArrayList<>();
	File file = new File(DataManager.ensureCSV(fileName));
	
	try(Scanner sc = new Scanner(file)){
	if(sc.hasNextLine()) sc.nextLine();
		while(sc.hasNextLine()){
			String line = sc.nextLine().trim();
			if(line.isEmpty()) continue;
			
			String[] parts = line.split(",");
			if(parts.length != 2) continue;
			
			String name = parts[0];
			int credits=Integer.parseInt(parts[1]);

			loadedCourses.add(new Course(name, credits));
		}
	}catch(Exception e){
		System.out.println("Error loading file: " + fileName);
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
		System.out.printf("Professor: %s | ID: %s\n", p.getName(), p.getID());
	}
	System.out.println("");
}

public static Professor findProfessor(String searchProf, ArrayList<Professor> allProfessors){
	for(Professor p: allProfessors){
		searchProf = searchProf.toLowerCase();
		if(p.getName().toLowerCase().equals(searchProf)){
			return p;
		}
	}
	return null;
}

public static Course searchCourse(String sCourse, ArrayList<Course> allCourses){
	if(allCourses.isEmpty()){
		System.out.println("The list is empty");
		return null;
	}
	sCourse = sCourse.toLowerCase();
	for(Course c: allCourses){
		if(c.getCourseTitle().toLowerCase().equals(sCourse)){
			return c;
		}
		}
		System.out.println("Couldn't Find"+sCourse);
		return null;
	}
}








