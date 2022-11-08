package Queue;


public class LinkQueue<T>{
    private class Node {
        // 存储的数据
        private T data;
        // 下一个节点的引用
        private Node next;
    
        public Node(T data) {
            this.data = data;
        }
    
        public T getData() {
            return data;
        }
    
        public void setData(T data) {
            this.data = data;
        }
    
        public Node getNext() {
            return next;
        }
    
        public void setNext(Node next) {
            this.next = next;
        }

        public void toArrayNode(){
            LinkQueue.this.returnData[LinkQueue.this.index++] = this.data;
            if(this.next != null){   ////还有下一个数据
                this.next.toArrayNode();
            }
        }
    
    }
    // 队头
    private Node front;
    // 队尾
    private Node behind;
    // 元素个数
    private int size;
    ///元素列表
    private Object[] returnData;
    ///脚标
    private int index = 0;

    /**
     * 创建队列
     */
    public LinkQueue() {
        behind = front = null;
    }

    /**
     * 入队列
     * 
     * @param data
     */
    public void offer(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            front = behind = node;
        } else {
            behind.setNext(node);
            behind = node;
        }
        size++;
    }

    /**
     * 出队列
     * 
     * @return 返回数据
     */
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        Node delete = front;
        front = delete.getNext();
        delete.setNext(null); // help GC
        size--;

        if (size == 0) {
            // 删除掉最后一个元素时，front值已经为null，但behind还是指向该节点，需要将behind置为null
            // 最后一个结点front和behind两个引用都没指向它，帮助GC处理该节点对象
            behind = front;
        }
        return (T)delete.getData();
    }

    /**
     * 判断队列是否为空
     * @return 
     */
    public boolean isEmpty() {
        return (front == null && behind == null) ? true : false;
    }

    /**
     * 获取队列的元素个数
     * @return
     */
    public int size() {
        return this.size;
    }

    public Object[] toArray(){
        if(this.isEmpty()){  ///空集合
            return null;     ///没有数据
        }
        this.index = 0;
        this.returnData = new Object[this.size];
        this.front.toArrayNode(); //递归循环
        return this.returnData;
    }
}