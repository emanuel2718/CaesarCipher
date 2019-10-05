import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
	/*
	 * A Caesar Cipher is a substitution cipher that uses a key to shift the message provided to either
	 * Encrypt or decrypt the given message. For example, a Caesar cipher with a key value of 3 and a
	 * given message "ABC" will encrypt to: "CDE".
	 * It just "shifts" the letters 3 letters to the right in the alphabet.
	 * Negative key values do the opposite. Shift the letter to the left.
	 */
	public static void main(String[] args) {
		initCipher();
	}

	private static void initCipher() {
		boolean isTrue = true;
		Scanner userInput = new Scanner(System.in);

		while (true) {
		//while (isTrue) {
			// Main menu options
			System.out.println("\nWelcome to the world crappiest Caesar Cipher Encryption/Decryption tool!");
			System.out.println("Please select an option from the list below [1 - 3]: " + "\n");
			System.out.println("[ 1 ] Encrypt message");
			System.out.println("[ 2 ] Decrypt message");
			System.out.println("[ 3 ] Exit" + "\n");

			System.out.print("Option: ");
			String choiceNumber = userInput.nextLine();

			// try and catch non-integer options
			try {
				Integer.parseInt(choiceNumber);
			}
			catch (Exception e) {
				//throw new ArithmeticException("Wrong choice. Choice must be a integer from 1 to 3 inclusive");
				System.out.println("Wrong choice. Choice must be a integer from 1 to 3 inclusive.");
				System.out.println("Press any key to continue");
				userInput.nextLine();
				initCipher();
			}

			/*
			 * Select action to perform:
			 */

			if (choiceNumber.equals("1")) {
				System.out.println("Provide a value for your key shift. Must be a positive integer \n");
				System.out.print("Key shift: ");
				// Check if key shift value provided is legal (i.e positive integer number)
				try {
					Integer.parseInt(choiceNumber);
				}
				catch (Exception e) {
					System.out.println("The value for the key shift must be a positive integer. ");
					System.out.println("Press any key to continue");
					userInput.nextLine();
					initCipher();
				}
				int keyShift = Integer.parseInt(userInput.nextLine());
				System.out.print("Provide the message to be encrypted: ");
				String message = userInput.nextLine();
				messageEncryptor(message, keyShift);
			}
			else if (choiceNumber.equals("2")) {
				System.out.println("Provide a value for your key shift. Must be a positive integer \n");
				System.out.print("Key shift: ");
				// Check if key shift value provided is legal (i.e positive integer number)
				try {
					Integer.parseInt(choiceNumber);
				}
				catch (Exception e) {
					System.out.println("The value for the key shift must be a positive integer. ");
					System.out.println("Press any key to continue");
					userInput.nextLine();
					initCipher();
				}
				int keyShift = Integer.parseInt(userInput.nextLine());
				System.out.print("Provide the message to be encrypted: ");
				String message = userInput.nextLine();
				messageDecryptor(message, keyShift);
			}

			else if (choiceNumber.equals("3")) {
				System.out.println("Thank you for using the CaesarCipher CLI. Please, come back soon.\n");
				break;
			}


		}
	}

	// Calls the Encryptor class to perform the encryption process
	private static void messageDecryptor(String message, int keyShift) {
		System.out.println("Encrypting the message...");
		Encryptor theEncryptor = new Encryptor(keyShift);
		System.out.println("Your encrypted message is: " + theEncryptor.encryptMessage(message, keyShift) + "\n");
		System.out.println("Thank you for using the CaesarCipher CLI. Please, come back soon.\n");
	}

	private static void messageEncryptor(String message, int keyShift) {
		System.out.println("Encrypting the message...");
		Decryptor theDecryptor = new Decryptor(keyShift);
		System.out.println("Your encrypted message is: " + theDecryptor.decryptMessage(message, keyShift) + "\n");
		System.out.println("Thank you for using the CaesarCipher CLI. Please, come back soon.\n");
	}

}
