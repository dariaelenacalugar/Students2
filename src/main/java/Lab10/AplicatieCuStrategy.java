package Lab10;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );
        Exporter exporter = new Exporter();
        //a)
        IStudentiExport strategyConsola = new StudentiInConsola();
        exporter.startExport(strategyConsola, studenti);
        //b)
        String textFile = "studentiInFisierText.txt";
        StudentiInFisierText studentiInFisierText = new StudentiInFisierText(textFile);
        exporter.startExport(studentiInFisierText, studenti);
        //c)
        String xlsxFile = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(xlsxFile);
        exporter.startExport(strategyFisierExcel, studenti);
        // d)
        String textFile2 = "studentiDinFisierText.txt";
        Importer importer = new Importer();
        StudentiDinFisierText strategyImportText = new StudentiDinFisierText(textFile);
        List<Student> dinTxt = importer.startImport(strategyImportText);
        dinTxt.forEach(System.out::println);
        //e)
        String xlsxFile2 = "studentiStrategyExcel.xlsx";
        StudentiDinFisierXlsx strategyImportXlsx = new StudentiDinFisierXlsx(xlsxFile2);
        List<Student> dinXlsx = importer.startImport(strategyImportXlsx);
        dinXlsx.forEach(System.out::println);
    }
}
