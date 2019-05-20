package parque_estacionamento_1;

import Domain.Cartao;
import Domain.Condutor;
import Domain.Consulta;
import Domain.Especial;
import Domain.Registro;

import Domain.Utilizadores;
import Domain.Veiculo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Parque_Estacionamento_1 {

    public static int id_u, id_s;
    public static Scanner ler = new Scanner(System.in);
    public static String nome_seg,nome_admin,nome_admin_sist;

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
        Utilizadores util=new Utilizadores();
        List<Utilizadores> lista_util=util.LerFicheiro();

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
                nome_seg=u.getNome();
                menu_Seg();

            } else if (u.getTipo().equals("Administrativo")) {
                id_s = u.getID_Utilizador();
                nome_admin=u.getNome();
                menu_principal_administrativo();

            } else if (u.getTipo().equals("Admin_Sistema")) {
                nome_admin_sist=u.getNome();
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
            System.out.println("\t\t\t\t     **              ADMINISTRADOR SISTEMA                **");
            System.out.println("\t\t\t\t     **                                                   **");
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
                    System.err.println("\t\tOpcao invalido!");
                    break;
            }

        }
    }
    
    public static void menu_reg() throws IOException{
        Registro reg=new Registro();
        int opc=0;
        
        while(opc!=4){
            
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                      REGISTRO                     **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **    1 -> Registrar Entrada                         **");
            System.out.println("\t\t\t\t     **    2 -> Registar Saida                            **");
            System.out.println("\t\t\t\t     **    3 -> Listar Registros                          **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **    4 -> voltar                                    **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");
            opc=ler.nextInt();
            
            switch(opc){
                case 1:System.out.println("\n");
                    reg.add_registro_entrada();
                    break;
                case 2:System.out.println("\n");
                    reg.add_registro_saida();
                    break;
                case 3:System.out.println("\n");
                    reg.listar_registro();
                    break;
                case 4:menu_Seg();
                    break;    
                default:System.err.println("Opcao invalido!");    
            }
            
        }
    }
    

    public static void menu_Seg() throws IOException {
        Especial e=new Especial();
        Registro reg = new Registro();

        int opc = 0;

        while (opc != 5) {

            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                    SEGURANCA                      **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **    1 -> Listar Veiculos nos dias de servicos      **");
            System.out.println("\t\t\t\t     **    2 -> Autorizar acesso ao veiculos especiais    **");
            System.out.println("\t\t\t\t     **    3 -> Registros Entrada & Saida                 **");
            System.out.println("\t\t\t\t     **    4 -> Veiculos                                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **    5 -> Logout                                    **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");

            opc = ler.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("\n");
                    reg.listar_reg_util();
                    break;
                case 2:
                    System.out.println("\n");
                    e.add_especial();
                    break;
                case 3:System.out.println("\n");
                    menu_reg();
                    break;
                case 4:
                    System.out.println("\n");
                    menu_veiculo();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.err.println("Opcao Invalido!");
                    break;
            }

        }

    }
    
    public static void menu_principal_administrativo() throws IOException{
        
        int opc=0;
        
        
        while(opc!=5){
            
            System.out.println("\n\n");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                   ADMINISTRATIVO                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      1 -> Condutores                              **");
            System.out.println("\t\t\t\t     **      2 -> Veiculos                                **");
            System.out.println("\t\t\t\t     **      3 -> Registros Entrada & Saida               **");
            System.out.println("\t\t\t\t     **      4 -> Consultas                               **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      5 -> Logout                                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");
            opc = ler.nextInt();
            
            switch(opc){
                case 1:System.out.println("\n");
                       menu_Administrativo();
                    break;
                case 2:System.out.println("\n");
                    menu_veiculo();
                    break;
                case 3:System.out.println("\n");
                    menu_reg();
                    break;
                case 4:System.out.println("\n");
                    menu_Consultas();
                    break;
                case 5:System.out.println("\n");
                    menuPrincipal();
                    break;
                default:System.err.println("Opcao invalido!");
            }
            
        }
    }

    public static void menu_Administrativo() throws IOException {

        int opc = 0;

        Condutor cond = new Condutor();
        Cartao cart = new Cartao();

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
            System.out.println("\t\t\t\t     **                   CONDUTORES                      **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      1 -> Registrar Condutores                    **");
            System.out.println("\t\t\t\t     **      2 -> Listar Condutores                       **");
            System.out.println("\t\t\t\t     **      3 -> Actualizar dados dos condutores         **");
            System.out.println("\t\t\t\t     **      4 -> Eliminar dados dos condutores           **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      5 -> Voltar                                  **");
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
                    
                    break;
                case 6:
                    System.out.println("\n\n");
                    menu_principal_administrativo();
                    break;

                default:
                    System.err.println("\t\tOpcao Invalido!");
                    break;
            }

        }

    }
    
    public static void menu_veiculo() throws IOException {

        int opc = 0;

        Veiculo v=new Veiculo();

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
            System.out.println("\t\t\t\t     **                       VEICULO                     **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      1 -> Registrar Veiculo                       **");
            System.out.println("\t\t\t\t     **      2 -> Listar Veiculo                          **");
            System.out.println("\t\t\t\t     **      3 -> Actualizar dados do veiculo             **");
            System.out.println("\t\t\t\t     **      4 -> Eliminar veiculo                        **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     **      5 -> Voltar                                  **");
            System.out.println("\t\t\t\t     **                                                   **");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.println("\t\t\t\t     *******************************************************");
            System.out.print("\t\t\t\t     Escolha uma opcao:");
            opc = ler.nextInt();

            switch (opc) {
                case 1:
                        System.out.println("\n");
                        v.add_veiculo();

                    break;
                case 2:
                        System.out.println("\n");
                        v.listar_veiculo();
                    
                    break;
                case 3:
                    System.out.println("\n");
                    v.actualizar_veiculo();
                    
                    break;
                case 4:
                    System.out.println("\n");
                    v.eliminar_veiculo();
                    
                    break;
                case 5:
                    System.out.println("\n");
                    menu_principal_administrativo();
                    break;
              
                default:
                    System.err.println("\t\tOpcao Invalido!");
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
            System.out.println("\t\t\t\t     **                       CONSULTAS                   **");
            System.out.println("\t\t\t\t     **                                                   **");
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
                default:System.err.println("\t\tOpcao Invalido!");    

            }
        }
    }

}
