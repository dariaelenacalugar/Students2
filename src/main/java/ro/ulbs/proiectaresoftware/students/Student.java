package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = 0;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }
    public void setNumarMatricol(int numarMatricol) {
        this.numarMatricol = numarMatricol;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public void setFormatieDeStudiu(String formatieDeStudiu) {
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }
    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }
    @Override
    public String toString() {
        return String.format("%15d %15s %15s %15s %15.2f",numarMatricol, prenume, nume, formatieDeStudiu,nota);
    }
}
