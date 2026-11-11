import java.util.ArrayList;

/**
 * Worker thread implementation that recursively checks subsets of an
 * ArrayList{@code <Integer>} stored in {@link SharedData} to find a target sum.
 */
public class ThreadCheckArray implements Runnable {
    private boolean flag;
    private boolean[] winArray;
    SharedData sd;
    ArrayList<Integer> array;
    int b;

    /**
     * Constructs a ThreadCheckArray task with the shared data instance.
     * Retrieves the shared ArrayList{@code <Integer>} and target sum, and
     * dynamically sizes the primitive boolean[] winArray using {@code array.size()}.
     *
     * @param sd the {@link SharedData} instance containing the ArrayList{@code <Integer>}
     */
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }
        winArray = new boolean[array.size()];
    }

    /**
     * Recursively evaluates elements of the ArrayList{@code <Integer>} to determine
     * whether a subset sums to the target value {@code b}.
     *
     * @param n the current number of elements being considered
     * @param b the remaining target sum to match
     */
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        if (n == 1) {
            if (b == 0 || b == array.get(n - 1)) {
                flag = true;
                synchronized (sd) {
                    sd.setFlag(true);
                }
            }
            if (b == array.get(n - 1)) {
                winArray[n - 1] = true;
            }
            return;
        }

        rec(n - 1, b - array.get(n - 1));
        if (flag) {
            winArray[n - 1] = true;
        }
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        rec(n - 1, b);
    }

    /**
     * Executes the subset sum search across threads and updates the winning
     * boolean[] array in {@link SharedData} if a valid subset is found.
     */
    @Override
    public void run() {
        if (array.size() != 1) {
            if (Thread.currentThread().getName().equals("thread1")) {
                rec(array.size() - 1, b - array.get(array.size() - 1));
            } else {
                rec(array.size() - 1, b);
            }
        }
        if (array.size() == 1) {
            if (b == array.get(0) && !flag) {
                winArray[0] = true;
                flag = true;
                synchronized (sd) {
                    sd.setFlag(true);
                }
            }
        }
        if (flag) {
            if (Thread.currentThread().getName().equals("thread1")) {
                winArray[array.size() - 1] = true;
            }
            synchronized (sd) {
                sd.setWinArray(winArray);
            }
        }
    }
}