
package Domain;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




public class Consulta {
    
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
        if(data_actual.equals(r.getData_entrada())&& data_actual.equals(r.getData_saida())){
            for(Veiculo v:lista_veiculo){
                if(v.getId_veiculo()==r.getId_Veiculo()){
    System.out.println("\t\t\t      "+v.getN_Matricula()+"             "+v.getMarca()+"         "+v.getModelo()+"           "+v.getCor()+"         "+v.getTipo());                
                }
            }
        }
    }
}
    public void consulta_2() throws IOException{
        Registro r=new Registro();
        Veiculo v=new Veiculo();
        Condutor c=new Condutor();
        
        List<Registro> lista_reg=r.LerFicheiro();
        List<Veiculo> lista_veiculo=v.LerFicheiro();
        List<Condutor> lista_cond=c.LerFicheiro();
        
       String data_actual=get_Data();
       
      for(Registro reg:lista_reg){
          if(reg.getData_entrada().equals(data_actual) && reg.getData_saida().equals("null")){
              
          }
      }
        
        
    }
 
}


