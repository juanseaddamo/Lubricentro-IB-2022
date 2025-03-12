package Lubricentro;

import java.util.ArrayList;

public class AplicLubricentro {

    static ArrayList<Cliente> clientes = new ArrayList<Cliente> ();
    static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    static ArrayList<Servicio> serviciosTotal = new ArrayList<Servicio>();
    static int cantClientes = 0;
    static int cantVehiculos = 0;
    static int cantServiciosTotal = 0;


    public AplicLubricentro() {
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.serviciosTotal = serviciosTotal;
        this.cantClientes = cantClientes;
        this.cantVehiculos = cantVehiculos;
        this.cantServiciosTotal = cantServiciosTotal;
    }

    public static void menuPrincipal () {
        char opc;
        do {
            /*
            System.out.println("\n-------------------------------------" +
                    "\nLUBRICENTRO" +
                    "\n1. Clientes" +
                    "\n2. Vehículos" +
                    "\n3. Listados"+
                    "\n-------------------------------------");
            */
            opc = IBIO.inputChar("\nOPCIÓN: ");
            switch (opc) {
                case '1': AplicCliente.menuClientes ();
                    break;
                case '2': AplicVehiculo.menuVehiculos ();
                    break;
                case '3': listados ();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    public static void listados () {
        char opc;
        do {
            /*
            System.out.println("\nLISTADOS" +
                    "\n1. Todos los servicios" +
                    "\n2. Servicios por vehículo" +
                    "\n3. Todos los clientes y sus vehículos");

             */
            opc = IBIO.inputChar("\nOPCIÓN: ");
            switch (opc) {
                case '1': listaServicios ();
                    break;
                case '2': listaSerVehiculos ();
                    break;
                case '3': listaClientes ();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    public static void listaServicios () {
        if (cantServiciosTotal == 0) {
            System.out.println("Sin servicios registrados");
        } else {
            for (int i = 0; i < cantServiciosTotal; i++) {
                System.out.println("\nSERVICIO n°" + i);
                serviciosTotal.get(i).verInfo();
            }
        }
    }

    public static void listaSerVehiculos () {
        if (cantVehiculos == 0) {
            System.out.println("Sin vehiculos registrados");
        } else {
            for (int i = 0; i < cantVehiculos; i++) {
                System.out.println("\nVEHICULO n°" + i);
                vehiculos.get(i).verServicios();
            }
        }
    }

    public static void listaClientes () {
        if (cantClientes == 0) {
            System.out.println("Sin clientes registrados");
        } else {
            for (int i = 0; i < cantClientes; i++) {
                System.out.println("\nCLIENTE n°" + i);
                clientes.get(i).verInfo();
            }
        }
    }


    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        AplicLubricentro.clientes = clientes;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        AplicLubricentro.vehiculos = vehiculos;
    }

    public static ArrayList<Servicio> getServiciosTotal() {
        return serviciosTotal;
    }

    public static void setServiciosTotal(ArrayList<Servicio> serviciosTotal) {
        AplicLubricentro.serviciosTotal = serviciosTotal;
    }
}

