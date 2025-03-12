package Lubricentro;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String dni;
    private String telefono;
    private String mail;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo> ();
    private int cantVehiculos = 0;

    public Cliente(String nombre, String dni, String telefono, String mail) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.mail = mail;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public int getCantVehiculos() {
        return cantVehiculos;
    }
    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public void verInfo () {
        System.out.println("\nNOMBRE: " + this.nombre);
        System.out.println("DNI: " + this.dni);
        System.out.println("TELEFONO: " + this.telefono);
        System.out.println("MAIL: " + this.mail);
        if (this.cantVehiculos == 0) {
            System.out.println("SIN VEHICULOS REGISTRADOS");
        } else {
            for (int i = 0; i < cantVehiculos; i++) {
                System.out.println("\n\tVEHICULO n°" + i);
                this.vehiculos.get(i).verInfoSinCli ();
            }
            System.out.println("\n--------------------------------------------");
        }
    }
}

