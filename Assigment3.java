/** 
 * Name: Rohan Kohli
 * BCS 345
 * Assignment 3 Submission
 */

package Assigment3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class Assigment3 extends Application {

    Group group;
    GraphicsContext gc;

    // launch the application
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Canvas");
        // create a canvas using the new operator set the dimension as well
        Canvas canvas = new Canvas(600.0 , 600.0);
        // graphics context
        gc = canvas.getGraphicsContext2D();
        // create a Group for the canvas
        group = new Group(canvas);
        draw();
        // create a scene 
        Scene scene = new Scene(group, 600, 600);
        // set the scene
        stage.setScene(scene);
        // Show it on the screen
        stage.show();
    }

    public void draw() {
        //sky
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 600, 250);

        //lawn
        gc.setFill(Color.LIME);
        gc.fillRect(0, 250, 600, 600);

        //triangle
        Polyline triangle = new Polyline();
        triangle.getPoints().addAll(new Double[] {
            300.0,
            0.0, //clockwise points of triangle
            550.0,
            150.0,
            50.0,
            150.0,
            300.0,
            0.0,
        }); //same as first
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.WHITE);
        group.getChildren().add(triangle);

        //rectangle is the below triangle
        Rectangle rect1 = new Rectangle(70, 150, 460, 30);
        rect1.setFill(Color.WHITE);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);

        //rectabgle brown / wall
        rect1 = new Rectangle(70, 180, 460, 330);
        rect1.setFill(Color.CHOCOLATE);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);

        //window center
        rect1 = new Rectangle(260, 210, 80, 40);
        rect1.setFill(Color.LIGHTGRAY);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);

        //door1
        rect1 = new Rectangle(125, 295, 80, 165);
        rect1.setFill(Color.WHITE);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);
        //door1 blacks
        doorblacks(142, 310);
        //door1 pillar
        pillar(80, 180);

        //door2
        rect1 = new Rectangle(260, 275, 80, 190);
        rect1.setFill(Color.WHITE);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);
        //door2 blacks
        doorblacks(277, 310);
        //door2 pillar
        pillar(215, 180);

        //door3
        rect1 = new Rectangle(395, 295, 80, 165);
        rect1.setFill(Color.WHITE);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);
        //door3 blacks
        doorblacks(412, 310);
        //door3 pillar
        pillar(350, 180);
        //last pillar
        pillar(485, 180);

        //rect below doors
        rect1 = new Rectangle(70, 460, 460, 5);
        rect1.setFill(Color.LIGHTGRAY);
        rect1.setStroke(Color.BLACK);
        group.getChildren().add(rect1);

        stairs(120, 460);

        // Sun
        //gc.setFill(Color.ORANGE);
        //gc.fillOval(30, 30, 70, 70);

    }

    public void doorblacks(int x, int y) {
        Rectangle rect2;

        for (int i = 0, j = 0; i < 5; i++, j += 30) {
            rect2 = new Rectangle(x, y + j, 15, 25); //black left
            rect2.setFill(Color.BLACK);
            rect2.setStroke(Color.BLACK);
            group.getChildren().add(rect2);

            rect2 = new Rectangle(x + 30, y + j, 15, 25); //black right
            rect2.setFill(Color.BLACK);
            rect2.setStroke(Color.BLACK);
            group.getChildren().add(rect2);

        }
    }

    public void pillar(int x, int y) {
        Rectangle rect3;
        int width = 35, height = 270;

        rect3 = new Rectangle(x, y, width, height); //pillar
        rect3.setFill(Color.WHITE);
        rect3.setStroke(Color.BLACK);
        group.getChildren().add(rect3);

        rect3 = new Rectangle(x - 5, y + height, 45, 10); ////pillar base
        rect3.setFill(Color.WHITE);
        rect3.setStroke(Color.BLACK);
        group.getChildren().add(rect3);

        //circles
        Circle circle1 = new Circle();
        //Setting the properties of the circle
        int radius = 11;
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        circle1.setRadius(radius);
        circle1.setCenterX(x);
        circle1.setCenterY(y + radius);
        group.getChildren().add(circle1);

        Circle circle2 = new Circle();
        //Setting the properties of the circle   
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        circle2.setRadius(radius);
        circle2.setCenterX(x + width);
        circle2.setCenterY(y + radius);
        group.getChildren().add(circle2);
    }
s
    public void stairs(int x, int y) {
        Rectangle rect4;
        int width = 360, height = 10;

        for (int i = 1; i <= 11; i++) {
            rect4 = new Rectangle(x, y, width, 10);
            rect4.setFill(Color.LIGHTGRAY);
            rect4.setStroke(Color.BLACK);
            group.getChildren().add(rect4);
            x = x - 10; //decrease x for next stair by 10
            y = y + height; //increase y for next stair
            width = width + 20; //increase width for next stair by 10
        }
    }
    // Main Method
    public static void main(String args[]) {
        // launch the application
        launch(args);
    }
    
}