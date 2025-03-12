package Lubricentro;

public class AplicVehiculo {

    public static void menuVehiculos () {
        char opc;
        do {

            /*
            System.out.println("\n-------------------------------------"+
                    "\nVEHÍCULOS" +
                    "\n1. Alta" +
                    "\n2. Baja" +
                    "\n3. Modificar" +
                    "\n4. Listar" +
                    "\n5. Registrar un servicio" +
                    "\n6. Enter para volver al menu anterior" +
                    "\n-------------------------------------");

             */
            opc = IBIO.inputChar("\nOPCIÓN: ");
            switch (opc) {
                case '1': altaVehiculo ();
                    break;
                case '2': bajaVehiculo ();
                    break;
                case '3': modificarVehiculo ();
                    break;
                case '4': listarVehiculos ();
                    break;
                case '5': registrarServicio ();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    static void altaVehiculo() {
        int posCli = AplicCliente.posicionCliente ();
        boolean clienteNoExiste = true;
        boolean vehiculoNoExiste = true;
        if (posCli != -1) {
            Cliente clienteVeh = AplicLubricentro.clientes.get(posCli);
            String patente = IBIO.input("Patente: ");
            clienteNoExiste = false;
            for (int i = 0; i < AplicLubricentro.cantVehiculos; i++) {
                if (AplicLubricentro.vehiculos.get(i).getPatente().equals(patente)) {
                    System.out.println("Vehiculo registrado");
                    vehiculoNoExiste = false;
                }
            }
            if (vehiculoNoExiste) {
                String marca = IBIO.input("Marca: ");
                String modelo = IBIO.input("Modelo: ");
                int kilometraje = IBIO.inputInt("Kilometraje: ");
                Vehiculo nuevoVeh = new Vehiculo (clienteVeh, patente, marca, modelo, kilometraje);
                AplicLubricentro.clientes.get(posCli).getVehiculos().add(nuevoVeh);
                AplicLubricentro.vehiculos.add(nuevoVeh);
                int cantVehCli = AplicLubricentro.clientes.get(posCli).getCantVehiculos();
                AplicLubricentro.clientes.get(posCli).setCantVehiculos(cantVehCli + 1);
                AplicLubricentro.cantVehiculos++;
            }
        }
        if (clienteNoExiste) {
            System.out.println("Cliente no registrado");
        }
    }

    static void bajaVehiculo () {
        int posVeh = posicionVehiculo ();
        boolean vehiculoNoExiste = true;
        if (posVeh >= 0) {
            AplicLubricentro.vehiculos.remove(posVeh);
            vehiculoNoExiste = false;
            System.out.println("Vehículo borrado");
            AplicLubricentro.cantVehiculos = AplicLubricentro.cantVehiculos - 1;
        }
        if (vehiculoNoExiste) {
            System.out.println("Vehículo no registrado");
        }
    }

    static int posicionVehiculo () {
        int posCli = AplicCliente.posicionCliente();
        String patente = IBIO.input("Patente del vehiculo: ");
        for (int i = 0; i < AplicLubricentro.cantClientes; i++) {
            for (int j = 0; j < AplicLubricentro.cantVehiculos; j++) {
                String patenteVeh = AplicLubricentro.clientes.get(posCli).getVehiculos().get(j).getPatente();
                if (patenteVeh.equals(patente)) {
                    return j;
                }
            }
        }
        return -1;
    }

    static void modificarVehiculo () {
        int posVeh = posicionVehiculo ();
        Vehiculo veh = AplicLubricentro.vehiculos.get(posVeh);
        if (posVeh != -1) {
            char opc;
            do {
                System.out.println("\n'a'- Marca" +
                        "\n'o'- Modelo" +
                        "\n'k' - Kilometraje" +
                        "\n'** - Salir");
                opc = IBIO.inputChar("\nInformación a modificar: ");
                switch (opc) {
                    case 'a': veh.setMarca(IBIO.input("Marca: "));
                        break;
                    case 'o': veh.setModelo(IBIO.input("Modelo: "));
                        break;
                    case 'k': veh.setKilometraje(IBIO.inputInt("Kilometraje: "));
                        break;
                    default:
                        break;
                }
            } while (opc != '*');
            System.out.println("Vehículo modificado");
        } else {
            System.out.println("Vehículo no registrado");
        }
    }

    static void listarVehiculos () {
        if (AplicLubricentro.cantVehiculos >= 1) {
            for (int i = 0; i < AplicLubricentro.cantVehiculos; i++) {
                System.out.println("\nVEHÍCULO n°" + i);
                AplicLubricentro.vehiculos.get(i).verInfo();
                System.out.println("\n--------------------------------------------");
            }
        } else {
            System.out.println("Sin vehículos registrados");
        }
    }

    static void registrarServicio () {
        int posVeh = posicionVehiculo ();
        boolean vehiculoNoExiste = true;
        if (posVeh != -1) {
            AplicLubricentro.vehiculos.get(posVeh).cargarServicio();
            vehiculoNoExiste = false;
        }
        if (vehiculoNoExiste) {
            System.out.println("Vehículo no registrado");
        }
    }
}
