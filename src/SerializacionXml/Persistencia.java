package SerializacionXml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Persistencia {


    public void XmlSerializacion(String nombre, Object object) throws FileNotFoundException{
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(nombre));
        encoder.writeObject(object);
        encoder.close();
    }

    public Object xmlDeserializar(String nombre) throws FileNotFoundException{

        XMLDecoder XD = new XMLDecoder(new FileInputStream(nombre));
        Object ob = XD.readObject();
        XD.close();

        return ob;
    }
}
