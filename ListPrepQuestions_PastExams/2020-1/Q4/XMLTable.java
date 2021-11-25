import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Save() method is already given. Please implement load() method to load XML
 * files and insert() method to insert a new customer to XML files.
 * 
 * Each customer must have an ID value, but may not have all the following column values:
 * Name, Address, City, Postcode, Country. Please see test cases in XMLTableTest.java.
 * 
 */
public class XMLTable {

	/**
	 * Save all records to the XML file
	 */
	public void save(String tableName, List<Customer> customers) {

		File f = new File(FileUtil.getTableFileName(tableName));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// make the xml tree
			// use factory to get the instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			// Root element <customers>
			Element rootElem = doc.createElement(Customer.KEY_ROOT);
			doc.appendChild(rootElem);

			for (Customer customer : customers) {
				Element customerElem = doc.createElement(Customer.KEY_ELEMENT);
				rootElem.appendChild(customerElem);

				// child element <ID> under <customer>
				Element cid = doc.createElement(Customer.KEY_ID);
				cid.appendChild(doc.createTextNode(Integer.toString(customer.getId())));
				customerElem.appendChild(cid);

				if (customer.getName() != null) {
					Element name = doc.createElement(Customer.KEY_NAME);
					name.appendChild(doc.createTextNode(customer.getName()));
					customerElem.appendChild(name);
				}

				if (customer.getAddress() != null) {
					Element address = doc.createElement(Customer.KEY_ADDRESS);
					address.appendChild(doc.createTextNode(customer.getAddress()));
					customerElem.appendChild(address);
				}

				if (customer.getCity() != null) {
					Element city = doc.createElement(Customer.KEY_CITY);
					city.appendChild(doc.createTextNode(customer.getCity()));
					customerElem.appendChild(city);
				}

				if (customer.getPostCode() != null) {
					Element postCode = doc.createElement(Customer.KEY_POSTCODE);
					postCode.appendChild(doc.createTextNode(customer.getPostCode()));
					customerElem.appendChild(postCode);
				}

				if (customer.getCountry() != null) {
					Element country = doc.createElement(Customer.KEY_COUNTRY);
					country.appendChild(doc.createTextNode(customer.getCountry()));
					customerElem.appendChild(country);
				}
			}
			// save the xml file
			// Transformer is for process XML from a variety of sources and write the
			// transformation
			// output to a variety of sinks
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			// set xml encoding to utf-8
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			// pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all records from the XML file
	 */
	public List<Customer> load(String tableName) {

		List<Customer> customers = new ArrayList<>();

		File f = new File(FileUtil.getTableFileName(tableName));
		if (!f.exists()) {
			return customers;
		}

		// TODO: Complete this method
		// START YOUR CODE
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(f); //parse file f, it is the root of the document tree
			d.getDocumentElement().normalize();
			Node customersEle = d.getFirstChild();
			NodeList nl = customersEle.getChildNodes();

			for(int i = 0; i < nl.getLength(); i++)
			{
				Node n = nl.item(i);

				if(n.getNodeType() == Node.ELEMENT_NODE) {
					Element element		= (Element) n;
					String name = null;
					String address = null;
					String city = null;
					String postcode = null;
					String country = null;

					int id = Integer.parseInt(element.getElementsByTagName(Customer.KEY_ID).item(0).getTextContent());
					if (element.getElementsByTagName(Customer.KEY_NAME).item(0) != null){
						name = element.getElementsByTagName(Customer.KEY_NAME).item(0).getTextContent();
						if (Objects.equals(name, "null")) name = null;
					}
					if (element.getElementsByTagName(Customer.KEY_ADDRESS).item(0) != null){
						address = element.getElementsByTagName(Customer.KEY_ADDRESS).item(0).getTextContent();
						if (Objects.equals(address, "null")) address = null;
					}
					if (element.getElementsByTagName(Customer.KEY_CITY).item(0) != null){
						city = element.getElementsByTagName(Customer.KEY_CITY).item(0).getTextContent();
						if (Objects.equals(city, "null")) city = null;
					}
					if (element.getElementsByTagName(Customer.KEY_POSTCODE).item(0) != null){
						postcode = element.getElementsByTagName(Customer.KEY_POSTCODE).item(0).getTextContent();
						if (Objects.equals(postcode, "null")) postcode = null;
					}
					if (element.getElementsByTagName(Customer.KEY_COUNTRY).item(0) != null){
						country = element.getElementsByTagName(Customer.KEY_COUNTRY).item(0).getTextContent();
						if (Objects.equals(country, "null")) country = null;
					}
					Customer customer = new Customer(id, name, address, city, postcode, country);
					customers.add(customer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// END YOUR CODE

		return customers;
	}

	/**
	 * Insert a new customer to XML files. 
	 * 
	 *
	 */
	public void insert(String tableName, Customer customer) {
		
		// TODO: Complete this method
		// START YOU CODE
		// HINT: insert the given customer to the XML file.
		// You can call the load() and save() methods
		List<Customer> customers = load(tableName);
		customers.add(customer);
		save(tableName, customers);

		
		// END YOUR CODE
	}
}
