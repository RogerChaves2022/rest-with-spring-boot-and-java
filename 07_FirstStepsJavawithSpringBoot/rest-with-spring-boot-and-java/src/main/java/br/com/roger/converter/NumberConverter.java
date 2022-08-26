package br.com.roger.converter;

public class NumberConverter {

	// método para converter a string do path para double
		public static Double convertToDouble(String strNumber) {
			if(strNumber == null) return 0D;
			String number = strNumber.replaceAll(",",".");
			if(isNumeric(number)) return Double.parseDouble(number);
			return 0D;
		}
		
		//método para validar se o valor é numerico
		public static boolean isNumeric(String strNumber) {
			if(strNumber == null) return false;
			String number = strNumber.replaceAll(",",".");
			return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		}

}
