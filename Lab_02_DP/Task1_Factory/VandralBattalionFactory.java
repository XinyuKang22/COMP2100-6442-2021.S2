package Task1_Factory;

/**
 * The factory class which produces Vandral battalions according to the schema provided.
 * Please note that you may edit this class as much as you like (create helper methods if you want!). So long as you genuinely pass the tests.
 * Ask questions if you are lost or unsure!
 */
public class VandralBattalionFactory {
    /*
    Copy of schema:
        At easy difficulty:
        - For every even level, an additional muggle is spawned.
        - For every 20 Muggles, 3 Low-Archons or 1 High-Archon an additional healer is spawned.
        - For every 5 levels up until level 75 a Low-Archon is spawned.
        - Beyond level 75, every 5 levels a High-Archon is spawned.

        At hard difficulty:
        - All spawn rates, except for healers, are halved rounding down.
        - Note that you will still spawn Low-Archons up until 75 and then High-Archons.

        For examples, please look at the lab slides.
     */

    /**
     * Creates a battalion to fight against!
     * @param difficulty set by user
     * @param playerLevel level that player is currently at between 1 and 100 inclusive
     * @return a Vandral battalion according to the schema
     * @throws Exception if the player level is not within 1 and 100 inclusive
     */
    public static VandralBattalion createVandralBattalion(Difficulty difficulty, int playerLevel)
        throws Exception {

        // We have done the exception handling for you. :)
        if (playerLevel < 1 || playerLevel > 100) {
            throw new Exception("Player level out of bounds");
        }

        // TODO: complete this method
        // If you are unsure of where to start, write your factory code below.
        // Keep in mind that you may use helper methods or edit this class as you please.

        int muggles = 0;
        int healers = 0;
        int lowArchons = 0;
        int highArchons = 0;
        int count_muggles = 0;
        int count_lowArchons = 0;
        int count_highArchons = 0;

        int x = difficulty.equals(Difficulty.EASY) ? 2:1;
        int y = difficulty.equals(Difficulty.EASY) ? 5:2;

        for (int i = 1; i <= playerLevel; i ++){
            if (i % x == 0){
                muggles = muggles + 1;
                count_muggles = count_muggles +1;
            }

            if (i % y == 0){
                if (i <= 75){
                    lowArchons = lowArchons +1;
                    count_lowArchons = count_lowArchons +1;
                }else if (i > 76){
                    highArchons = highArchons +1;
                    count_highArchons = count_highArchons +1;
                }
            }

            if (count_muggles >= 20){
                healers = healers +1;
                count_muggles = count_muggles -20;
            }
            if (count_lowArchons >= 3){
                healers = healers +1;
                count_lowArchons = count_lowArchons -3;
            }
            if (count_highArchons >= 1){
                healers = healers +1;
                count_highArchons = count_highArchons -1;
            }
        }


        // The following code is just here to prevent an error with regards to the method's promise to return something. Delete it when you start coding.
        return new VandralBattalion(muggles,healers,lowArchons,highArchons);

        // If you are unsure of where to start, write your factory code above.
    }

}
