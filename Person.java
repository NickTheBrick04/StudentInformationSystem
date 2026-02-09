package Final_Prep;

public abstract class Person{
private final String name;
private final String id;

public Person(String name, String id){
	this.name=name;
	this.id=id;
}

public String getName(){
	return this.name;
}

public String getID(){
	return this.id;
}

public abstract String getRole();


}
