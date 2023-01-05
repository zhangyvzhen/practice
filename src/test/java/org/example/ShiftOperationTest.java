package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

/**
 * 移位运算
 */
public class ShiftOperationTest {
    @Test
    public void shiftOperation(){
        // 注意 Integer.toBinaryString() 这个方法会省略前面的0

        // 正数（补码） 240
        // int占4B，用二进制形式赋值时若未提供完整的32位数，正数会自动在前面填充0
        int x = 0b11110000;
        // 左移2位
        int x1 = x << 2;
        // 算术右移2位
        int x2 = x >> 2;
        // 逻辑右移2位
        int x3 = x >>> 2;
        // 没有单独的逻辑左移符号 <<< , 对于无符号数和补码来说， 逻辑左移 和 算术左移的功能相同，它们共用符号 <<
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x1));
        System.out.println(Integer.toBinaryString(x2));
        System.out.println(Integer.toBinaryString(x3));
        System.out.println("--------------------------");

        // * 使用二进制形式（或16进制）给变量赋值，提供的是真值转换为补码后的机器数

        // int 最大值
        int max = 0x7FFFFFFF;
        // 左移2位
        int max1 = max<<2;
        // 算术右移2位
        int max2 = max >> 2;
        // 逻辑右移2位
        int max3 = max >>> 2;
        System.out.println(max);
        // Integer.toBinaryString()省略了前面的一个0
        System.out.println(Integer.toBinaryString(max));
        System.out.println(Integer.toBinaryString(max1));
        System.out.println(Integer.toBinaryString(max2));
        System.out.println(Integer.toBinaryString(max3));
        System.out.println("--------------------------");


        // 负数 -240
        //真值->原码->补码
            // 真值：-240
            // 原码(32位)：1000 0000 0000 0000 0000 0000 1111 0000
            // 补码(32位)：1111 1111 1111 1111 1111 1111 0001 0000 （口算：符号位不变，从右往左数第一个1本身及其之后不变，之前取反）
        int y = 0b11111111111111111111111100010000;
        // 左移2位
        int y1 = y << 2;
        // 算术右移2位
        int y2 = y >> 2;
        // 逻辑右移2位
        int y3 = y >>> 2;
        System.out.println(y);
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(y1));
        System.out.println(Integer.toBinaryString(y2));
        System.out.println(Integer.toBinaryString(y3));
        System.out.println("--------------------------");

        // 负数 int最小值(补码负数用-0表示最小负数)
        int min = 0b10000000000000000000000000000000;
        // 左移2位
        int min1 = min<<2;
        // 算术右移2位
        int min2 = min>>2;
        // 逻辑右移2位
        int min3 = min >>> 2;
        System.out.println(min);
        System.out.println(Integer.toBinaryString(min));
        System.out.println(Integer.toBinaryString(min1));
        System.out.println(Integer.toBinaryString(min2));
        System.out.println(Integer.toBinaryString(min3));
        System.out.println("--------------------------");

        // java没有提供循环移位操作，需要自己实现
        // 具体到 带进位位的大循环 和 不带进位位的小循环 这都是底层的计组关心的东西，所以只要能实现对一个二进制数左右循环移位的效果即可

        int c = 0XFF000000;
        int n=4;
        // 循环左移4位
        int c1 = c<<n | c>>>(Integer.SIZE-n) ;
        // 循环右移4位
        int c2 = c>>>n | c<<(Integer.SIZE-n);
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c1));
        System.out.println(Integer.toBinaryString(c2));
    }
}
