package SerializacionXml;

import java.io.FileNotFoundException;

public class SerializacionXml {

    public static void main(String[] args) {
        System.out.println("XD");

        Persistencia files = new Persistencia();

        Persona p; // = new SerializacionXml.Persona("Lisa","Jimenez","1094");

        //files.XmlSerializacion("persona.xml",p);

        try {
            p= (Persona) files.XmlDeserializable("persona.xml");
            System.out.println(p.getNombre() + " " + p.getApellido());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
