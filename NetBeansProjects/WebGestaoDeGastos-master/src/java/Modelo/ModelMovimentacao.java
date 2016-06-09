
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelMovimentacao extends ModelCategoria implements Serializable{
    private int IdMovimentacao;
    private float Valor;
    private Date Data;
    private String Descricao;
    private boolean status;
    private String tipo;
    private String dataFormat;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public int getIdMovimentacao() {
        return IdMovimentacao;
    }

    public void setIdMovimentacao(int IdMovimentacao) {
        this.IdMovimentacao = IdMovimentacao;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
        
        SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
     
        dataFormat = sm.format(Data);
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
}
