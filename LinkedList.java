/*
 *  LinkedList.java   
 *
 *  Description: This class is represents a LinkedList.
 *
 *  Name: Kent Chow
 *
 *  Date: March 19, 2013
 */

class LinkedList<T> {
    private int numberOfNodes = 0; 
    private ListNode<T> front = null;
    private ListNode<T> tail = null;
    
    // Returns true if the linked list has no nodes, or false otherwise.
    public boolean isEmpty() {
        return (front == null);
    }
    
    // Deletes all of the nodes in the linked list.
    // Note: ListNode objects will be automatically garbage collected by JVM.
    public void makeEmpty() {
        front = null;
        tail = null;
        numberOfNodes = 0;
    }
    
    // Returns the number of nodes in the linked list
    public int size() {
        return numberOfNodes;
    }
    
    // Adds a node to the front of the linked list.
    public void addFront( T element ) {
        front = new ListNode<T>( element, front );
        if (tail == null){
            tail = front;
        }
        numberOfNodes++;
    }
    
    // Returns a reference to the data in the first node, or null if the list is empty.
    public T first() {
        if (isEmpty()) 
            return null;
        
        return front.getData();
    }
    
    // Removes a node from the front of the linked list (if there is one).
    // Returns a reference to the data in the first node, or null if the list is empty.
    @SuppressWarnings("unchecked")
    public T removeFront() {
        T tempData;
        
        if (isEmpty()) 
            return null;
        
        tempData = front.getData();
        front = front.getNext();
        numberOfNodes--;
        return tempData;
    }
    
    // Returns true if the linked list contains a certain element, or false otherwise.
    @SuppressWarnings("unchecked")
    public boolean contains( T key ) {
        ListNode<T> searchNode;
        searchNode = front;
        while ( (searchNode != null) && (!key.equals(searchNode.getData())) ) {
            searchNode = searchNode.getNext();
        }
        return (searchNode != null);
    }
    
    // Insert a node in the list with a given key value
    @SuppressWarnings("unchecked")
    public void insert( Comparable key ) {
        ListNode<T> before = null;
        ListNode<T> after = front;
        ListNode<T> newNode;        
        
        // Traverse the list to find the ListNode before and after our insertion point.
        while ((after != null) && (key.compareTo(after.getData()) != 0)) {
            before = after;
            after = after.getNext();
        }
        
        // Create the new node with link pointing to after
        newNode = new ListNode<T>( (T)key, after);
        
        // Adjust front of the list or set before's link to point to new node, as appropriate
        if (before == null) {
            front = newNode;
        }
        else {
            before.setNext(newNode);
        }
        numberOfNodes++;
    }
    
    // Delete a node in the list with a given key value
    @SuppressWarnings("unchecked")
    public boolean delete( Comparable key ) {
        ListNode<T> before = null;
        ListNode<T> after = front;   
        
        // Traverse the list to find the ListNode before and after our deletion point.
        while ((after != null) && (key.compareTo(after.getData()) != 0)) {
            before = after;
            after = after.getNext();
        }
        
        if (after == null)
            return false;
        else
            after = after.getNext();
        
        // Delete the node by linking before to the next node of after
        if (size() == 1 || before == null)
            front = after;
        else 
            before.setNext(after);
        
        numberOfNodes--;
        return true;
    }
    
    // Adds a node to the end of the linked list.
    public void addEnd( T element ) {
        ListNode<T> newNode = new ListNode<T>( element, null );
        if (isEmpty()){
            tail = newNode;
            front = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        numberOfNodes++;
    }
    
    // Removes a node from the end of the linked list (if there is one).
    @SuppressWarnings("unchecked")
    public T removeEnd() {
        ListNode<T> before = null;
        ListNode<T> after = front; 
        T tempData;
        
        if (isEmpty()) 
            return null;
        
        tempData = tail.getData();
        
        if (size() == 2){
            front.setNext(null);
            tail = front;
            numberOfNodes--;
            return tempData;
        }
        else if (size() == 1){
            front = null;
            tail = null;
            numberOfNodes--;
            return tempData;
        }

        // Traverse the list
        while (after != null){
            if (after.getNext() == null){
                break;
            }
            else {
                before = after;     
            }
            after = after.getNext();
        }
        
        before.setNext(null);
        tail = before;

        numberOfNodes--;
        return tempData;
    }    

}