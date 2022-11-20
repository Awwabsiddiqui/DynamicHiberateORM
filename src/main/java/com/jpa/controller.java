package com.jpa;

import com.jpa.entity.Ent;
import com.jpa.entity.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class controller {
    @Autowired
    private Repository Repository;

    @GetMapping("/")
    public String[] homepage() {
        String[] arr = new String[]{"http://localhost:8080",
        		"http://localhost:8080/data",
        		"http://localhost:8080/config?"
        		+ "dbname=&"
        		+ "dbpass=&"
        		+ "schema=&"
        		+ "tableName=&"
        		+ "columnsCSV="
        };
        return arr;
    }

    @GetMapping("/data")
    public String allStudent() {
//        @RequestParam(value = "schema") String schema, @RequestParam(value = "table") String table,
//        @RequestParam(value = "dbname") String dbname, @RequestParam(value = "dbpass") String dbpass
        List<Ent> ls = Repository.findAll();
        System.out.println("LIST = " + ls);
        return ls.toString();
    }

//    @GetMapping("/single")
//    public String singleStuddent() {
////        @RequestParam(value = "schema") String schema, @RequestParam(value = "table") String table,
////        @RequestParam(value = "dbname") String dbname, @RequestParam(value = "dbpass") String dbpass
//        List<Ent> ls = Repository.findByName("awab");
//        System.out.println("LIST = " + ls);
//        return ls.toString();
//    }
    @GetMapping("/config")
    public String config(@RequestParam(value = "tableName") String tableName,
                             @RequestParam(value = "columnsCSV") String cols,
                             @RequestParam(value = "schema") String schema,
                             @RequestParam(value = "dbname") String dbname,
                             @RequestParam(value = "dbpass") String dbpass) throws IOException {
        appPropertiesBuilder.appPropertiesMAker(schema,dbname,dbpass);
        EntityBuilder.entBuilder(tableName,cols);
        return "appsDone";
    }
}
