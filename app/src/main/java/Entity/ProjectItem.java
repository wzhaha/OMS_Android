package Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lenovo on 2018/4/20.
 */

public class ProjectItem implements Serializable{


    String id;
    String name;
    String releaseDate;
    String dueDate;
    String publisherId;
    String description;
    ArrayList<String> projectFile=new ArrayList<String>();
    public ProjectItem(String id, String name,String description,String releaseDate,String dueDate,String publisherId,ArrayList<String> projectFile ){
        this.id = id;
        this.name=name;
        this.description=description;
        this.releaseDate=releaseDate;
        this.dueDate=dueDate;
        this.publisherId=publisherId;
        this.projectFile=projectFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public ArrayList<String> getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(ArrayList<String> projectFile) {
        this.projectFile = projectFile;
    }
}
