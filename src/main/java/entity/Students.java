package entity;


import java.io.Serializable;

public class Students implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9191142601688367354L;
	private String id;
    private String name;
    private String birthday;
    private String description;
    private String avgscore2019;

    public Students(){

    }
    public Students(String id, String name, String birthday, String description, String avgscore) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.description = description;
        this.avgscore = avgscore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(String avgscore) {
        this.avgscore = avgscore;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", description='" + description + '\'' +
                ", avgscore='" + avgscore + '\'' +
                '}';
    }
}
