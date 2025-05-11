package pertemuan3;

import java.util.HashMap;
import java.util.Map;

public class Day {
    public static void main(String[] args) {
        HashMap<String, String> days = new HashMap<String, String>();

        // mengisi hashmap
        days.put("senin", "Menghapal vocab");
        days.put("selasa", "Hapalan vocab");
        days.put("rabu", "Ada tes vocab");
        days.put("kamis", "Pengumuman nilai vocab");
        days.put("jumat", "Kecewa dengan pengumuman vocab");
        days.put("sabtu", "Dikasih vocab baru");
        days.put("minggu", "Aku suka vocab :)");

        // [{"senin", "Menghapal vocab"}, {"selasa", "Hapalan vocab"}, ...]

        // cetak hashmap
        for (Map.Entry x : days.entrySet()) {
            System.out.println(x.getKey() + " : " + x.getValue());
        }

        // setelah update di hari jumat
        System.out.println("========================================");
        // mengganti value jumat
        days.replace("jumat", "Aku cinta PUB");

        for (Map.Entry x : days.entrySet()) {
            System.out.println(x.getKey() + " : " + x.getValue());
        }

        // menghapus value minggu
        System.out.println("========================================");
        // mengganti value jumat

        days.remove("jumat");

        for (Map.Entry x : days.entrySet()) {
            System.out.println(x.getKey() + " : " + x.getValue());
        }
    }
}
