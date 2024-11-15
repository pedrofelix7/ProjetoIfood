package Entities;

import java.io.*;

public class Serializable {

    public static void gravar(String caminho, Object object)
            throws FileNotFoundException, IOException {
        FileOutputStream outFile = new FileOutputStream(caminho);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(object);
        s.close();
    }

    public static Object ler(String caminho)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream inFile = new FileInputStream(caminho);
        ObjectInputStream s = new ObjectInputStream(inFile);
        Object object = s.readObject();
        s.close();
        return object;
    }
}
