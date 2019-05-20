
package Domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static parque_estacionamento_1.Parque_Estacionamento_1.id_s;
import static parque_estacionamento_1.Parque_Estacionamento_1.id_u;

public class Registro {
    
    private int Id_Reg;
    private String data_entrada;
    private String hora_entrada;
    private String data_saida;
    private String hora_saida;
    private int id_condutor;
    private int id_Veiculo;
    private int id_util;

    public static Scanner ler=new Scanner(System.in);
    
    public int getId_Reg() {
        return Id_Reg;
    }

    public void setId_Reg(int Id_Reg) {
        this.Id_Reg = Id_Reg;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }

    public int getId_condutor() {
        return id_condutor;
    }

    public void setId_condutor(int id_condutor) {
        this.id_condutor = id_condutor;
    }

    public int getId_Veiculo() {
        return id_Veiculo;
    }

    public void setId_Veiculo(int id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }

    public int getId_util() {
        return id_util;
    }

    public void setId_util(int id_util) {
        this.id_util = id_util;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    File file =new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Registro.txt");
    
    public Registro add_registro_entrada() throws IOException{
        Veiculo ve=new Veiculo();
        List<Veiculo> v=ve.LerFicheiro();
        Condutor cond=new Condutor();
        Registro reg=new Registro();
        List<Registro> lista_reg=LerFicheiro();
        List<Condutor> lista_cond=cond.LerFicheiro();
        List<Veiculo> lista_ve=ve.LerFicheiro();
        
        reg.Id_Reg=lista_reg.size()+1;
        
        reg.data_entrada=get_Data();
        
        reg.hora_entrada=get_Hora();
        
        reg.data_saida="null";
        
        reg.hora_saida="null";
        
        cond.Listar_Condutor();
        System.out.print("\n  Selecione o condutor:");
        reg.id_condutor=ler.nextInt();
        
        while(reg.id_condutor>lista_cond.size()){
        System.err.println("  Condutor nao encontrado!");
        System.out.print("    Selecione o condutor novamente:");
        reg.id_condutor=ler.nextInt();
        }
        
        
        
        System.out.println("\n");
        ve.listar_veiculo();
        System.out.print("  Selecione o veiculo:");
        reg.id_Veiculo=ler.nextInt();
        
        while(reg.id_Veiculo>lista_ve.size()){
        System.err.println("  Veiculo nao encontrado!");
        System.out.print("   Selecione o veiculo novamente:");
        reg.id_Veiculo=ler.nextInt();
        }
        
        
        reg.id_util=id_s;
        lista_reg.add(reg);
        SalvarFicheiro(lista_reg);
        System.out.println("  Registro efectuado com sucesso!");
        
        return reg;
    }
    
    public  void add_registro_saida() throws IOException{
        Registro reg=new Registro();
         List<Registro> lista_reg=LerFicheiro();
         
        System.out.println("      Id Registro        |Data & Hora Entrada        |Data & Hora Saida        |Id Condutor        |Id Veiculo        |Id Utilizador"); 
        for(int i=0;i<lista_reg.size();i++){
            if(lista_reg.get(i).data_saida.equals("null") && lista_reg.get(i).getHora_saida().equals("null")){
        System.out.println("      "+lista_reg.get(i).Id_Reg+"                   "+lista_reg.get(i).data_entrada+" "+lista_reg.get(i).hora_entrada+"         "+lista_reg.get(i).data_saida+" "+lista_reg.get(i).hora_saida+"                   "+lista_reg.get(i).id_condutor+"                   "+lista_reg.get(i).id_Veiculo+"                   "+lista_reg.get(i).id_util);
            }
        } 
        System.out.print("     \nDigite o numero de registro:");
        int num=ler.nextInt();
        
        Registro r=reg.test_reg(num);
        
        if(r!=null){
            for(int i=0;i<lista_reg.size();i++){
                if(lista_reg.get(i).getId_Reg()==num){
                reg.Id_Reg=lista_reg.get(i).Id_Reg;
                reg.data_entrada=lista_reg.get(i).data_entrada;
                reg.hora_entrada=lista_reg.get(i).hora_entrada;
                reg.data_saida=get_Data();
                reg.hora_saida=get_Hora();
                reg.id_condutor=lista_reg.get(i).id_condutor;
                reg.id_Veiculo=lista_reg.get(i).id_Veiculo;
                reg.id_Veiculo=lista_reg.get(i).id_Veiculo;
                reg.id_util=lista_reg.get(i).id_util;
                
                lista_reg.remove(i);
                
                
                lista_reg.add(i,reg);
                SalvarFicheiro(lista_reg);
                System.out.println("\nRegistrado com sucesso!\n");
                
                }
            }
            
        }else{
        System.err.println("     Este registro nao existe!");
        }
        
       
        
        
        
    }
    
    public String get_Data(){
        DateFormat data_formatada=new SimpleDateFormat("dd/MM/yyyy");
        Date data=new Date();
        return data_formatada.format(data);
    }
    
    
    public String get_Hora(){
        DateFormat data_formatada=new SimpleDateFormat("HH:MM:SS");
        Date data=new Date();
        return data_formatada.format(data);
    }
    
    
    
    public void SalvarFicheiro(List<Registro> list_reg) throws IOException{
        
        FileWriter fw =new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        for(Registro r:list_reg){
            
            bw.write(r.Id_Reg+";");
            bw.write(r.data_entrada+";");
            bw.write(r.hora_entrada+";");
            bw.write(r.data_saida+";");
            bw.write(r.hora_saida+";");
            bw.write(r.id_condutor+";");
            bw.write(r.id_Veiculo+";");
            bw.write(r.id_util+";\n");
           
        }
        
        bw.close();
    }
    
    public List<Registro> LerFicheiro() throws FileNotFoundException, IOException{
      
        List<Registro> list_reg=new ArrayList();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        
        
        String dados;
        
        while((dados=br.readLine())!=null){
            Registro reg=new Registro();
            String atributo[]=dados.split(";");
                    
            reg.Id_Reg=Integer.parseInt(atributo[0]);
            reg.data_entrada=atributo[1];
            reg.hora_entrada=atributo[2];
            reg.data_saida=atributo[3];
            reg.hora_saida=atributo[4];
            reg.id_condutor=Integer.parseInt(atributo[5]);
            reg.id_Veiculo=Integer.parseInt(atributo[6]);
            reg.id_util=Integer.parseInt(atributo[7]);
            
            
            list_reg.add(reg);
            
        }
        
        return list_reg;
    }
    
    
    public void listar_registro() throws IOException{
        List<Registro> list_reg=LerFicheiro();
        
        System.out.println("      Id Registro        |Data & Hora Entrada        |Data & Hora Saida        |Id Condutor        |Id Veiculo        |Id Utilizador");
        list_reg.forEach(u->{
        System.out.println("      "+u.Id_Reg+"                   "+u.data_entrada+" "+u.hora_entrada+"       "+u.data_saida+" "+u.hora_saida+"       "+u.id_condutor+"                   "+u.id_Veiculo+"                  "+u.id_util);
        });
        
    }
    
    public void listar_reg_util() throws IOException{
       
        Registro registro=new Registro();
        Veiculo veiculo=new Veiculo();
        
        List<Registro> list_reg=LerFicheiro();
        List<Veiculo> lista_veiculo=veiculo.LerFicheiro();
       
        /*   
        System.out.println("\t\t\t\tId Veiculo         |Data & Hora Entrada             |Data & Hora Saida\n");
        for(Registro r:list_reg){
            if(r.id_util==id_s ){
            System.out.println("\t\t\t\t"+r.id_Veiculo+"                   "+r.data_entrada+" "+r.hora_saida+"              "+r.data_entrada+" "+r.hora_saida+"");    
            }
        }
        System.out.println("\n\n");
        */
          
        System.out.println("N Matricula      |Marca             |Modelo             |Cor             |Tipo             |Data & Hora Entrada             |Data & Hora Saida");
        for(Registro r:list_reg){
          if(r.id_util==id_s ){
          for(Veiculo v:lista_veiculo){
              if(v.getId_veiculo()==r.id_Veiculo){
        System.out.println( v.getN_Matricula()+"          "+v.getMarca()+"             "+v.getModelo()+"               "+v.getCor()+"            "+v.getTipo()+"            "+r.data_entrada+" "+r.hora_saida+"              "+r.data_entrada+" "+r.hora_saida);     
              }
          }
        }
       
       
    }

    }
    
    public Registro test_reg(int id) throws IOException{
        List<Registro> lista_reg=LerFicheiro();
        for(Registro reg:lista_reg){
            if(reg.Id_Reg==id){
                return reg;
            }
            
        }
        
        return null;
    
    }
   
    
    
    
}
