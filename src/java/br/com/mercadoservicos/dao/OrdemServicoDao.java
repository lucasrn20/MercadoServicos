package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.OrdemServico;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class OrdemServicoDao {
    
    public List<OrdemServico> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<OrdemServico> ordemServicos = session.createQuery("from OrdemServico order by dataHora").list();
            session.getTransaction().commit();
            return ordemServicos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public OrdemServico consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            OrdemServico ordemServico = (OrdemServico)session.createQuery("from OrdemServico where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return ordemServico;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(OrdemServico ordemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(ordemServico);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
    public boolean excluir(OrdemServico ordemServico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(ordemServico);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
}
