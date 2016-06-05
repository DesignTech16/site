package Persistencia;;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Movimentacao;
import java.util.ArrayList;
import java.util.List;
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
    public int salvarMovimentacaoDAO(Movimentacao pModelMovimentacao){
        try {
            this.conectar();
       Date d = new Date(pModelMovimentacao.getData().getTime());
            return this.insertSQL(
                "INSERT INTO Movimentacao ("
                    + "id_mov,"
                    + "valor,"
                    + "data,"
                    + "descricao,"
                    + "id_categoria"
                + ") VALUES ("
                    + "'" + pModelMovimentacao.getIdMovimentacao() + "',"
                    + "'" + pModelMovimentacao.getValor() + "',"
                    + "'" + d + "',"
                    + "'" + pModelMovimentacao.getDescricao() + "',"
                    + "'" + buscarIdCategoria(pModelMovimentacao.getNome_categoria()) + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }
    
    public int buscarIdCategoria(String nomeCategoria){
        int id = 0;
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_categoria"
                
                 + " FROM"
                     + " Categoria"
                 + " WHERE"
                     + " nome_categoria = '" + nomeCategoria + "'"
                + ";"
            );

            while(this.getResultSet().next()){
               id = this.getResultSet().getInt("id_categoria");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
        
    }

   
   

    /**
    * recupera uma lista de Movimentacao
        * return ArrayList
    */
    public List<Movimentacao> getListaMovimentacaoDAO(){
        List<Movimentacao> listamodelMovimentacao = new ArrayList();
        
        try {
            this.conectar();
            String sql = (
                "SELECT "
                    + "id_mov,"
                    + "valor,"
                    + "data,"
                    + "descricao,"
                    + "id_categoria"
                 + " FROM"
                     + " Movimentacao"
                + ";"
            );
            
            PreparedStatement stmt = getCon().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Movimentacao modelMovimentacao = new Movimentacao();
                modelMovimentacao.setIdMovimentacao(rs.getInt("id_mov"));
                modelMovimentacao.setValor(rs.getFloat("valor"));
                modelMovimentacao.setData(rs.getDate("data"));
                
                modelMovimentacao.setDescricao(rs.getString("descricao"));
                modelMovimentacao.setNome_categoria(buscarNomeCategoria(rs.getInt("id_categoria")));
                listamodelMovimentacao.add(modelMovimentacao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelMovimentacao;
    }
    
    public String buscarNomeCategoria(int id){
    String nome = null;
         try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "nome_categoria"
                
                 + " FROM"
                     + " Categoria"
                 + " WHERE"
                     + " id_categoria = '" + id + "'"
                + ";"
            );

            while(this.getResultSet().next()){
               nome = this.getResultSet().getString(1);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nome;
}

    /**
    * atualiza Movimentacao
    * @param pModelMovimentacao
    * return boolean
    */
    public boolean atualizarMovimentacaoDAO(Movimentacao pModelMovimentacao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Movimentacao SET "
                    + "id_mov = '" + pModelMovimentacao.getIdMovimentacao() + "',"
                    + "valor = '" + pModelMovimentacao.getValor() + "',"
                    + "data = '" + pModelMovimentacao.getData() + "',"
                    + "descricao = '" + pModelMovimentacao.getDescricao() + "',"
                    + "id_categoria = '" + pModelMovimentacao.getNome_categoria() + "'"
                + " WHERE "
                    + "id_mov = '" + pModelMovimentacao.getIdMovimentacao() + "'"
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
                    + "id_mov = '" + pIdMovimentacao + "'"
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