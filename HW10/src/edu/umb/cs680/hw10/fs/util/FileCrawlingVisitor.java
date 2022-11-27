package edu.umb.cs680.hw10.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class FileCrawlingVisitor implements edu.umb.cs680.hw10.fs.FSVisitor {

    private LinkedList<File> files = new LinkedList<File>();

	public LinkedList<File> getFiles() {
		return files;
	}

    @Override
	public void visit(Link link) {
		return;
	}

    @Override
	public void visit(Directory directory) {
		return;
	}

    @Override
	public void visit(File file) {
		files.add(file);
	}
}
