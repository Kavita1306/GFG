
class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here
	 int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        int direction = 0;
        int count = 0;

        while (count < k) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    count++;
                    if (count == k) {
                        return A[top][i];
                    }
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    count++;
                    if (count == k) {
                        return A[i][right];
                    }
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    count++;
                    if (count == k) {
                        return A[bottom][i];
                    }
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    count++;
                    if (count == k) {
                        return A[i][left];
                    }
                }
                left++;
            }

            direction = (direction + 1) % 4;
        }

        return -1; // Return -1 if k is out of bounds
    }
    
}
