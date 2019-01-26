/**
 * @author 王鑫祉 
 * @date : 2017年7月25日 下午5:49:25
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

public class Bee extends AbstractBee {
	private String fileSrc = "cattle/data/" + ID + "data.dat";
	protected String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Bee() {
		super();
	}
	
	public Bee(int ID) {
		super(ID);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Bee bee) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(bee.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(bee);
		writedData.flush();
		writedData.close();
	}
	
	public static Bee getData(int id) throws IOException, ClassNotFoundException {
		Bee bee = new Bee(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(bee.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		bee = (Bee)getData.readObject();
		getData.close();
		return bee;
	}
	
	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}
}
