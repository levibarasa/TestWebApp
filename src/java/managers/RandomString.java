/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.security.SecureRandom;

/**
 *
 * @author Levi Barasa
 */
public class RandomString {

    private static final char[] availChars;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch) {
            stringBuilder.append(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            stringBuilder.append(ch);
        }
        availChars = stringBuilder.toString().toCharArray();
    }

    private final SecureRandom random = new SecureRandom();

    private final char[] generatedChars;

    public RandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length < 1: " + length);
        }
        generatedChars = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < generatedChars.length; ++idx) {
            generatedChars[idx] = availChars[random.nextInt(availChars.length)];
        }
        return new String(generatedChars);
    }
}