public class ActionCount {
    private String action;
    private Integer count;

    public String getAction(){
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public Integer getCount(){
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public void incrementCount() {
        count++;
    }
}
