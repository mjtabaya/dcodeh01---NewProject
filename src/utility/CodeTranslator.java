package utility;

import java.util.HashMap;
import java.util.Map;

public class CodeTranslator {
	static final int totalProducts = 9;
	
	static final Map<String, String> productMap = new HashMap<String, String>();
	static
	{
		productMap.put("01", "P1");
		productMap.put("02", "P2");
		productMap.put("03", "P3");
		productMap.put("04", "E1");
		productMap.put("05", "E2");
		productMap.put("06", "E3");
		productMap.put("07", "T1");
		productMap.put("08", "T2");
		productMap.put("09", "T3");
	}


}
