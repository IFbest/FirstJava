package kh0114;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.cha.go.kr/cha/SearchKindOpenapiList.do");
			InputStream stream = url.openStream(); // openStream 은 해당 url을 객체로 만들어준다
			char ch = 0;
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			
			// XML 문서의 구조대로 완성이 되는것이다.
			// XML 문서는 유일한 루트 엘리먼트를 가진다.
			// 이 메소드가 루트 엘리먼트를 구한다. 루트를 구해야 자식들을 읽을 수 있다.
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("row");
			// Document 인터페이스의 getElementsByTagName 메소드는 엘리먼트의 HTMLCollection과
			// 주어진 태그명을 반환합니다. 루트 노드를 포함해 전체 도큐먼트를 대상으로 검색됩니다.
			// 반환된 HTMLCollection은 살아있는데, 이는 document.getElementsByTagName() 을
			// 다시 호출하지 않아도 자동으로 업데이트 하여 DOM 트리와 동기화 된 상태를 유지함을 의미
			System.out.println("-----------------------");
			
			for (int temp=0; temp<nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					// 각 번호 이름 한자명 등 엘리먼트 객체를 출력
					System.out.println("문화재 번호 : " + getTagValue("MANAGE_NUM", eElement));
					System.out.println("문화재 이름 : " + getTagValue("NAME_KOR", eElement));
					System.out.println("문화재 한자명 : " + getTagValue("NAME_CNI", eElement));
					System.out.println("문화재 설명 : " + getTagValue("BOARD_KOR", eElement));
					System.out.println("문화재 크기 : " + getTagValue("SCALE", eElement));
					System.out.println();					
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
