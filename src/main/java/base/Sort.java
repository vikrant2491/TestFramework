package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import cucumber.deps.com.thoughtworks.xstream.io.xml.CompactWriter;

public class Sort {
	
	static class comp implements Comparator<Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
			if(entry1.getValue()>entry2.getValue())
				return 1;
			else if(entry1.getValue()<entry2.getValue())
				return -1;
			else
				return 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		comp c = new comp();
		Map<String, Integer> input = new HashMap<String, Integer>();
		input.put("Math", 98);
		input.put("Data Structure", 85);
		input.put("Database", 91);
		input.put("Java", 95);
		input.put("OS", 79);
		System.out.println("Input is: "+input);		
		
		List<Entry<String, Integer>> list = new ArrayList<>();
		for(Entry<String, Integer> en: input.entrySet()){
			list.add(en);
		}
		Collections.sort(list, c);
		System.out.println("output is: "+list);
	}
	
	

}


