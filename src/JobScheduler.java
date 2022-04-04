import java.util.Deque;
import java.util.LinkedList;

public class JobScheduler<Process> {
    Deque<Process> queue;

    public JobScheduler() {
        queue = new LinkedList<>();
    }

    /**
     * Adds the passed process to the back of the queue
     * @param e
     */
    public void addProcess(Process e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        queue.offer(e);
    }

    /**
     * Gets the next process in the queue. Returns null if empty
     * @return
     */
    public Process getNextProcess() {
        return queue.poll();
    }

    /**
     * Switches the next process in the queue with the passed process
     * @param e
     * @return
     */
    public Process switchProcess(Process e) {
        if (queue.size() == 0) {
            return e;
        }

        Process returnData = queue.poll();
        queue.offerFirst(e);

        return returnData;
    }

}
