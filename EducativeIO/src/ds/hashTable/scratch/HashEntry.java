package ds.hashTable.scratch;

//One Entry in the Hash Table
public class HashEntry
{
    String key;
    int value;

    // Reference to next node
    HashEntry next;

    // Constructor
    public HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
}