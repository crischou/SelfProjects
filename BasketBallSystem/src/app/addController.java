package app;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addController implements Initializable {
    //table.fxml
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField age;

    @FXML
    private TextField pts;

    @FXML
    private TextField games;

    @FXML
    private Button addPlayer;

    @FXML
    private TextField assists;

    @FXML
    void addPlayerAction(ActionEvent event) {

    }
    //variables
    private BasketballPlayer player;
    private Controller mainController;
    Optional<BasketballPlayer>returnValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    //let parentcontroller have acess to child controller
    public void setParentController(Controller parentController){
        mainController = parentController;
    }
    public Button getButton(){
        return addPlayer;
    } //return player made from addController
    public BasketballPlayer getPlayer(){
        return player;
    }
    public Optional<BasketballPlayer> getNewItem(){

        return returnValue;
    }

    public void addPlayerAction(javafx.event.ActionEvent event) {

        String name;
        int ageInt, ptsInt, assistsInt, gamesInt;
        double ppg;
        BasketballPlayer newPlayer = new BasketballPlayer();
        //set textfields to variables
        name = firstName.getText() +" "+lastName.getText();
        ageInt = Integer.parseInt(age.getText());
        ptsInt = Integer.parseInt(pts.getText());
        assistsInt = Integer.parseInt(assists.getText());
        gamesInt = Integer.parseInt(games.getText());
        ppg = (double) ptsInt / gamesInt  ;
        //round to 2 decimal places
        DecimalFormat newVal = new DecimalFormat("#.##");
        ppg = Double.valueOf(newVal.format(ppg));

        //give basketballplayer its arguements
        newPlayer.setName(name);
        newPlayer.setAge(ageInt);
        newPlayer.setPoints(ptsInt);
        newPlayer.setAssists(assistsInt);
        newPlayer.setGames(gamesInt);
        newPlayer.setPPG(ppg);
        player = newPlayer;
        Node n = (Node) event.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        returnValue = Optional.of(newPlayer);
        //close after adding new player
        stage.close();
        /*firstName.clear();
        lastName.clear();
        age.clear();
        games.clear();
        pts.clear();*/
    }


}
