package application;
	

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
		
		

	    @FXML
	    private Label grossIncome;
	    @FXML
	    private Label MonthlyDebt;
	    @FXML
	    private Label prefTerm;
	    @FXML
	    private Label mortgageInterest;
	    @FXML
	    private Label downPayment;
	    
	    @FXML
	    private Label housingPayment;
	    
	    @FXML
	    private Label tv1;
	    @FXML
	    private Label tv2;
	    @FXML
	    private Label tv3;
	    @FXML
	    private Label tv4;
	    
	    @Override
		public void start(Stage primaryStage) {
			try {
				BorderPane root = new BorderPane();
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	    
	    public void calculate(){
	    	String t1 = grossIncome.getText().toString();
	    	String t2 = MonthlyDebt.getText().toString();
	    	String t3 = prefTerm.getText().toString();
	    	String t4 = mortgageInterest.getText().toString();
	    	String t5 = downPayment.getText().toString();
	    	
	    	double grossIncome = 0;
	    	double monthlyDebt = 0;
	    	double prefTerm = 0;
	    	double mortgageInterest = 0;
	    	double downPayment = 0;
	    	try{
	        	grossIncome = Double.parseDouble(t1);
	        	monthlyDebt = Double.parseDouble(t2);
	        	mortgageInterest = Double.parseDouble(t3);
	        	prefTerm = Double.parseDouble(t4);
	        	downPayment = Double.parseDouble(t5);
	        	
	    	}catch(Exception e){
	    		
	    	}
	    	//calc
	    	double housingPayment = 0;
	    	double totalMonthlyObligation = 0;
	    	double maxAllowed = 0;
	    	//double mortgageFinanced = 0;
	    	double monthlyRate = 0;
	    	double numberOfPayments = 0;
	    	double presentValue = 0;
	    	double x = 0;
	    	double b = 0;
	    	
	    	
	    	housingPayment = (grossIncome/12.0*0.18);
	    	totalMonthlyObligation = (grossIncome/12.0*0.36)- monthlyDebt;
	    	
	    	if(totalMonthlyObligation < housingPayment){
	    		maxAllowed = totalMonthlyObligation;
	    	}
	    	else {
	    		maxAllowed = housingPayment;
	    	}
	    	
	    	monthlyRate = (mortgageInterest/12.0);
	    	numberOfPayments = (prefTerm*12.0);
	    	
	    	x = (1.0 + monthlyRate);
	    	b = Math.pow(x, numberOfPayments);
	    	presentValue = maxAllowed*((b-1.0)/(monthlyRate*b));
	    	
	    	tv1.setText("Housing Payment (only) 18% = " + housingPayment);
	    	tv2.setText("Housing Payment+ Monthly Obligation = " + totalMonthlyObligation);
	    	tv3.setText("Maximum Payment Allowed = " + maxAllowed);
	    	tv4.setText("Amount of Mortgage Financed = " +  presentValue);
	    }
	

	
}
