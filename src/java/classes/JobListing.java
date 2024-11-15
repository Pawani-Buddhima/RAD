package classes;

public class JobListing {
    private int id;
    private String title;
    private String type;
    private String requirements; 
    private String description;

    public JobListing() {
        // Default constructor
    }

    public JobListing(int id, String title, String type, String requirements, String description) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.requirements = requirements;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
