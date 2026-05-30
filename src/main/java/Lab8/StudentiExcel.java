package Lab8;

import ro.ulbs.proiectaresoftware.students.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentiExcel {
    public static void main(String[] args) throws Exception {
       //lab8-a)
        try {
           Set<Student> studenti = new java.util.HashSet<Student>();

           Student s1 = new Student(1025, "Andrei", "Popa", "ISM141/2");
           s1.setNota(8.70);
           studenti.add(s1);

           Student s2 = new Student(1024, "Ioan", "Mihalcea", "ISM141/1");
           s2.setNota(9.80);
           studenti.add(s2);

           Student s3 = new Student(1026, "Anamaria", "Prodan", "TI131/1");
           s3.setNota(8.90);
           studenti.add(s3);

           Student s4 = new Student(1029, "Bianca", "Popescu", "TI131/1");
           s4.setNota(9.10);
           studenti.add(s4);
           String xlsFileName = "laborator8_student.xlsx";
           writeToXls(studenti, xlsFileName);
       } catch (Exception e) {
           e.printStackTrace();
       }
       //lab8-b)

        List<Student> studentsFromXls = readFromXls("laborator8_student.xlsx");
        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }
    //a)
    public static void writeToXls(Set<Student> studenti, String xlsFileName) throws Exception {
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("Studenti");

        Row header=sheet.createRow(0);
        header.createCell(0).setCellValue("Nr Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Formatie Studiu");
        header.createCell(4).setCellValue("Nota");

        int rowNum=1;
        for(Student st:studenti){
            Row row=sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(st.getNumarMatricol());
            row.createCell(1).setCellValue(st.getPrenume());
            row.createCell(2).setCellValue(st.getNume());
            row.createCell(3).setCellValue(st.getFormatieDeStudiu());
            row.createCell(4).setCellValue(st.getNota());
        }
        try(OutputStream fileOut=new FileOutputStream(xlsFileName)){
            wb.write(fileOut);
        }
        System.out.println("Studenti exportati in: "+xlsFileName);
    }
    //b)
    public static List<Student> readFromXls(String xlsFileName) throws Exception {
        List<Student> result = new ArrayList<>();

        InputStream fileIn = new FileInputStream(xlsFileName);
        Workbook wb = new XSSFWorkbook(fileIn);
        Sheet sheet = wb.getSheetAt(0);

        boolean firstRow = true;
        for (Row row : sheet) {
            if (firstRow) {
                firstRow = false;
                continue;
            }
            int numarMatricol = (int) row.getCell(0).getNumericCellValue();
            String prenume = row.getCell(1).getStringCellValue();
            String nume = row.getCell(2).getStringCellValue();
            String formatie = row.getCell(3).getStringCellValue();
            double nota = row.getCell(4).getNumericCellValue();

            Student st = new Student(numarMatricol, prenume, nume, formatie);
            st.setNota(nota);
            result.add(st);
        }
        return result;
    }
}
