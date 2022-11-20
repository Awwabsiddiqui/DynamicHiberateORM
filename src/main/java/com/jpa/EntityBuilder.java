package com.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EntityBuilder {
    public static void entBuilder(String tableName, String cols) throws IOException {
        File myFoo = new File("src/main/java/com/jpa/entity/Ent.java");
        FileWriter fooWriter = new FileWriter(myFoo, false);
//        String ip = "int,id,String,name,int,age,String,emailId,String,value";
        String[] arr = cols.split(",");

        StringBuffer sb = new StringBuffer("package com.jpa.entity;\n" +
                "\n" +
                "import lombok.AllArgsConstructor;\n" +
                "import lombok.Builder;\n" +
                "import lombok.Data;\n" +
                "import lombok.NoArgsConstructor;\n" +
                "\n" +
                "import javax.persistence.*;\n" +
                "\n" +
                "@Entity\n" +
                "@Data\n" +
                "@AllArgsConstructor\n" +
                "@NoArgsConstructor\n" +
                "@Builder\n" +
                "@Table(name = \""+tableName+"\")\n" +
                "public class Ent {\n" +
                "\n" +
                "    @Id\n");
        for (int i=0 ; i< arr.length-1 ; i+=2){
            sb.append("private "+arr[i]+" "+arr[i+1]+";\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
        fooWriter.write(sb.toString());
        fooWriter.close();
            System.out.println("done");
    }
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
}
