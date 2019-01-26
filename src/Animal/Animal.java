package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月7日 下午3:34:50
 */
import java.util.*;
public abstract class Animal implements Comparable<Animal>, java.io.Serializable{
	protected int ID;
	public boolean sex;
	public double age;
	public String species;
	public String country; // gather country
	public String province = ""; // gather in which province of China 
	public String locality; // To record the gather site;
	public double latitude; // 纬度
	public double longitude; // 经度
	public int year; // To record the gather date
	public int month;
	public int day;
	public int generation;
	public Animal father;
	protected Animal mother;
	protected ArrayList<Animal> borders;
	protected ArrayList<Animal> mates;
	protected ArrayList<Animal> children;
	
	public Animal() {
	}
	
	public Animal(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public double getAge() {
		return this.age;
	}
	
	@Override
	public int compareTo(Animal animal) {
		return animal.generation - this.generation;
	}
	
	
}
