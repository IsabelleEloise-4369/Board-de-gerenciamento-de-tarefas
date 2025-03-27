package board.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "root";  // Substitua pelo seu usuário
    private static final String PASSWORD = "sua_senha";  // Substitua pela sua senha

    // Método para obter conexão com o banco
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para testar a conexão
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static Connection conectar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'conectar'");
    }
}
