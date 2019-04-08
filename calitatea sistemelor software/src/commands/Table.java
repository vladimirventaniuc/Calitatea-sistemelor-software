package commands;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Table {
    private String projectPath = Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\";

    public boolean createTable(String databaseName, String tableName, HashMap<String, String> fields) {
        System.out.println("A intrat");
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element tableInfo = doc.createElement("Table");
            doc.appendChild(tableInfo);

            // staff elements
            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode(tableName));
            tableInfo.appendChild(name);
            Element numberOfFields = doc.createElement("NumberOfFields");
            numberOfFields.appendChild(doc.createTextNode(String.valueOf(fields.size())));
            tableInfo.appendChild(numberOfFields);
            // set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");

            Element tableFields = doc.createElement("Fields");

            for (Map.Entry<String, String> entry : fields.entrySet()) {
                Element el = doc.createElement(entry.getKey());
                el.appendChild(doc.createTextNode(entry.getValue()));
                tableFields.appendChild(el);
            }
            tableInfo.appendChild(tableFields);

            Element entryes = doc.createElement("Entryes");
            tableInfo.appendChild(entryes);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(projectPath + databaseName + "/" + tableName + ".xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return true;
    }

    public void insertRecord(String databaseName, String tableName, ArrayList<String> entry) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            try {
                Document document = documentBuilder.parse(projectPath + databaseName + "/" + tableName + ".xml");
                Element root = document.getDocumentElement();
                NodeList fields = root.getElementsByTagName("Fields");
                NodeList nodeList = document.getElementsByTagName("Fields");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node e = nodeList.item(i);
                    System.out.println(e.getAttributes());
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
