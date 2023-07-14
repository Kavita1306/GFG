class Solution{
    public:
    //You need to complete this function    
    long long power(int N,int R)
    {
       long long ans = 1;
    long long mod = 1e9 + 7;
    long long pow = N * 1LL;
 
    while (R > 0) {
        // When reverse is odd
        if (R & 1) {
            ans = (ans * pow) % mod;
        }
        pow = (pow * pow) % mod;
        // Shifting right (rev = rev/2 )
        R >>= 1;
    }
    return ans;   
    }
};
