public class Main {
    public static void main(String[] args) {
        // PRINT
        // Mencetak teks tanpa pindah baris
        System.out.print("Hello ");
        System.out.print("World");

        System.out.println("\n");

        // PRINTLN
        // Mencetak teks dan langsung pindah baris setelahnya
        System.out.println("Hello");
        System.out.println("World");

        // PRINTLN
        // Mencetak teks dengan format tertentu, seperti dalam bahasa C
        System.out.printf("%s %s", "Hello", "World");

        System.out.println("\n\n");
        String nama = "Wahyu";
        int umur = 22;

        // 1. print()
        System.out.print("Menggunakan print(): ");
        System.out.print("Halo ");
        System.out.print(nama);
        System.out.print("\n");

        // 2. println()
        System.out.println("Menggunakan println():");
        System.out.println("Nama saya " + nama);
        System.out.println("Umur saya " + umur);

        // 3. printf()
        System.out.println("Menggunakan printf():");
        System.out.printf("Nama: %s, Umur: %d tahun\n", nama, umur);
    }
}