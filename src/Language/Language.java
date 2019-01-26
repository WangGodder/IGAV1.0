/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:57:49
 */
package Language;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Language implements Serializable {
	public static String language = "Chinese";
	protected static File file;
	public String[] countryCandidate;
	public String[] sexCandidate;
	public String[] buttonNames;
	public String[] dateLabels;
	public String speicesLabel;
	public String sexLabel;
	public String[] ageLabels;
	public String[] localityLabels;
	public String[] statusLabels;
	public String imageChooser;
	public String commentLabel;
	
	public Language() {
		
	}
	
	public static Language inputLanguage(String languageName) throws IOException, ClassNotFoundException {
		
		String src = file.getParent() + "/" + languageName + ".dat";
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(src));
		ObjectInputStream input = new ObjectInputStream(buffer);
		Language language = (Language) input.readObject();
		input.close();
		return language;
	}

}
