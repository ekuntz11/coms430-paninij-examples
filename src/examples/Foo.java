package examples;

/**
 * Example of a reference type in a Panini program.
 * (aka a progammer written Java class.)
 * @author Eva Kuntz
 *
 */
public class Foo {
    
    private int counter;
    
    public Foo() {
        counter = 0;
    }
    
    public void doSomethingOnFoo() {
        counter++;
    }
    
    public void doSomethingElseOnFoo() {}
    
    public int returnANumber() { return counter; }
}
