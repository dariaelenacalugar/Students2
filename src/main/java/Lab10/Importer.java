package Lab10;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.List;

public class Importer {
    public List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}