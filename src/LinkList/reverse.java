package LinkList;

/**
 * 反转链表
 */
    public class reverse {
        private static class Node{
            private int val;
            private Node next;
            public Node(int val){
                this.val = val;
            }

            public void printNode(Node node){
                System.out.print(node.val+"->");
                if(node.next != null){
                    printNode(node.next);
                }
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        /**
         * 反转链表
         * @param node
         * @return
         */
        public static Node reverseList(Node node){
            if(node == null || node.getNext() == null){
                return node;
            }
            //头节点的下一节点元素
            Node prev = reverseList(node.getNext());
            ///改变指针指向
            node.getNext().setNext(node);
            ///断掉头节点原来的引用
            node.setNext(null);

            return prev;
        }


        public static void main(String[] args) {
            Node a = new Node(1);
            Node b = new Node(2);
            Node c = new Node(3);
            Node d = new Node(4);
            Node e = new Node(5);
            Node f = new Node(6);
            Node g = new Node(7);
            Node h = new Node(8);
            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
            e.next = f;
            f.next = g;
            g.next = h;

            a.printNode(a);
            Node es = reverseList(a);
            System.out.println();
            a.printNode(es);

        }
    }

