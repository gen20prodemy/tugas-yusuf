public class Modulus {
    public int n;

    public Modulus(int n){
        this.n = n;
    }

    public void printNumber(){
        int n = this.n;
        int count = 0;
        int i = 1;
        while(count<n){
            if(i%3==0&& i%2!=0){
                System.out.print(i+" ");
                count += 1;
                i +=1;
            } else{
                i+=1;
            }
        }
    }
}
