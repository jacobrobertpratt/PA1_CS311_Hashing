import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hugh Potter
*/

public class HashTable
{	
	
	private int size, numOfElements;
	private HashFunction hash;
	private Tuple[] table;
	
	public HashTable(int size)
	{
		// possibly check and see if size will be negative
		this.numOfElements = 0;
		this.size = findPrime(size);
		hash = new HashFunction(size);
		table = new Tuple[this.size];
		for(int i = 0; i < this.size; i++){
			table[i] = new Tuple();
		}
	}

	public int maxLoad()
	{
		return 0;
	}

	public float averageLoad()
	{
		// implementation
		return 0;
	}

	public int size()
	{
		return size;
	}

	public int numElements()
	{
		return this.numOfElements;
	}

	public float loadFactor()
	{
		return 0;
	}

	public void add(Tuple t)
	{
		int h = hash.hash(t.getKey());
		System.out.println(h);
		table[h].add(t);
		this.numOfElements++;
	}

	public ArrayList<Tuple> search(int k)
	{
		return null;
	}

	public int search(Tuple t)
	{
		return 0;
	}

	public void remove(Tuple t)
	{
	}
	
	public void printTable(){
		for(int i = 0; i < this.size; i++){
			System.out.print("Hash<" + i + ">: ");
			table[i].print();
			System.out.println();
		}
	}
	
	
	
	private int findPrime(int n) {
		boolean found = false;
		int num = n;
		while(!found) {
			if (isPrime(num))
				return num;
			num++;
		}
		return -1;
	}
	
	private boolean isPrime(int n) {
		for(int i= 2; i<=Math.sqrt(n); i++)
			if (n%i==0)
				return false;
		return true;
	}
}