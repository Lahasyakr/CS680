package edu.umb.cs680.hw09.fs;

public interface FSVisitor {
    public void visit(Link link);
	public void visit(Directory directory);
	public void visit(File file);
}
