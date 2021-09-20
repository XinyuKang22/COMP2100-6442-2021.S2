import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlActionReport extends ActionReport{
    @Override
    public List<UserActivity> parseFileContent(String rawData) {
        List<UserActivity> userActivityList = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(rawData));
            Document doc = db.parse(is);
            Element root = doc.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("action");
            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node n = nodeList.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element elem = (Element) n;
                    String username = elem.getAttribute("usernmame");
                    String actionName = elem.getAttribute("actionName");
                    String content = elem.getAttribute("content");
                    Integer id = Integer.parseInt(elem.getAttribute("id"));
                    UserActivity userActivity = new UserActivity(username, actionName,
                            content, id);
                    userActivityList.add(userActivity);
                }
            }
        } catch (ParserConfigurationException e) {e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        } catch (SAXException e) { e.printStackTrace();
        }
        return userActivityList;
    }
}
