package XML_Project2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class Xml_utils {
	String fileLocation;

	static Document createXmlConfigDoc() throws ParserConfigurationException
	{
		//Recuperes les Adapters de l'IHM
		ArrayList<String> adaptersName = new ArrayList();
		ArrayList<String> sourcesName = new ArrayList();
		adaptersName = MainWindow.getWindowAdpaters();
		sourcesName = MainWindow.getWindowSources();
		//Creation document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder DocBuilder = factory.newDocumentBuilder();
		Document doc = DocBuilder.newDocument();
		//Nouvel element racine
		Element root = doc.createElement("Simulation");
		root.setAttribute("lang", "fr");
		doc.appendChild(root);
		//Element adapters
		Element adapters = doc.createElement("Adapteurs");
		for(int i = 0; i<adaptersName.size(); i++ )
		{
			Element adapter = doc.createElement("Adapteur");
			adapter.setAttribute("name", adaptersName.get(i));
			adapters.appendChild(adapter);
		}
		root.appendChild(adapters);
		//Element sources 
		Element sources = doc.createElement("Sources");
		for(int i = 0; i<sourcesName.size(); i++)
		{
			Element source = doc.createElement("Source");
			source.setAttribute("name", sourcesName.get(i));
			sources.appendChild(source);
		}
		root.appendChild(sources);
		//Element XML
		Element xml = doc.createElement("Xml");
		root.appendChild(xml);
		return doc;
	}
	static void writeXmlFile(Document doc, String fileName)
	{
		//Creation du fichier
		Source documentSource =  new DOMSource(doc);
		Result resultat = new StreamResult(new File(fileName));
		//Creation du transphormateur XML
		Transformer transfo = null;
		try{
			transfo = TransformerFactory.newInstance().newTransformer();
		}catch(TransformerConfigurationException e){
			System.err.println("Impossible de créer un transformateur XML.");
            System.exit(1);
		}
		// configuration du transformateur   
        // sortie en XML
        transfo.setOutputProperty(OutputKeys.METHOD, "xml");
        // inclut une déclaration XML (recommandé)
        transfo.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); 
        // codage des caractères : UTF-8. Ce pourrait être également ISO-8859-1
        transfo.setOutputProperty(OutputKeys.ENCODING, "utf-8"); 
        // idente le fichier XML
        transfo.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transfo.transform(documentSource, resultat);
        } catch(TransformerException e) {
            System.err.println("La transformation a échoué : " + e);
            System.exit(1);
        }
	}
	static void loadXmlConfigFile(String fileLocation) throws ParserConfigurationException, SAXException, IOException
	{
		//Creation document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder DocBuilder = factory.newDocumentBuilder();
		try{
			Document doc = DocBuilder.parse(new File(fileLocation));
			NodeList root = doc.getElementsByTagName("Simulation");
			NodeList adapters = doc.getElementsByTagName("Adapteurs");
			NodeList sources = doc.getElementsByTagName("Sources");
			if(null == root || null == adapters || null == sources)
			{
				JOptionPane.showInputDialog("Impossible de charger la configuration, fichier mal formé");
			}else
			{
				if(adapters.item(0).hasChildNodes())
				{
					System.out.println("Adapters");
					NodeList adapterschilds = adapters.item(0).getChildNodes();
					for(int i = 0 ; adapterschilds.item(i) != null ; i++)
					{
						NamedNodeMap map = adapterschilds.item(i).getAttributes();
						if(map != null)
						{
							String adapterName = map.getNamedItem("name").toString();
							//Parsing du name
							adapterName = adapterName.substring(adapterName.indexOf('"')+1, adapterName.lastIndexOf('"'));
							System.out.println(adapterName);
							MainWindow.addElementByLoad(adapterName, "adapters");
						}
					}
					
				}
				if(sources.item(0).hasChildNodes())
				{
					System.out.println("Sources");
					NodeList sourceschilds = sources.item(0).getChildNodes();
					for(int i = 0 ; sourceschilds.item(i)!= null ; i++)
					{
						NamedNodeMap map = sourceschilds.item(i).getAttributes();
						if(map != null)
						{
							String sourceName = map.getNamedItem("name").toString();
							//Parsing du name
							sourceName = sourceName.substring(sourceName.indexOf('"')+1, sourceName.lastIndexOf('"'));
							System.out.println(sourceName);
							MainWindow.addElementByLoad(sourceName, "sources");
						}
					}
				}
			}
		}catch(SAXException s)
		{
			JOptionPane.showInputDialog("Erreur de parsing du fichier");
		}catch(IOException e)
		{
			JOptionPane.showInputDialog("Erreur d'accès au fichier");
		}

		
	}
	static void readConfigFile(String fileLocation) throws SAXException, IOException
	{

	}
}
