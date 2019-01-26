/**
 * @author ������ 
 * @date : 2017��7��25�� ����6:14:50
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
	public double chamberHalfNetRate; //�뾻����
	public double chamberAllNetRate; //ȫ������
	public double legMuscleRate; //�ȼ���
	public double breastMuscleRate; //�ؼ���
	public double AFY;
	public double eggWeight; //unit: g
	public double eggShapeIndex; // unit: none;
	public double eggShellSER; // ����ǿ�� unit:kg/cm3
	public double eggShellThickness; // unit: mm
	public String eggShellColor; 
	public double yolkRate; // ���Ʊ���
	public String earColor;
	public String mouthShape;
	public String neckCharacter;
	public String combShape;
	public String skinColor;
	public String legCharacter;
	public String clawColor;
	public String webColor; // ����color
	public String bodyCharacter;
	public String comment;
	
	public AbstractPoultry()  {
		super();
	}

	public AbstractPoultry(int id) {
		super(id);
	}
	
}
