package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:59:03
 */
public abstract class AbstractCattle extends Animal implements java.io.Serializable {
	public double weight;
	public double bodyLength;
	public double bodyHeight;
	public double bodyDipLength;
	public double bust;
	public double cannon;
	
	public double killWeight;
	public double carcassWeight;
	public double pureMeat;
	public double skinThickness;
	public double skeletonWeight;
	public double musculiOculi; //眼肌面积
	public double slaughterRate;
	public double meatBoneRatio;
	
	public String furtherColor;
	public String cavel;
	public String acromion;
	
	public String comment;
	
	public AbstractCattle() {
		super();
	}
	
	public AbstractCattle(int ID) {
		super(ID);
	}
	
}
