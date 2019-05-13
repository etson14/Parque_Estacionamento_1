
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


public class Cartao {
    
    private int ID_Cartao;
    private String C_Cartao;
    private String E_Cartao;
    

    public int getID_Cartao() {
        return ID_Cartao;
    }

    public void setID_Cartao(int ID_Cartao) {
        this.ID_Cartao = ID_Cartao;
    }

    public String getC_Cartao() {
        return C_Cartao;
    }

    public void setC_Cartao(String C_Cartao) {
        this.C_Cartao = C_Cartao;
    }

    public String getE_Cartao() {
        return E_Cartao;
    }

    public void setE_Cartao(String E_Cartao) {
        this.E_Cartao = E_Cartao;
    }

   
    File file=new File("C:\\Users\\Vares\\Documents\\NetBeansProjects\\Parque_Estacionamento_1\\src\\Files\\Cartao.txt");
    
    public static int id_Cart;
    
    public static String get_Data(){
        DateFormat data_f=new SimpleDateFormat("yyyyMMdd");
        Date data=new Date();
        return data_f.format(data);
    }
    
    public Cartao add_Cart() throws IOException{
        
        if(!(file.exists())){
            file.createNewFile();
        }
        
        String data_actual=get_Data();
        Cartao cart=new Cartao();
        List<Cartao> list_cart =LerFicheiroCart();
        
       cart.ID_Cartao=list_cart.size()+1;
       id_Cart=list_cart.size()+1;
       cart.C_Cartao=Integer.toString(list_cart.size()+Integer.parseInt(data_actual));
       cart.E_Cartao="Ativo";
      
       
       
       list_cart.add(cart);
       SalvarFicheiroCart(list_cart);
        
        return cart;
    }
    
    
    
    public  void SalvarFicheiroCart (List<Cartao> list_cart) throws IOException{
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        for(Cartao ca: list_cart){
            bw.write(ca.ID_Cartao+";");
            bw.write(ca.C_Cartao+";");
            bw.write(ca.E_Cartao+";\n");
           
        }
            bw.close();
    }
    
    public List<Cartao> LerFicheiroCart() throws FileNotFoundException, IOException{
        List<Cartao> list_cart=new ArrayList<>();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        
        String dados;
        
        while((dados=br.readLine())!=null){
            Cartao cart=new Cartao();
            String [] atributo=dados.split(";");
            
            cart.ID_Cartao=Integer.parseInt(atributo[0]);
            cart.C_Cartao=atributo[1];
            cart.E_Cartao=atributo[2];
            
           
            
            list_cart.add(cart);
            
        }
        
        
        return list_cart;
    }

    
    
            
    
}
