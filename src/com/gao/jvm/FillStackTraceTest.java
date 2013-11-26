package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-11-26
 * Time: 下午6:04
 */
public class FillStackTraceTest {
    public static void main(String[] args) {
        a();
    }

    static void a(){
        System.out.println("a method");
        b();
    }

    private static void b() {
        System.out.println("b method");
        c();
    }

    private static void c() {
        System.out.println("c method");
        d();
    }

    private static void d() {
        throw new ExceptionTeset("china");
    }
}

class ExceptionTeset  extends RuntimeException{
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExceptionTeset(String message) {
        super(message);
    }
    /**
     * Fills in the execution stack trace. This method records within this
     * {@code Throwable} object information about the current state of
     * the stack frames for the current thread.
     * <p/>
     * <p>If the stack trace of this {@code Throwable} {@linkplain
     * Throwable#Throwable(String, Throwable, boolean, boolean) is not
     * writable}, calling this method has no effect.
     *
     * @return a reference to this {@code Throwable} instance.
     * @see Throwable#printStackTrace()
     */
    /*@Override
    public synchronized Throwable fillInStackTrace() {
        System.out.println("in fillinstacktrace");
        return this;
    }*/
}
