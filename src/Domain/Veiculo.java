
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
import static parque_estacionamento_1.Parque_Estacionamento_1.id_s;
import static parque_estacionamento_1.Parque_Estacionamento_1.id_u;


public class Veiculo {
    
    private int Id_veiculo;
    private String N_Matricula;
    private String marca;
    private String modelo;
    private String cor;
    private String tipo;
    private int Id_Utilizador;
    private int Id_Condutor;
    
    public static Scanner ler=new Scanner(System.in);

    public int getId_veiculo() {
        return Id_veiculo;
    }

    public void setId_veiculo(int Id_v) {
        this.Id_veiculo = Id_v;
    }

    public String getN_Matricula() {
        return N_Matricula;
    }

    public void setN_Matricula(String N_Matricula) {
        this.N_Matricula = N_Matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_Seguranca() {
        return Id_Utilizador;
    }

    public void setId_Seguranca(int Id_Seguranca) {
        this.Id_Utilizador = Id_Seguranca;
    }

    public int getId_Condutor() {
        return Id_Condutor;
    }

    public void setId_Condutor(int Id_Condutor) {
        this.Id_Condutor = Id_Condutor;
    }
    
    public static File file = new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Veiculo.txt");
    
    public Veiculo add_veiculo() throws IOException{
        Condutor cond=new Condutor();
        Veiculo v=new Veiculo();
        List<Veiculo> lista_veiculo=LerFicheiro();
        List<Condutor> lista_cond=cond.LerFicheiro();
        
        v.Id_veiculo=lista_veiculo.size()+1;
        
        System.out.print("\t\tNumero Matricula:");
        v.N_Matricula=ler.nextLine();
        
        System.out.print("\t\tMarca:");
        v.marca=ler.nextLine();
        
        System.out.print("\t\tModelo:");
        v.modelo=ler.nextLine();
        
        System.out.print("\t\tCor:");
        v.cor=ler.nextLine();
        
       System.out.println("\t\tEscolha o tipo de veiculo");
       System.out.println("\t\t1 -> Autorizado");
       System.out.println("\t\t2 -> Especial");
       System.out.print("\t\tEscolha uma opção: ");
       int op=ler.nextInt();
       switch(op){
           case 1:v.tipo="Autorizado" ;
                   break;
           case 2:v.tipo="Especial";
                    break;
           default:System.out.println("Opcao invalido");
       }
       
       v.Id_Utilizador=id_u;
       
       cond.Listar_Condutor();
       
       System.out.print("\n\t\tSelecione o condutor:");
       v.Id_Condutor=ler.nextInt();
       
       while(v.Id_Condutor>lista_cond.size()){
        System.err.println("  Condutor nao encontrado!");
        System.out.print("   Selecione o condutor novamente:");
        v.Id_Condutor=ler.nextInt();
       }
       
       lista_veiculo.add(v);
       SalvarFicheiro(lista_veiculo);
       System.out.println("\n\t\tVeiculo registrado com sucesso!");
       return v;
       
       
      
    }
    
    public void SalvarFicheiro(List<Veiculo> lista_veiculo) throws IOException{
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        for(Veiculo v:lista_veiculo){
            bw.write(v.Id_veiculo+";");
            bw.write(v.N_Matricula+";");
            bw.write(v.marca+";");
            bw.write(v.modelo+";");
            bw.write(v.cor+";");
            bw.write(v.tipo+";");
            bw.write(v.Id_Utilizador+";");
            bw.write(v.Id_Condutor+";\n");
            
        }
        bw.close();
    }
    
    
    public List<Veiculo> LerFicheiro() throws FileNotFoundException, IOException{
        List <Veiculo> lista_veiculo=new ArrayList();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        
        String dados;
        
        while((dados=br.readLine())!=null){
            Veiculo v = new Veiculo();
            String atributo[]=dados.split(";");
            
            
            v.Id_veiculo=Integer.parseInt(atributo[0]);
            v.N_Matricula=atributo[1];
            v.marca=atributo[2];
            v.modelo=atributo[3];
            v.cor=atributo[4];
            v.tipo=atributo[5];
            v.Id_Utilizador=Integer.parseInt(atributo[6]);
            v.Id_Condutor=Integer.parseInt(atributo[7]);
                    
            lista_veiculo.add(v);
        }
       
        return lista_veiculo;
    }
    
    public void actualizar_veiculo() throws IOException{
        Condutor cond=new Condutor();
        Veiculo v=new Veiculo();
        List<Veiculo> lista_veiculo=LerFicheiro();
        List<Condutor> lista_cond=cond.LerFicheiro();
        
        listar_veiculo();
        System.out.print("\n\t\tDigite o codigo do veiculo que desejas actualizar:");
        String cod=ler.nextLine();
        
        Veiculo veiculo=test_veiculo(Integer.parseInt(cod));
        if(veiculo!=null){
        
        for(int i=0;i<lista_veiculo.size();i++){
            if(lista_veiculo.get(i).getId_veiculo()==Integer.parseInt(cod)){
                
        v.Id_veiculo=lista_veiculo.get(i).Id_veiculo;
        
        
        v.N_Matricula=lista_veiculo.get(i).N_Matricula;
        
       
        v.marca=lista_veiculo.get(i).marca;
        
       
        v.modelo=lista_veiculo.get(i).modelo;
        
        System.out.print("\t\tCor:");
        v.cor=ler.nextLine();
        
        v.tipo=lista_veiculo.get(i).tipo;
       
        v.Id_Utilizador=id_u;
       
        v.Id_Condutor=lista_veiculo.get(i).Id_Condutor;
       
       lista_veiculo.remove(i);
       
       lista_veiculo.add(i,v);
       SalvarFicheiro(lista_veiculo);
       System.out.println("\n\t\tVeiculo registrado com sucesso!");
               
            }
        }
        }else{
            System.err.println("\t\tVeiculo nao encontrado!");
        }
        
    }
    
    public void eliminar_veiculo() throws IOException{
        List<Veiculo> lista_veiculo=LerFicheiro();
        
        listar_veiculo();
        System.out.print("\n\t\tDigite o codigo do veiculo que desejas eliminar:");
        int cod=ler.nextInt();
        Veiculo veiculo=test_veiculo(cod);
        if(veiculo!=null){
        
        for(int i=0;i<lista_veiculo.size();i++){
            if(lista_veiculo.get(i).getId_veiculo()==cod){
                lista_veiculo.remove(i);
                SalvarFicheiro(lista_veiculo);
                System.out.println("\t\tVeiculo eliminado com sucesso!");
            }
        }
        }else{
            System.err.println("\t\tVeiculo nao encontrado!");
        }
    }
    
    public void listar_veiculo() throws IOException{
        List<Veiculo> lista_veiculo=LerFicheiro();
        
        System.out.println("\t\tId_Veiculo  |N Matricula        |Marca         |Modelo         |Cor         |Tipo         |Id Condutor");
        lista_veiculo.forEach(v->{
        System.out.println("\t\t"+v.Id_veiculo+"           "+v.N_Matricula+"             "+v.marca+"           "+v.modelo+"           "+v.cor+"         "+v.tipo+"         "+v.Id_Condutor);
        });
    }
    
    public Veiculo test_veiculo(int i) throws IOException{
        List<Veiculo> lista_veiculo=LerFicheiro();
        
        for(Veiculo v:lista_veiculo){
            if(v.Id_veiculo==i){
                return v;
            }
        }
        return null;
    }
}
