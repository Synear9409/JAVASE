package JavaIO.StudentSort;

import JavaIO.UserLogin.InputUtil;

public class Menu {
    private VoteService voteService;

    public Menu(){
       this.voteService = Factory.getInstance();
       this.vote();
    }

    public void vote(){   //投票
        Student[] stu = this.voteService.getData();
        for(Student temp : stu){
            System.out.println(temp.getSid()+" : " + temp.getName() + " : 【" + temp.getVote() + "】" );
        }
        int num = 10;
        while(num != 0){  //循环投票
            num = InputUtil.getInt("请输入班长候选人代号(数字0代表结束程序)：");
            if(num != 0 ){
                if(!this.voteService.inc(num)){
                    System.out.println("次选票无效，请输入正确的候选人代号！");
                }
            }
        }
        System.out.println("投票最终结果：");
        stu = this.voteService.result();
        System.out.println(stu[0].getName() + "同学，以"+stu[0].getVote()+"票，当选班长");
    }
}
