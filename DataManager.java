

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataManager{

private static String ensureCSV(String fileName){
    if(!fileName.endsWith(".csv")){
	fileName += ".csv";
	}
	return "data/" + fileName; 
}
	
	// going to save each students information to .csv file
public static void saveStudentsToFile(HashMap<String,Student> students, String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS=new PrintWriter(fileName)){
		fileS.println("name,id,tuition");
		for(Student s: students.values()){
			fileS.printf("%s,%s,%.2f\n",s.getName(),s.getID(),s.getTuition());
		}
	}
		catch(FileNotFoundException e){
			System.out.println("Error: "+ e.getMessage());
		}
}


public static void saveProfessorsToFile(HashMap<String,Professor> professors, String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS=new PrintWriter(fileName)){
		fileS.println("name,id");
		for(Professor p: professors.values()){
    		fileS.printf("%s,%s\n", p.getName(), p.getID());
}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
}

public static void saveCoursesToFile(HashMap<String, Course> courses,String fileName){
	fileName = DataManager.ensureCSV(fileName);
	try(PrintWriter fileS = new PrintWriter(fileName)){
		fileS.println("title,credits");
		for(Course p: courses.values()){
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

}









