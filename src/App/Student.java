package App;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private String gender;
    private String birthday;
    private double avg;
    private double minVote;
    private double maxVote;

    public Student(int id, String name, String lastname, String gender, String birthday,
                   double avg, double minVote, double maxVote) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = avg;
        this.minVote = minVote;
        this.maxVote = maxVote;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public double getAvg() {
        return avg;
    }

    public double getMinVote() {
        return minVote;
    }

    public double getMaxVote() {
        return maxVote;
    }
}

