import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Solution5 单元测试类
 * 
 * 测试用例设计原则：
 * 1. 等价类划分：将输入分为有效等价类和无效等价类
 *    - 有效等价类：满足条件的合法输入（1 <= nums.length <= 10^5, 1 <= nums[i] <= 10^6, 1 <= target <= 10^6）
 *    - 边界情况：数组长度为1、数组元素重复、target过小等
 * 2. 边界值分析：测试边界条件
 *    - 最小值：nums.length = 1, target = nums[0]
 *    - 特殊情况：所有元素相同、target < 最小元素和等
 * 3. 功能性测试：验证子序列计数的正确性
 */
public class L2023112099_5_Test {

    /**
     * 测试目的：验证基本的多元素数组情况
     * 测试用例：nums = [3,5,6,7], target = 9
     * 预期结果：4个子序列 [3], [3,5], [3,5,6], [3,6]
     */
    @Test
    public void testExample1() {
        Solution5 s = new Solution5();
        int[] nums = {3, 5, 6, 7};
        assertEquals(4, s.numSubseq(nums, 10));
    }

    /**
     * 测试目的：验证数组包含重复元素的情况
     * 测试用例：nums = [3,3,6,8], target = 10
     * 预期结果：6个子序列 [3], [3], [3,3], [3,6], [3,6], [3,3,6]
     */
    @Test
    public void testExample2() {
        Solution5 s = new Solution5();
        int[] nums = {3, 3, 6, 8};
        assertEquals(6, s.numSubseq(nums, 10));
    }

    /**
     * 测试目的：验证较大规模数据的计算
     * 测试用例：nums = [2,3,3,4,6,7], target = 12
     * 预期结果：61个有效子序列（总63个 - 2个无效的 [6,7], [7]）
     */
    @Test
    public void testExample3() {
        Solution5 s = new Solution5();
        int[] nums = {2, 3, 3, 4, 6, 7};
        assertEquals(61, s.numSubseq(nums, 12));
    }

    /**
     * 测试目的：验证数组长度为1的边界情况
     * 测试用例：nums = [5], target = 10
     * 预期结果：1个子序列 [5]
     */
    @Test
    public void testSingleElement() {
        Solution5 s = new Solution5();
        int[] nums = {5};
        assertEquals(1, s.numSubseq(nums, 10));
    }

    /**
     * 测试目的：验证target等于最小元素情况
     * 测试用例：nums = [1,2,3], target = 2
     * 预期结果：1个子序列 [1]
     */
    @Test
    public void testTargetEqualsMinElement() {
        Solution5 s = new Solution5();
        int[] nums = {1, 2, 3};
        assertEquals(1, s.numSubseq(nums, 2));
    }

    /**
     * 测试目的：验证target小于任何两个元素和的情况
     * 测试用例：nums = [5,10,15], target = 10
     * 预期结果：1个子序列 [5]
     */
    @Test
    public void testTargetTooSmall() {
        Solution5 s = new Solution5();
        int[] nums = {5, 10, 15};
        assertEquals(1, s.numSubseq(nums, 10));
    }

    /**
     * 测试目的：验证所有元素相同的情况
     * 测试用例：nums = [2,2,2,2], target = 4
     * 预期结果：15个子序列（任意非空子集都满足 min + max = 2 + 2 = 4）
     */
    @Test
    public void testAllElementsSame() {
        Solution5 s = new Solution5();
        int[] nums = {2, 2, 2, 2};
        assertEquals(15, s.numSubseq(nums, 4));
    }

    /**
     * 测试目的：验证target足够大包含所有元素的情况
     * 测试用例：nums = [1,2,3], target = 100
     * 预期结果：7个子序列（所有非空子集）
     */
    @Test
    public void testTargetVeryLarge() {
        Solution5 s = new Solution5();
        int[] nums = {1, 2, 3};
        assertEquals(7, s.numSubseq(nums, 100));
    }
}
