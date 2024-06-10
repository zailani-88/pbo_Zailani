package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class catatan_keuangan {
    private String database_name = "2210010451"; // Nama database Anda
    private String username = "root"; // Username MySQL Anda
    private String password = ""; // Password MySQL Anda
    public Connection koneksiDB; 

    public catatan_keuangan() {
        try {
            String lokasi = "jdbc:mysql://localhost:3306/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }

    // Metode untuk menyimpan data ke tabel Catatan_Keuangan
    public void Simpan(String tanggal, String pengeluaran, double harga, double keuangan) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO Catatan_Keuangan (Tanggal, Pengeluaran, Harga, Keuangan) VALUES (?, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, tanggal);
                perintah.setString(2, pengeluaran);
                perintah.setDouble(3, harga);
                perintah.setDouble(4, keuangan);
                perintah.executeUpdate();
                System.out.println("Data berhasil disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    // Metode untuk mengubah data di tabel Catatan_Keuangan
    public void Ubah(int id, String tanggal, String pengeluaran, double harga, double keuangan) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE Catatan_Keuangan SET Tanggal=?, Pengeluaran=?, Harga=?, Keuangan=? WHERE ID=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, tanggal);
                perintah.setString(2, pengeluaran);
                perintah.setDouble(3, harga);
                perintah.setDouble(4, keuangan);
                perintah.setInt(5, id);
                perintah.executeUpdate();
                System.out.println("Data berhasil diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    // Metode untuk menghapus data dari tabel Catatan_Keuangan
    public void Hapus(int id) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM Catatan_Keuangan WHERE ID=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setInt(1, id);
                perintah.executeUpdate();
                System.out.println("Data berhasil dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
}
