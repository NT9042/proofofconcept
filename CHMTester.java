package drivers;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

public class CHMTester {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
		chm.put("neha", "29");
		chm.put("karan", "31");
		chm.putIfAbsent("neha", "30");
		Enumeration<String> itr = chm.keys();
		while (itr.hasMoreElements()) {
			String key = (String) itr.nextElement();
			System.out.println(key + "s age is : " + chm.get(key));
		}
	}

}
