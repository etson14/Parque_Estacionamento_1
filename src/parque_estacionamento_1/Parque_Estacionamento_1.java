package parque_estacionamento_1;

import Domain.Cartao;
import Domain.Condutor;
import Domain.Consulta;
import Domain.Registro;

import Domain.Utilizadores;

import java.io.IOException;
import java.util.Scanner;

public class Parque_Estacionamento_1 {

    public static int id_u, id_s;
    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       
        menuPrincipal();

    }

    public static void menuPrincipal() throws IOException {

        int opc;

        System.out.println("\t\t ***   ***   *********   ***          *********   ***    *********   *********   *********   *********      ");
        System.out.println("\t\t ***   ***   ***   ***   ***          ***   ***   ***    ***   ***   ***         ***            ***         ");
        System.out.println("\t\t ***   ***   ***   ***   ***   ***    *********   ***    *********   ***   ***   *********      ***         ");
        System.out.println("\t\t ***   ***   ***   ***   ***          ***         ***    ***   ***   *********   ***            ***         ");
        System.out.println("\t\t *********   ***   ***   ***          ***         ***    ***   ***   *********   *********      ***         ");
        System.out.println("\t                                                                                                              ");
        System.out.println("\t\t\t\t\t     SISTEMA DE GESTAO PARQUE ESTACIONAMENTO                                                         \n");

        System.out.println("\t\t\t\t\t                     Login ");
        Login();

    }

    public static void Login() throws IOException {

        String nomeUsuario, senhaUsuario;

        System.out.println("\t\t\t\t\t     ");
        
        ler.nextLine();
        System.out.print("\t\tNome Usuario:");
        nomeUsuario = ler.nextLine();

        System.out.print("\t\tSenha:");
        senhaUsuario = ler.nextLine();

        Utilizadores utilLog = new Utilizadores();
        Utilizadores u = utilLog.testa_util(nomeUsuario, senhaUsuario);

        if (u != null) {
            if (u.getTipo().equals("Seguranca")) {
                id_s = u.getID_Utilizador();
                menu_Seg();

            } else if (u.getTipo().equals("Administrativo")) {
                id_u = u.getID_Utilizador();
                menu_Administrativo();

            } else if (u.getTipo().equals("Admin_Sistema")) {
                menu_Admin_Sist();
            }

        } else {
            System.out.println("\n");
            System.err.println("\t\tEste usuario nao existe!");
            System.err.println("\t\tTente novamente!");
            Login();

        }

    }

    public static void menu_Admin_Sist() throws IOException {

        int op = 0;

        while (op != 3) {

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
            System.out.println("\t\t\t\t     **      1 -> Criar conta e perfis de acesso          **");
            System.out.println("\t\t\t\t     **      2 -> Cancelar contas de acesso               **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      3 -> Logout                                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\tEscolha uma opcao:");
            op = ler.nextInt();

            Utilizadores u = new Utilizadores();

            switch (op) {
                case 1:
                    System.out.println("\n");
                    u.Listar();
                    u.adicionar();
                    u.Listar();

                    break;
                case 2:
                    System.out.println("\n");
                    u.Listar();
                    u.cancelar_conta();

                    break;

                case 3:
                    System.out.println("\n");
                    menuPrincipal();
                    break;
                default:
                    System.err.println("Opcao invalido!");
                    break;
            }

        }
    }

    public static void menu_Seg() throws IOException {

        Registro reg = new Registro();

        int opc = 0;

        while (opc != 3) {

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
            System.out.println("\t\t\t\t     **    1 -> Listar Veiculos                           **");
            System.out.println("\t\t\t\t     **    2 -> Autorizar acesso ao veiculos especiais    **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **   3 -> Logout                                     **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");

            opc = ler.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("\n\n");
                    reg.listar_reg_util();
                    break;
                case 2:
                    break;
                case 3:
                    menuPrincipal();
                    break;
                default:
                    System.err.println("Opcao Invalida!");
                    break;
            }

        }

    }

    public static void menu_Administrativo() throws IOException {

        int opc = 0;

        Condutor cond = new Condutor();
        Cartao cart = new Cartao();

        while (opc != 6) {

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
            System.out.println("\t\t\t\t     **      3 -> Actualizar dados dos condutores         **");
            System.out.println("\t\t\t\t     **      4 -> Eliminar dados dos condutores           **");
            System.out.println("\t\t\t\t     **      5 -> Consultas                               **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      6 -> Logout                                  **");
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
                    menu_Consultas();
                    break;
                case 6:
                    System.out.println("\n\n");
                    menuPrincipal();
                    break;

                default:
                    System.err.println("Opcao Invalida!");
                    break;
            }

        }

    }

    public static void menu_Consultas() throws IOException {
        Consulta c = new Consulta();
        String opc = "1";

        while (opc != "0") {
            System.out.println("\n\n");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                         Menu                      **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                 1  ->  Consulta 1                 **");
            System.out.println("\t\t\t\t     **                 2  ->  Consulta 2                 **");
            System.out.println("\t\t\t\t     **                 3  ->  Consulta 3                 **");
            System.out.println("\t\t\t\t     **                 4  ->  Consulta 4                 **");
            System.out.println("\t\t\t\t     **                 5  ->  Consulta 5                 **");
            System.out.println("\t\t\t\t     **                 6  ->  Consulta 6                 **");
            System.out.println("\t\t\t\t     **                 7  ->  Consulta 7                 **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                 0 ->Voltar                        **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");
            opc = ler.nextLine();

            switch (opc) {
                case "0":
                    menu_Administrativo();
                    break;
                case "1":
                    System.out.println("\n");
                    c.consulta_1();
                    System.out.println("\n");
                    break;
                case "2":
                    System.out.println("\n");
                    c.consulta_2();
                    System.out.println("\n");
                    break;
                case "3":
                    System.out.println("\n");
                    c.consulta_3();
                    System.out.println("\n");
                    break;
                case "4":
                    System.out.println("\n");
                    c.consulta_4();
                    System.out.println("\n");
                    break;
                case "5":
                    System.out.println("\n");
                    c.consulta_5();
                    System.out.println("\n");
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("\n");
                    c.consulta_7();
                    System.out.println("\n");
                    break;

            }
        }
    }

}
