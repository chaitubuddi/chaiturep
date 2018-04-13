package practicePgms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapGenaric {
	public static void main(String[] args) {
		
	
Map<Integer,String> map=new HashMap();
map.put(101, "sagar");
map.put(104, "sagar");
map.put(102, "chaitu");
map.put(103, "kiran");
for(Map.Entry<Integer, String> m :map.entrySet())
{
	System.out.println(m.getKey()+""+m.getValue());
}
}
	}
