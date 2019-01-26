/**
 * @author ������ 
 * @date : 2017��7��10�� ����1:09:12
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GUIMainClass extends Application {
	private final Label titleChinese = new Label("家养动物遗传资源信息采集系统");
	private final Label titleEnglish = new Label("Information collection"
			+ " system for genetic resources of domestic animal （IGA）");
	private final Label[] copyright = new Label[3];
	private final String[] copyrightInfoChinese = {
			"作者：俄广鑫，王鑫祉.",
			"发表日期：2017年10月1日",
			"作者单位：西南大学动物科技学院，重庆北碚，中国"

	};
	private final String[] copyrightInfoEnglish = {
			"Author;Dr. Guang-Xin E, Xin-Zhi Wang",
			"Date of publication:October 1, 2017",
			"Administrative unit: College of Animal Science and Technology,"
			+ " Chongqing Key Laboratory of Forage & Herbivore, "
			+ "Chongqing Engineering Research Centre for Herbivores"
			+ " Resource Protection and Utilization, Southwest University,"
			+ " Chongqing, China,"

	};
	private final Label version = new Label("V1.0");
	private final Button btGoat = new Button("");
	private final Button btPig = new Button("");
	private final Button btFowl = new Button("");
	private final Button btOx = new Button("");
	private final Button btHorse = new Button("");
	private final Button btBee = new Button("");
//	private final Image signImage = new Image("src/img/sign.png");
	private final Image sheepImage = new Image("file:image/sheep.jpg");
	private final Image oxImage = new Image("file:image/ox.jpg");
	private final Image chickenImage = new Image("file:image/chicken.jpg");
	private final Image hourseImage = new Image("file:image/hourse.jpg");
	private final Image pigImage = new Image("file:image/pig.jpg");
	private final Image beeImage = new Image("file:image/bee.jpg");
	
	private final ImageView sheepView = new ImageView(sheepImage);
	private final ImageView oxView = new ImageView(oxImage);
	private final ImageView chickenView = new ImageView(chickenImage);
	private final ImageView horseView = new ImageView(hourseImage);
	private final ImageView pigView = new ImageView(pigImage);
	private final ImageView beeView = new ImageView(beeImage);
	
	private final Label sheepLabel = new Label("SHEEP/GOAT");
	private final Label oxLabel = new Label("CATTLE");
	private final Label hourseLabel = new Label("DONKEY/HORSE");
	private final Label pigLabel = new Label("PIG");
	private final Label fowlLabel = new Label("POULTRY");
	private final Label beeLabel = new Label("BEE");
			
	private Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		scene = new Scene(pane, 800, 600);
		
		titleChinese.setFont(new Font(30));
		titleEnglish.setFont(new Font(15));
		
//		version.setLayoutX(700);
//		version.setLayoutY(0);
//		pane.getChildren().add(version);
		
		VBox titleBox = new VBox(10);
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().addAll(titleChinese, titleEnglish);
		pane.setTop(titleBox);
		
		for (int i = 0; i < copyright.length ; i++) 
			copyright[i] = new Label(copyrightInfoChinese[i]);
		
		VBox copyrightBox = new VBox(5);
		copyrightBox.setAlignment(Pos.BOTTOM_CENTER);
		copyrightBox.getChildren().addAll(copyright);
		pane.setBottom(copyrightBox);
		
		GridPane btPane = new GridPane();
		btPane.setHgap(20);
		btPane.setVgap(20);
		btPane.setAlignment(Pos.CENTER);
				
		sheepView.setFitHeight(100);
		sheepView.setFitWidth(100);
		btGoat.setGraphic(sheepView);
		btGoat.setAlignment(Pos.BOTTOM_CENTER);
		
		oxView.setFitHeight(100);
		oxView.setFitWidth(100);
		btOx.setGraphic(oxView);
		
		horseView.setFitHeight(100);
		horseView.setFitWidth(100);
		btHorse.setGraphic(horseView);
		
		pigView.setFitHeight(100);
		pigView.setFitWidth(100);
		btPig.setGraphic(pigView);
		
		chickenView.setFitHeight(100);
		chickenView.setFitWidth(100);
		btFowl.setGraphic(chickenView);
		
		beeView.setFitHeight(100);
		beeView.setFitWidth(100);
		btBee.setGraphic(beeView);
		
		VBox goatBox = new VBox(5);
		goatBox.setAlignment(Pos.CENTER);
		goatBox.getChildren().addAll(btGoat, sheepLabel);
		
		VBox oxBox = new VBox(5);
		oxBox.setAlignment(Pos.CENTER);
		oxBox.getChildren().addAll(btOx, oxLabel);
		
		VBox hourseBox = new VBox(5);
		hourseBox.setAlignment(Pos.CENTER);
		hourseBox.getChildren().addAll(btHorse, hourseLabel);
		
		VBox pigBox = new VBox(5);
		pigBox.setAlignment(Pos.CENTER);
		pigBox.getChildren().addAll(btPig, pigLabel);
		
		VBox fowlBox = new VBox(5);
		fowlBox.setAlignment(Pos.CENTER);
		fowlBox.getChildren().addAll(btFowl, fowlLabel);
		
		VBox beeBox = new VBox(5);
		beeBox.setAlignment(Pos.CENTER);
		beeBox.getChildren().addAll(btBee, beeLabel);

		btPane.add(goatBox, 0, 0);
		btPane.add(oxBox, 1, 0);
		btPane.add(hourseBox, 2, 0);
		btPane.add(pigBox, 0, 1);
		btPane.add(fowlBox, 1, 1);
		btPane.add(beeBox, 2, 1);
		
		pane.setCenter(btPane);
		btGoat.setOnAction(e -> {
			Stage goatStage = new GoatStage(primaryStage);
			primaryStage.hide();
		});
		
		btOx.setOnAction(e -> {
			Stage cattleStage = new CattleStage(primaryStage);
			primaryStage.hide();
		});
		
		btPig.setOnAction(e -> {
			Stage pigStage = new PigStage(primaryStage);
			primaryStage.hide();
		});
		
		btHorse.setOnAction(e -> {
			Stage horseStage = new HorseStage(primaryStage);
			primaryStage.hide();
		});
		
		btFowl.setOnAction(e -> {
			Stage poultryStage = new PoultryStage(primaryStage);
			primaryStage.hide();
		});
		
		btBee.setOnAction(e -> {
			Stage beeStage = new BeeStage(primaryStage);
			primaryStage.hide();
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Register v1.0");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
