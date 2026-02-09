package Final_Prep;


import java.util.ArrayList;
import java.util.HashMap;

public class University{
private final String name;

private final HashMap<String, Student> students;
private final HashMap<String, Professor> professors;
private final HashMap<String, Course> courses;

public University(String name){
	this.name=name;
	this.students = new HashMap<>();
	this.professors = new HashMap<>();
	this.courses = new HashMap<>();

}

public String getUniversityName(){
	return this.name;
}

public Student getStudent(String id){
    return students.get(id.toLowerCase());
}

public Professor getProfessor(String id){
    return professors.get(id.toLowerCase());
}

public Course getCourse(String title){
    return courses.get(title.toLowerCase());
}

public void addStudent(Student s){
	students.put(s.getID().toLowerCase(),s);
}

public void addProfessor(Professor p){
	professors.put(p.getID().toLowerCase(),p);
}

public void addCourse(Course c){
    courses.put(c.getCourseTitle().toLowerCase(), c);
}

public void listThings(){
	int count1=0;
	int count2=0;
	int count3=0;
	for(Student s : students.values()){
		System.out.printf("Name: %s | Role: %s | ID: %s | Tuition: %.2f \n" ,s.getName() ,s.getRole(), s.getID(),s.getTuition());
		count1++;
	}
	for(Professor p : professors.values()){
		System.out.printf("Name: %s | Role: %s | ID: %s \n", p.getName() ,p.getRole(),p.getID() );
		count2++;
	}
	for(Course c : courses.values()){
		System.out.printf("Title: %s | Credits: %d\n", c.getCourseTitle(),c.getCourseCredits());
		count3++;
	}
	
	System.out.printf("There are %d students, %d professors, and %d courses.\n\n", count1,count2,count3);
	
}

public void removeStudent(String id){
	students.remove(id.toLowerCase());
}

public void removeProfessor(String id){
    professors.remove(id.toLowerCase());
}

public void removeCourse(String title){
    courses.remove(title.toLowerCase());
    }

public static void listAllCourses(HashMap<String,Course> allCourses){
	System.out.println("");
	if(allCourses.isEmpty()) System.out.println("There are no courses in list");
	for(Course c: allCourses.values()){
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

public static Course searchCourse(String sCourse, HashMap<String, Course> allCourses){
	if(allCourses.isEmpty()){
		System.out.println("The list is empty");
		return null;
	}
	sCourse = sCourse.toLowerCase();
	for(Course c: allCourses.values()){
		if(c.getCourseTitle().toLowerCase().equals(sCourse)){
			return c;
		}
		}
		System.out.println("Couldn't Find"+sCourse);
		return null;
	}
}

