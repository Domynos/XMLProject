package XML_Project2;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class Xml_utils {
	String fileLocation;

	static void readConfigFile(String fileLocation) throws SAXException, IOException
	{
		try{
			DOMParser parser = new DOMParser();
			//decommenter quand la dtd sera faite
			//Validation du fichier XML
			//parser.setFeature("", true);
			//permet d'enlever les espaces et retours chariots
			//parser.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);
            parser.parse(fileLocation);
            Document doc = parser.getDocument();
        	DocumentTraversal dot =(DocumentTraversal)doc;
    		Element e = (Element)doc.getLastChild();
    		NodeList adapters = e.getElementsByTagName("adapters");
    		NodeList sources = e.getElementsByTagName("sources");
        	printNode(adapters);
        	printNode(sources);
        	
		}catch(Exception e)
		{
			System.out.println("Problème de parsage du fichier : "+e);
		}
	}
	static void printNode(NodeList nl)
	{

	}
	void refreshXmlFile()
	{
		
	}
}
