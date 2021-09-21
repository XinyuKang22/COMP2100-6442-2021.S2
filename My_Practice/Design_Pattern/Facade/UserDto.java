import java.util.List;

public class UserDto {

    private UserActivity lastPostCreated;
    private List<ActionCount> communityReport;

    public UserDto(UserActivity lastPostCreated, List<ActionCount> communityReport){
        this.lastPostCreated = lastPostCreated;
        this.communityReport = communityReport;
    }

    public UserActivity getLastPostCreated(){
        return lastPostCreated;
    }

    public List<ActionCount> getCommunityReport(){
        return communityReport;
    }
}
