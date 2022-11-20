package com.jpa;

import com.jpa.entity.Ent;
import com.jpa.entity.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class meths {

    @Autowired
    private static Repository Repository;


    public String print() {
        List<Ent> ls = Repository.findAll();
        System.out.println("LIST = " + ls.toString());
        return ls.toString();
    }
}
