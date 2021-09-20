import java.util.List;

public class NoSessionState extends UserState{
    public NoSessionState(UserSession userSession) {
        super(userSession);
    }

    @Override
    public boolean login(String userName, String password) {
        if ("admin".equals(userName) && "123".equals(password)){
            SessionState nextState = new SessionState(userSession);
            userSession.changeState(nextState);
            System.out.println("Login done.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    @Override
    public UserActivity createPost(String content) {
        System.out.println("You cannot create post in no session state.");
        return null;
    }

    @Override
    public boolean likePost(Integer postId) {
        System.out.println("You cannot like post in no session state.");
        return false;
    }


    @Override
    public boolean logout() {
        System.out.println("You cannot logout in no session state.");
        return false;
    }

    @Override
    public List<ActionCount> generateActionCountReport() {
        System.out.println("You cannot generate report in no session state.");
        return null;
    }

    @Override
    public List<UserActivity> findAllPosts() {
        System.out.println("You cannot get all posts in no session state.");
        return null;
    }
}
