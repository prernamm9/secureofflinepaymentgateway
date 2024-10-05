import encryption.AES;
import db.SQLiteHandler;
import models.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SQLiteHandler dbHandler = new SQLiteHandler();
        AES aes = new AES();

        // Simulate a transaction
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter transaction amount:");
        double amount = sc.nextDouble();

        Transaction tx = new Transaction(amount, "2024-10-04", "Completed");

        // Encrypt transaction data
        String encryptedData = aes.encrypt(tx.toString());
        System.out.println("Encrypted Transaction Data: " + encryptedData);

        // Store encrypted transaction in the database
        dbHandler.storeTransaction(tx);
        System.out.println("Transaction stored securely.");

        // Decrypt data for verification (optional)
        String decryptedData = aes.decrypt(encryptedData);
        System.out.println("Decrypted Transaction Data: " + decryptedData);
    }
}
