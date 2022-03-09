package com.company;

import com.company.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperarConexao();

        Statement stm = con.createStatement();

       stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES (Mouse', 'Mouse sem fio', 5, 69.90)", Statement.RETURN_GENERATED_KEYS);

       ResultSet rst = stm.getGeneratedKeys();
       while(rst.next()){

           Integer id = rst.getInt(1);
           System.out.println("O id criado foi: " + id);

       }
        con.close();
    }
}
