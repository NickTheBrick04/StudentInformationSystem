
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

public class DataManager{
	
	// going to save each students information in words then next student on next line
public static void saveStudentsToFile(ArrayList<Student> students, String filename){
	try(PrintWriter fileS=new PrintWriter(filename)){
		for(Student s: students){
			fileS.println(s.getName()+ " "+ s.getID()+" "+s.calculateTuition());
			
		}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
}

public static void saveProfessorsToFile(ArrayList<Professor> professors, String filename){
	try(PrintWriter fileS=new PrintWriter(filename)){
		for(Professor p: professors){
			fileS.println(s.getName()+ " "+ s.getID());
			
		}
		}catch(FileNotFoundException e){
			System.out.println("There was an error:" + e.getMessage());
		}
}


public ArrayList<Student> loadStudentsFromFile(String filename){
	ArrayList<Student> students = new ArrayList<>();
	File file=new File(filename);
	try(Scanner sc=new Scanner(file)){
		while(sc.hasNext()){
			String name=sc.next();
			String id=sc.next();
			double tuition=sc.nextDouble();
			sc.nextLine();
			Student s = new Student(name,id,tuition);
			students.add(s);
		}
	}catch(FileNotFoundException e){
		System.out.println("Error with file: "+ e.getMessage());
	}
	
	return students;
}


}

