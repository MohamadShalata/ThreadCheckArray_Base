import java.util.ArrayList;

public class SharedData {
    private ArrayList<Integer> array;
    private boolean[] winArray;
    private boolean flag;
    private final int b;

    /**
     * Constructor for SharedData.
     *
     * @param array the ArrayList of integers to be stored
     * @param b a constant integer value
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = new ArrayList<>(array);
        this.b = b;
        this.winArray = new boolean[array.size()];
    }

    /**
     * Getter method for the winArray.
     *
     * @return the winArray
     */
    public boolean[] getWinArray() { return winArray; }

    /**
     * Setter method for the winArray.
     *
     * @param winArray the new winArray to be set
     */
    public void setWinArray(boolean[] winArray) { this.winArray = winArray; }

    /**
     * Getter method for the array.
     *
     * @return the array
     */
    public ArrayList<Integer> getArray() { return array; }

    /**
     * Getter method for the constant integer value b.
     *
     * @return the constant integer value b
     */
    public int getB() { return b; }

    /**
     * Getter method for the flag.
     *
     * @return the flag
     */
    public boolean getFlag() { return flag; }

    /**
     * Setter method for the flag.
     *
     * @param flag the new value of the flag to be set
     */
    public void setFlag(boolean flag) { this.flag = flag; }
}
