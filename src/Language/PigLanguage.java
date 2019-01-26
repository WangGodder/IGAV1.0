/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午3:18:40
 */
package Language;
import java.io.*;
public class PigLanguage extends Language {

	private static File file = new File("language/pig/" + language + ".dat");
	
	public String[] furtherColor;
	public String bodyLengthLabel;
	public String bodyHeightLabel;
	public String weightLabel;
	public String bustLabel;
	public String carcassWeightLabel;
	public String slaughterRateLabel;
	public String backfatThicknessOfAverageLabel;
	public String backfatThicknessOfSixSevenLabel;
	public String skinThicknessLabel;
	public String musculiOculiLabel;
	public String meatFactorLabel;
	public String furtherColorLabel;
	
	public String meatColorLabel;
	public String marblingLabel;
	public String PHLabel;
	public String crudeProteinLabel;
	public String imfLabel;
	public String waterProportionLabel;
	public String crudeAshLabel;
	
	public PigLanguage() {
		super.file = new File("language/pig/" + language + ".dat");
	}
	
	public PigLanguage(String language) {
		this.language = language;
		this.file = new File("language/pig/" + language + ".dat");
		super.file = new File("language/pig/" + language + ".dat");
	}
	
	public static void outputLanguage(PigLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static PigLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/pig/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		PigLanguage pigLanguage = (PigLanguage)input.readObject();
		input.close();
		return pigLanguage;
	}
	
}
