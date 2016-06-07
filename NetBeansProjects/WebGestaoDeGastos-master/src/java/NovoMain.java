
import java.text.ParseException;
import model.Controller;
import model.Movimentacao;
import ws.wsCategoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danilo
 */
public class NovoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
             
        String nomeCategoria = "Danilo";
        String novacategoria = "DaniloGoulart"; 
        
        wsCategoria ws = new wsCategoria();
        if(ws.atualizarCategoria(nomeCategoria, novacategoria)){
            System.out.println("Excluido");
        }else{
            System.out.println("Erro");
        }
    
    }
    
}
