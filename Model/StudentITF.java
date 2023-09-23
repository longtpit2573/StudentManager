package StudentManager.Model;

import java.util.ArrayList;


public interface StudentITF {
    boolean create();
    ArrayList<Student> searchByName();
    Student searchById();
    void sort(ArrayList<Student> list);
    void update(Student st);
    void delete(Student st);
    void report();
    void display(ArrayList<Student> list);
}
