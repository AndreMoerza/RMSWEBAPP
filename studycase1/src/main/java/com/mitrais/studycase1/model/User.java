/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.studycase1.model;

import java.util.Date;
/**
 *
 * @author Andre_P772
 */
public class User {
    String uname, password, email;
   Date registerdate;
   
   public String getuname() {
        return uname;
    }
    public void setuname(String uname) {
        this.uname = uname;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public Date getregisterdate() {
        return registerdate;
    }
    public void setregisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }
}
