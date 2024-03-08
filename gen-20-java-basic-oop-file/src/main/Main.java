package main;

import filecrud.FileCRUD;
import pojo.DataSiswa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Lokasi file untuk menyimpan data
        String filePath = "E:\\Bootcamp Sigmaka\\Intellij\\tugas-yusuf\\gen-20-java-basic-oop-file\\src\\file.txt";
        FileCRUD fileCRUD = new FileCRUD(filePath);


        int p=1;
        int choice;
        while (p != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            choice = s.nextInt();
            s.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    addData(fileCRUD, s);
                    break;
                case 2:
                    showData(fileCRUD);
                    break;
                case 3:
                    updateData(fileCRUD, s);
                    break;
                case 4:
                    deleteData(fileCRUD, s);
                    break;
                case 5:
                    System.out.println("Program selesai. Sampai jumpa!");
                    p=0;
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
        }
    }

    private static void addData(FileCRUD fileCRUD, Scanner scanner) {
        System.out.print("Masukkan ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kelas (1-12): ");
        int kelas = scanner.nextInt();

        DataSiswa newData = new DataSiswa();
        newData.setId(id);
        newData.setNama(nama);
        newData.setKelas(kelas);

        fileCRUD.addRow(newData);
    }

    private static void showData(FileCRUD fileCRUD) {
        fileCRUD.showData();
    }

    private static void updateData(FileCRUD fileCRUD, Scanner scanner) {
        System.out.print("Masukkan ID yang akan diupdate: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();  // consume the newline character
        System.out.print("Masukkan Nama Baru: ");
        String newNama = scanner.nextLine();
        System.out.print("Masukkan Kelas baru: ");
        int newKelas = scanner.nextInt();

        DataSiswa updatedData = new DataSiswa();
        updatedData.setId(idToUpdate);
        updatedData.setNama(newNama);
        updatedData.setKelas(newKelas);

        fileCRUD.updateRow(updatedData);
    }

    private static void deleteData(FileCRUD fileCRUD, Scanner scanner) {
        System.out.print("Masukkan ID yang akan dihapus: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();  // consume the newline character

        DataSiswa dataToDelete = new DataSiswa();
        dataToDelete.setId(idToDelete);

        fileCRUD.deleteRow(dataToDelete);
    }
}