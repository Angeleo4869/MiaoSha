package com.leo.admin.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leo
 */
@Getter
@Setter
public class MsaUser {

    private Long id;
    private String account;
    private String password;

    public MsaUser(){

    }

    public  MsaUser(String account, String password){
        this.account = account;
        this.password = password;
    }
    @Override
    public String toString(){
        return account + "," + password;
    }

}
