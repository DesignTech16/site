package Persistencia;

import java.sql.Date;
import model.Fixa;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DAOFixa extends ConexaoMySql {

    /**
     * grava Fixa
     *
     * @param pModelFixa return int
     */
    public int salvarFixaDAO(Fixa pModelFixa) {
        try {

            this.conectar();
            int i = 0;
            if (pModelFixa.isStatus()) {
                i = 1;
            }
            Date d = new Date(pModelFixa.getDia().getTime());
            
            return this.insertSQL(
                    "INSERT INTO Fixa ("
                    + "id_fixa,"
                    + "status,"
                    + "descricao,"
                    + "dia,"
                    + "id_categoria"
                    + ") VALUES ("
                    + "'" + pModelFixa.getIdFixa() + "',"
                    + "'" + i + "',"
                    + "'" + pModelFixa.getDescricao() + "',"
                    + "'" + d + "',"
                    + "'" + buscarIdCategoria(pModelFixa.getNome_categoria()) + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
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
     * recupera uma lista de Fixa return ArrayList
     */
    public ArrayList<Fixa> getListaFixaDAO() {
        ArrayList<Fixa> listamodelFixa = new ArrayList();
        Fixa modelFixa = new Fixa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_fixa,"
                    + "status,"
                    + "descricao,"
                    + "dia,"
                    + "id_categoria"
                    + " FROM"
                    + " Fixa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFixa = new Fixa();
                modelFixa.setIdFixa(this.getResultSet().getInt(1));
                modelFixa.setStatus(this.getResultSet().getBoolean(2));
                modelFixa.setDescricao(this.getResultSet().getString(3));
                modelFixa.setDia(this.getResultSet().getDate(4));
                modelFixa.setNome_categoria(buscarNomeCategoria(this.getResultSet().getInt(5)));
                listamodelFixa.add(modelFixa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFixa;
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
     * atualiza Fixa
     *
     * @param pModelFixa return boolean
     */
    public boolean atualizarFixaDAO(Fixa pModelFixa) {
        try {
            this.conectar();
              int i = 0;
            if (pModelFixa.isStatus()) {
                i = 1;
            }
            return this.executarUpdateDeleteSQL(
                    "UPDATE Fixa SET "
                    + "id_fixa = '" + pModelFixa.getIdFixa() + "',"
                    + "status = '" + i + "',"
                    + "descricao = '" + pModelFixa.getDescricao() + "',"
                    + "dia = '" + pModelFixa.getDia() + "',"
                    + "id_categoria = '" + buscarIdCategoria(pModelFixa.getNome_categoria()) + "'"
                    + " WHERE "
                    + "id_fixa = '" + pModelFixa.getIdFixa() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Fixa
     *
     * @param pIdFixa return boolean
     */
    public boolean excluirFixaDAO(int pIdFixa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Fixa "
                    + " WHERE "
                    + "id_fixa = '" + pIdFixa + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
