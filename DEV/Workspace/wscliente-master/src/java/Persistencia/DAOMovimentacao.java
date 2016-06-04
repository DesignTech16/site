package Persistencia;;

import model.ModelMovimentacao;
import java.util.ArrayList;
/**
*
* @author Danilo
*/
public class DAOMovimentacao extends ConexaoMySql {

    /**
    * grava Movimentacao
    * @param pModelMovimentacao
    * return int
    */
    public int salvarMovimentacaoDAO(ModelMovimentacao pModelMovimentacao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO Movimentacao ("
                    + "pk_id_movimentacao,"
                    + "valor,"
                    + "data,"
                    + "descricao,"
                    + "fk_id_categoria"
                + ") VALUES ("
                    + "'" + pModelMovimentacao.getIdMovimentacao() + "',"
                    + "'" + pModelMovimentacao.getValor() + "',"
                    + "'" + pModelMovimentacao.getData() + "',"
                    + "'" + pModelMovimentacao.getDescricao() + "',"
                    + "'" + pModelMovimentacao.getId_categoria() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Movimentacao
    * @param pIdMovimentacao
    * return ModelMovimentacao
    */
    public ModelMovimentacao getMovimentacaoDAO(int pIdMovimentacao){
        ModelMovimentacao modelMovimentacao = new ModelMovimentacao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_movimentacao,"
                    + "valor,"
                    + "data,"
                    + "descricao,"
                    + "fk_id_categoria"
                 + " FROM"
                     + " Movimentacao"
                 + " WHERE"
                     + " pk_id_movimentacao = '" + pIdMovimentacao + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMovimentacao.setIdMovimentacao(this.getResultSet().getInt(1));
                modelMovimentacao.setValor(this.getResultSet().getFloat(2));
                modelMovimentacao.setData(this.getResultSet().getDate(3));
                modelMovimentacao.setDescricao(this.getResultSet().getString(4));
                modelMovimentacao.setId_categoria(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelMovimentacao;
    }

    /**
    * recupera uma lista de Movimentacao
        * return ArrayList
    */
    public ArrayList<ModelMovimentacao> getListaMovimentacaoDAO(){
        ArrayList<ModelMovimentacao> listamodelMovimentacao = new ArrayList();
        ModelMovimentacao modelMovimentacao = new ModelMovimentacao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_movimentacao,"
                    + "valor,"
                    + "data,"
                    + "descricao,"
                    + "fk_id_categoria"
                 + " FROM"
                     + " Movimentacao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelMovimentacao = new ModelMovimentacao();
                modelMovimentacao.setIdMovimentacao(this.getResultSet().getInt(1));
                modelMovimentacao.setValor(this.getResultSet().getFloat(2));
                modelMovimentacao.setData(this.getResultSet().getDate(3));
                modelMovimentacao.setDescricao(this.getResultSet().getString(4));
                modelMovimentacao.setId_categoria(this.getResultSet().getInt(5));
                listamodelMovimentacao.add(modelMovimentacao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMovimentacao;
    }

    /**
    * atualiza Movimentacao
    * @param pModelMovimentacao
    * return boolean
    */
    public boolean atualizarMovimentacaoDAO(ModelMovimentacao pModelMovimentacao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Movimentacao SET "
                    + "pk_id_movimentacao = '" + pModelMovimentacao.getIdMovimentacao() + "',"
                    + "valor = '" + pModelMovimentacao.getValor() + "',"
                    + "data = '" + pModelMovimentacao.getData() + "',"
                    + "descricao = '" + pModelMovimentacao.getDescricao() + "',"
                    + "fk_id_categoria = '" + pModelMovimentacao.getId_categoria() + "'"
                + " WHERE "
                    + "pk_id_movimentacao = '" + pModelMovimentacao.getIdMovimentacao() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Movimentacao
    * @param pIdMovimentacao
    * return boolean
    */
    public boolean excluirMovimentacaoDAO(int pIdMovimentacao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Movimentacao "
                + " WHERE "
                    + "pk_id_movimentacao = '" + pIdMovimentacao + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}