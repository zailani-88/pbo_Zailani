package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class supplier {
    private String database_name = "2210010451"; // Nama database Anda
    private String username = "root"; // Username MySQL Anda
    private String password = ""; // Password MySQL Anda
    public Connection koneksiDB; 

    public supplier() {
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

    // Metode untuk menyimpan data ke tabel Supplier
    public void Simpan(String nama, String telp, String alamat) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO Supplier (Nama, Telp, Alamat) VALUES (?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama);
                perintah.setString(2, telp);
                perintah.setString(3, alamat);
                perintah.executeUpdate();
                System.out.println("Data berhasil disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    // Metode untuk mengubah data di tabel Supplier
    public void Ubah(int id, String nama, String telp, String alamat) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE Supplier SET Nama=?, Telp=?, Alamat=? WHERE ID=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama);
                perintah.setString(2, telp);
                perintah.setString(3, alamat);
                perintah.setInt(4, id);
                perintah.executeUpdate();
                System.out.println("Data berhasil diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah data: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    // Metode untuk menghapus data dari tabel Supplier
    public void Hapus(int id) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM Supplier WHERE ID=?";
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
