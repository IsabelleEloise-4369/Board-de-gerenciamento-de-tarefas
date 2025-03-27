package board;

import java.sql.*;

import board.database.Database;

public class CardDAO {
    public void criarCard(int colunaId, String titulo, String descricao) {
        try (Connection conn = Database.conectar()) {
            String sql = "INSERT INTO cards (titulo, descricao, coluna_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setInt(3, colunaId);
            stmt.executeUpdate();
            System.out.println("Card criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bloquearCard(int cardId, String motivo) {
        try (Connection conn = Database.conectar()) {
            String sql = "UPDATE cards SET bloqueado = TRUE, bloqueio_justificativa = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, motivo);
            stmt.setInt(2, cardId);
            stmt.executeUpdate();
            System.out.println("Card bloqueado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desbloquearCard(int cardId, String motivo) {
        try (Connection conn = Database.conectar()) {
            String sql = "UPDATE cards SET bloqueado = FALSE WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cardId);
            stmt.executeUpdate();
            System.out.println("Card desbloqueado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}