package ds.stackQueue.ex02;

/*
 Two stacks on a single array.
 !!Tests not displayed
 * */

public class TwoStacks<V> {
    private int maxSize;
    private V[] array;
    private int tos1;
    private int tos2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        this.array = (V[]) new Object[max_size];
        this.tos1 = 0;
        this.tos2 = this.array.length-1;
    }

    //insert at top of first stack
    public void push1(V value) {
    	if(this.tos1 < this.tos2) {
    		array[tos1] = value;
    		tos1++;
    	}
    	else
    		return;
    }

    //insert at top of second stack
    public void push2(V value) {
    	if(this.tos1 < this.tos2) {
    		array[tos2] = value;
    		tos2--;
    	}
    	else
    		return;
    }

    //remove and return value from top of first stack
    public V pop1() {
    	V val = null;
        if(this.tos1 >= 0) {
        	val = array[this.tos1];
        	this.tos1--;
        }
        return val;
    }

    //remove and return value from top of second stack
    public V pop2() {
    	V val = null;
        if(this.tos2 < this.array.length) {
        	val = array[this.tos2];
        	this.tos2++;
        }
        return val;
    }
    
    public static void main(String[] args) {
    	TwoStacks stack = new TwoStacks(5);
    	stack.push1(12);
    	stack.push1(12);
    	stack.push1(12);
    	stack.push1(12);
    	
    	stack.push2(22);
    	stack.push2(22);
    }
}
