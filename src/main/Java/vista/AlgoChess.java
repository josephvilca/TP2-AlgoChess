package vista;

import modelo.*;
import controlador.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlgoChess extends Application {

    public static double width;
    public static double heigth;
    private Juego juego;


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {

        loadMainMenu(primaryStage);

    }

    
    public void loadMainMenu(Stage primaryStage) {


        try {

            BorderPane border = new BorderPane();
            border.setPadding(new Insets(20, 0, 20, 20));
            border.setId("background");


            // Botones
            Boton btnJugar = new Boton("Jugar");
            Boton btnSalir = new Boton("Salir del Juego");

            btnJugar.setMaxWidth(Double.MAX_VALUE);
            btnSalir.setMaxWidth(Double.MAX_VALUE);
   
            // Agrego botones a VBox
            VBox vbButtons = new VBox();
            vbButtons.setAlignment(Pos.CENTER);
            vbButtons.setSpacing(10);
            vbButtons.setPadding(new Insets(0, 20, 10, 20));
            vbButtons.getChildren().addAll(btnJugar, btnSalir);

            // Agrego lo anterior al BorderPane
            border.setCenter(vbButtons);
            border.setStyle("-fx-background-image: url('background.jpg')");
            
            Scene scene = new Scene(border, 1200, 900);
            primaryStage.setTitle("AlgoChess");
            
            ControladorDeEscena controladorDeEscena = new ControladorDeEscena(scene);
            
            JuegoVista juegoVista = new JuegoVista(controladorDeEscena);
            controladorDeEscena.agregarEscena("juegoVista", juegoVista.pane());
            
            PreJuego preJuego = new PreJuego(controladorDeEscena, juegoVista);
            controladorDeEscena.agregarEscena("preJuego", preJuego.pane());
            
            btnJugar.setOnAction(e -> {
                controladorDeEscena.activate("preJuego");
            });

            btnSalir.setOnAction(e -> {
                Platform.exit();
            });

            // PRUEBA
            System.out.println("Iniciando el juego");
            Juego juego = new Juego();

            ControladorJuego controladorJuego = new ControladorJuego(juegoVista, juego);
            juegoVista.setControlador(controladorJuego);
            //primaryStage.getIcons().add(new Image(AlgoCraft.class.getResourceAsStream("../../../res/icon.png")));
            primaryStage.setScene(scene);
            //scene.getStylesheets().add(AlgoCraft.class.getResource("../../../res/AlgoCraft.css").toExternalForm());
            primaryStage.show();

        }

        catch (Exception e) {

            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setTitle("ERROR");
            error.setHeaderText("Algo salio mal en tiempo de ejecucion...");
            error.setContentText("Tipo de error: " + e);
            error.initStyle(StageStyle.UTILITY);
            error.showAndWait();

        }
    }
}