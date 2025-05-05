package br.com.flp.contatos.contatos;

import br.com.flp.contatos.dao.Conexao;
import br.com.flp.contatos.dao.ContatoDao;
import br.com.flp.contatos.dao.TipoContatoDao;
import br.com.flp.contatos.model.Contato;
import br.com.flp.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {
    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

//        cadastrar(em);
//        atualizar(em);
//        excluir(em);
//        consultarContatoPorId(em);
//        listarTodosOsContatos(em);
//        listarContatosPorEmail(em);
//        consultarTipoContatoPorId(em);

    }

    private static void consultarTipoContatoPorId(EntityManager em) {
        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);
        TipoContato tipoContatoBuscado = new TipoContato();
        tipoContatoBuscado.setId(5L);

        TipoContato tipoContatoEncontrado = new TipoContato();
        tipoContatoEncontrado = tipoContatoDao.buscarTipoContatoPorId(tipoContatoBuscado);

        System.out.println(tipoContatoEncontrado.getTipo());
        System.out.println(tipoContatoEncontrado.getContatos());
    }

    public  static void cadastrar(EntityManager em){

        TipoContato tipoContato = new TipoContato();
        tipoContato.setId(5L);
        tipoContato.setTipo("Família");

        TipoContatoDao tipoContatoDao = new TipoContatoDao(em);

        em.getTransaction().begin();
        //tipoContatoDao.salvar(tipoContato);

        Contato contato = new Contato();
        contato.setNome("Anderson Silva");
        contato.setEmail("spider@gmail.com");
        contato.setDataNascimento(LocalDate.of(1975,4,17));
        contato.setTipoContato(tipoContato);

        ContatoDao contatoDao = new ContatoDao(em);

        contatoDao.salvar(contato);

        em.getTransaction().commit();
    }

    public  static void atualizar(EntityManager em){
        Contato contato = new Contato();
        contato.setId(32L);
        contato.setNome("Felipe Oliveira");
        contato.setEmail("felipeolv@fiap.com.br");
        contato.setDataNascimento(LocalDate.of(2004,2,29));


        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();
    }

    public  static void excluir (EntityManager em){
        Contato contato = new Contato();
        contato.setId(5L);

        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.excluir(contato);
        em.getTransaction().commit();
    }

    public  static void consultarContatoPorId (EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.consultarContatoPorId(5L);
        em.getTransaction().commit();
    }
    public  static void listarTodosOsContatos (EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.ListarTodosOsContatos();

        for (Contato contato : contatos){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(contato.toString());
        }

        System.out.println("Fim dos registros");

    }

    public  static void listarContatosPorEmail (EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.ListarContatosPorEmail("anamaria@gmail.com");

        for (Contato contato : contatos){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(contato.toString());
        }

        System.out.println("Fim dos registros");

    }

}
