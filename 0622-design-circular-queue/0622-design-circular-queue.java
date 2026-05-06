class MyCircularQueue {

    int[] arr;
    int front = 0; 
    int rear = -1; 
    int size = 0;
    public MyCircularQueue(int k) {
        arr=new int[k];
    }
    
    public boolean enQueue(int value) {
        if (size == arr.length) return false; 
        rear = (rear + 1) % arr.length; 
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false; 
        front = (front + 1) % arr.length; 
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : arr[front];
    }
    
    public int Rear() {
        return size == 0 ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

