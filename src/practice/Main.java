package practice;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("./src/practice/candies.xml");

        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        CandyHelper candyHelper = new CandyHelper();

        int id = 0;
        String name = "";
        int weight = 0;
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {
                        case "id":
                            id = Integer.parseInt(xmlStreamReader.getElementText());
                            System.out.println("Id: " + id);
                            break;
                        case "name":
                            name = xmlStreamReader.getElementText();
                            System.out.println("Name: " + name);
                            break;
                        case "weight":
                            weight = Integer.parseInt(xmlStreamReader.getElementText());
                            System.out.println("Weight: " + weight + "\n");
                            candyHelper.addCandy(new Candy(id, name, weight));
                    }
                    break;

                case XMLStreamReader.END_ELEMENT:
                    break;
            }
        }

        for (Candy item : candyHelper.getCandyList()){
            System.out.println(item);
        }
    }
}
