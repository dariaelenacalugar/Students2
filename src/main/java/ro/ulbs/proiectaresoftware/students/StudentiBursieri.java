package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentiBursieri extends Student {
    private double cuantumBursa;
    public StudentiBursieri(int numarMatricol,String nume,String prenume,String formatieDeStudiu,double nota,double cuantumBursa) {
        super(numarMatricol,nume,prenume,formatieDeStudiu);
        super.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }
    public double getCuantumBursa() {
        return cuantumBursa;
    }
    public void setCuantumBursa(double cuantumBursa) {
        this.cuantumBursa = cuantumBursa;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentiBursieri that = (StudentiBursieri) o;
        return Double.compare(cuantumBursa, that.cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" %15f",cuantumBursa);
    }

}
