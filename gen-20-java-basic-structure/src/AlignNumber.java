public class AlignNumber {
    private int n;

    public AlignNumber(int n){
        this.n = n;
    }

    public int getResult(){
        int n = this.n;
        int result = 0;
        for(int i=1; i<=n; i++){
            result += i;
        }
        return result;
    }
}
