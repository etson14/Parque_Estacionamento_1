
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



public class Especial {
    private int id_especial;
    private String tipo;
    private String Numero_Matricula;
    private String data_entrada;
    private String data_saida;
    private int id_seguranca;
  
    
    public String getNumero_Matricula(){
        return Numero_Matricula;
    }
    
    public void setNumero_Matricula(String Numero_Matricula){
        this.Numero_Matricula=Numero_Matricula;
    }
    
    
    
    public int getId_Especial(){
        return id_especial;
    }
    
    public void setId_especial(int id_especial){
        this.id_especial=id_especial;
               
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public int getId_seguranca() {
        return id_seguranca;
    }

    public void setId_seguranca(int id_seguranca) {
        this.id_seguranca = id_seguranca;
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        Especial.file = file;
    }
    
    
    public static Scanner ler=new Scanner(System.in);
    public static File file=new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Especial.txt");
    
    public Especial add_especial() throws IOException{
        Especial e=new Especial();
        List<Especial> lista_especial=LerFicheiro();
        
        e.id_especial=lista_especial.size()+1;
        
        System.out.print("\t\tNumero Matricula:");
        e.Numero_Matricula=ler.nextLine();
        
        System.out.println("\t\tVeiculos especiais");
        System.out.println("\t\t1->Bombeiros");
        System.out.println("\t\t2->Policia");
        System.out.println("\t\t3->Ambulancia");
        System.out.println("\t\t4->Veiculo do Estado");
        System.out.print("\t\tEscolha o tipo de veiculo:");
        String opc=ler.nextLine();
         switch(opc){
             case "1":e.tipo="Bombeiros";
                break;
             case "2":e.tipo="Policia";
                break;
             case "3":e.tipo="Ambulancia";
                break;
             case "4":e.tipo="Veiculo do Estado";
                break;
                
             default:System.err.println("\t\tOpcao invalido!");
                break;
         }
        
        e.data_entrada=get_data_hora();
        
        e.id_seguranca=id_s;
        
        
        lista_especial.add(e);
        SalvarFicheiro(lista_especial);
        System.out.println("\n\t\tRegistrado com sucesso!");
        
        
        return e;
    }
    
    public void listar_especial() throws IOException{
        List<Especial> lista_especial=LerFicheiro();
        
        System.out.println("\t\t\tId    Tipo          |Data Entrada          |Id Seguranca");
        lista_especial.forEach(u->{
        System.out.println("\t\t\t"+u.id_especial+"    "+u.tipo+"          "+u.data_entrada+"          "+u.id_seguranca);
        
        });
        
    }
    
    public String get_data_hora(){
        DateFormat data_f=new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
        Date data=new Date();
        return data_f.format(data);
    }
    
    public void SalvarFicheiro(List<Especial> lista_especial) throws IOException{
       FileWriter fw=new FileWriter(file);
       BufferedWriter bw=new BufferedWriter(fw);
        
       for(Especial e: lista_especial){
           bw.write(e.id_especial+";");
           bw.write(e.Numero_Matricula+";");
           bw.write(e.tipo+";");
           bw.write(e.data_entrada+";");
           bw.write(e.id_seguranca+";\n");
       }
       
       bw.close();
    }
    
    
    public List<Especial> LerFicheiro() throws FileNotFoundException, IOException{
        List<Especial> lista_especial=new ArrayList();
        FileReader fr=new FileReader(file);
        BufferedReader bw=new BufferedReader(fr);
        
        String dados;
        
        while((dados=bw.readLine())!=null){
            Especial e =new Especial();
            String atributos[]=dados.split(";");
            
            e.id_especial=Integer.parseInt(atributos[0]);
            e.Numero_Matricula=atributos[1];
            e.tipo=atributos[2];
            e.data_entrada=atributos[3];
            e.id_seguranca=Integer.parseInt(atributos[4]);
            
            lista_especial.add(e);
        }
        
        return lista_especial;
    }
} 
