package edu.umb.cs680.hw13.fs.comparator;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class ElementtypeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        // TODO Auto-generated method stub
        if(o1.isDirectory()){
            return -1;
        }
        else if(!o1.isDirectory() && o2.isDirectory()){
            return 1;
        }
        if(o1.isFile()){
            return -1;
        }
        else if (o1.isFile() && o2.isFile()) {
            return 0;
        }
        else if(!o1.isFile() && o2.isFile()){
            return 1;
        }
        if(!o1.isLink()){
            return -1;
        }
        else{
            return 0;
        }
    }

}
