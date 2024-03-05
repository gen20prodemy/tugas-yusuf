public class Barang {
    private String nama;

    public Barang (String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    @Override
    public String toString(){
        return "Barang{"+
                "nama: '"+ nama+"'"+
                "}";

    }
}
