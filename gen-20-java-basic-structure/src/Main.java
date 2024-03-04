import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Print Class Variable");
        Variabel.PrintVariabel();
        System.out.println();

        System.out.println("Aritmatika sederhana");
        Scanner s = new Scanner(System.in);
        System.out.print("masukkan variabel 1 untuk ditambahkan: ");
        int x = s.nextInt();
        System.out.print("masukkan variabel 2 untuk ditambahkan: ");
        int y = s.nextInt();
        Arithmetics aritmatika = new Arithmetics(x,y);
        System.out.println("Hasil dari aritmatika pertambahan: " + aritmatika.getResult());
        System.out.println();

        System.out.println("Membuat Segitiga");
        System.out.print("masukkan jumlah baris untuk membuat segitiga: ");
        int rows = s.nextInt();
        new Triangle(rows);
        System.out.println();

        System.out.println("Ganjil/Genap");
        System.out.print("masukkan angka pertama: ");
        int intA = s.nextInt();

        System.out.print("masukkan angka kedua: ");
        int intB = s.nextInt();
        System.out.println();

        OddEven gangen = new OddEven();
        System.out.print("hasil dari penjumlahan merupakan angka: ");
        System.out.println(gangen.Determine(intA,intB));
        System.out.println();

        int n = 0;
        while (n<1){
            System.out.print("masukkan jumlah n(bilangan positif lebih dari 0): ");
            n = s.nextInt();
        }

        Modulus mod = new Modulus(n);
        AlignNumber number = new AlignNumber(n);

        System.out.println("Hasil deret bilangan habis dibagi 3 tapi tidak habis dibagi 2 sebanyak "+n+ " bilangan adalah:");
        mod.printNumber();
        System.out.println();
        System.out.println();

        System.out.println("Hasil penjumlahan deret bilangan 1+2+3+...+n: "+ number.getResult());
    }
}