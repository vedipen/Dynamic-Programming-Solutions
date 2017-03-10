/*
Problem Link: https://www.codechef.com/problems/ROBOWALL 

*/

import java.util.*;
import java.lang.*;
import java.io.*;


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int t;
       /* The problem statement says that there are n walls, which a player is supposed to cross.
       He can cross it by jumping on walls any number of times. There is an array A denoting the 
       scores associated with each wall, i.e the points one can score on jumping on ith wall.
       Another array B is given, which contains the jump strengths allowed, i.e the range of jumps
       the player is allowed to make. Keeping this in mind, the player is supposed to cross the 
       n  walls while scoring the maximum points. */
        Scanner sc = new Scanner(System.in);
       
        t=sc.nextInt();
       
        while(t!=0)
        {
            int a,n,m,i,j;
            long x;
            n=sc.nextInt();
            /*Two arrays are declared. The array v is to store the points for each wall and another array dp is to 
          store the points scored after jumping on the ith wall*/
        //Initially the array dp just stores the points of each wall
            long v[]= new long[n];
            long dp[]= new long[n];
           
            for(i=0; i<n; i++)
            {
               x=sc.nextLong();
               v[i]=x;
               dp[i]=x;
            }
           
            m=sc.nextInt();
            //Another array jmps is declare to store the jump strengths the person is allowed to make
            int jmps[]= new int[m];
            for(i=0; i<m; i++)
            {
                
                a=sc.nextInt();
                jmps[i]=a;
            }
           /*This problem can be solved by a bottom up approach, i.e we wil start with the smallest sub-problem and
          build the solution of the main problem by combining solutions of its sub-problems*/
        /*The smallest sub-problem is to calculate the score of the nth wall, i.e the score that a person can 
          obtain by jumping from the nth wall.*/
           for(i=n-1; i>=0; i--)
           {
           /*We start traversing the array from behind, to store the maximum points a person can score by
              jumping from the ith wall. The maximum score for jumping from the ith wall is stored in the dp[i].*/
                for(j=0; j<m; j++)
                {
                /*For every ith jump we will check the valid jumps from the ith position by checking if 
                  i+jmps[j] is less than n. If it is, then the jump is valid and we calculated the score for the ith wall.
                  Initially the score for ith wall in array dp, is v[i]. We calculate the score the person will obtain
                  after making the valid jump jmps[j] i.e v[i]+dp[i+jmps[j]].
                  We calculate the maximum points scored by considering the score obtained by doind every valid jump
                  from ith wall and taking the maximum value*/
                    if(i+jmps[j]<n)
                    {
                    /*for i=n-1 and for every jmps[j] no valid jump is valid. Hence score for i=n-1 is v[i]
                      i.e dp[n-1]=v[n-1]
                      For i=n-2, a jump strength of 1 is a valid jump
                      dp[i] stores previous score calculated for the ith wall. The current score is v[i]+dp[i+jmps[j]]
                      i.e v[i]+dp[i+1] in this case, which is -2. Since -2>-5(the previously calculated score), the maximum
                      score for (n-2)th wall is -2. Hence dp[n-2]=-2
                      In this way, you traverse the entire array and keep calculating the maximum score obtained by
                      jumping from ith wall in dp[i]. The final answer will be stored in dp[0] by employing this
                      bottom up approach*/
                        dp[i]=Math.max(dp[i], v[i]+ dp[i+jmps[j]]);
                    }
                }
           }
           //Final score obtained by the player, which is the maximum score 
           System.out.println(dp[0]);
           t--;
        }
    }
}

