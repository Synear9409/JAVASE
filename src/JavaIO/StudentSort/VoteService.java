package JavaIO.StudentSort;

public interface VoteService {
    
    public boolean inc(int sid);   ///根据编号增长

    public Student[] result();   ///获取投票的结果

    public Student[] getData();   ///获取全部数据

}