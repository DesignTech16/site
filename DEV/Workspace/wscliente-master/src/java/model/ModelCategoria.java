package model;


/**
*
* @author Danilo
*/
public class ModelCategoria {

    private int idCategoria;
    private String nomeCategoria;

    /**
    * Construtor
    */
    public ModelCategoria(){}

    /**
    * seta o valor de idCategoria
    * @param pIdCategoria
    */
    public void setIdCategoria(int pIdCategoria){
        this.idCategoria = pIdCategoria;
    }
    /**
    * return pk_idCategoria
    */
    public int getIdCategoria(){
        return this.idCategoria;
    }

    /**
    * seta o valor de nomeCategoria
    * @param pNomeCategoria
    */
    public void setNomeCategoria(String pNomeCategoria){
        this.nomeCategoria = pNomeCategoria;
    }
    /**
    * return nomeCategoria
    */
    public String getNomeCategoria(){
        return this.nomeCategoria;
    }

    @Override
    public String toString(){
        return "ModelCategoria {" + "::idCategoria = " + this.idCategoria + "::nomeCategoria = " + this.nomeCategoria +  "}";
    }
}