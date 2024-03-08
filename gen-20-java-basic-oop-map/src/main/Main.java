package main;

import interfacecrud.ICRUD;
import mapcrud.MapCRUD;
import pojo.DataSiswa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            System.out.println("Java OOP Map");
            ICRUD mapCRUD = new MapCRUD();
            testCRUD(mapCRUD, s);
    }

    private static void testCRUD(ICRUD crud, Scanner scanner){
        boolean r = true;
        while (r) {
            System.out.println("1. Tambah Element");
            System.out.println("2. Tampilkan Element");
            System.out.println("3. Update Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Exit Program");
            System.out.print("Pilih menu (1-5): ");
            int opt = scanner.nextInt();

            switch (opt){
                case 1:
                    addElement(crud, scanner);
                    System.out.println();
                    break;
                case 2:
                    crud.showElement();
                    System.out.println();
                    break;
                case 3:
                    updateElement(crud, scanner);
                    System.out.println();
                    break;
                case 4:
                    deleteElement(crud, scanner);
                    System.out.println();
                    break;
                case 5:
                    r = false;
                    break;
                default:
                    System.out.println("Menu yang diinput tidak ada!!");
                    System.out.println();
                    break;
            }
        }
    }

    private static void addElement(ICRUD crud, Scanner scanner){
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        DataSiswa newData = new DataSiswa(id, nama);

        crud.addElement(newData);
    }

    private static void updateElement(ICRUD crud, Scanner scanner){
        System.out.print("Masukkan ID yang ingin diupdate: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Baru: ");
        String newNama = scanner.nextLine();

        DataSiswa updateData = new DataSiswa(idToUpdate,newNama);
        crud.updateElement(updateData);
    }

    private static void deleteElement(ICRUD crud, Scanner scanner){
        System.out.print("Masukkan Id yang akan dihapus: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();

        DataSiswa dataToDelete = new DataSiswa(idToDelete);
        crud.deleteElement(dataToDelete);
    }
}