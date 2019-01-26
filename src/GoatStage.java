/**
 * @author ������ 
 * @date : 2017��7��10�� ����2:29:14
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

import Animal.Goat;
import Language.GoatLanguage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GoatStage extends StageModel {
	private String[] colorCandidate;
	private String[] skinColorCandidate ;
	private String[] cavelCandidate;
	private String[] cavelShapeCandidate;
	private String[] noseCandidate;
	private String[] earCandidate;
	private String[] neckCandidate ;
	private String[] limbsCandidate;
	private String[] headTypeCandidate;
	private String[] foreheadCandidate;
	private String[] tailTypeCandidate;
	private final String[] farrowingNumberCandidate = {
			"1", "2", "3", "4", "5"};
	
	private final TextField bodyLengthField = new TextField();
	private final TextField bodyHeightField = new TextField();
	private final TextField bodyDipLengthField = new TextField();
	private final TextField bustField = new TextField();
	private final TextField bustWidthField = new TextField();
	private final TextField bustDepthField = new TextField();
	private final TextField weightField = new TextField();
	private final TextField headLengthField = new TextField();
	private final TextField headWidthField = new TextField();
	private final TextField earLengthField = new TextField();
	private final TextField earWidthField = new TextField();
	private final TextField tailLengthField = new TextField();
	private final TextField tailWidthField = new TextField();
	
	private final ComboBox<String> cavelComboBox = new ComboBox<>();
	private final ComboBox<String> cavelShapeComboBox = new ComboBox<>();
	private final ComboBox<String> colorComboBox = new ComboBox<>();
	private final ComboBox<String> skinColorComboBox = new ComboBox<>();
	private final ComboBox<String> noseComboBox = new ComboBox<>();
	private final ComboBox<String> earComboBox = new ComboBox<>();
	private final ComboBox<String> limbsComboBox = new ComboBox<>();
	private final ComboBox<String> neckComboBox = new ComboBox<>();
	private final ComboBox<String> headTypeComboBox = new ComboBox<>();
	private final ComboBox<String> foreheadTypeComboBox = new ComboBox<>();
	private final ComboBox<String> tailTypeComboBox = new ComboBox<>();
	private final ComboBox<String> farrowingNumberComboBox = new ComboBox<>();
		
	private final CheckBox[] neckCheckBoxs = new CheckBox[3];
	

	private Label[] headLabels = new Label[3];
	private Label foreheadLabel = new Label("��");
	private Label cavelLabel = new Label("��");
	private Label[] earLabels = new Label[3];
//	private Label earLengthLabel = new Label("����");
//	private Label earWidthLabel = new Label("����");
	private Label noseLabel = new Label("�ǲ�");
	private Label neckLabel = new Label("����");
	private Label bodyLengthLabel = new Label("�峤");
	private Label bodyHeightLabel = new Label("���");
	private Label bodyDipLengthLabel = new Label("б���");
	private Label furtherColorLabel = new Label("ëɫ");
	private Label skinColorLabel = new Label("��ɫ");
	private Label limbsLabel = new Label("��֫");
	private Label bustLabel = new Label("��Χ");
	private Label bustWidthLabel = new Label("�ؿ�");
	private Label bustDepthLabel = new Label("����");
	private Label[] tailLabels = new Label[3];
//	private Label tailLLengthLabel = new Label("β��");
//	private Label tailWidthLabel = new Label("β��");
	private Label weightLabel = new Label("����");
	private Label farrowingLabel = new Label("����");
	
//	private File file = new File("data.dat");
//	private DataInputStream getData;
//	private DataOutputStream writeData;
	
	public GoatStage(Stage mainStage) {
		super(mainStage);
		stage.setTitle("Goat Register");
		
		setLanguage("Chinese");
		initializeNode();
		initializeAction();
		
		HBox dateBox = new HBox(5);
		dateBox.getChildren().add(yearComboBox);
		dateBox.getChildren().add(dateLabels[1]);
		dateBox.getChildren().add(monthComboBox);
		dateBox.getChildren().add(dateLabels[2]);
		dateBox.getChildren().add(dayComboBox);
		dateBox.getChildren().add(dateLabels[3]);
		
		GridPane firstPane = new GridPane();
		firstPane.setHgap(10);
		firstPane.add(new Label("ID"), 0, 0);
		firstPane.add(idComboBox, 1, 0);
		firstPane.add(dateLabels[0], 2, 0);
		firstPane.add(dateBox, 3, 0);
		firstPane.add(speicesLabel, 4, 0);
		firstPane.add(speciesField, 5, 0);
		
		HBox localityBox = new HBox(5);
		localityBox.getChildren().add(countryComboBox);
		localityBox.getChildren().add(provinceComboBox);
		localityBox.getChildren().add(localityLabels[1]);
		localityBox.getChildren().add(localityField);
		localityBox.getChildren().add(localityLabels[2]);
		localityBox.getChildren().add(latitudeField);
		localityBox.getChildren().add(localityLabels[3]);
		localityBox.getChildren().add(longitudeField);

		
		GridPane localityPane = new GridPane();
		localityPane.add(localityLabels[0], 0, 0); // �ɼ�����
		localityPane.add(localityBox, 1, 0); 
		
		HBox ageBox = new HBox(5);
		ageBox.getChildren().add(ageField);
		ageBox.getChildren().add(ageLabels[1]);
		
		GridPane thirdPane = new GridPane();
		thirdPane.setHgap(10);
		thirdPane.add(sexLabel, 0, 0);
		thirdPane.add(sexComboBox, 1, 0);
		thirdPane.add(ageLabels[0], 2, 0);
		thirdPane.add(ageBox, 3, 0);
		thirdPane.add(farrowingLabel, 4, 0);
		thirdPane.add(farrowingNumberComboBox, 5, 0);
		thirdPane.add(cavelLabel, 6, 0);
		thirdPane.add(cavelComboBox, 7, 0);
		thirdPane.add(cavelShapeComboBox, 8, 0);
		
		HBox neckCheckBoxsBox = new HBox(5);
		neckCheckBoxsBox.getChildren().addAll(neckCheckBoxs);
		
		GridPane fourthPane = new GridPane();
		fourthPane.setHgap(10);
		fourthPane.add(neckLabel, 0, 0);
		fourthPane.add(neckComboBox, 1, 0);
		fourthPane.add(neckCheckBoxsBox, 2, 0);
		
		HBox headBox = new HBox(5);
		headBox.getChildren().add(headLabels[1]);
		headBox.getChildren().add(headLengthField);
		headBox.getChildren().add(new Label("cm"));
		headBox.getChildren().add(headLabels[2]);
		headBox.getChildren().add(headWidthField);
		headBox.getChildren().add(new Label("cm"));
		
		GridPane fifthPane = new GridPane();
		fifthPane.setHgap(10);
		fifthPane.add(headLabels[0], 0, 0);
		fifthPane.add(headTypeComboBox, 1, 0);
		fifthPane.add(headBox, 2, 0);
		fifthPane.add(foreheadLabel, 3, 0);
		fifthPane.add(foreheadTypeComboBox, 4, 0);
		
		HBox earBox = new HBox(5);
		earBox.getChildren().add(earComboBox);
		earBox.getChildren().add(earLabels[1]);
		earBox.getChildren().add(earLengthField);
		earBox.getChildren().add(new Label("cm"));
		earBox.getChildren().add(earLabels[2]);
		earBox.getChildren().add(earWidthField);
		earBox.getChildren().add(new Label("cm"));
		
		GridPane sixthPane = new GridPane();
		sixthPane.setHgap(10);
		sixthPane.add(earLabels[0], 0, 0);
		sixthPane.add(earBox, 1, 0);
		sixthPane.add(noseLabel, 2, 0);
		sixthPane.add(noseComboBox, 3, 0);
		sixthPane.add(limbsLabel, 4, 0);
		sixthPane.add(limbsComboBox, 5, 0);
		
		HBox bodyLengthBox = new HBox(5);
		bodyLengthBox.getChildren().add(bodyLengthField);
		bodyLengthBox.getChildren().add(new Label("cm"));
		
		HBox bodyHeightBox = new HBox(5);
		bodyHeightBox.getChildren().add(bodyHeightField);
		bodyHeightBox.getChildren().add(new Label("cm"));
		
		HBox bodyDipLengthBox = new HBox(5);
		bodyDipLengthBox.getChildren().add(bodyDipLengthField);
		bodyDipLengthBox.getChildren().add(new Label("cm"));
		
		HBox weightBox = new HBox(5);
		weightBox.getChildren().add(weightField);
		weightBox.getChildren().add(new Label("kg"));
		
		GridPane seventhPane = new GridPane();
		seventhPane.setHgap(10);
		seventhPane.add(bodyLengthLabel, 0, 0);
		seventhPane.add(bodyLengthBox, 1, 0);
		seventhPane.add(bodyHeightLabel, 2, 0);
		seventhPane.add(bodyHeightBox, 3, 0);
		seventhPane.add(bodyDipLengthLabel, 4, 0);
		seventhPane.add(bodyDipLengthBox, 5, 0);
		seventhPane.add(weightLabel, 6, 0);
		seventhPane.add(weightBox, 7, 0);
		
		HBox bustBox = new HBox(5);
		bustBox.getChildren().add(bustField);
		bustBox.getChildren().add(new Label("cm"));
		
		HBox bustWidthBox = new HBox(5);
		bustWidthBox.getChildren().add(bustWidthField);
		bustWidthBox.getChildren().add(new Label("cm"));
		
		HBox bustDepthBox = new HBox(5);
		bustDepthBox.getChildren().add(bustDepthField);
		bustDepthBox.getChildren().add(new Label("cm"));
		
		GridPane eighthPane = new GridPane();
		eighthPane.setHgap(10);
		eighthPane.add(bustLabel, 0, 0);
		eighthPane.add(bustBox, 1, 0);
		eighthPane.add(bustWidthLabel, 2, 0);
		eighthPane.add(bustWidthBox, 3, 0);
		eighthPane.add(bustDepthLabel, 4, 0);
		eighthPane.add(bustDepthBox, 5, 0);
		
		GridPane ninthPane = new GridPane();
		ninthPane.setHgap(10);
		ninthPane.add(furtherColorLabel, 0, 0);
		ninthPane.add(colorComboBox, 1, 0);
		ninthPane.add(skinColorLabel, 2, 0);
		ninthPane.add(skinColorComboBox, 3, 0);
		
		HBox tailBox = new HBox(5);
		tailBox.getChildren().add(tailTypeComboBox);
		tailBox.getChildren().add(tailLabels[1]);
		tailBox.getChildren().add(tailLengthField);
		tailBox.getChildren().add(new Label("cm"));
		tailBox.getChildren().add(tailLabels[2]);
		tailBox.getChildren().add(tailWidthField);
		tailBox.getChildren().add(new Label("cm"));
		
		GridPane tenthPane = new GridPane();
		tenthPane.setHgap(10);
		tenthPane.add(tailLabels[0], 0, 0);
		tenthPane.add(tailBox, 1, 0);
		
		dataPane.add(firstPane, 0, 0);
		dataPane.add(localityPane, 0, 1);
		dataPane.add(thirdPane, 0, 2);
		dataPane.add(fifthPane, 0, 3);
		dataPane.add(sixthPane, 0, 4);
		dataPane.add(fourthPane, 0, 5);
		dataPane.add(seventhPane, 0, 6);
		dataPane.add(eighthPane, 0, 7);
		dataPane.add(ninthPane, 0, 8);
		dataPane.add(tenthPane, 0, 9);
		
//		dataPane.add(new Label("ID"), 0, 0);
//		dataPane.add(idField, 1, 0);
//		dataPane.add(new Label("Ʒ��"), 2, 0);
//		dataPane.add(speciesField, 3, 0);
//		dataPane.add(new Label("����"), 4, 0);
//		dataPane.add(dateBox, 5, 0);
//		dataPane.add(new Label("�ռ��ص�"), 6, 0);
//		dataPane.add(localityField, 7, 0);
//		
//		dataPane.add(new Label("sex"), 0, 1);
//		dataPane.add(sexComboBox, 1, 1);
//		dataPane.add(new Label("age"), 2, 1);
//		dataPane.add(ageAndBodyLengthBox, 3, 1);
//		dataPane.add(new Label("���"), 4, 1);
//		dataPane.add(bodyHeightAndBustBox, 5, 1);
//		dataPane.add(new Label("����"), 6, 1);
//		dataPane.add(weightBox, 7, 1);
//		dataPane.add(new Label("��"), 0, 2);
//		dataPane.add(cavelComboBox, 1, 2);
//		dataPane.add(new Label("ͷ��"), 2, 2);
//		dataPane.add(headBox, 3, 2);
//		dataPane.add(new Label("����"), 4, 2);
//		dataPane.add(earBox, 5, 2);
//		dataPane.add(new Label("�ǲ�"), 6, 2);
//		dataPane.add(noseComboBox, 7, 2);
//		dataPane.add(new Label("���μ���С"), 0, 3);
//		dataPane.add(cavelShapeComboBox, 1, 3);
//		dataPane.add(new Label("����"), 2, 3);
//		dataPane.add(neckBox, 3, 3);
//		dataPane.add(new Label("��ë��ɫ"), 4, 3);
//		dataPane.add(colorBox, 5, 3);
//		dataPane.add(new Label("��֫"), 6, 3);
//		dataPane.add(limbsComboBox, 7, 3);

	}
	
	@Override
	protected void setLanguage(String languageName) {
		GoatLanguage language = new GoatLanguage();
		try {
			language = GoatLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
		
		colorCandidate = language.colorCandidate;
		skinColorCandidate = language.skinColorCandidate;
		cavelCandidate = language.cavelCandidate;
		cavelShapeCandidate = language.cavelShapeCandidate;
		noseCandidate = language.noseCandidate;
		earCandidate = language.earCandidate;
		noseCandidate = language.noseCandidate;
		neckCandidate = language.neckCandidate;
		limbsCandidate = language.limbsCandidate;
		headTypeCandidate = language.headTypeCandidate;
		foreheadCandidate = language.foreheadCandidate;
		tailTypeCandidate = language.tailTypeCandidate;
		
		setTextForLabel(headLabels, language.headLabels);
		foreheadLabel.setText(language.foreheadLabel);
		cavelLabel.setText(language.cavelLabel);
		setTextForLabel(earLabels, language.earLabels);
		noseLabel.setText(language.noseLabel);
		neckLabel.setText(language.neckLabel);
		bodyLengthLabel.setText(language.bodyLengthLabel);
		bodyHeightLabel.setText(language.bodyHeightLabel);
		bodyDipLengthLabel.setText(language.bodyDipLengthedLabel);
		furtherColorLabel.setText(language.furtherColorLabel);
		skinColorLabel.setText(language.skinColorLabel);
		limbsLabel.setText(language.limbsLabel);
		bustLabel.setText(language.bustLabel);
		bustWidthLabel.setText(language.bustWidthLabel);
		bustDepthLabel.setText(language.bustDepthLabel);
		setTextForLabel(tailLabels, language.tailLabels);
		weightLabel.setText(language.weightLabel);
		farrowingLabel.setText(language.farrowLabel);
		
		for (int i = 0; i < neckCheckBoxs.length; i++) {
			if (neckCheckBoxs[i] != null) {
				neckCheckBoxs[i].setText(language.neckCheckBox[i]);
			} else {
				neckCheckBoxs[i] = new CheckBox(language.neckCheckBox[i]);
			}
		}
		
		initializeComboBoxs();

	}
	
	private void initializeNode() {
		initNode();
		
		bodyLengthField.setMaxWidth(80);
		bodyHeightField.setMaxWidth(80);
		bodyDipLengthField.setMaxWidth(80);
		bustField.setMaxWidth(80);
		bustWidthField.setMaxWidth(80);
		bustDepthField.setMaxWidth(80);
		weightField.setMaxWidth(80);
		headLengthField.setMaxWidth(80);
		headWidthField.setMaxWidth(80);
		earLengthField.setMaxWidth(60);
		earWidthField.setMaxWidth(60);
		tailLengthField.setMaxWidth(80);
		tailWidthField.setMaxWidth(80);
//		yearComboBox.getItems().addAll(years);
//		monthComboBox.getItems().addAll(months);
//		dayComboBox.getItems().addAll(days);
	
		initializeComboBoxs();
		
		getIDCandidate("goat/data");

		getLanguageCandidate("language/goat");
	}
	
	private void initializeComboBoxs() {
		initializeComboBox(cavelComboBox, cavelCandidate, false);
		initializeComboBox(cavelShapeComboBox, cavelShapeCandidate, false);
		initializeComboBox(earComboBox, earCandidate, false);
		initializeComboBox(limbsComboBox, limbsCandidate, false);
		initializeComboBox(noseComboBox, noseCandidate, false);
		initializeComboBox(neckComboBox, neckCandidate, false);

		initializeComboBox(headTypeComboBox, headTypeCandidate, false);
		initializeComboBox(foreheadTypeComboBox, foreheadCandidate, false);
		initializeComboBox(tailTypeComboBox, tailTypeCandidate, false);
		initializeComboBox(farrowingNumberComboBox, farrowingNumberCandidate, true);
		farrowingNumberComboBox.setValue("0");
		farrowingNumberComboBox.setMaxWidth(60);
		initializeComboBox(colorComboBox, colorCandidate, true);
		colorComboBox.setMaxWidth(100);
		initializeComboBox(skinColorComboBox, skinColorCandidate, true);
		skinColorComboBox.setMaxWidth(100);
	}
	
	private void initializeAction() {
		initAction();
		
		cavelComboBox.setOnAction(e -> {
			if (cavelComboBox.getValue() == cavelCandidate[1]) {
				cavelShapeComboBox.setVisible(false);
			}
			else {
				cavelShapeComboBox.setVisible(true);
				cavelShapeComboBox.show();
			}
		});
		
		
		btSearch.setOnAction(e -> {
			try {
				int id = -1;
				try {
					id = Integer.parseInt(idComboBox.getValue().trim());
					
				} catch (NumberFormatException ex) {
					statusLabel.setText(status[1]);
					
				}
				Goat goat = Goat.getData(id);
				showData(goat);
				
				JOptionPane.showMessageDialog(null, goat.getID() + status[2]);
				statusLabel.setText(goat.getID() + status[2]);
			} catch (IOException ex) {
				statusLabel.setText(idComboBox.getValue() + status[3]);
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, idComboBox.getValue() + status[3]);
			} catch (ClassNotFoundException ex) {
				statusLabel.setText(idComboBox.getValue() + status[3]);
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, idComboBox.getValue() + status[3]);
			}
		});
		
		btAdd.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[8] + idComboBox.getValue() + "?");
			try {
				Goat goat = getGoat();
				Goat.writeData(goat);
				JOptionPane.showMessageDialog(null, goat.getID() + status[4]);
				statusLabel.setText(goat.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("goat/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Goat goat = getGoat();
					Goat.writeData(goat);
					JOptionPane.showMessageDialog(null, goat.getID() + status[6]);
					statusLabel.setText(goat.getID() + status[6]);
				} catch (IOException ex) {
					statusLabel.setText(ex.toString());
				}
			} 
		});
		
		btOutput.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[10]);
			if (answer == JOptionPane.YES_OPTION) {
				File file = directoryChooser.showDialog(stage);
				getLongitudinalText(file.getPath());
				
			}
			if (answer == JOptionPane.NO_OPTION) {
				File file = directoryChooser.showDialog(stage);
				getLateralText(file.getPath());
			}
		});
		
		btOutputFiles.setOnAction(e -> {
			File idFile = new File("goat/data");
			File[] files = idFile.listFiles();
			Stage stage = new GoatOutputStage(files);
		});
		
	}
	
	private Goat getGoat() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		Goat goat = new Goat(id);
		
		goat.year = (int)yearComboBox.getValue();
		goat.month = (int)monthComboBox.getValue();
		goat.day = (int)dayComboBox.getValue();
		goat.country = countryComboBox.getValue();
		if (goat.country == countryCandidate[87])
			goat.province = provinceComboBox.getValue();
		goat.locality = localityField.getText();
		goat.latitude = (double)Double.parseDouble(latitudeField.getText().trim());
		goat.longitude = (double)Double.parseDouble(longitudeField.getText().trim());
		goat.species = speciesField.getText();
		
		goat.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		goat.age = (double)Double.parseDouble(ageField.getText().trim());
		goat.farrowingNumber = (int)Integer.parseInt(farrowingNumberComboBox.getValue().trim());
		goat.isCavel = (cavelComboBox.getValue() == cavelCandidate[0])? true : false;
		if (goat.isCavel) {
			goat.cavelCharacter = cavelShapeComboBox.getValue();
		} else {
			goat.cavelCharacter = "";
		}
		
		goat.headType = headTypeComboBox.getValue();
		goat.headLength = (double)Double.parseDouble(headLengthField.getText().trim());
		goat.headWidth = (double)Double.parseDouble(headWidthField.getText().trim());
		goat.foreheadType = foreheadTypeComboBox.getValue();
		goat.earLength = (double)Double.parseDouble(earLengthField.getText().trim());
		goat.earWidth = (double)Double.parseDouble(earWidthField.getText().trim());
		goat.earCharacter = earComboBox.getValue();
		goat.noseCharacter = noseComboBox.getValue();
		goat.limbsCharacter = limbsComboBox.getValue();

		goat.neckCharacter = noseComboBox.getValue();
		goat.isMeat = (neckCheckBoxs[0].isSelected()) ? true : false;
		goat.isWrinkle = (neckCheckBoxs[1].isSelected())? true : false;
		goat.isBeard = (neckCheckBoxs[2].isSelected())? true : false;
		
		goat.bodyLength = (double)Double.parseDouble(bodyLengthField.getText().trim());
		goat.bodyHeight = (double)Double.parseDouble(bodyHeightField.getText().trim());
		goat.bodyDipLength = (double)Double.parseDouble(bodyDipLengthField.getText().trim());
		goat.weight = (double)Double.parseDouble(weightField.getText().trim());

		goat.bust = (double)Double.parseDouble(bustField.getText().trim());
		goat.bustWidth = (double)Double.parseDouble(bustWidthField.getText().trim());
		goat.bustDepth = (double)Double.parseDouble(bustDepthField.getText().trim());
		
		goat.color = colorComboBox.getValue();
		goat.skinColor = skinColorComboBox.getValue();
		
		goat.tailLength = (double)Double.parseDouble(tailLengthField.getText().trim());
		goat.tailWidth = (double)Double.parseDouble(tailWidthField.getText().trim());
		goat.tailType = tailTypeComboBox.getValue();
		
		goat.comment = commentArea.getText();
		
		goat.setImageSrc(imageSrc);
		
		return goat;
	}
	
	private void showData(Goat goat) {
		yearComboBox.setValue(goat.year);
		monthComboBox.setValue(goat.month);
		dayComboBox.setValue(goat.day);
		countryComboBox.setValue(goat.country);
		provinceComboBox.setValue(goat.province);
		localityField.setText(goat.locality);
		latitudeField.setText(goat.latitude + "");
		longitudeField.setText(goat.longitude + "");
		speciesField.setText(goat.species);
		sexComboBox.setValue((goat.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(goat.getAge() + "");
		farrowingNumberComboBox.setValue(goat.farrowingNumber + "");
		cavelComboBox.setValue((goat.isCavel)? cavelCandidate[0] : cavelCandidate[1]);
		cavelShapeComboBox.setValue(goat.cavelCharacter);

		headTypeComboBox.setValue(goat.headType);
		headLengthField.setText(goat.headLength + "");
		headWidthField.setText(goat.headWidth + "");
		foreheadTypeComboBox.setValue(goat.foreheadType);
		
		earLengthField.setText(goat.earLength + "");
		earWidthField.setText(goat.earWidth + "");
		earComboBox.setValue(goat.earCharacter);
		noseComboBox.setValue(goat.noseCharacter);
		limbsComboBox.setValue(goat.limbsCharacter);
		
		neckComboBox.setValue(goat.neckCharacter);
		neckCheckBoxs[0].setSelected(goat.isMeat);
		neckCheckBoxs[1].setSelected(goat.isWrinkle);
		neckCheckBoxs[2].setSelected(goat.isBeard);
		
		bodyLengthField.setText(goat.bodyLength + "");
		bodyHeightField.setText(goat.bodyHeight + "");
		bodyDipLengthField.setText(goat.bodyDipLength + "");
		weightField.setText(goat.weight + "");
		
		bustField.setText(goat.bust + "");
		bustWidthField.setText(goat.bustWidth + "");
		bustDepthField.setText(goat.bustDepth + "");
		
		colorComboBox.setValue(goat.color);
		skinColorComboBox.setValue(goat.skinColor);
		
		tailLengthField.setText(goat.tailLength + "");
		tailWidthField.setText(goat.tailWidth + "");
		tailTypeComboBox.setValue(goat.tailType);
		
		commentArea.setText(goat.comment);
		
		imageSrc = goat.getImageSrc();
		showImage(0);

		if (imageSrc == null) {
			btRight.setDisable(true);
		} else if (imageSrc.length > 1) {
			btRight.setDisable(false);
		}
		
	}
	
	private void getLateralText(String src) {
		try {
			PrintWriter output = new PrintWriter(src + "/" + idComboBox.getValue() + "output" + times + ".txt");
			output.print("ID: ");
			output.println(idComboBox.getValue());
			
			output.print(dateLabels[0].getText() + ": ");
			output.print(yearComboBox.getValue());
			output.print(dateLabels[1].getText() + " ");
			output.print(monthComboBox.getValue());
			output.print(dateLabels[2].getText() + " ");
			output.print(dayComboBox.getValue());
			output.println(dateLabels[3].getText());
			
			output.print(speicesLabel.getText() + ": ");
			output.println(speciesField.getText());
			
			output.print(localityLabels[0].getText() + ": ");
			output.print(countryComboBox.getValue() + " ");
			output.print(provinceComboBox.getValue() == null ? "" : provinceComboBox.getValue() + " ");
			output.print(localityLabels[1].getText() + " ");
			output.print(localityField.getText() + " ");
			output.print(localityLabels[2].getText() + " ");
			output.print(latitudeField.getText() + " ");
			output.print(localityLabels[3].getText() + " ");
			output.println(longitudeField.getText());
			
			output.print(sexLabel.getText() + ": ");
			output.println(sexComboBox.getValue());
			
			output.print(ageLabels[0].getText() + ": ");
			output.println(ageField.getText() + ageLabels[1].getText());
			
			output.print(farrowingLabel.getText() + ": ");
			output.println(farrowingNumberComboBox.getValue());
			
			output.print(cavelLabel.getText() + ": ");
			output.print(cavelComboBox.getValue() + " ");
			output.println(cavelShapeComboBox.getValue());
			
			output.print(headLabels[0].getText() + ": ");
			output.print(headTypeComboBox.getValue() + " ");
			output.print(headLabels[1].getText() + " ");
			output.print(headLengthField.getText() + "cm ");
			output.print(headLabels[2].getText() + " ");
			output.println(headWidthField.getText() + "cm");
			
			output.print(foreheadLabel.getText() + ": ");
			output.println(foreheadTypeComboBox.getValue());
			
			output.print(earLabels[0].getText() + ": ");
			output.print(earComboBox.getValue() + " ");
			output.print(earLabels[1].getText() + " ");
			output.print(earLengthField.getText() + "cm ");
			output.print(earLabels[2].getText() + " ");
			output.println(earWidthField.getText() + "cm");
			
			output.print(noseLabel.getText() + ": ");
			output.println(noseComboBox.getValue());
			
			output.print(limbsLabel.getText() + ": ");
			output.println(limbsComboBox.getValue());
			
			output.print(neckLabel.getText() + ": ");
			output.print(neckComboBox.getValue());
			output.print(neckCheckBoxs[0].getText() + " ");
			output.print(neckCheckBoxs[0].isSelected() + " ");
			output.print(neckCheckBoxs[1].getText() + " ");
			output.print(neckCheckBoxs[1].isSelected() + " ");
			output.print(neckCheckBoxs[2].getText() + " ");
			output.println(neckCheckBoxs[2].isSelected());
			
			output.print(bodyLengthLabel.getText() + ": ");
			output.println(bodyLengthField.getText());
			
			output.print(bodyHeightLabel.getText() + ": ");
			output.println(bodyHeightField.getText());
			
			output.print(bodyDipLengthLabel.getText() + ": ");
			output.println(bodyDipLengthLabel.getText());
			
			output.print(weightLabel.getText() + ": ");
			output.println(weightField.getText());
			
			output.print(bustLabel.getText() + ": ");
			output.println(bustField.getText());
			
			output.print(bustWidthLabel.getText() + ": ");
			output.println(bustWidthField.getText());
			
			output.print(bustDepthLabel.getText() + ": ");
			output.println(bustDepthField.getText());
			
			output.print(furtherColorLabel.getText() + ": ");
			output.println(colorComboBox.getValue());
			
			output.print(skinColorLabel.getText() + ": ");
			output.println(skinColorComboBox.getValue());
			
			output.print(tailLabels[0].getText() + ": ");
			output.print(tailTypeComboBox.getValue() + " ");
			output.print(tailLabels[1].getText() + " ");
			output.print(tailLengthField.getText() + "cm ");
			output.print(tailLabels[2].getText() + " ");
			output.println(tailWidthField.getText() + "cm");
			
			output.print(commentLabel.getText() + ": ");
			output.println(commentArea.getText());
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".txt");
			
			times++;

		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void getLongitudinalText(String src) {
		try {
			PrintWriter output = new PrintWriter(src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			output.print("id\t");
			output.print(dateLabels[0].getText() + "\t");
			output.print(speicesLabel.getText() + "\t");
			output.print(localityLabels[0].getText() + "\t");
			output.print(localityLabels[1].getText() + "\t");
			output.print(localityLabels[2].getText() + "\t");
			output.print(localityLabels[3].getText() + "\t");
			output.print(sexLabel.getText() + "\t");
			output.print(ageLabels[0].getText() + ageLabels[1].getText() + "\t");
			output.print(farrowingLabel.getText() + "\t");
			output.print(cavelLabel.getText() + "\t");
			output.print(headLabels[0].getText() + "\t");
			output.print(headLabels[1].getText() + "cm\t");
			output.print(headLabels[2].getText() + "cm\t");
			output.print(foreheadLabel.getText() + "\t");
			output.print(earLabels[0].getText() + "\t");
			output.print(earLabels[1].getText() + "cm\t");
			output.print(earLabels[2].getText() + "cm\t");
			output.print(noseLabel.getText() + "\t");
			output.print(limbsLabel.getText() + "\t");
			output.print(neckLabel.getText() + "\t");
			output.print(neckCheckBoxs[0].getText() + "\t");
			output.print(neckCheckBoxs[1].getText() + "\t");
			output.print(neckCheckBoxs[2].getText() + "\t");
			output.print(bodyLengthLabel.getText() + "\t");
			output.print(bodyHeightLabel.getText() + "\t");
			output.print(bodyDipLengthLabel.getText() + "\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(bustWidthLabel.getText() + "cm\t");
			output.print(bustDepthLabel.getText() + "cm\t");
			output.print(furtherColorLabel.getText() + "\t");
			output.print(skinColorLabel.getText() + "\t");
			output.print(tailLabels[0].getText() + "\t");
			output.print(tailLabels[1].getText() + "cm\t");
			output.print(tailLabels[2].getText() + "cm\t");
			output.println(commentLabel.getText());

			output.print(idComboBox.getValue() + "\t");
			output.print(yearComboBox.getValue() + dateLabels[1].getText());
			output.print(monthComboBox.getValue() + dateLabels[2].getText());
			output.print(dayComboBox.getValue() + dateLabels[3].getText() + "\t");
			output.print(speciesField.getText() + "\t");
			output.print(countryComboBox.getValue() + provinceComboBox.getValue() + "\t");
			output.print(localityField.getText() + "\t");
			output.print(latitudeField.getText() + "\t");
			output.print(longitudeField.getText() + "\t");
			output.print(sexComboBox.getValue() + "\t");
			output.print(ageField.getText() + "\t");
			output.print(farrowingNumberComboBox.getValue() + "\t");
			if (cavelComboBox.getValue() == cavelCandidate[0]) {
				output.print(cavelShapeComboBox.getValue() + "\t");
			} else {
				output.print(cavelComboBox.getValue() + "\t");
			}
			output.print(headTypeComboBox.getValue() + "\t");
			output.print(headLengthField.getText() + "\t");
			output.print(headWidthField.getText() + "\t");
			output.print(foreheadTypeComboBox.getValue() + "\t");
			output.print(earComboBox.getValue() + "\t");
			output.print(earLengthField.getText() + "\t");
			output.print(earWidthField.getText() + "\t");
			output.print(noseComboBox.getValue() + "\t");
			output.print(limbsComboBox.getValue() + "\t");
			output.print(neckComboBox.getValue() + "\t");
			output.print(neckCheckBoxs[0].isSelected() + "\t");
			output.print(neckCheckBoxs[1].isSelected() + "\t");
			output.print(neckCheckBoxs[2].isSelected() + "\t");
			output.print(bodyLengthField.getText() + "\t");
			output.print(bodyHeightField.getText() + "\t");
			output.print(bodyDipLengthField.getText() + "\t");
			output.print(weightField.getText() + "\t");
			output.print(bustField.getText() + "\t");
			output.print(bustWidthField.getText() + "\t");
			output.print(bustDepthField.getText() + "\t");
			output.print(colorComboBox.getValue() + "\t");
			output.print(skinColorComboBox.getValue() + "\t");
			output.print(tailTypeComboBox.getValue() + "\t");
			output.print(tailLengthField.getText() + "\t");
			output.print(tailWidthField.getText() + "\t");
			output.println(commentArea.getText());
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Goat> goats) {
		try {
			PrintWriter output = new PrintWriter(src + "/" + "output" + times + ".xls");
			output.print("id\t");
			output.print(dateLabels[0].getText() + "\t");
			output.print(speicesLabel.getText() + "\t");
			output.print(localityLabels[0].getText() + "\t");
			output.print(localityLabels[1].getText() + "\t");
			output.print(localityLabels[2].getText() + "\t");
			output.print(localityLabels[3].getText() + "\t");
			output.print(sexLabel.getText() + "\t");
			output.print(ageLabels[0].getText() + ageLabels[1].getText() + "\t");
			output.print(farrowingLabel.getText() + "\t");
			output.print(cavelLabel.getText() + "\t");
			output.print(headLabels[0].getText() + "\t");
			output.print(headLabels[1].getText() + "cm\t");
			output.print(headLabels[2].getText() + "cm\t");
			output.print(foreheadLabel.getText() + "\t");
			output.print(earLabels[0].getText() + "\t");
			output.print(earLabels[1].getText() + "cm\t");
			output.print(earLabels[2].getText() + "cm\t");
			output.print(noseLabel.getText() + "\t");
			output.print(limbsLabel.getText() + "\t");
			output.print(neckLabel.getText() + "\t");
			output.print(neckCheckBoxs[0].getText() + "\t");
			output.print(neckCheckBoxs[1].getText() + "\t");
			output.print(neckCheckBoxs[2].getText() + "\t");
			output.print(bodyLengthLabel.getText() + "\t");
			output.print(bodyHeightLabel.getText() + "\t");
			output.print(bodyDipLengthLabel.getText() + "\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(bustWidthLabel.getText() + "cm\t");
			output.print(bustDepthLabel.getText() + "cm\t");
			output.print(furtherColorLabel.getText() + "\t");
			output.print(skinColorLabel.getText() + "\t");
			output.print(tailLabels[0].getText() + "\t");
			output.print(tailLabels[1].getText() + "cm\t");
			output.print(tailLabels[2].getText() + "cm\t");
			output.println(commentLabel.getText());
			
			for (Goat goat : goats) {
				output.print(goat.getID() + "\t");
				output.print(goat.year + dateLabels[1].getText());
				output.print(goat.month + dateLabels[2].getText());
				output.print(goat.day + dateLabels[3].getText() + "\t");
				output.print(goat.species + "\t");
				output.print(goat.country + goat.province + "\t");
				output.print(goat.locality + "\t");
				output.print(goat.latitude + "\t");
				output.print(goat.longitude + "\t");
				output.print((goat.sex ? "male" : "female") + "\t");
				output.print(goat.age + "\t");
				output.print(goat.farrowingNumber + "\t");
				if (goat.isCavel) {
					output.print(goat.cavelCharacter + "\t");
				} else {
					output.print(goat.isCavel + "\t");
				}
				output.print(goat.headType + "\t");
				output.print(goat.headLength + "\t");
				output.print(goat.headWidth + "\t");
				output.print(goat.foreheadType + "\t");
				output.print(goat.earCharacter + "\t");
				output.print(goat.earLength + "\t");
				output.print(goat.earWidth + "\t");
				output.print(goat.noseCharacter + "\t");
				output.print(goat.limbsCharacter + "\t");
				output.print(goat.neckCharacter + "\t");
				output.print(goat.isMeat + "\t");
				output.print(goat.isWrinkle + "\t");
				output.print(goat.isBeard + "\t");
				output.print(goat.bodyLength + "\t");
				output.print(goat.bodyHeight + "\t");
				output.print(goat.bodyDipLength + "\t");
				output.print(goat.weight + "\t");
				output.print(goat.bust + "\t");
				output.print(goat.bustWidth + "\t");
				output.print(goat.bustDepth + "\t");
				output.print(goat.color + "\t");
				output.print(goat.skinColor + "\t");
				output.print(goat.tailType + "\t");
				output.print(goat.tailLength + "\t");
				output.print(goat.tailWidth + "\t");
				output.println(goat.comment);
			}

			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private class GoatOutputStage extends OutputStage {
		
		protected GoatOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Goat> goats = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							goats.add(Goat.getData(id));
						}  catch (IOException ex) {
							statusLabel.setText(idComboBox.getValue() + status[3]);
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, idComboBox.getValue() + status[3]);
						} catch (ClassNotFoundException ex) {
							statusLabel.setText(idComboBox.getValue() + status[3]);
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, idComboBox.getValue() + status[3]);
						}
					}
				}
				File file = directoryChooser.showDialog(stage);
				OutputFiles(file.getPath(), goats);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
		
	}
}
