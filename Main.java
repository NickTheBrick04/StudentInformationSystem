
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        University ucf = new University("UCF");
		
		int answer = 0;
		try (Scanner in = new Scanner(System.in)) {
		while(answer != 7){
			
		
        //selectable menu
        System.out.println("=== University Database ===");
        System.out.println("What would you like to access?");
        System.out.println("1. Enter Import Menu");
        System.out.println("2. Enter Save Menu");
        System.out.println("3. Enter Course Menu");
        System.out.println("4. Enter Professor Menu");
        System.out.println("5. Enter Student Menu");
        System.out.println("6. University Data");
        System.out.println("7. Exit");
        
        answer = in.nextInt();
        in.nextLine();
        
        //create response repository 
        switch(answer){
            //Access files containing information from previous sessions and add to arrayLists
            case 1 -> {
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
                        
                        case 1 -> {
                            System.out.println("What file do you want to load?");
                            String nFile = in.nextLine();
                           
                            ArrayList<Student> loadedStudents = DataManager.loadStudentsFromFile(nFile);
                            if(loadedStudents.isEmpty()) {
								System.out.println("\n--- Invalid file ---\n");
								break;
							}
                            else System.out.println("\n--- Loaded Students from File ---\n");
                            
                            for(Student p: loadedStudents){
								String id = p.getID().trim().toLowerCase();
                                if(!ucf.addStudent(p)){
                                    System.out.println("Duplicate ID skipped: " + p.getID());
                                }

                            }
                        
                }
                        
                        case 2 -> {
                            System.out.println("What file do you want to load?");
                            String nFile = in.nextLine();
                            
                            ArrayList<Professor> loadedProfessors = DataManager.loadProfessorFromFile(nFile);
                            if(loadedProfessors.isEmpty()){
								System.out.println("\n--- Invalid File ---\n");
								break;
							} 
                            else System.out.println("\n--- Loaded Professors from File ---\n");
                            for(Professor p: loadedProfessors){
								String id = p.getID().trim().toLowerCase();
                                if(!ucf.addProfessor(p)){
                                    System.out.println("Duplicate ID Skipped: "+p.getID());
                                }
                                
                            }
                }
                        
                        case 3 -> {
                            System.out.println("What file do you want to load?");
                            String nFile = in.nextLine();
                            
                            ArrayList<Course> loadedCourses = DataManager.loadCourseFromFile(nFile);
                            if(loadedCourses.isEmpty()){
								System.out.println("\n--- Invalid File ---\n");
								break;
							} 
                            else System.out.println("\n--- Loaded Courses from File ---\n");

                            for(Course p: loadedCourses){
								String title = p.getCourseTitle().trim().toLowerCase();
                                if(!ucf.addCourse(p)){
                                    System.out.println("Duplicate Course Skipped: "+p.getCourseTitle());
                                }
                            }
                }
                        
                        }
                    }
            }
                    
                    // save menu for students, professors, and courses
                    case 2 -> {
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
                                
                                case 1 -> {
                                    System.out.println("What would you like to name the file?");
                                    fileName= in.nextLine();
                                    DataManager.saveStudentsToFile(ucf.getStudents(),fileName);
                                }
                                
                                case 2 -> {
                                    System.out.println("What would you like to name the file?");
                                    fileName = in.nextLine();
                                    DataManager.saveProfessorsToFile(ucf.getProfessors(),fileName);
                                }
                                    
                                case 3 -> {
                                    System.out.println("What would you like to name the file?");
                                    fileName = in.nextLine();
                                    DataManager.saveCoursesToFile(ucf.getCourses(),fileName);
                                }
                                    
                            }
                            }
            }
                            
                        
                    // Add new course to allCourses and ucf
                        case 3 -> {
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
                                case 1 -> ucf.listAllCourses();
                                    
                                case 2 -> {
                                    System.out.println("What course are you looking for?");
                                    String sCourse = in.nextLine();
                                    Course c = ucf.searchCourse(sCourse);
                                    if(c != null){
                                        System.out.printf("\nCourse Exists\n");
                                        System.out.printf("\n Course Title: %s | Credits: %d\n", c.getCourseTitle(),c.getCourseCredits());
                                        System.out.printf("\n");
                                    }
                                }
                                    
                                case 3 -> {
                                    System.out.println("What is the title and number?");
                                    String courseName = in.next();
                                    System.out.println("How many credit hours?");
                                    int courseNumber = in.nextInt();
                                    in.nextLine();
                                    Course d1 = new Course(courseName , courseNumber);
                                    ucf.addCourse(d1);
                                }

                                case 4->{
                                    System.out.println("What course would you like to remove?");
                                    ucf.listAllCourses();
                                    String rCourse = in.nextLine();
                                    if(ucf.removeCourse(rCourse)){
                                        System.out.println("Course removed");
                                    }else{
                                        System.out.println("Course couldn't be removed.");
                                    }

                                }
                            }
                            
                        }
            }
                            
                        //Add new Professor to allProfessors and ucf
                        case 4 -> {
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
                                    case 1 -> University.listAllProfessors(professorByID);
                                        
                                    case 2 -> {
                                        System.out.println("What Professor do you want to look for?");
                                        String searchProf = in.nextLine();
                                        Professor returnProf = University.findProfessor(searchProf,professorByID);
                                        if(returnProf == null){
                                             System.out.println("Couldn't find the professor\n");
                                         }
                                        else {
                                            System.out.printf("\nName: %s | ID: %s\n", returnProf.getName(), returnProf.getID());
                                        }
                                        System.out.println("");
                                    }
                                        
                                    case 3 -> {
                                        System.out.println("What is the professors name?");
                                        String profName = in.next();
                                        System.out.println("What is their ID number?");
                                        String profID = in.next();
                                        Professor f1 = new Professor(profName, profID);
                                        professorByID.put(profID, f1);
                                        ucf.addProfessor(f1);
                                    }
                                        
                                    case 4 -> {
                                        System.out.println("What is the professors ID?");
                                        String removeProfID = in.nextLine();
                                        Professor returnRemoveProf = professorByID.get(removeProfID);
                                        if(returnRemoveProf==null){
                                            System.out.println("\nCouldn't find professor\n");
                                        }
                                        else {
                                            System.out.println("\nProfessor removed!\n");
                                            professorByID.remove(removeProfID);
                                            ucf.removeProfessor(returnRemoveProf.getID());
                                        }
                                    }
                                        
                                    case 5 -> {
                                        System.out.println("What is the professors ID?");
                                        String courseProfName = in.nextLine();
                                        Professor returnCourseProf = professorByID.get(courseProfName);
                                        if(returnCourseProf==null){
                                            System.out.println("\nCouldn't find the professor\n");
                                        }
                                        else {
                                            returnCourseProf.listTeachingCourses();
                                        }
                                    }
                                        
                                    case 6 -> {
                                        System.out.println("What is the professors ID?");
                                        String addRemoveProf=in.nextLine();
                                        Professor returnAddRemoveProf = professorByID.get(addRemoveProf);
                                        if(returnAddRemoveProf == null){
                                            System.out.println("\nCouldn't find the professor\n");
                                            break;
                                        }
                                        
                                        System.out.println("Would you like to add or remove a course?");
                                        String choice = in.nextLine();
                                        if(choice.equals("add")){
                                            University.listAllCourses(courseByTitle);
                                            System.out.println("Which course to add?");
                                            String profCourseName = in.nextLine();
                                            if(courseByTitle.containsKey(profCourseName)){    
                                                    returnAddRemoveProf.assignCourse(courseByTitle.get(profCourseName));                                                        break;
                                                    }
                                                
                                            }
                                            if(choice.equals("remove")){
                                                returnAddRemoveProf.listTeachingCourses();
                                                System.out.println("Which course to remove?");
                                                String profCourseName = in.nextLine();
                                                profCourseName = profCourseName.toLowerCase();
                                                returnAddRemoveProf.removeTeachingCourse(profCourseName);
                                            }
                                        }
                                    }
                            
                        }
                    }
            
                            
                        // access student specific menu, view all, search specific, and add a student
                        case 5 -> {
                    
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
            case 1 -> {
                if(studentsByID.isEmpty()){
                    System.out.println("\nThere are no students\n");
                } else {
                    System.out.printf("\nThere is %d students\n", studentsByID.size());
                    for(Student v: studentsByID.values()){
                        System.out.printf("Name: %s | ID: %s | Tuition: %.2f\n", v.getName(),v.getID(),v.getTuition());
                    }
                    System.out.printf("\n");
                }
            }
            case 2 -> {
                System.out.println("Enter Student ID");
                String studentSearch = in.nextLine();
                if(studentsByID.containsKey(studentSearch)){
                        Student q = studentsByID.get(studentSearch);
                        System.out.println("Student Found");
                        System.out.printf("Student: %s | ID: %s | Tuition: %.2f\n", q.getName(),q.getID(),q.getTuition());
                        break;
                    }else{
                        System.out.printf("Couldn't find student with ID: %s\n", studentSearch);
                    }}
            
            //Add new student to allStudents and to ucf
            case 3 -> {
                System.out.println("What is the students name?");
                String studName = in.next();
                System.out.println("What is their ID number?");
                String studID = in.next();
                studID = studID.trim().toLowerCase();
                System.out.println("How much tuition are they paying now?");
                int studTuition = in.nextInt();
                in.nextLine();
                Student g1 = new Student(studName, studID, studTuition);
                studentsByID.put(studID, g1);
                ucf.addStudent(g1);
            }
                
            case 4 -> {
                System.out.println("What is the students ID?");
                String rmStudent = in.nextLine();
                if(studentsByID.isEmpty()){
                     System.out.println("\nStudents list is empty... exiting\n");
                     break;
                }
                    if(studentsByID.containsKey(rmStudent)){
                        Student s = studentsByID.get(rmStudent);
                        studentsByID.remove(rmStudent, s);
                        ucf.removeStudent(s.getID());
                        System.out.println("\nRemoving "+s.getName());
                        break;                            
                    }
                    
                    
                    if(!studentsByID.containsKey(rmStudent)){
                        System.out.println("\nCouldn't find " + rmStudent);	
                    }
                }
                
            case 5 -> {
                System.out.println("What is the students ID?");
                String coursesStudent = in.nextLine();
                if(studentsByID.isEmpty()){
                     System.out.println("\nStudents list is empty... exiting\n");
                } else {
                    if(studentsByID.containsKey(coursesStudent)){
                        studentsByID.get(coursesStudent).listCourses();
                    }
                }
            }
                        
            case 6 -> {
                System.out.println("Would you like to remove or add a course?");
                String cR = in.nextLine();
                cR = cR.toLowerCase();
                System.out.println("What is the students ID");
                String studentC = in.nextLine();
                if(studentsByID.containsKey(studentC)) {
                    if(cR.equals("remove")){
                        University.listAllCourses(courseByTitle);
                        System.out.println("What course would you like to remove?");
                        String courseR = in.nextLine();
                        if(courseByTitle.containsKey(courseR)){
                            studentsByID.get(studentC).removeStudentCourse(courseR);
                        }else{
                            System.out.println("Couldn't find that course.");
                        }
                }
                    if(cR.equals("add")){
                        University.listAllCourses(courseByTitle);
                        System.out.println("What course would you like to add");
                        String courseA = in.nextLine();
                        courseA = courseA.toLowerCase();
                        if(courseByTitle.containsKey(courseA)){
                            studentsByID.get(studentC).registerCourse(courseByTitle.get(courseA));
                        }else{
                            System.out.println("Couldn't find that course.");
                        }
                    }
                } else {
                    System.out.println("Couldn't find student");
                }
            }
            
        }
                            
    }
    }
    case 6 ->{
        System.out.println("=== UCF ===");
        ucf.listThings();
    }
}
}
        System.out.printf("==Goodbye!==");
        }
        }
    }



