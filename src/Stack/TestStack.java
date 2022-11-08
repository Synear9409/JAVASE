package Stack;

import java.util.Arrays;

public class TestStack {
	private int[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;
    
    /**
     * 不带初始容量的构造方法。默认容量为8
     */
    public TestStack() {
    	this.storage = new int[8];
    	this.capacity = 8;
    	this.count = 0;
    }
    /**
     * 带初始容量的构造方法
     * @param intCapacity
     */
    public TestStack(int intCapacity) {
    	if(intCapacity < 1) {
    		throw new IllegalArgumentException("Capacity too small.");
    	}
    	this.capacity = intCapacity;
    	this.storage = new int[intCapacity];
    	this.count = 0;
    }
    /**
     * 入栈
     * @param args
     */
    public void push(int value) {
    	if(count == capacity) {
    		ensureCapacity();
    	}
    	storage[count++] = value; ///下标从0开始 先赋值后自加
    	
    }
    /**
     * 确保容量大小
     */
	private void ensureCapacity() {
		int newCapacity = capacity * GROW_FACTOR;
		storage = Arrays.copyOf(storage, newCapacity);
		capacity = newCapacity;
	}
	/**
	 * 返回栈顶元素出栈
	 * @param args
	 */
	private int pop() {
		if(count == 0) {
			throw new IllegalArgumentException("storage is empty.");
		}
		count--;
		return storage[count];
	}
	/**
	 * 返回栈顶元素不出栈
	 * @param args
	 */
	private int peek() {
		if(count == 0) {
			throw new IllegalArgumentException("storage is empty.");
		}else {
			return storage[count-1];
		}
	}
	/**
	 * 判断栈是否为空
	 * @param args
	 */
	private boolean isEmpty() {
		return count == 0;
	}
	/**
	 * 返回栈中元素的个数
	 * @param args
	 */
	private int size() {
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStack Ts = new TestStack(3);
		Ts.push(1);
		Ts.push(2);
		Ts.push(3);
		Ts.push(4);
		Ts.push(5);
		Ts.push(6);
		Ts.push(7);
		Ts.push(8);
		for(int item : Ts.storage) {
			System.out.print(item+" ");
		}
		System.out.println("");
		System.out.println("栈顶元素为："+Ts.peek());
		System.out.println("栈的元素数量："+Ts.size());
		for (int i = 0; i < 8; i++) {
			System.out.println("移除栈顶元素："+Ts.pop());
		}
		System.out.println("栈是否为空？"+Ts.isEmpty());
		for(int item : Ts.storage) {
			System.out.print(item+" ");
		}
		// System.out.println("栈顶元素为："+Ts.pop());///报错：java.lang.IllegalArgumentException: storage is empty.
	}

}
