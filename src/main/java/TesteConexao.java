import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:h2:file:./data/meubanco";
        String usuario = "sa";
        String senha = "";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conectado com sucesso");
            System.out.println("Banco: " + conn.getMetaData().getDatabaseProductName());
            System.out.println("Versão: " + conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
