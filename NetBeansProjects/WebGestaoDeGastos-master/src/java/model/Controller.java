package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Categoria;
import model.Movimentacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
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


    public List<Categoria> ListarCategorias() throws Exception {
        List<Categoria> lista = new ArrayList<Categoria>();
        wsCategoria ws = new wsCategoria();

        for (String ws1 : ws.listarCategoria()) {
            Categoria c = new Categoria();
            c.setNome(ws1);
            lista.add(c);
        }

        return lista;
    }

    public void ExcluirCategoria(int idCategoria) throws Exception {

        List<Categoria> lista = ListarCategorias();
        for (Categoria c : lista) {
            if (c.getId() == idCategoria) {
                lista.remove(c);
            }
        }

    }

    public List<Movimentacao> ListarMovimentos() throws ParseException {

        List<Movimentacao> lista = new ArrayList<Movimentacao>();
        wsCategoria ws = new wsCategoria();

        for (ws.Movimentacao m : ws.listarMovimentacao()) {
            Movimentacao m1 = new Movimentacao();
            m1.setIdMovimentacao(m.getIdMovimentacao());

            m1.setNomeCategoria(m.getNomeCategoria());
            m1.setDescricao(m.getDescricao());
            m1.setTipo(m.getTipo());
            m1.setData(toDate(m.getData()));
            String data = ""+m.getData().getDay()+"/"+m.getData().getMonth()+"/"+m.getData().getYear();
            m1.setDataFormat(data);
            m.getValor();
            m1.setValor(m.getValor());
            

            lista.add(m1);
        }

        return lista;
    }

    public static Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

}
