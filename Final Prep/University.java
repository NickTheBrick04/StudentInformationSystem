import java.util.ArrayList;

public class University{
private String name;
private ArrayList<Student> students;
private ArrayList<Professor> professor;
private ArrayList<Course> courses;

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

public void listPeople(){
	int count=0;
	for(Student s: students){
		System.out.printf("%s is a %s \n" ,s.getName() ,s.getRole());
		count++;
	}
	for(Professor p: professor){
		System.out.printf("%s is a %s \n", p.getName() ,p.getRole() );
		count++;
	}
	
	System.out.printf("There are %d students and professors", count);
	
}

}
