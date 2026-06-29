/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appabsensismpihidayatuttholibin.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    private static Connection mysqlconfig;
    
    //method static untuk membuka koneksi ke database MySQL
    public static Connection konek(){
        try {
            //URL koneksi ke database: jdbc:mysql://[host]:[port]/[nama_database]
            String url = "jdbc:mysql://localhost:3306/absensi";

            //username database
            String user = "root";

            //password database
            String pass = "";

            //membuka koneksi ke database dan menyimpannya divariabel mysqlconfig
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException sQLException) {
            //menampilkan pesan error jika koneksi gagal
            System.err.println(sQLException.getMessage());
        }
        
        //mengembalikan objek koneksi (bisa null jika gagal)
        return mysqlconfig;
    }
}
