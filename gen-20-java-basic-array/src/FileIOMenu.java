import java.util.Scanner;

public class FileIOMenu {

    public static void ioMenu(int s){
        int status = s;
        while(s!=0){

            Scanner scan = new Scanner(System.in);
            System.out.println("Menu Input Output Java");
            System.out.println("1. Membuat Txt");
            System.out.println("2. Membaca Txt");
            System.out.println("3. Kembali ke menu sebelumnya");
            int input = scan.nextInt();

            switch(input){
                case 1:
                    createFile();
                    System.out.println();
                    break;
                case 2:
                    readFile();
                    System.out.println();
                    break;
                case 3:
                    s=0;
                    System.out.println();
                    System.out.println();
                    break;
                default:
                    System.out.println("Menu yang anda pilih tidak ada");
                    System.out.println();
                    break;
            }
        }
    }

    public static void createFile(){
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan kalimat yang akan ditulis pada output.txt: ");
        String input = s.nextLine();
        FileIO.makeFile(input);
    }

    public static void readFile(){
        FileIO.readFile();
        System.out.println();
    }
}
