package pjv.hello.vasylnaz.xml_task.parser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pjv.hello.vasylnaz.xml_task.entity.Village;
import pjv.hello.vasylnaz.xml_task.entity.VillagePart;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlParser {

    public record ParsedData(List<Village> villages, List<VillagePart> villageParts) {}

    public ParsedData parse(InputStream xmlStream) throws Exception {
        List<Village> villages = new ArrayList<>();
        List<VillagePart> villageParts = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlStream);
        document.getDocumentElement().normalize();

        ///  Villages
        NodeList villageNodes = document.getElementsByTagName("vf:Obec");
        for (int i = 0; i < villageNodes.getLength(); i++) {
            if (villageNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) villageNodes.item(i);
                Village village = new Village();
                village.setId(Long.parseLong(element.getElementsByTagName("obi:Kod").item(0).getTextContent().trim()));
                village.setName(element.getElementsByTagName("obi:Nazev").item(0).getTextContent());
                villages.add(village);
            }
        }

        /// VillageParts
        NodeList partNodes = document.getElementsByTagName("vf:CastObce");
        for (int i = 0; i < partNodes.getLength(); i++) {
            if (partNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) partNodes.item(i);
                VillagePart villagePart = new VillagePart();
                villagePart.setId(Long.parseLong(element.getElementsByTagName("coi:Kod").item(0).getTextContent().trim()));
                villagePart.setName(element.getElementsByTagName("coi:Nazev").item(0).getTextContent());

                String parentVillageIdStr = element.getElementsByTagName("obi:Kod").item(0).getTextContent().trim();
                villagePart.setVillageId(Long.parseLong(parentVillageIdStr));

                villageParts.add(villagePart);
            }
        }

        return new ParsedData(villages, villageParts);
    }
}