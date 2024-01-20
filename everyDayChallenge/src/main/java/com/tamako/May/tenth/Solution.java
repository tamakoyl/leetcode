package com.tamako.May.tenth;

/**
 * @Author:Tamako
 * @Date:2023/4/11 00:57
 * @Description: 1041. 困于环中的机器人
 */
class Solution {
    public static void main(String[] args) {
        String instruction = "GLGLGGLGL";
        boolean robotBounded = new Solution().isRobotBounded(instruction);
    }
    public boolean isRobotBounded(String instructions) {
        //关键在于怎么判断没有环？ 距离一直在增大？
        char[] instructionChar = instructions.toCharArray();
        //使用二维数组模拟4个方向
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x = 0, y = 0, dir = 0;
        for (int i = 0; i < instructionChar.length; i++) {
            if (instructionChar[i] == 'L') {
                dir++;
            } else if (instructionChar[i] == 'R') {
                dir+=3;
            } else {
                dir = dir % 4;
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        return x == 0 && y == 0 || dir % 4 != 0;

//        int curDistance=0,preDistance=0,increaseCount=0;
//        //循环队列
//        directions[0] = 'N';
//        directions[1] = 'W';
//        directions[2] = 'S';
//        directions[3] = 'E';
//        boolean loop = true;
//        HashMap<Character, Integer> directionAndStepsMap = new HashMap<>();
//        directionAndStepsMap.put('N',0);
//        directionAndStepsMap.put('W',0);
//        directionAndStepsMap.put('S',0);
//        directionAndStepsMap.put('E',0);
//        int curDirectionIndex = 0;
//        char curDirection;
//        while (loop){
//            for (char instruct : instructionChar) {
//                switch (instruct){
//                    case 'G':
//                        if(curDirectionIndex >= 0 ){
//                            curDirection = directions[curDirectionIndex % 3];
//                        }else{
//                           curDirection = directions[curDirectionIndex % 4 + 4];
//                        };
//                        int tempStep = directionAndStepsMap.get(curDirection) + 1;
//                        directionAndStepsMap.put(curDirection,tempStep);
//                    case 'L':
//                        curDirectionIndex--;
//
//                    case 'R':
//                        curDirectionIndex++;
//                }
//            }
//            //存在环，就是相对两个方向的steps相同
//            Integer northSteps = directionAndStepsMap.get('N');
//            Integer southSteps = directionAndStepsMap.get('S');
//            Integer westSteps = directionAndStepsMap.get('W');
//            Integer eastSteps = directionAndStepsMap.get('E');
//            if(northSteps == southSteps &&
//                    westSteps == eastSteps){
//                return true;
//            }
//
//            //判断无环
//            //距离一直在增大，没有减小的意思
//            curDistance = (northSteps - southSteps)^2 + (eastSteps - westSteps)^2;
//            if(curDistance > preDistance){
//                increaseCount ++;
//            }else {
//                increaseCount = 0;
//            }
//            preDistance = curDistance;
//        }

    }
}