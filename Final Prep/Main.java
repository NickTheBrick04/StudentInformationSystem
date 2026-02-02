import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Create some courses
        Course c1 = new Course("COP3330", 3);
        Course c2 = new Course("CEN3031", 3);
        Course c3 = new Course("CNT4007", 4);

        // 2. Create students
        Student s1 = new Student("Nick", "S123",0);
        Student s2 = new Student("Alice", "S456",0);

        // Register courses
        s1.registerCourse(c1);
        s1.registerCourse(c2);
        s2.registerCourse(c3);
     

        // 3. Create professors
        Professor p1 = new Professor("Dr. Smith", "P987");
        Professor p2 = new Professor("Dr. Johnson", "P654");

        // Assign courses
        p1.assignCourse(c1);
        p2.assignCourse(c3);

        // 4. Create a university and add people/courses
        University ucf = new University("University of Central Florida");
        ucf.addStudent(s1);
        ucf.addStudent(s2);
        ucf.addProfessor(p1);
        ucf.addProfessor(p2);
        ucf.addCourse(c1);
        ucf.addCourse(c2);
        ucf.addCourse(c3);

        // 5. List people in the university
        System.out.println("=== University People ===");
        ucf.listPeople();
        s1.listCourses();

        // 6. Show student tuition calculations
        System.out.println("\n=== Tuition ===");
        System.out.printf("%s owes $%.2f%n", s1.getName(), s1.calculateTuition());
        System.out.printf("%s owes $%.2f%n", s2.getName(), s2.calculateTuition());
        
        
		
		ArrayList<Student> allStudents = new ArrayList<>();
		ArrayList<Professor> allProfessors = new ArrayList<>();
		ArrayList<Course> allCourses = new ArrayList<>();
		int answer = 0;
		Scanner in = new Scanner(System.in);
		while(answer != 6){
			
		
        //selectable menu
        System.out.println("=== University Database ===");
        System.out.println("What would you like to access?");
        System.out.println("1. Enter Import Menu");
        System.out.println("2. Enter Save Menu");
        System.out.println("3. Enter Course Menu");
        System.out.println("4. Enter Professor Menu");
        System.out.println("5. Enter Student Menu");
        System.out.println("6. Exit");
		
		answer = in.nextInt();
		in.nextLine();
		
        //create response repository 
		switch(answer){
			//Access files containing information from previous sessions and add to arrayLists
			case 1:
				int answer3 = 0;
				
				while(answer3 != 4){
					System.out.println("=== Import Menu ===");
					System.out.println("1. Import previous student data");
					System.out.println("2. Import previous professor data");
					System.out.println("3. Import previous course data");
					System.out.println("4. Back");
					answer3 = in.nextInt();
					in.nextLine();
					switch(answer3){
						
						case 1:
							System.out.println("What file do you want to load?");
							String nFile = in.next();
							ArrayList<Student> loadedStudents = new DataManager().loadStudentsFromFile(nFile);
							if(loadedStudents.isEmpty()) System.out.println("\n--- Invalid file ---\n");
							else System.out.println("\n--- Loaded Students from File ---\n");
						
							allStudents.addAll(loadedStudents);
							break;
							
						case 2:
							System.out.println("What file do you want to load?");
							nFile = in.next();
							ArrayList<Professor> loadedProfessors = new DataManager().loadProfessorFromFile(nFile);
							if(loadedProfessors.isEmpty()) System.out.println("\n--- Invalid File ---\n");
							else System.out.println("\n--- Loaded Professors from File ---\n");
							allProfessors.addAll(loadedProfessors);
							break;
						
						case 3:
							System.out.println("What file do you want to load?");
							nFile = in.next();
							ArrayList<Course> loadedCourses = new DataManager().loadCourseFromFile(nFile);
							if(loadedCourses.isEmpty()) System.out.println("\n--- Invalid File ---\n");
							else System.out.println("\n--- Loaded Courses from File ---\n");
							allCourses.addAll(loadedCourses);
							break;
							
						}
						System.out.println("=== Import Menu ===");
						System.out.println("1. Import previous student data");
						System.out.println("2. Import previous professor data");
						System.out.println("3. Import previous course data");
						System.out.println("4. Back");
						answer3 = 0;
						answer3 = in.nextInt();
						in.nextLine();
					}
					break;
					
					// save menu for students, professors, and courses
					case 2:
						int answer4 = 0;
						
						while (answer4!=4){
							System.out.println("=== Save Menu ===");
							System.out.println("1. Save current student data");
							System.out.println("2. Save current professor data");
							System.out.println("3. Save current course data");
							System.out.println("4. Back");
							
							answer4 = in.nextInt();
							in.nextLine();
							String fileName;
							
							switch(answer4){
								
								case 1:
									System.out.println("What would you like to name the file?");
									fileName= in.nextLine();
									DataManager.saveStudentsToFile(allStudents,fileName);
									
									break;
								
								case 2:
									System.out.println("What would you like to name the file?");
									fileName = in.nextLine();
									DataManager.saveProfessorsToFile(allProfessors,fileName);
									
									break;
									
								case 3:
									System.out.println("What would you like to name the file?");
									fileName = in.nextLine();
									DataManager.saveCoursesToFile(allCourses,fileName);
									
									break;
									
								}
							}break;
							
						
					// Add new course to allCourses and ucf
						case 3:
							int answer5 = 0;
							while(answer5!=5){
								System.out.println("=== Course Menu ===");
								System.out.println("1. List all courses");
								System.out.println("2. Search for a course");
								System.out.println("3. Add course");
								System.out.println("4. Remove course");
								System.out.println("5. Back");
								answer5 = in.nextInt();
								in.nextLine();
							switch(answer5){
								case 1:
									DataManager.listAllCourses(allCourses);
									break;
									
								case 2:
									break;
									
								case 3:
									System.out.println("What is the title and number?");
									String courseName = in.next();
									System.out.println("How many credit hours?");
									int courseNumber = in.nextInt();
									in.nextLine();
									Course d1 = new Course(courseName , courseNumber);
									allCourses.add(d1);
									ucf.addCourse(d1);
									break;
							}
							
						}break;
							
						//Add new Professor to allProfessors and ucf
						case 4:
							int answer7 = 0;
							while(answer7!= 7){
								System.out.println("=== Professor Menu ===");
								System.out.println("1. View All Professors");
								System.out.println("2. Search Professor");
								System.out.println("3. Add Professor");
								System.out.println("4. Remove Professor");
								System.out.println("5. View Professor Courses");
								System.out.println("6. Add or Remove Courses");
								System.out.println("7. Back");
								answer7 = in.nextInt();
								in.nextLine();
								switch(answer7){
									case 1:
										DataManager.listAllProfessors(allProfessors);
										break;
										
									case 2: 
										System.out.println("What Professor do you want to look for?");
										String searchProf = in.nextLine();
										Professor returnProf = DataManager.findProfessor(searchProf,allProfessors);
										if(returnProf == null){
											 System.out.println("Couldn't find the professor\n");
											 break;
										 }
										System.out.printf("\nName: %s | ID: %s\n", returnProf.getName(), returnProf.getID());
										break;
										
									case 3:
										System.out.println("What is the professors name?");
										String profName = in.next();
										System.out.println("What is their ID number?");
										String profID = in.next();
										Professor f1 = new Professor(profName, profID);
										allProfessors.add(f1);
										ucf.addProfessor(f1);
										break;
										
									case 4:
										System.out.println("What is the professors name?");
										String removeProfName = in.nextLine();
										Professor returnRemoveProf = DataManager.findProfessor(removeProfName,allProfessors);
										if(returnRemoveProf==null){
											System.out.println("\nCouldn't find professor\n");
											break;
										}
										System.out.println("\nProfessor removed!\n");
										allProfessors.remove(returnRemoveProf);
										break;
										
									case 5:
										System.out.println("What is the professors name?");
										String courseProfName = in.nextLine();
										Professor returnCourseProf = DataManager.findProfessor(courseProfName,allProfessors);
										if(returnCourseProf==null){
											System.out.println("\nCouldn't find the professor\n");
											break;
										}
										returnCourseProf.listTeachingCourses();
										break;
										
									case 6: 
										System.out.println("What is the professors name?");
										String addRemoveProf=in.nextLine();
										Professor returnAddRemoveProf = DataManager.findProfessor(addRemoveProf,allProfessors);
										if(returnAddRemoveProf == null){
											System.out.println("\nCouldn't find the professor\n");
											break;
										}
										System.out.println("Would you like to add or remove a course?");
										String courseProf = in.nextLine();
										if(courseProf.equals("add")){
											DataManager.listAllCourses(allCourses);
											System.out.println("Which course to add?");
											String profCourseName = in.nextLine();
											profCourseName = profCourseName.toLowerCase();
											for(Course n: allCourses){
												if(profCourseName.equals(n.getCourseTitle().toLowerCase())){
													
													returnAddRemoveProf.assignCourse(n);
													break;
												}
											}
										}
										if(courseProf.equals("remove")){
											returnAddRemoveProf.listTeachingCourses();
											System.out.println("Which course to remove?");
											String profCourseName = in.nextLine();
											profCourseName = profCourseName.toLowerCase();
											returnAddRemoveProf.removeTeachingCourse(profCourseName);
											break;
										}
							
						}
					}break;
							
						// access student specific menu, view all, search specific, and add a student
						case 5:
					
							int answer2 = 0;
						
							while(answer2 != 7){
								System.out.println("=== Student Menu ===");
								System.out.println("1. View All Students");
								System.out.println("2. Search Student");
								System.out.println("3. Add Student");
								System.out.println("4. Remove Student");
								System.out.println("5. View Student Courses");
								System.out.println("6. Add/Remove Student Courses");
								System.out.println("7. Back");
								answer2 = in.nextInt();
								in.nextLine();
								switch(answer2){
									case 1:
										if(allStudents.isEmpty()){
											System.out.println("\nThere are no students\n");
											break;
										}
										System.out.printf("\nThere is %d students\n", allStudents.size());
										for(Student v: allStudents){
											System.out.printf("Name: %s | ID: %s | Tuition: %.2f\n", v.getName(),v.getID(),v.getTuition());
										}
										System.out.printf("\n");
										
										break;
									case 2:
										System.out.println("What Student are you looking for?");
										String studentSearch = in.nextLine();
										for(Student q: allStudents){
											studentSearch = studentSearch.toLowerCase();
											if(q.getName().toLowerCase().equals(studentSearch)){
												System.out.printf("%s is found\nID: %s\nTuition: %.2f\n", q.getName(),q.getID(),q.getTuition());
												break;
											}else{
												System.out.printf("Couldn't find %s\n", studentSearch);
											}}
										break;
									
									//Add new student to allStudents and to ucf
									case 3: 
										System.out.println("What is the students name?");
										String studName = in.next();
										System.out.println("What is their ID number?");
										String studID = in.next();
										System.out.println("How much tuition are they paying now?");
										int studTuition = in.nextInt();
										in.nextLine();
										Student g1 = new Student(studName, studID, studTuition);
										allStudents.add(g1);
										ucf.addStudent(g1);
										break;
										
									case 4:
										System.out.println("What student would you like to remove?");
										String rmStudent = in.nextLine();
										if(allStudents.isEmpty()){
											 System.out.println("\nStudents list is empty... exiting\n");
											 break;								
										} 
										rmStudent = rmStudent.toLowerCase();
										boolean isRemoved = false;
										for(Student s: allStudents){
											if(s.getName().toLowerCase().equals(rmStudent)){
												allStudents.remove(s);
												System.out.println("\nRemoving "+s.getName());
												isRemoved = true;
												break;
												
											}
										}
										
										if(isRemoved == false){
											System.out.println("\nCouldn't find " + rmStudent);	
										}
										break;
										
									case 5:
										System.out.println("What students courses would you like to view?");
										String coursesStudent = in.nextLine();
										if(allStudents.isEmpty()){
											 System.out.println("\nStudents list is empty... exiting\n");
											 break;								
										} 
										coursesStudent = coursesStudent.toLowerCase();
										boolean isFound = false;
										for(Student s: allStudents){
											if(s.getName().toLowerCase().equals(coursesStudent)){
												s.listCourses();
											
											
												isFound = true;
												break;
											}
											}
												
									case 6:
										System.out.println("Would you like to remove or add a course?");
										String cR = in.nextLine();
										cR = cR.toLowerCase();
										System.out.println("What student would you like to edit?");
										String studentC = in.nextLine();
										studentC=studentC.toLowerCase();
										boolean studentCourseFound = false;
								
										for(Student s: allStudents){
											if(s.getName().toLowerCase().equals(studentC)){
												if(cR.equals("remove")){
													System.out.println("What course would you like to remove?");
													String courseR = in.nextLine();
													s.removeStudentCourse(courseR);
													studentCourseFound = true;
													
												}
												if(cR.equals("add")){
													System.out.println("What course would you like to add");
													DataManager.listAllCourses(allCourses);
													String courseA = in.nextLine();
													courseA = courseA.toLowerCase();
													for(Course c: allCourses){
														if(c.getCourseTitle().toLowerCase().equals(courseA)){
															s.registerCourse(c);
															studentCourseFound = true;
															System.out.println("Added the Course");
															
														}
													}
													System.out.println("Couldn't find the course");
												
												}
												if(studentCourseFound = true) break;	
													}
												}
												System.out.println("Couldn't find student");
												break;
		}
							
	} break;
}
}
		System.out.printf("==Goodbye!==");
}
}

