
package parque_estacionamento_1;

import static Domain.Seguranca.menu_Seg;
import Domain.Utilizadores;
import static Domain.Utilizadores.menu_Admin_Sist;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Parque_Estacionamento_1 {

   
    public static void main(String[] args) throws IOException {
        Utilizadores u=new Utilizadores();
        
        menuPrincipal();
        
        //menu_Admin_Sist();
        
    }
    
    
 public static void menuPrincipal() throws IOException{
        
        Scanner ler=new Scanner(System.in);
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
 
    public static void Login() throws IOException{
        
        System.out.println("\t\t\t\t\t                     Login ");
        System.out.println("\t\t\t\t\t     ");        Scanner ler=new Scanner(System.in);
        
        System.out.print("\t\tNome Usuario:");
        String nomeUsuario=ler.nextLine();
        
        System.out.print("\t\tSenha:");
        String senhaUsuario=ler.nextLine();
        
        
        Utilizadores utilLog=new Utilizadores();
        List<Utilizadores> list_util=utilLog.LerFicheiro();
        
        for(Utilizadores u:list_util){
            if(nomeUsuario.equals(u.Nome) && senhaUsuario.equals(u.senha) ){
           
                menu_Seg();
                      
         /*   }else if(nomeUsuario.equals(u.Nome) && senhaUsuario.equals(u.senha)){
                
                menu_Administrativo();
                
            }else if(nomeUsuario.equals(u.Nome) && senhaUsuario.equals(u.senha) ){
                
                menu_Admin_Sist();
                */
            }else{
                System.err.println("\t\tEste usuario nao existe!");
            }
        
        }
    }
    
   
    
    
     public static void menu_Administrativo() throws IOException{
         Scanner ler=new Scanner(System.in);
         int opc=0;
         
         while(opc!=4){
         
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
        System.out.println("\t\t\t\t     **      2 -> Actualizar registro dos condutores      **");
        System.out.println("\t\t\t\t     **      3 -> Eliminar registro dos condutores        **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     **      4 -> Logout                                  **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");    
        System.out.print("\t\t\t\t     Escolha uma opcao:");
         opc=ler.nextInt();
         
         switch(opc){
             case 1:System.out.println("\n\n");
                 break;
             case 2:
                 break;
             case 3:System.out.println("\n\n");
                 break;
             case 4:System.out.println("\n\n");
                 menuPrincipal();
                 break;    
             default:System.err.println("Opcao Invalida!");
                 break;
         }
         
             
             
         }
         
      
    }
     
    
    
    
    
    
}
