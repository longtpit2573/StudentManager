package StudentManager.Controller;

import java.util.ArrayList;

import StudentManager.Model.Student;
import StudentManager.Model.StudentManagement;
import StudentManager.View.Menu;

public class ManagingStudent extends Menu<String> {

    StudentManagement list;

    public ManagingStudent() {
        this(new StudentManagement());
    }

    public ManagingStudent(StudentManagement list) {
        super("=========STUDENT MANAGEMENT==========", new String[]{"Create", "Find and Sort", "Update/Delete", "Report", "Exit"});
        this.list = list;
    }

    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                list.create();
                break;
            case 2:
                ArrayList<Student> searchedList = list.searchByName();
                list.sort(searchedList);
                list.display(searchedList);
                break;
            case 3:
                Student st = list.searchById();

                if (st != null) {
                    String choice = val.getString("Do you want to update (U) or delete (D) student", "U|D");
                    switch (choice) {
                        case "U":
                            list.update(st);
                            break;
                        case "D":
                            list.delete(st);
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    System.out.println("Not Found!\n");
                }
                break;
            case 4:
                list.report();
                break;
            default:
                throw new AssertionError();
        }
    }

}