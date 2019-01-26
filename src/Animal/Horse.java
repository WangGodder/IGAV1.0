/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午7:17:27
 */
package Animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Horse extends AbstractHorse {
	private String fileSrc = "horse/data/" + ID + "data.dat";
	protected String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Horse() {
		super();
	}
	
	public Horse(int ID) {
		super(ID);
		fileSrc = "horse/data/" + ID + "data.dat";
		file = new File(fileSrc);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Horse horse) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(horse.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(horse);
		writedData.flush();
		writedData.close();
	}
	
	public static Horse getData(int id) throws IOException, ClassNotFoundException {
		Horse horse = new Horse(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(horse.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		horse = (Horse)getData.readObject();
		getData.close();
		return horse;
	}
	
	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}
}
