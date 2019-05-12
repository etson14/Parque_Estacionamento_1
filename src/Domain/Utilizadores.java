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

import static parque_estacionamento_1.Parque_Estacionamento_1.menu_Admin_Sist;


public class Utilizadores {
    
    //Atributos dos utilizadores
    private int ID_Utilizador;
    private String Nome;
    private String Nome_util;
    private String senha;
    private String tipo;
    
    public static Scanner ler=new Scanner (System.in);
    
    //Metodos acessores & metodos modificadores 
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNome_util() {
        return Nome_util;
    }

    public void setNome_util(String Nome_util) {
        this.Nome_util = Nome_util;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    public  int getID_Utilizador(){
        return this.ID_Utilizador;
    }
    
    public void setID_Utilizador(int ID_Utilizador){
        this.ID_Utilizador=ID_Utilizador;
    }

    public  String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
   
    int op;
    
      
      File file_util=new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Utilizadores.txt");

   
   
   
   
   //Metodo adicionar utilizadores
   public Utilizadores adicionar() throws IOException{
       System.out.println("\n");
       Utilizadores util=new Utilizadores();
       List<Utilizadores> list_util = LerFicheiro();
       
       
       util.ID_Utilizador=list_util.size()+1;
       
       
       ler.nextLine();
       System.out.print("\t\tEntre com o nome:");
       util.Nome=ler.nextLine();
       
       System.out.print("\t\tEntre com o nome do utilizador:");
       util.Nome_util=ler.nextLine();
       
       for(Utilizadores u:list_util){
           while(util.Nome_util.equals(u.Nome_util)){
               System.err.println("\t\tEste usuario ja existe!");
               System.out.print("\t\tEntre novamente com o nome do Utilizador:");
               util.Nome=ler.nextLine();
           }
       }
      
       System.out.print("\t\tEntre com a senha (6-12 caracteres):");
       util.senha=ler.nextLine();
       
       //System.out.println("[0-9|A-Z|a-z]{15}[@]{1}[a-z]{12}[.com|.cv]");
       
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
           case 1:util.tipo="Seguranca" ;
                   break;
           case 2:util.tipo="Administrativo";
                    break;
           default:System.out.println("Opcao invalido");
       }
       
       list_util.add(util);
       SalvarFicheiro(list_util);
       return util;
       
       
       
   }
   
   
   //Metodos que lista os utilizadores
   public  void Listar() throws IOException{
       List<Utilizadores> list_util =LerFicheiro();
       System.out.println("\t\t     Codigo         |Nome Completo           |Nome Utilizador             |Senha            |Tipo");
       
       list_util.forEach((u) -> {
           System.out.println("\t\t     "+u.ID_Utilizador+"               "+u.Nome+"         "+u.Nome_util+"                      "+u.senha+"            "+u.tipo);
        });
           
       
   }
   
   //Metodo cancelar conta
   public  void cancelar_conta() throws IOException{
       
       
       List<Utilizadores> list_util=LerFicheiro();
       Utilizadores util=new Utilizadores();
       
       final int cod_util;
       
       System.out.println("\n");
       ler.nextLine();
       System.out.print("\t\tEntra com o codigo de utilizador que desejas cancelar a sua conta:");
        cod_util=ler.nextInt();
       Utilizadores test_util=util.testa_u(cod_util);
        
       if(test_util!=null){
           for(Utilizadores u:list_util){
           if(u.ID_Utilizador==cod_util){
               list_util.remove(u);
               SalvarFicheiro(list_util);
               System.out.println("\t\tConta cancelado com sucesso!\n");
               util.Listar();
               
           }
           
        }
       }else{
               
            System.err.println("\t\tEste utilizador nao existe!");
           
       }
       
       
       menu_Admin_Sist();
      
   }


   //Metodo salvar utilizadores no ficheiro
   public void SalvarFicheiro(List<Utilizadores> util) throws IOException{
       FileWriter fw=new FileWriter(file_util);
       BufferedWriter bw=new BufferedWriter(fw);
       
       for(Utilizadores u: util){
           
           bw.write(u.ID_Utilizador+";");
           bw.write(u.Nome+";");
           bw.write(u.Nome_util+";");
           bw.write(u.senha+";");
           bw.write(u.tipo+";\n");
          
       }
        bw.close();
       
        
   }
   
   //Metodo que carrega os utilizadores do ficheiro
   public List<Utilizadores> LerFicheiro() throws FileNotFoundException, IOException{
       List<Utilizadores> list_util=new ArrayList<> ();
       FileReader fr=new FileReader(file_util);
       BufferedReader br=new BufferedReader(fr);
       
       String dados;
       
       while((dados=br.readLine())!=null){
           Utilizadores util=new Utilizadores();
           String[] atributos=dados.split(";");
           
           util.ID_Utilizador=Integer.parseInt(atributos[0]);
           util.Nome=atributos[1];
           util.Nome_util=atributos[2];
           util.senha=atributos[3];
           util.tipo=atributos[4];
           
           
           list_util.add(util);
       }
       
       return list_util;
   }
   
   //Metodo que recebe como parametro nome & senha e verifica se esse utilizador existe
   //caso existir retorno esse utilizador caso nao retorna nulo
   public Utilizadores testa_util(String nome,String senha) throws IOException{
       List<Utilizadores> list_util=LerFicheiro();
       
       for(Utilizadores u: list_util){
           if(u.Nome_util.equals(nome) && u.senha.equals(senha)){
        
           return u;
            }
       
       }

       return null;
    }
   
   //Metodo que recebe como parametro o id e verifica se existe utilizador com este id
   //caso existir retorno esse utilizador caso nao retorna nulo
   public Utilizadores testa_u(int ID) throws IOException{
       List<Utilizadores> list_util=LerFicheiro();
       
       for(Utilizadores u:list_util){
           if(u.ID_Utilizador==ID){
               return u;
           }
       }
       
       return null;
   }
   
  
}
