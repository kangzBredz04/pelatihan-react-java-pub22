package pertemuan1;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] data = { 10, 20, 30, 40, 50 };

        // 1. Arrays.toString()
        System.out.println("Array dalam bentuk string: " + Arrays.toString(data));

        // 2. Arrays.copyOfRange()
        int[] sebagian = Arrays.copyOfRange(data, 1, 4); // indeks 1 hingga 3
        System.out.println("Salinan sebagian data: " + Arrays.toString(sebagian));

        // 3. System.arraycopy()
        int[] tujuan = new int[5];
        System.arraycopy(data, 0, tujuan, 0, 3); // salin 3 elemen pertama
        System.out.println("Array hasil System.arraycopy(): " + Arrays.toString(tujuan));

        // 4. Arrays.setAll()
        int[] hasilSet = new int[5];
        Arrays.setAll(hasilSet, i -> i * 10); // isi array dengan kelipatan 10
        System.out.println("Array setelah setAll(): " + Arrays.toString(hasilSet));

        // 5. Stream (opsional lanjutan)
        long jumlahData = Arrays.stream(data).count();
        System.out.println("Jumlah elemen dengan stream: " + jumlahData);
    }
}
