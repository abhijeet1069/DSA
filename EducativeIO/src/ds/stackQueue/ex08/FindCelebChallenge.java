package ds.stackQueue.ex08;

/**
 Celebrity Problem : Find the celebrity where celebrity is someone that everyone knows, but he/she doesn't know anyone.


 Logic:
    acquaintance(a,b):
        1 -> discard a
        2 -> discard b
 */

public class FindCelebChallenge {
    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> stack = new Stack<>(numPeople);
        for(int i = 0; i < numPeople; i++){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int a = stack.pop();
            if(stack.isEmpty()){
                celebrity = a;
                break;
            }
            int b = stack.pop();
            if(party[a][b] == 1){
                stack.push(b); //discard a since he knows b, so he is definitely not a celebrity
            }
            else{
                stack.push(a); //discard b as a doesn't know b, so he is definitely not a celebrity.
            }
        }

        //final check whether last person is celebrity
        for(int i = 0; i < numPeople && i != celebrity; i++){
            if(party[celebrity][i] == 1 || party[i][celebrity] == 0 ){ //if celebrity knows i or if i does not know celebrity
                return -1;
            }
        }
        return celebrity;
    }

    public static void main(String[] args) {
        int [][] party = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };
        System.out.println(findCelebrity(party, party.length));
    }
}
