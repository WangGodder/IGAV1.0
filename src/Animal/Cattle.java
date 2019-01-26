package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月15日 下午3:49:32
 */
import java.io.*;

public class Cattle extends AbstractCattle {
	private String fileSrc = "cattle/data/" + ID + "data.dat";
	protected String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Cattle() {
		
	}
	
	public Cattle(int ID) {
		super(ID);
		fileSrc = "cattle/data/" + ID + "data.dat";
		file = new File(fileSrc);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Cattle cattle) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(cattle.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(cattle);
		writedData.flush();
		writedData.close();
	}
	
	public static Cattle getData(int id) throws IOException, ClassNotFoundException {
		Cattle cattle = new Cattle(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(cattle.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		cattle = (Cattle)getData.readObject();
		getData.close();
		return cattle;
	}
	
	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}
}
