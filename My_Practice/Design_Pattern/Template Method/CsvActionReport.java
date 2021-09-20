import java.util.ArrayList;
import java.util.List;

public class CsvActionReport extends ActionReport{
    @Override
    public List<UserActivity> parseFileContent(String rawData) {
        List<UserActivity> userActivityList = new ArrayList<>();
        if (rawData != null){
            String[] lines = rawData.split("\n");
            for (String line : lines){
                String[] strings = line.split(";");
                if (strings != null && strings.length == 4){
                    String username = strings[0];
                    String action = strings[1];
                    String content = strings[2];
                    Integer id = Integer.parseInt(strings[3]);
                    UserActivity userActivity = new UserActivity(username, action, content, id);
                    userActivityList.add(userActivity);
                }
            }
        }
        return userActivityList;
    }

    public List<ActionCount> generateReport(String filePath) {
        return null;
    }
}
