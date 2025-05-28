abstract class Character {
    private String name;

    abstract void attack();

    void defend() {
        System.out.println("Defend");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Hero extends Character {
    void attack() {
        System.out.println("Attack");
    }
}

abstract class MahasiswaPUB {

    String name;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void tidur();

    abstract void jajan();

    void pembinaan() {
        System.out.println("Pembinaan");
    }

    void makan() {
        System.out.println("Makan dikantin");
    }
}

class Arjun extends MahasiswaPUB {

    @Override
    void tidur() {
        System.out.println("Tidur 8 jam");
    }

    @Override
    void jajan() {
        System.out.println("Jajan batagor");
    }

}

class Mora extends MahasiswaPUB {

    @Override
    void tidur() {
        System.out.println("Tidur 7 jam");
    }

    @Override
    void jajan() {
        System.out.println("Jajan nasi goreng");
    }

}


class Kucing {
    void makan() {
        System.out.println("Makan");
    }

    void makan(String makanan) {
        System.out.println("Makan " + makanan);
    }

    void makan(String makanan, String tempat) {
        System.out.println("Makan " + makanan + " di " + tempat);
    }
}

public class Main {
    public static void main(String[] args) {
        Arjun arjun = new Arjun();
        // arjun.tidur();
        // arjun.jajan();
        // arjun.pembinaan();
        // arjun.makan();

        Kucing kucing = new Kucing();
        kucing.makan();
        kucing.makan("Sate");
        kucing.makan("Sate", "Rumah");
    }

}
