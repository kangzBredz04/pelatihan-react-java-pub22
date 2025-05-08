package pertemuan_satu;

import java.util.ArrayList;

public class ArrayListCoba {
    public static void main(String[] args) {
        // Membuat ArrayList untuk menyimpan string
        ArrayList<String> daftarNama = new ArrayList<>();

        // 1. add() - Menambahkan objek ke dalam ArrayList
        daftarNama.add("Wahyu");
        daftarNama.add("Budi");
        daftarNama.add("Sari");
        System.out.println("Daftar Nama: " + daftarNama);

        // 2. remove() - Menghapus objek dari ArrayList
        daftarNama.remove("Budi");
        System.out.println("Setelah menghapus Budi: " + daftarNama);

        // 3. get() - Mengambil objek berdasarkan indeks
        String namaPertama = daftarNama.get(0); // Mengambil nama pertama
        System.out.println("Nama pertama: " + namaPertama);

        // 4. set() - Mengupdate objek pada indeks tertentu
        daftarNama.set(0, "Agus");
        System.out.println("Setelah mengubah nama pertama: " + daftarNama);

        // 5. size() - Mendapatkan ukuran ArrayList
        System.out.println("Jumlah nama dalam daftar: " + daftarNama.size());

        // 6. clear() - Menghapus semua objek dari ArrayList
        daftarNama.clear();
        System.out.println("Setelah clear: " + daftarNama);

        // 7. isEmpty() - Memeriksa apakah ArrayList kosong
        boolean kosong = daftarNama.isEmpty();
        System.out.println("Apakah daftar nama kosong? " + kosong);

        // 8. contains() - Memeriksa apakah objek ada di ArrayList
        daftarNama.add("Sari");
        daftarNama.add("Budi");
        boolean adaSari = daftarNama.contains("Sari");
        System.out.println("Apakah 'Sari' ada dalam daftar? " + adaSari);
    }
}
