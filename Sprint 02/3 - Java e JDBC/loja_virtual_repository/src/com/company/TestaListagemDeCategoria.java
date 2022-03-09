package com.company;

import com.company.dao.CategoriaDAO;
import com.company.dao.ProdutoDAO;
import com.company.factory.ConnectionFactory;
import com.company.modelo.Categoria;
import com.company.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategoria {
    public static void main(String[] args) throws SQLException {


        try (Connection connection = new ConnectionFactory().recuperarConexao()) {

            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
            listaDeCategoria.stream().forEach(ct -> {
                System.out.println(ct.getNome());

                    for (Produto produto : ct.getProdutos()) {
                        System.out.println(ct.getNome() + " - " + produto.getNome());
                    }

            });

        }
    }
}
