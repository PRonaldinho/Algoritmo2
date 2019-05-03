//DisjointSets class
//CONSTRUCTION: with int representing initial number of sets
//******************PUBLIC OPERATIONS*********************
//void union( root1, root2 ) --> Merge two sets
//int find( x )
//--> Return set containing x
//******************ERRORS********************************
//Error checking or parameters is performed

public class DisjointSet{

	private int[] s;

   /**
	* Construct the disjoint sets object.
	* @param numElements the initial number of disjoint sets.
	*/
	public DisjointSet( int numElements ){
		
		s = new int[numElements];
		for( int i = 0; i < s.length; i++ )
			s[i] = -1;
	}

	/**
	* Union two disjoint sets using the height heuristic.
	* root1 and root2 are distinct and represent set names.
	* @param root1 the root of set 1.
	* @param root2 the root of set 2.
	* @throws IllegalArgumentException if root1 or root2
	* are not distinct roots.
	*/
	public void union( int root1, int root2){
	
	//	assertIsRoot(root1);
	//	assertIsRoot(root2);
		if (root1 == root2)
			throw new IllegalArgumentException();
		if (s[root2] < s[root1]) // root2 is deeper
			s[root1] = root2;	// Make root2 new root
		else{
			if (s[root1] == s[root2])
				s[root1]--;	// Update height if same
			s[root2]= root1;	// Make root1 new root
		}
	}

	/**
	* Perform a find with path compression.
	* @param x the element being searched for.
	* @return the set containing x.
	* @throws IllegalArgumentException if x is not valid.
	*/
	public int find( int x){

		assertIsItem(x);
		if (s[x] < 0)
			return x;
		else
			return s[x] = find(s[x]);
	}

	private void assertIsRoot( int root){

		assertIsItem(root);
		if( s[root] >= 0 )
			throw new IllegalArgumentException();
	}

	private void assertIsItem( int x){

		if( x<0 || x >= s.length )
			throw new IllegalArgumentException();
	}
}
