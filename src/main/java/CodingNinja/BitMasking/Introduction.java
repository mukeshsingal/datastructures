package CodingNinja.BitMasking;



/**
 * Bitwise and bit shift operators are used on integral types (byte, short, int
 * and long) to perform bit-level operations.
 * 
 * These operators are not commonly used. You will learn about a few use cases
 * of bitwise operators in Java enum type chapter. This article will only focus
 * on how these operators work.
 * 
 * There are 7 operators to perform bit-level operations in Java ( 4 bitwise and
 * 3 bit shift).
 * 
 * <pre>
 * |	Bitwise OR
 * &	Bitwise AND
 * ~	Bitwise Complement
 * ^	Bitwise XOR
 * <<	Left Shift | multiply with 2 | n << i -> multiply n with 2 i times
 * >>	Right Shift | divide by 2 | n >> i -> divide n with 2 i times
 * >>>	Unsigned Right Shift
 * </pre>
 */
public class Introduction {
    public static void main(String[] args) {

        int number1 = 12, number2 = 25;

        int orResult = number1 | number2;
        int andResult = number1 & number2;
        int xorResult = number1 ^ number2;
        int complimentResult = ~number1;

        /* The left shift operator << shifts a bit pattern to the left by certain number 
        of specified bits, and zero bits are shifted into the low-order positions. */

        int signedLeftShift = number1 << 1; 
        /* The right shift operator >> shifts a bit pattern to the right by certain number 
        of specified bits. */
        int signedRightShift = number1 >>  1; 
        /* The unsigned right shift operator >>> shifts zero into the leftmost position. */
        int unsignedRightShift = number1 >>> 1; 

        System.out.println("" + 12 + " | " + 25 + " = " + orResult);
        System.out.println("" + 12 + " & " + 25 + " = " + andResult);
        System.out.println("" + 12 + " ^ " + 25 + " = " + xorResult);
        System.out.println("   ~ " + 12 + " = " + complimentResult);
        System.out.println("" + 12 + " << " +  " = " + signedLeftShift);
        System.out.println("" + 12 + " >> " +  " = " + signedRightShift);
        System.out.println("" + 12 + " >>> " +  " = " + unsignedRightShift);
    }   
}