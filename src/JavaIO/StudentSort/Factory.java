package JavaIO.StudentSort;


///工厂类
public class Factory {
    
    private Factory(){}

    public static VoteService getInstance(){
        return new VoteServiceImp();
    }
}