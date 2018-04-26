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
public class Handphone {
    String hp_id, hp_name, hp_type;
   Date hp_prod_date;
   
   public String gethp_id() {
        return hp_id;
    }
    public void sethp_id(String hp_id) {
        this.hp_id = hp_id;
    }
    public String gethp_name() {
        return hp_name;
    }
    public void sethp_name(String hp_name) {
        this.hp_name = hp_name;
    }
    public String gethp_type() {
        return hp_type;
    }
    public void sethp_type(String hp_type) {
        this.hp_type = hp_type;
    }
    public Date gethp_prod_date() {
        return hp_prod_date;
    }
    public void sethp_prod_date(Date hp_prod_date) {
        this.hp_prod_date = hp_prod_date;
    }
}
