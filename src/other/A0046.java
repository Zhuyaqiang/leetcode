package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class A0046 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        boolean[] seen = new boolean[len];
        backtrack(res, new ArrayList<>(), seen, len, nums);
        return res;
    }
    public static void backtrack(List<List<Integer>> res, List<Integer> list, boolean[] seen, int len, int[] nums) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!seen[i]) {
                seen[i] = true;
                list.add(nums[i]);
                backtrack(res, list, seen, len, nums);
                list.remove(list.size() - 1);
                seen[i] = false;
            }
        }
    }
}
