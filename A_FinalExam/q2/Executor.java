import java.io.File;
import java.util.LinkedList;
import java.util.List;

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

public class Executor {

	private final List<Command> commands;

	private final DataBase db = DataBase.getInstance();

	public Executor(List<Command> commands) {
		this.commands = commands;
	}

	public void execute() {
		for (Command c : this.commands) {
			if (c instanceof RetrieveCommand) {
				retrieveFrom((RetrieveCommand) c);
			} else if (c instanceof StoreCommand) {
				storeTo((StoreCommand) c);
			}
		}
	}

	/**
	 * store the employees from the database to the xml file
	 *
	 * @param sac
	 */
	private void storeTo(StoreCommand sac) {

		List<Employee> employees = this.db.load(sac.getKey());

		File f = new File(sac.getFileName());
		if (f.exists()) {
			f.delete();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########
			Element rootElement = doc.createElement("employees");
			doc.appendChild(rootElement);
			for (Employee employee:employees){
				Element employeeEle = doc.createElement("employee");
				Element nameEle = doc.createElement("name");
				nameEle.appendChild(doc.createTextNode(employee.getName()));
				Element genderEle = doc.createElement("gender");
				genderEle.appendChild(doc.createTextNode(employee.getGender()));
				Element salaryEle = doc.createElement("salary");
				salaryEle.appendChild(doc.createTextNode(employee.getSalary()+""));
				Element departmentEle = doc.createElement("department");
				departmentEle.appendChild(doc.createTextNode(employee.getDepartment()));
				employeeEle.appendChild(nameEle);
				employeeEle.appendChild(genderEle);
				employeeEle.appendChild(salaryEle);
				employeeEle.appendChild(departmentEle);

				rootElement.appendChild(employeeEle);
			}
			// ########## YOUR CODE ENDS HERE ##########

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

			// INDENT the xml file is optional, you can
			// uncomment the following statement if you would like the xml files to be more
			// readable
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * retrieve the employees from the xml file into the database
	 *
	 * @param lc
	 */
	private void retrieveFrom(RetrieveCommand lc) {

		List<Employee> employees = new LinkedList<>();

		File f = new File(lc.getFileName());
		if (!f.exists()) {
			return;
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);

			doc.getDocumentElement().normalize();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########
			NodeList nl = doc.getElementsByTagName("employee");
			for(int i = 0; i < nl.getLength(); i++){
				Node n = nl.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) n;
					String name = element.getElementsByTagName("name").item(0).getTextContent();
					String gender = element.getElementsByTagName("gender").item(0).getTextContent();
					String salary = element.getElementsByTagName("salary").item(0).getTextContent();
					String department = element.getElementsByTagName("department").item(0).getTextContent();
					employees.add(new Employee(name, gender, Integer.parseInt(salary), department));
				}
			}
			// ########## YOUR CODE ENDS HERE ##########

			this.db.save(lc.getKey(), employees);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Command> getCommands() {
		return commands;
	}
}
