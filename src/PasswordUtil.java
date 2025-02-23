import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PasswordUtil {
    private static final String ALGORITHM = "AES";
    private static final byte[] SECRET_KEY = "1234567890123456".getBytes(); // Use a 16-byte key

    // Encrypt Text
    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting text", e);
        }
    }

    // Decrypt Text
    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting text", e);
        }
    }
}
