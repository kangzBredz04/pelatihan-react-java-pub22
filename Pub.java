interface MahasiswaPUB2 {


    String makan();

    void tidur();

    void jajan();

    void pembinaan();
}

class Imelda implements MahasiswaPUB2 {

    @Override
    public String makan() {
        return "Makan nasi goreng";
    }

    @Override
    public void tidur() {
        System.out.println("Tidur 8 jam");
    }

    @Override
    public void jajan() {
        System.out.println("Jajan batagor");
    }

    @Override
    public void pembinaan() {
        System.out.println("Pembinaan");
    }
}

public class Pub {
    public static void main(String[] args) {
        Imelda imelda = new Imelda();
        System.out.println(imelda.makan());
        imelda.tidur();
        imelda.jajan();
        imelda.pembinaan();
    }
}
