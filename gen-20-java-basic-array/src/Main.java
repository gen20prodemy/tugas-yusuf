
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int p = 1;
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            while (p!=0){
                System.out.println("===Aplikasi Array===");
                System.out.println("|By. Yusuf Valent A|");
                System.out.println("====================");
                System.out.println();
                System.out.println("1. Jumlahkan element Array");
                System.out.println("2. Jumlahkan element Array pada dimensi 2");
                System.out.println("3. Membalik susunan Array");
                System.out.println("4. Read/Write File");
                System.out.println("5. Keluar");
                System.out.println();
                System.out.print("pilih menu (masukkan angka): ");
                int opt = s.nextInt();

                switch (opt){
                    case 1:
                        sum();
                        Thread.sleep(5000);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        break;
                    case 2:
                        arrInArr();
                        Thread.sleep(5000);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        break;
                    case 3:
                        transpose();
                        Thread.sleep(5000);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        break;
                    case 4:
                        FileIOMenu.ioMenu(1);
                        break;
                    case 5:
                        p = 0;
                        break;
                    default:
                        System.out.println("menu yang anda pilih tidak ada");
                        Thread.sleep(500);
                        System.out.println();
                        System.out.println();
                }
            }
            }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void transpose(){
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan element Array (pisahkan dengan spasi): ");
        String input = s.nextLine();
        int[] arr = convertToIntArray(input.split(" "));
        ArrayClass transpose = new ArrayClass();
        System.out.println("Hasil membalik urutan array: " + Arrays.toString(transpose.transposeArray(arr)));
    }

    public static void sum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan element array (pisahkan dengan spasi): ");
        String input = scan.nextLine();

        String[] s1 = input.split(" ");
        System.out.println(Arrays.toString(s1));
        int[] newArray = convertToIntArray(s1);

        ArrayClass array = new ArrayClass(newArray);
        System.out.println("Sum element Array: "+ array.arraySum());
    }

    public static void arrInArr(){
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        System.out.print("Berapa Array yang ingin di proses menjadi array baru? ");
        int count = s1.nextInt();
        int[][] arr = new int[count][];
        for(int i=0; i<count; i++){
            System.out.print("masukkan element array (pisahkan dengan spasi): ");
            String sa = s2.nextLine();
            int[] inputArr = convertToIntArray(sa.split(" "));
            arr[i] = inputArr;
        }

        ArrayClass proc = new ArrayClass();
        System.out.print("[");
        for(int[] num : arr){
            System.out.print(Arrays.toString(num)+", ");
        }
        System.out.println("]");
        System.out.println("Hasil proses Penjumlahan Array dimensi 2: "+ Arrays.toString(proc.twoDimArray(arr)));
    }

    public static int[] convertToIntArray(String[] payload){
        int[] newArr = new int[payload.length];

        for(int i=0; i<payload.length; i++){
            newArr[i] = Integer.parseInt(payload[i]);
        }

        return newArr;
    }

}