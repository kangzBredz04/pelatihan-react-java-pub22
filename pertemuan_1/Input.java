package pertemuan_1;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk mengambil input dari keyboard
        Scanner input = new Scanner(System.in);

        // Input String
        System.out.print("Masukkan nama Anda: ");
        String nama = input.nextLine(); // membaca satu baris input

        // Input Integer
        System.out.print("Masukkan umur Anda: ");
        int umur = input.nextInt(); // membaca input angka

        // Input Double
        System.out.print("Masukkan tinggi badan Anda (dalam meter): ");
        double tinggi = input.nextDouble(); // membaca input angka desimal

        // Menampilkan hasil input
        System.out.println("\nHalo, " + nama + "!");
        System.out.println("Umur Anda: " + umur + " tahun");
        System.out.println("Tinggi Anda: " + tinggi + " meter");

        // Menutup Scanner
        input.close();
    }
}
