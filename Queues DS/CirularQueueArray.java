public class CirularQueueArray {

    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n)
        {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        //is empty
        public boolean isEmpty()
        {
            return rear == -1 && front == -1;
        }

        //full
        public boolean isFull()
        {
            return (rear+1) % size == front;
        }
        
        //enqueue
        public void add(int data)
        {
            if(isFull())
            {
                System.out.println("Queue is full");
                return;
            }

            //inserting the first element.
            if(front == -1)
            {
                front = 0;
            }

            rear = (rear+1) % size;
            arr[rear] = data;
        }

        //dequeue
        public int remove()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];
            //deleting last element
            if(rear == front)
            {
                rear = front = -1;
            }
            else
            {
                front = (front+1)%size;
            }
            return result;
        }

        //front
        public int peek()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty())
        {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
