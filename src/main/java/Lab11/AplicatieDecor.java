package Lab11;

import Lab10.IStudentiExport;
import Lab10.Exporter;
import Lab10.StudentiInConsola;
import Lab10.StudentiInFisierText;
import Lab10.StudentiInFisierXlsx;
import ro.ulbs.proiectaresoftware.students.Student;

import java.util.Arrays;
import java.util.List;
public class AplicatieDecor {
    public static void main(String[] args) {
        // Aceeasi lista de studenti
        List<Student> studenti = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10.0),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1", 10.0),
                new Student(1029,"Maria","Pana","TI131/,", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();

        System.out.println("Export in Consola (Decorat)");
        IStudentiExport strategyConsole = new StudentiInConsola();
        IStudentiExport decoratedConsole = new ExportTimeDecorator(strategyConsole);
        exporter.startExport(decoratedConsole, studenti);

        System.out.println("Export in fisier text (Decorat)");
        IStudentiExport strategyFisierText = new StudentiInFisierText("studentiDecoratorText.txt");
        IStudentiExport decoratedFisierText = new ExportTimeDecorator(strategyFisierText);
        exporter.startExport(decoratedFisierText, studenti);

        System.out.println("Export in fisier Xlsx (Decorat)");
        IStudentiExport strategyFisierXlsx = new StudentiInFisierXlsx("studentiDecoratorXlsx.xlsx");
        IStudentiExport decoratedFisierXlsx = new ExportTimeDecorator(strategyFisierXlsx);
        exporter.startExport(decoratedFisierXlsx, studenti);
    }
}
