package model;


/**
*
* @author Danilo
*/
public class Saldo {

    private int idSaldo;
    private float saldo;

    /**
    * Construtor
    */
    public Saldo(){}

    /**
    * seta o valor de idSaldo
    * @param pIdSaldo
    */
    public void setIdSaldo(int pIdSaldo){
        this.idSaldo = pIdSaldo;
    }
    /**
    * return pk_idSaldo
    */
    public int getIdSaldo(){
        return this.idSaldo;
    }

    /**
    * seta o valor de saldo
    * @param pSaldo
    */
    public void setSaldo(float pSaldo){
        this.saldo = pSaldo;
    }
    /**
    * return saldo
    */
    public float getSaldo(){
        return this.saldo;
    }

    @Override
    public String toString(){
        return "ModelSaldo {" + "::idSaldo = " + this.idSaldo + "::saldo = " + this.saldo +  "}";
    }
}