package Domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static parque_estacionamento_1.Parque_Estacionamento_1.menuPrincipal;


public class Utilizadores {
    public String ID_Utilizador;
    public String Nome;
    public String senha;
    public String tipo;

    public  String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
   
    int op;
    Scanner ler=new Scanner (System.in);
    
      File file_util=new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Utilizadores.txt");

   public static void menu_Admin_Sist() throws IOException{
       Scanner ler=new Scanner (System.in);
       int op=0;
       
       
       while(op!=3){
       
        System.out.println("\n\n");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     ** BENVINDO SISTEMA DE GESTAO PARQUE ESTACIONAMENTO  **");
        System.out.println("\t\t\t\t     **                                                   **");
        System.out.println("\t\t\t\t     *******************************************************");
        System.out.println("\t\t\t\t     *******************************************************");
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
       
         
        op=ler.nextInt();
        Utilizadores u=new Utilizadores();
         switch(op){
             case 1:System.out.println("\n");
             u.Listar();
             u.adicionar();
             u.Listar();
             
             
                 break;
             case 2:System.out.println("\n");
             u.Listar();
             u.cancelar_conta();
             
                 break;
             
             case 3:System.out.println("\n");
                 menuPrincipal();
                 break;
             default:System.err.println("Opcao invalido!");
                break;
         }
       
        }
   }
   
   
   public Utilizadores adicionar() throws IOException{
       System.out.println("\n");
       Utilizadores util=new Utilizadores();
       List<Utilizadores> list_util = LerFicheiro();
       
       
       System.out.print("\t\tEntre com o codigo do Utilizador:");
       util.ID_Utilizador=ler.nextLine();
       
       while(!(util.ID_Utilizador.matches("[0-9]{4}"))){
       System.err.println("\t\tO codigo deve ser numerico!");
       System.out.print("\t\tEntre novamente com o codigo do Utilizador:");
       util.ID_Utilizador=ler.nextLine();
       }
       
       for(Utilizadores u:list_util){
           while(util.ID_Utilizador.equals(u.ID_Utilizador)){
               System.err.println("\t\tJa exixte um usuario com este codigo!");
               System.out.print("\t\tEntre novamente com o codigo do Utilizador:");
               util.ID_Utilizador=ler.nextLine();
           }
       }
       
       
       System.out.print("\t\tEntre com o nome do Utilizador:");
       util.Nome=ler.nextLine();
       
       for(Utilizadores u:list_util){
           while(util.Nome.equals(u.Nome)){
               System.err.println("\t\tEste usuario ja existe!");
               System.out.print("\t\tEntre novamente com o nome do Utilizador:");
               util.Nome=ler.nextLine();
           }
       }
      
       System.out.print("\t\tEntre com a senha (6-12 caracteres):");
       util.senha=ler.nextLine();
       
       while(!(util.senha.matches("[0-9|A-Z|a-z]{6,12}"))){
           System.err.println("\t\tSenha Invalida");
           System.out.print("\t\tEntre novamente com a senha (6-12 caracteres):");
           util.senha=ler.nextLine();
       }
       
     
       System.out.println("\t\tEscolha o tipo de utilizador");
       System.out.println("\t\t1 -> Seguranca");
       System.out.println("\t\t2 -> Administrativo");
       System.out.print("\t\tEscolha uma opção: ");
       int op=ler.nextInt();
       switch(op){
           case 1:util.tipo="seguranca" ;
                   break;
           case 2:util.tipo="Administrativo";
                    break;
           default:System.out.println("Opcao invalido");
       }
       
       list_util.add(util);
       SalvarFicheiro(list_util);
       return util;
       
       
       
   }
   /*
   public void sub_menuUtil() throws IOException{
       System.out.println("\n");
        
       System.out.println("\t\t 1 -> Criar novamente");
       System.out.println("\t\t 2 -> Voltar\n");
       System.out.println("\t\t Escolha uma opcao:");
       int op=ler.nextInt();
       
       switch(op){
           case 1:adicionar();
                break;
           case 2:menu_Admin_Sist();
                break;
           default:System.err.println("Opcao invalido"); 
            break;
           
               
       }
   }*/
   
   private  void Listar() throws IOException{
       List<Utilizadores> list_util =LerFicheiro();
       System.out.println("\t\t\t\t     Codigo         |Nome           |Senha             |Tipo            ");
       
       for(Utilizadores util:list_util){
           System.out.println("\t\t\t\t     "+util.ID_Utilizador+"           "+util.Nome+"           "+util.senha+"           "+util.tipo+"          ");
       }
           
       
   }
   
   private  void cancelar_conta() throws IOException{
       
       int op;
       List<Utilizadores> list_util=LerFicheiro();
       Utilizadores util=new Utilizadores();
       final String cod_util;
       
       System.out.println("\n");
       System.out.print("\t\tEntra com o codigo de utilizador que desejas cancelar a sua conta:");
        cod_util=ler.nextLine();
       
       for(Utilizadores u:list_util){
           if(u.ID_Utilizador.equals(cod_util)){
               list_util.remove(u);
               SalvarFicheiro(list_util);
               System.out.println("\t\t\nConta cancelado com sucesso!");
           }
           else{
               System.err.println("\t\tEste utilizador nao existe!");
           }
       }
       
       menu_Admin_Sist();
       
       
       
       
       
       
   }


   
   public void SalvarFicheiro(List<Utilizadores> util) throws IOException{
       FileWriter fw=new FileWriter(file_util);
       BufferedWriter bw=new BufferedWriter(fw);
       
       for(Utilizadores u: util){
           
           bw.write(u.ID_Utilizador+";");
           bw.write(u.Nome+";");
           bw.write(u.senha+";");
           bw.write(u.tipo+";\n");
       }
        bw.close();
        
        
   }
   
   public List<Utilizadores> LerFicheiro() throws FileNotFoundException, IOException{
       List<Utilizadores> list_util=new ArrayList<> ();
       FileReader fr=new FileReader(file_util);
       BufferedReader br=new BufferedReader(fr);
       
       String dados;
       
       while((dados=br.readLine())!=null){
           Utilizadores util=new Utilizadores();
           String[] atributos=dados.split(";");
           
           util.ID_Utilizador=atributos[0];
           util.Nome=atributos[1];
           util.senha=atributos[2];
           util.tipo=atributos[3];
           
           
           list_util.add(util);
       }
       
       return list_util;
   }

}
