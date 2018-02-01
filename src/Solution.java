
public class Solution {
	public int longestSubstring(String s, int k) {
        int res = 0, n = s.length(), i = 0;
        while(i + k <= n){
            int m[] = new int[26];
        	int mask = 0, maxIdx = i;
        	for(int a = 0; a < 26; a++){
        		m[a] = 0;
        	}
        	for(int j = i; j < n; j++){
        		int t = s.charAt(j) - 'a';
        		m[t]++;
        		if(m[t] < k)
        			mask |= (1 << t);
        		else
        			mask &= (~(1 << t));
        		
        		if(mask == 0){
        			res = Math.max(res, j - i + 1);
        			maxIdx = j;
        		}
        	}
        	i = maxIdx + 1;
        }
        
        return res;
    }
}
