package testes;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {

        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto p = produtoDAO.buscarPorId(1l);
        System.out.println(p.getPreco());

//        List<Produto> todos = produtoDAO.buscarPorNome("Iphone");
//        todos.forEach(p2 -> System.out.println(p.getNome()));

        List<Produto> todos = produtoDAO.buscarPorCategorias("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Iphone");
        System.out.println("Preco do produto: "+precoDoProduto);

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone", "Muito caro", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);

        em.getTransaction().commit();
        em.close();

//        em.persist(celulares);
//        celulares.setNome("XPTO");

//        em.flush();
//        em.clear();

//        celulares = em.merge(celulares);
//        celulares.setNome("1234");
//        em.flush();
//        em.clear();
//        em.remove(celulares);
//        em.flush();
    }
}
