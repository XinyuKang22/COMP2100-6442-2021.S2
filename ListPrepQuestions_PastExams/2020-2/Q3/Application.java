
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;


public class Application {

	public RBTree<Integer, Person> createTree(List<Person> personList) {

		RBTree<Integer, Person> tree = new RBTree<>();

		// ########## YOUR CODE STARTS HERE ##########
		if (personList == null) return tree;
		for (Person person:personList){
			tree.insert(person.id, person);
		}
		// ########## YOUR CODE ENDS HERE ##########

		return tree;
	}

	public List<Person> readCsv(String fileName) {

		List<Person> list = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				int id = Integer.parseInt(values[0]);
				String name = values[1];
				int age = Integer.parseInt(values[2]);
				String occupation = values[3];
				//System.out.println(id+" "+name+" "+age+" "+occupation);
				list.add(new Person(id, name, age, occupation));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

	public void saveXML(RBTree<Integer, Person> tree) {

		if (tree == null) {
			return;
		}

		List<Node> list = tree.levelTraversal();

		// ########## YOUR CODE STARTS HERE ##########
		File f = new File("people.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
			Document d = db.newDocument(); //obtain new instance of a DOM document

			Element rootElement = d.createElement("people");
			d.appendChild(rootElement);

			for (Node<Integer,Person> node:list){
				Element personElement = d.createElement("person");
				Element idElement = d.createElement("id");
				idElement.appendChild(d.createTextNode(node.getData().getId().toString()));
				Element nameElement = d.createElement("name");
				nameElement.appendChild(d.createTextNode(node.getData().getName()));
				Element ageElement = d.createElement("age");
				ageElement.appendChild(d.createTextNode(node.getData().getAge().toString()));
				Element occupationElement = d.createElement("occupation");
				occupationElement.appendChild(d.createTextNode(node.getData().getOccupation()));

				personElement.appendChild(idElement);
				personElement.appendChild(nameElement);
				personElement.appendChild(ageElement);
				personElement.appendChild(occupationElement);

				rootElement.appendChild(personElement);
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

			DOMSource source = new DOMSource(d); //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
			StreamResult result = new StreamResult(f);//Acts as a holder for a transformation result, which may be XML,..
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ########## YOUR CODE ENDS HERE ##########
	}

}
