package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.database.Database;

public class BoardDAO {
    public void criarBoard(String nome) {
        try (Connection conn = Database.conectar()) {
            String sql = "INSERT INTO boards (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Board criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listarBoards() {
        List<String> boards = new ArrayList<>();
        try (Connection conn = Database.conectar()) {
            String sql = "SELECT * FROM boards";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                boards.add(rs.getInt("id") + " - " + rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boards;
    }

    public void excluirBoard(int idBoard) {
        try (Connection conn = Database.conectar()) {
            String sql = "DELETE FROM boards WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idBoard);
            stmt.executeUpdate();
            System.out.println("Board excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}