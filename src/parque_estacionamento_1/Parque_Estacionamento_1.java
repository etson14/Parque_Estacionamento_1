package parque_estacionamento_1;

import Domain.Cartao;
import Domain.Condutor;
import static Domain.Seguranca.menu_Seg;
import Domain.Utilizadores;
import static Domain.Utilizadores.menu_Admin_Sist;
import java.io.IOException;
import java.util.Scanner;

public class Parque_Estacionamento_1 {

    public static int id_u;

    public static void main(String[] args) throws IOException {
        Utilizadores u = new Utilizadores();

        menuPrincipal();

    }

    public static void menuPrincipal() throws IOException {

        Scanner ler = new Scanner(System.in);
        int opc;

        System.out.println("\t\t ***   ***   *********   ***          *********   ***    *********   *********   *********   *********      ");
        System.out.println("\t\t ***   ***   ***   ***   ***          ***   ***   ***    ***   ***   ***         ***            ***         ");
        System.out.println("\t\t ***   ***   ***   ***   ***   ***    *********   ***    *********   ***   ***   *********      ***         ");
        System.out.println("\t\t ***   ***   ***   ***   ***          ***         ***    ***   ***   *********   ***            ***         ");
        System.out.println("\t\t *********   ***   ***   ***          ***         ***    ***   ***   *********   *********      ***         ");
        System.out.println("\t                                                                                                              ");
        System.out.println("\t\t\t\t\t     SISTEMA DE GESTAO PARQUE ESTACIONAMENTO                                                         \n");

        Login();

    }

    public static void Login() throws IOException {

        String nomeUsuario, senhaUsuario;

        System.out.println("\t\t\t\t\t                     Login ");
        System.out.println("\t\t\t\t\t     ");
        Scanner ler = new Scanner(System.in);

        System.out.print("\t\tNome Usuario:");
        nomeUsuario = ler.nextLine();

        System.out.print("\t\tSenha:");
        senhaUsuario = ler.nextLine();

        Utilizadores utilLog = new Utilizadores();
        Utilizadores u = utilLog.testa_util(nomeUsuario, senhaUsuario);

        if (u != null) {
            if (u.getTipo().equals("Seguranca")) {
                menu_Seg();
            } else if (u.getTipo().equals("Administrativo")) {
                id_u = u.getID_Utilizador();
                menu_Administrativo();

            } else if (u.getTipo().equals("Admin_Sistema")) {
                menu_Admin_Sist();
            }

        } else {

            System.err.println("\t\tEste usuario nao existe!");
            Login();

        }

    }

    public static void menu_Administrativo() throws IOException {
        Scanner ler = new Scanner(System.in);
        int opc = 0;

        Condutor cond = new Condutor();
        Cartao cart=new Cartao();

        while (opc != 5) {

            System.out.println("\n\n");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                       MENU                        **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      1 -> Registrar Condutores                    **");
            System.out.println("\t\t\t\t     **      2 -> Listar Condutores                       **");
            System.out.println("\t\t\t\t     **      3 -> Actualizar registro dos condutores      **");
            System.out.println("\t\t\t\t     **      4 -> Eliminar registro dos condutores        **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      5 -> Logout                                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");
            opc = ler.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("\n");
                    cart.add_Cart();
                    cond.add_condutor();
                    
                    break;
                case 2:
                    System.out.println("\n\n");
                    cond.Listar_Condutor();
                    break;
                case 3:
                    System.out.println("\n\n");
                    cond.actualizar_condutor();
                    break;
                case 4:
                    System.out.println("\n\n");
                    cond.Eliminar_Condutor();
                    break;
                case 5:
                    System.out.println("\n\n");
                    menuPrincipal();
                    break;
                default:
                    System.err.println("Opcao Invalida!");
                    break;
            }

        }

    }

}
