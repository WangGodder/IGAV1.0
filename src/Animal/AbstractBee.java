/**
 * @author ������ 
 * @date : 2017��7��17�� ����7:17:18
 */
package Animal;
import java.io.Serializable;

public abstract class AbstractBee extends Animal implements Serializable {
	public String color;
	public double mouthLength;
	public double foreWineLength;
	public double foreWineWidth;
	public double brachiumIndex;
	public double bellyBackboardOf34;
	public double honeyWeight;
	public double royalJellyWeight;
	public double beePollenWeight;
	public double propolisWeight; // unit: g
	public double beewaxWeight; 
	public double waterOfHoney; // unit: %
	
	public String comment;
	
	public AbstractBee() {
		super();
	}
	
	public AbstractBee(int ID) {
		super(ID);
	}
	
}
