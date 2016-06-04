package Persistencia;

import model.ModelCategoria;
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
    public int salvarCategoriaDAO(ModelCategoria pModelCategoria){
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
    public ArrayList<ModelCategoria> getListaCategoriaDAO(){
        ArrayList<ModelCategoria> listamodelCategoria = new ArrayList();
        ModelCategoria modelCategoria = new ModelCategoria();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_categoria,"
                    + "nome_categoria"
                 + " FROM"
                     + " Categoria"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCategoria = new ModelCategoria();
                modelCategoria.setIdCategoria(this.getResultSet().getInt(1));
                modelCategoria.setNomeCategoria(this.getResultSet().getString(2));
                listamodelCategoria.add(modelCategoria);
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
    public boolean atualizarCategoriaDAO(ModelCategoria pModelCategoria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Categoria SET "
                    + "id_categoria = '" + pModelCategoria.getIdCategoria() + "',"
                    + "nome_categoria = '" + pModelCategoria.getNomeCategoria() + "'"
                + " WHERE "
                    + "id_categoria = '" + pModelCategoria.getIdCategoria() + "'"
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
    public boolean excluirCategoriaDAO(int pIdCategoria){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Categoria "
                + " WHERE "
                    + "id_categoria = '" + pIdCategoria + "'"
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