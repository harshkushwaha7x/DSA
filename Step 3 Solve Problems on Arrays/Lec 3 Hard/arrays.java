// Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> dummyRow = new ArrayList<>();
            dummyRow.add(0);
            dummyRow.addAll(res.get(res.size() - 1));
            dummyRow.add(0);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < dummyRow.size() - 1; j++) {
                row.add(dummyRow.get(j) + dummyRow.get(j + 1));
            }

            res.add(row);
        }

        return res;        
    }
}

// Majority Element II

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}

// 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            
        int j= i+1;
        int k= nums.length-1;
        while(j<k){
            int total= nums[i]+ nums[j]+ nums[k];

            if(total>0){
                k--;
            }else if(total<0){
                j++;
            }else{
               result.add(Arrays.asList(nums[i], nums[j], nums[k])); 
               j++;

               while(nums[j]== nums[j-1] && j<k){
                 j++;
               }
            }
          }
        }
        return result;
    }
}

