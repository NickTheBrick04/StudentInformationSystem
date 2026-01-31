import java.util.ArrayList;

public class Student extends Person implements Payable{
private ArrayList<Course> courses;
private double tuition;

public Student(String name, String id,double tuition){
	super(name,id);
	courses=new ArrayList<>();
	this.tuition=tuition;
}

public void registerCourse(Course c){
	// adds a course to arraylist
	courses.add(c);
}

public void removeStudentCourse( String rmCourse){
	if(courses.isEmpty()) System.out.println("The list is empty");
	else if(courses.contains(rmCourse)){
		courses.remove(rmCourse);
	}else{
		System.out.println("There was an error or the list doesn't contain that course");
	}
}

public void listCourses(){
	System.out.printf("\n %d \n", courses.size());
	if(courses.size()==0){
		System.out.println("There are no registered courses");
	}
	for(int i=0; i<courses.size();i++){
		System.out.printf("%s ", courses.get(i).getCourseTitle());
	}
}

@Override
public String getRole(){
	return "Student";
}

public double getTuition(){
	return this.tuition;
}

public double calculateTuition(){
	this.tuition=courses.size()*236.34;
	return courses.size()*236.34;
}


}
