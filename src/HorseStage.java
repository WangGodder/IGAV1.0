/**
 * @author ������ 
 * @date : 2017��7��18�� ����1:05:44
 */
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Animal.Horse;
import Language.HorseLanguage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HorseStage extends StageModel {
	private String[] furtherColorCandidate;
	private final ComboBox<String> furtherColorComboBox = new ComboBox<>();
	
	private final TextField weightField = new TextField();
	private final TextField bodyLengthField = new TextField();
	private final TextField bodyHeightField = new TextField();
	private final TextField bodyLengthExponentField = new TextField();
	private final TextField bustField = new TextField();
	private final TextField bustExponentField = new TextField();
	private final TextField cannonField = new TextField();
	private final TextField cannonExponentField = new TextField();
	private final TextField slaughterRateField = new TextField();
	private final TextField carcassMeatFactorField = new TextField();
	private final TextField meatBoneRatioField = new TextField();
	private final TextField musculiOculiField = new TextField();
	private final TextField legMuscleThicknessField = new TextField();
	private final TextField waistMuscleThicknessField = new TextField();
	private final TextField legFatThicknessField = new TextField();
	private final TextField waistFatThicknessField = new TextField();
	
	private final Label furtherColorLabel = new Label("ëɫ");
	private Label weightLabel = new Label("����");
	private Label bodyLengthLabel = new Label("�峤");
	private Label bodyHeightLabel = new Label("���");
	private Label bodyLengthExponentLabel = new Label("�峤ָ��");
	private Label bustLabel = new Label("��Χ");
	private Label bustExponentLabel = new Label("��Χָ��");
	private Label cannonLabel = new Label("��Χ");
	private Label cannonExponentLabel = new Label("��Χָ��");
	private Label slaughterRateLabel = new Label("������");
	private Label carcassMeatFactorLabel = new Label("���徻����");
	private Label meatBoneRatioLabel = new Label("�����");
	private Label musculiOculiLabel = new Label("�ۼ����");
	private Label legMuscleThicknessLabel = new Label("�ȼ����");
	private Label waistMuscleThicknessLabel = new Label("�������");
	private Label legFatThicknessLabel = new Label("��֬����");
	private Label waistFatThicknessLabel = new Label("��֬����");
	
	public HorseStage(Stage mainStage) {
		super(mainStage);
		stage.setTitle("Horse/Donkey Register");
		
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

		dataPanes[1].add(localityLabels[0], 0, 0); // �ɼ�����
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
		dataPanes[3].add(bodyHeightLabel, 2, 0);
		dataPanes[3].add(getUnitBox(bodyHeightField, "cm"), 3, 0);
		dataPanes[3].add(bodyLengthExponentLabel, 4, 0);
		dataPanes[3].add(bodyLengthExponentField, 5, 0);
		dataPanes[3].add(weightLabel, 6, 0);
		dataPanes[3].add(getUnitBox(weightField, "kg"), 7, 0);
		
		dataPanes[4].add(bustLabel, 0, 0);
		dataPanes[4].add(getUnitBox(bustField, "cm"),  1, 0);
		dataPanes[4].add(bustExponentLabel, 2, 0);
		dataPanes[4].add(bustExponentField, 3, 0);
		dataPanes[4].add(cannonLabel, 4, 0);
		dataPanes[4].add(getUnitBox(cannonField, "cm"), 5, 0);
		dataPanes[4].add(cannonExponentLabel, 6, 0);
		dataPanes[4].add(cannonExponentField, 7, 0);
		
		dataPanes[5].add(slaughterRateLabel, 0, 0);
		dataPanes[5].add(getUnitBox(slaughterRateField, "%"), 1, 0);
		dataPanes[5].add(carcassMeatFactorLabel, 2, 0);
		dataPanes[5].add(getUnitBox(carcassMeatFactorField, "%"), 3, 0);
		dataPanes[5].add(meatBoneRatioLabel, 4, 0);
		dataPanes[5].add(getUnitBox(meatBoneRatioField, "%"), 5, 0);
		
		dataPanes[6].add(legMuscleThicknessLabel, 0, 0);
		dataPanes[6].add(getUnitBox(legMuscleThicknessField, "mm"), 1, 0);
		dataPanes[6].add(waistMuscleThicknessLabel, 2, 0);
		dataPanes[6].add(getUnitBox(waistMuscleThicknessField, "mm"), 3, 0);
		dataPanes[6].add(musculiOculiLabel, 4, 0);
		dataPanes[6].add(getUnitBox(musculiOculiField, "cm2"),  5, 0);
		
		dataPanes[7].add(legFatThicknessLabel, 0, 0);
		dataPanes[7].add(getUnitBox(legFatThicknessField, "mm"), 1, 0);
		dataPanes[7].add(waistFatThicknessLabel, 2, 0);
		dataPanes[7].add(getUnitBox(waistFatThicknessField, "mm"), 3, 0);
		
		for (int i = 0; i < dataPanes.length; i++) {
			dataPane.add(dataPanes[i], 0, i);
		}
	}
	
	@Override
	protected void setLanguage(String languageName) {
		HorseLanguage language = new HorseLanguage();
		try {
			language = HorseLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
		
		furtherColorCandidate = language.furtherColorCandidate;
		furtherColorLabel.setText(language.furtherColorLabel);
		weightLabel.setText(language.weightLabel);
		bodyLengthLabel.setText(language.bodyLengthLabel);
		bodyHeightLabel.setText(language.bodyHeigthLabel);
		bodyLengthExponentLabel.setText(language.bodyLengthExponentLabel);
		bustLabel.setText(language.bustLabel);
		bustExponentLabel.setText(language.bustExponentLabel);
		cannonLabel.setText(language.cannonLabel);
		cannonExponentLabel.setText(language.cannonExponentLabel);
		slaughterRateLabel.setText(language.slaughterRateLabel);
		carcassMeatFactorLabel.setText(language.carcassMeatFactorLabel);
		meatBoneRatioLabel.setText(language.meatBoneRatioLabel);
		musculiOculiLabel.setText(language.musculiOculiLabel);
		legMuscleThicknessLabel.setText(language.legMuscleThicknessLabel);
		waistMuscleThicknessLabel.setText(language.waistMuscleThicknessLabel);
		legFatThicknessLabel.setText(language.legFatThicknessLabel);
		waistFatThicknessLabel.setText(language.waistFatThicknessLabel);
		
		initializeComboBox(furtherColorComboBox, furtherColorCandidate, false);
	}
	
	private void initializeNode() {
		initNode();
		
		setFieldWidth(80, weightField, bodyLengthField, bodyHeightField, 
				bodyLengthExponentField, bustField, bustExponentField, 
				cannonField, cannonExponentField, slaughterRateField, 
				carcassMeatFactorField, meatBoneRatioField, 
				musculiOculiField, legMuscleThicknessField, waistMuscleThicknessField,  
				legFatThicknessField, waistFatThicknessField);
		
		initializeComboBox(furtherColorComboBox, furtherColorCandidate, false);
		
		getIDCandidate("horse/data");
		
		getLanguageCandidate("language/horse");
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
				Horse horse = Horse.getData(id);
				showData(horse);
				
				JOptionPane.showMessageDialog(null, horse.getID() + status[2]);
				statusLabel.setText(horse.getID() + status[2]);
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
				Horse horse = getHorse();
				Horse.writeData(horse);
				JOptionPane.showMessageDialog(null, horse.getID() + status[4]);
				statusLabel.setText(horse.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("horse/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Horse horse = getHorse();
					Horse.writeData(horse);
					JOptionPane.showMessageDialog(null, horse.getID() + status[6]);
					statusLabel.setText(horse.getID() + status[6]);
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
			File idFile = new File("horse/data");
			File[] files = idFile.listFiles();
			Stage stage = new HorseOutputStage(files);
		});

	}
	
	private Horse getHorse() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		Horse horse = new Horse(id);
		
		horse.year = (int)yearComboBox.getValue();
		horse.month = (int)monthComboBox.getValue();
		horse.day = (int)dayComboBox.getValue();
		horse.country = countryComboBox.getValue();
		horse.province = provinceComboBox.getValue();
		horse.locality = localityField.getText();
		horse.latitude = getDouble(latitudeField);
		horse.longitude = getDouble(longitudeField);
		horse.species = speciesField.getText();
		horse.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		horse.age = getDouble(ageField);
		horse.furtherColor = furtherColorComboBox.getValue();
		horse.bodyLength = getDouble(bodyLengthField);
		horse.bodyHeight = getDouble(bodyHeightField);
		horse.bodyLengthExponent = getDouble(bodyLengthExponentField);
		horse.weigth = getDouble(weightField);
		horse.bust = getDouble(bustField);
		horse.bustExponent = getDouble(bustExponentField);
		horse.cannon = getDouble(cannonField);
		horse.cannonExponent = getDouble(cannonExponentField);
		horse.slaughterRate = getDouble(slaughterRateField);
		horse.carcassMeatFactor = getDouble(carcassMeatFactorField);
		horse.meatBoneRatio = getDouble(meatBoneRatioField);
		horse.musculiOculi = getDouble(musculiOculiField);
		horse.legMuscleThickness = getDouble(legMuscleThicknessField);
		horse.waistMuscleThickness = getDouble(waistMuscleThicknessField);
		horse.legFatThickness = getDouble(legFatThicknessField);
		horse.waistFatThickness = getDouble(waistFatThicknessField);
		horse.comment = commentArea.getText();
		horse.setImageSrc(imageSrc);
		
		return horse;
	}
	
	private void showData(Horse horse) {
		yearComboBox.setValue(horse.year);
		monthComboBox.setValue(horse.month);
		dayComboBox.setValue(horse.day);
		countryComboBox.setValue(horse.country);
		provinceComboBox.setValue(horse.province);
		localityField.setText(horse.locality);
		latitudeField.setText(horse.latitude + "");
		longitudeField.setText(horse.longitude + "");
		speciesField.setText(horse.species);
		sexComboBox.setValue((horse.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(horse.getAge() + "");
		furtherColorComboBox.setValue(horse.furtherColor);
		bodyLengthField.setText(horse.bodyLength + "");
		bodyHeightField.setText(horse.bodyHeight + "");
		bodyLengthExponentField.setText(horse.bodyLengthExponent + "");
		weightField.setText(horse.weigth + "");
		bustField.setText(horse.bust + "");
		bustExponentField.setText(horse.bustExponent + "");
		cannonField.setText(horse.cannon + "");
		cannonExponentField.setText(horse.cannonExponent + "");
		slaughterRateField.setText(horse.slaughterRate + "");
		carcassMeatFactorField.setText(horse.carcassMeatFactor + "");
		meatBoneRatioField.setText(horse.meatBoneRatio + "");
		musculiOculiField.setText(horse.musculiOculi + "");
		legMuscleThicknessField.setText(horse.legMuscleThickness + "");
		waistMuscleThicknessField.setText(horse.waistMuscleThickness + "");
		legFatThicknessField.setText(horse.legFatThickness + "");
		waistMuscleThicknessField.setText(horse.waistFatThickness + "");
		commentArea.setText(horse.comment);
		
		imageSrc = horse.getImageSrc();
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
			
			output.print(bodyLengthExponentLabel.getText() + ": ");
			output.println(bodyLengthExponentField.getText());
			
			output.print(weightLabel.getText() + ": ");
			output.println(weightField.getText() + "kg");
			
			output.print(bustLabel.getText() + ": ");
			output.println(bustField.getText() + "cm");
			
			output.print(bustExponentLabel.getText() + ": ");
			output.println(bustExponentField.getText());
			
			output.print(cannonLabel.getText() + ": ");
			output.println(cannonField.getText() + "cm");
			
			output.print(cannonExponentField.getText() + ": ");
			output.println(cannonExponentField.getText());
			
			output.print(slaughterRateLabel.getText() + ": ");
			output.println(slaughterRateField.getText() + "%");
			
			output.print(carcassMeatFactorLabel.getText() + ": ");
			output.println(carcassMeatFactorField.getText() + "%");
			
			output.print(meatBoneRatioLabel.getText() + ": ");
			output.println(meatBoneRatioField.getText() + "%");
			
			output.print(musculiOculiLabel.getText() + ": ");
			output.println(musculiOculiField.getText() + "cm2");
			
			output.print(legMuscleThicknessLabel.getText() + ": ");
			output.println(legMuscleThicknessField.getText() + "mm");
			
			output.print(waistMuscleThicknessLabel.getText() + ": ");
			output.println(waistMuscleThicknessField.getText() + "mm");
			
			output.print(legFatThicknessLabel.getText() + ": ");
			output.println(legFatThicknessField.getText() + "mm");
			
			output.print(waistFatThicknessLabel.getText() + ": ");
			output.println(waistFatThicknessField.getText() + "mm");

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
		Horse horse = getHorse();
		
		try {
			PrintWriter output = new PrintWriter(src + "/" + idComboBox.getValue() + "output" + times + ".txt");
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
			output.print(bodyLengthExponentLabel.getText() + "\t");
			output.print(weightLabel.getText() + "kg\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(bustExponentLabel.getText() + "\t");
			output.print(cannonLabel.getText() + "cm\t");
			output.print(cannonExponentLabel.getText() + "\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(carcassMeatFactorLabel.getText() + "%\t");
			output.print(meatBoneRatioLabel.getText() + "%\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(legMuscleThicknessLabel.getText() + "mm\t");
			output.print(waistMuscleThicknessLabel.getText() + "mm\t");
			output.print(legFatThicknessLabel.getText() + "mm\t");
			output.print(waistFatThicknessLabel.getText() + "mm\t");
			output.println(commentLabel.getText());
			
			output.print(horse.getID() + "\t");
			output.print(horse.year + dateLabels[1].getText());
			output.print(horse.month + dateLabels[2].getText());
			output.print(horse.day + dateLabels[3].getText() + "\t");
			output.print(horse.species + "\t");
			output.print(horse.country + horse.province + "\t");
			output.print(horse.locality + "\t");
			output.print(horse.latitude + "\t");
			output.print(horse.longitude + "\t");
			output.print((horse.sex ? "male" : "female") + "\t");
			output.print(horse.age + "\t");
			output.print(horse.furtherColor + "\t");
			output.print(horse.bodyLength + "\t");
			output.print(horse.bodyHeight + "\t");
			output.print(horse.bodyLengthExponent + "\t");
			output.print(horse.weigth + "\t");
			output.print(horse.bust + "\t");
			output.print(horse.bustExponent + "\t");
			output.print(horse.cannon + "\t");
			output.print(horse.cannonExponent + "\t");
			output.print(horse.slaughterRate + "\t");
			output.print(horse.carcassMeatFactor + "\t");
			output.print(horse.meatBoneRatio + "\t");
			output.print(horse.musculiOculi + "\t");
			output.print(horse.legMuscleThickness + "\t");
			output.print(horse.waistMuscleThickness + "\t");
			output.print(horse.legFatThickness + "\t");
			output.print(horse.waistFatThickness + "\t");
			output.println(horse.comment);
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Horse> horses) {
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
			output.print(bodyLengthExponentLabel.getText() + "\t");
			output.print(weightLabel.getText() + "kg\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(bustExponentLabel.getText() + "\t");
			output.print(cannonLabel.getText() + "cm\t");
			output.print(cannonExponentLabel.getText() + "\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(carcassMeatFactorLabel.getText() + "%\t");
			output.print(meatBoneRatioLabel.getText() + "%\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(legMuscleThicknessLabel.getText() + "mm\t");
			output.print(waistMuscleThicknessLabel.getText() + "mm\t");
			output.print(legFatThicknessLabel.getText() + "mm\t");
			output.print(waistFatThicknessLabel.getText() + "mm\t");
			output.println(commentLabel.getText());
			 
			for (Horse horse : horses) {
				output.print(horse.getID() + "\t");
				output.print(horse.year + dateLabels[1].getText());
				output.print(horse.month + dateLabels[2].getText());
				output.print(horse.day + dateLabels[3].getText() + "\t");
				output.print(horse.species + "\t");
				output.print(horse.country + horse.province + "\t");
				output.print(horse.locality + "\t");
				output.print(horse.latitude + "\t");
				output.print(horse.longitude + "\t");
				output.print((horse.sex ? "male" : "female") + "\t");
				output.print(horse.age + "\t");
				output.print(horse.furtherColor + "\t");
				output.print(horse.bodyLength + "\t");
				output.print(horse.bodyHeight + "\t");
				output.print(horse.bodyLengthExponent + "\t");
				output.print(horse.weigth + "\t");
				output.print(horse.bust + "\t");
				output.print(horse.bustExponent + "\t");
				output.print(horse.cannon + "\t");
				output.print(horse.cannonExponent + "\t");
				output.print(horse.slaughterRate + "\t");
				output.print(horse.carcassMeatFactor + "\t");
				output.print(horse.meatBoneRatio + "\t");
				output.print(horse.musculiOculi + "\t");
				output.print(horse.legMuscleThickness + "\t");
				output.print(horse.waistMuscleThickness + "\t");
				output.print(horse.legFatThickness + "\t");
				output.print(horse.waistFatThickness + "\t");
				output.println(horse.comment);
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
	
	private class HorseOutputStage extends OutputStage {
		
		protected HorseOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Horse> horses = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							horses.add(Horse.getData(id));
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
				OutputFiles(file.getPath(), horses);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
		
	}
}
