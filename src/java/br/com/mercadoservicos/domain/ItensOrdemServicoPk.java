package br.com.mercadoservicos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class ItensOrdemServicoPk implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="idOrdemServico", referencedColumnName="id")
    private OrdemServico ordemServico;
    
    @NotNull
    @Column(name="sequencia")
    private Integer sequencia;

    public ItensOrdemServicoPk() {
    }

    public ItensOrdemServicoPk(OrdemServico ordemServico, Integer sequencia) {
        this.ordemServico = ordemServico;
        this.sequencia = sequencia;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public String toString() {
        return "ItensOrdemServicoPk{" + "ordemServico=" + ordemServico + ", sequencia=" + sequencia + '}';
    }
    
    
}
