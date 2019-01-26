package Animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Poultry extends AbstractPoultry {
	private String fileSrc = "poultry/data/" + ID + "data.dat";
	private String[] imageSrc ;
	protected String moveSrc;
	protected String voiceSrc;
	private File file;
	
	public Poultry() {
		super();
	}
	
	public Poultry(int id) {
		super(id);
		fileSrc = "poultry/data/" + id + "data.dat";
		file = new File(fileSrc);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public static void writeData(Poultry poultry) throws IOException {
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(poultry.getFileSrc()));
		ObjectOutputStream writedData = new ObjectOutputStream(buffer);
		writedData.writeObject(poultry);
		writedData.flush();
		writedData.close();
	}
	
	public static Poultry getData(int id) throws IOException, ClassNotFoundException {
		Poultry poultry = new Poultry(id);
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(poultry.getFileSrc()));
		ObjectInputStream getData = new ObjectInputStream(buffer);
		poultry = (Poultry)getData.readObject();
		getData.close();
		return poultry;
	}
	
	public String[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String[] imageSrc) {
		this.imageSrc = imageSrc;
	}
	
}
