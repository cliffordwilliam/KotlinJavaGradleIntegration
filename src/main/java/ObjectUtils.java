public class ObjectUtils {
    // null safe version of built in "a.equals(b)"
    public static boolean equals(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals(b);
    }
}