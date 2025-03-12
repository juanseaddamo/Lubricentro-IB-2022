package Lubricentro;

import java.util.ArrayList;
import java.util.Date;

public class Vehiculo {
    private Cliente cliente;
    private String patente;
    private String marca;
    private String modelo;
    private int kilometraje;
    private ArrayList<Servicio> servicios = new ArrayList<Servicio> ();
    private int cantServicios = 0;

    public Vehiculo(Cliente cliente, String patente, String marca, String modelo, int kilometraje) {
        this.cliente = cliente;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getKilometraje() {
        return kilometraje;
    }
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void verInfo () {
        System.out.println("\nCLIENTE: " + this.cliente.getNombre());
        System.out.println("DNI: " + this.cliente.getDni());
        System.out.println("PATENTE: " + this.patente);
        System.out.println("MARCA: '" + this.marca + "'");
        System.out.println("MODELO: '" + this.modelo + "'");
        System.out.println("KILOMETRAJE: " + this.kilometraje);
        System.out.println("CANT. DE SERVICIOS: " + this.cantServicios);
    }

    public void verInfoSinCli () {
        System.out.println("PATENTE: " + this.patente);
        System.out.println("MARCA: '" + this.marca + "'");
        System.out.println("MODELO: '" + this.modelo + "'");
        System.out.println("KILOMETRAJE: " + this.kilometraje);
        System.out.println("CANT. DE SERVICIOS: " + this.cantServicios);
    }

    public void cargarServicio () {
        int dia = IBIO.inputInt("Día: ");
        int mes = IBIO.inputInt("Mes: ");
        int año = IBIO.inputInt("Año: ");
        Date fecha = new Date(año, mes, dia);
        String info = IBIO.input("Info. del servicio: ");
        Double precio = IBIO.inputDouble("Precio: ");
        this.kilometraje = IBIO.inputInt("Kilometraje actualizado: ");
        Servicio servicio = new Servicio (fecha, info, precio);
        this.servicios.add(servicio);
        this.cantServicios++;
        AplicLubricentro.serviciosTotal.add(servicio);
        AplicLubricentro.cantServiciosTotal++;
    }

    public int posicionServicio () {
        String info = IBIO.input("Información del servicio: ");
        String infoVeh;
        for (int i = 0; i < this.cantServicios; i++) {
            infoVeh = this.servicios.get(i).getInfo();
            if (infoVeh.equals(info)) {
                return i;
            }
        }
        return -1;
    }

    public void verServicios () {
        if (this.cantServicios == 0) {
            System.out.println("Sin servicios registrados");
            System.out.println("\n--------------------------------------------");
        } else {
            verInfoSinCli ();
            for (int i = 0; i < this.cantServicios; i++) {
                System.out.println("\n\tSERVICIO n°" + i);
                this.servicios.get(i).verInfo();
            }
            System.out.println("\n--------------------------------------------");
        }
    }
}
