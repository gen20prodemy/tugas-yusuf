public class Throws {

    public static void ArithmethicsExceptionExample(int s){
        try{
            int result = s/0;
        } catch (ArithmeticException e){
            System.out.println("error: "+ s +e.getMessage());
        }

        System.out.println("end");
    }

    public static void ArrayExceptionExample() throws ArrayStoreException{
        Object[] x = new String[3];
        x[0] = 0;
    }

    public static void NullPointerXception(){
        String str = null;
        try{
            int length = str.length();
        } catch (NullPointerException e){
            System.out.println("Block Catch");
            System.out.println("error: "+e.getMessage());
        } finally {
            System.out.println();
            System.out.println("successfully executed");
        }
        System.out.println("end");
    }

    public static void ArrayOutOfBound(){
        int[] arr = new int[5];
        try{
            int value = arr[10];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error: "+e.getMessage());
        }
        System.out.println("end");
    }

    public static void IllegalArgument(){
        int age = -1;
        System.out.println("age: "+ age);
        if(age<0){
            throw new IllegalArgumentException("error: age must not be negative");
        }
    }

    public static void NumberFormat(){
        String str = "asd";
        try{
            int val = Integer.parseInt(str);
        }catch (NumberFormatException e){
            System.out.println("block catch");
            System.out.println("error: "+e.getMessage());
        }

        System.out.println("end");
    }

    public static void NegativeArray(){
        try{
            int[] arr = new int[-1];
        } catch (NegativeArraySizeException e){
            System.out.println("error: "+e.getMessage());
        }
        System.out.println("end");
    }

}
