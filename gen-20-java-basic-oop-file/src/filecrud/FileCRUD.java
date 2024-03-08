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
        List<DataSiswa> dataList = readDataFromFile();
        if(dataList.contains(data)){
            System.out.println("Data sudah ada.");
        } else {
            dataList.add(data);
            writeDataToFile(dataList);
            System.out.println("Data berhasil ditambah");
        }
    }

    @Override
    public void updateRow(DataSiswa data) {
        List<DataSiswa> dataList = readDataFromFile();
        if(!dataList.contains(data)){
            System.out.println("Data tidak ditemukan");
        } else{
            dataList.remove(data);
            dataList.add(data);
            writeDataToFile(dataList);
            System.out.println("Data berhasil diupdate");
        }
    }

    @Override
    public void deleteRow(DataSiswa data) {
        List<DataSiswa> dataList = readDataFromFile();
        if(!dataList.contains(data)){
            System.out.println("Data tidak ditemukan");
        } else {
            dataList.remove(data);
            writeDataToFile(dataList);
            System.out.println("Data Berhasil dihapus");
        }
    }

    public void showData(){
        List<DataSiswa> dataList = readDataFromFile();
        System.out.println("Data siswa: ");
        for(DataSiswa data: dataList){
            System.out.println("ID: " + data.getId()+", Nama: "+ data.getNama()+", Kelas: "+data.getKelas());
        }
    }

    public List<DataSiswa> readDataFromFile() {
        List<DataSiswa> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    DataSiswa data = new DataSiswa();
                    data.setId(Integer.parseInt(parts[0].trim()));
                    data.setNama(parts[1].trim());
                    data.setKelas(Integer.parseInt(parts[2].trim()));
                    dataList.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan. Membuat file baru.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public void writeDataToFile(List<DataSiswa> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (DataSiswa data : dataList) {
                writer.write(String.format("%d, %s, %d%n", data.getId(), data.getNama(), data.getKelas()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
