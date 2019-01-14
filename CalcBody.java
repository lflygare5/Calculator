package application;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class CalcBody extends Application {
    String firstValue = "";
    String secondValue = ""; 
    Character operator = null; 
    
    // mathematic Objects 
    Add addObj = new Add(); 
    
    
    ArrayList<String> valuesArray = new ArrayList<String>(); 
	@Override
	public void start(Stage primaryStage) {
		try {
		    VBox vBox = new VBox(); 
			Scene scene = new Scene(vBox,400,400);
			
			primaryStage.setTitle("Calculator"); 
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Label outputLabel = new Label(); 
			
			TextField textField = new TextField(); 
			textField.setPromptText("NUMBERS");
			textField.setFocusTraversable(false);
			
			// list of the current operation 
			// bRedmond5
			// use an array list with the operators and the numbers 
			
			EventHandler<ActionEvent> addButton = new EventHandler<ActionEvent>()
			{
			    public void handle(ActionEvent event)
			    {
			        valuesArray.add(textField.getText()); 
			        valuesArray.add("+"); 
			        /*firstValue = textField.getText(); 
			        operator = '+'; */
			        textField.clear();
			        textField.requestFocus(); 
			    }
			}; 
			Button b1 = new Button(); 
            b1.setText("+"); 
            b1.setOnAction(addButton);
            
            EventHandler<ActionEvent> subtractButton = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    valuesArray.add(textField.getText()); 
                    valuesArray.add("-"); 
                    /*firstValue = textField.getText(); 
                    operator = '-'; */
                    textField.clear();
                    textField.requestFocus(); 
                }
            }; 
			Button b2 = new Button(); 
			b2.setText("-");
			b2.setOnAction(subtractButton);
			
			EventHandler<ActionEvent> multiplyButton = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    valuesArray.add(textField.getText()); 
                    valuesArray.add("*"); 
                    /*firstValue = textField.getText(); 
                    operator = '*';*/
                    textField.clear();
                    textField.requestFocus(); 
                }
            }; 
			Button b3 = new Button(); 
            b3.setText("*"); 
            b3.setOnAction(multiplyButton);
            
            EventHandler<ActionEvent> divideButton = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    valuesArray.add(textField.getText()); 
                    valuesArray.add("/"); 
                    /*firstValue = textField.getText(); 
                    operator = '/'; */
                    textField.clear();
                    textField.requestFocus(); 
                }
            }; 
            Button b4 = new Button(); 
            b4.setText("/"); 
            b4.setOnAction(divideButton);
            
            EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    if(valuesArray.size() <= 1)
                    {
                        valuesArray.clear(); 
                    }
                    else
                    {
                        valuesArray.add(textField.getText());
                        //int operatorValue = 0; 
                        for(int i = 0; i < valuesArray.size(); i++)
                        {
                            ArrayList<String> tempArray = new ArrayList<String>(); 
                            int num1 = Integer.parseInt(valuesArray.get(0)); 
                            String operator = valuesArray.get(1); 
                            int num2 = Integer.parseInt(valuesArray.get(2));
                            
                            int firstValue = 0; 
                            
                            if(operator.equals("+"))
                            {
                                //operatorValue = addObj.execute(num1, num2); 
                                 firstValue = addObj.execute(num1, num2); 
                            }
                            else if(operator.equals("-"))
                            {
                                firstValue = num1 - num2; 
                            }
                            else if(operator.equals("*"))
                            {
                                firstValue = num1 * num2; 
                            }
                            else if(operator.equals("/"))
                            {
                                firstValue = num1 / num2; 
                            }
                            
                            tempArray.add(Integer.toString(firstValue));
                            
                            if(valuesArray.size() > 3)
                            {
                                for(int j = 3; j < valuesArray.size(); j++)
                                {
                                    tempArray.add(valuesArray.get(j)); 
                                }
                            }
                            valuesArray = tempArray; 
                            
                            if(valuesArray.size() == 1)
                            {
                                break; 
                            }
                        }
                        outputLabel.setText(valuesArray.get(0)); 
                    }
                    /*
                    firstValue = firstValue.trim(); 
                    secondValue = textField.getText().trim(); 
                    if(operator.equals('+'))
                    {
                        int finalInt = Integer.parseInt(firstValue) + 
                                        Integer.parseInt(secondValue); 
                        outputLabel.setText(Integer.toString(finalInt)); 
                    }
                    else if(operator.equals('-'))
                    {
                        int finalInt = Integer.parseInt(firstValue) - 
                                        Integer.parseInt(secondValue); 
                        outputLabel.setText(Integer.toString(finalInt)); 
                    }
                    else if(operator.equals('*'))
                    {
                        int finalInt = Integer.parseInt(firstValue) * 
                                        Integer.parseInt(secondValue); 
                        outputLabel.setText(Integer.toString(finalInt)); 
                    }
                    else if(operator.equals('/'))
                    {
                        int finalInt = Integer.parseInt(firstValue) / 
                                        Integer.parseInt(secondValue); 
                        outputLabel.setText(Integer.toString(finalInt)); 
                    }*/
                }
            };
            
            Button finalB = new Button(); 
            finalB.setText("="); 
            finalB.setOnAction(addEvent);
            
            
            EventHandler<ActionEvent> bOne = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("1"); 
                }
            };
            Button one = new Button(); 
            one.setText("1");
            one.setOnAction(bOne);
            
            EventHandler<ActionEvent> bTwo = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("2"); 
                }
            };
            Button two = new Button(); 
            two.setText("2");
            two.setOnAction(bTwo);
            
            EventHandler<ActionEvent> bThree = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("3"); 
                }
            };
            Button three = new Button(); 
            three.setText("3");
            three.setOnAction(bThree);
            
            HBox hBoxNum1 = new HBox(); 
            hBoxNum1.getChildren().addAll(one, two, three); 
            
            EventHandler<ActionEvent> bFour = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("4"); 
                }
            };
            Button four = new Button(); 
            four.setText("4");
            four.setOnAction(bFour);
            
            EventHandler<ActionEvent> bFive = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("5"); 
                }
            };
            Button five = new Button(); 
            five.setText("5");
            five.setOnAction(bFive);
            
            EventHandler<ActionEvent> bSix = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("6"); 
                }
            };
            Button six = new Button(); 
            six.setText("6");
            six.setOnAction(bSix);
            
            HBox hBoxNum2 = new HBox(); 
            hBoxNum2.getChildren().addAll(four, five, six); 
            
            EventHandler<ActionEvent> bSeven = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("7"); 
                }
            };
            Button seven = new Button(); 
            seven.setText("7");
            seven.setOnAction(bSeven);
            
            EventHandler<ActionEvent> bEight = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("8"); 
                }
            };
            Button eight = new Button(); 
            eight.setText("8");
            eight.setOnAction(bEight);
            
            EventHandler<ActionEvent> bNine = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("9"); 
                }
            };
            Button nine = new Button(); 
            nine.setText("9");
            nine.setOnAction(bNine); 
            
            HBox hBoxNum3 = new HBox(); 
            hBoxNum3.getChildren().addAll(seven, eight, nine); 
            
            EventHandler<ActionEvent> bZero = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    textField.appendText("0"); 
                }
            };
            Button zero = new Button(); 
            zero.setText("0");
            zero.setOnAction(bZero);
            
            Button nullB1 = new Button(); 
            nullB1.setText("  "); 
            Button nullB2 = new Button(); 
            nullB2.setText("  "); 
            
            HBox hBoxNum4 = new HBox(3); 
            hBoxNum4.getChildren().addAll(nullB1, zero, nullB2); 
            
            // when keys are pressed 
            scene.setOnKeyPressed(
                            event -> 
                            {
                                // operators 
                                if(event.getText().equals("+"))
                                {
                                    b1.fire(); 
                                }
                                else if(event.getText().equals("-"))
                                {
                                    b2.fire(); 
                                }
                                else if(event.getText().equals("*"))
                                {
                                    b3.fire(); 
                                }
                                else if(event.getText().equals("/"))
                                {
                                    b4.fire(); 
                                }
                                // numbers 
                                else if(event.getText().equals("1"))
                                {
                                    textField.appendText("1");
                                }
                                else if(event.getText().equals("2"))
                                {
                                    textField.appendText("2");
                                }
                                else if(event.getText().equals("3"))
                                {
                                    textField.appendText("3");
                                }
                                else if(event.getText().equals("4"))
                                {
                                    textField.appendText("4"); 
                                }
                                else if(event.getText().equals("5"))
                                {
                                    textField.appendText("5");
                                }
                                else if(event.getText().equals("6"))
                                {
                                    textField.appendText("6");
                                }
                                else if(event.getText().equals("7"))
                                {
                                    textField.appendText("7");
                                }
                                else if(event.getText().equals("8"))
                                {
                                    textField.appendText("8");
                                }
                                else if(event.getText().equals("9"))
                                {
                                    textField.appendText("9");
                                }
                                else if(event.getText().equals("0"))
                                {
                                    textField.appendText("0");
                                }
                                // enter and delete operations 
                                // enter will theoretically hit the equal sign 
                                // delete will clear all the operation
                                else if(event.getCode().equals(KeyCode.ENTER)) 
                                {
                                    finalB.fire(); 
                                }
                                else if(event.getCode().equals(KeyCode.P)) // FIX ME 
                                                                           // CAPITAL P for now but it should be delete... not sure why it is not picking it up 
                                {
                                    textField.clear(); 
                                    valuesArray.clear(); 
                                }
                            }
                            );
            
            HBox hBox1 = new HBox(); 
			hBox1.getChildren().addAll(b1, b2, b3, b4, finalB); 	
			
			vBox.getChildren().addAll(textField, hBox1, 
			                hBoxNum1, hBoxNum2, hBoxNum3, hBoxNum4,          
			                outputLabel); 
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// launch 
	public static void main(String[] args) {
		launch(args);
	}
	
	//Git 
	// git init
	// git add . 
	// git commit -a -m "Test"
	// git push -u origin --all
}
