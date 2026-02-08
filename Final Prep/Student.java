import java.util.ArrayList;

public class Student extends Person implements Payable{
private final ArrayList<Course> courses;
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

public void removeStudentCourse(String title){
    for (Course c : courses) {
        if (c.getCourseTitle().equalsIgnoreCase(title)) {
            courses.remove(c);
            return;
        }
    }
    System.out.println("Course not found");
}

public void listCourses(){
	System.out.printf("\n %d \n", courses.size());
	if(courses.isEmpty()){
		System.out.println("There are no registered courses");
	}
	for(Course c: courses){
		System.out.printf("%s ", c.getCourseTitle());
	}
}

@Override
public String getRole(){
	return "Student";
}

public double getTuition(){
	return this.tuition;
}

@Override
public double calculateTuition(){
	this.tuition=courses.size()*236.34;
	return courses.size()*236.34;
}


}
