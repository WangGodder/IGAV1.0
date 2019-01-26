/**
 * @author ������ 
 * @date : 2017��7��17�� ����2:58:16
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Language.GoatLanguage;
import Language.Language;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public abstract class StageModel extends Stage {
	protected String[] idCandidate;
	protected String[] countryCandidate ;
	protected final String[] provinceCandidate = {
			"������ʡ","������","����ʡ","������","�����","����ʡ","����ʡ","����ʡ",
			"�ӱ�ʡ","����ʡ","����ʡ","����ʡ","����ʡ","����ʡ","����ʡ","̨��ʡ",
			"���ɹ�������","���ɹ�������","���Ļ���������","�ຣʡ","ɽ��ʡ","ɽ��ʡ",
			"�Ĵ�ʡ","����������","�½�ά���������","����ʡ","�㽭ʡ","����ʡ"};
	protected String[] sexCandidate ;
	protected String[] languages;
	
	protected String[] status;
	
	protected final ComboBox<String> idComboBox = new ComboBox<>();
	protected final ComboBox<Integer> yearComboBox = new ComboBox<>();
	protected final ComboBox<Integer> monthComboBox = new ComboBox<>();
	protected final ComboBox<Integer> dayComboBox = new ComboBox<>();
	protected final ComboBox<String> sexComboBox = new ComboBox<>();
	protected final ComboBox<String> countryComboBox = new ComboBox<>();
	protected final ComboBox<String> provinceComboBox = new ComboBox<>();
	
	protected final ComboBox<String> languageComboBox = new ComboBox<>();
	
	protected final TextArea commentArea = new TextArea();
	
	protected final Button btCommentClear = new Button("���");
	protected final Button btCommentEnlarge = new Button("����");
	protected final Button btCommentShrink = new Button("��С");
	protected final Button btSearch = new Button("����");
	protected final Button btAdd = new Button("���");
	protected final Button btChange = new Button("�޸�");
	protected final Button btBack = new Button("������ҳ��");
	protected final Button btOutput = new Button("����ļ�");
	protected final Button btAddImage = new Button("���ͼƬ");
	protected final Button btShowImage = new Button();
	protected final Button btLeft = new Button("<");
	protected final Button btRight = new Button(">");
	protected final Button btOutputFiles = new Button("�������");
	
//	protected final TextField idField = new TextField();
	protected final TextField localityField = new TextField();
	protected final TextField latitudeField = new TextField();
	protected final TextField longitudeField = new TextField();
	protected final TextField speciesField = new TextField();
	protected final TextField ageField = new TextField();
	
	protected Label[] dateLabels = new Label[4];
	protected Label speicesLabel = new Label("Ʒ��");
	protected Label[] localityLabels = new Label[4];
	protected Label sexLabel = new Label("�Ա�");
	protected Label[] ageLabels = new Label[2];
	protected Label commentLabel = new Label("��ע");

	protected Image image = new Image("file:image/initialization.png", true);
	protected ImageView imageView = new ImageView(image);
	
	protected Label statusLabel = new Label("ͨ��ID���в��Һ��޸�");
	
	protected FileChooser imageChooser = new FileChooser();
	
	protected final Desktop desktop = Desktop.getDesktop();
	
	protected DirectoryChooser directoryChooser = new DirectoryChooser();

	protected BorderPane basePane;
	protected GridPane dataPane;
	protected BorderPane viewPane;
	
	protected Stage mainStage;
	protected Stage stage = new Stage();
	
	protected String[] imageSrc ;
	
	protected int times = 1;
	protected int imageNo = 0;
	
	public StageModel(Stage mainStage) {
		this.mainStage = mainStage;
		basePane = new BorderPane();
		dataPane = new GridPane();
		basePane.setPadding(new Insets(5, 0, 40, 0));
		imageView.setFitWidth(300);
		imageView.setFitHeight(350);
		btShowImage.setGraphic(imageView);
		viewPane = new BorderPane();
		viewPane.setCenter(btShowImage);
		viewPane.setBottom(btAddImage);
		viewPane.setLeft(btLeft);
		viewPane.setRight(btRight);
		viewPane.setAlignment(btAddImage, Pos.BOTTOM_CENTER);
		viewPane.setAlignment(btLeft, Pos.CENTER_LEFT);
		viewPane.setAlignment(btRight, Pos.CENTER_RIGHT);
		viewPane.setMaxSize(200, 300);
		GridPane infoPane = new GridPane();
		infoPane.add(dataPane, 0, 0);
		infoPane.add(viewPane, 1, 0);
		basePane.setTop(infoPane);
		Scene scene = new Scene(basePane, 1150, 700);
		dataPane.setPadding(new Insets(20, 5, 5, 20));
		dataPane.setVgap(20);
		dataPane.setHgap(10);
		
		VBox commentButtonBox = new VBox(5);
		commentButtonBox.getChildren().add(btCommentClear);
		commentButtonBox.getChildren().add(btCommentEnlarge);
		commentButtonBox.getChildren().add(btCommentShrink);
		
		HBox commentBox = new HBox(10);
		commentBox.getChildren().add(commentLabel);
		commentBox.getChildren().add(commentArea);
		commentBox.getChildren().add(commentButtonBox);
		commentBox.setAlignment(Pos.TOP_CENTER);
		
		HBox btBox = new HBox(20);
		btBox.getChildren().add(btSearch);
		btBox.getChildren().add(btChange);
		btBox.getChildren().add(btAdd);
		btBox.getChildren().add(btOutput);
		btBox.setAlignment(Pos.CENTER);
		
		VBox opBox = new VBox(10);
		opBox.getChildren().add(btBox);
		opBox.getChildren().add(statusLabel);
		opBox.setAlignment(Pos.CENTER);
		
		VBox backButtonsBox = new VBox(10);
		backButtonsBox.getChildren().add(btBack);
		backButtonsBox.getChildren().add(languageComboBox);
		backButtonsBox.getChildren().add(btOutputFiles);
		backButtonsBox.setAlignment(Pos.CENTER);
		
		basePane.setCenter(commentBox);
		basePane.setRight(backButtonsBox);
		basePane.setBottom(opBox);
		
		
		stage.setScene(scene);
		stage.show();
	}
	
	protected void setLanguage(String languageName) {
		Language language = new Language();
		try {
			language = Language.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		
		sexCandidate = language.sexCandidate;
		
		countryCandidate = language.countryCandidate;
		
		btCommentClear.setText(language.buttonNames[0]);
		btCommentEnlarge.setText(language.buttonNames[1]);
		btCommentShrink.setText(language.buttonNames[2]);
		btSearch.setText(language.buttonNames[3]);
		btAdd.setText(language.buttonNames[4]);
		btChange.setText(language.buttonNames[5]);
		btOutput.setText(language.buttonNames[6]);
		btAddImage.setText(language.buttonNames[7]);
		btOutputFiles.setText(language.buttonNames[8]);
		btBack.setText(language.buttonNames[9]);
		
		setTextForLabel(dateLabels, language.dateLabels);
		speicesLabel.setText(language.speicesLabel);
		sexLabel.setText(language.sexLabel);
		setTextForLabel(ageLabels, language.ageLabels);
		setTextForLabel(localityLabels, language.localityLabels);
		commentLabel.setText(language.commentLabel);
		
		status = language.statusLabels;
		
		imageChooser.setTitle(language.imageChooser);

		initComboBoxs();
	}
	
	protected void initNode() {
		
//		idField.setMaxWidth(100);
		speciesField.setPrefColumnCount(8);
		latitudeField.setMaxWidth(60);
		longitudeField.setMaxWidth(60);
		ageField.setMaxWidth(80);
		initComboBoxs();
		initializeComboBox(provinceComboBox, provinceCandidate, false);
		provinceComboBox.hide();
		provinceComboBox.setVisible(false);	
		
		commentArea.setMaxHeight(100);
				
		idComboBox.setMaxWidth(100);
		
		imageChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All images", "*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png")
				);
		
		directoryChooser.setTitle("Choose output path");
		
		btLeft.setDisable(true);
		btRight.setDisable(true);
	}
	
	protected void initComboBoxs() {
		List<Integer> years = new ArrayList<>();
		List<Integer> months = new ArrayList<>();
		List<Integer> days = new ArrayList<>();
		for (int i = 2050; i >= 2006; i--) {
			years.add(i);
		}
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}
		for (int i = 1; i <= 31; i++) {
			days.add(i);
		}
		initializeComboBox(yearComboBox, years, false);
		initializeComboBox(monthComboBox, months, false);
		initializeComboBox(dayComboBox, days, false);
		initializeComboBox(countryComboBox, countryCandidate, false);
		initializeComboBox(sexComboBox, sexCandidate, false);
		
		statusLabel.setText(status[0]);
	}
	
	protected void initAction() {
		countryComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (countryComboBox.getValue() == countryCandidate[87]) {
					provinceComboBox.setVisible(true);
					provinceComboBox.show();
				} else {
					provinceComboBox.setVisible(false);
				}
			}
		});
		
		languageComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String language = languageComboBox.getValue();
				if (language != "Chinese") {
					stage.setWidth(1300.0);
					stage.centerOnScreen();
				} else {
					stage.setWidth(1150.0);
					stage.sizeToScene();
					stage.centerOnScreen();
				}
				StageModel.this.setLanguage(language);
			}
		});
		
		btCommentClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				commentArea.clear();
			}
		});

		btCommentEnlarge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				double preHeight = commentArea.getHeight();
				double preStageHeight = stage.getHeight();
				if (preHeight == commentArea.getMaxHeight()) {
					commentArea.setMaxHeight(preHeight + 50);
					stage.setHeight(preStageHeight + 50);
				}
			}
		});

		btCommentShrink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				double preHeight = commentArea.getHeight();
				double preStageHeight = stage.getHeight();
				if (preHeight == commentArea.getMaxHeight() && preHeight >= 100) {
					commentArea.setMaxHeight(preHeight - 50);
					stage.setHeight(preStageHeight - 50);
				}
			}
		});

		btBack.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[7]);
			if (answer == JOptionPane.YES_OPTION) {
				this.mainStage.show();
				stage.hide();
			}
		});
		
		btAddImage.setOnAction(e -> {
			List<File> files = imageChooser.showOpenMultipleDialog(stage);
			System.out.println(files.size());
			imageSrc = new String[files.size()];
			copyImage(files);
			showImage(0);
			btLeft.setDisable(true);
			if (imageSrc.length > 1)
				btRight.setDisable(false);
			else
				btRight.setDisable(true);
		});
		
		btShowImage.setOnAction(e -> {
			System.out.println(imageSrc[imageNo]);
			File file = new File(imageSrc[imageNo].substring(5));
			System.out.println(file.getPath());
			try {
				desktop.open(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btLeft.setOnAction(e -> {
			if (imageNo <= 1) {
				btLeft.setDisable(true);
			} 
			showImage(--imageNo);
		
			btRight.setDisable(false);
			
		});
		
		btRight.setOnAction(e -> {
			showImage(++imageNo);
			btLeft.setDisable(false);
			if (imageNo >= imageSrc.length - 1) {
				btRight.setDisable(true);
			}
		});
		
	}
	
	protected void setTextForLabel(Label[] labels, String[] str) {
		for (int i = 0; i < labels.length; i++)  {
			if (labels[i] == null) {
				labels[i] = new Label(str[i]);
			}
			labels[i].setText(str[i]);
		}
	}
	
	protected void initializeComboBox(ComboBox comboBox, Object[] candidate, boolean isEditable) {
		comboBox.getItems().clear();
		if (candidate == null) {
			return;
		}
		for (Object object : candidate) {
			if (!comboBox.getItems().contains(object)) {
				comboBox.getItems().add(object);
			}
		}
		if (isEditable) {
			comboBox.setEditable(true);
		}
		else {
			comboBox.setValue(candidate[0]);
		}
	}
	
	private void initializeComboBox(ComboBox comboBox, List<Integer> candidate, boolean isEditable) {
		comboBox.getItems().addAll(candidate);
		if (isEditable) {
			comboBox.setEditable(true);
		}
		else {
			comboBox.setValue(candidate.get(0));
		}
	}
	
	protected void copyImage(List<File> files) {
		for (int i = 0; i < files.size(); i++) {
			String fileName = files.get(i).getName();
			String srcFormat = fileName.substring( fileName.length() - 4);
			System.out.println(srcFormat);
			File targetFile = new File("goat/img/" + idComboBox.getValue().trim() + "-" + i + srcFormat);
			try {
				InputStream in = new FileInputStream(files.get(i));
				OutputStream out = new FileOutputStream(targetFile);
				byte[] bytes = new byte[1024];
				int len = -1;
				while ((len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
				}
				in.close();
				out.close();
				imageSrc[i] = "file:goat/img/" + idComboBox.getValue().trim() + "-" + i + srcFormat;
				System.out.println(imageSrc[i]);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, status[12]);
				ex.printStackTrace();
			}
		}
	}
	
	protected void showImage(int number) {
		if (imageSrc == null){
			image = new Image("file:image/initialization.png", true);
		} else {
			image = new Image(imageSrc[number], true);
		}
		imageView.setImage(image);
		btShowImage.setGraphic(imageView);
		viewPane.setCenter(btShowImage);
	}
	
	protected void setFieldWidth(double width, TextField ...fields) {
		for (TextField field : fields) {
			field.setMaxWidth(width);
		}
	}
	
	protected double getDouble(TextField field) {
		return Double.parseDouble(field.getText().trim());
	}

	protected void getIDCandidate(String src) {
		File idFile = new File(src);
		File[] idArray = idFile.listFiles();
		idCandidate = new String[idArray.length];
		for (int i = 0; i < idArray.length; i++) {
			idCandidate[i] = idArray[i].getName().substring(0, idArray[i].getName().length() - 8);
		}
		initializeComboBox(idComboBox, idCandidate, true);
	}
	
	protected File[] getAnotherID(String src) {
		File idFile = new File(src);
		File[] fileArray = idFile.listFiles();
		return fileArray;
	}
	
	protected void getLanguageCandidate(String src) {
		File file = new File(src);
		File[] array = file.listFiles();
		this.languages = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			languages[i] = array[i].getName().substring(0, array[i].getName().length() - 4);
		}
		initializeComboBox(languageComboBox, languages, false);
	}
	
	protected HBox getUnitBox(TextField field, String unit) {
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(field, new Label(unit));
		return hBox;
	}
	
	protected class OutputStage extends Stage {
		protected CheckBox[] fileCheckBoxs;
		protected File[] files;
		protected Stage stage = new Stage();
		protected final Button btOutput = new Button("output");
		protected final Button btCheckAll = new Button("check all");
		protected final Button btCancel = new Button("cancel");
		
		protected OutputStage(File[] files) {
			this.files = files;
			fileCheckBoxs = new CheckBox[files.length];
			for (int i = 0; i < files.length; i++) {
				fileCheckBoxs[i] = new CheckBox(files[i].getName().
						substring(0, files[i].getName().length() - 8));
			}
			
			BorderPane pane = new BorderPane();
			ScrollPane filePane = new ScrollPane();
			VBox fileBox = new VBox(5);
			fileBox.getChildren().add(new Label("ID"));
			fileBox.getChildren().addAll(fileCheckBoxs);
			filePane.setContent(fileBox);
			filePane.setMaxSize(150, 300);
			pane.setCenter(filePane);
			HBox btBox = new HBox(10);
			btBox.getChildren().addAll(btOutput, btCheckAll, btCancel);
			pane.setBottom(btBox);
			pane.setAlignment(btBox, Pos.BOTTOM_CENTER);
			
			btCheckAll.setOnAction(e -> {
				for (CheckBox checkBox : fileCheckBoxs) {
					checkBox.setSelected(true);
				}
			});
			
			stage.setTitle("Choose the id to output");
			stage.setScene(new Scene(pane, 200, 400));
			stage.show();
		}
	}
}
