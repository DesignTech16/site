package Persistencia;

import model.ModelSaldo;
import Persistencia.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Danilo
*/
public class DAOSaldo extends ConexaoMySql {

    /**
    * grava Saldo
    * @param pModelSaldo
    * return int
    */
    public int salvarSaldoDAO(ModelSaldo pModelSaldo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO Saldo ("
                    + "pk_id_saldo,"
                    + "saldo"
                + ") VALUES ("
                    + "'" + pModelSaldo.getIdSaldo() + "',"
                    + "'" + pModelSaldo.getSaldo() + "'"
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
    * recupera Saldo
    * @param pIdSaldo
    * return ModelSaldo
    */
    public ModelSaldo getSaldoDAO(int pIdSaldo){
        ModelSaldo modelSaldo = new ModelSaldo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_saldo,"
                    + "saldo"
                 + " FROM"
                     + " Saldo"
                 + " WHERE"
                     + " pk_id_saldo = '" + pIdSaldo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSaldo.setIdSaldo(this.getResultSet().getInt(1));
                modelSaldo.setSaldo(this.getResultSet().getFloat(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelSaldo;
    }

    /**
    * recupera uma lista de Saldo
        * return ArrayList
    */
    public ArrayList<ModelSaldo> getListaSaldoDAO(){
        ArrayList<ModelSaldo> listamodelSaldo = new ArrayList();
        ModelSaldo modelSaldo = new ModelSaldo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_saldo,"
                    + "saldo"
                 + " FROM"
                     + " Saldo"
                + ";"
            );

            while(this.getResultSet().next()){
                modelSaldo = new ModelSaldo();
                modelSaldo.setIdSaldo(this.getResultSet().getInt(1));
                modelSaldo.setSaldo(this.getResultSet().getFloat(2));
                listamodelSaldo.add(modelSaldo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelSaldo;
    }

    /**
    * atualiza Saldo
    * @param pModelSaldo
    * return boolean
    */
    public boolean atualizarSaldoDAO(ModelSaldo pModelSaldo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Saldo SET "
                    + "pk_id_saldo = '" + pModelSaldo.getIdSaldo() + "',"
                    + "saldo = '" + pModelSaldo.getSaldo() + "'"
                + " WHERE "
                    + "pk_id_saldo = '" + pModelSaldo.getIdSaldo() + "'"
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
    * exclui Saldo
    * @param pIdSaldo
    * return boolean
    */
    public boolean excluirSaldoDAO(int pIdSaldo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Saldo "
                + " WHERE "
                    + "pk_id_saldo = '" + pIdSaldo + "'"
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