package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午3:00:00
 */
import java.io.*;
public class Pig extends AbstractPig {
	private String fileSrc = "pig/data/" + ID + "data.dat";
	protected String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Pig() {
		super();
	}
	
	public Pig(int ID) {
		super(ID);
		fileSrc = "pig/data/" + ID + "data.dat";
		file = new File(fileSrc);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Pig pig) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(pig.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(pig);
		writedData.flush();
		writedData.close();
	}
	
	public static Pig getData(int id) throws IOException, ClassNotFoundException {
		Pig pig = new Pig(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(pig.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		pig = (Pig)getData.readObject();
		getData.close();
		return pig;
	}
	
	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}
}
