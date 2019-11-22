package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Calculator extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @FXML
    Label ans;




    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = primaryStage;
        window.setTitle("Calculator");
        window.setScene(new Scene(root, 474, 485));
        window.show();
    }


    ////////////////////////////////////////////////////////BUTTON ACTIONS/////////////////////////////////////////////////////////////////////////


    boolean equalPress;
    public void handlePlus(){
        ans.setText(ans.getText() + "+");
    }

    public void handleMinus(){
        ans.setText(ans.getText() + "-");
    }
    public void handleDivide(){
        ans.setText(ans.getText() + "÷");
    }
    public void handleMult(){
        ans.setText(ans.getText() + "x");
    }
    public void handleDec(){
        ans.setText(ans.getText() + ".");
    }
    public void handleClear(){
        ans.setText("");
    }


    public void handle() {
        ans.setText(getAns(ans));
        equalPress = true;
    }

    public void handleback(){
        String back = ans.getText();
        ans.setText(back.substring(0, back.length()-1));
    }

    public void handle0() {
        if(equalPress) {
            ans.setText("0");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "0");
    }

    public void handle1() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("1");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "1");
    }
    public void handle2() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("2");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "2");
    }
    public void handle3() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("3");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "3");
    }
    public void handle4() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("4");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "4");
    }
    public void handle5() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("6");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "6");
        }


    public void handle6() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("6");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "6");
    }
    public void handle7() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("7");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "7");
    }
    public void handle8() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("8");
            equalPress = false;
        }
        else
            ans.setText(ans.getText() + "8");
    }
    public void handle9() {
        if(equalPress && !(ans.getText().contains("x")) && !(ans.getText().contains("+")) && !(ans.getText().contains("-")) && !(ans.getText().contains("÷"))) {
            ans.setText("9");
            equalPress = false;
        }

        else
            ans.setText(ans.getText() + "9");
    }


    ////////////////////////////////////////////////////////END BUTTON ACTIONS/////////////////////////////////////////////////////////////////////////


    private String getAns(Label label){
        String answer;
        String string = label.getText();
        String[] parts;
        String part1;
        String part2;

       //try {
           if (string.contains("+")) {
               try{
               parts = string.split("\\+");
               part1 = parts[0];
               part2 = parts[1];
               if (isInt(Float.parseFloat(part1), Float.parseFloat(part2)))
                   answer = Integer.toString(Integer.parseInt(part1) + Integer.parseInt(part2));
               if ((Float.parseFloat(part1) + Float.parseFloat(part2)) % 1 == 0)
                   answer = Integer.toString(Math.round(Float.parseFloat(part1) + Float.parseFloat(part2)));
               else
                   answer = Float.toString(Float.parseFloat(part1) + Float.parseFloat(part2));

               return answer;
               }
               catch (Exception e){
                   return "0";
               }
           }
           if (string.contains("x")) {
               try{
               parts = string.split("x");
               part1 = parts[0];
               part2 = parts[1];
               if (isInt(Float.parseFloat(part1), Float.parseFloat(part2)))
                   answer = Integer.toString(Integer.parseInt(part1) * Integer.parseInt(part2));
               else
                   answer = Float.toString(Float.parseFloat(part1) * Float.parseFloat(part2));

               return answer;
               }
               catch (Exception e){
                   return "0";
               }
           }

           if (string.contains("÷")) {
               try{
               parts = string.split("÷");
               part1 = parts[0];
               part2 = parts[1];

               if (isDivisible(Float.parseFloat(part1), Float.parseFloat(part2)))
                   answer = Integer.toString(Integer.parseInt(part1) / Integer.parseInt(part2));
               else
                   answer = Float.toString(Float.parseFloat(part1) / Float.parseFloat(part2));

               return answer;
           }
               catch (Exception e){
            return "0";
        }
           }

           if (string.contains("-")) {
               try{
               parts = string.split("-");
               part1 = parts[0];
               part2 = parts[1];
               if (isInt(Float.parseFloat(part1), Float.parseFloat(part2)))
                   answer = Integer.toString(Integer.parseInt(part1) - Integer.parseInt(part2));
               else
                   answer = Float.toString(Float.parseFloat(part1) - Float.parseFloat(part2));

               return answer;
    }
               catch (Exception e){
        return "0";
    }
           }
           return "";


    }

    private boolean isDivisible(Float part1, Float part2){
        if(part1 % part2 == 0 && part1 % 1 == 0 && part2 % 1 ==0)
            return true;
        else
            return false;


    }
    private boolean isInt(Float part1, Float part2){
        if(part1 % 1 == 0 && part2 % 1 == 0)
            return true;
        else
            return false;
    }




}
