package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean existaStudent(List<Student> lista, Student student) {
        for (Student s : lista) {
            if (s.getPrenume().equals(student.getPrenume()) &&
                    s.getNume().equals(student.getNume()) &&
                    s.getFormatieDeStudiu().equals(student.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Lab1
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        //Lab2
        //a)
        List<Student> students=new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("Lista studenti a) :");
        for (Student s : students) {
            System.out.println(s);
        }
        // b)
        Student cautat1 = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println("Verificare b)");
        System.out.println("Studentul " + cautat1.getPrenume() + " " + cautat1.getNume()
                + " (" + cautat1.getFormatieDeStudiu() + ") este in lista: "
                + existaStudent(students, cautat1));

        // c) Verificare
        Student cautat2 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Verificare c)");
        System.out.println("Studentul " + cautat2.getPrenume() + " " + cautat2.getNume()
                + " (" + cautat2.getFormatieDeStudiu() + ") este in lista: "
                + existaStudent(students, cautat2));

    }

}
