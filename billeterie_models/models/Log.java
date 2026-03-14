package billeterie_models.models;

public class Log {
    private int id;
    private String action;
    private String timestamp;
    private int userId;

    public Log(int id, String action, String timestamp, int userId) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public int getId() { return id; }
    public String getAction() { return action; }
    public String getTimestamp() { return timestamp; }
    public int getUserId() { return userId; }

    public void setId(int id) { this.id = id; }
    public void setAction(String action) { this.action = action; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setUserId(int userId) { this.userId = userId; }
}
