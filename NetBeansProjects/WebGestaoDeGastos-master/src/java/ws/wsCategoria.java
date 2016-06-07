/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;


import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author danilo
 */
public class wsCategoria {
    
    public boolean excluirCategoria(String nomecategoria){
        
        return excluicategoria(nomecategoria);
    }

    public List<String> listarCategoria() throws Exception {

        return listacategoria();

    }
    
    public boolean salvarCategoria(String nome){
        return salvacategoria(nome);
    }

    public float obterSaldo() {

        return getSaldo();
    }

    public List<Movimentacao> listarMovimentacao() {

        return listaMovimentacao();
    }
    
    public boolean atualizarCategoria(String categoria, String categoriaEditada){
        
        return atualizaCategoria(categoria, categoriaEditada);
    }

    public boolean salvarMovimentacao(model.Movimentacao m) throws DatatypeConfigurationException {
        Movimentacao m1 = new Movimentacao();

     
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(m.getData());
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        m1.setData(date2);
        
        m1.setDescricao(m.getDescricao());
        m1.setNomeCategoria(m.getNomeCategoria());
        m1.setTipo(m.getTipo());
        m1.setValor(m.getValor());
        
        return salvaMovimentacao(m1);
    }

    private static java.util.List<java.lang.String> listacategoria() {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.listacategoria();
    }

    

    private static boolean salvacategoria(java.lang.String nomecategoria) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.salvacategoria(nomecategoria);
    }

    private static float getSaldo() {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.getSaldo();
    }

    private static java.util.List<ws.Movimentacao> listaMovimentacao() {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.listaMovimentacao();
    }

    private static boolean salvaMovimentacao(ws.Movimentacao arg0) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.salvaMovimentacao(arg0);
    }

    private static boolean excluicategoria(java.lang.String nomecategoria) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.excluicategoria(nomecategoria);
    }

    private static boolean atualizaCategoria(java.lang.String arg0, java.lang.String arg1) {
        ws.WsCategoria_Service service = new ws.WsCategoria_Service();
        ws.WsCategoria port = service.getWsCategoriaPort();
        return port.atualizaCategoria(arg0, arg1);
    }

}
