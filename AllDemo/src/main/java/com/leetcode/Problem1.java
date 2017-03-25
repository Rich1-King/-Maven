package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sunchong on 2017/3/17.
 */
public class Problem1{

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
        System.out.println("over");
    }

    public int[] soluteProblem1(int[] nums, int target){
        int[] retValues = new int[2];
        for(int i=0; i<nums.length; i++){
            int value = target - nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == value){
                    retValues[0] = i;
                    retValues[1] = j;
                }
            }
        }
        return retValues;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        Map map = new HashMap<>();
        for(int i=0; i<nums.length ; i++){
            map.put(i, nums[i]);
        }
        for(int i=0; i<map.size(); i++){
            for(int j=i+1; j<map.size(); j++){
                int value1 = (int)map.get(i);
                int value2 = (int)map.get(j);
                int value =value1 + value2;
                map.remove(i);
                map.remove(j);
                if(map.containsValue(value * (-1))){
                    List<Integer> intList = new ArrayList<Integer>();
                    intList.add(value1);
                    intList.add(value2);
                    intList.add(value*(-1));
                    retList.add((List)intList.stream().sorted().collect(Collectors.toList()));
                }
                map.put(i,value1);
                map.put(j,value2);
            }
        }
        return (List)retList.stream().distinct().collect(Collectors.toList());
    }
}
