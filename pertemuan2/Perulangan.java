package pertemuan2;

public class Perulangan {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop ke-" + i);
        }

        int i = 0;
        while (i < 3) {
            System.out.println("While loop ke-" + i);
            i++;
        }

        int j = 0;
        do {
            System.out.println("Do-While loop ke-" + j);
            j++;
        } while (j < 3);
    }
}
