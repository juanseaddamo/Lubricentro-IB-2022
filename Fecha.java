package Lubricentro;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }

    public void verInfo () {
        System.out.println("FECHA: " + this.dia + "/" + this.mes + "/" + this.año);
    }

    public void cargarFecha () {
        this.dia = IBIO.inputInt("Día: ");
        this.mes = IBIO.inputInt("Mes: ");
        this.año = IBIO.inputInt("Año: ");
    }
}

