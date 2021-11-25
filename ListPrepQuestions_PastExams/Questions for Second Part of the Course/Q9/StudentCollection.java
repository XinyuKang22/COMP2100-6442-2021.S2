import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nanwang
 *
The goal of this task is to write a program that loads/stores a list of students in XML format. `StudentCollection.java` class contains
a list of `Student` instances. Each student has his/her `age` and `name`, which need to be saved as attributes of XML node. Additionally,
each student can have three possible properties: `height`, `weight` and `courses`. `courses` property contains a list of `course` elements.
Each course has a course `name` attribute and a `grade` value. Note that not every student has all three properties. Some properties of students may be missing
(for example, see the test cases in StudentsTest.java). You job is to implement the below two methods in `StudentCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given student. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `StudentCollection.java` to wattle!**
 */
public class StudentCollection {

	private final List<Student> students;

	public StudentCollection(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Implement this method to save the list of students to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `name` and `age` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUR CODE
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();

			Element rootElement = d.createElement("StudentCollection");
			d.appendChild(rootElement);
			for(Student student : students)
			{
				Element studentElement = d.createElement("Student");
				studentElement.setAttribute("name", student.getName());
				studentElement.setAttribute("age", (student.getAge() == null) ? "":student.getAge().toString());
				studentElement.setAttribute("height", (student.getHeight() == null) ? "":student.getHeight().toString());
				studentElement.setAttribute("weight", (student.getWeight() == null) ? "":student.getWeight().toString());

				Element coursesElement = d.createElement("courses");
				if (student.getCourses() != null){
					for (Course course:student.getCourses()){
						Element courseEle = d.createElement("Course");
						courseEle.setAttribute("name", course.getName());
						courseEle.setAttribute("grade", course.getGrade().toString());
						coursesElement.appendChild(courseEle);
					}
					studentElement.appendChild(coursesElement);
				}

				rootElement.appendChild(studentElement);
			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(d);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//END YOUR CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `StudentCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `name` and `age` properties
	 * @param file
	 * @return
	 */
	public static StudentCollection loadFromFile(File file) {
		//START YOUR CODE
		List<Student> studentsNew = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(file);
			d.getDocumentElement().normalize();

			NodeList nl = d.getElementsByTagName("Student");
			for(int i = 0; i < nl.getLength(); i++) {
				Student student = new Student();
				Node n = nl.item(i);
				if(n.getNodeType() == Node.ELEMENT_NODE) {
					Element studentElement		= (Element) n;
					student.withName(studentElement.getAttribute("name"));
					if (!studentElement.getAttribute("age").equals("")) student.withAge(Integer.parseInt(studentElement.getAttribute("age")));
					if (!studentElement.getAttribute("height").equals("")) student.withHeight(Integer.parseInt(studentElement.getAttribute("height")));
					if (!studentElement.getAttribute("weight").equals("")) student.withWeight(Integer.parseInt(studentElement.getAttribute("weight")));

					NodeList courseNL = studentElement.getElementsByTagName("Course");
					for (int j = 0; j < courseNL.getLength(); j++){
						Node node = courseNL.item(j);
						if (node.getNodeType() == Node.ELEMENT_NODE){
							Element course = (Element) node;
							String courseName = course.getAttribute("name");
							Integer grade = Integer.parseInt(course.getAttribute("grade"));
							student.addCourse(new Course(courseName, grade));
						}
					}

					studentsNew.add(student);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new StudentCollection(studentsNew);
		//END YOUR CODE
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof StudentCollection) {
			StudentCollection studentCollection = (StudentCollection) o;
			return this.students.equals(studentCollection.students);
		}

		return false;
	}

	@Override
	public String toString() {
		return "StudentCollection{" +
				"students=" + students +
				'}';
	}
}
