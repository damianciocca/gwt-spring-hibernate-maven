package au.com.uptick.gwt.maven.sample.test.stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestLogAnalyst {
	
	public static void main(String[] args) {
		
		List<LogEntry> list = new ArrayList<LogEntry>();
		
		list.add(new LogEntry(120, "getFoo", true));
		
		list.add(new LogEntry(121, "getMax", true));
		list.add(new LogEntry(124, "getMax", false));
		
		list.add(new LogEntry(128, "getMin", true));
		list.add(new LogEntry(130, "getMin", true));
		list.add(new LogEntry(132, "getMin", false));
		list.add(new LogEntry(137, "getMin", false));
		
		list.add(new LogEntry(150, "getSum", true));
		list.add(new LogEntry(155, "getZum", true));
		list.add(new LogEntry(161, "getZum", false));
		list.add(new LogEntry(170, "getSum", false));
				
		list.add(new LogEntry(230, "getFoo", false));
		
//		Esto agreguenlo despues	para probar
//		list.add(new LogEntry(250, "getMin", true));
//		list.add(new LogEntry(251, "getMin", false));
		
		// getFoo = 1+4+13+60 = 78
		// getMax = 3
		// getMin = 2+2+5 = 9
		// getZum = 6
		// getSum = 5+9 = 14
		
		LogAnalyst logAnalyst = new LogAnalyst();
		
		Map<String, Integer> map = logAnalyst.getAnalizedData(list);
		for (String key : map.keySet())
			System.out.println(key + ": " + map.get(key));
		
	}
}
