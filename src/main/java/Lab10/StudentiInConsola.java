package Lab10;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.List;

public class StudentiInConsola implements IStudentiExport{
    public void doExport(List<Student> studenti) {
        System.out.println("Studentii: ");
        for(Student student : studenti){
            System.out.println(student);
        }
        System.out.println("Totalul : "+studenti.size());
    }
}
