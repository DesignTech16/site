/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Interface.ICategoria;
import Persistencia.DAOCategoria;
import java.util.List;
import model.ModelCategoria;

/**
 *
 * @author aluno
 */
public class CategoriaHelper{

    public String ListaCategoria() {       
        DAOCategoria c = new DAOCategoria();        
        List<ModelCategoria> listaCategoria = c.getListaCategoriaDAO();
        
        StringBuilder str = new StringBuilder();
       
        for(ModelCategoria categoria : listaCategoria)
        {           
            str.append("<tr>");
                str.append("<td>");
                    str.append(categoria.getIdCategoria());
                str.append("</td>");
                str.append("<td>");
                    str.append(categoria.getNomeCategoria());
                str.append("</td>");
            str.append("</tr>");
        }
        return str.toString();
    }    
}
