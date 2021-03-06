package reading.dsAndAlgos.swordPointOffer;

import java.security.InvalidParameterException;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 *  不得使用库函数，不需要考虑大数问题。
 *
 *  mark 注意两种递归方式使用的差异：对result的计算放在哪里的区别，一个是在方法调用中计算，另一个在递归调用链返回途中计算
 * created by ran
 */
public class Power {
    private static double solution(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            throw new InvalidParameterException();
        }
        if (exponent == 0) {
            return 1;
        }

        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }

        //double result = powerWithUnsignedExponent(base, exponent);
        double result = powerWithUnsignedExponent(base, exponent, base);

        if (flag) {
            result = 1 / result;
        }
        return result;
    }

    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 1) {
            return base;    // 相当于下一个方法传入的result参数
        }

        double result = powerWithUnsignedExponent(base, exponent / 2);
        result *= result;

        if (exponent % 2 == 1) {
            result *= base;
        }

        return result;
    }

    // note 调用该方法时result初始值为base
    private static double powerWithUnsignedExponent(double base, int exponent, double result) {
        if (exponent == 1) {
            return result;
        }

        if ((exponent & 0x01) == 1) {
            return powerWithUnsignedExponent(base, (exponent >> 1), result * result * base);
        } else {
            return powerWithUnsignedExponent(base, (exponent >> 1), result * result);
        }
    }


    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(2, -1));
    }
}
