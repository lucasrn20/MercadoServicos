package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.ItensOrdemServico;
import br.com.mercadoservicos.domain.OrdemServico;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class ItensOrdemServicoDao {
    
    public List<ItensOrdemServico> listar(OrdemServico ordemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<ItensOrdemServico> itensOrdemServicos = session.createQuery("from ItensOrdemServico where idOrdemServico = "+ ordemServico.getId() +" order by dataHora").list();
            session.getTransaction().commit();
            return itensOrdemServicos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(ItensOrdemServico itensOrdemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(itensOrdemServico);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }   
    
    public boolean alterar(ItensOrdemServico itensOrdemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(itensOrdemServico);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    } 
     
    public boolean excluir(ItensOrdemServico itensOrdemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(itensOrdemServico);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
}
