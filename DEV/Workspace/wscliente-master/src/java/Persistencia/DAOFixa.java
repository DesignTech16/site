package Persistencia;

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
                    + "'" + pModelFixa.getDia() + "',"
                    + "'" + pModelFixa.getId_categoria() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Fixa
     *
     * @param pIdFixa return Fixa
     */
    public Fixa getFixaDAO(int pIdFixa) {
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
                    + " WHERE"
                    + " id_fixa = '" + pIdFixa + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFixa.setIdFixa(this.getResultSet().getInt(1));
                int i = this.getResultSet().getInt(2);
                if (i == 1) {
                    modelFixa.setStatus(true);
                } else {
                    modelFixa.setStatus(false);
                }
                modelFixa.setDescricao(this.getResultSet().getString(3));
                modelFixa.setDia(this.getResultSet().getDate(4));
                modelFixa.setId_categoria(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFixa;
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
                modelFixa.setId_categoria(this.getResultSet().getInt(5));
                listamodelFixa.add(modelFixa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFixa;
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
                    + "id_categoria = '" + pModelFixa.getId_categoria() + "'"
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
