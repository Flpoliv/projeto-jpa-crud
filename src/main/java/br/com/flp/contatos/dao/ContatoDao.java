package br.com.flp.contatos.dao;

import br.com.flp.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {
    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Contato contato) {
        em.persist(contato);

    }

   public void atualizar(Contato contato){
        em.merge(contato);
   }

    public void excluir(Contato contato){
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);
    }

    public void consultarContatoPorId(Long id){
        Contato contatoConsulta = em.find(Contato.class, id);

        if (contatoConsulta == null){
            System.out.println("O contato não foi encontrado");
        }
        else {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(contatoConsulta.toString());}
            System.out.println("--------------------------------------------------------------------------------------------------------");

    }

    public List<Contato> ListarTodosOsContatos(){
        String consulta = "SELECT c FROM Contato c ORDER BY nome ASC";
        return em.createQuery(consulta).getResultList();
    }

    public List<Contato> ListarContatosPorEmail(String email){
        String consulta = "SELECT c FROM Contato c WHERE email = :email";
        return em.createQuery(consulta, Contato.class)
                .setParameter("email", email)
                .getResultList();
    }

}
