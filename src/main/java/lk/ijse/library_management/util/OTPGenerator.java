package lk.ijse.library_management.util;

import java.util.Random;

public class OTPGenerator {
    public static String generateOTP() {
        int length = 6;

        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] otp = new char[length];

        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }

        return new String(otp);
    }
}
