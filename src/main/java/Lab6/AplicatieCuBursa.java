package Lab6;

import ro.ulbs.proiectaresoftware.students.StudentiBursieri;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AplicatieCuBursa {
    public List<StudentiBursieri> genereaza() {
        List<StudentiBursieri> lista = new ArrayList<>();
        lista.add(new StudentiBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        lista.add(new StudentiBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        lista.add(new StudentiBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        lista.add(new StudentiBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        lista.add(new StudentiBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 100.00));
        return lista;
    }

    public List<StudentiBursieri> sort(List<StudentiBursieri> lst) {
        List<StudentiBursieri> copie = new ArrayList<>(lst);
        copie.sort(Comparator
                .comparing(s -> s.getFormatieDeStudiu())
        );
        return copie;
    }
}
