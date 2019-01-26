package Language;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PoultryLanguage extends Language {
	private static File file = new File("language/poultry/" + language + ".dat");
	public String[] eggColorCandidate;
	public String[] neckCharacterCandidate;
	public String[] combCandidate;
	public String[] skinColorCandidate;
	public String[] legCharacterCandidate;
	public String[] bodyCharacterCandidate;
	public String eggColorLabel;
	public String neckCharacterLabel;
	public String combLabel;
	public String skinColorLabel;
	public String legCharacterLabel;
	public String bodyCharacterLabel;
	public String bodyDipLengthLabel;
	public String weightLabel;
	public String bustWidthLabel;
	public String bustDepthLabel;
	public String sternumLengthLabel;
	public String shinLengthLabel;
	public String shinCircumferenceLabel;
	public String pelvisWidthLabel;
	public String killWeightLabel;
	public String slaughterWeightLabel;
	public String slaughterRateLabel;
	public String chamberHalfNetRateLabel;
	public String chamberAllNetRateLabel;
	public String legMuscleRateLabel;
	public String breastMuscleRateLabel;
	public String AFYLabel;
	public String eggWeightLabel;
	public String eggShapeIndexLabel;
	public String eggShellSERLabel;
	public String eggShellThicknessLabel;
	public String yolkRateLabel;
	public String earColorLabel;
	public String mouthShapeLabel;
	public String clawColorLabel;
	public String webColorLabel;
	
	public PoultryLanguage() {
		super.file = new File("language/poultry/" + language + ".dat");
	}
	
	public PoultryLanguage(String language) {
		this.language = language;
		this.file = new File("language/poultry/" + language + ".dat");
		super.file = new File("language/poultry/" + language + ".dat");
	}
	
	public static void outputLanguage(PoultryLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static PoultryLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/poultry/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		PoultryLanguage poultryLanguage = (PoultryLanguage)input.readObject();
		input.close();
		return poultryLanguage;
	}
}
