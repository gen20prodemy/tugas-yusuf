package pojo;

public class DataSiswa {
    private int id;
    private String nama;

    public DataSiswa(int id){
        this.id = id;
    }

    public DataSiswa(int id, String nama){
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
