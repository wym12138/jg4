package duilie;

public class cricledeque2 <E>{
    private int size;
    private E[] elements;

    private int front;//记录队头元素//默认为0
    private int index(int index){//循环转换坐标
        index+=front;
        if (index<0){
            return index+ elements.length;
        }else {
            return  index % elements.length;
        }

        //优化算法
        //return index-(index>=elements.length? elements.length : 0);
    }

    public cricledeque2() {
        elements = (E[]) new Object[10];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear(){
        size=0;
        for (int i=0;i<size;i++){
            elements[index(i)]=null;
        }
        front=0;
    }

    public void enQueueRear(E element) {//入队
        ensureCapacity(size + 1);
        //***************
        elements[(front + size) % elements.length] = element;
        size++;
    }
    public void enQueueFront(E element){
        ensureCapacity(size+1);
        front=index(-1);
        elements[front]=element;
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
    public E deQueuefront () {
        E element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }
    public E deQueuerear () {
        int rearindex=index(size-1);
        E element = elements[rearindex];
        elements[rearindex]=null;
        size--;
        return element;

    }

    public E front () {
        return elements[front];
    }

    public E rear(){
        return elements[index(size-1)];
    }
}
