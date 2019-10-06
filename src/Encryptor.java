public class Encryptor {

    private int keyShift;

    public Encryptor(int keyShift) {
        this.keyShift = keyShift;
    }

    // Does the encryption
    public static String encryptMessage(String message, int keyShift) {
        keyShift = keyShift % 26 + 26;
        StringBuilder encrypted = new StringBuilder();
        for (char i : message.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted.append((char) ('A' + (i - 'A' + keyShift) % 26 ));
                } else {
                    encrypted.append((char) ('a' + (i - 'a' + keyShift) % 26 ));
                }
            } else {
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }
}
