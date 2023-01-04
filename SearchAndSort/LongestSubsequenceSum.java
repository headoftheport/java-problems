class LongestSubsequenceSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        // Arrays.sort(queries);

        int numsIter = 0;
        int queryIter = 0;
        int sum = 0;
        int count = 0;
        while(numsIter < nums.length){
            sum += nums[numsIter];
            count++;
            queryIter = 0;
            while(queryIter < queries.length){
                if(sum <= queries[queryIter]){
                    ans[queryIter] = count;
                }
                queryIter++;
            }
           
            numsIter++;
        }

        return ans;
    }
}