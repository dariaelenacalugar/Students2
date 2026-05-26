package ro.ulbs.proiectaresoftware.students;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

    //Tema lab 4
    public static double gasesteNota(String prenume,String nume,HashMap<Integer, Student>map)
    {
        HashMap<String,Student> prenumeNume=new HashMap<>();
        for(Student s:map.values()){
            String cheie=s.getPrenume()+"-"+s.getNume();
            prenumeNume.put(cheie,s);
        }
        String caut=prenume+"-"+nume;
        Student studentGasit=prenumeNume.get(caut);
        if(studentGasit!=null){
            return studentGasit.getNota();
        }
        return 0.0;
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

        students.sort((a, b) -> a.getNume().compareTo(b.getNume()));

        try {
            List<String> liniiOut = new ArrayList<>();
            for (Student s : students) {
                liniiOut.add(s.getNumarMatricol() + "," + s.getNume() + "," + s.getPrenume() + "," + s.getFormatieDeStudiu());
            }
            Files.write(Paths.get("studenti_out.txt"), liniiOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        for (Student s : students) {
            System.out.println(s);
        }
        //listStudenti.sort((s2,s3)->s2.getFormatieDeStudiu().compareTo(s3.getFormatieDeStudiu()));
        students.sort((s6, s7) -> s6.getNume().compareTo(s7.getNume()));

        try {
            List<String> liniiOut = new ArrayList<>();
            for (Student s : students) {
                liniiOut.add(s.getNumarMatricol() + "," + s.getNume() + "," + s.getPrenume() + "," + s.getFormatieDeStudiu());
            }
            Files.write(Paths.get("studenti_out.txt"), liniiOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tema lab3
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int res = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
                if (res == 0) {
                    res = s1.getNume().compareTo(s2.getNume());
                }
                return res;
            }
        });
        List<String> liniiSort = new ArrayList<>();
        for (Student s : students) {
            liniiSort.add(s.getNumarMatricol() + "," + s.getNume() + "," + s.getPrenume() + "," + s.getFormatieDeStudiu());
        }
        try {
            Files.write(Path.of("studenti_out_sorted.txt"), liniiSort);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Lab4
        HashMap<Integer, Student>studentiMap=new HashMap<>();
        try{
            List<String>linii=Files.readAllLines(Paths.get("studenti_in.txt"));
            for(String linie:linii)
            {
                String[] parts=linie.split(",");
                int numarMatricol=Integer.parseInt(parts[0]);
                String prenume=parts[1];
                String nume=parts[2];
                String formatieDeStudiu=parts[3];
                Student s=new Student(numarMatricol, prenume, nume, formatieDeStudiu);
                studentiMap.put(numarMatricol, s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            List<String> linii=Files.readAllLines(Paths.get("note_anon.txt"));
            for(String linie:linii){
                String[] parts=linie.split(",");
                int numarMatricol=Integer.parseInt(parts[0]);
                double nota=Double.parseDouble(parts[1]);
                Student s=studentiMap.get(numarMatricol);//O(1)
                if(s!=null){
                    s.setNota(nota);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Studneti cu note: ");
        for(Map.Entry<Integer, Student> entry:studentiMap.entrySet()){
            System.out.println(entry.getValue());
        }

        //Tema Lab 4
        double notaM = gasesteNota("Bianca", "Popescu", studentiMap);
        double notaN = gasesteNota("Ioan", "Mihalcea", studentiMap);
        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Mihalcea: " + notaN);
    }

}
