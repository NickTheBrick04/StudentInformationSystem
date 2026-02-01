public class Course{
private String title;
private int credits;

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
