
/**
 * Skeleton code for Edit Distance Computation of DNA sequences.
 * The DNA sequence consists of four characters only: {A, C, G, T}.
 * You are required to implement the minDistance method by dynamic programming.
 * The edit costs are defined in EditCost class.
 *
 * The given code is provided to assist you to complete the required tasks. But the
 * given code is often incomplete. You have to read and understand the given code
 * carefully, before you can apply the code properly. You might need to implement
 * additional procedures, such as error checking and handling, in order to apply the
 */

public class EditDistance {

    /* Compute the minimal total cost of character edits between two DNA sequences by dynamic programming.
     *
     * @param seq1 the original sequence.
     * @param seq2 the target sequence.
     * @return the minimal cost of the character edits.
     */
    public static int minDistance(String seq1, String seq2){
        // TODO: Complete this method
        // START YOUR CODE
        int n1 = seq1.length();
        int n2 = seq2.length();
        int dp[][] = new int[n1+1][n2+1];

        //init value(dp[0][0...n2]
        for (int j = 1;j<=n2;j++){
            dp[0][j] = dp[0][j-1] + EditCost.getInsertCost(EditCost.convertToIndex(seq2.charAt(j-1)));
        }

        //init value(dp[0...n1][0]
        for (int k = 1;k<=n1;k++){
            dp[k][0] = dp[k-1][0] + EditCost.getDeleteCost(EditCost.convertToIndex(seq1.charAt(k-1)));
        }

        // State transition equation
        for (int j = 1;j<=n2;j++){
            for (int k = 1;k<=n1;k++){
                if (seq1.charAt(k-1)==seq2.charAt(j-1)){
                    dp[k][j] = dp[k-1][j-1];
                }else {
                    int index1 = EditCost.convertToIndex(seq1.charAt(k-1));
                    int index2 = EditCost.convertToIndex(seq2.charAt(j-1));
                    int insert_cost  = EditCost.getInsertCost(index2);
                    int replace_cost = EditCost.getReplaceCost(index1,index2);
                    int delete_cost = EditCost.getDeleteCost(index1);
                    dp[k][j] = Math.min(Math.min(dp[k-1][j-1]+replace_cost,
                            dp[k][j-1]+insert_cost),dp[k-1][j]+delete_cost);
                }
            }
        }

        return dp[n1][n2];
        // END YOUR CODE

    }

}