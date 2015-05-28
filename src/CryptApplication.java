import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CryptApplication {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Crypt Application");
		Scanner scan = new Scanner(System.in);
		String choice = "";
		
		System.out.print("Input File Name: ");
		String input = scan.nextLine();
		File fileIn = new File(input);
		// Make a file object called fileIn using the input String
		
		System.out.print("Output File Name: ");
		String output = scan.nextLine();
		File fileOut = new File(output);
		// Make a file object called fileOut using the output String
		
		System.out.print("Password: ");
		String password = scan.nextLine();
	
		// This will loop until a valid encrypt or decrypt option is made
		while (choice == "") {
			System.out.print("Encrypt or Decrypt? ");
			choice = scan.nextLine();
			if (choice.toLowerCase().charAt(0) == 'e') {
				 encryptFile(fileIn, fileOut, password);
			}
			else if(choice.toLowerCase().charAt(0) =='d') {
				decryptFile(fileIn, fileOut, password);
			}
			else {
				System.out.println("Please try again.");
				choice = "";
			}
		}
		System.out.println("Operation Complete.");
	}
	
	/**
	 *	To write this method you will need to read the APIs for Crypt and
	 *	FileIO.  Your goal will be to take an input file, encrypt its bytes
	 *	using a password, and then write the encrypted bytes back out to an
	 *	output file.
	 */
	public static void encryptFile (File input, File output, String password) throws IOException  {


		try {
			byte[] data = FileIO.read(input);

			Crypt c = new Crypt(password);
			byte[] encrypted = c.encrypt(data);
		
			FileIO.write(output, encrypted);
		}
		catch (IOException e) {
			System.out.println("Could not read the file");
		}
		
catch (Exception e) {
		System.out.println("Encryption error.");
	}
	
	}
	
	/**
	 *	To write this method you will need to read the APIs for Crypt and
	 *	FileIO.  Your goal will be to take an input file, decrypt its bytes
	 *	using a password, and then write the decrypted bytes back out to an
	 *	output file.
	 */
	public static void decryptFile(File input, File output, String password) {
		

		try {
			byte[] data = FileIO.read(input);

			Crypt c = new Crypt(password);
			byte[] decrypted = c.decrypt(data);
			FileIO.write(output,decrypted);
		}
		catch (IOException e) {
			System.out.println("Could not read the file");
		}
		
catch (Exception e) {
		System.out.println("Encryption error.");
	}
	
		

	}
}
