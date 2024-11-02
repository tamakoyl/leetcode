package com.everyday_chanllenge.nov_24;

/**
 * @Author:Tamako
 * @Date:2024/11/2 08:44
 * @Description:3226. 使两个整数相等的位更改次数
 */
public class SecondDay {

    public static int minChanges(int n, int k) {
        int cnt = 0;
        //因为变为二进制数之后的bit的位数不一样，但是前面可以补零，所以需要等移动完全部的位数
        while(n > 0 || k > 0){
            int nBit = n % 2;
            n = n >> 1;
            int kBit = k % 2;
            k = k >> 1;
            //n不能从0->1
            if(nBit == 0 && kBit == 1){
                return -1;
            }
            //计数
            if(nBit != kBit){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        minChanges(11,56);
    }
}
