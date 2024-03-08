package customerror;

public class DuplicateIdException extends RuntimeException{
    public DuplicateIdException(String msg){
        super(msg);
    }
}
