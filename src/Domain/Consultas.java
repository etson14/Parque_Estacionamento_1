
package Domain;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




public class Consultas {
    
    public String get_Data(){
        DateFormat dataF=new SimpleDateFormat("dd/mm/yyyy");
        Date date =new Date();
        return dataF.format(date);
    }
    
 
    public void consulta_1() throws IOException{
    System.out.println("\t\t\tQuais foram as viaturas que entraram e saíram a data de hoje no parque?");    
     
     Veiculo veiculo=new Veiculo();
     Registro reg=new Registro();
     List<Registro> lista_reg=reg.LerFicheiro();
     List<Veiculo> lista_veiculo=veiculo.LerFicheiro();
     String data_actual=get_Data();
    
    System.out.println("\t\tId_Veiculo         |N Matricula         |Marca         |Modelo         |Cor         |Tipo         ");
    for(Registro r:lista_reg){
        if(data_actual.equals(r.getData_entrada())){
            for(Veiculo v:lista_veiculo){
                if(v.getId_veiculo()==r.getId_Veiculo()){
    System.out.println("\t\t"+v.getId_veiculo()+"                   "+v.getN_Matricula()+"             "+v.getMarca()+"           "+v.getModelo()+"           "+v.getCor()+"         "+v.getTipo());                
                }
            }
        }
    }
     
     

}
 
}


