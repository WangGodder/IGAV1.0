/**
 * @author ������ 
 * @date : 2017��7��30�� ����10:02:34
 */
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Animal.Bee;
import Language.BeeLanguage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class BeeStage extends StageModel {

	private String[] colorCandidate;
	
	private final ComboBox<String> colorComboBox = new ComboBox<>();
	
	private final TextField mouthLengthField = new TextField();
	private final TextField foreWineLengthField = new TextField();
	private final TextField foreWineWidthField = new TextField();
	private final TextField brachiumIndexField = new TextField();
	private final TextField bellyBackboardOf34Field = new TextField();
	private final TextField honeyWeightField = new TextField();
	private final TextField royalJellyWeightField = new TextField();
	private final TextField beePollenWeightField = new TextField();
	private final TextField propolisWeightField = new TextField();
	private final TextField beewaxWeightField = new TextField();
	private final TextField waterOfHoneyField = new TextField();
	
	private final Label colorLabel = new Label("��ɫ");
	private final Label mouthLengthLabel = new Label("๳�");
	private final Label foreWineLengthLabel = new Label("ǰ�᳤");
	private final Label foreWineWidthLabel = new Label("ǰ���");
	private final Label brachiumIndexLabel = new Label("����ָ��");
	private final Label bellyBackboardOf34Label = new Label("3+4���ڱ����ܳ� ");
	private final Label honeyWeightLabel = new Label("����");
	private final Label royalJellyWeightLabel = new Label("������");
	private final Label beePollenWeightLabel = new Label("�廨��");
	private final Label propolisWeightLabel = new Label("�佺");
	private final Label beewaxWeightLabel = new Label("����");
	private final Label waterOfHoneyLabel = new Label("���ۺ�ˮ��");
	
	public BeeStage(Stage mainStage) {
		super(mainStage);
		stage.setTitle("Bee Register");
		
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
		dataPanes[2].add(colorLabel, 4, 0);
		dataPanes[2].add(colorComboBox, 5, 0);
		
		dataPanes[3].add(mouthLengthLabel, 0, 0);
		dataPanes[3].add(getUnitBox(mouthLengthField, "mm"), 1, 0);
		dataPanes[3].add(foreWineLengthLabel, 2, 0);
		dataPanes[3].add(getUnitBox(foreWineLengthField, "mm"), 3, 0);
		dataPanes[3].add(foreWineWidthLabel, 4, 0);
		dataPanes[3].add(getUnitBox(foreWineWidthField, "mm"), 5, 0);
		
		dataPanes[4].add(brachiumIndexLabel, 0, 0);
		dataPanes[4].add(brachiumIndexField, 1, 0);
		dataPanes[4].add(bellyBackboardOf34Label, 2, 0);
		dataPanes[4].add(getUnitBox(bellyBackboardOf34Field, "mm"), 3, 0);
		
		dataPanes[5].add(honeyWeightLabel, 0, 0);
		dataPanes[5].add(getUnitBox(honeyWeightField, "kg"),  1, 0);
		dataPanes[5].add(royalJellyWeightLabel, 2, 0);
		dataPanes[5].add(getUnitBox(royalJellyWeightField, "kg"), 3, 0);
		dataPanes[5].add(beePollenWeightLabel, 4, 0);
		dataPanes[5].add(getUnitBox(beePollenWeightField, "kg"), 5, 0);
		
		dataPanes[6].add(propolisWeightLabel, 0, 0);
		dataPanes[6].add(getUnitBox(propolisWeightField, "g"), 1, 0);
		dataPanes[6].add(beewaxWeightLabel, 2, 0);
		dataPanes[6].add(getUnitBox(beewaxWeightField, "kg"), 3, 0);
		dataPanes[6].add(waterOfHoneyLabel, 4, 0);
		dataPanes[6].add(getUnitBox(waterOfHoneyField, "%"), 5, 0);
		
		for (int i = 0; i < dataPanes.length; i++) {
			dataPane.add(dataPanes[i], 0, i);
		}
	}

	@Override
	protected void setLanguage(String languageName) {
		BeeLanguage language = new BeeLanguage();
		try {
			language = BeeLanguage.inputLanguage(languageName);
		} catch (IOException ex) {
			ex.getStackTrace();
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Language can not be found", 0);
			return;
		} 
		super.setLanguage(languageName);
		
		colorCandidate = language.colorCandidate;
		colorLabel.setText(language.colorLabel);
		mouthLengthLabel.setText(language.mouthLengthLabel);
		foreWineLengthLabel.setText(language.foreWineLengthLabel);
		foreWineWidthLabel.setText(language.foreWineWidthLabel);
		brachiumIndexLabel.setText(language.brachiumIndexLabel);
		bellyBackboardOf34Label.setText(language.bellyBackboardOf34Label);
		honeyWeightLabel.setText(language.honeyWeightLabel);
		royalJellyWeightLabel.setText(language.royalJellyWeightLabel);
		beePollenWeightLabel.setText(language.beePollenWeightLabel);
		propolisWeightLabel.setText(language.propolisWeightLabel);
		beewaxWeightLabel.setText(language.beewaxWeightLabel);
		waterOfHoneyLabel.setText(language.waterOfHoneyLabel);
		initializeComboBox(colorComboBox, colorCandidate, false);

	}
	
	private void initializeNode() {
		initNode();
		
		setFieldWidth(80, mouthLengthField, foreWineLengthField, 
				foreWineWidthField, brachiumIndexField, 
				bellyBackboardOf34Field, honeyWeightField, 
				royalJellyWeightField, beePollenWeightField, 
				propolisWeightField, beewaxWeightField, 
				waterOfHoneyField);
		initializeComboBox(colorComboBox, colorCandidate, false);
		
		getIDCandidate("bee/data");
		
		getLanguageCandidate("language/bee");
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
				Bee bee = Bee.getData(id);
				showData(bee);
				
				JOptionPane.showMessageDialog(null, bee.getID() + status[2]);
				statusLabel.setText(bee.getID() + status[2]);
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
				Bee bee = getBee();
				Bee.writeData(bee);
				JOptionPane.showMessageDialog(null, bee.getID() + status[4]);
				statusLabel.setText(bee.getID() + status[4]);
			} catch (IOException ex) {
				statusLabel.setText(ex.toString());
			}
			getIDCandidate("bee/data");
		});
		
		btChange.setOnAction(e -> {
			int answer = JOptionPane.showConfirmDialog(null, status[5] + idComboBox.getValue() + "?");
			if (answer == JOptionPane.YES_OPTION) {
				try {
					Bee bee = getBee();
					Bee.writeData(bee);
					JOptionPane.showMessageDialog(null, bee.getID() + status[6]);
					statusLabel.setText(bee.getID() + status[6]);
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
			File idFile = new File("bee/data");
			File[] files = idFile.listFiles();
			Stage stage = new BeeOutputStage(files);
		});

	}
	
	private Bee getBee() {
		int id = -1;
		try {
			id = Integer.parseInt(idComboBox.getValue().trim());
		} catch (NumberFormatException ex) {
			statusLabel.setText(status[1]);
			return null;
		}
		Bee bee = new Bee(id);
		
		bee.year = (int)yearComboBox.getValue();
		bee.month = (int)monthComboBox.getValue();
		bee.day = (int)dayComboBox.getValue();
		bee.country = countryComboBox.getValue();
		bee.province = provinceComboBox.getValue();
		bee.locality = localityField.getText();
		bee.latitude = getDouble(latitudeField);
		bee.longitude = getDouble(longitudeField);
		bee.species = speciesField.getText();
		bee.sex = (sexComboBox.getValue() == sexCandidate[0])? true : false;
		bee.age = getDouble(ageField);
		bee.color = colorComboBox.getValue();
		bee.mouthLength = getDouble(mouthLengthField);
		bee.foreWineLength = getDouble(foreWineLengthField);
		bee.foreWineWidth = getDouble(foreWineWidthField);
		bee.brachiumIndex = getDouble(brachiumIndexField);
		bee.bellyBackboardOf34 = getDouble(bellyBackboardOf34Field);
		bee.honeyWeight = getDouble(honeyWeightField);
		bee.royalJellyWeight = getDouble(royalJellyWeightField);
		bee.beePollenWeight = getDouble(beePollenWeightField);
		bee.propolisWeight = getDouble(propolisWeightField);
		bee.beewaxWeight = getDouble(beewaxWeightField);
		bee.waterOfHoney = getDouble(waterOfHoneyField);
		bee.comment = commentArea.getText();
		
		bee.setImageSrc(imageSrc);
		
		return bee;
	}
	
	private void showData(Bee bee) {
		yearComboBox.setValue(bee.year);
		monthComboBox.setValue(bee.month);
		dayComboBox.setValue(bee.day);
		countryComboBox.setValue(bee.country);
		provinceComboBox.setValue(bee.province);
		localityField.setText(bee.locality);
		latitudeField.setText(bee.latitude + "");
		longitudeField.setText(bee.longitude + "");
		speciesField.setText(bee.species);
		sexComboBox.setValue((bee.sex)? sexCandidate[0] : sexCandidate[1]);
		ageField.setText(bee.getAge() + "");
		commentArea.setText(bee.comment);
		
		colorComboBox.setValue(bee.color);
		mouthLengthField.setText(bee.mouthLength + "");
		foreWineLengthField.setText(bee.foreWineLength + "");
		foreWineWidthField.setText(bee.foreWineWidth + "");
		brachiumIndexField.setText(bee.brachiumIndex + "");
		bellyBackboardOf34Field.setText(bee.bellyBackboardOf34 + "");
		honeyWeightField.setText(bee.honeyWeight + "");
		royalJellyWeightField.setText(bee.royalJellyWeight + "");
		beePollenWeightField.setText(bee.beePollenWeight + "");
		propolisWeightField.setText(bee.propolisWeight + "");
		beewaxWeightField.setText(bee.beewaxWeight + "");
		waterOfHoneyField.setText(bee.waterOfHoney + "");
		
		imageSrc = bee.getImageSrc();
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
			
			output.print(colorLabel.getText() + ": ");
			output.println(colorComboBox.getValue());
			
			output.print(mouthLengthLabel.getText() + ": ");
			output.println(mouthLengthField.getText() + "mm");
			
			output.print(foreWineLengthLabel.getText() + ": ");
			output.println(foreWineLengthField.getText() + "mm");
			
			output.print(foreWineWidthLabel.getText() + ": ");
			output.println(foreWineWidthField.getText() + "mm");
			
			output.print(brachiumIndexLabel.getText() + ": ");
			output.println(brachiumIndexField.getText());
			
			output.print(bellyBackboardOf34Label.getText() + ": ");
			output.println(bellyBackboardOf34Field.getText() + "mm");
			
			output.print(honeyWeightLabel.getText() + ": ");
			output.println(honeyWeightField.getText() + "kg");
			
			output.print(royalJellyWeightLabel.getText() + ": ");
			output.println(royalJellyWeightField.getText() + "kg");
			
			output.print(beePollenWeightLabel.getText() + ": ");
			output.println(beePollenWeightField.getText() + "kg");
			
			output.print(propolisWeightLabel.getText() + ": ");
			output.println(propolisWeightField.getText() + "g");
			
			output.print(beewaxWeightLabel.getText() + ": ");
			output.println(beewaxWeightField.getText() + "kg");
			
			output.print(waterOfHoneyLabel.getText() + ": ");
			output.println(waterOfHoneyField.getText() + "%");
			
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
		Bee bee = getBee();
		
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
			output.print(colorLabel.getText() + "\t");
			output.print(mouthLengthLabel.getText() + "mm\t");
			output.print(foreWineLengthLabel.getText() + "mm\t");
			output.print(foreWineWidthLabel.getText() + "mm\t");
			output.print(brachiumIndexLabel.getText() + "\t");
			output.print(bellyBackboardOf34Label.getText() + "mm\t");
			output.print(honeyWeightLabel.getText() + "kg\t");
			output.print(royalJellyWeightLabel.getText() + "kg\t");
			output.print(beePollenWeightLabel.getText() + "kg\t");
			output.print(propolisWeightLabel.getText() + "g\t");
			output.print(beewaxWeightLabel.getText() + "kg\t");
			output.print(waterOfHoneyLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			output.print(bee.getID() + "\t");
			output.print(bee.year + dateLabels[1].getText());
			output.print(bee.month + dateLabels[2].getText());
			output.print(bee.day + dateLabels[3].getText() + "\t");
			output.print(bee.species + "\t");
			output.print(bee.country + bee.province + "\t");
			output.print(bee.locality + "\t");
			output.print(bee.latitude + "\t");
			output.print(bee.longitude + "\t");
			output.print((bee.sex ? "male" : "female") + "\t");
			output.print(bee.age + "\t");
			output.print(bee.color + "\t");
			output.print(bee.mouthLength + "\t");
			output.print(bee.foreWineLength + "\t");
			output.print(bee.foreWineWidth + "\t");
			output.print(bee.brachiumIndex + "\t");
			output.print(bee.bellyBackboardOf34 + "\t");
			output.print(bee.honeyWeight + "\t");
			output.print(bee.royalJellyWeight + "\t");
			output.print(bee.beePollenWeight + "\t");
			output.print(bee.propolisWeight + "\t");
			output.print(bee.beewaxWeight + "\t");
			output.print(bee.waterOfHoney + "\t");
			output.println(bee.comment);
			
			output.flush();
			output.close();
			
			JOptionPane.showMessageDialog(null, status[11] + src + "/" + idComboBox.getValue() + "output" + times + ".xls");
			
			times++;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, status[9]);
		}
	}
	
	private void OutputFiles(String src, List<Bee> bees) {
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
			output.print(colorLabel.getText() + "\t");
			output.print(mouthLengthLabel.getText() + "mm\t");
			output.print(foreWineLengthLabel.getText() + "mm\t");
			output.print(foreWineWidthLabel.getText() + "mm\t");
			output.print(brachiumIndexLabel.getText() + "\t");
			output.print(bellyBackboardOf34Label.getText() + "mm\t");
			output.print(honeyWeightLabel.getText() + "kg\t");
			output.print(royalJellyWeightLabel.getText() + "kg\t");
			output.print(beePollenWeightLabel.getText() + "kg\t");
			output.print(propolisWeightLabel.getText() + "g\t");
			output.print(beewaxWeightLabel.getText() + "kg\t");
			output.print(waterOfHoneyLabel.getText() + "%\t");
			output.println(commentLabel.getText());
			
			for (Bee bee : bees) {
				output.print(bee.getID() + "\t");
				output.print(bee.year + dateLabels[1].getText());
				output.print(bee.month + dateLabels[2].getText());
				output.print(bee.day + dateLabels[3].getText() + "\t");
				output.print(bee.species + "\t");
				output.print(bee.country + bee.province + "\t");
				output.print(bee.locality + "\t");
				output.print(bee.latitude + "\t");
				output.print(bee.longitude + "\t");
				output.print((bee.sex ? "male" : "female") + "\t");
				output.print(bee.age + "\t");
				output.print(bee.color + "\t");
				output.print(bee.mouthLength + "\t");
				output.print(bee.foreWineLength + "\t");
				output.print(bee.foreWineWidth + "\t");
				output.print(bee.brachiumIndex + "\t");
				output.print(bee.bellyBackboardOf34 + "\t");
				output.print(bee.honeyWeight + "\t");
				output.print(bee.royalJellyWeight + "\t");
				output.print(bee.beePollenWeight + "\t");
				output.print(bee.propolisWeight + "\t");
				output.print(bee.beewaxWeight + "\t");
				output.print(bee.waterOfHoney + "\t");
				output.println(bee.comment);
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
	
	private class BeeOutputStage extends OutputStage {
		
		protected BeeOutputStage(File[] files) {
			super(files);
			
			btOutput.setOnAction(e -> {
				List<Bee> bees = new ArrayList<>();
				for (int i = 0; i < files.length; i++) {
					if (fileCheckBoxs[i].isSelected()) {
						int id = Integer.parseInt(fileCheckBoxs[i].getText());
						try {
							bees.add(Bee.getData(id));
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
				OutputFiles(file.getPath(), bees);
			});
			
			btCancel.setOnAction(e -> {
				this.stage.hide();
				System.gc();
			});
		}
	}
}
