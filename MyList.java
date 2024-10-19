package Nested;

public class MyList <T> {
    private T[] list ;
    private int capacity;

    public MyList(){
        this.capacity=10;
        this.list = (T[]) new Object[capacity];
    }

    public MyList(int capacity){
        this.capacity=capacity;
        this.list = (T[]) new Object[capacity];
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(T data){
      int item = size();
      if(item == capacity){
          increaseCapacity(item);
      }
      else {
          list[item] = data;
      }
    }

    public int size(){
        int counter=0;
        for(T i: list){
            if(i != null){
                counter+=1;
            }
            else{
                break;
            }
        }
        return counter;
    }

    private void increaseCapacity(int size) {
        capacity *= 2;
        T[] newList = (T[]) new Object[capacity];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    public T get(int index){
        int size = size();
        if(size<index){
            return null;
        }
        else{
            return list[index];
        }
    }

    public void remove(int index){
        int size = size()-1;
        for(int i=index; i<size; i++){
            list[i] = list[i+1];
        }
        list[size] = null;
    }
    
    public Object set(int index, T data){
        int size = size();
        if(size<index){
            return null;
        }
        else{
            list[index] = data;
            return 1;
        }
    }

    public int indexOf(T data){
        int size = size();
        for(int i=0; i<size; i++){
            if(list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        int size = size();
        return size == 0;
    }

    public void clear(){
        int size = size();
        for(int i=0; i<size; i++){
            list[i] = null;
        }
    }

    public MyList<T> sublist(int start,int finish){
        int j=0;
        MyList<T> newlist = new MyList<>();
        for(int i=start; i<finish; i++){
             newlist.add(list[i]);
        }
        return newlist;
    }

    public boolean contains(T data){
        int size = size();
        for(int i=0; i<size; i++){
            if(list[i] == data){
                return true;
            }
        }
        return false;
    }

    public void printElements() {
        for (T element : list) {
            if (element != null) {
                System.out.print(" " + element);
            }
        }
        System.out.println();
    }


}
