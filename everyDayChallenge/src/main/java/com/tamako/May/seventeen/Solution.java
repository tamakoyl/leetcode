package com.tamako.May.seventeen;

/**
 * @Author:Tamako
 * @Date:2023/4/17 23:20
 * @Description:2409. 统计共同度过的日子数
 */
public class Solution {
    public static void main(String[] args) {
        String arriveAlice = new String("10-01");
        String leaveAlice = new String("10-31");
        String arriveBob = new String("11-01");
        String leaveBob = new String("12-31");
        int res = new Solution().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(res);
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //arrive 取大的
        //left 取小的
        int[] arriveDate = getLaterDate(format(arriveAlice), format(arriveBob));
        int[] leftDate = getEarlierDate(format(leaveAlice), format(leaveBob));
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        //如果arrive的日期大于leave的日期则days=0
        int[] earlierDate = getEarlierDate(arriveDate, leftDate);
        for (int i = 0; i < earlierDate.length; i++) {
            if(earlierDate[i]!=arriveDate[i]){
                return 0;
            }
        }

        //有月份间隔
        for (int i = arriveDate[0]; i < leftDate[0]; i++)days+=months[i-1];
        days += leftDate[1] - arriveDate[1];
        return days+1;
    }

    /**
     * 格式化日期为一个大小为2的int数组分别保存月和日
     * @param date
     * @return
     */
    public int[] format(String date) {
        String[] split = date.split("-");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }

    /**
     * 得到更迟的日期
     * @param alice
     * @param bob
     * @return
     */
    public int[] getLaterDate(int[] alice, int[] bob) {
        int[] res;
        if (alice[0] > bob[0]) {
            res = alice;
        } else if (alice[0] == bob[0]) {
            res = alice[1] > bob[1] ? alice : bob;
        } else {
            res = bob;
        }
        return res;
    }

    /**
     * 得到更早的日期
     * @param alice
     * @param bob
     * @return
     */
    public int[] getEarlierDate(int[] alice, int[] bob) {
        int[] res;
        if (alice[0] < bob[0]) {
            res = alice;
        } else if (alice[0] == bob[0]) {
            res = alice[1] < bob[1] ? alice : bob;
        } else {
            res = bob;
        }
        return res;
    }
}
