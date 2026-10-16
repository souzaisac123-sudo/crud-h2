package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produto (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                preco DOUBLE NOT NULL
            )
            """;

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada (ou já existia).");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.executeUpdate();
            System.out.println("Produto Inserido com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());

        }
    }
}