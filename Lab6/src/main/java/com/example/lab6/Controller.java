package com.example.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {

    @FXML private Spinner<Integer> widthSpinner;
    @FXML private Spinner<Integer> heightSpinner;
    @FXML private Pane centerPane;

    public void create(ActionEvent e){

        int currentHeight = heightSpinner.getValue();
        int currentWidth = widthSpinner.getValue();

        System.out.println("height: " + currentHeight + "   width: " + currentWidth);

        centerPane.getChildren().clear();

        int segmentWidth = 600 / currentWidth;
        int startWidth = segmentWidth / 2;
        int segmentHeight = 500 / currentHeight;
        int startHeight = segmentHeight / 2;


        for( int line = 0 ; line < currentHeight ; line++ ){
            for( int column = 0 ; column < currentWidth ; column++ ){
                Circle circle = new Circle(12);
                circle.setCenterX( startWidth + column * segmentWidth );
                circle.setCenterY( startHeight + line * segmentHeight );
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                centerPane.getChildren().add(circle);
            }
        }

        for( int line = 0 ; line < currentHeight; line++ ){
            for( int column = 0 ; column < currentWidth ; column++ ){

                if( line != (currentHeight - 1) ){
                    Line linePane = new Line();
                    linePane.setOpacity(0.5);
                    linePane.setStartX(startWidth + column * segmentWidth);
                    linePane.setStartY(startHeight + line * segmentHeight);
                    linePane.setEndX(startWidth + column * segmentWidth);
                    linePane.setEndY(startHeight + (line + 1) * segmentHeight);
                    linePane.setFill(Color.BLACK);
                    centerPane.getChildren().add(linePane);
                }

                if( column != (currentWidth - 1)){
                    Line columnPane = new Line();
                    columnPane.setOpacity(0.5);
                    columnPane.setStartX(startWidth + column * segmentWidth);
                    columnPane.setStartY(startHeight + line * segmentHeight);
                    columnPane.setEndX(startWidth + (column + 1) * segmentWidth);
                    columnPane.setEndY(startHeight + line * segmentHeight);
                    columnPane.setFill(Color.BLACK);
                    centerPane.getChildren().add(columnPane);
                }
            }
        }
    }
}