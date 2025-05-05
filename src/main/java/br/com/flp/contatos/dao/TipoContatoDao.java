package br.com.flp.contatos.dao;

import br.com.flp.contatos.model.Contato;
import br.com.flp.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TipoContatoDao {

    private EntityManager em;

    public TipoContatoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(TipoContato tipocontato) {
        em.persist(tipocontato);

    }

    public TipoContato buscarTipoContatoPorId(TipoContato tipoContato){
        return  em.find(TipoContato.class, tipoContato.getId());
    }

}