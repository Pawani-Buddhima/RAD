package classes;

public class Feedback {
    private int feedbackId;
    private String name;
    private String email;
    private String message;

    public Feedback(int feedbackId, String name, String email, String message) {
        this.feedbackId = feedbackId;
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public Feedback() {
        
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
