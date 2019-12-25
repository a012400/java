package java_collections.collections_tools_class;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationTest {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("疯狂Java讲义");
		v.add("轻量级Java EE企业应用实战");
		Hashtable scores = new Hashtable();
		scores.put("语文", 78);
		scores.put("数学", 88);
		Enumeration em = v.elements();
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		Enumeration keyEm = scores.keys();
		while (keyEm.hasMoreElements()) {
			System.out.println(keyEm.nextElement());
		}
	}

}
