package Lubricentro;

import java.util.Date;

public class Servicio {
    private Date fecha;
    private String info;
    private Double precio;

    public Servicio(Date fecha, String info, Double precio) {
        this.fecha = fecha;
        this.info = info;
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public void verInfo () {
        System.out.println("INFORMACIÓN: " + this.fecha.toString());
        System.out.println("INFORMACIÓN: " + this.info);
        System.out.println("PRECIO: " + this.precio);
    }
}

