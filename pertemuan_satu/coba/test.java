package pertemuan_satu.coba;

import java.util.Scanner;

public class test {
    void sapaan(String nama) {
        System.out.println("Hai " + nama);
    }

    int luasPersegi(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        int a = 10;
        // if (a % 2 == 0) {
        // System.out.println("Ini bilangan genap");
        // } else {
        // System.out.println("Ini bilangan ganjil");
        // }

        // String hasil = (a % 2 == 0) ? "Ini bilangan genap" : "Ini bilangan ganjil";
        // System.ou

        // Scanner input = new Scanner(System.in);
        // String lampu;
        // System.out.print("Sekarang lampu apa : ");
        // lampu = input.nextLine();
        // switch (lampu) {
        // case "merah":
        // System.out.println("Berhenti!");
        // break;
        // case "kuning":
        // System.out.println("Siap-siap!");
        // break;
        // case "hijau":
        // System.out.println("Jalan!");
        // break;
        // default:
        // System.out.println("Lampu mati!");
        // break;

        // String[] name = { "Dimas", "Wahyu", "Anggi", "Rey" };

        // System.out.println(name[0]);
        // System.out.println(name[1]);
        // System.out.println(name[2]);
        // for (String n : name) {
        // System.out.println(n);

        // }

        // Scanner input = new Scanner(System.in);
        // boolean ulang = false;
        // int hitung = 0;
        // String jawab;
        // while (ulang) {
        // System.out.print("Apakah ingin mengulang (y/t) : ");
        // jawab = input.nextLine();
        // if (jawab.equalsIgnoreCase("t")) {
        // ulang = false;
        // }
        // hitung++;
        // }
        // System.out.println("Anda telah melakukan perulangan sebanyak "
        // + hitung + " kali");

        test t = new test();
        t.sapaan("Wahyu");
        System.out.println("Luas persegi : " + t.luasPersegi(5));
    }
}
