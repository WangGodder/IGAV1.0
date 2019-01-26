/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午3:26:21
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Animal.Pig;
import Language.PigLanguage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class PigStage extends StageModel {
	private String[] furtherColorCandidate;
	
	private final ComboBox<String> furtherColorComboBox = new ComboBox<>();
	
	private final TextField weightField = new TextField();
	private final TextField bodyLengthField = new TextField();
	private final TextField bodyHeightField = new TextField();
	private final TextField bustField = new TextField();
	private final TextField carcassWeightField = new TextField();
	private final TextField slaughterRateField = new TextField();
	private final TextField backfatThicknessOfAverageField = new TextField();
	private final TextField backfatThicknessOfSixSevenField = new TextField();
	private final TextField skinThicknessField = new TextField();
	private final TextField musculiOculiField = new TextField();
	private final TextField meatFactorField = new TextField();
	
	private final TextField meatColorField = new TextField();
	private final TextField marblingField = new TextField();
	private final TextField PHField = new TextField();
	private final TextField crudeProteinField = new TextField();
	private final TextField imfField = new TextField();
	private final TextField waterProportionField = new TextField();
	private final TextField crudeAshField = new TextField();
	
	private final Label furtherColorLabel = new Label("毛色");
	
	private final Label weightLabel = new Label("体重");
	private final Label bodyLengthLabel = new Label("体长");
	private final Label bodyHeightLabel = new Label("提高");
	private final Label bustLabel = new Label("胸围");
	private final Label carcassWeightLabel = new Label("胴体重");
	private final Label slaughterRateLabel = new Label("屠宰率");
	private final Label backfatThicknessOfAverageLabel = new Label("平均背膘厚");
	private final Label backfatThicknessOfSixSevenLabel = new Label("6-7肋骨背膘厚");
	private final Label skinThicknessLabel = new Label("皮厚");
	private final Label musculiOculiLabel = new Label("眼肌面积");
	private final Label meatFactorLabel = new Label("瘦肉率");
	
	private final Label meatColorLabel = new Label("肉色");
	private final Label marblingLabel = new Label("大理石纹");
	private final Label PHLabel = new Label("PH值");
	private final Label crudeProteinLabel = new Label("粗蛋白");
	private final Label imfLabel = new Label("肌内脂肪");
	private final Label waterProportionLabel = new Label("水分");
	private final Label crudeAshLabel = new Label("粗灰分");
	
	public PigStage(Stage mainStage) {
		super(mainStage);
		stage.setTitle("Pig Register");
		
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
		dataPanes[2].add(furtherColorLabel, 4, 0);
		dataPanes[2].add(furtherColorComboBox, 5, 0);
		
		dataPanes[3].add(bodyLengthLabel, 0, 0);
		dataPanes[3].add(getUnitBox(bodyLengthField, "cm"), 1, 0);
		dataPanes[3].add(bodyHeightLabel,  2, 0);
		dataPanes[3].add(getUnitBox(bodyHeightField, "cm"), 3, 0);
		dataPanes[3].add(bustLabel, 4, 0);
		dataPanes[3].add(getUnitBox(bustField, "cm"), 5, 0);
		dataPanes[3].add(weightLabel, 6, 0);
		dataPanes[3].add(getUnitBox(weightField, "kg"), 7, 0);
		
		dataPanes[4].add(carcassWeightLabel, 0, 0);
		dataPanes[4].add(getUnitBox(carcassWeightField, "kg"), 1, 0);
		dataPanes[4].add(slaughterRateLabel, 2, 0);
		dataPanes[4].add(getUnitBox(slaughterRateField, "%"), 3, 0);
		dataPanes[4].add(backfatThicknessOfAverageLabel, 4, 0);
		dataPanes[4].add(getUnitBox(backfatThicknessOfAverageField, "cm"), 5, 0);
		
		dataPanes[5].add(backfatThicknessOfSixSevenLabel, 0, 0);
		dataPanes[5].add(getUnitBox(backfatThicknessOfSixSevenField, "cm"), 1, 0);
		dataPanes[5].add(skinThicknessLabel, 2, 0);
		dataPanes[5].add(getUnitBox(skinThicknessField, "cm"), 3, 0);
		dataPanes[5].add(musculiOculiLabel, 4, 0);
		dataPanes[5].add(getUnitBox(musculiOculiField, "cm2"), 5, 0);
		dataPanes[5].add(meatFactorLabel, 6, 0);
		dataPanes[5].add(getUnitBox(meatFactorField, "%"), 7, 0);
		
		dataPanes[6].add(meatColorLabel, 0, 0);
		dataPanes[6].add(meatColorField, 1, 0);
		dataPanes[6].add(marblingLabel, 2, 0);
		dataPanes[6].add(marblingField, 3, 0);
		dataPanes[6].add(PHLabel, 4, 0);
		dataPanes[6].add(PHField, 5, 0);
		dataPanes[6].add(crudeAshLabel, 6, 0);
		dataPanes[6].add(crudeAshField, 7, 0);
		
		dataPanes[7].add(imfLabel, 0, 0);
		dataPanes[7].add(imfField, 1, 0);
		dataPanes[7].add(waterProportionLabel, 2, 0);
		dataPanes[7].add(getUnitBox(waterProportionField, "%"), 3, 0);
		dataPanes[7].add(crudeProteinLabel, 4, 0);
		dataPanes[7].add(getUnitBox(crudeProteinField, "%"), 5, 0);
		
		for (int i = 0; i < dataPanes.length; i++) {
			dataPane.add(dataPanes[i], 0, i);
		}
	}
	
	@Override
	protected void setLanguage(String languageName) {
		PigLanguage language = new PigLanguage();
		try {
			language = PigLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
			
		furtherColorCandidate = language.furtherColor;
		weightLabel.setText(language.weightLabel);
		bodyLengthLabel.setText(language.bodyLengthLabel);
		bodyHeightLabel.setText(language.bodyHeightLabel);
		bustLabel.setText(language.bustLabel);
		carcassWeightLabel.setText(language.carcassWeightLabel);
		slaughterRateLabel.setText(language.slaughterRateLabel);
		backfatThicknessOfAverageLabel.setText(language.backfatThicknessOfAverageLabel);
		backfatThicknessOfSixSevenLabel.setText(language.backfatThicknessOfSixSevenLabel);
		skinThicknessLabel.setText(language.skinThicknessLabel);
		musculiOculiLabel.setText(language.musculiOculiLabel);
		meatFactorLabel.setText(language.meatFactorLabel);
		furtherColorLabel.setText(language.furtherColorLabel);
		
		meatColorLabel.setText(language.meatColorLabel);
		marblingLabel.setText(language.marblingLabel);
		PHLabel.setText(language.PHLabel);
		crudeProteinLabel.setText(language.crudeProteinLabel);
		imfLabel.setText(language.imfLabel);
		waterProportionLabel.setText(language.waterProportionLabel);
		crudeAshLabel.setText(language.crudeAshLabel);
		
		initializeComboBox(furtherColorComboBox, furtherColorCandidate, false);
	}
	
	private void initializeNode() {
		initNode();
		
		setFieldWidth(80, weightField, bodyLengthField, bodyHeightField,
				bustField, carcassWeightField, slaughterRateField, 
				backfatThicknessOfAverageField, backfatThicknessOfSixSevenField,
				musculiOculiField, meatFactorField, PHField, crudeProteinField,
				imfField, waterProportionField, skinThicknessField);
		setFieldWidth(100, meatColorField, marblingField, crudeAshField);
		initializeComboBox(furtherColorComboBox, furtherColorCandidate, false);
		
		getIDCandidate("pig/data");
		
		getLanguageCandidate("language/pig");
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
				Pig pig = Pig.getData(id);
				showData(pig);
				
				JOptionPane.showMessageDialog(null, pig.getID() + status[2]);
				statusLabel.setText(pig.getID() + status[2]);
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
				Pig pig = getPig();
				Pig.writeData(pig);
				JOptionPane.showMessageDialog(null, pig.getID() + status[4]);
				statusLabel.setText(pig.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("pig/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Pig pig = getPig();
					Pig.writeData(pig);
					JOptionPane.showMessageDialog(null, pig.getID() + status[6]);
					statusLabel.setText(pig.getID() + status[6]);
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
			File idFile = new File("pig/data");
			File[] files = idFile.listFiles();
			Stage stage = new PigOutputStage(files);
		});

		
	}
	
	private Pig getPig() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		Pig pig = new Pig(id);
		
		pig.year = (int)yearComboBox.getValue();
		pig.month = (int)monthComboBox.getValue();
		pig.day = (int)dayComboBox.getValue();
		pig.country = countryComboBox.getValue();
		pig.province = provinceComboBox.getValue();
		pig.locality = localityField.getText();
		pig.latitude = getDouble(latitudeField);
		pig.longitude = getDouble(longitudeField);
		pig.species = speciesField.getText();
		pig.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		pig.age = getDouble(ageField);
		pig.furtherColor = furtherColorComboBox.getValue();
		pig.bodyLength = getDouble(bodyLengthField);
		pig.bodyHeight = getDouble(bodyHeightField);
		pig.bust = getDouble(bustField);
		pig.weight = getDouble(weightField);
		pig.carcassWeight = getDouble(carcassWeightField);
		pig.slaughterRate = getDouble(slaughterRateField);
		pig.backfatThicknessOfAverage = getDouble(backfatThicknessOfAverageField);
		pig.backfatThicknessOfSixSeven = getDouble(backfatThicknessOfSixSevenField);
		pig.skinThickness = getDouble(skinThicknessField);
		pig.musculiOculi = getDouble(musculiOculiField);
		pig.meatFactor = getDouble(meatFactorField);
		pig.meatColor = meatColorField.getText().trim();
		pig.marbling = marblingField.getText().trim();
		pig.PH = getDouble(PHField);
		pig.crudeAsh = getDouble(crudeAshField);
		pig.imf = getDouble(imfField);
		pig.waterProportion = getDouble(waterProportionField);
		pig.crudeProtein = getDouble(crudeProteinField);
		pig.comment = commentArea.getText();
		
		pig.setImageSrc(imageSrc);
		
		return pig;
	}
	
	private void showData(Pig pig) {
		yearComboBox.setValue(pig.year);
		monthComboBox.setValue(pig.month);
		dayComboBox.setValue(pig.day);
		countryComboBox.setValue(pig.country);
		provinceComboBox.setValue(pig.province);
		localityField.setText(pig.locality);
		latitudeField.setText(pig.latitude + "");
		longitudeField.setText(pig.longitude + "");
		speciesField.setText(pig.species);
		sexComboBox.setValue((pig.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(pig.getAge() + "");
		furtherColorComboBox.setValue(pig.furtherColor);
		bodyLengthField.setText(pig.bodyLength + "");
		bodyHeightField.setText(pig.bodyHeight + "");
		bustField.setText(pig.bust + "");
		weightField.setText(pig.weight + "");
		carcassWeightField.setText(pig.carcassWeight + "");
		slaughterRateField.setText(pig.slaughterRate + "");
		backfatThicknessOfAverageField.setText(pig.backfatThicknessOfAverage + "");
		backfatThicknessOfSixSevenField.setText(pig.backfatThicknessOfSixSeven + "");
		skinThicknessField.setText(pig.skinThickness + "");
		musculiOculiField.setText(pig.musculiOculi + "");
		meatFactorField.setText(pig.meatFactor + "");
		meatColorField.setText(pig.meatColor);
		marblingField.setText(pig.marbling); 
		PHField.setText(pig.PH + "");
		crudeAshField.setText(pig.crudeAsh + "");
		imfField.setText(pig.imf + "");
		waterProportionField.setText(pig.waterProportion + "");
		crudeProteinField.setText(pig.crudeProtein + "");
		commentArea.setText(pig.comment);
		
		imageSrc = pig.getImageSrc();
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
			
			output.print(furtherColorLabel.getText() + ": ");
			output.println(furtherColorComboBox.getValue());
			
			output.print(bodyLengthLabel.getText() + ": ");
			output.println(bodyLengthField.getText() + "cm");
			
			output.print(bodyHeightLabel.getText() + ": ");
			output.println(bodyHeightField.getText() + "cm");
			
			output.print(bustLabel.getText() + ": ");
			output.println(bustField.getText() + "cm");
			
			output.print(weightLabel.getText() + ": ");
			output.println(weightField.getText() + "kg");
			
			output.print(carcassWeightLabel.getText() + ": ");
			output.println(carcassWeightField.getText() + "kg");
			
			output.print(slaughterRateLabel.getText() + ": ");
			output.println(slaughterRateField.getText() + "%");
			
			output.print(backfatThicknessOfAverageLabel.getText() + ": ");
			output.println(backfatThicknessOfSixSevenField.getText() + "cm");
			
			output.print(backfatThicknessOfSixSevenLabel.getText() + ": ");
			output.println(backfatThicknessOfSixSevenField.getText() + "cm");

			output.print(skinThicknessLabel.getText() + ": ");
			output.println(skinThicknessField.getText() + "cm");
			
			output.print(musculiOculiLabel.getText() + ": ");
			output.println(musculiOculiField.getText() + "cm2");
			
			output.print(meatFactorLabel.getText() + ": ");
			output.println(meatFactorField.getText() + "%");
			
			output.print(meatColorLabel.getText() + ": ");
			output.println(meatColorField.getText());
			
			output.print(marblingLabel.getText() + ": ");
			output.println(marblingField.getText());
			
			output.print(PHLabel.getText() + ": ");
			output.println(PHField.getText());
			
			output.print(crudeAshLabel.getText() + ": ");
			output.println(crudeAshField.getText());
			
			output.print(imfLabel.getText() + ": ");
			output.println(imfField.getText());
			
			output.print(waterProportionLabel.getText() + ": ");
			output.println(waterProportionField.getText());
			
			output.print(crudeProteinLabel.getText() + ": ");
			output.println(crudeProteinField.getText() + "%");
			
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
		Pig pig = getPig();
		
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
			output.print(furtherColorLabel.getText() + "\t");
			output.print(bodyLengthLabel.getText() + "cm\t");
			output.print(bodyHeightLabel.getText() + "cm\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(weightLabel.getText() + "kg\t");
			output.print(carcassWeightLabel.getText() + "kg\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(backfatThicknessOfAverageLabel.getText() + "cm\t");
			output.print(backfatThicknessOfSixSevenLabel.getText() + "cm\t");
			output.print(skinThicknessLabel.getText() + "cm\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(meatFactorLabel.getText() + "%\t");
			output.print(meatColorLabel.getText() + "\t");
			output.print(marblingLabel.getText() + "\t");
			output.print(PHLabel.getText() + "\t");
			output.print(crudeAshLabel.getText() + "\t");
			output.print(imfLabel.getText() + "\t");
			output.print(waterProportionLabel.getText() + "\t");
			output.print(crudeProteinLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			output.print(pig.getID() + "\t");
			output.print(pig.year + dateLabels[1].getText());
			output.print(pig.month + dateLabels[2].getText());
			output.print(pig.day + dateLabels[3].getText() + "\t");
			output.print(pig.species + "\t");
			output.print(pig.country + pig.province + "\t");
			output.print(pig.locality + "\t");
			output.print(pig.latitude + "\t");
			output.print(pig.longitude + "\t");
			output.print((pig.sex ? "male" : "female") + "\t");
			output.print(pig.age + "\t");
			output.print(pig.furtherColor + "\t");
			output.print(pig.bodyLength + "\t");
			output.print(pig.bodyHeight + "\t");
			output.print(pig.bust + "\t");
			output.print(pig.weight + "\t");
			output.print(pig.carcassWeight + "\t");
			output.print(pig.slaughterRate + "\t");
			output.print(pig.backfatThicknessOfAverage + "\t");
			output.print(pig.backfatThicknessOfSixSeven + "\t");
			output.print(pig.skinThickness + "\t");
			output.print(pig.meatFactor + "\t");
			output.print(pig.meatColor + "\t");
			output.print(pig.marbling + "\t");
			output.print(pig.PH + "\t");
			output.print(pig.crudeAsh + "\t");
			output.print(pig.imf + "\t");
			output.print(pig.waterProportion + "\t");
			output.print(pig.crudeProtein + "\t");
			output.println(pig.comment + "\t");

			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Pig> pigs) {
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
			output.print(furtherColorLabel.getText() + "\t");
			output.print(bodyLengthLabel.getText() + "cm\t");
			output.print(bodyHeightLabel.getText() + "cm\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(weightLabel.getText() + "kg\t");
			output.print(carcassWeightLabel.getText() + "kg\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(backfatThicknessOfAverageLabel.getText() + "cm\t");
			output.print(backfatThicknessOfSixSevenLabel.getText() + "cm\t");
			output.print(skinThicknessLabel.getText() + "cm\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(meatFactorLabel.getText() + "%\t");
			output.print(meatColorLabel.getText() + "\t");
			output.print(marblingLabel.getText() + "\t");
			output.print(PHLabel.getText() + "\t");
			output.print(crudeAshLabel.getText() + "\t");
			output.print(imfLabel.getText() + "\t");
			output.print(waterProportionLabel.getText() + "\t");
			output.print(crudeProteinLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			for (Pig pig : pigs) {
				output.print(pig.getID() + "\t");
				output.print(pig.year + dateLabels[1].getText());
				output.print(pig.month + dateLabels[2].getText());
				output.print(pig.day + dateLabels[3].getText() + "\t");
				output.print(pig.species + "\t");
				output.print(pig.country + pig.province + "\t");
				output.print(pig.locality + "\t");
				output.print(pig.latitude + "\t");
				output.print(pig.longitude + "\t");
				output.print((pig.sex ? "male" : "female") + "\t");
				output.print(pig.age + "\t");
				output.print(pig.furtherColor + "\t");
				output.print(pig.bodyLength + "\t");
				output.print(pig.bodyHeight + "\t");
				output.print(pig.bust + "\t");
				output.print(pig.weight + "\t");
				output.print(pig.carcassWeight + "\t");
				output.print(pig.slaughterRate + "\t");
				output.print(pig.backfatThicknessOfAverage + "\t");
				output.print(pig.backfatThicknessOfSixSeven + "\t");
				output.print(pig.skinThickness + "\t");
				output.print(pig.meatFactor + "\t");
				output.print(pig.meatColor + "\t");
				output.print(pig.marbling + "\t");
				output.print(pig.PH + "\t");
				output.print(pig.crudeAsh + "\t");
				output.print(pig.imf + "\t");
				output.print(pig.waterProportion + "\t");
				output.print(pig.crudeProtein + "\t");
				output.println(pig.comment + "\t");
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
	
	private class PigOutputStage extends OutputStage {
		
		protected PigOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Pig> pigs = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							pigs.add(Pig.getData(id));
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
				OutputFiles(file.getPath(), pigs);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
		
	}
}
