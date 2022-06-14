import java.util.*;

class Main {
  public static void main(String[] args) {
    // create object of scanner
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Password");
    String plainPassword = sc.nextLine().toLowerCase();
    System.out.println("The entered password hashed value is:");

    encryptPassword(plainPassword);
  }

  static void encryptPassword(String plainPassword) {
    // System.out.println("Method Called:" + plainPassword );

    // char firstCharacter = plainPassword.charAt(0);
    // System.out.println(firstCharacter);

    // Array to add each character ascii to the array
    LinkedList<Integer> arrayOfAscii = new LinkedList<>();

    for (int i = 0; i < plainPassword.length(); i++) {
      char character = plainPassword.charAt(i);
      // System.out.println(character);
      int asciiValue = (int) character;
      // System.out.print(asciiValue);

      // Changing Value
      int newAsciiValue = ((asciiValue * 1246785) + 1004321);
      // System.out.print(newAsciiValue);
      arrayOfAscii.push(newAsciiValue);

    }
    for (int i = 0; i < arrayOfAscii.size(); i++) {
      int arrayOfAsciiValueHashedForm = arrayOfAscii.get(i);
      System.out.print(arrayOfAsciiValueHashedForm);

    }
    // System.out.print("Array of entered password Ascii:" +
    // arrayOfAsciiValueHashedForm);

    // create object of scanner

    Scanner sc = new Scanner(System.in);
    System.out.println("\n" + "Enter y to decrypt the password or n to exit");

    if (sc.nextLine().equals("y")) {
      decryptPassword(arrayOfAscii);
    } else {
      System.out.println("Try again");
    }

  }

  static void decryptPassword(LinkedList<Integer> arrayOfAscii) {
    // Array to add each character ascii to the array
    LinkedList<Integer> arrayOfDecryptAscii = new LinkedList<>();

    for (int i = 0; i < arrayOfAscii.size(); i++) {
      int asciiValue = arrayOfAscii.get(i);
      // System.out.print(asciiValue);

      // Changing Value
      int newAsciiValue = ((asciiValue - 1004321) / 1246785);
      // System.out.print(newAsciiValue);

      arrayOfDecryptAscii.push(newAsciiValue);

    }
    // print arraOfDecryptAscii
    //System.out.println(arrayOfDecryptAscii)
    // System.out.println("Array of decrypted password Ascii:" + arrayOfDecryptAscii
    // + "\n" + "Decrypted Password is:");
    System.out.println("\n" + "Decrypted Password is:");
    for (int i = 0; i < arrayOfDecryptAscii.size(); i++) {
      int asciiValue = arrayOfDecryptAscii.get(i);
      char asciiToCharacter = (char) asciiValue;
      System.out.print(asciiToCharacter);
    }

  }

}