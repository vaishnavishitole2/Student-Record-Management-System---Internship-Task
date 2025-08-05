package DAY2;
import java.util.*;
public class StudentRecordManagementSystem
{
        public static void main(String[] args) {
        ArrayList<Student>  list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while(running) 
        {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                System.out.print("Enter ID:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter NAME:");
                String name = sc.nextLine();
                System.out.println("Enter MARKS:");
                int marks = sc.nextInt();
                list.add(new Student (id, name, marks));
                System.out.println("Student added Succesfully!");    
                break;

            case 2 :
            if(list.isEmpty())
            {
                System.out.println("No student record found");
            }
            else
            {
                System.out.println("\nID | Name | Marks");
                for(Student s : list)
                {
                    System.out.println(s);
                }
            }
            break;

            case 3:
            System.out.println("Enter Student ID to update:");
            int UpdateId = sc.nextInt();

            boolean found = false;
            for (Student v : list)
            {
                if (v.getId() == UpdateId)
                {
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    v.setName(sc.nextLine());
                    System.out.print("Enter new Marks: ");
                    v.setMarks(sc.nextInt());
                    System.out.println("Record updated.");
                    found = true;
                    break;
                }
            }

            if(!found)
            {
                System.out.println("Student ID not found.");
            }
            break;

            case 4:
            System.out.println("Enter Student ID to delete:");
            int deletedId = sc.nextInt();

            Iterator<Student> iterator = list.iterator();
            boolean deleted = false;

            while(iterator.hasNext())
            {
                if(iterator.next().getId() == deletedId)
                {
                    iterator.remove();
                    System.out.println("Student deleted.");
                    deleted = true;
                    break;
                }
            }
            if(! deleted)
            {
                System.out.println("Student Id not found.");
            }
            break;

            case 5 :
            running = false;
            System.out.println("Exiting... Thank you!");
            break;

            default:
            System.out.println("Invalid cHOICE, please try again.");
        }
    }
    sc.close();
}
}