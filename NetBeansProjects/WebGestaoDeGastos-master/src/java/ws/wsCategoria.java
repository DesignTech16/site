/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import model.Categoria;
import java.util.ArrayList;
import java.util.Date;
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

    public List<String> listarCategoria() throws Exception {

        return listacategoria();

    }

    public float obterSaldo() {

        return getSaldo();
    }

    public List<Movimentacao> listarMovimentacao() {

        return listaMovimentacao();
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

}
