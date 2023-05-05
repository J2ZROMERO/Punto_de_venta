package metodos_personalizados;

import java.text.DecimalFormat;

public class Metodos_numericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		double num = 100.000;
	    String result = Metodos_numericos.convierteAkilogramos(num);
	    System.out.print(result);
		 	}
	
	public static double convierteAdecimal(double double_number) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		return Double.parseDouble(df.format(double_number));
				
	}
	
	public static String convierteAkilogramos(double double_number) {
	    String formattedNumber = String.format("%.3f", double_number);
	    return formattedNumber;
	}
	
	


}
