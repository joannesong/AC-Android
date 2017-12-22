
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;

public class ObjectSerializationExample {

    @XmlRootElement
    public static class  Car implements Serializable {
        @XmlElement
        public String name = "Mercedes Benz";
        @XmlElement
        public int mileage = 2000;
        @XmlAttribute
        public String model = "C-class";
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();

        // marshall the object
        JAXBContext ctx = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // write it to a stream
        StringWriter writer = new StringWriter();
        marshaller.marshal(car, writer);
        writer.close();

        // print to console (could be to a file)
        System.out.println(writer.toString());


        // Read it back
        JAXBContext readCtx = JAXBContext.newInstance(Car.class);
        Unmarshaller unmarshaller = readCtx.createUnmarshaller();

        Car carReadBack = (Car) unmarshaller.unmarshal(new StringReader(writer.toString()));
        System.out.println(carReadBack.name);
    }
}