package Queue;

public class testLinkQueue {
    public static void main(String[] args) {
        LinkQueue<Integer> lq = new LinkQueue<>();
        lq.offer(1);
        lq.offer(2);
        lq.offer(3);
        lq.offer(4);

        for(Object i : lq.toArray()){
            System.out.println(i);
        }
        
        // lq.poll();
        // for(Object i : lq.toArray()){
        //     System.out.println(i);
        // }

        System.out.println("元素个数为："+lq.size());
        
        System.out.println("队列是否为空？"+lq.isEmpty());
    }
}