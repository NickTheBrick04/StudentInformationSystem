import java.util.ArrayList;

public class University{
private final String name;
private final ArrayList<Student> students;
private final ArrayList<Professor> professor;
private final ArrayList<Course> courses;

public University(String name){
	this.name=name;
	this.students=new ArrayList<>();
	this.professor=new ArrayList<>();
	this.courses=new ArrayList<>();
}

public String getUniversityName(){
	return this.name;
}

public void addStudent(Student s){
	this.students.add(s);
}

public void addProfessor(Professor p){
	this.professor.add(p);
}

public void addCourse(Course c){
	this.courses.add(c);
}

public void listThings(){
	int count1=0;
	int count2=0;
	int count3=0;
	for(Student s: this.students){
		System.out.printf("Name: %s | Role: %s | ID: %s | Tuition: %.2f \n" ,s.getName() ,s.getRole(), s.getID(),s.getTuition());
		count1++;
	}
	for(Professor p: this.professor){
		System.out.printf("Name: %s | Role: %s | ID: %s \n", p.getName() ,p.getRole(),p.getID() );
		count2++;
	}
	for(Course c: this.courses){
		System.out.printf("Title: %s | Credits: %d\n", c.getCourseTitle(),c.getCourseCredits());
		count3++;
	}
	
	System.out.printf("There are %d students, %d professors, and %d courses.\n\n", count1,count2,count3);
	
}

public void removeStudent(Student s){
	this.students.remove(s);
}

public void removeProfessor(Professor p){
	this.professor.remove(p);
}

public void removeCourse(Course c){
	this.courses.remove(c);
}

}
