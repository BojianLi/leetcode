public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C - A) * (D - B);
        int b = (G - E) * (H - F);
        int c = 0;
        if (C > E && A < G && F < D && H > B) {
          c = ((Math.min(C, G) - Math.max(E, A)) * (Math.min(H, D) - Math.max(B, F)));
        }
        return a + b - c;
    }
}
