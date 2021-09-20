import java.util.List;

public class SessionState extends UserState{
    public SessionState(UserSession userSession){
        super(userSession);
    }

    @Override
    public boolean login(String userName, String password) {
        System.out.println("You cannot log in the session state.");
        return false;
    }

    @Override
    public UserActivity createPost(String content) {
        UserActivityDao userActivityDao = UserActivityDao.getInstance();
        UserActivity userActivity = userActivityDao.createPost(userSession.getUsername(), content);
        System.out.println("Post created with id " + userActivity.getIdPost());
        return null;
    }

    @Override
    public boolean likePost(Integer postId) {
        UserActivityDao userActivityDao = UserActivityDao.getInstance();
        userActivityDao.likePost(userSession.getUsername(),postId);
        System.out.println("You liked post " + postId);
        return true;
    }

    @Override
    public boolean logout() {
        userSession.changeState(new NoSessionState(userSession));
        System.out.println("Logout done");
        return true;
    }

    @Override
    public List<ActionCount> generateActionCountReport() {
        CsvActionReport csvActionReport = new CsvActionReport();
        UserActivityDao userActivityDao = UserActivityDao.getInstance();
        List<ActionCount> actionCountList = csvActionReport.generateReport(userActivityDao.getFilePath());
        return actionCountList;
    }

    @Override
    public List<UserActivity> findAllPosts() {
        UserActivityDao userActivityDao = UserActivityDao.getInstance();
        return userActivityDao.findAllPosts();
    }
}
