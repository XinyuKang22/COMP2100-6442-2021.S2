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

        // The following code is just here to prevent an error with regards to the method's promise to return something. Delete it when you start coding.
        return new VandralBattalion(0,0,0,0);

        // If you are unsure of where to start, write your factory code above.
    }

}
