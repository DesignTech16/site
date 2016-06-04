package model;



import java.util.Date;

/**
*
* @author Danilo
*/
public class ModelMovimentacao {

    private int idMovimentacao;
    private float valor;
    private Date data;
    private String descricao;
    private int id_categoria;

    /**
    * Construtor
    */
    public ModelMovimentacao(){}

    /**
    * seta o valor de idMovimentacao
    * @param pIdMovimentacao
    */
    public void setIdMovimentacao(int pIdMovimentacao){
        this.idMovimentacao = pIdMovimentacao;
    }
    /**
    * return pk_idMovimentacao
    */
    public int getIdMovimentacao(){
        return this.idMovimentacao;
    }

    /**
    * seta o valor de valor
    * @param pValor
    */
    public void setValor(float pValor){
        this.valor = pValor;
    }
    /**
    * return valor
    */
    public float getValor(){
        return this.valor;
    }

    /**
    * seta o valor de data
    * @param pData
    */
    public void setData(Date pData){
        this.data = pData;
    }
    /**
    * return data
    */
    public Date getData(){
        return this.data;
    }

    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    /**
    * seta o valor de id_categoria
    * @param pId_categoria
    */
    public void setId_categoria(int pId_categoria){
        this.id_categoria = pId_categoria;
    }
    /**
    * return fk_id_categoria
    */
    public int getId_categoria(){
        return this.id_categoria;
    }

    @Override
    public String toString(){
        return "ModelMovimentacao {" + "::idMovimentacao = " + this.idMovimentacao + "::valor = " + this.valor + "::data = " + this.data + "::descricao = " + this.descricao + "::id_categoria = " + this.id_categoria +  "}";
    }
}