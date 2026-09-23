problem:883
problem name:Projection Area of 3D Shapes
category:easy
  class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int top = 0;
        int side = 0;
        int front = 0;
        for(int i=0;i<n;i++)
            {
                int maxi = 0;
                for(int j=0;j<n;j++)
                    {
                        maxi = Math.max(maxi,grid[i][j]);
                        if(grid[i][j]!=0)top++;
                    }
                side += maxi;
            }
        for(int j=0;j<n;j++)
            {
                int maxi = 0;
                for(int i=0;i<n;i++)
                    {
                        maxi = Math.max(maxi,grid[i][j]);
                    }
                front += maxi;
            }
        return top+front+side;
    }
}

problem:860
problem name:Lemonade Change
category:easy
  class Solution {
    public boolean lemonadeChange(int[] bills) {

        // Number of $5 bills we currently have
        int five = 0;

        // Number of $10 bills we currently have
        int ten = 0;

        // Process customers in order
        for (int bill : bills) {

            // Customer pays with $5
            if (bill == 5) {

                // No change needed
                five++;

            } else if (bill == 10) {

                // Need $5 as change
                if (five == 0) return false;

                // Give one $5
                five--;

                // Keep the customer's $10
                ten++;

            } else { // bill == 20

                // Need $15 change
                // Prefer $10 + $5 to preserve $5 bills
                if (ten > 0 && five > 0) {

                    ten--;
                    five--;

                } else if (five >= 3) {

                    // Otherwise use three $5 bills
                    five -= 3;

                } else {

                    // Cannot provide $15 change
                    return false;
                }
            }
        }

        // Successfully served every customer
        return true;
    }
}
