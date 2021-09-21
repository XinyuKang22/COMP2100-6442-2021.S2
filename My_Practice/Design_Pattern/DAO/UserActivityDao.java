import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UserActivityDao implements UserActivityDaoInterface{

    // Singleton
    private static UserActivityDao instance;
    private UserActivityDao() {}
    public static UserActivityDao getInstance() {
        if (instance == null){
            instance = new UserActivityDao();
        }
        return instance;
    }

    private static File file;
    private static Integer idCount = 0;
    static {
        try {
            file = File.createTempFile("user-action", ".csv");
        } catch (IOException e){
            e.printStackTrace();
        }
    }




    @Override
    public UserActivity createPost(String username, String postContent) {
        try {
            idCount ++;
            String action = "create-post";
            String text = username + ";" + action + ";" + postContent + ";" + idCount + "\n";
            Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Post saved in " + file.getAbsolutePath());
            UserActivity userActivity = new UserActivity(username, action, postContent, idCount);
            return userActivity;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserActivity likePost(String username, Integer idPost) {
        try {
            String action = "like-post";
            String content = "+1";
            String text = username + ";" + content + ";" + idPost + "\n";
            Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Like saved in " + file.getAbsolutePath());
            UserActivity userActivity = new UserActivity(username, action, content, idPost);
            return userActivity;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserActivity> findAllPosts() {
        List<UserActivity> userActivityList = new ArrayList<>();
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            String fileContent = new String(bytes);
            String[] lines = fileContent.split("\n");
            if (lines != null){
                for (String line : lines){
                    String[] strings = line.split(";");
                    if (strings != null && strings.length == 4){
                        String username = strings[0];
                        String action = strings[1];
                        String content = strings[2];
                        Integer id = Integer.parseInt(strings[3]);
                        if ("create-post".equals(action)){
                            UserActivity userActivity = new UserActivity(username, action, content, id);
                            userActivityList.add(userActivity);
                        }
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return userActivityList;
    }

    @Override
    public String getFilePath() {
        return file.getAbsolutePath();
    }

    @Override
    public void deleteAll() {
        try {
            if (file.exists()){
                file.delete();
            }
            file = File.createTempFile("user-action", ".csv");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
