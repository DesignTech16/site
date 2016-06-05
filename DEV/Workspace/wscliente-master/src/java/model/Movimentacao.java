package model;



import java.io.Serializable;
import java.util.Date;

/**
*
* @author Danilo
*/
public class Movimentacao implements Serializable {

    private int idMovimentacao;
    private String tipo;
    private float valor;
    private Date data;
    private String descricao;
    private String nome_categoria;

    /**
    * Construtor
    */
    public Movimentacao(){
    }

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
        if(valor < 0){
            setTipo("Despesa");
        }else{
            setTipo("Receita");
        }
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
    * seta o valor de nome_categoria
    * @param pId_categoria
    */
    public void setNome_categoria(String pId_categoria){
        this.nome_categoria = pId_categoria;
    }
    /**
    * return fk_id_categoria
    */
    public String getNome_categoria(){
        return this.nome_categoria;
    }

    @Override
    public String toString(){
        return "ModelMovimentacao {" + "::idMovimentacao = " + this.idMovimentacao + "::valor = " + this.valor + "::data = " + this.data + "::descricao = " + this.descricao + "::id_categoria = " + this.nome_categoria +  "}";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}