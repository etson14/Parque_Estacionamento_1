
package Domain;


import static Domain.Cartao.id_Cart;
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

import static parque_estacionamento_1.Parque_Estacionamento_1.id_u;

public class Condutor extends Pessoa{
    
    private int Id_Condutor;
    private String tipo_condutor;
    private int n_cartao;
    private int id_Utilizador;

    public int getN_cartao() {
        return n_cartao;
    }

    public void setN_cartao(int n_cartao) {
        this.n_cartao = n_cartao;
    }

    public int getId_Utilizador() {
        return id_Utilizador;
    }

    public void setId_Utilizador(int id_Utilizador) {
        this.id_Utilizador = id_Utilizador;
    }
    
    
    
    public int getId_Condutor(){
        return this.Id_Condutor;
    }
    
    public void setId_Condutor(int Id_Condutor){
        this.Id_Condutor=Id_Condutor;
    }
    
    
    File file=new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Condutor.txt");
    
    
    
    public static Scanner ler=new Scanner(System.in);
    public static int id_Cond;

    public Condutor add_condutor() throws IOException{
        
        Condutor cond=new Condutor();
        List<Condutor> list_cond=LerFicheiro();
        
        
        cond.Id_Condutor=list_cond.size()+1;
        id_Cond=list_cond.size()+1;
        System.out.print("\t\tNome:");
        cond.nome=ler.nextLine();
        
        System.out.print("\t\tEmail:");
        cond.email=ler.nextLine();
        
        System.out.print("\t\tTelefone:");
        cond.telefone=ler.nextLine();
        
        System.out.println("\t\tEscolhe o sexo");
        
        System.out.println("\t\t1-Masculino");
        System.out.println("\t\t2-Feminino");
        System.out.println("\t\t3-Outros");
        
        System.out.print("\t\tEscolhe uma opcao:");
        int s=ler.nextInt();
        
        
        switch(s){
            case 1:cond.sexo="M";
                break;
            case 2:cond.sexo="F";
                break;
            case 3:cond.sexo="Outros";
                break;
                
            default:System.err.println("\t\tOpcao Invalido");    
        }
        
        System.out.println("\t\tEscolhe o tipo do condutor");
        
        System.out.println("\t\t1-Funcionario");
        System.out.println("\t\t2-Aluno");
        System.out.println("\t\t3-Residente");
        
        System.out.print("\t\tEscolhe uma opcao:");
        int t=ler.nextInt();
        
        switch(t){
            case 1:cond.tipo_condutor="Funcionario";
                break;
            case 2:cond.tipo_condutor="Aluno";
                break;
            case 3:cond.tipo_condutor="Residente";
                break;
                
            default:System.err.println("\t\tOpcao Invalido");    
        }
        
        ler.nextLine();
        
        cond.n_cartao=id_Cart;
        
        cond.id_Utilizador=id_u;
        
        
        list_cond.add(cond);
        SalvarFicheiro(list_cond);
        System.out.println("\n\t\tCondutor registado com sucesso!");
        return cond;
        
       
    }
    
    
    public void SalvarFicheiro(List<Condutor> list_cond) throws IOException{
        
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        for(Condutor c:list_cond){
            
            bw.write(c.Id_Condutor+";");
            bw.write(c.nome+";");
            bw.write(c.email+";");
            bw.write(c.telefone+";");
            bw.write(c.sexo+";");
            bw.write(c.tipo_condutor+";");
            bw.write(c.n_cartao+";");
            bw.write(c.id_Utilizador+";\n");
            
            
            }
            bw.close();
    }
    
    public List<Condutor> LerFicheiro() throws FileNotFoundException, IOException{
        List<Condutor> list_cond=new ArrayList<>();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        
        String dados;
        
        while((dados=br.readLine())!=null){
            Condutor cond=new Condutor();
            String atributo[]=dados.split(";");
            
            cond.Id_Condutor=Integer.parseInt(atributo[0]);
            cond.nome=atributo[1];
            cond.email=atributo[2];
            cond.telefone=atributo[3];
            cond.sexo=atributo[4];
            cond.tipo_condutor=atributo[5];
            cond.n_cartao=Integer.parseInt(atributo[6]);
            cond.id_Utilizador=Integer.parseInt(atributo[7]);
            
            list_cond.add(cond);
            
        }
        
        
        return list_cond;
    }
    
    
    public void Listar_Condutor() throws IOException{
        List <Condutor> list_cond =LerFicheiro();
        
        System.out.println("Id Condutor  |Nome          |Email                  |Telefone          |Sexo   |Tipo                |N Cartao          |Id Utilizador  ");
        list_cond.forEach((c)->{
            System.out.println(c.Id_Condutor+"            "+c.nome+"          "+c.email+"          "+c.telefone+"            "+c.sexo+"       "+c.tipo_condutor+"          "+c.n_cartao+"             "+c.id_Utilizador);
        });
        
    }
    
    public void Eliminar_Condutor() throws IOException{
        
         List <Condutor> list_cond =LerFicheiro();
         
         Listar_Condutor();
         
         System.out.print("\t\t Digite o codigo do condutor que desejas eliminar:");
         final int id_c=ler.nextInt();
         
         Condutor cond=new Condutor();
         
         Condutor c=cond.test_cond(id_c);
         
        if(c!=null){
            
        for(int i=0;i<list_cond.size();i++){
            if(list_cond.get(i).getId_Condutor()==id_c){
                list_cond.remove(i);
                SalvarFicheiro(list_cond);
                System.out.println("\n\n\t\ttCondutor eliminado com sucesso");
                Listar_Condutor();
            }
        }
        }else{
                System.err.println("\n\t\tEste condutor nao existe");
                }
            
        
    
        
       
    }
    
    public void actualizar_condutor() throws IOException{
        System.out.println("\n\n");
        List <Condutor> list_cond =LerFicheiro();
        Condutor cond=new Condutor();
       
         
         Listar_Condutor();
         
         System.out.print("\t\t\nDigite o codigo do condutor que desejas actualizar:");
         final int id_c=ler.nextInt();
         
          Condutor c=cond.test_cond(id_c);
          
          
         if(c!=null){
          
         for(int i=0;i<list_cond.size();i++){
            if(list_cond.get(i).getId_Condutor()==id_c){
            list_cond.remove(i);
                 
            
            System.out.print("\t\tNome:");
            cond.nome=ler.nextLine();
        
            System.out.print("\t\tEmail:");
            cond.email=ler.nextLine();
        
            System.out.print("\t\tTelefone:");
            cond.telefone=ler.nextLine();
        
            System.out.println("\t\tEscolhe o sexo");
        
            System.out.println("\t\t1-Masculino");
            System.out.println("\t\t2-Feminino");
            System.out.println("\t\t3-Outros");
        
            System.out.print("\t\tEscolhe uma opcao:");
            int s=ler.nextInt();
        
        
            switch(s){
            case 1:cond.sexo="M";
                break;
            case 2:cond.sexo="F";
                break;
            case 3:cond.sexo="Outros";
                break;
                
            default:System.err.println("\t\tOpcao Invalido");    
            }
        
            System.out.println("\t\tEscolhe o tipo do condutor");
        
            System.out.println("\t\t1-Funcionario");
            System.out.println("\t\t2-Aluno");
            System.out.println("\t\t3-Residente");
        
            System.out.print("\t\tEscolhe uma opcao:");
            int t=ler.nextInt();
        
            switch(t){
            case 1:cond.tipo_condutor="Funcionario";
                break;
            case 2:cond.tipo_condutor="Aluno";
                break;
            case 3:cond.tipo_condutor="Residente";
                break;
                
            default:System.err.println("\t\tOpcao Invalido");    
                }
            
            
            
            
            list_cond.add(i, c);
            SalvarFicheiro(list_cond);
            
            
            System.out.println("\t\t\nCondutor actualizado com sucesso!");
            
            }
             
            }
         }else{
             
             System.err.println("\t\t\nCondutor nao encontrado!");
             
         }
         
        }
    
   public Condutor test_cond(int id) throws IOException{
       
       List<Condutor> list_cond=LerFicheiro();
       
       for(Condutor c:list_cond){
           if(c.Id_Condutor==id){
               return c;
           }
        }
             return null;
    }
    
    
    
    
   
    
    
    
}
