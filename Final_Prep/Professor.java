import java.util.ArrayList;

public class Professor extends Person{
private final ArrayList<Course> teachingCourses;

public Professor(String name, String id){
	super(name,id);
	teachingCourses = new ArrayList<>();
}
public void assignCourse(Course c){
	//adds course to teaching list
	teachingCourses.add(c);
	System.out.println("\nCourse assigned\n");
}

public void removeTeachingCourse( String rmCourse){
	if(teachingCourses.isEmpty()) System.out.println("The list is empty");
	for(Course n: teachingCourses){
		if(n.getCourseTitle().toLowerCase().equals(rmCourse)){
			
			teachingCourses.remove(n);
			System.out.println("\nThe course was removed\n");
			return;
		}
	}
		System.out.println("There was an error or the list doesn't contain that course");
	
}

public void listTeachingCourses(){
	if(teachingCourses.isEmpty()){
		System.out.println("This teacher has no courses");
	}
	int count =1;
	System.out.printf("\n");
	for(Course c: teachingCourses){
		System.out.printf("Course #: %d | Title: %s | Credits: %d \n",count,c.getCourseTitle(),c.getCourseCredits());
		count++;
	}
	System.out.printf("\n");
}

@Override
public String getRole(){
	return "Professor";
}

}
