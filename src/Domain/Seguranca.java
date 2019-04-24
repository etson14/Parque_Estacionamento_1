
package Domain;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import static parque_estacionamento_1.Parque_Estacionamento_1.menuPrincipal;


public class Seguranca {
    
    public int codigo_Seg;
    public String nome_Seg;
    public Date data_N_Seg;
  

    public static void menu_Seg() throws IOException{
         Scanner ler=new Scanner(System.in);
         int opc=0;
         
         while(opc!=3){
             
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     **      1 -> Listar Veiculos                         **");
        System.out.println("\t\t\t\t     **      2 -> Autorizar acesso ao veiculos especiais  **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     **      3 -> Logout                                  **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");    
        System.out.print("\t\t\t\t     Escolha uma opcao:");     
       
         opc=ler.nextInt();
         
         switch(opc){
             case 1:
                 break;
             case 2:
                 break;
             case 3:menuPrincipal();
                 break;
             default:System.err.println("Opcao Invalida!");
                 break;
         }
             
         }
         
         
         
         
    }

   

    
    
    
    
    
    
    
    
    
    
    
}
