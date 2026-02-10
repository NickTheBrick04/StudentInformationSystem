
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
	calculateTuition();
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
	if(courses.isEmpty()){
		System.out.println("This student has no courses");
	}
	int count =1;
	System.out.printf("\n");
	for(Course c: courses){
		System.out.printf("Course #: %d | Title: %s | Credits: %d \n",count,c.getCourseTitle(),c.getCourseCredits());
		count++;
	}
	System.out.printf("\n");
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
