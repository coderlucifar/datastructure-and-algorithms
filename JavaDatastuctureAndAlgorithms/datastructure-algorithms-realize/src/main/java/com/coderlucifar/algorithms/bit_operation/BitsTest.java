package com.coderlucifar.algorithms.bit_operation;


public class BitsTest {
    public static void main(String[] args) {
        Bits bits = new Bits();
        /**
         * 测试获取指定的二进制位
         */
        System.out.println("----------测试获取指定的二进制位--------------------------");
        int bit = bits.getBit(8, 0);
        System.out.println(bit);
        int bit1 = bits.getBit(8, 1);
        System.out.println(bit1);
        int bit2 = bits.getBit(8, 2);
        System.out.println(bit2);
        int bit3 = bits.getBit(8, 3);
        System.out.println(bit3);
        int bit4 = bits.getBit(8, 4);
        System.out.println(bit4);

        int bit5 = bits.getBit(8, 31);
        int bit6 = bits.getBit(-8, 31);
        System.out.println(bit5);
        System.out.println(bit6);
        System.out.println("------------------------------------------------------");
    }
}
