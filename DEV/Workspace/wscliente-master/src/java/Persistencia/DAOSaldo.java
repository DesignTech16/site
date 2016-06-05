package Persistencia;

import model.Saldo;
import Persistencia.ConexaoMySql;
import java.util.ArrayList;
/**
q*
* @author Danilo
*/
public class DAOSaldo extends ConexaoMySql {

    /**
    * grava Saldo
    * @param pModelSaldo
    * return int
    */
    public int salvarSaldoDAO(Saldo pModelSaldo){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO Saldo ("
                    + "id_saldo,"
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
    * return Saldo
    */
    public float getSaldoDAO(){
        Saldo modelSaldo = new Saldo();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    
                    + "saldo"
                 + " FROM"
                     + " Saldo"
                 + " WHERE"
                     + " id_saldo = '" + 1 + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                
                modelSaldo.setSaldo(this.getResultSet().getFloat("saldo"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelSaldo.getSaldo();
    }

  
    /**
    * atualiza Saldo
    * @param pModelSaldo
    * return boolean
    */
    public boolean atualizarSaldoDAO(){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Saldo SET "
                    
                    + "saldo = (select sum(valor) from Movimentacao)"
                + " WHERE "
                    + "id_saldo = '" + 1 + "'"
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
    public boolean excluirSaldoDAO(){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Saldo "
                + " WHERE "
                    + "id_saldo = '" + 1 + "'"
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