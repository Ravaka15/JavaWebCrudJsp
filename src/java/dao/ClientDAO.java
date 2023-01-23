/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 26134
 */
public class ClientDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/vente";
    private String jdbcClientname = "root";
    private String jdbcPassword = "";
    
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client" + "  (nomClient,prenomClient,sexeClient,adresseClient,situationMatClient,telephoneClient,emailClient) VALUES " + " (?,?,?,?,?,?,?);";
    private static final String SELECT_CLIENT_BY_ID = "select * from client where idClient=?";
    private static final String SELECT_ALL_CLIENT = "select * from client";
    private static final String DELETE_CLIENT_SQL = "delete from client where idClient = ?;";
    private static final String UPDATE_CLIENT_SQL = "update client set nomClient=?, prenomClient=? ,sexeClient=?, adresseClient=?, situationMatClient=? , telephoneClient=? , emailClient=? where idClient=?";


public ClientDAO() {}

   protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcClientname, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
   ///Insertion Client
    public void insertClient(Client cli) throws SQLException {
        System.out.println(INSERT_CLIENT_SQL);
        try (Connection connection = getConnection(); 
            PreparedStatement ps = connection.prepareStatement(INSERT_CLIENT_SQL)) {
                ps.setString(1,cli.getNomClient());  
                ps.setString(2,cli.getPrenomClient());  
                ps.setString(3,cli.getSexeClient());  
                ps.setString(4,cli.getAdresseClient());  
                ps.setString(5,cli.getSituationMatClient());  
                ps.setString(6,cli.getTelephoneClient());
                ps.setString(7,cli.getEmailClient());
                ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    /// Affichage modifiction Client ty
    public Client selectClient(int id){
        Client client = null;
        try (Connection connection = getConnection();
                
            PreparedStatement ps = connection.prepareStatement(SELECT_CLIENT_BY_ID);) {
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) { 
                int idClient = rs.getInt("idClient");
                String nomClient = rs.getString("nomClient");  
                String prenomClient =rs.getString("prenomClient");  
                String sexeClient =rs.getString("sexeClient");  
                String adresseClient = rs.getString("adresseClient");  
                String situationMatClient = rs.getString("situationMatClient");
                String telephoneClient = rs.getString("telephoneClient"); 
                String emailClient = rs.getString("emailClient"); 
                client = new Client(idClient,nomClient,prenomClient,sexeClient,adresseClient,situationMatClient,telephoneClient,emailClient);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return client;
    }
    
    /////Affichage Client
    public List < Client > selectAllClient(){
        List < Client > client = new ArrayList < > ();
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CLIENT);) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idClient = rs.getInt("idClient");
                String nomClient = rs.getString("nomClient");  
                String prenomClient =rs.getString("prenomClient");  
                String sexeClient =rs.getString("sexeClient");  
                String adresseClient = rs.getString("adresseClient");  
                String situationMatClient = rs.getString("situationMatClient");
                String telephoneClient = rs.getString("telephoneClient"); 
                String emailClient = rs.getString("emailClient"); 
                client.add(new Client(idClient,nomClient,prenomClient,sexeClient,adresseClient,situationMatClient,telephoneClient,emailClient));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return client;
    }
    
    // Suppression de Client
    public boolean deleteClient(int idClient) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); 
                PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL);) {
            statement.setInt(1, idClient);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Modification Client
     public boolean updateClient(Client cli) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
            PreparedStatement ps = connection.prepareStatement(UPDATE_CLIENT_SQL);) {
                ps.setString(1,cli.getNomClient());  
                ps.setString(2,cli.getPrenomClient());  
                ps.setString(3,cli.getSexeClient());  
                ps.setString(4,cli.getAdresseClient());  
                ps.setString(5,cli.getSituationMatClient());  
                ps.setString(6,cli.getTelephoneClient());  
                ps.setString(7,cli.getEmailClient()); 
                ps.setInt(8,cli.getIdClient());

                rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
     
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

} 
