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
public class wsGestaodeGastos {

    public void saveMovimentacao(Modelo.ModelMovimentacao m)
            throws DatatypeConfigurationException {
        ModelMovimentacao m1 = new ModelMovimentacao();

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(m.getData());
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        m1.setData(date2);
        m1.setDescricao(m.getDescricao());
        m1.setNomeCategoria(m.getNomeCategoria());
        m1.setIdCategoria(m.getIdCategoria());
        m1.setValor(m.getValor());

        savemovimentacao(m1);
    }

    public List<ModelMovimentacao> obterMovimentacao() {
        return obterlistamovimentacao();
    }

    public void atualizaMovimentacao(Modelo.ModelMovimentacao m)
            throws DatatypeConfigurationException {
        ModelMovimentacao m1 = new ModelMovimentacao();

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(m.getData());
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        m1.setData(date2);
        m1.setDescricao(m.getDescricao());
        m1.setNomeCategoria(m.getNomeCategoria());
        m1.setIdCategoria(m.getIdCategoria());
        m1.setValor(m.getValor());

        atualizarmovimentacao(m1);

    }
    
    public float obterSaldo(){
        return obtersaldo();
    }

    public List<ModelCategoria> obterCategoria() {
        return obterlistacategoria();
    }

    public void deleteCategoria(int id) {
        deletecategoria(id);
    }

    public void atualizaCategoria(Modelo.ModelCategoria c) {
        ModelCategoria ca = new ModelCategoria();
        ca.setIdCategoria(c.getIdCategoria());
        ca.setNomeCategoria(c.getNomeCategoria());
        atualizarcategoria(ca);
    }

    public void saveCategoria(Modelo.ModelCategoria c) {
        ModelCategoria ca = new ModelCategoria();        
        ca.setNomeCategoria(c.getNomeCategoria());
        savecategoria(ca);
    }

    private static void savecategoria(ws.ModelCategoria objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.savecategoria(objeto);
    }

  

    private static void atualizarcategoria(ws.ModelCategoria objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.atualizarcategoria(objeto);
    }

    private static void atualizarfixa(ws.ModelFixa objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.atualizarfixa(objeto);
    }

    private static void atualizarmovimentacao(ws.ModelMovimentacao objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.atualizarmovimentacao(objeto);
    }

    private static void deletecategoria(int id) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.deletecategoria(id);
    }

    private static void deletefixa(int id) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.deletefixa(id);
    }

    private static void deletemovimentacao(int id) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.deletemovimentacao(id);
    }

    private static java.util.List<ws.ModelCategoria> obterlistacategoria() {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        return port.obterlistacategoria();
    }

    private static java.util.List<ws.ModelFixa> obterlistafixa() {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        return port.obterlistafixa();
    }

    private static java.util.List<ws.ModelMovimentacao> obterlistamovimentacao() {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        return port.obterlistamovimentacao();
    }

    private static void savemovimentacao(ModelMovimentacao objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.savemovimentacao(objeto);
    }

    private static void savefixa(ws.ModelFixa objeto) {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        port.savefixa(objeto);
    }

    private static float obtersaldo() {
        ws.GestaodeGastos service = new ws.GestaodeGastos();
        ws.WsGestaodeGastos port = service.getWsGestaodeGastosPort();
        return port.obtersaldo();
    }

}
