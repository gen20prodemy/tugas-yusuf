package mapcrud;

import customerror.DuplicateIdException;
import interfacecrud.CRUD;
import pojo.DataSiswa;

import java.util.HashMap;
import java.util.Map;

public class MapCRUD extends CRUD {
    private Map<Integer, DataSiswa> mapData;

    public MapCRUD(){
        this.mapData = new HashMap<>();
    }

    @Override
    public void addElement(DataSiswa data) {
        try {
            if(mapData.containsKey((data.getId()))){
                throw new DuplicateIdException("Data dengan Id " + data.getId() + " sudah ada");
            }
            mapData.put(data.getId(), data);
            System.out.println("Data berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }

    @Override
    public void deleteElement(DataSiswa data) {
        if(!mapData.containsKey(data.getId())){
            System.out.println("Data dengan ID" + data.getId()+ " tidak ditemukan");
            return;
        }
        mapData.remove(data.getId());
        System.out.println("Data berhasil dihapus");
    }

    @Override
    public void showElement() {
        System.out.println("Tampilkan data:");
        for(Map.Entry<Integer, DataSiswa> entry: mapData.entrySet()){
            System.out.println("Id: " + entry.getKey() + ", Nama: "+ entry.getValue().getNama());
        }
    }

    @Override
    public void updateElement(DataSiswa data) {
        if(!mapData.containsKey(data.getId())){
            System.out.println("Data dengan Id "+ data.getId() + " tidak ditemukan");
            return;
        }
        mapData.put(data.getId(), data);
        System.out.println("Data berhasil diupdate");
    }
}
