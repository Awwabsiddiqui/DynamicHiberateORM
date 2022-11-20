package com.jpa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class appPropertiesBuilder {
    public static void appPropertiesMAker(String schemaName, String username, String password) throws IOException {
        File myFoo = new File("src/main/resources/application.properties");
        FileWriter fooWriter = new FileWriter(myFoo, false);
        fooWriter.write("spring.jpa.hibernate.ddl-auto=update\n" +
                "spring.datasource.url=jdbc:mysql://localhost:3306/"+schemaName+"\n" +
                "spring.datasource.username="+username+"\n" +
                "spring.datasource.password="+password+"\n" +
                "spring.datasource.driver-class-name =com.mysql.jdbc.Driver\n" +
                "spring.jpa.show-sql: true\n");
        fooWriter.close();
            System.out.println("done");
    }
}
