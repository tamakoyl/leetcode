package com.tamako.backtracking.partition.restore_ip;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/26 09:50
 * @Description:93. 复原 IP 地址
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        backtracking(0, s);
        ArrayList<String> results = new ArrayList<>();
        for (List<String> re : res) {
            StringBuilder validIp = new StringBuilder();
            for (int i = 0; i < re.size() - 1; i++) {
                validIp.append(re.get(i));
                validIp.append(".");
            }
            validIp.append(re.get(re.size() - 1));
            results.add(validIp.toString());
        }
        return results;
    }


    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    private void backtracking(int startIndex, String s) {
        //bounding func
        //递归出口
        if (path.size() == 4 && startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (substring.charAt(0) - '0' > 0 && substring.length() <= 3 && Integer.parseInt(substring) <= 255 || substring.length() == 1) {
                path.add(substring);
            } else {
                continue;
            }
            backtracking(i + 1, s);//递归求解
            path.remove(path.size() - 1);
        }
    }
}
