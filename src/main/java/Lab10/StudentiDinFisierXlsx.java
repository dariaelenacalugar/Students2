package Lab10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.ulbs.proiectaresoftware.students.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements  IStudentiImport{
    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                int id         = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume    = row.getCell(2).getStringCellValue();
                String grupa   = row.getCell(3).getStringCellValue();
                double medie   = row.getCell(4).getNumericCellValue();

                studenti.add(new Student(id, prenume, nume, grupa, medie));
            }
            System.out.println("Import XLSX: " + studenti.size() + " studenti cititi din " + fileName);

        } catch (IOException e) {
            System.err.println(e);
        }

        return studenti;
    }
}
