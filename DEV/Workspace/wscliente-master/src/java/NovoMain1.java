
import Persistencia.DAOCategoria;
import model.ModelCategoria;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danilo
 */
public class NovoMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ModelCategoria c = new ModelCategoria();
        DAOCategoria dc = new DAOCategoria();
        
        c.setNomeCategoria("testenovocategoria");
        dc.salvarCategoriaDAO(c);
    }
    
}
