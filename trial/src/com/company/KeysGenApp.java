package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

public class KeysGenApp {
    public static final Logger LOGGER = Logger.getLogger(KeysGenApp.class.getName());
    public static String generateSecretKey() throws NoSuchAlgorithmException {
        // Initialize KeyGenerator to generate a key for HMAC-SHA256
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA384");
        // Specify the key size of 256 bits
        keyGen.init(384);
        // Generate the Secret key
        SecretKey secretKey = keyGen.generateKey();
        // Encode the binary key to a Base64 string for easier handling and storage
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public static void main(String[] args) {
        try {
            String secretKey = generateSecretKey();
            System.out.println("Generated Secret Key: " + secretKey);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
