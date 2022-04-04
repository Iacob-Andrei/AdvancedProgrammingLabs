package com.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.Random;

public class Controller {

    static int turn = 0;
    @FXML private Spinner<Integer> widthSpinner;
    @FXML private Spinner<Integer> heightSpinner;
    @FXML private Pane centerPane;

    public void createCircles(int currentHeight, int currentWidth){

        int segmentWidth = 600 / currentWidth;
        int startWidth = segmentWidth / 2;
        int segmentHeight = 500 / currentHeight;
        int startHeight = segmentHeight / 2;

        for( int line = 0 ; line < currentHeight ; line++ ){
            for( int column = 0 ; column < currentWidth ; column++ ){
                Circle circle = new Circle(12);
                circle.setOnMouseClicked(event -> {
                    Color currentColor = (Color)circle.getFill();
                    if( Color.WHITE.equals(currentColor) ){
                        if( turn == 0 ){
                            circle.setFill(Color.RED);
                            turn = 1;
                        }else{
                            circle.setFill(Color.BLUE);
                            turn = 0;
                        }
                    }
                });
                circle.setCenterX( startWidth + column * segmentWidth );
                circle.setCenterY( startHeight + line * segmentHeight );
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                centerPane.getChildren().add(circle);
            }
        }
    }

    public void createLines(int currentHeight, int currentWidth){

        int segmentWidth = 600 / currentWidth;
        int startWidth = segmentWidth / 2;
        int segmentHeight = 500 / currentHeight;
        int startHeight = segmentHeight / 2;

        for( int line = 0 ; line < currentHeight; line++ ){
            for( int column = 0 ; column < currentWidth ; column++ ){

                Random random = new Random();

                if( line != (currentHeight - 1) ){
                    Line linePane = new Line();
                    linePane.setStartX(startWidth + column * segmentWidth);
                    linePane.setStartY(startHeight + line * segmentHeight);
                    linePane.setEndX(startWidth + column * segmentWidth);
                    linePane.setEndY(startHeight + (line + 1) * segmentHeight);
                    linePane.setFill(Color.DARKGRAY);
                    linePane.setOpacity(0.5);

                    if( (random.nextInt(5) + 1) >= 3 ){
                        linePane.setOpacity(1);
                        linePane.setStrokeWidth(7);
                    }
                    centerPane.getChildren().add(linePane);
                }

                if( column != (currentWidth - 1)){
                    Line columnPane = new Line();
                    columnPane.setOpacity(0.5);
                    columnPane.setStartX(startWidth + column * segmentWidth);
                    columnPane.setStartY(startHeight + line * segmentHeight);
                    columnPane.setEndX(startWidth + (column + 1) * segmentWidth);
                    columnPane.setEndY(startHeight + line * segmentHeight);
                    columnPane.setFill(Color.DARKGRAY);

                    if( (random.nextInt(5) + 1) >= 3 ){
                        columnPane.setOpacity(1);
                        columnPane.setStrokeWidth(7);
                    }

                    centerPane.getChildren().add(columnPane);
                }
            }
        }
    }

    public void create(){

        int currentHeight = heightSpinner.getValue();
        int currentWidth = widthSpinner.getValue();

        centerPane.getChildren().clear();

        createLines(currentHeight, currentWidth);
        createCircles(currentHeight, currentWidth);
    }
}