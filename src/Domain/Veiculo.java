
package Domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Veiculo {
    
    private int Id_veiculo;
    private String N_Matricula;
    private String marca;
    private String modelo;
    private String cor;
    private String tipo;
    private int Id_Seguranca;
    private int Id_Condutor;
    
    

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
        return Id_Seguranca;
    }

    public void setId_Seguranca(int Id_Seguranca) {
        this.Id_Seguranca = Id_Seguranca;
    }

    public int getId_Condutor() {
        return Id_Condutor;
    }

    public void setId_Condutor(int Id_Condutor) {
        this.Id_Condutor = Id_Condutor;
    }
    
    File file = new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Veiculo.txt");
    
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
            v.Id_Condutor=Integer.parseInt(atributo[6]);
                    
            lista_veiculo.add(v);
        }
       
        return lista_veiculo;
    }
    
    public void listar_veiculo() throws IOException{
        List<Veiculo> lista_veiculo=LerFicheiro();
        
        System.out.println("\t\tId_Veiculo  |N Matricula        |Marca         |Modelo         |Cor         |Tipo         |Id Condutor");
        lista_veiculo.forEach(v->{
        System.out.println("\t\t"+v.Id_veiculo+"    "+v.N_Matricula+"             "+v.marca+"           "+v.modelo+"           "+v.cor+"         "+v.tipo+"         "+v.Id_Condutor);
        });
    }
    
    
    
    
    
            
    
    

    
    
    
    
}
