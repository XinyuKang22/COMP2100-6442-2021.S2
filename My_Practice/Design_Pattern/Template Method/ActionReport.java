import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ActionReport {

    // read data from file and return it as String
    public String readData(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        String fileContent = new String(bytes);
        return fileContent;
    }

    // get the file content and structure it as UserActivity instances
    public abstract List<UserActivity> parseFileContent(String rawData);

    // handle exception if needed
    public void handleException(Exception e) {
        System.out.println("Ops, something went wrong");
    }

    // count all actions
    public List<ActionCount> countActions(List<UserActivity> userActivityList){
        if (userActivityList != null && !userActivityList.isEmpty()){
            Map<String, ActionCount> actionCountMap = new HashMap<>();
            for (UserActivity userActivity : userActivityList){
                if (userActivity != null && userActivity.getAction() != null){
                    String action = userActivity.getAction();
                    if (!actionCountMap.containsKey(action)){
                        ActionCount actionCount = new ActionCount();
                        actionCount.setAction(action);
                        actionCount.setCount(0);
                        actionCountMap.put(action, actionCount);
                    }
                    ActionCount actionCount = actionCountMap.get(action);
                    actionCount.incrementCount();
                }
            }
            return new ArrayList<>(actionCountMap.values());

        }
        return null;
    }

    // this is the template method with all steps to generate the report
    public List<ActionCount> generateReport(String filePath){
        try {
            String data = readData(filePath);
            List<UserActivity> activityList = parseFileContent(data);
            List<ActionCount> actionCountList = countActions(activityList);
            return actionCountList;
        }catch (Exception e){
            handleException(e);
        }
        return null;
    }
}
