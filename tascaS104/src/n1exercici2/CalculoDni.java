package n1exercici2;

public class CalculoDni {
	
	/**
	 * This function returns the letter of the document number entered
	 * by parameters
	 * @param num
	 * @return letter of the entered Dni
	 */
	public char calculateLetter(int num) {
		char result=' ';
		String letter="TRWAGMYFPDXBNJZSQVHLCKE";
		
		int mod=num%23;
		
		result=letter.charAt(mod);
		
		return result;
	}

}
