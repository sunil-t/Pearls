package topcoder;

public class SSCalculator {
	public static final String REGEXP_CONSONANTS = "b|c|d|f|g|h|j|k|l|m|n|p|q|r|s|t|v|w|x|z";
	public static final String REGEXP_VOWELS = "a|e|i|o|u|y";
	
	public float claculateMaxSS(String inputLine) {
		String [] customers = inputLine.split(";")[0].split(",");
		String [] products = inputLine.split(";")[1].split(",");
		
		float maxSS = -1;
		for(String customer : customers) {
			for(String product : products) {
				float val = calculateSS(customer.toLowerCase(), product.toLowerCase());
				log(customer + " : " + product + " = " + val);
				if(val > maxSS) maxSS = val;
			}
		}
		System.out.println(maxSS);
		return maxSS;
	}
	
	public float calculateSS(String customer, String product) {
		customer = customer.replaceAll("\\s+", "");
		product = product.replaceAll("\\s+", "");
		
		float ss = 0;
		if (product.length() % 2 == 0) 
			ss = (float)(customer.replaceAll(REGEXP_CONSONANTS, "").length() * 1.5);
		else
			ss = (float)(customer.replaceAll(REGEXP_VOWELS, "").length());
		
		log("HCF (" + customer.length() + ", " + product.length() + ") = " + getHCF(customer.length(), product.length()));
		return (float)((getHCF(customer.length(), product.length()) > 1) ? ss*1.5 : ss);
	}
	
	public int getHCF(int a, int b) {
            if (b == 0) return a;
            else return getHCF(b, a % b);
	}
	
	public static void main (String [] args) {
		SSCalculator ssc = new SSCalculator();
		ssc.claculateMaxSS("Jeffery Lebowski,Walter Sobchak;Half Half,Colt MA");
	}
	
	public static void log(String str) {
		System.out.println(str);
	}
}
