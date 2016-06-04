/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Entidade.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danilo
 */
public class wsCategoria {

    public List<String> listarCategoria() throws Exception{
        
        return listacategoria();
    }
    
    
    private static java.util.List<java.lang.String> listacategoria() {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.listacategoria();
    }

    private static boolean excluicategoria(java.lang.String nomecategoria) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.excluicategoria(nomecategoria);
    }

    private static boolean salvacategoria(java.lang.String nomecategoria) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.salvacategoria(nomecategoria);
    }
    

   
}
