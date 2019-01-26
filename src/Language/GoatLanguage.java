package Language;
/**
 * @author ������ 
 * @date : 2017��7��11�� ����5:23:50
 */

import java.io.*;
public class GoatLanguage extends Language implements Serializable {
	private static File file = new File("language/goat/" + language + ".dat"); 
	public String[] colorCandidate;
	public String[] skinColorCandidate;
	public String[] cavelCandidate;
	public String[] cavelShapeCandidate;
	public String[] noseCandidate;
	public String[] earCandidate;
	public String[] neckCandidate;
	public String[] limbsCandidate;
	public String[] headTypeCandidate;
	public String[] foreheadCandidate;
	public String[] tailTypeCandidate;
			
	public String[] headLabels;
	public String foreheadLabel;
	public String cavelLabel;
	public String[] earLabels;
	public String noseLabel;
	public String neckLabel;
	public String bodyLengthLabel;
	public String bodyHeightLabel;
	public String bodyDipLengthedLabel;
	public String furtherColorLabel;
	public String skinColorLabel;
	public String limbsLabel;
	public String bustLabel;
	public String bustWidthLabel;
	public String bustDepthLabel;
	public String[] tailLabels;
	public String weightLabel;
	public String farrowLabel;
	
	public String[] neckCheckBox;
		
	public GoatLanguage() {
		super.file = new File("language/goat/" + language + ".dat");
		file = new File("language/goat/" + language + ".dat");
	}
	
	public GoatLanguage(String language) {
		this.language = language;
		super.file = new File("language/goat/" + language + ".dat");
		this.file = new File("language/goat/" + language + ".dat");
	}
	
	public static void outputLanguage(GoatLanguage language) throws Exception{
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(buffer);
		output.writeObject(language);
		output.flush();
		output.close();
	}
	
	public static GoatLanguage inputLanguage(String language) throws IOException, ClassNotFoundException {
		String src = "language/goat/" + language + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		GoatLanguage goatLanguage = (GoatLanguage)input.readObject();
		input.close();
		return goatLanguage;
	}
}
