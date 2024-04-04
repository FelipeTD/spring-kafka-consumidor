package tortora.kafka.consumidor.data;

import java.math.BigDecimal;

public class PedidoData {

    private String codigo;
    private String nomeProduto;
    private BigDecimal valor;

    public PedidoData() {
        super();
    }

    public PedidoData(String codigo, String nomeProduto, BigDecimal valor) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PedidoData{" +
                "codigo='" + codigo + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                '}';
    }

}
