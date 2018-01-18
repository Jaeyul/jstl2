package conf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExam {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("key1","value1");
		
		Iterator<String> it = map.keySet().iterator();
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		
	}
}
