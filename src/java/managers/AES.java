/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

/**
 *
 * @author Levi Barasa
 */
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

public class AES {

    private final static String ALGORITHM = "AES";

    public static byte[] encrypt(String input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey());
            return encodeString(cipher.doFinal(input.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return input.getBytes();
        }
    }

    public static String decrypt(byte[] input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey());
            String value = new String(cipher.doFinal(decodeString(input)));
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // generates a secret key
    private static Key generateKey() throws Exception {
        try {
            byte[] keyval = "@compulynx#54321".getBytes();
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            keyval = digest.digest(keyval);
            keyval = Arrays.copyOf(keyval, 16);
            Key key = new SecretKeySpec(keyval, ALGORITHM);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] encodeString(byte[] input) {
        return Base64.encodeBase64(input);
    }

    private static byte[] decodeString(byte[] output) {
        return Base64.decodeBase64(output);
    }
}

