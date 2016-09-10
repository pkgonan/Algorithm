package BasicAlgorithm;

public class PriorityQueue {
    int array[];
    int queuesize;
    int cnt;

    void enqueue(int data){
        if(cnt+1 < queuesize) {
            array[++cnt] = data;

            int p = cnt;
            while (p >= 2 && array[p] > array[p / 2]) {
                int temp = array[p];
                array[p] = array[p / 2];
                array[p / 2] = temp;
                p = p / 2;
            }
        }
    }

    int dequeue(){
        int result;

        result = array[1];
        array[1] = array[cnt--];

        int parrent = 1;
        int child = 2;

        while(child <= cnt){
            if(array[child] < array[child + 1])
                child++;

            if(array[parrent] < array[child]){
                int temp = array[parrent];
                array[parrent] = array[child];
                array[child] = temp;

                parrent = child;
                child *= 2;
            }
        }
        return result;
    }

    public PriorityQueue(int cnt) {
        this.array = new int[cnt];
        this.queuesize = cnt;
        this.cnt = 0;
    }
}
