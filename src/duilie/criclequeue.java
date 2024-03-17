package duilie;

public class criclequeue<E> {//类似数组
    private int size;
    private E[] elements;

    private int front;//记录队头元素//默认为0
    private int index(int index){//循环转换坐标
        return (front+index)%elements.length;
    }

    public criclequeue() {
        elements = (E[]) new Object[10];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(E element) {//入队
        ensureCapacity(size + 1);
        //***************
        elements[(front + size) % elements.length] = element;
        size++;


    }

    private void ensureCapacity(int newcapacity) {
        int oldcap = elements.length;
        if (oldcap >= newcapacity) {
            return;
        } else {
            int new1 = oldcap + (oldcap >> 1);//1.5倍
            E[] newElement = (E[]) new Object[new1];
            for (int i = 0; i < size; i++) {
                newElement[i] = elements[(i + front) % elements.length];
            }
            front = 0;
            elements = newElement;
        }
    }
        public E deQueue () {
            E element = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return element;
        }

        public E front () {
            return elements[front];
        }

}
