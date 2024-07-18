public class LinkedListDeque<Dudu> {
        private IntNode sentinel;
        private int size;
        // 采用头部和尾部连接成环的方法来构建双向链表
        public class IntNode {
            public Dudu item;

            //头部的哨兵节点
            public IntNode prev;
            public IntNode next;
            //尾部的哨兵节点

            public IntNode(Dudu _item, IntNode _prev, IntNode _next) {
                item = _item;
                prev = _prev;
                next = _next;
            }
        }

        public LinkedListDeque() {
            sentinel = new IntNode(null ,sentinel,null);
            size = 0;
        }
        public void addFirst(Dudu x) {
            if (sentinel.next == null) {
                sentinel.next = new IntNode(x,sentinel,null);
                sentinel.prev = sentinel.next;
                size = size + 1;
                return;
            }
            IntNode node = sentinel.next;
            sentinel.next = new IntNode(x,sentinel,node);
            node.prev = sentinel.next;
            size = size + 1;
        }

        public void addLast(Dudu x) {
            if (sentinel.prev == null) {
                sentinel.prev = new IntNode(x,sentinel,sentinel);
                sentinel.next = sentinel.prev;
                size = size + 1;
                return;
            }
            IntNode lastnode = sentinel.prev;
            lastnode.next = new IntNode(x,lastnode,sentinel);
            sentinel.prev = lastnode.next;
            size = size + 1;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        public void printDeque() {
            IntNode p = sentinel;
            while (p.next.next != sentinel) {
                p = p.next;
                System.out.println(p.item);
                System.out.println(" ");
            }
            p = p.next;
            System.out.println(p.item);
            System.out.println("\n");
        }

        public Dudu removeFirst() {
            Dudu result = sentinel.next.item;
            IntNode p = sentinel.next.next;
            sentinel.next = p;
            return result;
        }

        public Dudu removeLast() {
            IntNode p = sentinel;
            while (p.next.next != sentinel) {
                p = p.next;
            }
            Dudu result = p.next.item;
            p.next = sentinel;
            return result;
        }

        public Dudu get(int index) {
            int counts = 0;
            IntNode p = sentinel;
            if (index == 0) {
                return p.item;
            }
            while (p.next != sentinel) {
                p = p.next;
                counts = counts + 1;
                if (counts == index) {
                    return p.item;
                }
            }
            return null;
        }
}
