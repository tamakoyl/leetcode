package com.tamako.array.merge_intervals;

import java.util.*;

/**
 * LCR 074. 合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<int[]> que = new LinkedList<>();
        for(int i = 0; i < intervals.length; i++){
            que.offer(intervals[i]);
        }
        ArrayList<int[]> res = new ArrayList<>();

        while(que.size() > 1){
            int[] firstInterval =  que.pop();
            int[] secInterval =  que.pop();
            if(firstInterval[0] <=secInterval[1] && firstInterval[0] >= secInterval[0]){
                int[] newInterval = new int[]{secInterval[0],firstInterval[1]};
                que.offerFirst(newInterval);
            }else if(firstInterval[1] >= secInterval[0] && firstInterval[0] < secInterval[0] ){
                int[] newInterval = new int[]{firstInterval[0],secInterval[1]};
                que.offerFirst(newInterval);
            }else{
                res.add(firstInterval);
                que.offerFirst(secInterval);
            }
        }
        res.add(que.pop());

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new Solution().merge(new int[][]{{1,3},{1,3}});
    }


    //优化
    public int[][] merge2(int[][] intervals) {
        Comparator<int[]> cmp = Comparator.comparingInt(a -> a[0]);
        PriorityQueue<int[]> que = new PriorityQueue<>(cmp);
        que.addAll(Arrays.asList(intervals));
        ArrayList<int[]> res = new ArrayList<>();
        while(que.size() > 1){
            int[] firstInterval = que.poll();
            int[] secInterval = que.poll();
            if(firstInterval[1] >= secInterval[0]){
                int[] newInterval = new int[]{firstInterval[0],Math.max(firstInterval[1],secInterval[1])};
                que.add(newInterval);
            }else{
                res.add(firstInterval);
                que.add(secInterval);
            }
        }
        res.add(que.poll());
        return res.toArray(new int[res.size()][]);
    }
}
