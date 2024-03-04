public class Student {
    private int age;

    public Student(int age) throws CustomAgeException{
        if(age<0){
            throw new CustomAgeException("Age can't be negative");
        }
        this.age=age;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) throws CustomAgeException {
        if(age<0){
            throw new CustomAgeException("Age can't be negative");
        }
        this.age=age;
    }
}
