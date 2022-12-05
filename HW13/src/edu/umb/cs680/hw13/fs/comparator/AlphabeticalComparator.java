package edu.umb.cs680.hw13.fs.comparator;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
    
}
