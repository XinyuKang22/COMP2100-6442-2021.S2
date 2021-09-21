import java.util.List;

public class UserSession {

    // current state of the session
    UserState userState;
    String userName;

    public UserSession() {
        UserState defaultState = new NoSessionState(this);
        changeState(defaultState);
    }

    public void changeState(UserState userState) {
        this.userState = userState;
    }

    public boolean login(String userName, String password){
        boolean loginOk = userState.login(userName, password);
        if (loginOk){
            this.userName = userName;
        }
        return loginOk;
    }

    public UserActivity createPost(String content){
        return userState.createPost(content);
    }

    public boolean likePost(Integer postId){
        return userState.likePost(postId);
    }

    public List<ActionCount> generateActionCountReport(){
        return userState.generateActionCountReport();
    }

    public boolean logout() {
        boolean logoutOk = userState.logout();
        if (logoutOk){
            this.userName = null;
        }
        return logoutOk;
    }

    public List<UserActivity> findAllPosts(){
        return userState.findAllPosts();
    }

    public String getUsername() {
        return userName;
    }


}
