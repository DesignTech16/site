/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;


import Persistencia.DAOCategoria;
import Persistencia.DAOMovimentacao;
import Persistencia.DAOSaldo;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Categoria;
import model.Movimentacao;

/**
 *
 * @author aluno
 */
@WebService(serviceName = "wsCategoria")
public class wsCategoria {

   /**
     * This is a sample web service operation
     */ 
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "listacategoria")
    public ArrayList<String> listaCategoria()
    {
        DAOCategoria dc = new DAOCategoria();
        return dc.getListaCategoriaDAO();
    }
    
    @WebMethod(operationName = "salvacategoria")
    public boolean salvaCategoria(@WebParam(name = "nomecategoria") String NomeCategoria){
        boolean i = false;
        DAOCategoria dc = new  DAOCategoria();
        Categoria c = new Categoria();
        c.setNomeCategoria(NomeCategoria);
       dc.salvarCategoriaDAO(c);
        
        return i;
    }
    
    @WebMethod(operationName = "excluicategoria")
    public boolean excluiCategoria(@WebParam(name = "nomecategoria") String NomeCategoria){
        boolean i = false;
        DAOCategoria dc = new  DAOCategoria();
        Categoria c = new Categoria();
        c.setNomeCategoria(NomeCategoria);
        dc.excluirCategoriaDAO(c.getNomeCategoria());
        
        return i;
    }
    
    public float getSaldo(){
        
        DAOSaldo ds = new DAOSaldo();
     return ds.getSaldoDAO();   
    }
    
    public List<Movimentacao> listaMovimentacao(){
        DAOMovimentacao dm = new DAOMovimentacao();
        return dm.getListaMovimentacaoDAO();
    } 
    
    public boolean salvaMovimentacao(Movimentacao m){
        
        DAOMovimentacao dm = new DAOMovimentacao();
        if(dm.salvarMovimentacaoDAO(m)!= 0){
            return true;
        }else{
            return false;
        }
    }
}
