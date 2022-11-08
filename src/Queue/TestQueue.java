package Queue;

import java.util.Arrays;

public class TestQueue {

    private int[] storage;///存储元素的队列
    private int capacity;///队列容量
    private int count;///队列里的元素个数
    private int index = 0; 

    private static final int GROW_FACTOR = 2;

    public TestQueue(){
        this.storage = new int[8];
        this.capacity = 8;
        this.count = 0;
    }

    public TestQueue(int initCapacity){
        if(initCapacity < 1){
            throw new IllegalArgumentException("Capacity too small.");
        }
        this.storage = new int[initCapacity];
        this.capacity = initCapacity;
        this.count = 0;
    }

    /**
         * 从队头入队列
         * @param args
         */
    public void offer(int value){
        if(count == capacity){
            int newCapacity = capacity * GROW_FACTOR;
            storage = Arrays.copyOf(storage, newCapacity);
            capacity = newCapacity;
        }
        storage[count++] = value;
    }

    /**
	 * 移除队头元素出队列
	 * @param args
	 */
    public void poll(){
        for(int i = 0;i < storage.length-1;i++){
            storage[i] = storage[i+1];   
        }
        count --;
        capacity --;
        storage = Arrays.copyOf(storage,count);
    }

    /**
	 * 返回队列头元素不出列
	 * @param args
	 */
    public int peek(){
        return storage[0];
    }

    public static void main(String[] args) {
        TestQueue tq = new TestQueue(3);
        tq.offer(1);
        tq.offer(2);
        tq.offer(3);
        for(int i : tq.storage){
            System.out.print(i);
        }
        tq.poll();
        System.out.println();
        System.out.println(tq.storage.length+" "+tq.count+" "+tq.capacity);
        // System.out.println("返回队头元素"+tq.peek());
        for(int i : tq.storage){
            System.out.print(i);
        }
        tq.offer(4);
        System.out.println();
        for(int i : tq.storage){
            System.out.print(i);
        }
        
        // System.out.println(tq.storage.length);
        
        
    }
}