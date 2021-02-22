package DataStructures;

public class BasicStackWithArray<X> {
    private X data[];
    private int stackpointer;

    public BasicStackWithArray(){
        data = (X[]) new Object[100];
        stackpointer =0;
    }

    public void push(X item){
        data[stackpointer] = item;
        stackpointer++;
    }

    public X pop(){
        if (stackpointer <0){
            throw new IllegalArgumentException("stack is empty");
        }
        return data[--stackpointer];
    }

    public boolean contains(X item){
        boolean found = false;
        for(int i=0;i<stackpointer;i++){
            if(data[i].equals(item)){
                found = true;
            }
        }
        return found;
    }

    public X access(X item){
        while (stackpointer > 0){
            X tempitem = pop();
            if(item.equals(tempitem)){
                return tempitem;
            }
        }
        throw new IllegalArgumentException("item not found");
    }

    public int size(){
        return stackpointer;
    }
}
