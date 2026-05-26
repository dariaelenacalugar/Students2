package Lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.StudentiBursieri;

import java.util.List;

public class AplicatieCuBursaTest {
    private AplicatieCuBursa app;

    @BeforeEach
    public void setUp() {
        app = new AplicatieCuBursa();
    }

    @Test
    public void testSortare() {
        List<StudentiBursieri> lista = app.genereaza();
        List<StudentiBursieri> sortata = app.sort(lista);

        Assertions.assertTrue(
                sortata.get(0).getFormatieDeStudiu().compareTo(
                        sortata.get(sortata.size() - 1).getFormatieDeStudiu()) <= 0
        );
    }
}
