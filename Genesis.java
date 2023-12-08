
import java.security.SecureRandom;

public class Genesis {
	
	private SecureRandom random;
	
	public Genesis() {
		this.random = new SecureRandom();
	}
	
	public String generatePassword(int length) {
		String uppyChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowyChars = "abcdefghijklmnopqrstuvwxyz";
		String numericChars = "0123456789";
		String crazyChars = "!@#$%^&*()-_=+";
		
		StringBuilder password = new StringBuilder();
		
		password.append(uppyChars.charAt(random.nextInt(uppyChars.length())));
		password.append(lowyChars.charAt(random.nextInt(lowyChars.length())));
	    password.append(numericChars.charAt(random.nextInt(numericChars.length())));
	    password.append(crazyChars.charAt(random.nextInt(crazyChars.length())));
	    
	    
	    String magic = uppyChars + lowyChars + numericChars + crazyChars;
		
	    
	    for(int i = 4; i < length; i++) {
			int index = random.nextInt(magic.length());
			password.append(magic.charAt(index));
		}
	    char[] passwordArray = password.toString().toCharArray();
	    for(int i = passwordArray.length - 1; i > 0; i--) {
	    	int j = random.nextInt(i+1);
	    	char temp = passwordArray[j];
	    	passwordArray[i] = passwordArray[j];
	    	passwordArray[j] = temp;
	    }
		
	    return new String(passwordArray);
	}
	public static void main(String[] args) {
		Genesis genesis = new Genesis();
		String muscleMan = genesis.generatePassword(12);
		System.out.println(muscleMan);
	}
}

