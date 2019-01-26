/**
 * @author 王鑫祉 
 * @date : 2017年7月25日 下午6:14:50
 */
package Animal;
import java.io.Serializable;

public abstract class AbstractPoultry extends Animal implements Serializable {
	public double bodyDipLength;
	public double weight;
	public double bustWidth;
	public double bustDepth;
	public double sternumLength;
	public double shinLength;
	public double shinCircumference;
	public double pelvisWidth;
	public double killWeight;
	public double slaughterWeight;
	public double slaughterRate;
	public double chamberHalfNetRate; //半净膛率
	public double chamberAllNetRate; //全净膛率
	public double legMuscleRate; //腿肌率
	public double breastMuscleRate; //胸肌率
	public double AFY;
	public double eggWeight; //unit: g
	public double eggShapeIndex; // unit: none;
	public double eggShellSER; // 蛋壳强率 unit:kg/cm3
	public double eggShellThickness; // unit: mm
	public String eggShellColor; 
	public double yolkRate; // 蛋黄比率
	public String earColor;
	public String mouthShape;
	public String neckCharacter;
	public String combShape;
	public String skinColor;
	public String legCharacter;
	public String clawColor;
	public String webColor; // 鸡蹼color
	public String bodyCharacter;
	public String comment;
	
	public AbstractPoultry()  {
		super();
	}

	public AbstractPoultry(int id) {
		super(id);
	}
	
}
