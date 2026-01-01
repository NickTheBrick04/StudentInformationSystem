import java.util.ArrayList;

public class Professor extends Person{
private ArrayList<Course> teachingCourses;

public Professor(String name, String id){
	super(name,id);
	teachingCourses = new ArrayList<>();
}
public void assignCourse(Course c){
	//adds course to teaching list
	teachingCourses.add(c);
}

public void listTeachingCourses(){
	if(teachingCourses.size()==0){
		System.out.println("This teacher has no courses");
	}
	for(int i=0; i<teachingCourses.size();i++){
		System.out.printf("Course %d : %s \n",i,teachingCourses.get(i));
	}
}

@Override
public String getRole(){
	return "Professor";
}

}
