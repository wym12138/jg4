public class arraylist {
    private int size;
    private int[] elements;

    private static final int DEFAYLT_CAPACITY=10;
    private static final int ELEMENT_NOTFOUND=-1;


    public arraylist(int capaticy){
        capaticy=(capaticy<0)?DEFAYLT_CAPACITY:capaticy;//三元
        elements=new int[capaticy];

    }
    public arraylist(){
        this(DEFAYLT_CAPACITY);
    }

    public void clear(){
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int element){
        elements[size]=element;
        size++;

    }
    public int get(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        return elements[index];
    }

    public int set(int index,int element){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        int old=elements[index];
        elements[index]=element;
        return old;
    }

    public void add(int index,int element){


    }

    public int remove(int index){//挪动
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("index越界");//索引越界异常
        }
        int old=elements[index];
        for (int i=index+1;i<=size-1;i++){
            elements[i-1]=elements[i];
        }
        size--;

        return old;
    }

    public int indexOf(int element){//写元素返回索引
        for (int i=0;i<size;i++){
            if (element==elements[i])
                return i;
        }
        return ELEMENT_NOTFOUND;

    }

    public boolean contains(int element){
        return indexOf(element)!=ELEMENT_NOTFOUND;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<size;i++){
            sb.append(elements[i]);
            sb.append(" ");
        }
        return sb.toString();
    }



}
