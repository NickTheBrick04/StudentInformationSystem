public abstract class Person{
private String name;
private String id;

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
