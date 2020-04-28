package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.OrdemServicoDao;
import br.com.mercadoservicos.domain.OrdemServico;
import java.util.Date;
import java.util.List;

public class OrdemServicoService {
    
    private OrdemServicoDao ordemServico = new OrdemServicoDao();
    
    public List<OrdemServico> listar(){
        return ordemServico.listar();
    }
    
    public OrdemServico consultar(Integer id){
        return ordemServico.consultar(id);
    }
    
    public boolean inserir(OrdemServico ordemServico){
        ordemServico.setDataHora(new Date());
        return this.ordemServico.inserir(ordemServico);
    }

    public boolean excluir(OrdemServico ordemServico){
        return this.ordemServico.excluir(ordemServico);
    }
}
