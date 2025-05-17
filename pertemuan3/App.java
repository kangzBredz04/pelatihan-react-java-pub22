package pertemuan3;

public class App {
    public static void main(String[] args) throws Exception {
        // instansiasi objek seperti biasa
        PubManagement pengurus = new PubManagement();
        EducationDivision divdik = new EducationDivision();
        SpiritualDivision rohani = new SpiritualDivision();
        WalfareDivision sejahtera = new WalfareDivision();

        // memanggil properti atau method di class super
        pengurus.reportJob();

        // mengolah properti atau method di class subclass
        divdik.programmingLang = "Java";
        rohani.absentOfficer = "Wabredz";
        sejahtera.absentBreackfast();

        // mengakses properti atau method yang ada
        // di class super, tapi menggunakan subclass
        rohani.generation = 20;
        System.out.println(rohani.generation);
        rohani.reportJob();
    }
}
