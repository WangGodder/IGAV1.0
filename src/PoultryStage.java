/**
 * @author 王鑫祉 
 * @date : 2017年7月28日 上午10:56:35
 */
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Animal.Poultry;
import Language.PoultryLanguage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class PoultryStage extends StageModel {
	private String[] eggColorCandidate;
	private String[] neckCharacterCandidate;
	private String[] combCandidate;
	private String[] skinColorCandidate;
	private String[] legCharacterCandidate;
	private String[] bodyCharacterCandidate;
	
	private final TextField bodyDipLengthField = new TextField();
	private final TextField weightField = new TextField();
	private final TextField bustWidthField = new TextField();
	private final TextField bustDepthField = new TextField();
	private final TextField sternumLengthField = new TextField();
	private final TextField shinLengthField = new TextField();
	private final TextField shinCircumferenceField = new TextField();
	private final TextField pelvisWidthField = new TextField();
	private final TextField killWeightField = new TextField();
	private final TextField slaughterWeightField = new TextField();
	private final TextField slaughterRateField = new TextField();
	private final TextField chamberHalfNetRateField = new TextField();
	private final TextField chamberAllNetRateField = new TextField();
	private final TextField legMuscleRateField = new TextField();
	private final TextField breastMuscleRateField = new TextField();
	private final TextField AFYField = new TextField();
	private final TextField eggWeightField = new TextField();
	private final TextField eggShapeIndexField = new TextField();
	private final TextField eggShellSERField = new TextField();
	private final TextField eggShellThicknessField = new TextField();
	private final TextField yolkRateField = new TextField();
	private final TextField earColorField = new TextField();
	private final TextField mouthShapeField = new TextField();
	private final TextField clawColorField = new TextField();
	private final TextField webColorField = new TextField();

	private final ComboBox<String> eggColorComboBox = new ComboBox<>();
	private final ComboBox<String> neckCharacterComboBox = new ComboBox<>();
	private final ComboBox<String> combCharacterComboBox = new ComboBox<>();
	private final ComboBox<String> skinColorComboBox = new ComboBox<>();
	private final ComboBox<String> legCharacterComboBox = new ComboBox<>();
	private final ComboBox<String> bodyCharacterComboBox = new ComboBox<>();
	
	private final Label eggColorLabel = new Label("蛋壳色泽");
	private final Label neckCharacterLabel = new Label("脖颈");
	private final Label combLabel = new Label("冠型");
	private final Label skinColorLabel = new Label("肤色");
	private final Label legCharacterLabel = new Label("腿颈");
	private final Label bodyCharacterLabel = new Label("体型");
	private final Label bodyDipLengthLabel = new Label("体斜长");
	private final Label weightLabel = new Label("体重");
	private final Label bustWidthLabel = new Label("胸宽");
	private final Label bustDepthLabel = new Label("胸深");
	private final Label sternumLengthLabel = new Label("龙骨长");
	private final Label shinLengthLabel = new Label("胫长");
	private final Label shinCircumferenceLabel = new Label("胫围");
	private final Label pelvisWidthLabel = new Label("骨盆宽 ");
	private final Label killWeightLabel = new Label("宰前活量");
	private final Label slaughterWeightLabel = new Label("屠体重");
	private final Label slaughterRateLabel = new Label("屠宰率");
	private final Label chamberHalfNetRateLabel = new Label("半净膛率");
	private final Label chamberAllNetRateLabel = new Label("全净膛率");
	private final Label legMuscleRateLabel = new Label("腿肌率");
	private final Label breastMuscleRateLabel = new Label("胸肌率");
	private final Label AFYLabel = new Label("腹脂率 ");
	private final Label eggWeightLabel = new Label("蛋重");
	private final Label eggShapeIndexLabel = new Label("蛋形指数");
	private final Label eggShellSERLabel = new Label("蛋壳强率");
	private final Label eggShellThicknessLabel = new Label("蛋壳厚度");
	private final Label yolkRateLabel = new Label("蛋黄比率 ");
	private final Label earColorLabel = new Label("耳色");
	private final Label mouthShapeLabel = new Label("喙型");
	private final Label clawColorLabel = new Label("爪色");
	private final Label webColorLabel = new Label("蹼色");
	
	public PoultryStage(Stage mainStage) {
		super(mainStage);
		
		stage.setTitle("Poultry Register");
		
		setLanguage("Chinese");
		initializeNode();
		initializeAction();
		
		GridPane[] dataPanes = new GridPane[10];
		for (int i = 0; i < dataPanes.length; i++) {
			dataPanes[i] = new GridPane();
			dataPanes[i].setHgap(10);
		}
		
		HBox dateBox = new HBox(5);
		dateBox.getChildren().add(yearComboBox);
		dateBox.getChildren().add(dateLabels[1]);
		dateBox.getChildren().add(monthComboBox);
		dateBox.getChildren().add(dateLabels[2]);
		dateBox.getChildren().add(dayComboBox);
		dateBox.getChildren().add(dateLabels[3]);
		
		
		dataPanes[0].add(new Label("ID"), 0, 0);
		dataPanes[0].add(idComboBox, 1, 0);
		dataPanes[0].add(dateLabels[0], 2, 0);
		dataPanes[0].add(dateBox, 3, 0);
		dataPanes[0].add(speicesLabel, 4, 0);
		dataPanes[0].add(speciesField, 5, 0);
		
		HBox localityBox = new HBox(5);
		localityBox.getChildren().add(countryComboBox);
		localityBox.getChildren().add(provinceComboBox);
		localityBox.getChildren().add(localityLabels[1]);
		localityBox.getChildren().add(localityField);
		localityBox.getChildren().add(localityLabels[2]);
		localityBox.getChildren().add(latitudeField);
		localityBox.getChildren().add(localityLabels[3]);
		localityBox.getChildren().add(longitudeField);
		
		dataPanes[1].add(localityLabels[0], 0, 0); // 采集地区
		dataPanes[1].add(localityBox, 1, 0); 
		
		HBox ageBox = new HBox(5);
		ageBox.getChildren().add(ageField);
		ageBox.getChildren().add(ageLabels[1]);
		
		dataPanes[2].add(sexLabel, 0, 0);
		dataPanes[2].add(sexComboBox, 1, 0);
		dataPanes[2].add(ageLabels[0], 2, 0);
		dataPanes[2].add(ageBox, 3, 0);
		dataPanes[2].add(combLabel, 4, 0);
		dataPanes[2].add(combCharacterComboBox, 5, 0);
		dataPanes[2].add(earColorLabel, 6, 0);
		dataPanes[2].add(earColorField, 7, 0);
		dataPanes[2].add(mouthShapeLabel, 8, 0);
		dataPanes[2].add(mouthShapeField, 9, 0);
		
		dataPanes[3].add(neckCharacterLabel, 0, 0);
		dataPanes[3].add(neckCharacterComboBox, 1, 0);
		dataPanes[3].add(skinColorLabel, 2, 0);
		dataPanes[3].add(skinColorComboBox, 3, 0);
		dataPanes[3].add(legCharacterLabel, 4, 0);
		dataPanes[3].add(legCharacterComboBox, 5, 0);
		dataPanes[3].add(clawColorLabel, 6, 0);
		dataPanes[3].add(clawColorField, 7, 0);
		dataPanes[3].add(webColorLabel, 8, 0);
		dataPanes[3].add(webColorField, 9, 0);
		
		dataPanes[4].add(bodyCharacterLabel, 0, 0);
		dataPanes[4].add(bodyCharacterComboBox, 1, 0);
		dataPanes[4].add(bodyDipLengthLabel, 2, 0);
		dataPanes[4].add(getUnitBox(bodyDipLengthField, "cm"), 3, 0);
		dataPanes[4].add(weightLabel, 4, 0);
		dataPanes[4].add(getUnitBox(weightField, "kg"), 5, 0);
		dataPanes[4].add(bustWidthLabel, 6, 0);
		dataPanes[4].add(getUnitBox(bustWidthField, "cm"), 7, 0);
		dataPanes[4].add(bustDepthLabel, 8, 0);
		dataPanes[4].add(getUnitBox(bustDepthField, "cm"), 9, 0);
		
		dataPanes[5].add(sternumLengthLabel, 0, 0);
		dataPanes[5].add(getUnitBox(sternumLengthField, "cm"), 1, 0);
		dataPanes[5].add(shinLengthLabel, 2, 0);
		dataPanes[5].add(getUnitBox(shinLengthField, "cm"), 3, 0);
		dataPanes[5].add(shinCircumferenceLabel, 4, 0);
		dataPanes[5].add(getUnitBox(shinCircumferenceField, "cm"), 5, 0);
		dataPanes[5].add(pelvisWidthLabel, 6, 0);
		dataPanes[5].add(getUnitBox(pelvisWidthField, "cm"), 7, 0);
		
		dataPanes[6].add(killWeightLabel, 0, 0);
		dataPanes[6].add(getUnitBox(killWeightField, "kg"), 1, 0);
		dataPanes[6].add(slaughterWeightLabel, 2, 0);
		dataPanes[6].add(getUnitBox(slaughterWeightField, "kg"), 3, 0);
		dataPanes[6].add(chamberHalfNetRateLabel, 6, 0);
		dataPanes[6].add(getUnitBox(chamberHalfNetRateField, "%"), 7, 0);
		dataPanes[6].add(chamberAllNetRateLabel, 8, 0);
		dataPanes[6].add(getUnitBox(chamberAllNetRateField, "%"), 9, 0);
		
		dataPanes[7].add(legMuscleRateLabel, 0, 0);
		dataPanes[7].add(getUnitBox(legMuscleRateField, "%"), 1, 0);
		dataPanes[7].add(breastMuscleRateLabel, 2, 0);
		dataPanes[7].add(getUnitBox(breastMuscleRateField, "%"), 3, 0);
		dataPanes[7].add(AFYLabel, 4, 0);
		dataPanes[7].add(getUnitBox(AFYField, "%"), 5, 0);
		dataPanes[7].add(slaughterRateLabel, 6, 0);
		dataPanes[7].add(getUnitBox(slaughterRateField, "%"), 7, 0);
		
		dataPanes[8].add(eggWeightLabel, 0, 0);
		dataPanes[8].add(getUnitBox(eggWeightField, "g"), 1, 0);
		dataPanes[8].add(eggShapeIndexLabel, 2, 0);
		dataPanes[8].add(eggShapeIndexField, 3, 0);
		dataPanes[8].add(eggShellSERLabel, 4, 0);
		dataPanes[8].add(getUnitBox(eggShellSERField, "MPa"), 5, 0);
		dataPanes[8].add(eggShellThicknessLabel, 6, 0);
		dataPanes[8].add(getUnitBox(eggShellThicknessField, "mm"), 7, 0);
		
		dataPanes[9].add(eggColorLabel, 0, 0);
		dataPanes[9].add(eggColorComboBox, 1, 0);
		dataPanes[9].add(yolkRateLabel, 2, 0);
		dataPanes[9].add(getUnitBox(yolkRateField, "%"), 3, 0);
		
		for (int i = 0; i < dataPanes.length; i++) {
			dataPane.add(dataPanes[i], 0, i);
		}
	}
	
	@Override
	protected void setLanguage(String languageName) {
		PoultryLanguage language = new PoultryLanguage();
		try {
			language = PoultryLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
		
		eggColorCandidate = language.eggColorCandidate;
		neckCharacterCandidate = language.neckCharacterCandidate;
		combCandidate = language.combCandidate;
		skinColorCandidate = language.skinColorCandidate;
		legCharacterCandidate = language.legCharacterCandidate;
		bodyCharacterCandidate = language.bodyCharacterCandidate;
		eggColorLabel.setText(language.eggColorLabel);
		neckCharacterLabel.setText(language.neckCharacterLabel);
		combLabel.setText(language.combLabel);
		skinColorLabel.setText(language.skinColorLabel);
		legCharacterLabel.setText(language.legCharacterLabel);
		bodyCharacterLabel.setText(language.bodyCharacterLabel);
		bodyDipLengthLabel.setText(language.bodyDipLengthLabel);
		weightLabel.setText(language.weightLabel);
		bustWidthLabel.setText(language.bustWidthLabel);
		bustDepthLabel.setText(language.bustDepthLabel);
		sternumLengthLabel.setText(language.sternumLengthLabel);
		shinLengthLabel.setText(language.shinLengthLabel);
		shinCircumferenceLabel.setText(language.shinCircumferenceLabel);
		pelvisWidthLabel.setText(language.pelvisWidthLabel);
		killWeightLabel.setText(language.killWeightLabel);
		slaughterWeightLabel.setText(language.slaughterWeightLabel);
		slaughterRateLabel.setText(language.slaughterRateLabel);
		chamberHalfNetRateLabel.setText(language.chamberHalfNetRateLabel);
		chamberAllNetRateLabel.setText(language.chamberAllNetRateLabel);
		legMuscleRateLabel.setText(language.legMuscleRateLabel);
		breastMuscleRateLabel.setText(language.breastMuscleRateLabel);
		AFYLabel.setText(language.AFYLabel);
		eggWeightLabel.setText(language.eggWeightLabel);
		eggShapeIndexLabel.setText(language.eggShapeIndexLabel);
		eggShellSERLabel.setText(language.eggShellSERLabel);
		eggShellThicknessLabel.setText(language.eggShellThicknessLabel);
		yolkRateLabel.setText(language.yolkRateLabel);
		earColorLabel.setText(language.earColorLabel);
		mouthShapeLabel.setText(language.mouthShapeLabel);
		clawColorLabel.setText(language.clawColorLabel);
		webColorLabel.setText(language.webColorLabel);
		
		initializeComboBox();
	}
	
	private void initializeNode() {
		initNode();
		
		setFieldWidth(80, weightField, bodyDipLengthField, sternumLengthField, 
				shinLengthField, bustWidthField, bustDepthField, 
				shinCircumferenceField, pelvisWidthField, slaughterRateField, 
				killWeightField, slaughterWeightField, chamberHalfNetRateField, 
				chamberAllNetRateField, legMuscleRateField, breastMuscleRateField,
				AFYField, eggWeightField, eggShapeIndexField, eggShellSERField,
				eggShellThicknessField, yolkRateField, clawColorField, webColorField);
		setFieldWidth(100, earColorField, mouthShapeField);
		
		initializeComboBox();
		getIDCandidate("poultry/data");
		
		getLanguageCandidate("language/poultry");
	}
	
	private void initializeComboBox() {
		
		initializeComboBox(eggColorComboBox, eggColorCandidate, false);
		initializeComboBox(neckCharacterComboBox, neckCharacterCandidate, false);
		initializeComboBox(combCharacterComboBox, combCandidate, false);
		initializeComboBox(skinColorComboBox, skinColorCandidate, true);
		skinColorComboBox.setValue(skinColorCandidate[0]);
		skinColorComboBox.setMaxWidth(100);
		initializeComboBox(legCharacterComboBox, legCharacterCandidate, false);
		initializeComboBox(bodyCharacterComboBox, bodyCharacterCandidate, false);
		
	}
	
	private void initializeAction() {
		initAction();
		
		btSearch.setOnAction(e -> {
			try {
				int id = -1;
				try {
					id = Integer.parseInt(idComboBox.getValue().trim());
					
				} catch (NumberFormatException ex) {
					statusLabel.setText(status[1]);
					
				}
				Poultry poultry = Poultry.getData(id);
				showData(poultry);
				
				JOptionPane.showMessageDialog(null, poultry.getID() + status[2]);
				statusLabel.setText(poultry.getID() + status[2]);
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
				Poultry poultry = getPoultry();
				Poultry.writeData(poultry);
				JOptionPane.showMessageDialog(null, poultry.getID() + status[4]);
				statusLabel.setText(poultry.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("poultry/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Poultry poultry = getPoultry();
					Poultry.writeData(poultry);
					JOptionPane.showMessageDialog(null, poultry.getID() + status[6]);
					statusLabel.setText(poultry.getID() + status[6]);
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
			File idFile = new File("poultry/data");
			File[] files = idFile.listFiles();
			Stage stage = new PoultryOutputStage(files);
		});
	}
	
	private Poultry getPoultry() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		
		Poultry poultry = new Poultry(id);
		
		poultry.year = (int)yearComboBox.getValue();
		poultry.month = (int)monthComboBox.getValue();
		poultry.day = (int)dayComboBox.getValue();
		poultry.country = countryComboBox.getValue();
		if (poultry.country == countryCandidate[87])
			poultry.province = provinceComboBox.getValue();
		poultry.locality = localityField.getText();
		poultry.latitude = getDouble(latitudeField);
		poultry.longitude = getDouble(longitudeField);
		poultry.species = speciesField.getText();
		poultry.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		poultry.age = getDouble(ageField);
		poultry.comment = commentArea.getText();
		poultry.setImageSrc(imageSrc);
		
		poultry.combShape = combCharacterComboBox.getValue();
		poultry.earColor = earColorField.getText().trim();
		poultry.mouthShape = mouthShapeField.getText().trim();
		poultry.neckCharacter = neckCharacterComboBox.getValue();
		poultry.skinColor = skinColorComboBox.getValue().trim();
		poultry.legCharacter = legCharacterComboBox.getValue();
		poultry.clawColor = clawColorField.getText().trim();
		poultry.webColor = webColorField.getText().trim();
		poultry.bodyCharacter = bodyCharacterComboBox.getValue();
		poultry.bodyDipLength = getDouble(bodyDipLengthField);
		poultry.weight = getDouble(weightField);
		poultry.bustWidth = getDouble(bustWidthField);
		poultry.bustDepth = getDouble(bustDepthField);
		poultry.sternumLength = getDouble(sternumLengthField);
		poultry.shinLength = getDouble(shinLengthField);
		poultry.shinCircumference = getDouble(shinCircumferenceField);
		poultry.pelvisWidth = getDouble(pelvisWidthField);
		poultry.killWeight = getDouble(killWeightField);
		poultry.slaughterRate = getDouble(slaughterRateField);
		poultry.slaughterWeight = getDouble(slaughterWeightField);
		poultry.chamberHalfNetRate = getDouble(chamberHalfNetRateField);
		poultry.chamberAllNetRate = getDouble(chamberAllNetRateField);
		poultry.legMuscleRate = getDouble(legMuscleRateField);
		poultry.breastMuscleRate = getDouble(breastMuscleRateField);
		poultry.AFY = getDouble(AFYField);
		poultry.eggWeight = getDouble(eggWeightField);
		poultry.eggShapeIndex = getDouble(eggShapeIndexField);
		poultry.eggShellSER = getDouble(eggShellSERField);
		poultry.eggShellThickness = getDouble(eggShellThicknessField);
		poultry.eggShellColor = eggColorComboBox.getValue();
		poultry.yolkRate = getDouble(yolkRateField);
		
		return poultry;
	}
	
	private void showData(Poultry poultry) {
		yearComboBox.setValue(poultry.year);
		monthComboBox.setValue(poultry.month);
		dayComboBox.setValue(poultry.day);
		countryComboBox.setValue(poultry.country);
		provinceComboBox.setValue(poultry.province);
		localityField.setText(poultry.locality);
		latitudeField.setText(poultry.latitude + "");
		longitudeField.setText(poultry.longitude + "");
		speciesField.setText(poultry.species);
		sexComboBox.setValue((poultry.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(poultry.getAge() + "");
		commentArea.setText(poultry.comment);
		
		combCharacterComboBox.setValue(poultry.combShape);
		earColorField.setText(poultry.earColor);
		mouthShapeField.setText(poultry.mouthShape);
		neckCharacterComboBox.setValue(poultry.neckCharacter);
		skinColorComboBox.setValue(poultry.skinColor);
		legCharacterComboBox.setValue(poultry.legCharacter);
		clawColorField.setText(poultry.clawColor);
		webColorField.setText(poultry.webColor);
		bodyCharacterComboBox.setValue(poultry.bodyCharacter);
		bodyDipLengthField.setText(poultry.bodyDipLength + "");
		weightField.setText(poultry.weight + "");
		bustWidthField.setText(poultry.bustWidth + "");
		bustDepthField.setText(poultry.bustDepth + "");
		sternumLengthField.setText(poultry.sternumLength + "");
		shinLengthField.setText(poultry.shinLength + "");
		shinCircumferenceField.setText(poultry.shinCircumference + "");
		pelvisWidthField.setText(poultry.pelvisWidth + "");
		killWeightField.setText(poultry.killWeight + "");
		slaughterRateField.setText(poultry.slaughterRate + "");
		slaughterWeightField.setText(poultry.slaughterWeight + "");
		chamberHalfNetRateField.setText(poultry.chamberHalfNetRate + "");
		chamberAllNetRateField.setText(poultry.chamberAllNetRate + "");
		legMuscleRateField.setText(poultry.legMuscleRate + "");
		breastMuscleRateField.setText(poultry.breastMuscleRate + "");
		AFYField.setText(poultry.AFY + "");
		eggWeightField.setText(poultry.eggWeight + "");
		eggShellSERField.setText(poultry.eggShellSER + "");
		eggShapeIndexField.setText(poultry.eggShapeIndex + "");
		eggShellThicknessField.setText(poultry.eggShellThickness + "");
		eggColorComboBox.setValue(poultry.earColor);
		yolkRateField.setText(poultry.yolkRate + "");
		
		imageSrc = poultry.getImageSrc();
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
			
			output.print(combLabel.getText() + ": ");
			output.println(combCharacterComboBox.getValue());
			
			output.print(earColorLabel.getText() + ": ");
			output.println(earColorField.getText());
			
			output.print(mouthShapeLabel.getText() + ": ");
			output.println(mouthShapeField.getText());
			
			output.print(neckCharacterLabel.getText() + ": ");
			output.println(neckCharacterComboBox.getValue());
			
			output.print(skinColorLabel.getText() + ": ");
			output.println(skinColorComboBox.getValue());
			
			output.print(legCharacterLabel.getText() + ": ");
			output.println(legCharacterComboBox.getValue());
			
			output.print(clawColorLabel.getText() + ": ");
			output.println(clawColorField.getText());
			
			output.print(webColorLabel.getText() + ": ");
			output.println(webColorField.getText());
			
			output.print(bodyCharacterLabel.getText() + ": ");
			output.println(bodyCharacterComboBox.getValue());
			
			output.print(bodyDipLengthLabel.getText() + ": ");
			output.println(bodyDipLengthField.getText() + "cm");
			
			output.print(weightLabel.getText() + ": ");
			output.println(weightField.getText() + "kg");
			
			output.print(bustWidthLabel.getText() + ": ");
			output.println(bustWidthField.getText() + "cm");
			
			output.print(bustDepthLabel.getText() + ": ");
			output.println(bustDepthField.getText() + "cm");
			
			output.print(sternumLengthLabel.getText() + ": ");
			output.println(sternumLengthField.getText() + "cm");
			
			output.print(shinLengthLabel.getText() + ": ");
			output.println(shinLengthField.getText() + "cm");
			
			output.print(shinCircumferenceLabel.getText() + ": ");
			output.print(shinCircumferenceField.getText() + "cm");
			
			output.print(pelvisWidthLabel.getText() + ": ");
			output.println(pelvisWidthField.getText() + "cm");
			
			output.print(killWeightLabel.getText() + ": ");
			output.println(killWeightField.getText() + "kg");
			
			output.print(slaughterWeightLabel.getText() + ": ");
			output.println(slaughterWeightField.getText() + "kg");

			output.print(slaughterRateLabel.getText() + ": ");
			output.println(slaughterRateField.getText() + "%");
			
			output.print(chamberHalfNetRateLabel.getText() + ": ");
			output.println(chamberHalfNetRateField.getText() + "%");
			
			output.print(chamberAllNetRateLabel.getText() + ": ");
			output.println(chamberAllNetRateField.getText() + "%");
			
			output.print(legMuscleRateLabel.getText() + ": ");
			output.println(legMuscleRateField.getText() + "%");
			
			output.print(breastMuscleRateLabel.getText() + ": ");
			output.println(breastMuscleRateField.getText() +"%");
			
			output.print(AFYLabel.getText() + ": ");
			output.println(AFYField.getText() + "%");
			
			output.print(eggWeightLabel.getText() + ": ");
			output.println(eggWeightField.getText() + "kg");
			
			output.print(eggShapeIndexLabel.getText() + ": ");
			output.println(eggShapeIndexField.getText());
			
			output.print(eggShellSERLabel.getText() + ": ");
			output.println(eggShellSERField.getText());
			
			output.print(eggShellThicknessLabel.getText() + ": ");
			output.println(eggShellThicknessField.getText() + "cm");
			
			output.print(eggColorLabel.getText() + ": ");
			output.println(eggColorComboBox.getValue());
			
			output.print(yolkRateLabel.getText() + ": ");
			output.println(yolkRateField.getText() + "%");
			
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
		Poultry poultry = getPoultry();
		
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
			output.print(combLabel.getText() + "\t");
			output.print(earColorLabel.getText() + "\t");
			output.print(mouthShapeLabel.getText() + "\t");
			output.print(neckCharacterLabel.getText() + "\t");
			output.print(skinColorLabel.getText() + "\t");
			output.print(legCharacterLabel.getText() + "\t");
			output.print(clawColorLabel.getText() + "\t");
			output.print(webColorLabel.getText() + "\t");
			output.print(bodyCharacterLabel.getText() + "\t");
			output.print(bodyDipLengthLabel.getText() + "cm\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bustWidthLabel.getText() + "cm\t");
			output.print(bustDepthLabel.getText() + "cm\t");
			output.print(sternumLengthLabel.getText() + "cm\t");
			output.print(shinLengthLabel.getText() + "cm\t");
			output.print(shinCircumferenceLabel.getText() + "cm\t");
			output.print(pelvisWidthLabel.getText() + "cm\t");
			output.print(killWeightLabel.getText() + "kg\t");
			output.print(slaughterWeightLabel.getText() + "kg\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(chamberHalfNetRateLabel.getText() + "%\t");
			output.print(chamberAllNetRateLabel.getText() + "%\t");
			output.print(legMuscleRateLabel.getText() + "%\t");
			output.print(breastMuscleRateLabel.getText() + "%\t");
			output.print(AFYLabel.getText() + "%\t");
			output.print(eggWeightLabel.getText() + "kg\t");
			output.print(eggShapeIndexLabel.getText() + "\t");
			output.print(eggShellSERLabel.getText() + "MPa\t");
			output.print(eggShellThicknessLabel.getText() + "cm\t");
			output.print(eggColorLabel.getText() + "\t");
			output.print(yolkRateLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			output.print(poultry.getID() + "\t");
			output.print(poultry.year + dateLabels[1].getText());
			output.print(poultry.month + dateLabels[2].getText());
			output.print(poultry.day + dateLabels[3].getText() + "\t");
			output.print(poultry.species + "\t");
			output.print(poultry.country + poultry.province + "\t");
			output.print(poultry.locality + "\t");
			output.print(poultry.latitude + "\t");
			output.print(poultry.longitude + "\t");
			output.print((poultry.sex ? "male" : "female") + "\t");
			output.print(poultry.age + "\t");
			output.print(poultry.combShape + "\t");
			output.print(poultry.earColor + "\t");
			output.print(poultry.mouthShape + "\t");
			output.print(poultry.neckCharacter + "\t");
			output.print(poultry.skinColor + "\t");
			output.print(poultry.legCharacter + "\t");
			output.print(poultry.clawColor + "\t");
			output.print(poultry.webColor + "\t");
			output.print(poultry.bodyCharacter + "\t");
			output.print(poultry.bodyDipLength + "\t");
			output.print(poultry.weight + "\t");
			output.print(poultry.bustWidth + "\t");
			output.print(poultry.bustDepth + "\t");
			output.print(poultry.sternumLength + "\t");
			output.print(poultry.shinLength + "\t");
			output.print(poultry.shinCircumference + "\t");
			output.print(poultry.pelvisWidth + "\t");
			output.print(poultry.killWeight + "\t");
			output.print(poultry.slaughterWeight + "\t");
			output.print(poultry.slaughterRate + "\t");
			output.print(poultry.chamberHalfNetRate + "\t");
			output.print(poultry.chamberAllNetRate + "\t");
			output.print(poultry.legMuscleRate + "\t");
			output.print(poultry.breastMuscleRate + "\t");
			output.print(poultry.AFY + "\t");
			output.print(poultry.eggWeight + "\t");
			output.print(poultry.eggShapeIndex + "\t");
			output.print(poultry.eggShellSER + "\t");
			output.print(poultry.eggShellThickness + "\t");
			output.print(poultry.eggShellColor + "\t");
			output.print(poultry.yolkRate + "\t");
			output.println(poultry.comment);
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Poultry> poultries) {
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
			output.print(combLabel.getText() + "\t");
			output.print(earColorLabel.getText() + "\t");
			output.print(mouthShapeLabel.getText() + "\t");
			output.print(neckCharacterLabel.getText() + "\t");
			output.print(skinColorLabel.getText() + "\t");
			output.print(legCharacterLabel.getText() + "\t");
			output.print(clawColorLabel.getText() + "\t");
			output.print(webColorLabel.getText() + "\t");
			output.print(bodyCharacterLabel.getText() + "\t");
			output.print(bodyDipLengthLabel.getText() + "cm\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bustWidthLabel.getText() + "cm\t");
			output.print(bustDepthLabel.getText() + "cm\t");
			output.print(sternumLengthLabel.getText() + "cm\t");
			output.print(shinLengthLabel.getText() + "cm\t");
			output.print(shinCircumferenceLabel.getText() + "cm\t");
			output.print(pelvisWidthLabel.getText() + "cm\t");
			output.print(killWeightLabel.getText() + "kg\t");
			output.print(slaughterWeightLabel.getText() + "kg\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(chamberHalfNetRateLabel.getText() + "%\t");
			output.print(chamberAllNetRateLabel.getText() + "%\t");
			output.print(legMuscleRateLabel.getText() + "%\t");
			output.print(breastMuscleRateLabel.getText() + "%\t");
			output.print(AFYLabel.getText() + "%\t");
			output.print(eggWeightLabel.getText() + "kg\t");
			output.print(eggShapeIndexLabel.getText() + "\t");
			output.print(eggShellSERLabel.getText() + "MPa\t");
			output.print(eggShellThicknessLabel.getText() + "cm\t");
			output.print(eggColorLabel.getText() + "\t");
			output.print(yolkRateLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			for (Poultry poultry : poultries) {
				output.print(poultry.getID() + "\t");
				output.print(poultry.year + dateLabels[1].getText());
				output.print(poultry.month + dateLabels[2].getText());
				output.print(poultry.day + dateLabels[3].getText() + "\t");
				output.print(poultry.species + "\t");
				output.print(poultry.country + poultry.province + "\t");
				output.print(poultry.locality + "\t");
				output.print(poultry.latitude + "\t");
				output.print(poultry.longitude + "\t");
				output.print((poultry.sex ? "male" : "female") + "\t");
				output.print(poultry.age + "\t");
				output.print(poultry.combShape + "\t");
				output.print(poultry.earColor + "\t");
				output.print(poultry.mouthShape + "\t");
				output.print(poultry.neckCharacter + "\t");
				output.print(poultry.skinColor + "\t");
				output.print(poultry.legCharacter + "\t");
				output.print(poultry.clawColor + "\t");
				output.print(poultry.webColor + "\t");
				output.print(poultry.bodyCharacter + "\t");
				output.print(poultry.bodyDipLength + "\t");
				output.print(poultry.weight + "\t");
				output.print(poultry.bustWidth + "\t");
				output.print(poultry.bustDepth + "\t");
				output.print(poultry.sternumLength + "\t");
				output.print(poultry.shinLength + "\t");
				output.print(poultry.shinCircumference + "\t");
				output.print(poultry.pelvisWidth + "\t");
				output.print(poultry.killWeight + "\t");
				output.print(poultry.slaughterWeight + "\t");
				output.print(poultry.slaughterRate + "\t");
				output.print(poultry.chamberHalfNetRate + "\t");
				output.print(poultry.chamberAllNetRate + "\t");
				output.print(poultry.legMuscleRate + "\t");
				output.print(poultry.breastMuscleRate + "\t");
				output.print(poultry.AFY + "\t");
				output.print(poultry.eggWeight + "\t");
				output.print(poultry.eggShapeIndex + "\t");
				output.print(poultry.eggShellSER + "\t");
				output.print(poultry.eggShellThickness + "\t");
				output.print(poultry.eggShellColor + "\t");
				output.print(poultry.yolkRate + "\t");
				output.println(poultry.comment);
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
	
	private class PoultryOutputStage extends OutputStage {
		
		protected PoultryOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Poultry> Poultries = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							Poultries.add(Poultry.getData(id));
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
				OutputFiles(file.getPath(), Poultries);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
		
	}
}
