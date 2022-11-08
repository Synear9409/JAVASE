package LinkList;

public class LinkDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImp<>();
        System.out.println("【增加之前】数据个数："+all.size()+"是否为空："+all.isEmpty());
        all.add("火车头");
        all.add("车厢");
        all.add("火车尾");
        // all.setNode(2, "hat");
        // all.remove("火车尾");
        all.clean();
        System.out.println("【增加之后】数据个数："+all.size()+"是否为空："+all.isEmpty());
        // Object[] obj = all.toArray();
        // for(Object o : obj){
        //     System.out.println(o);
        // }
        // System.out.println("-----------------数据获取--------------------");
        // System.out.println(all.get(0));
        // System.out.println(all.get(2));
        // System.out.println(all.get(4));
    }
}