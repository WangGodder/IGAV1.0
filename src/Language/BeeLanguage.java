package Language;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BeeLanguage extends Language {
	private static File file = new File("language/bee/" + language + ".dat");
	public String[] colorCandidate;
	public String colorLabel;
	public String mouthLengthLabel;
	public String foreWineLengthLabel;
	public String foreWineWidthLabel;
	public String brachiumIndexLabel;
	public String bellyBackboardOf34Label;
	public String honeyWeightLabel;
	public String royalJellyWeightLabel;
	public String beePollenWeightLabel;
	public String propolisWeightLabel;
	public String beewaxWeightLabel;
	public String waterOfHoneyLabel;
	
	public BeeLanguage() {
		super.file = new File("language/bee/" + language + ".dat");
	}
	
	public BeeLanguage(String language) {
		this.language = language;
		this.file = new File("language/bee/" + language + ".dat");
		super.file = new File("language/bee/" + language + ".dat");
	}
	
	public static void outputLanguage(BeeLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static BeeLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/bee/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		BeeLanguage beeLanguage = (BeeLanguage)input.readObject();
		input.close();
		return beeLanguage;
	}
}
