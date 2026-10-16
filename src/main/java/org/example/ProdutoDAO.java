package org.example;

import java.sql.Connection;
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
}