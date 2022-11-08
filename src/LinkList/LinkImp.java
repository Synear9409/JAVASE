package LinkList;

public class LinkImp<E> implements ILink<E>{

    private class Node{       ////保存节点的数据关系
        private E data;        ///保存的数据
        private Node next;      ///保存下一个引用
        public Node(E data){          ///有数据时才有意义
            this.data = data;
        }

        ///第一次调用：this = LinkImp.root
        ///第二次调用：this = LinkImp.root.next;
        ///第三次调用：this = LinkImp.root.next.next;
        public void addNode(Node newNode){  ///保存新的Node数据
            if(this.next == null){    ///当前节点的下一个节点为空时
                this.next = newNode;  ///保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }
        ///第一次调用：this = LinkImp.root
        ///第二次调用：this = LinkImp.root.next;
        ///第三次调用：this = LinkImp.root.next.next;
        public void toArrayNode(){
            LinkImp.this.returnData[LinkImp.this.foot++] = this.data;
            if(this.next != null){   ////还有下一个数据
                this.next.toArrayNode();
            }
        }

        public E getNode(int index){
            if(LinkImp.this.foot ++ == index){
                return this.data;
            }else{
                return this.next.getNode(index);
            }  
        }

        public void setNode(int index,E data){
            if(LinkImp.this.foot ++ == index){
                this.data = data;
            }else{
                this.next.setNode(index,data);
            }  
        }

        public void removeNode(Node previous,E data){
            if(this.data.equals(data)){
                previous.next = this.next;   ///空出当前节点
            }else{
                if(this.next != null){  ///有后续节点
                    this.next.removeNode(this, data);  //继续向后删除
                }
            }
        }



        public boolean containsNode(E data) {
            if(this.data.equals(data)){
                return true;
            }else{
                if(this.next == null){  ///没有后续节点了
                    return false;    ///找不到
                }else{
                    return this.next.containsNode(data);
                }
            }
        }
    }

    /* --------------------------以下为ILink类中定义的成员---------------------------------- */
    private Node root;      ///保存根元素
    private int count;      ///数据个数
    private int foot;       ///数据脚标
    private Object [] returnData;  ///返回的数据保存

    /* --------------------------以下为ILink类中定义的方法---------------------------------- */
    @Override
    public void add(E e) {
        if(e == null){  ///保存的数据为null
            return ;    ///方法直接调用结束
        }
        ////数据本身是不具有关联特性的，只有Node类有，那么要想实现关联处理，就必须将数据封装到Node类中
        Node newNode = new Node(e);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);    ///把新节点保存在合适的位置
        }
        count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        ///return this.root == null;  用这个效果一样
        return this.count == 0;
    }

    @Override
    public Object[] toArray() {
        if(this.isEmpty()){  ///空集合
            return null;     ///没有数据
        }
        this.foot = 0;  ///将脚标清零
        this.returnData = new Object[this.count];  ///根据已有的长度开辟数组
        this.root.toArrayNode();   ///利用Node类进行递归数据获取
        return this.returnData;
    }

    @Override
    public E get(int index) {
        if(index >= this.count){  ///索引超出范围
            return null;            
        }
        //索引数据的获取应该由Node类完成
        this.foot = 0;
        return this.root.getNode(index);
    }

    @Override
    public void setNode(int index, E data) {
        if(index >= count){
           return ;
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    @Override
    public void remove(E data) {
        if(this.contains(data)){
            if(this.root.data.equals(data)){  ///若是根节点
                this.root = this.root.next;  //将根节点的内容修改为它的下一个节点的值
            }else{          ///若不是删除根节点
                this.root.next.removeNode(this.root, data);
            }
            this.count --;
        }

    }
    @Override
    public boolean contains(E data) {
        if(data == null){
            return false;
        }
        return this.root.containsNode(data);
    }

    @Override
    public void clean() {
        this.root = null;
        this.count = 0;
    }
    
}