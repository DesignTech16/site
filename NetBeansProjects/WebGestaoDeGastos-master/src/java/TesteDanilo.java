
import Modelo.ModelMovimentacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import ws.wsGestaodeGastos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danilo
 */
public class TesteDanilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        // TODO code application logic here
        
        /*ws.wsGestaodeGastos ws = new ws.wsGestaodeGastos();
        List<Modelo.ModelMovimentacao> lista1 = new ArrayList<ModelMovimentacao>();
        lista1 = (List<ModelMovimentacao>) ws.ObterLista("movimentacao");
        List<ModelMovimentacao> lista = new ArrayList<>();

        for (ModelMovimentacao m2 : lista1) {
            ModelMovimentacao m = new ModelMovimentacao();
            m.setData(m2.getData());
            m.setDescricao(m2.getDescricao());
            m.setIdMovimentacao(m2.getIdMovimentacao());
            m.setTipo(m2.getValor() < 0 ? "Despesa" : "Receita");
            m.setValor(m2.getValor());
            m.setNomeCategoria(m2.getNomeCategoria());

            lista.add(m);
            System.out.println(m);
        }*/
        
        ModelMovimentacao m1 = new ModelMovimentacao();
     
        Date d = new Date(1, 1, 2001);
        m1.setData(d);
        
        m1.setDescricao("lalala");
        m1.setNomeCategoria("trigguer");
        m1.setIdCategoria(2);
        
        m1.setValor(m1.getValor());
        wsGestaodeGastos ws = new wsGestaodeGastos();
        ws.saveMovimentacao(m1);
        
               
     
    }
    
}
