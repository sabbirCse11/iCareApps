package Database;

/**
 * Created by Mobile App Develop on 7-1-16.
 */
public class UserProfileTable {

    private int userId;
    private String userName;
    private String gender;
    private String dateOfBirth;
    private double age;
    private String bloodGroup;
    private double height;
    private double weight;


    public UserProfileTable(String userName, String gender, String dateOfBirth, double age, String bloodGroup, double height, double weight, int userId) {
        this.userName = userName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
        this.userId = userId;
    }

    public UserProfileTable(String userName, String gender, String dateOfBirth, double age, String bloodGroup, double height, double weight) {
        this.userName = userName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
    }

    public UserProfileTable(String userName, double age, double height, double weight) {
        this.userName = userName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
