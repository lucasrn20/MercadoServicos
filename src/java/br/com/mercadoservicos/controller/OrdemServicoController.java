package br.com.mercadoservicos.controller;

import br.com.mercadoservicos.domain.ItensOrdemServico;
import br.com.mercadoservicos.domain.OrdemServico;
import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.service.OrdemServicoService;
import br.com.mercadoservicos.service.UsuarioService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ordemServicoMB")
@SessionScoped
public class OrdemServicoController implements Serializable{
    
    private OrdemServico ordemServico = new OrdemServico();
    private List<OrdemServico> ordensServico;
    private OrdemServicoService ordemServicoService = new OrdemServicoService();
    private UsuarioService usuarioService = new UsuarioService();
    private List<Usuario> clientes;
    private List<Usuario> empresas;
    private List<ItensOrdemServico> itensOrdemServico;
    private ItensOrdemServico itemOrdemServico;
    
    public OrdemServicoController(){
        listar();
    }
    
    public void listar(){
        ordensServico = ordemServicoService.listar();
    }
    
    public String novo(){
        ordemServico = new OrdemServico();
        itensOrdemServico = new ArrayList<>();
        itemOrdemServico = new ItensOrdemServico();
        clientes = usuarioService.listarClientes();
        empresas = usuarioService.listarEmpresas();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(OrdemServico ordemServico){
        this.ordemServico = ordemServico;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(ordemServicoService.inserir(ordemServico, itensOrdemServico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Ordem de serviço salva com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar a ordem de serviço!");
        return null;
    }
    
    public String excluir(OrdemServico ordemServico){
        if(ordemServicoService.excluir(ordemServico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Ordem de serviço excluida com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a ordem de serviço!");
        return null;
    }
    
    public void addServico(){
        itensOrdemServico.add(itemOrdemServico);
        itemOrdemServico = new ItensOrdemServico();
    }
    
    public void removeServico(ItensOrdemServico itemOrdemServico ){
        itensOrdemServico.remove(itemOrdemServico);
    }
    
    public void calculaTotal(){
        itemOrdemServico.setPreco(itemOrdemServico.getQuantidade() * itemOrdemServico.getServico().getPreco());
    }
    
    public List<OrdemServico> getCategorias() {
        return ordensServico;
    }

    public void setCategorias(List<OrdemServico> categorias) {
        this.ordensServico = categorias;
    }

    public OrdemServico getCategoria() {
        return ordemServico;
    }

    public void setCategoria(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }   

    public List<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }

    public List<Usuario> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Usuario> empresas) {
        this.empresas = empresas;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<OrdemServico> getOrdensServico() {
        return ordensServico;
    }

    public void setOrdensServico(List<OrdemServico> ordensServico) {
        this.ordensServico = ordensServico;
    }

    public List<ItensOrdemServico> getItensOrdemServico() {
        return itensOrdemServico;
    }

    public void setItensOrdemServico(List<ItensOrdemServico> itensOrdemServico) {
        this.itensOrdemServico = itensOrdemServico;
    }

    public ItensOrdemServico getItemOrdemServico() {
        return itemOrdemServico;
    }

    public void setItemOrdemServico(ItensOrdemServico itemOrdemServico) {
        this.itemOrdemServico = itemOrdemServico;
    }
    
    
}
