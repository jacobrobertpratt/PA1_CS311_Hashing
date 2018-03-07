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
	private int[] tableSize;
	
	public HashTable(int size) {
		this.numOfElements = 0;
		this.size = findPrime(size);
		hash = new HashFunction(size);
		table = new Tuple[this.size];
	}

	public int maxLoad()
	{
		
		return 0;
	}

	public float averageLoad()
	{
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
	
	/**
	 * add(Tuple t) adds the Tuple to the hash table. When 0.7 load factor is 
	 * reached then the array doubles and each element is rehashed. and re-added to the 
	 * new hashtable.
	 * @param 
	 */
	public void add(Tuple t)
	{
		int h = hash.hash(t.getKey());
		if(table[h] == null){
			table[h] = new Tuple(t.getKey(), t.getValue());
		}else {
			Tuple temp = this.table[h].search(t);
			if(temp == null){
				this.table[h].add(t);
			} else {
				temp.increaseSize();
			}
		}
		this.numOfElements++;
	}
	
	private void resize(Tuple[] t){
		int t_size = findPrime(this.size*2);
		HashFunction t_hash = new HashFunction(this.size*2);
		Tuple[] t_tup = new Tuple[t_size*2];
		
	}

	/**
	 * search(int k) takes in a number that will be the sudo "key" value 
	 * then finds that hash index and adds each element to the ArrayList 
	 * being returned.
	 * @param int
	 * @return ArrayList<Tuple>
	 */
	public ArrayList<Tuple> search(int k)
	{
		ArrayList<Tuple> ret = new ArrayList<Tuple>();
		int h = hash.hash(k);
		Tuple cur = table[h];
		while(cur != null) {
			ret.add(new Tuple(cur.getKey(), cur.getValue()));  		// Want to generate new Tuple for the ArrayList<Tuple>
			cur = cur.getNext();
		}
		return ret;
	}

	/**
	 * search(Tuple t) finds all the number of Tuples in a hash value
	 * provided by t.getKey(). The number gets the number of Tuples
	 * in that hash value at index h.
	 * @param Tuple t
	 * @return int
	 */
	public int search(Tuple t)
	{
		int num = 0;
		int h = hash.hash(t.getKey());
		Tuple cur = table[h];
		while(cur != null){
			if(cur.equals(t))
				num++;
			cur = cur.getNext();
		}
		return num;
	}

	/**
	 * remove(Tuple t) takes the has code from the key of t and 
	 * calculates where in the array that is needs to be removed. 
	 * It then removes it from the array. will not remove something 
	 * that doesn't exist.
	 * @param Tuple
	 */
	public void remove(Tuple t)
	{
		int h = hash.hash(t.getKey());
		Tuple cur = table[h];
		while(cur != null){
			if(cur.getPrev() == null){
				
				table[h] = cur.getNext();
				cur.copyLeft();
				cur.remove();
			}
			if(cur.getNext() == null){
				
			}
			if(cur.equals(t)){
				cur.remove();
				this.numOfElements--;
				break;
			} 
			cur = cur.getNext();
		}
	}
	
	/**
	 * PrintTable() prints the specific HashTable.
	 */
	public void printTable(){
		for(int i = 0; i < this.size; i++){
			if(table[i] == null){
				System.out.println("<null>");
				continue;
			} else { 
				System.out.print("Hash<" + i + ">: ");
				table[i].print();
				System.out.println();
			}
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