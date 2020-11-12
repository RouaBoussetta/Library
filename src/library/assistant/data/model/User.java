/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assistant.data.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class User {

    private int id;

    private String userName;
    private String lastname;
    private String pseudoName;
    private String userMail;
    private String userPassword;
    private String userImage;
    private String roles;

    public User(int id,  String roles, String userName, String lastname, String pseudoName, String userMail, String userPassword, String userImage) {
        this.id = id;
       

        this.roles = roles;
        this.userName = userName;
        this.lastname = lastname;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userImage = userImage;
    }

    public User() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPseudoName() {
        return pseudoName;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.userName);
        hash = 83 * hash + Objects.hashCode(this.lastname);
        hash = 83 * hash + Objects.hashCode(this.pseudoName);
        hash = 83 * hash + Objects.hashCode(this.userMail);
        hash = 83 * hash + Objects.hashCode(this.userPassword);
        hash = 83 * hash + Objects.hashCode(this.userImage);
        hash = 83 * hash + Objects.hashCode(this.roles);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.pseudoName, other.pseudoName)) {
            return false;
        }
        if (!Objects.equals(this.userMail, other.userMail)) {
            return false;
        }
        if (!Objects.equals(this.userPassword, other.userPassword)) {
            return false;
        }
        if (!Objects.equals(this.userImage, other.userImage)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

   

}
