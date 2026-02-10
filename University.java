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

public HashMap<String, Student> getStudents(){
    return students;
}

public HashMap<String, Professor> getProfessors(){
    return professors;
}

public HashMap<String, Course> getCourses(){
    return courses;
}


public boolean addStudent(Student s){
    String key = s.getID().trim().toLowerCase();

    if(students.containsKey(key))
        return false;

    students.put(key, s);
    return true;
}


public boolean  addProfessor(Professor p){
	String key = p.getID().trim().toLowerCase();

	if(professors.containsKey(key))
		return false;

	professors.put(key, p);
	return true;
}

public boolean addCourse(Course c){
	String key = c.getCourseTitle().trim().toLowerCase();

	if(courses.containsKey(key))
		return false;

	courses.put(key, c);
	return true;
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

public boolean removeStudent(String id){
	return students.remove(id.toLowerCase()) != null;
}

public boolean removeProfessor(String id){
    return professors.remove(id.toLowerCase()) != null;
}

public boolean removeCourse(String title){
    return courses.remove(title.toLowerCase()) != null;
    }

public void listAllCourses(){
	System.out.println("");
	if(this.courses.isEmpty()) System.out.println("There are no courses in list");
	for(Course c: this.courses.values()){
		System.out.printf("Course: %s | Credits: %d \n", c.getCourseTitle(), c.getCourseCredits());
	}
	System.out.println("");
}
public void listAllProfessors(){
	System.out.println("");
	if(this.professors.isEmpty()) System.out.println("There are no professors in list");
	for(Professor p: this.professors.values()){
		System.out.printf("Professor: %s | ID: %s\n", p.getName(), p.getID());
	}
	System.out.println("");
}

public Course searchCourse(String sCourse){
	if(this.courses.isEmpty()){
		System.out.println("The list is empty");
		return null;
	}
	sCourse = sCourse.toLowerCase();
	if(this.courses.containsKey(sCourse)){
		return courses.get(sCourse);
	}
	System.out.println("Couldn't Find"+sCourse);
	return null;
}
}

