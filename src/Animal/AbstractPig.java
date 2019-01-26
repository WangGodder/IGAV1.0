package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月10日 下午1:01:06
 */
public abstract class AbstractPig extends Animal implements java.io.Serializable {
	public double weight;
	public double bodyLength;
	public double bodyHeight;
	public double bust;
	
	public double carcassWeight;
	public double slaughterRate;
	public double backfatThicknessOfAverage;
	public double backfatThicknessOfSixSeven;
	public double skinThickness;
	public double musculiOculi;
	public double meatFactor; // 瘦肉率
	
	public String furtherColor;
	
	public String meatColor;
	public String marbling; // 大理石纹
	public double PH;
	public double crudeProtein; // 粗蛋白
	public double imf; // 肌内脂肪
	public double waterProportion; // 水分
	public double crudeAsh; // 粗灰分
	
	public String comment;
	
	public AbstractPig() {
		super();
	}
	
	public AbstractPig(int ID) {
		super(ID);
	}
}
