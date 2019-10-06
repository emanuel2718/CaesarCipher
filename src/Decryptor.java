public class Decryptor {
    int keyShift;

    public Decryptor(int keyShift) {
        this.keyShift = keyShift;
    }

    public static String decryptMessage(String message, int keyShift) {
        return Encryptor.encryptMessage(message, 26 - keyShift);
    }
}
