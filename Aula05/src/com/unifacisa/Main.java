package com.unifacisa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Configurações de conexão
        String jdbcUrl = "jdbc:mysql://localhost:3306/loja"; // Substitua pelo URL correto do seu SGBD
        String username = "root";
        String password = "marcos090716";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Inserir dados na tabela Produto
            insertProduct(connection, 1, "Arroz");
            insertProduct(connection, 2, "Feijao");
            insertProduct(connection, 3, "macarrao");

            // Fechar conexão
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir produtos na tabela Produto
    private static void insertProduct(Connection connection, int codProduto, String produto) throws SQLException {
        String selectSql = "SELECT codProduto FROM Produto WHERE codProduto = ?";
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setInt(1, codProduto);
        ResultSet resultSet = selectStatement.executeQuery();
        
        if (!resultSet.next()) {
            String insertSql = "INSERT INTO Produto (codProduto, produto) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setInt(1, codProduto);
            insertStatement.setString(2, produto);
            insertStatement.executeUpdate();
            insertStatement.close();
        }
        
        selectStatement.close();
        resultSet.close();
    	}
    }