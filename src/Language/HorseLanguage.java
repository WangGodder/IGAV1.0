package Language;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HorseLanguage extends Language {
	private static File file = new File("language/horse/" + language + ".dat");
	public String[] furtherColorCandidate;
	public String furtherColorLabel;
	public String weightLabel;
	public String bodyLengthLabel;
	public String bodyHeigthLabel;
	public String bodyLengthExponentLabel;
	public String bustLabel;
	public String bustExponentLabel;
	public String cannonLabel;
	public String cannonExponentLabel;
	public String slaughterRateLabel;
	public String carcassMeatFactorLabel;
	public String meatBoneRatioLabel;
	public String musculiOculiLabel;
	public String legMuscleThicknessLabel;
	public String waistMuscleThicknessLabel;
	public String legFatThicknessLabel;
	public String waistFatThicknessLabel;
	
	public HorseLanguage() {
		super.file = new File("language/horse/" + language + ".dat");
	}
	
	public HorseLanguage(String language) {
		this.language = language;
		this.file = new File("language/horse/" + language + ".dat");
		super.file = new File("language/horse/" + language + ".dat");
	}
	
	public static void outputLanguage(HorseLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static HorseLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/horse/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		HorseLanguage horseLanguage = (HorseLanguage)input.readObject();
		input.close();
		return horseLanguage;
	}

}
