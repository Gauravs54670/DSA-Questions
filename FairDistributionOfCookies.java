
public class FairDistributionOfCookies {
    int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        FairDistributionOfCookies fd = new FairDistributionOfCookies();
        int[] cookies = {8,15,10};
        int k = 2;
        int ans = fd.distributeCookies(cookies,k);
        System.out.println(ans);
    }
    private int distributeCookies(int[] cookies,int k) {
        int[] child = new int[k];
        int index = 0;
        solve(cookies,child,k,index);
        return answer;
    }
    private void solve(int[] cookies, int[] child, int k, int index) {
        int n = cookies.length;
        if(index == n) {
            int max = 0;
            for(int a: child) max = Math.max(max,a);
            answer = Math.min(answer,max);
            return;
        }
        for(int i = 0; i<k; i++) {
            child[i] += cookies[index];
            solve(cookies, child, k, index+1);
            child[i] -= cookies[index];
            if(child[i] == 0) break;
        }
    }
}
