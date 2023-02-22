package metodos_externos_necesarios;

import java.text.DecimalFormat;

public class Metodos_numericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 	}
	
	public static double convierteAdecimal(double double_number) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		return Double.parseDouble(df.format(double_number));
				
	}
	

}
