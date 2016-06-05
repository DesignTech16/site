package Persistencia;



import Persistencia.*;
import model.Categoria;
import java.util.ArrayList;
/**
*
* @author Danilo
*/
public class DAOCategoria extends ConexaoMySql {

    /**
    * grava Categoria
    * @param pModelCategoria
    * return int
    */
    public int salvarCategoriaDAO(Categoria pModelCategoria){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO Categoria ("
                    + "id_categoria,"
                    + "nome_categoria"
                + ") VALUES ("
                    + "'" + pModelCategoria.getIdCategoria() + "',"
                    + "'" + pModelCategoria.getNomeCategoria() + "'"
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
    * recupera uma lista de Categoria
        * return ArrayList
    */
    public ArrayList<String> getListaCategoriaDAO(){
        ArrayList<String> listamodelCategoria = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    
                    + "nome_categoria"
                 + " FROM"
                     + " Categoria"
                + ";"
            );

            while(this.getResultSet().next()){
                              
                listamodelCategoria.add(this.getResultSet().getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCategoria;
    }

    /**
    * atualiza Categoria
    * @param pModelCategoria
    * return boolean
    */
    public boolean atualizarCategoriaDAO(Categoria pModelCategoria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Categoria SET "
                    + "id_categoria = '" + pModelCategoria.getIdCategoria() + "',"
                    + "nome_categoria = '" + pModelCategoria.getNomeCategoria() + "'"
                + " WHERE "
                    + "nome_categoria = '" + pModelCategoria.getNomeCategoria() + "'"
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
    * exclui Categoria
    * @param pIdCategoria
    * return boolean
    */
    public boolean excluirCategoriaDAO(String nomeCategoria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Categoria "
                + " WHERE "
                    + "nome_categoria = '" + nomeCategoria + "'"
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