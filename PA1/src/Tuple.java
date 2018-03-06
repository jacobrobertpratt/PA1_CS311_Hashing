// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hugh Potter
*/

public class Tuple
{
	// member fields and other member methods
	private int key;
	private String value;
	private Tuple next;
	private Tuple prev;
	private int size;
	
	public Tuple(){
		this.key = 0;
		this.next = null;
		this.prev = null;
		this.size = 0;
	}
	
	public Tuple(int keyP, String valueP)
	{
		this.key = keyP;
		this.value = valueP;
	}
	
	public int getKey()
	{
		return key;
	}
	public String getValue()
	{
		return value;
	}
	public boolean equals(Tuple t)
	{
		if(this.key == t.key && this.value.equals(t.value))
			return true;	
		return false;
	}
	public void print(){
		Tuple temp = this;
		while(temp.next != null){
			temp = temp.next;
			System.out.print("[" + temp.key + "," + temp.value + "] ");
		}
	}
	public Tuple getNext(){
		return this.next;
	}
	public Tuple getPrev(){
		return this.prev;
	}
	public void add(Tuple t){
		if(this.next == null){
			this.next = t;
			t.prev = this;
		} else {
			this.next.prev = t;
			t.next = this.next;
			t.prev = this;
			this.next = t;
		}
		size++;
	}
	public void remove(){
		this.next.prev = this.prev;
		this.prev.next = this.next;
		this.prev = null;
		this.next = null;
	}

	public int getSize() {
		return size;
	}
}