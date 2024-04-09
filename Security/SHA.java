package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA {
    public static void main(String[] args) {
        // Nhập chuỗi từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to encode: ");
        String input = scanner.nextLine();
        scanner.close();

        // Mã hóa chuỗi sử dụng SHA
        String encodedString = encodeSHA(input);

        // In ra chuỗi đã mã hóa
        System.out.println("Encoded string (SHA): " + encodedString);
    }

    // Phương thức để mã hóa chuỗi sử dụng SHA
    private static String encodeSHA(String input) {
        try {
            // Tạo đối tượng MessageDigest với thuật toán SHA
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Mã hóa chuỗi đầu vào
            byte[] encodedHash = digest.digest(input.getBytes());

            // Chuyển đổi mảng byte sang chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not found.");
            e.printStackTrace();
            return null;
        }
    }
}
