package Entidade;


import Entidade.Categoria;
import Entidade.Movimentacao;
import Entidade.TipoEnum;
import java.util.ArrayList;
import java.util.List;
import ws.wsCategoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADILSON
 */
public class Controller {
    

    private List<Movimentacao> Listar(){
       List<Movimentacao> lista = new ArrayList<Movimentacao>();
       
       for(int i=0; i < 10; i++){
           Movimentacao m = new Movimentacao();
           m.setId(i);
           m.setTipo(i<5?TipoEnum.Receita:TipoEnum.Despesa);
           m.setValor(i + 100);
           m.setData("1"+i+"/01/201" + i);
           
           lista.add(m);
       }
       
       return lista;
    }
    
    public List<Categoria> ListarCategorias() throws Exception{
        List<Categoria> lista = new ArrayList<Categoria>();
        wsCategoria ws = new wsCategoria();
        
        for( String ws1 : ws.listarCategoria() ){
            Categoria c = new Categoria();            
            c.setNome(ws1);
            lista.add(c);
        }
        
        return lista;
    }
    
    public void ExcluirCategoria(int idCategoria) throws Exception{
        
        List<Categoria> lista = ListarCategorias();
        for(Categoria c: lista){
            if(c.getId() == idCategoria)
                lista.remove(c);
        }
        
    }
    
    public static ArrayList<Movimentacao> ListarMovimentos(){
        ArrayList<Movimentacao> lista = new ArrayList<Movimentacao>();
        
        for(int i=0; i < 10;i++){
            Movimentacao m = new Movimentacao();
            m.setId(i);
            m.categoria.setId(i);
            m.categoria.setNome("Categoria "+i);
            m.setTipo(i<5? TipoEnum.Despesa : TipoEnum.Receita);
            m.setData("1"+i+"/01/200"+i);
            m.setValor(12.25f*i);
            
            lista.add(m);
        }
        
        return lista;
    }
    
}
