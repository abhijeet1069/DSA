package mod2.arrays;

// Importing required functions
import java.util.*;
class Interval {
    public int first;
    public int second;

    public Interval(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

public class MergeIntervals {

    public static boolean isMergePossible(Interval a, Interval b){
        if(a.first <= b.second && b.first <= a.second)
            return true;
        else
            return false;
    }

    public static Interval merge(Interval a, Interval b){
        return new Interval(Math.min(a.first, b.first), Math.max(a.second, b.second));
    }

    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> v) {
        ArrayList<Interval> output = new ArrayList<Interval>();

        if(v.size() <= 1)
            return v;

        Collections.sort(v, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return Integer.compare(a.first, b.first);
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(v.get(0));
        for(int i = 1; i < v.size(); i++){
            if(isMergePossible(v.get(i), stack.peek()))
                stack.push(merge(stack.pop(), v.get(i)));
            else
                stack.push(v.get(i));
        }

        while(!stack.empty())
            output.add(0,stack.pop());

        //for(Interval i : output)
          //  System.out.println(i.first+","+i.second);

        return output;
    }

    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(2,6));
        input.add(new Interval(8,10));
        input.add(new Interval(15,18));
        mergeIntervals(input);
    }
}
