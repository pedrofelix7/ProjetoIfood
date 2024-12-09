package Entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig {

    private static Properties properties = new Properties();

    static {
        File envFile = new File("C:\\Users\\pedro\\IdeaProjects\\proto_Ifood\\.env");
        if(!envFile.exists()){
            throw new RuntimeException("Arquivo .env não encontrado no diretório: " + envFile.getAbsolutePath());
        }
        try {
            properties.load(new FileInputStream(envFile));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String key(String key){
            return properties.getProperty(key);
    }

}