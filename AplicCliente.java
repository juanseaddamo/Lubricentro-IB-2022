package Lubricentro;

public class AplicCliente {

    public static void menuClientes () {
        char opc;
        do {
            /*
            System.out.println("\n-------------------------------------" +
                    "\nCLIENTES" +
                    "\n1. Alta" +
                    "\n2. Baja" +
                    "\n3. Modifcar" +
                    "\n4. Listar" +
                    "\n5. Buscar" +
                    "\n6. Enter para volver al menu anterior" +
                    "\n-------------------------------------");

            */

            opc = IBIO.inputChar("\nOPCIÓN: ");
            switch (opc) {
                case '1': altaCliente ();
                    break;
                case '2': bajaCliente ();
                    break;
                case '3': modificarCliente ();
                    break;
                case '4': listarClientes ();
                    break;
                case '5': buscarCliente ();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    static void altaCliente() {
        String dni = IBIO.input("DNI: ");
        boolean clienteNoExiste = true;
        for (int i = 0; i < AplicLubricentro.cantClientes; i++) {
            String dniCli = AplicLubricentro.clientes.get(i).getDni();
            if (dniCli.equals(dni)) {
                System.out.println("Cliente ya registrado");
                clienteNoExiste = false;
            }
        }
        if (clienteNoExiste) {
            String nombre = IBIO.input("Nombre: ");
            String telefono = IBIO.input("Telefono: ");
            String mail = IBIO.input("Mail: ");
            Cliente cli = new Cliente (nombre, dni, telefono, mail);
            AplicLubricentro.clientes.add(cli);
            AplicLubricentro.cantClientes++;
        }
    }

    static void bajaCliente () {
        int posCli = posicionCliente ();
        if (posCli != -1) {
            AplicLubricentro.clientes.remove(posCli);
            System.out.println("Cliente borrado");
            AplicLubricentro.cantClientes = AplicLubricentro.cantClientes - 1;
        } else {
            System.out.println("Cliente no registrado");
        }
    }

    static int posicionCliente () {
        String dni = IBIO.input("DNI del cliente: ");
        for (int i = 0; i < AplicLubricentro.cantClientes; i++) {
            String dniCli = AplicLubricentro.clientes.get(i).getDni();
            if (dniCli.equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    static void modificarCliente() {
        int posCli = posicionCliente ();
        Cliente cli = AplicLubricentro.clientes.get(posCli);
        if (posCli != -1) {
            char opc;
            do {
                System.out.println("\n'n'- Nombre" +
                        "\n't'- Telefono" +
                        "\n'm'- Mail" +
                        "\n'*' - Salir");
                opc = IBIO.inputChar("\nInformación a modificar: ");
                switch (opc) {
                    case 'n': cli.setNombre(IBIO.input("Nombre: "));
                        break;
                    case 't': cli.setTelefono(IBIO.input("Telefono: "));
                        break;
                    case 'm': cli.setMail(IBIO.input("Mail: "));
                        break;
                    default:
                        break;
                }
            } while (opc != '*');
            System.out.println("Cliente modificado");
        } else {
            System.out.println("Cliente no registrado");
        }
    }

    static void listarClientes () {
        if (AplicLubricentro.cantClientes >= 1) {
            for (int i = 0; i < AplicLubricentro.cantClientes; i++) {
                System.out.println("\nCLIENTE n°" + i);
                AplicLubricentro.clientes.get(i).verInfo();
                System.out.println("\n--------------------------------------------");
            }
        } else {
            System.out.println("Sin clientes registrados");
        }
    }

    static void buscarCliente() {
        int posCli = posicionCliente ();
        Cliente cli = AplicLubricentro.clientes.get(posCli);
        if (posCli != -1) {
            cli.verInfo ();
        } else {
            System.out.println("Cliente no registrado");
        }
    }
}
