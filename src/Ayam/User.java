/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ayam;

/**
 *
 * @author acer
 */
public class User extends Entity {
    private String nama;
    private String email;
    private String noTelp;
    private String password;

    public User(String id, String nama, String email, String noTelp, String password) {
        super(id);
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
        this.password = password;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
