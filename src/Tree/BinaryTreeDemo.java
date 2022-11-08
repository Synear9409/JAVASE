package Tree;
import java.util.Arrays;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<Person>();
        tree.add(new Person("A", 80));
        tree.add(new Person("B", 30));
        tree.add(new Person("k", 15));
        tree.add(new Person("C", 60));
        tree.add(new Person("D", 89));
        tree.add(new Person("L", 87));
        tree.add(new Person("M", 88));
        tree.add(new Person("E", 95));
        tree.add(new Person("F", 90));
        tree.add(new Person("G", 70));
        tree.add(new Person("H", 10));
        tree.add(new Person("I", 55));
        tree.add(new Person("J", 50));
        tree.remove(new Person("A", 80));
        System.out.println(Arrays.toString(tree.toArray()));
        // System.out.println(tree.contains(new Person("H", 10)));

    }
}

class BinaryTree<T extends Comparable<T>>{
    private class Node{
        private Comparable<T> data;
        private Node left;      ////左子树
        private Node right;    ///右子树
        private Node parent;   ////父节点

        private Node(Comparable<T> data){
            this.data = data;
        }

        public void addNode(Node newNode) {
            if(newNode.data.compareTo((T) this.data) < 0) {  ///若比根节点小
                if(this.left == null){ ///左子树节点为空
                    this.left = newNode;
                    newNode.parent = this;  ///设置父节点
                }else{
                    this.left.addNode(newNode);///继续向下判断
                    
                }
            }else{  ///比根节点大
                if(this.right == null){ ////右子树节点为空
                    this.right = newNode;
                    newNode.parent = this;  ///设置父节点
                }else{
                    this.right.addNode(newNode);  ///继续向下判断
                }
            }
        }

        /**
         * 实现所有数据的获取处理，按照中序遍历的形式来完成
         */
        public void toArrayNode(){
            if(this.left != null){  ///有左子树节点
                this.left.toArrayNode();  // 递归调用
            }
            BinaryTree.this.returnData[BinaryTree.this.foot ++] = this.data;
            if(this.right != null){
                this.right.toArrayNode();
            }
        }

        /**
         * 
         * @param data  要查找的数据
         * @return   查到返回true，否则false
         */
        public boolean containsNode(Comparable<T> data){
            if(data.compareTo((T)this.data) == 0){
                return true;   ///查到了
            }else if(data.compareTo((T)this.data) < 0){   ///数据在左边
                if(this.left != null){
                    return this.left.containsNode(data);  ///不为空则往下递归
                }else{
                    return false;
                }
            }else{                     ///数据在右边
                if(this.right != null){
                    return this.right.containsNode(data); ///不为空则往下递归
                }else{
                    return false;
                }
            }
        }

        /**
         * 获取要删除的节点
         * @param data  比较的对象
         * @return  要删除的对象，对象一定存在
         */
        public Node getRemoveNode(Comparable<T> data){
            if(data.compareTo((T)this.data) == 0){
                return this;
            }else if(data.compareTo((T)this.data) < 0){  
                if(this.left != null){
                    return this.left.getRemoveNode(data);
                }else{
                    return null;
                }
            }else{
                if(this.right != null){
                    return this.right.getRemoveNode(data);
                }else{
                    return null;
                }
            }
        } 
    }

    ///----------------以下为二叉树的功能实现------------------

    private Node root;   ///根节点
    private int count;  ///保存数据的个数
    private int foot;   ///数据的脚标
    private Object[] returnData; /// 返回的数据用数组封装

    /**
     * 添加数据功能
     * @param data  需要保存的数据内容
     */
    public void add(Comparable<T> data){
        if(data == null){
            throw new NullPointerException("保存的数据不允许为空");
        }
        ////所有的数据本身不具备节点关系的匹配，那么一定要将其保存进Node类中
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
       this.count++;
    }

    /**
     * 以对象数组的形式返回全部数据，如果没有数据则返回null
     * @param returnData   全部数据
     * @return
     */
    public Object[] toArray(){
        if(this.count == 0){
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;      ///将脚标清零
        this.root.toArrayNode();
        return this.returnData; ///返回全部数据
    }

    /**
     * 检索依靠的是Comparable实现数据的比较
     * @param data   要比较的数据
     * @return  查到数据返回true，否则false
     */
    public boolean contains(Comparable<T> data){
        if(this.count == 0){   ///没有数据
            return false;
        }
        return this.root.containsNode(data);
    }

    public void remove(Comparable<T> data){
        if(this.root == null){
            return;
        }else{
            if(this.root.data.compareTo((T)data) == 0){   ///表示要删除的是根节点
                Node moveNode = this.root.right;  //从要删除节点的右节点开始遍历
                if(moveNode.left == null){            /// 情况四1：若根节点的右子树节点的左节点直接为空时
                    moveNode.left = this.root.left;
                    this.root = moveNode;  ///根节点改变了
                }else{
                    while(moveNode.left != null){   ///若要移动的节点存在左子节点
                        moveNode = moveNode.left;  ///一直向左寻找
                    }  ///循环完则找到删除节点的右节点的最小的左节点
                    if(moveNode.right != null){         // 情况四2：当移动节点不存在左子节点而存在右子节点时
                        Node temp = null;
                        moveNode.left = this.root.left; 
                        temp = moveNode.right;   
                        moveNode.parent.left = temp;
                        moveNode.right = this.root.right;
                        this.root = moveNode;   //根节点改变了
                    }else{                             // 情况四3：当移动节点不存在左右子节点时
                        moveNode.left = this.root.left;
                        moveNode.right = this.root.right;
                        moveNode.parent.left = null;
                        this.root = moveNode;  ///根节点改变了
                    }
                }
            }else{
                Node removeNode = this.root.getRemoveNode(data);      //找到要删除的信息
                // System.out.println(removeNode.data);
                if(removeNode != null){   
                    ///情况一：删除的数据无左右子树节点
                    if(removeNode.left == null && removeNode.right == null){
                        removeNode.parent.left = null;
                        removeNode.parent = null;   ///直接与父节点断开联系
                    }else if(removeNode.left != null && removeNode.right == null){            ///情况二：删除的数据有左子树节点
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    }else if(removeNode.right != null && removeNode.left == null){            ///情况二：删除的数据有右子树节点
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    }else{          ////情况三：要删除的数据两边都有节点，则将右边节点中最左边的节点找到，改变其指向
                        Node moveNode = removeNode.right;  //从要删除节点的右节点开始遍历
                        while(moveNode.left != null){   ///若要移动的节点存在左子节点
                            moveNode = moveNode.left;  ///一直向左寻找
                        }  ///循环完则找到删除节点的右节点的最小的左节点
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null;   //断开原来的联系
                        moveNode.parent = removeNode.parent;  ///修改移动节点的父节点
                        moveNode.right = removeNode.right;   //改变右节点指向
                        moveNode.left = removeNode.left;    //改变左节点指向
                    }
                }
            }
            this.count--;
        } 
    }
}

class Person implements Comparable<Person>{ 
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Person per) {
        return this.age - per.age;
    }
}