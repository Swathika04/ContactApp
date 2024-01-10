package com.ContactApplication.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ContactApplication.Dto.*;

public class ContactRepo {
    private static ContactRepo contactRepositoryDb;
    private Statement stmt;
    private Connection con;
    private List<Contact> showContactList = new ArrayList<>();

    private ContactRepo() {
        stmt = null;
        con = null;
    }

    public static ContactRepo getInstance() throws Exception {
        if (contactRepositoryDb == null) {
            contactRepositoryDb = new ContactRepo();
            contactRepositoryDb.executeConnection();
        }
        return contactRepositoryDb;
    }

    private void executeConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/contactapp";
        String username = "*********";
        String password = "*********";
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
    }

    public List<Contact> showContact() {

        try {

            ResultSet resultSet = stmt.executeQuery("select * from contacts");
            while (resultSet.next()) {

                Contact contact = new Contact(resultSet.getInt("contactId"), resultSet.getString("contactName"),
                        resultSet.getString("phone1"), resultSet.getString("phone2"), resultSet.getString("email"),
                        resultSet.getString("notes"));
                showContactList.add(contact);

            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return showContactList;

    }

    public void addContact(Contact contact) {
        try {
            stmt.executeUpdate("insert into contacts (contactName,phone1,phone2,email,notes) values('"
                    + contact.getContactname() + "','" + contact.getContactnumber1() + "','"
                    + contact.getContactnumber2() + "','" + contact.getEmail() + "','" + contact.getNotes() + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeContact(int contactId) {
        try {
            stmt.executeUpdate("delete from contacts where contactId='" + contactId + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editContact(int contactId, String fieldToBeupdated, String updatedValue) {
        try {
            String query = "update contacts set '?'= ? where contactId=?";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            preparedStmt.setString(1, fieldToBeupdated);
            preparedStmt.setString(2, updatedValue);
            preparedStmt.setInt(3, contactId);
            preparedStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
