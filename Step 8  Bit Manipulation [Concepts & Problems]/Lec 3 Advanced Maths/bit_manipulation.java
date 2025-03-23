// Prime Factors

class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        // code here
        int i=2;
        List<Integer>list=new ArrayList<>();
        while(n!=1){
            if(n%i==0){
                n=n/i;
                if(!list.contains(i)) list.add(i);
            }else{
                i++;
            }
        }
        int res[]=new int[list.size()];
        for(int j=0;j<list.size();j++){
            res[j]=list.get(j);
        }
        return res;
    }
}