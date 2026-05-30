package Lab10;
import ro.ulbs.proiectaresoftware.students.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class StudentiInFisierText implements IStudentiExport {
    private  String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("id,prenume,nume,grupa,medie");
            bw.newLine();
            for (Student student : studenti) {
                bw.write(student.getNumarMatricol()+", "+student.getPrenume()+", "+student.getNume()+", "+student.getFormatieDeStudiu()+", "+ student.getNota());
                bw.newLine();
            }
            System.out.println("Export TXT realizat: "+fileName);

        }catch(IOException e)
        {
            System.err.println(e);
        }
    }
}
