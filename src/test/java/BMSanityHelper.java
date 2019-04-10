/* BMSanityHelper.java */
public class BMSanityHelper
{
    static boolean wasAcked = false;

    static void ack()
    {
        System.out.println("ack");
        wasAcked = true;
    }

    void doSomething()
    {
        System.out.println("something");
    }
}
