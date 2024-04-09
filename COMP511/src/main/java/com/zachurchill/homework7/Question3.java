package com.zachurchill.homework7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Question3<E> extends ArrayCollection<E> {
    /**
     * Searches this collection to determine if every element of <tt>coll</tt>
     * exists in this collection.  Comparison is based on the same algorithm
     * as for <tt>contains</tt>.
     * 
     * Time complexity is: O(n*m)
     * 
     * @param coll the collection to be checked for containment in this on
     * @return true if all elements of <tt>coll</tt> also exist in this.
     */
    @Override
    public boolean containsAll(Collection<?> coll) {
        ArrayList<Boolean> doesContain = new ArrayList<>();
        Iterator<?> itr = coll.iterator();
        while(itr.hasNext()) {
            doesContain.add(this.contains(itr.next()));
        }
        return !doesContain.contains(false);
    }

    /**
     * Retains all the elements in this collection that match those in
     * the parameter collection <tt>coll</tt>.  That is, it will remove
     * all elements in this collection that have no match in <tt>coll</tt>.
     * 
     * Time complexity is: O(n*m)
     * 
     * @parma coll the collection of elements to be matched against
     * @return true if this collection is altered as a result of the call.
     */
    public boolean retainAll(Collection<?> coll) {
        boolean altered = false;
        for (Iterator<E> itr = this.iterator(); itr.hasNext(); ) {
            E el = itr.next();
            if (!coll.contains(el)) {
                System.out.println("removing...");
                itr.remove();
                altered = altered || true;
            }
        }
        return altered;
    }

}
