package db;

import models.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteHandler {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:transactions.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void storeTransaction(Transaction tx) {
        String sql = "INSERT INTO transactions(amount, date, status) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, tx.getAmount());
            pstmt.setString(2, tx.getDate());
            pstmt.setString(3, tx.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
