import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        try{
            System.out.println("contoh exception: ");
            System.out.println("1. ArithmethicsExceptionExample");
            System.out.println("2. ArrayExceptionExample");
            System.out.println("3. NullPointerXception");
            System.out.println("4. ArrayOutOfBound");
            System.out.println("5. IllegalArgument");
            System.out.println("6. NumberFormat");
            System.out.println("7. NegativeArray");
            System.out.println("8. Custom Age Exception");
            System.out.print("pilih menu: ");
            Scanner s = new Scanner(System.in);
            int c = s.nextInt();

            switch (c){
                case 1:
                    Throws.ArithmethicsExceptionExample(10);
                    break;
                case 2:
                    Throws.ArrayExceptionExample();
                    break;
                case 3:
                    Throws.NullPointerXception();
                    break;
                case 4:
                    Throws.ArrayOutOfBound();
                    break;
                case 5:
                    Throws.IllegalArgument();
                    break;
                case 6:
                    Throws.NumberFormat();
                    break;
                case 7:
                    Throws.NegativeArray();
                    break;
                case 8:
                    customError();
                    break;
                default:
                    System.out.println("menu yang dipilih tidak ada");
                    System.out.println();
                    menu();
                    break;
            }
        } catch (NumberFormatException | CustomAgeException e){
            System.out.println("mohon masukkan hanya angka");
            System.out.println();
            menu();
        }
    }

    public static void customError() throws CustomAgeException {
        try {
            Student student = new Student(-100);
            System.out.println(student.getAge());
        } catch (CustomAgeException e){
            System.out.println("error: " + e.getMessage());
        }
    }
}