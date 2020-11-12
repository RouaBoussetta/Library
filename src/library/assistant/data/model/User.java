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
       private String username;
 
    private String email;
    private String password;
    private String roles;
    
    
    
    private String userName;
    private String lastname;
    private String pseudoName;
    private String userMail;
    private String userPassword;
    private String userImage;


    public User(int id, String username, String email, String password,String roles, String userName, String lastname, String pseudoName, String userMail, String userPassword, String userPhoto) {
        this.id = id;
        this.username = username;
      
        this.email = email;
       
        this.password = password;
        
        this.roles = roles;
        this.userName = userName;
        this.lastname = lastname;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userImage=userImage;
    }

                                                                     
 
                                                           
                                                                     
       public User(){
       };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.roles);
        hash = 97 * hash + Objects.hashCode(this.userName);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.pseudoName);
        hash = 97 * hash + Objects.hashCode(this.userMail);
        hash = 97 * hash + Objects.hashCode(this.userPassword);
        hash = 97 * hash + Objects.hashCode(this.userImage);
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
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
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
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", roles=" + roles + ", userName=" + userName + ", lastname=" + lastname + ", pseudoName=" + pseudoName + ", userMail=" + userMail + ", userPassword=" + userPassword + ", userImage=" + userImage + '}';
    }

  
       
                                 
}
