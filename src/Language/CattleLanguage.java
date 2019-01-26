/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:57:56
 */
package Language;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CattleLanguage extends Language implements Serializable {
	private static File file = new File("language/cattle/" + language + ".dat");
	public String[] furtherColorCandidate;
	public String[] cavelCandidate;
	public String[] acromionCandidate;
	
	public String weightLabel;
	public String bodyLengthLabel;
	public String bodyHeightLabel;
	public String bodyDipLengthLabel;
	public String bustLabel;
	public String cannonLabel;
	
	public String killWeightLabel;
	public String carcassWeightLabel;
	public String pureMeatLabel;
	public String skinThicknessLabel;
	public String skeletonWeightLabel;
	public String musculiOculiLabel;
	public String slaughterRateLabel;
	public String meatBoneRatioLabel;
	public String furtherColorLabel;
	public String cavelLabel;
	public String acromionLabel;
	
	public CattleLanguage() {
		super.file = new File("language/cattle/" + language + ".dat");
		file = new File("language/cattle/" + language + ".dat");
	}
	
	public CattleLanguage(String language) {
		this.language = language;
		this.file = new File("language/cattle/" + language + ".dat");
		super.file = new File("language/cattle/" + language + ".dat");
	}
	
	public static void outputLanguage(CattleLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static CattleLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/cattle/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		CattleLanguage cattleLanguage = (CattleLanguage)input.readObject();
		input.close();
		return cattleLanguage;
	}
}
