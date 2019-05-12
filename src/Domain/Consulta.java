
package Domain;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




public class Consulta {
    
    public static Scanner ler = new Scanner(System.in);
    public static String matricula;
    public static String condutor;
    public static int cont=0;
    
    public static void main(String[] args) throws IOException {
        //Registro r=new Registro();
        //List<Registro> reg=r.LerFicheiro();
        
        //String data_actual=get_Data();
        //System.out.println("Data atual:"+data_actual);
        
    /*
        for(Registro rr:reg){
            System.out.println("Data entrada:"+rr.getData_entrada());
            System.out.println("Data saida:"+rr.getData_saida());
        }

    */
    }
   
    public static String get_Data(){
        DateFormat dataF=new SimpleDateFormat("dd/MM/yyyy");
        Date date =new Date();
        return dataF.format(date);
    }
   
    public void consulta_1() throws IOException{
    System.out.println("\t\t\t     Quais foram as viaturas que entraram e saíram a data de hoje no parque?\n");    
     
     Veiculo veiculo=new Veiculo();
     Registro reg=new Registro();
     List<Registro> lista_reg=reg.LerFicheiro();
     List<Veiculo> lista_veiculo=veiculo.LerFicheiro();
     String data_actual=get_Data();
    
    System.out.println("\t\t\t     |N Matricula         |Marca         |Modelo         |Cor         |Tipo         ");
    for(Registro r:lista_reg){
        if(data_actual.equals(r.getData_entrada())&& data_actual.equals(r.getData_saida())){//Verifica se existe registro com a data actual
            for(Veiculo v:lista_veiculo){
                if(v.getId_veiculo()==r.getId_Veiculo()){//Veiculo associado a este registro
    System.out.println("\t\t\t      "+v.getN_Matricula()+"             "+v.getMarca()+"         "+v.getModelo()+"           "+v.getCor()+"         "+v.getTipo());                
                }
            }
        }
    }
}
    public void consulta_2() throws IOException{
    
    System.out.println("\tQuais foram as viaturas que entraram e não saíram do parque ainda (a data actual) e quais são os condutores associados?\n");        
        
        Registro r=new Registro();
        Veiculo v=new Veiculo();
        Condutor c=new Condutor();
        
        List<Registro> lista_reg=r.LerFicheiro();
        List<Veiculo> lista_veiculo=v.LerFicheiro();
        List<Condutor> lista_cond=c.LerFicheiro();
        
       String data_actual=get_Data();
       
    System.out.println("\t\tN Matricula      |Tipo             |Data & Hora Entrada             |Data & Hora Saida             |Nome Condutor"); 
        for(Registro reg:lista_reg){
          if(reg.getData_entrada().equals(data_actual) && reg.getData_saida().equals("null")){//Verifica se existe algum registro sem a data de saida
              for(Veiculo veiculo:lista_veiculo){
                  if(reg.getId_Veiculo()==veiculo.getId_veiculo()){//Desses registro verifica  os veiculo associados a eles
                      for(Condutor cond:lista_cond){
                          if(cond.getId_Condutor()==veiculo.getId_Condutor()){//Desses veiculos associados ao registro mostra quem sao o condutores associados
    System.out.println("\t\t"+veiculo.getN_Matricula()+"          "+veiculo.getTipo()+"            "+reg.getData_entrada()+" "+reg.getHora_entrada()+"               "+reg.getData_saida()+" "+reg.getHora_saida()+"                     "+cond.nome);                             
                          }
                       
                      }
                  }
              }
          }
      }
        
        
    }
    
    public  void consulta_3() throws IOException{
        
    System.out.println("\t     Quantas vezes entrou a viatura ST-57-PN no parque durante a última semana e a quem pertence essa viatura?\n");     
        
        Registro r=new Registro();
        Veiculo v=new Veiculo();
        Condutor c=new Condutor();
        
        List<Registro> lista_reg=r.LerFicheiro();
        List<Veiculo> lista_veiculo=v.LerFicheiro();
        List<Condutor> lista_cond=c.LerFicheiro();
        
        System.out.print("\t     Digite o numero de matricula:");
        String n_veiculo=ler.nextLine();
       
       
        
        
        
    System.out.println("\t\t\t\tNome Condutor      |Numero acesso ao parque\n");  
             for(Veiculo veiculo:lista_veiculo){
                 if(veiculo.getN_Matricula().equals(n_veiculo)){//verifica se existe veiculo com esse numero de matricula
                     for(Registro reg:lista_reg){
                         if(reg.getId_Veiculo()==veiculo.getId_veiculo()){//verifica se este veiculo possui registro
                             cont++;
                                for(Condutor cond:lista_cond){
                                  if(veiculo.getId_Condutor()==cond.getId_Condutor()){//Verifica se o condutor que vai ser  listado pertence realmente ao veiculo
    //System.out.println("\t\t\t\t"+veiculo.getN_Matricula()+"          "+cond.nome+"                     "+cont);
                                
                                condutor=cond.nome;
                                
                                }
                            }
                         }
                     }
                 }
                 
             }
    System.out.println("\t\t\t\t"+condutor+"               "+cont);      
         
         
        
    }
    
    
    public  void consulta_4() throws IOException{
        
    Registro r=new Registro();
    Veiculo v=new Veiculo();
    Condutor c=new Condutor();
    Utilizadores u=new Utilizadores();
    
    List<Registro> lista_reg=r.LerFicheiro();
    List<Veiculo> lista_veiculo=v.LerFicheiro();
    List<Condutor> lista_cond=c.LerFicheiro();
    List<Utilizadores> lista_util=u.LerFicheiro();
        
    System.out.println("Quem foi o segurança de serviço na data DD/MM/AAAA (a escolha), quais foram os veículos que entram e saíram nesse dia e a quem pertencem?\n");

    System.out.print("\t\t\t\t     Digite uma data(DD/MM/AAAA):");
    String data=ler.nextLine();
    System.out.println("\n");
        
        
    System.out.println("\t\t\t\t   Nome Seguranca         |N Matricula         |Nome Condutor");
    for(Registro reg:lista_reg){
       if(reg.getData_entrada().equals(data) && reg.getData_saida().equals(data)){//Verifica se existe registro de entrada e saida nesta data
           for(Utilizadores util:lista_util){
               if(reg.getId_util()==util.getID_Utilizador()){    //desses registro verifica se os utilizadores(seguranca) existentes estao associados a esse registro
                   for(Veiculo veiculo:lista_veiculo){
                       if(reg.getId_condutor()==veiculo.getId_Condutor()){//desses registro verifica os veiculos associados
                           for(Condutor cond:lista_cond){
                               if(cond.getId_Condutor()==veiculo.getId_Condutor()){//desses veiculos verifica os condutores associados
                                   
    System.out.println("\t\t\t\t   "+util.getNome()+"         "+veiculo.getN_Matricula()+"            "+cond.nome);                               
    
                                   
                               } 
                           }
                       }
                   }
               }
           }
       }
    }
    
        
}
    
    public static void consulta_5() throws IOException{
        
    Registro r=new Registro();
    Veiculo v=new Veiculo();
    Condutor c=new Condutor();
    Utilizadores u=new Utilizadores();
    
    List<Registro> lista_reg=r.LerFicheiro();
    List<Veiculo> lista_veiculo=v.LerFicheiro();
    List<Condutor> lista_cond=c.LerFicheiro();
    List<Utilizadores> lista_util=u.LerFicheiro();
    
    System.out.println("\t\t   Quais são os alunos atualmente no parque e quais são os caros que lhes estejam associados?\n");
    
    String data_actual=get_Data();
    
    System.out.println("\t\t\t   Nome Condutor       |Tipo Condutor        |N Matricula        |Data & Hora Saida");
    
    for(Registro reg:lista_reg){
        if(reg.getData_entrada().equals(data_actual) && reg.getData_saida().equals("null") && reg.getHora_saida().equals("null")){//verifica se o registro tem data de entrada actual e data de saida null 
            for(Veiculo veiculo:lista_veiculo){
                if(veiculo.getId_veiculo()==reg.getId_Veiculo()){//desse registro verifica os veiculos associados
                    for(Condutor cond:lista_cond){
                        if(cond.getId_Condutor()==veiculo.getId_Condutor() && cond.getTipo_condutor().equals("Aluno")){//desses veiculos verifica os condutores associados
    System.out.println("\t\t\t   "+cond.nome+"                 "+cond.getTipo_condutor()+"                 "+veiculo.getN_Matricula()+"            "+reg.getData_saida()+" "+reg.getHora_saida());                        
                        }
                    }
                }
            }
        }
        
    }
        
}
    public void consulta_6(){
        
    }
    
    public void consulta_7() throws IOException{
        
       System.out.println("\t\t\t     Quais são os registos de entrada e saída de veículos especiais no parque?\n");
        
        Registro r =new Registro();
        Veiculo v =new Veiculo();
        
        List<Registro> lista_reg=r.LerFicheiro();
        List<Veiculo> lista_veiculo=v.LerFicheiro();
        
        
        System.out.println("\t\t\t\t Data & Hora Entrada        |Data & Hora Saida        |Tipo Veiculo");
        for(Registro reg:lista_reg){
            if(!(reg.getData_entrada().equals("null") && reg.getHora_entrada().equals("null") && reg.getData_saida().equals("null") && reg.getHora_saida().equals("null"))){
                for(Veiculo veiculo:lista_veiculo){
                     if(reg.getId_Veiculo()==veiculo.getId_veiculo() && veiculo.getTipo().equals("Especial")){
        System.out.println("\t\t\t\t "+reg.getData_entrada()+" "+reg.getHora_entrada()+"         "+reg.getData_saida()+" "+reg.getHora_saida()+"        "+veiculo.getTipo());                 
                     }
                }
            }
        }
        
        
        
    }
   
}


