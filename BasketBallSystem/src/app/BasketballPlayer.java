package app;
//basketball player object
public class BasketballPlayer {
    private String name;
    private int age;
    private int games;
    private int points;
    private int assists;
    private double ppg;

    //default constructor
    public BasketballPlayer(){

    }


    public BasketballPlayer(String name, int age, int points, int assists, int games, double ppg)
    {
        this.name = name;
        this.age = age;
        this.games = games;
        this.points = points;
        this.assists = assists;
        this.ppg = ppg;
    }



    public String outPrint()
    {
        return "Name: " + "Points Per Game (PPG):  "+ points + " points!";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public double getPPG(){

        return ppg;
    }
    public void setPPG(double ppg){
        this.ppg = ppg;
    }
}
