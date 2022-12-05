package edu.umb.cs680.hw13.fs.comparator;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class SizeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        // TODO Auto-generated method stub
        return o1.getSize() > o2.getSize() ? 1 : (o1.getSize() < o2.getSize()) ? -1 : 0;
    }

}
