import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
public class BitboardGame {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Bitboards bitboards = Bitboards.getInstance();
        for (Method m : bitboards.getClass().getMethods()) {
            if (m.getName().startsWith("get") && m.getParameterTypes().length == 0 && m.getReturnType().equals(Long.TYPE)) {
                final long r = (long) m.invoke(bitboards);
                System.out.println(m.getName());
                System.out.println(Long.toBinaryString(r).length());
                bitboards.printBitboard(r);
            }
        }
    }
}
