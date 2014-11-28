package Trees;
public class BSTree <E extends Comparable> {

    private TreeNode root;

    BSTree () {
        root = null;
    }

    public void insert (E newEntry) {
        if (root == null)
            root = new TreeNode(newEntry);
        else {
            TreeNode ptr = root;  // pointer to node in search for leaf
            while (ptr != null) {// search for leaf
                if (newEntry.compareTo(ptr.getData()) < 0) {
                    // insert on left of given node
                    if (ptr.getLeft() == null) {
                        // when at end of tree, insert
                        ptr.setLeft(new TreeNode(newEntry));
                        return; 
                    } else 
                        // move left in tree and continue search
                        ptr = ptr.getLeft();
                } else {
                    // insert on right of given node
                    if (ptr.getRight() == null) {
                        // when at end of tree, insert
                        ptr.setRight(new TreeNode(newEntry));
                        return;
                    } else
                        // move right in tree and continue search
                        ptr = ptr.getRight();
                }
            }

            // insertion should be done by now!!
            // exception could be thrown or error message printed here!!
        }
    }

    public void print () {
        System.out.println ("Directory Listing");
        printKernel (root);
        System.out.println ();
        System.out.println ("End of Listing");
    }

    private void printKernel (TreeNode<E> base) {
        // to print elements in a tree (using an in-order traversal),
        //     print the left subtree
        //     print the elements in a node
        //     print the right subtree
        if (base != null) {
            printKernel (base.getLeft());
            System.out.print(base.getData());
            printKernel (base.getRight());
        }
    }

    public E lookup (E desiredItem) {
        return lookupKernel (root, desiredItem);
    }

    public E lookupKernel (TreeNode<E> base, E desiredItem) {
        if (base == null)
            return null;
        else if (base.getData().compareTo(desiredItem) == 0)
            return base.getData();
        else if (base.getData().compareTo(desiredItem) < 0)
            return lookupKernel (base.getRight(), desiredItem);
        else return lookupKernel (base.getLeft(), desiredItem);
    }
    
    public E iterativelookup (E item)
    {
    	TreeNode ptr = root;
    	
    	while (ptr != null)
    	{
    		if(ptr.getData().compareTo(item) == 0)
    		{
    			return (E)ptr.getData();
    		}
    		
    		else if (ptr.getData().compareTo(item) < 0)
    		{
    			ptr = ptr.getRight();
    		}
    		
    		else
    		{
    			ptr = ptr.getLeft();
    		}
    	}
    	 return null;
    }
    
    public int nodeLevel (E item)
    {
    	//Declare a pointer to the tree root
    	TreeNode<E> ptr = root;
    	//Counter is initally set to zero
    	int counter = 0;
    	
    	//Keep going through the tree while incrementing the counter and then return the counter when we find the item
    	while (ptr != null)
    	{
    		if(ptr.getData().compareTo(item) == 0)
    		{
    			return counter;
    		}
    		
    		//If its on the right of the tree, go right
    		else if (ptr.getData().compareTo(item) < 0)
    		{
    			ptr = ptr.getRight();
    		}
    		
    		//Otherwise go left
    		else
    		{
    			ptr = ptr.getLeft();
    		}
    		//Increment counter when you go right or left
    		counter++;
    	}
    	
    	return -1; //Either there is no such element in the tree, or the tree is empty
    }
    
    
    //http://stackoverflow.com/questions/4531449/height-of-a-binary-tree
    
    public int height (TreeNode item)
    {
    	if (item != null)
    	{
    		return 0;
    	}
    	
    	return 1 + Math.max( height(item.getRight()), height(item.getLeft()) );
    }
    
    public boolean isBalanced (TreeNode root)
    {
		return false;
    	
    }
    
}
