package Lab10;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.ulbs.proiectaresoftware.students.Student;

public class StudentiInFisierXlsx implements IStudentiExport{
    private final String fileName;
    public  StudentiInFisierXlsx(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public void doExport(List<Student> studenti)
    {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(fileName)) {

            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            String[] cols = {"ID", "Prenume", "Nume", "Grupa", "Medie"};
            CellStyle boldStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            boldStyle.setFont(font);

            for (int i = 0; i < cols.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(cols[i]);
                cell.setCellStyle(boldStyle);
            }

            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }

            workbook.write(fos);
            System.out.println("Export XLSX realizat: " + fileName);

        } catch (IOException e) {
            System.err.println("Eroare la export XLSX: " + e.getMessage());
        }
    }
}
