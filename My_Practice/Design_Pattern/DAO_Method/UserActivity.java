public class UserActivity {
    private String username;
    private String action;
    private String content;
    private Integer idPost;
    public UserActivity(String username, String action, String content, Integer idPost) {
        this.username = username;
        this.action = action;
        this.content = content;
        this.idPost = idPost;
    }

    public String getUsername() { return username;}

    public String getAction() { return action; }

    public String getContent() { return content;}

    public Integer getIdPost() { return idPost; }


}
