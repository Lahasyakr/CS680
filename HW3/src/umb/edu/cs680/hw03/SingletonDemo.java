package umb.edu.cs680.hw03;
public class SingletonDemo {
    private static SingletonDemo singleinstance = null;
    public String s;
    private SingletonDemo(){
        s = "This is a singleton class";
    }

    public static SingletonDemo getInstance(){
        if(singleinstance == null){
            singleinstance = new SingletonDemo();
        }
        return singleinstance;
    }

    public static void main(String args[]) {
		SingletonDemo inst1 = SingletonDemo.getInstance();
        SingletonDemo inst2 = SingletonDemo.getInstance();
		
		System.out.println("\n" + inst1.hashCode() + " hashcode of instance 1.");		
        System.out.println("\n" + inst2.hashCode() + " hashcode of instance 2.");								
	}
}
