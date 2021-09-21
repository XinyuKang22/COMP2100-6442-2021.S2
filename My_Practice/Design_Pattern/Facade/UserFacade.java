import java.util.List;

public class UserFacade {

    public UserDto createPost(String username, String password, String content){
        UserSession userSession = new UserSession();
        userSession.login(username, password);
        UserActivity userActivity = userSession.createPost(content);
        List<ActionCount> actionCountList = userSession.generateActionCountReport();
        userSession.logout();
        UserDto userDto = new UserDto(userActivity, actionCountList);
        return userDto;
    }

    public UserDto likeAllPosts(String username, String passward){
        UserSession userSession = new UserSession();
        userSession.login(username, passward);
        List<UserActivity> allPosts = userSession.findAllPosts();
        UserActivity lastUserActivity = null;
        if (allPosts != null && !allPosts.isEmpty()){
            for (UserActivity userActivity : allPosts){
                userSession.likePost(userActivity.getIdPost());
                lastUserActivity = userActivity;
            }
        }
        List<ActionCount> actionCountList = userSession.generateActionCountReport();
        userSession.logout();
        UserDto userDto = new UserDto(lastUserActivity, actionCountList);
        return userDto;
    }

    public static void main(String[] args) {
        UserFacade userFacade = new UserFacade();
        userFacade.createPost("admin", "123", "abc");
        userFacade.createPost("admin", "123", "abcd");
        UserDto userDto = userFacade.createPost("admin", "123", "abcf");
        System.out.println(userDto);
    }
}
