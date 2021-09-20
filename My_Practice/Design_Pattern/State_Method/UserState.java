import java.util.List;

public abstract class UserState {
    protected UserSession userSession;

    public UserState(UserSession userSession){
        this.userSession = userSession;
    }

    public abstract boolean login(String userName, String password);
    public abstract UserActivity createPost(String content);
    public abstract boolean likePost(Integer postId);
    public abstract boolean logout();
    public abstract List<ActionCount> generateActionCountReport();
    public abstract List<UserActivity> findAllPosts();
}
