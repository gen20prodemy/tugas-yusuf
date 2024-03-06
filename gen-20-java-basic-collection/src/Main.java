import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Barang> list = new ArrayList<>();
        boolean p = true;
        while (p==true){
            Scanner s = new Scanner(System.in);
            System.out.println("Menu bukan Me n U");
            System.out.println("1. Input Barang");
            System.out.println("2. Tampilkan semua barang");
            System.out.println("3. Tampilkan barang pada index n");
            System.out.println("4. konversi list");
            System.out.println("5. keluar program");
            System.out.print("pilih menu (angka saja): ");
            int opt = s.nextInt();

            switch (opt){
                case 1:
                    list = inputBarang(list);
                    System.out.println();
                    break;
                case 2:
                    tampilkanSekumpulanBarang(list);
                    System.out.println();
                    break;
                case 3:
                    s.nextLine();
                    System.out.print("masukkan index yang ingin dilihat nilainya (0-"+(list.size()-1)+"): ");
                    int index = s.nextInt();
                    tampilkanBarang(list, index);
                    System.out.println();
                    break;
                case 4:
                    konversiList(list);
                    System.out.println();
                    break;
                case 5:
                    p=false;
                    break;
                default:
                    System.out.println("menu tidak ada!!");
                    break;
            }
        }
    }

    public static List<Barang> inputBarang(List<Barang> list){
        List<Barang> listBarang = list;
        int jumlahBarang=0;

        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan jumlah barang yang ingin diinput: ");
        try{
            jumlahBarang = s.nextInt();
        }catch (NumberFormatException e){
            System.out.println("masukkan hanya angka!!!");
            System.out.println();
            inputBarang(list);
        }

        s.nextLine();
        for (int i = 0; i<jumlahBarang; i++){
            System.out.print("masukkan nama barang: ");
            String barang = s.nextLine();
            listBarang.add(new Barang(barang));
        }

        return listBarang;
    }

    public static void tampilkanSekumpulanBarang(List<Barang> listBarang){
        System.out.println("Data pada List");
        listBarang.forEach(System.out::println);
    }

    public static void tampilkanBarang(List<Barang> listBarang, int index){
        if(index<0){
            System.out.println("index tidak valid");
            return;
        }
        System.out.println("Data ke-"+index+": "+listBarang.get(index));
    }

    public static void konversiList(List<Barang> listBarang){
        System.out.println();

        System.out.print("ArrayList: ");
        System.out.println(listBarang);
        System.out.println();

        LinkedList<Barang> linkedList = new LinkedList<>(listBarang);
        System.out.println("Convert ke LinkedList: "+linkedList);
        System.out.println();

        HashSet<Barang> set = new HashSet<>(listBarang);

        System.out.print("Convert menjadi HashSet: ");
        System.out.println(set);
        System.out.println();

        HashMap<Integer, Barang> map = new HashMap<>();
        int defaultKey = 0;
        for (Barang barang : set){
            map.put(defaultKey++, barang);
        }
        System.out.print("Convert menjadi Map: ");
        System.out.println(map);
    }
}