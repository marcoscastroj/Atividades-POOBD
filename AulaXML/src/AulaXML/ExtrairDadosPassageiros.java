package AulaXML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtrairDadosPassageiros {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("passageiros.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            NodeList passageiros = doc.getElementsByTagName("passageiro");
            int numPassageiros = passageiros.getLength();
            
            System.out.println("Número de passageiros: " + numPassageiros);
            
            System.out.println("Origens e destinos:");
            for (int i = 0; i < numPassageiros; i++) {
                Element passageiro = (Element) passageiros.item(i);
                String origem = passageiro.getElementsByTagName("origem").item(0).getTextContent();
                String destino = passageiro.getElementsByTagName("destino").item(0).getTextContent();
                
                System.out.println("Passageiro " + (i + 1) + ": Origem - " + origem + ", Destino - " + destino);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}