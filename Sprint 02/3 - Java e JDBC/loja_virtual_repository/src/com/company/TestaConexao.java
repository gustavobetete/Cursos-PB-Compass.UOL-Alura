package com.company;
import com.company.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory ConnectionFactory = new ConnectionFactory();
        Connection con = ConnectionFactory.recuperarConexao();

        System.out.println("Fechando conexão!!!");
        con.close();
    }

}
