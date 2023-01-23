/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author 26134
 */
public class Client {
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String sexeClient;
    private String adresseClient;
    private String situationMatClient;
    private String telephoneClient;
    private String emailClient;

    public Client() {
    }

    public Client(int idClient, String nomClient, String prenomClient, String sexeClient, String adresseClient, String situationMatClient, String telephoneClient, String emailClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.sexeClient = sexeClient;
        this.adresseClient = adresseClient;
        this.situationMatClient = situationMatClient;
        this.telephoneClient = telephoneClient;
        this.emailClient = emailClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getSexeClient() {
        return sexeClient;
    }

    public void setSexeClient(String sexeClient) {
        this.sexeClient = sexeClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getSituationMatClient() {
        return situationMatClient;
    }

    public void setSituationMatClient(String situationMatClient) {
        this.situationMatClient = situationMatClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }
    
}
