public class ArrayClass {
    private int[] array1;
    private int[] newArray;

    public ArrayClass(){
        this.array1 = new int[0];
    }

    public ArrayClass(int[] a1){
        this.array1 = a1;
    }

    public int arraySum(){
        int sum = 0;
        for(int num : this.array1){
            sum+= num;
        }
        return sum;
    }

    public int[] twoDimArray(int[][] payload){
        int[] sumArray = new int[payload.length];
        for(int i=0; i< payload.length; i++){
            int sum = 0;
            for(int num : payload[i]){
                sum += num;
            }
            sumArray[i] = sum;
            sum = 0;
        }

        return sumArray;
    }

    public int[] transposeArray(int[] payload){
        this.newArray = new int[payload.length];
        int j = payload.length-1;
        for(int i=0; i<newArray.length;i++){
            newArray[i] = payload[j];
            j--;
        }

        return this.newArray;
    }

}
