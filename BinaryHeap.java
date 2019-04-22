public class BinaryHeap {

    public int[] data = new int[10];//initialize array size of 10
    int size = 0;


    public  void add(int item){
        if(size == data.length){
            grow();
        }
        data[size++]= item;
        int current = size -1;
        int parent = (current-1)/2;

        while(data[current]<data[parent]&& current!=0){
            swap(data,current, parent);
            current = parent;
            parent = (parent-1)/2;
        }
    }


    private void grow() {
        int new_Array[] = new int[data.length*2];
        for(int i = 0; i < size; i++){
            new_Array[i] = data[i];
        }
        data = new_Array;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public int remove(){
        swap(data, 0, size-1);
        --size;
        if (size > 0){
            shiftdown(0);
        }
        return data[size];
    }

    public void shiftdown(int pos){
        int parent = pos;
        int left_child = parent *2+ 1;
        int right_child = parent *2 +2;


        if(left_child >= size || right_child >= size){
            return;
        }

        if(data[left_child] <data[right_child] && data[left_child] < data[pos]){
            swap(data, left_child, pos);
            shiftdown(left_child);
        }
        
        else if(data[right_child] < data[left_child] && data[right_child]< data[pos]){
            swap(data,right_child,pos);
            shiftdown(right_child);
        }
    }


}