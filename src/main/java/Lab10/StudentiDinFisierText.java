package Lab10;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements  IStudentiImport{
    private String fileName;
    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport(){
        List<Student> studenti=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line=null;
            boolean firstLine=true;
            while((line=br.readLine())!=null){
                if(firstLine){
                    firstLine=false;
                    continue;
                }
                String[] parts=line.split(",");
                if(parts.length==5){
                    int numarMatricol=Integer.parseInt(parts[0].trim());
                    String prenume=parts[1].trim();
                    String nume=parts[2].trim();
                    String formatiaDeStudium=parts[3].trim();
                    double nota=Double.parseDouble(parts[4].trim());
                    studenti.add(new Student(numarMatricol,prenume,nume,formatiaDeStudium,nota));

                }
            }
            System.out.println(studenti.size() + " studenti");

        }catch(IOException e){
            System.err.println(e);
        }
        return studenti;
    }
}
