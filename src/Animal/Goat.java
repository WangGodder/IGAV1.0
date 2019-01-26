package Animal;
/**
 * @author ������ 
 * @date : 2017��7��17�� ����2:58:30
 */
import java.io.*;

public class Goat extends AbstractSheet {
	private String fileSrc = "goat/data/" + ID + "data.dat";
	private String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Goat() {
		super();
		
	}
	
	public Goat(int id) {
		super(id);
		fileSrc = "goat/data/" + id + "data.dat";
		file = new File(fileSrc);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Goat goat) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(goat.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(goat);
		writedData.flush();
		writedData.close();
	}
	
	public static Goat getData(int id) throws IOException, ClassNotFoundException {
		Goat goat = new Goat(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(goat.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		goat = (Goat)getData.readObject();
		getData.close();
		return goat;
	}

	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}

}
