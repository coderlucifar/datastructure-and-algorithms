package com.coderlucifar.algorithms.bit_operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunyuan
 * @version 1.0
 * @description: 位运算
 * @date 2022/10/31 09:58
 */
public class Bits {
    private final Logger log = LoggerFactory.getLogger(Bits.class);

    /**
     * 获得二进制数字指定位置的值
     * 利用 & 运算的特性
     * @param number
     * @param bitPosition
     * @return
     */
    public int getBit(int number, int bitPosition) {
        int value = (number >> bitPosition) & 1;
        return value;
    }

    /**
     * 设置二进制数字指定位置的值为1
     * 利用 ｜ 运算的特性
     * @param number
     * @param bitPosition
     * @return
     */
    public int setBit(int number, int bitPosition) {
        int result = number | (1 << bitPosition);
        return result;
    }

    /**
     * 清除二进制位指定位置的值（设置为0）
     * @param number
     * @param bitPosition
     * @return
     */
    public int clearBit(int number, int bitPosition) {
        int mask = ~(1 << bitPosition);
        int result = number & mask;
        return result;
    }

    /**
     * 组合clearBit 和 setBit
     * @param number
     * @param position
     * @param bitValue
     * @return
     */
    public int updateBit(int number, int position, int bitValue) {
        int mask = ~(1 << position);
        int result = (number & mask) | (bitValue << position);
        return result;
    }

    /**
     * 判断是否是偶数
     * 奇数的二进制表示，最右边的位永远为1
     * @param number
     * @return
     */
    public boolean isEven(int number) {
        return (number & 1) == 0;
    }

    /**
     * 判断是否是正数
     *
     * @param number
     * @return
     */
    public boolean isPositive(int number) {
        if (number == 0) return false;
        return ((number >> 31) & 1) == 0 ;
    }

    /**
     * 乘二运算
     * @param number
     * @return
     */
    public int multiplyByTwo(int number) {
        return 0;
    }

    /**
     * 除二运算
     * @param number
     * @return
     */
    public int divideByTwo(int number) {
        return 0;
    }

    /**
     * 改变数的正负
     * @param number
     * @return
     */
    public int switchSign(int number) {
        return 0;
    }

    /**
     * 计算两个有符号数的乘积
     * @param a
     * @param b
     * @return
     */
    public int multiply(int a, int b) {
        return 0;
    }

    /**
     * 递归实现乘积计算
     * @param a
     * @param b
     * @return
     */
    public int multiplyByRecursive(int a, int b) {
        return 0;
    }

    /**
     * 计算两个无符号数的乘积
     * @param number1
     * @param number2
     * @return
     */
    public int multiplyUnsigned(int number1, int number2) {
        return 0;
    }

    /**
     * 计算二进制数中1的个数
     * @param originalNumber
     * @return
     */
    public int countSetBits(int originalNumber) {
        return 0;
    }

    /**
     * 计算把一个数字转换为另一个数字所需要转换的位数
     * @param number1
     * @param number2
     * @return
     */
    public int bitsDiff(int number1, int number2) {
        return 0;
    }

    /**
     * 计算数字的有效位数
     * @param number
     * @return
     */
    public int bitLength(int number) {
        return 0;
    }

    /**
     * 判断数字是否可以表示为2的幂
     * @param number
     * @return
     */
    public boolean isPowerOfTwo(int number) {
        return true;
    }

    /**
     * 使用位运算计算两个数的和
     * @param a
     * @param b
     * @return
     */
    public int fullAdder(int a, int b) {
        return 0;
    }

}
