import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // Cara 1: Deklarasi langsung dengan nilai
        String[] nama = { "Wahyu", "Budi", "Sari" };

        // Cara 2: Deklarasi dengan ukuran tertentu
        int[] nilai = new int[3]; // elemen diisi nanti
        nilai[0] = 80;
        nilai[1] = 90;
        nilai[2] = 75;

        System.out.println(nama[0]);
        System.out.println(nilai[2]);

        // Penggunaan Array dan Fungsinya
        int[] data = { 90, 70, 85, 60, 95 };

        // 1. sort()
        Arrays.sort(data);
        System.out.println("Data setelah diurutkan: " + Arrays.toString(data));

        // 2. copyOf()
        int[] salinan = Arrays.copyOf(data, data.length);
        System.out.println("Salinan array: " + Arrays.toString(salinan));

        // 3. fill()
        int[] kosong = new int[5];
        Arrays.fill(kosong, 100);
        System.out.println("Array setelah diisi nilai sama: " + Arrays.toString(kosong));

        // 4. binarySearch()
        int cari = 85;
        int indeks = Arrays.binarySearch(data, cari);
        if (indeks >= 0) {
            System.out.println("Nilai " + cari + " ditemukan di indeks ke-" + indeks);
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }

        // 5. equals()
        boolean sama = Arrays.equals(data, salinan);
        System.out.println("Apakah data dan salinan sama? " + sama);
    }
}
