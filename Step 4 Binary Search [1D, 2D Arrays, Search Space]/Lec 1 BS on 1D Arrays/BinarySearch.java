import java.util.Arrays;

// Square Root
class SquareRoot {
    public int floorSqrt(int n) {
        int low = 1, high = n / 2, ans = -1;
        if (n == 1) return 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

// Find nth Root of m
class NthRoot {
    public int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = (long) Math.pow(mid, n);
            if (power == m) return mid;
            else if (power < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// Koko Eating Bananas
class KokoEatingBananas {
    public int max(int[] arr) {
        int m = -1;
        for (int i = 0; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }
        return m;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = max(piles); 
        int l = 1;          
        int r = n;          
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            long hr = 0; 
            int mid = (l + r) / 2;

            for (int i = 0; i < piles.length; i++) {
                hr += (long) (piles[i] + mid - 1) / mid; 
            }

            if (hr <= h) {
                ans = Math.min(ans, mid);
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }

        return ans; 
    }
}

// Minimum Number of Days to Make m Bouquets
class MinDaysToMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int consecutiveFlowers = 0, bouquetCount = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquetCount++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquetCount >= m;
    }
}

// Find the Smallest Divisor Given a Threshold
class SmallestDivisor {
    public int findSum(int[] nums, int div){
        int sum = 0;
        for(int n: nums){
            sum += Math.ceil((double)n / div);
        }
        return sum;
    }

    public int binarySearch(int[] nums, int threshold, int low, int high){
        while(low <= high){
            int mid = (low + high) / 2;
            if(findSum(nums, mid) > threshold){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int n: nums){            
            if(n > max){
                max = n;
            }
        }
        return binarySearch(nums, threshold, 1, max);
    }
}

// Capacity To Ship Packages Within D Days
class ShipPackages {
    public int countNoOfDays(int[] weights, int cap){
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            if(sum + weights[i] > cap){
                cnt++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        if(sum > 0){
            cnt++;
        }
        return cnt;
    }

    public int binarySearch(int[] weights, int days, int low, int high){
        while(low <= high){
            int mid = (low + high) / 2;
            int d = countNoOfDays(weights, mid);
            if(d > days){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = -1;
        for(int n: weights){
            sum += n;
            if(max < n){
                max = n;
            }
        }
        return Math.max(max, binarySearch(weights, days, 1, sum));
    }
}

// Kth Missing Positive Number
class KthMissingPositive {
    public int findKthPositive(int[] arr, int k) {
        for(int i : arr){
            if(i <= k) k++; else break;
        }
        return k;
    }
}

// Split Array Largest Sum
class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }

    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}

// Median of Two Sorted Arrays
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            new_arr[k++] = nums1[i++];
        }

        while (j < n2) {
            new_arr[k++] = nums2[j++];
        }

        if (n % 2 == 0) return (float)(new_arr[n/2 - 1] + new_arr[n/2]) / 2;
        else return new_arr[n/2];
    }
}

// K-th element of two Arrays
class KthElementOfTwoArrays {
    public int kthElement(int[] a, int[] b, int k) {
        int[] arr = new int[a.length + b.length];
        System.arraycopy(a, 0, arr, 0, a.length);
        System.arraycopy(b, 0, arr, a.length, b.length);
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
