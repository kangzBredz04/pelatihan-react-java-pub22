package pertemuan2;

public class Percabangan {
    public static void main(String[] args) {
        int x = 10;
        if (x > 5) {
            System.out.println("Lebih besar dari 5");
        } else {
            System.out.println("5 atau kurang");
        }

        int xy = 10;
        String hasil = (xy > 5) ? "Besar" : "Kecil";
        System.out.println(hasil);

        int hari = 3;
        switch (hari) {
            case 1:
                System.out.println("Senin");
                break;
            case 2:
                System.out.println("Selasa");
                break;
            case 3:
                System.out.println("Rabu");
                break;
            default:
                System.out.println("Hari tidak ditemukan");
        }

    }
}
