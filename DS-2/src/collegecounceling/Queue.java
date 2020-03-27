package college_counseling;

public class Queue{
    int rear, front;
    int capacity;
    String queue[];
    int fatchDataCount;

    Queue(){}
    
    Queue(int capacity) {
        this.rear = -1;
        this.front = -1;
        this.capacity = capacity;
        this.queue = new String[this.capacity];
    }

    public int size() {
        return ((this.capacity - this.front + this.rear + 1) % (this.capacity));
    }

    public boolean isFull() {
        return ((this.rear + 1) % this.capacity == this.front);
    }

    public boolean isEmpty() {
        return (this.front == -1);
    }

    public void add(String value) {
        if (isFull()) {
            System.out.println("Overflow");
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            this.queue[this.rear] = value;
            if (this.front == -1) {
                this.front = this.rear;
            }
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (this.front == this.rear) {
                this.front = this.rear = -1;
            } else {
                this.front = (this.front + 1) % this.capacity;
            }
        }
    }

    public void show() {
        int temporary1 = this.front;
        int i = 0, size;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (size() == 0) {
                size = 4;
            } else {
                size = size();
            }
            while (i < size) {
                System.out.print(this.queue[temporary1]+" ");
                temporary1 = (temporary1 + 1) % this.capacity;
                i++;
            }
        }
        System.out.println();
    }

    public String[] getQueue() {
        return queue;
    }
}
