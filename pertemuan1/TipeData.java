package pertemuan1;

public class TipeData {
    public static void main(String[] args) {
        // === Tipe Data Primitif ===
        char golonganDarah = 'A';
        int umur = 20;
        double tinggi = 1.74;
        boolean menikah = true;

        // === Tipe Data Komposit ===
        String nama = "Wahyu";
        int[] nilaiUjian = { 85, 90, 88 }; // array sebagai tipe komposit
        // Mahasiswa mhs = new Mahasiswa(nama, umur, golonganDarah, tinggi, menikah);

        // Output
        System.out.println("=== Tipe Data Primitif ===");
        System.out.println("Golongan Darah: " + golonganDarah);
        System.out.println("Umur: " + umur);
        System.out.println("Tinggi: " + tinggi + " m");
        System.out.println("Status Menikah: " + menikah);

        System.out.println("\n=== Tipe Data Komposit ===");
        System.out.print("Nilai Ujian: ");
        for (int nilai : nilaiUjian) {
            System.out.print(nilai + " ");
        }

        System.out.println("\n\nData Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Golongan Darah: " + golonganDarah);
        System.out.println("Tinggi: " + tinggi + " m");
        System.out.println("Menikah: " + menikah);
    }
}
