1) Insert data at the end of list.
    Input:
        list = 0->1->2
        data = 3
    Output:
        list = 0->1->2->3

    Location : EducativeIO.ds.sll.ex01.CheckInsertion

    /** Prev node is also maintained for deletion case.
        Case 1 : Deletion at head node - prev is null, simply adjust headnode
        Case 2 : Deletion in between - prev node is not null, prev.next = current.next
    **/
    public void insertAtEnd(T data) {
        Node temp = this.headNode;
        Node prev = this.headNode;//maintain one position before temp
        while(temp != null){ 
            prev = temp;
            temp = temp.nextNode;
        }
        temp = new Node();
        temp.data = data;
        temp.nextNode = null;
        if(prev != null) //not an empty list
            prev.nextNode = temp;
        else //first node
            this.headNode = temp;
        this.size++;
    }

2. Find the middle node.
Input:
	linkedList = 7->14->10->21
Output:
	mid = 14

Location : EducativeIO.ds.sll.ex07.CheckMid

This is a two pointer approach. Where the fast pointer(rabbit) is 2x fast as slow pointer(turtle).

public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node rabbit =  list.headNode; //rabbit is twice as fast as turtle
        SinglyLinkedList.Node turtle = list.headNode;
        while(rabbit != null) {
        	if(rabbit.nextNode != null && rabbit.nextNode.nextNode != null) {
        		rabbit = rabbit.nextNode.nextNode;
        	}
        	else {
        		break;
        	}
        	turtle = turtle.nextNode;
        }
        return turtle.data;
    }

3. Find the union and intersection of lists.
Input:
	list1 = 15->22->8->null
	list2 = 7->14->22->null
Output:
	Union = 15->22->8->7->14->null
	Intersection = 22->null

Location : EducativeIO.ds.sll.ex09.CheckUnionIntersection

For union, make a single list out of two lists and remove the duplicates.
For instersection, remove duplicates from both lists then merge in a single list. Factor out the repeating elements in a list and return.