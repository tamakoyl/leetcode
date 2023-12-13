package com.tamako.june;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2023/6/7 14:07
 * @Description:2611. 老鼠和奶酪
 */
public class Solution7 {
    public static void main(String[] args) {
        int[] reward1 = {1, 4, 4, 6, 4};
        int[] reward2 = {6, 5, 3, 6, 1};
        int res = new Solution7().miceAndCheese(reward1, reward2, 1);
    }


    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        //采用贪心策略
        int maxBenefit = 0;
        int cheeseQuantities = reward1.length;
        int[] diff = new int[cheeseQuantities];
        for (int i = 0; i < cheeseQuantities; i++) {
            maxBenefit += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for (int i = cheeseQuantities - 1; i > 0 && k-- > 0; i++) {
            maxBenefit+=diff[i];
        }
        return maxBenefit;
    }

//    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
//        //采用贪心策略
//        int cheeseQuantities = reward1.length;
//        HashMap<Integer, Integer> diffMap = new HashMap<>();
//        for (int i = 0; i < cheeseQuantities; i++) {
//           diffMap.put(i,reward1[i]-reward2[i]);
//        }
//        //这里将map.entrySet()转换成list
//        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(diffMap.entrySet());
//        //然后通过比较器来实现排序
//        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
//            //升序排序
//            public int compare(Map.Entry<Integer, Integer> o1,
//                               Map.Entry<Integer, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        int maxReward = 0;
//        boolean[] picked = new boolean[cheeseQuantities];
//        Iterator<Map.Entry<Integer, Integer>> iterator = list.iterator();
//        while (k > 0){
//            Map.Entry<Integer, Integer> next = iterator.next();
//            Integer index = next.getKey();
//            maxReward+=reward1[index];
//            picked[index]=true;
//            k--;
//        }
//        for (int i = 0; i < cheeseQuantities; i++) {
//            if(!picked[i]){
//                maxReward+=reward2[i];
//            }
//        }
//        return  maxReward;
//    }
}
