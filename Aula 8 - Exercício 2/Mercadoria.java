public abstract class Mercadoria {
    
    protected int codigo;
    protected String fabricante;
    protected String descricao;
    protected double valor;
    
    public Mercadoria(int codigo, String fabricante, String descricao, double valor) {
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    
            
}
