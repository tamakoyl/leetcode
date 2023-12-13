package com.tamako.May.forteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:Tamako
 * @Date:2023/4/14 09:01
 * @Description: 1023. 驼峰式匹配
 */
public class Solution {
    public static void main(String[] args) {
        String[] queries = {"aksvbjLiknuTzqon", "ksvjLimflkpnTzqn", "mmkasvjLiknTxzqn", "ksvjLiurknTzzqbn", "ksvsjLctikgnTzqn", "knzsvzjLiknTszqn"
        };
        String pattern = "ksvjLiknTzqn";
        String[] queries2 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"
        };
        String pattern2 = "FB";
        Solution solution = new Solution();
//        List<Boolean> booleans = solution.camelMatch(queries2, pattern2);
        List<Boolean> booleans1 = solution.camelMatch2(queries2, pattern2);
        for (Boolean aBoolean : booleans1) {
            System.out.println(aBoolean);
        }
    }

    //思路1：双指针比较ASCII
    public List<Boolean> camelMatch2(String[] queries, String pattern) {
         ArrayList<Boolean> res = new ArrayList<>();
        char[] patternArray = pattern.toCharArray();
        int j, k;
        boolean flag;
        for (int i = 0; i < queries.length; i++) {
            j = 0;
            k = 0;
            flag = false;
            char[] qurey = queries[i].toCharArray();
            while (j < qurey.length && k < patternArray.length) {
                //当匹配到相同的字符
                if (qurey[j] == patternArray[k]) {
                    j++;
                    k++;
                } else {
                    //如果匹配到不同的字符，且query的当前比较字符为大写字母
                    //直接break,为false
                    if (qurey[j] >= 'A' && qurey[j] <= 'Z') {
                       flag = true;
                       break;
                    }
                    j++;
                }
            }
            //返回false
            if(flag){
                res.add(false);
                continue;
            }

            //qurey匹配pattern完毕
            if (j == qurey.length && k == patternArray.length) {
                res.add(true);
                //k == patternArray.length  ==> pattern已经被匹配了一次了,但是query有剩余字符未匹配
            } else if (k == patternArray.length) {
                //如果query剩余的字符 只有小写字母则匹配成功
               while (j < qurey.length){
                  if(!((qurey[j] >= 'A' && qurey[j] <= 'Z'))){
                      j++;
                  }else {
                    //如果剩余字符有大写字母
                      break;
                  }
               }
                //如果剩余字符有大写字母，那么j的下标 < len
               if(j == qurey.length){
                   res.add(true);
               }else {
                   res.add(false);
               }
            }else {
                //其他情况直接返回false
                res.add(false);
            }
        }
        return res;
    }

    //思路2：正则表达式
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> res = new ArrayList<>();
        char[] patternArray = pattern.toCharArray();
        String regExp = "[a-z]*";
        for (int i = 0; i < patternArray.length; i++) {
            regExp += patternArray[i] + "[a-z]*";
        }
        Pattern compile = Pattern.compile(regExp);
        for (String query : queries) {
            Matcher matcher = compile.matcher(query);
            //query与pattern匹配
            if (matcher.find() && query.equals(matcher.group(0))) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }


}
