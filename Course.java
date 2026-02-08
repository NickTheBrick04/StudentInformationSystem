public class Course{
private final String title;
private final int credits;

public Course(String title,int credits){
	this.title=title;
	this.credits=credits;
}

public String getCourseTitle(){
	return this.title;
}

public int getCourseCredits(){
	return this.credits;
}
}
