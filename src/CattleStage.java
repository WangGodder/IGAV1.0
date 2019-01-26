/**
 * @author ������ 
 * @date : 2017��7��17�� ����2:58:38
 */
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Animal.Cattle;
import Language.CattleLanguage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CattleStage extends StageModel {
	private String[] furtherColorCandidate;
	private String[] cavelCandidate;
	private String[] acromionCandidate;
	
	private final TextField weightField = new TextField();
	private final TextField bodyLengthField = new TextField();
	private final TextField bodyHeightField = new TextField();
	private final TextField bodyDipLengthField = new TextField();
	private final TextField bustField = new TextField();
	private final TextField cannonField = new TextField();
	
	private final TextField killWeightField = new TextField();
	private final TextField carcassWeightField = new TextField();
	private final TextField pureMeatField = new TextField();
	private final TextField skinThicknessField = new TextField();
	private final TextField skeletonWeightField = new TextField();
	private final TextField musculiOculiField = new TextField();
	private final TextField slaughterRateField = new TextField();
	private final TextField meatBoneRatioField = new TextField();
	
	private final ComboBox<String> furtherComboBox = new ComboBox<>();
	private final ComboBox<String> cavelComboBox = new ComboBox<>();
	private final ComboBox<String> acromionComboBox = new ComboBox<>();
	
	private Label weightLabel = new Label("����");
	private Label bodyLengthLabel = new Label("�峤");
	private Label bodyHeightLabel = new Label("���");
	private Label bodyDipLengthLabel = new Label("б���");
	private Label bustLabel = new Label("��Χ");
	private Label cannonLabel = new Label("��Χ");
	
	private Label killWeightLabel = new Label("��ǰ������");
	private Label carcassWeightLabel = new Label("������");
	private Label pureMeatLabel = new Label("������");
	private Label skinThicknessLabel = new Label("Ƥ��");
	private Label skeletonWeightLabel = new Label("������");
	private Label musculiOculiLabel = new Label("�ۼ����");
	private Label slaughterRateLabel = new Label("������");
	private Label meatBoneRatioLabel = new Label("��Ǳ�");
	private Label furtherColorLabel = new Label("ëɫ");
	private Label cavelLabel = new Label("ţ��");
	private Label acromionLabel = new Label("���");

	public CattleStage(Stage mainStage) {
		super(mainStage);
		stage.setTitle("Cattle Register");
		
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
		dataPanes[2].add(cavelLabel, 4, 0);
		dataPanes[2].add(cavelComboBox, 5, 0);
		dataPanes[2].add(acromionLabel, 6, 0);
		dataPanes[2].add(acromionComboBox, 7, 0);
		
		HBox bodyLengthBox = getUnitBox(bodyLengthField, "cm");
		HBox bodyHeightBox = getUnitBox(bodyHeightField, "cm");
		HBox bodyDipLengthBox = getUnitBox(bodyDipLengthField, "cm");	
		
		dataPanes[3].add(bodyLengthLabel, 0, 0);
		dataPanes[3].add(bodyLengthBox, 1, 0);
		dataPanes[3].add(bodyHeightLabel, 2, 0);
		dataPanes[3].add(bodyHeightBox, 3, 0);
		dataPanes[3].add(bodyDipLengthLabel, 4, 0);
		dataPanes[3].add(bodyDipLengthBox, 5, 0);
		dataPanes[3].add(furtherColorLabel, 6, 0);
		dataPanes[3].add(furtherComboBox, 7, 0);
		
		HBox bustBox = getUnitBox(bustField, "cm");	
		HBox cannonBox = getUnitBox(cannonField, "cm");
		HBox weightBox = getUnitBox(weightField, "kg");

		dataPanes[4].add(bustLabel, 0, 0);
		dataPanes[4].add(bustBox, 1, 0);
		dataPanes[4].add(cannonLabel, 2, 0);
		dataPanes[4].add(cannonBox, 3, 0);
		
		dataPanes[4].add(killWeightLabel, 4, 0);
		dataPanes[4].add(getUnitBox(killWeightField, "kg"), 5, 0);
		
		dataPanes[5].add(carcassWeightLabel, 0, 0);
		dataPanes[5].add(getUnitBox(carcassWeightField, "kg"), 1, 0);
		dataPanes[5].add(pureMeatLabel, 2, 0);
		dataPanes[5].add(getUnitBox(pureMeatField, "%"), 3, 0);
		dataPanes[5].add(skinThicknessLabel, 4, 0);
		dataPanes[5].add(getUnitBox(skinThicknessField, "cm"), 5, 0);
		
		dataPanes[6].add(weightLabel, 0, 0);
		dataPanes[6].add(weightBox, 1, 0);
		dataPanes[6].add(skeletonWeightLabel, 2, 0);
		dataPanes[6].add(getUnitBox(skeletonWeightField, "kg"), 3, 0);
		dataPanes[6].add(musculiOculiLabel, 4, 0);
		dataPanes[6].add(getUnitBox(musculiOculiField, "cm2"), 5, 0);
		
		dataPanes[7].add(slaughterRateLabel, 0, 0);
		dataPanes[7].add(getUnitBox(slaughterRateField, "%"), 1, 0);
		dataPanes[7].add(meatBoneRatioLabel, 2, 0);
		dataPanes[7].add(getUnitBox(meatBoneRatioField, "%"), 3, 0);
		

		for (int i = 0; i < dataPanes.length; i++) {
			dataPane.add(dataPanes[i], 0, i);
		}
	}
	
	@Override
	protected void setLanguage(String languageName) {
		CattleLanguage language = new CattleLanguage();
		try	{
			language = CattleLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
		
		furtherColorCandidate = language.furtherColorCandidate;
		cavelCandidate = language.cavelCandidate;
		acromionCandidate = language.cavelCandidate;
		
		weightLabel.setText(language.weightLabel);
		bodyLengthLabel.setText(language.bodyLengthLabel);
		bodyHeightLabel.setText(language.bodyHeightLabel);
		bodyDipLengthLabel.setText(language.bodyDipLengthLabel);
		bustLabel.setText(language.bustLabel);
		cannonLabel.setText(language.cannonLabel);
		killWeightLabel.setText(language.killWeightLabel);
		carcassWeightLabel.setText(language.carcassWeightLabel);
		pureMeatLabel.setText(language.pureMeatLabel);
		skinThicknessLabel.setText(language.skinThicknessLabel);
		skeletonWeightLabel.setText(language.skeletonWeightLabel);
		musculiOculiLabel.setText(language.musculiOculiLabel);
		slaughterRateLabel.setText(language.slaughterRateLabel);
		meatBoneRatioLabel.setText(language.meatBoneRatioLabel);
		furtherColorLabel.setText(language.furtherColorLabel);
		cavelLabel.setText(language.cavelLabel);
		acromionLabel.setText(language.acromionLabel);
		
		initializeComboBox();
	}
	
	private void initializeNode() {
		initNode();

		setFieldWidth(80, bodyLengthField, bodyHeightField, bodyDipLengthField,
				bustField, weightField, cannonField, killWeightField,
				carcassWeightField, pureMeatField, skinThicknessField, skeletonWeightField,
				musculiOculiField, slaughterRateField, meatBoneRatioField);
		initializeComboBox();
		
		getIDCandidate("cattle/data");
		
		getLanguageCandidate("language/cattle");

	}
	
	private void initializeComboBox() {
		initializeComboBox(furtherComboBox, furtherColorCandidate, false);
		initializeComboBox(cavelComboBox, cavelCandidate, false);
		initializeComboBox(acromionComboBox, acromionCandidate, false);
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
				Cattle cattle = Cattle.getData(id);
				showData(cattle);
				
				JOptionPane.showMessageDialog(null, cattle.getID() + status[2]);
				statusLabel.setText(cattle.getID() + status[2]);
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
				Cattle cattle = getCattle();
				Cattle.writeData(cattle);
				JOptionPane.showMessageDialog(null, cattle.getID() + status[4]);
				statusLabel.setText(cattle.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("cattle/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Cattle cattle = getCattle();
					Cattle.writeData(cattle);
					JOptionPane.showMessageDialog(null, cattle.getID() + status[6]);
					statusLabel.setText(cattle.getID() + status[6]);
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
			File idFile = new File("cattle/data");
			File[] files = idFile.listFiles();
			Stage stage = new CattleOutputStage(files);
		});

	}
	
	private Cattle getCattle() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		Cattle cattle = new Cattle(id);
		
		cattle.year = (int)yearComboBox.getValue();
		cattle.month = (int)monthComboBox.getValue();
		cattle.day = (int)dayComboBox.getValue();
		cattle.country = countryComboBox.getValue();
		cattle.province = provinceComboBox.getValue();
		cattle.locality = localityField.getText();
		cattle.latitude = getDouble(latitudeField);
		cattle.longitude = getDouble(longitudeField);
		cattle.species = speciesField.getText();
		cattle.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		cattle.age = getDouble(ageField);
		cattle.comment = commentArea.getText();
		cattle.setImageSrc(imageSrc);
		
		cattle.furtherColor = furtherComboBox.getValue();
		cattle.cavel = cavelComboBox.getValue();
		cattle.acromion = acromionComboBox.getValue();
		cattle.weight = getDouble(weightField);
		cattle.bodyLength = getDouble(bodyLengthField);
		cattle.bodyHeight = getDouble(bodyHeightField);
		cattle.bodyDipLength = getDouble(bodyDipLengthField);
		cattle.bust = getDouble(bustField);
		cattle.cannon = getDouble(cannonField);
		cattle.killWeight = getDouble(killWeightField);
		cattle.carcassWeight = getDouble(carcassWeightField);
		cattle.pureMeat = getDouble(pureMeatField);
		cattle.skinThickness = getDouble(skinThicknessField);
		cattle.skeletonWeight = getDouble(skeletonWeightField);
		cattle.musculiOculi = getDouble(musculiOculiField);
		cattle.slaughterRate = getDouble(slaughterRateField);
		cattle.meatBoneRatio = getDouble(meatBoneRatioField);
		
		return cattle;
	}
	
	private void showData(Cattle cattle) {
		yearComboBox.setValue(cattle.year);
		monthComboBox.setValue(cattle.month);
		dayComboBox.setValue(cattle.day);
		countryComboBox.setValue(cattle.country);
		provinceComboBox.setValue(cattle.province);
		localityField.setText(cattle.locality);
		latitudeField.setText(cattle.latitude + "");
		longitudeField.setText(cattle.longitude + "");
		speciesField.setText(cattle.species);
		sexComboBox.setValue((cattle.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(cattle.getAge() + "");
		commentArea.setText(cattle.comment);
		
		furtherComboBox.setValue(cattle.furtherColor);
		cavelComboBox.setValue(cattle.cavel);
		acromionComboBox.setValue(cattle.acromion);
		weightField.setText(cattle.weight + "");
		bodyLengthField.setText(cattle.bodyLength + "");
		bodyHeightField.setText(cattle.bodyHeight + "");
		bodyDipLengthField.setText(cattle.bodyDipLength  + "");
		bustField.setText(cattle.bust + "");
		cannonField.setText(cattle.cannon + "");
		killWeightField.setText(cattle.killWeight + "");
		carcassWeightField.setText(cattle.carcassWeight + "");
		pureMeatField.setText(cattle.pureMeat + "");
		skinThicknessField.setText(cattle.skinThickness + "");
		skeletonWeightField.setText(cattle.skeletonWeight + "");
		musculiOculiField.setText(cattle.musculiOculi + "");
		slaughterRateField.setText(cattle.slaughterRate + "");
		meatBoneRatioField.setText(cattle.meatBoneRatio + "");
		
		
		imageSrc = cattle.getImageSrc();
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
			
			output.print(cavelLabel.getText() + ": ");
			output.println(cavelComboBox.getValue());
			
			output.print(acromionLabel.getText() + ": ");
			output.println(acromionComboBox.getValue());
			
			output.print(furtherColorLabel.getText() + ": ");
			output.println(furtherComboBox.getValue());
			
			output.print(weightLabel.getText() + ": ");
			output.println(weightField.getText() + "kg");
			
			output.print(bodyLengthLabel.getText() + ": ");
			output.println(bodyLengthField.getText() + "cm");
			
			output.print(bodyHeightLabel.getText() + ": ");
			output.println(bodyHeightField.getText() + "cm");
			
			output.print(bodyDipLengthLabel.getText() + ": ");
			output.println(bodyDipLengthField.getText() + "cm");
			
			output.print(bustLabel.getText() + ": ");
			output.println(bustField.getText() + "cm");
			
			output.print(cannonLabel.getText() + ": ");
			output.println(cannonField.getText() + "cm");
			
			output.print(killWeightLabel.getText() + ": ");
			output.println(killWeightField.getText() + "kg");
			
			output.print(carcassWeightLabel.getText() + ": ");
			output.println(carcassWeightField.getText() + "kg");
			
			output.print(pureMeatLabel.getText() + ": ");
			output.println(pureMeatField.getText() + "%");
			
			output.print(skinThicknessLabel.getText() + ": ");
			output.println(skinThicknessField.getText() + "cm");
			
			output.print(skeletonWeightLabel.getText() + ": ");
			output.println(skeletonWeightField.getText() + "kg");
			
			output.print(musculiOculiLabel.getText() + ": ");
			output.println(musculiOculiField.getText() + "cm2");
			
			output.print(slaughterRateLabel.getText() + ": ");
			output.println(slaughterRateField.getText() + "%");
			
			output.print(meatBoneRatioLabel.getText() + ": ");
			output.println(meatBoneRatioField.getText() + "%");

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
		Cattle cattle = getCattle();
		
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
			output.print(cavelLabel.getText() + "\t");
			output.print(acromionLabel.getText() + "\t");
			output.print(furtherColorLabel.getText() + "\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bodyLengthLabel.getText() + "cm\t");
			output.print(bodyHeightLabel.getText() + "cm\t");
			output.print(bodyDipLengthLabel.getText() + "cm\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(cannonLabel.getText() + "cm\t");
			output.print(killWeightLabel.getText() + "kg\t");
			output.print(carcassWeightLabel.getText() + "kg\t");
			output.print(pureMeatLabel.getText() + "%\t");
			output.print(skinThicknessLabel.getText() + "cm\t");
			output.print(skeletonWeightLabel.getText() + "kg\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(meatBoneRatioLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			output.print(cattle.getID() + "\t");
			output.print(cattle.year + dateLabels[1].getText());
			output.print(cattle.month + dateLabels[2].getText());
			output.print(cattle.day + dateLabels[3].getText() + "\t");
			output.print(cattle.species + "\t");
			output.print(cattle.country + cattle.province + "\t");
			output.print(cattle.locality + "\t");
			output.print(cattle.latitude + "\t");
			output.print(cattle.longitude + "\t");
			output.print((cattle.sex ? "male" : "female") + "\t");
			output.print(cattle.age + "\t");
			output.print(cattle.cavel + "\t");
			output.print(cattle.acromion + "\t");
			output.print(cattle.furtherColor + "\t");
			output.print(cattle.weight + "\t");
			output.print(cattle.bodyLength + "\t");
			output.print(cattle.bodyHeight + "\t");
			output.print(cattle.bodyDipLength + "\t");
			output.print(cattle.bust + "\t");
			output.print(cattle.cannon + "\t");
			output.print(cattle.killWeight + "\t");
			output.print(cattle.carcassWeight + "\t");
			output.print(cattle.pureMeat + "\t");
			output.print(cattle.skinThickness + "\t");
			output.print(cattle.skeletonWeight + "\t");
			output.print(cattle.musculiOculi + "\t");
			output.print(cattle.slaughterRate + "\t");
			output.print(cattle.meatBoneRatio + "\t");
			output.println(cattle.comment);
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Cattle> cattles) {
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
			output.print(cavelLabel.getText() + "\t");
			output.print(acromionLabel.getText() + "\t");
			output.print(furtherColorLabel.getText() + "\t");
			output.print(weightLabel.getText() + "\t");
			output.print(bodyLengthLabel.getText() + "cm\t");
			output.print(bodyHeightLabel.getText() + "cm\t");
			output.print(bodyDipLengthLabel.getText() + "cm\t");
			output.print(bustLabel.getText() + "cm\t");
			output.print(cannonLabel.getText() + "cm\t");
			output.print(killWeightLabel.getText() + "kg\t");
			output.print(carcassWeightLabel.getText() + "kg\t");
			output.print(pureMeatLabel.getText() + "%\t");
			output.print(skinThicknessLabel.getText() + "cm\t");
			output.print(skeletonWeightLabel.getText() + "kg\t");
			output.print(musculiOculiLabel.getText() + "cm2\t");
			output.print(slaughterRateLabel.getText() + "%\t");
			output.print(meatBoneRatioLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			for (Cattle cattle : cattles) {
				output.print(cattle.getID() + "\t");
				output.print(cattle.year + dateLabels[1].getText());
				output.print(cattle.month + dateLabels[2].getText());
				output.print(cattle.day + dateLabels[3].getText() + "\t");
				output.print(cattle.species + "\t");
				output.print(cattle.country + cattle.province + "\t");
				output.print(cattle.locality + "\t");
				output.print(cattle.latitude + "\t");
				output.print(cattle.longitude + "\t");
				output.print((cattle.sex ? "male" : "female") + "\t");
				output.print(cattle.age + "\t");
				output.print(cattle.cavel + "\t");
				output.print(cattle.acromion + "\t");
				output.print(cattle.furtherColor + "\t");
				output.print(cattle.weight + "\t");
				output.print(cattle.bodyLength + "\t");
				output.print(cattle.bodyHeight + "\t");
				output.print(cattle.bodyDipLength + "\t");
				output.print(cattle.bust + "\t");
				output.print(cattle.cannon + "\t");
				output.print(cattle.killWeight + "\t");
				output.print(cattle.carcassWeight + "\t");
				output.print(cattle.pureMeat + "\t");
				output.print(cattle.skinThickness + "\t");
				output.print(cattle.skeletonWeight + "\t");
				output.print(cattle.musculiOculi + "\t");
				output.print(cattle.slaughterRate + "\t");
				output.print(cattle.meatBoneRatio + "\t");
				output.println(cattle.comment);
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
	
	
	private class CattleOutputStage extends OutputStage {
		
		protected CattleOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Cattle> cattles = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							cattles.add(Cattle.getData(id));
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
				OutputFiles(file.getPath(), cattles);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
		
	}
}
