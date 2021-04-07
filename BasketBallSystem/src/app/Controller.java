package app;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Filter;

public class Controller implements Initializable {
    //table.fxml
    @FXML
    private TableView<BasketballPlayer> table_info;

    @FXML
    private TableColumn<BasketballPlayer, String> col_name;

    @FXML
    private TableColumn<BasketballPlayer, Integer> col_age;

    @FXML
    private TableColumn<BasketballPlayer, Integer> col_pts;

    @FXML
    private TableColumn<BasketballPlayer, Integer> col_assists;

    @FXML
    private TableColumn<BasketballPlayer, Integer> col_games;

    @FXML
    private TableColumn<BasketballPlayer, Double> col_ppg;

    @FXML
    private TextField filterField;

    @FXML
    private Button addWindow;

    @FXML
    private Button deleteWindow;

    @FXML
    void newAddWindow(ActionEvent event) {
    }

    @FXML
    void newDeleteWindow(ActionEvent event) {
    }

    //list to hold players
    private final ObservableList<BasketballPlayer> PlayerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //made with scenecreator
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_pts.setCellValueFactory(new PropertyValueFactory<>("points"));
        col_assists.setCellValueFactory(new PropertyValueFactory<>("assists"));
        col_games.setCellValueFactory(new PropertyValueFactory<>("games"));
        col_ppg.setCellValueFactory(new PropertyValueFactory<>("PPG"));
        //test players for the list
        BasketballPlayer player1 = new BasketballPlayer("Player1", 17, 33, 12, 10,3.3);
        BasketballPlayer player2 = new BasketballPlayer("Player2", 15, 10, 8, 10,.1);
        BasketballPlayer player3 = new BasketballPlayer("Player3", 18, 14, 3, 10,.14);
        BasketballPlayer player4 = new BasketballPlayer("Player4", 18, 77, 25, 10,7.7);

        PlayerList.addAll(player1,player2,player3,player4);

        //search function
        FilteredList<BasketballPlayer> filteredList = new FilteredList<>(PlayerList, b -> true);

            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(basketballPlayer -> {

                    if (newValue == null || newValue.isEmpty() ){
                        return true;
                    }
                    //can search by name or age
                    if(basketballPlayer.getName().equalsIgnoreCase(newValue)){
                        return true;
                    } else if(String.valueOf(basketballPlayer.getAge()).equalsIgnoreCase(newValue)){
                        return true;
                    }else{
                        return false;
                    }
        });
    });
            //sort filtered list
        SortedList<BasketballPlayer> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table_info.comparatorProperty());
        table_info.setItems(sortedList);
        //final test player
        BasketballPlayer player5 = new BasketballPlayer("Player5", 36, 17, 25, 50, 52);
        PlayerList.add(player5);


    }

    //for clicking add button
    public void newAddWindow(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
        Parent root = loader.load();

        addController newControl = loader.getController();
        BasketballPlayer newPlayer = new BasketballPlayer();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Add Player");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        //get basketball player from child controller (addController)
        Optional<BasketballPlayer> result = newControl.getNewItem();
        newPlayer = newControl.getPlayer();
        PlayerList.add(result.get());



    }

    //Delete Selected item
    public void newDeleteWindow(javafx.event.ActionEvent actionEvent)  {
    ObservableList<BasketballPlayer> selected;
    selected = table_info.getSelectionModel().getSelectedItems();

        selected.forEach(PlayerList::remove);

    }





}
