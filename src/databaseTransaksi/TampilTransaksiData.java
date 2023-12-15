/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseTransaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.KoneksiDB;

/**
 *
 * @author Limun
 */
public class TampilTransaksiData {
    private ResultSet rs;
    
    public ResultSet tampilkanDataSemuaTransaksi(){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String readallquery = String.format("SELECT * FROM transaksi");
            PreparedStatement preparedStatement = koneksi.prepareStatement(readallquery);
            
            this.rs = preparedStatement.executeQuery();
            return this.rs;
        }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
            }
        return this.rs;
    }
   
    public ResultSet tampiltransaksi (Integer faktur){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String query = "SELECT * FROM transaksi WHERE faktur = ?";
            PreparedStatement preparedStatement = koneksi.prepareCall(query);
            
            preparedStatement.setInt(1, faktur);
            this.rs = preparedStatement.executeQuery();
            return this.rs;
            
        } catch (ClassNotFoundException | SQLException ex ){
        System.out.println("Error BROK : "+ ex.getMessage());
        
        return this.rs;
        }      
    }
    
        public void updatebarang (Integer jumlbarang, Integer kode_barang){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String query = "UPDATE barang SET jumlah_barang = ? WHERE kode_barang = ?";
            PreparedStatement preparedStatement = koneksi.prepareCall(query);
            
            preparedStatement.setInt(1, jumlbarang);
            preparedStatement.setInt(2, kode_barang);
            preparedStatement.executeUpdate();
            
            
        } catch (ClassNotFoundException | SQLException ex ){
        System.out.println("Error BROK : "+ ex.getMessage());
        
        }      
    }
}
