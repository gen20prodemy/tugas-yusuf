public class OddEven {
    public String Determine(int a, int b){
        var c = a+b;
        if (c%2 != 0){
            return "ganjil";
        }
        return "genap";
    }
}
