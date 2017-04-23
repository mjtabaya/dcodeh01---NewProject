package utility;

import java.util.HashMap;
import java.util.Map;

public class CodeTranslator {
	static final int totalProducts = 9;
	
	private static final Map<String, String> productMap = new HashMap<String, String>();
	static
	{
		getProductmap().put("01", "P1");
		getProductmap().put("02", "P2");
		getProductmap().put("03", "P3");
		getProductmap().put("04", "E1");
		getProductmap().put("05", "E2");
		getProductmap().put("06", "E3");
		getProductmap().put("07", "T1");
		getProductmap().put("08", "T2");
		getProductmap().put("09", "T3");
	}
	public static Map<String, String> getProductmap() {
		return productMap;
	}


}
