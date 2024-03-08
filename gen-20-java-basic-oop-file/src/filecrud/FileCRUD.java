package filecrud;

import crud.IFileCRUD;
import pojo.DataSiswa;

import java.io.*;
import java.util.*;

public class FileCRUD implements IFileCRUD {
    private String filePath;

    public FileCRUD(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void addRow(DataSiswa data) {
        Map<Integer, DataSiswa> dataMap = readDataFromFile();
        if(dataMap.containsKey(data.getId())){
            System.out.println("Data sudah ada.");
        } else {
            dataMap.put(data.getId(), data);
            writeDataToFile(dataMap);
            System.out.println("Data berhasil ditambah");
        }
    }

    @Override
    public void updateRow(DataSiswa data) {
        Map<Integer, DataSiswa> dataMap = readDataFromFile();
        if(!dataMap.containsKey(data.getId())){
            System.out.println("Data tidak ditemukan");
        } else{
            dataMap.remove(data.getId());
            dataMap.put(data.getId(), data);
            writeDataToFile(dataMap);
            System.out.println("Data berhasil diupdate");
        }
    }

    @Override
    public void deleteRow(DataSiswa data) {
        Map<Integer, DataSiswa> dataMap = readDataFromFile();
        if(!dataMap.containsKey(data.getId())){
            System.out.println("Data tidak ditemukan");
        } else {
            dataMap.remove(data.getId());
            writeDataToFile(dataMap);
            System.out.println("Data Berhasil dihapus");
        }
    }

    public void showData(){
        Map<Integer, DataSiswa> dataMap = readDataFromFile();
        System.out.println("Data siswa: ");
        for(Map.Entry<Integer, DataSiswa> entry: dataMap.entrySet()){
            DataSiswa data = entry.getValue();
            System.out.println("ID: " + data.getId()+", Nama: "+ data.getNama()+", Kelas: "+data.getKelas());
        }
    }

    public Map<Integer, DataSiswa> readDataFromFile() {
        Map<Integer, DataSiswa> dataMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    DataSiswa data = new DataSiswa();
                    data.setId(Integer.parseInt(parts[0].trim()));
                    data.setNama(parts[1].trim());
                    data.setKelas(Integer.parseInt(parts[2].trim()));
                    dataMap.put(data.getId(), data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan. Membuat file baru.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public void writeDataToFile(Map<Integer, DataSiswa> dataMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (DataSiswa data : dataMap.values()) {
                writer.write(String.format("%d, %s, %d%n", data.getId(), data.getNama(), data.getKelas()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
