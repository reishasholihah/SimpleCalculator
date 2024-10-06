import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try (s) {
            int operasi;
            do {
                System.out.println("Selamat Datang di Program Kalkulator.");
                System.out.print("1.Penambahan\n2.Pengurangan\n3.Perkalian\n4.Pembagian\n5.Keluar\nPilih Operasi: ");
                
                while (true) {
                    try {
                        operasi = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Mohon diisi dengan angka ya.\n");
                        s.next();
                    }
                }

                double num1 = 0, num2 = 0;
                if (operasi >= 1 && operasi <= 4) {
                    num1 = getNumber(s, "Masukkan angka 1: ");
                    num2 = getNumber(s, "Masukkan angka 2: ");
                }

                double hasil = 0;
                switch (operasi) {
                    case 1 -> hasil = add(num1, num2);
                    case 2 -> hasil = subtract(num1, num2);
                    case 3 -> hasil = multiply(num1, num2);
                    case 4 -> hasil = divide(num1, num2);
                    case 5 -> System.out.println("Sampai Jumpa!\n");
                    default -> System.out.println("Invalid.\n");
                }

                if (operasi >= 1 && operasi <= 4) {
                    System.out.println("Hasil: " + hasil + "\n");
                }

            } while (operasi != 5);
        }
    }

    public static double getNumber(Scanner s, String prompt) {
        double number = 0;
        while (true) {
            System.out.print(prompt);
            try {
                number = s.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid.\n");
                s.next();
            }
        }
        return number;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Pembagian dengan 0 tidak diizinkan.");
            return 0;
        }
        return a / b;
    }
}
