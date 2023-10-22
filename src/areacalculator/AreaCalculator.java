/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areacalculator;


import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Olive
 */
public class AreaCalculator extends Application {
   static Stage secondStage = new Stage();
    
    @Override
    public void start(Stage page2) {
        Text triangle_lbl = new Text("Traingle");
        triangle_lbl.setFont(Font.font("verdana", FontPosture.REGULAR,20));
        Text triangleInput_lbl = new Text("Enter Dimensions Below:");
        Text base_lbl = new Text("Base:");
        Text height_lbl = new Text("Height:");
        TextField triA = new TextField();
        TextField triB = new TextField();
        Text result = new Text();
        
        Button calcTri = new Button("Calculate!");
        calcTri.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if( triA.getText().trim().isEmpty() ||triB.getText().trim().isEmpty() ){
                  result.setText("Invalid Input");
                }
                else{
                    double a = Double.parseDouble(triA.getText());
                    double b = Double.parseDouble(triB.getText());
                    result.setText(" Area of Triangle: "+Double.toString(0.5*a*b));
                    
                }
            }
        });
        
        Separator sep1 = new Separator(Orientation.VERTICAL);
        

        Text circle_lbl = new Text("Circle");
        circle_lbl.setFont(Font.font("verdana", FontPosture.REGULAR,20));
        Text circleInput_lbl = new Text("Enter Radius Below:");
        TextField circleA = new TextField();
        Button calcCircle = new Button("Calculate!");
        calcCircle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
              if( circleA.getText().trim().isEmpty() ){
                  result.setText("Invalid Input");
                }
                else{
                    double r = Double.parseDouble(circleA.getText());
                    result.setText(" Area of Circle: "+Double.toString(Math.PI * r *r));
                }  
            }
        });
        
        Separator sep2 = new Separator(Orientation.VERTICAL);

        Text rect_lbl = new Text("Rectangle");
        rect_lbl.setFont(Font.font("verdana", FontPosture.REGULAR,20));
        Text rectInput_lbl = new Text("Enter Dimensions Below:");
        TextField rectA = new TextField();
        TextField rectB = new TextField();
        Button calcRect = new Button("Calculate!");
        
        calcRect.setOnMouseClicked( new EventHandler <MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            if( rectA.getText().trim().isEmpty() ||rectB.getText().trim().isEmpty() ){
                  result.setText("Invalid Input");
                }
                else{
                  double l = Double.parseDouble(rectA.getText());
                  double w = Double.parseDouble(rectB.getText());
                  result.setText(" Area of Rectangle: "+Double.toString(l*w));
                   
                } 
        }
    });
        
        
        result.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,15));

        Button tempCalc = new Button ("Temperature Calculator");
        tempCalc.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                Stage stage = (Stage)tempCalc.getScene().getWindow();  
                stage.close(); 
            }
        });
         
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000, 400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(triangle_lbl,1,0);
        gridPane.add(triangleInput_lbl,1,1);
        gridPane.add(base_lbl, 0, 2);
        gridPane.add(triA, 1, 2);
        gridPane.add(height_lbl, 0, 3);
        gridPane.add(triB, 1, 3);
        gridPane.add(calcTri,1,4);
        
        gridPane.add(sep1,2,0,1,5);
        
        gridPane.add(circle_lbl,4,0);
        gridPane.add(circleInput_lbl,4,1,1,1);
        gridPane.add(circleA,4,2);
        gridPane.add(calcCircle,4,3);
        
        gridPane.add(sep2,5,0,1,5);
       
        gridPane.add(rect_lbl,6,0);
        gridPane.add(rectInput_lbl,6,1);
        VBox rectDimensions = new VBox();
        rectDimensions.setSpacing(10);
        rectDimensions.getChildren().addAll(rectA,rectB);
        gridPane.add(rectDimensions,6,2,2,1);
        gridPane.add(calcRect,6,3);
        
        gridPane.add(result,4,6);
        
        gridPane.add(tempCalc,6,7);

        page2.setTitle(" Area Calculator");

        Scene my_scene = new Scene(gridPane);

        page2.setScene(my_scene);
        page2.show();
    }
}