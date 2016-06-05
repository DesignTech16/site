
import Persistencia.DAOCategoria;
import Persistencia.DAOMovimentacao;
import Persistencia.DAOSaldo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Categoria;
import model.Movimentacao;



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
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        /*Categoria c = new Categoria();
        DAOCategoria dc = new DAOCategoria();
        
        c.setNomeCategoria("testenovocategoria222");
        dc.salvarCategoriaDAO(c);
      dc.excluirCategoriaDAO("testenovocategoria666");
        Movimentacao m = new Movimentacao();
        
        String dataStr = "22/10/2011";
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date(format.parse(dataStr).getTime());
        m.setData(data);
        m.setDescricao("testeNovo");
        m.setNome_categoria("Alimentação");
        m.setValor(-300);
        
        DAOMovimentacao dc = new DAOMovimentacao();
        dc.salvarMovimentacaoDAO(m);
        for (Movimentacao m1 : dc.getListaMovimentacaoDAO()) {
            System.out.println(m1.getDescricao());}*/
        
        DAOSaldo ds = new DAOSaldo();
        ds.atualizarSaldoDAO();
        
        
        
    }
    
}
