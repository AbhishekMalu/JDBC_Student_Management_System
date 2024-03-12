import java.sql.SQLException;
import java.util.ArrayList;

public class StudentApp {
    public static void main(String[] args) throws SQLException {
        while(true)
        {
            System.out.print("\n\t\t\t\t\tStudent Management System\n\n");
            System.out.println("Enter 1 to add a student, 2 to delete a student, 3 to update a student, 4 to display all students, 5 to exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch(choice)
            {
                case 1 -> {
                    System.out.print("Enter your id: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.print("Enter your first name: ");
                    String fname = System.console().readLine();
                    System.out.print("Enter your last name: ");
                    String lname = System.console().readLine();
                    System.out.print("Enter your Email-id: ");
                    String email = System.console().readLine();
                    Student st1 = new Student(id, fname, lname, email);
                    Student.createStudentData(st1);
                }
                      
                case 2 -> {
                    System.out.print("Enter student id: ");
                    int id = Integer.parseInt(System.console().readLine());
                    Student.deleteStudentData(id);
                }
                 
                case 3 -> {
                    System.out.print("Enter your id: ");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.print("Enter your first name: ");
                    String fname = System.console().readLine();
                    Student.updateStudentData(id, fname);
                }
                 
                case 4 -> {
                    ArrayList<Student> list = Student.getStudentList();
                    for(Student st : list)
                    {
                        System.out.println(st);
                    }
                }
                
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
