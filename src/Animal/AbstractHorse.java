/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午7:17:36
 */
package Animal;

import java.io.Serializable;

public abstract class AbstractHorse extends Animal implements Serializable {
	public String furtherColor;
	public double weigth;
	public double bodyLength;
	public double bodyHeight;
	public double bodyLengthExponent;
	public double bust;
	public double bustExponent;
	public double cannon;
	public double cannonExponent;
	public double slaughterRate;
	public double carcassMeatFactor;
	public double meatBoneRatio;
	public double musculiOculi;
	public double legMuscleThickness;
	public double waistMuscleThickness;
	public double legFatThickness;
	public double waistFatThickness;
	
	public String comment;
	
	public AbstractHorse() {
		super();
	}
	
	public AbstractHorse(int ID) {
		super(ID);
	}
	
	public double getAge() {
		return this.age;
	}
	public int getId() {
		return this.ID;
	}

}
