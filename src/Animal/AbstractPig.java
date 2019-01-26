package Animal;
/**
 * @author ������ 
 * @date : 2017��7��10�� ����1:01:06
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
	public double meatFactor; // ������
	
	public String furtherColor;
	
	public String meatColor;
	public String marbling; // ����ʯ��
	public double PH;
	public double crudeProtein; // �ֵ���
	public double imf; // ����֬��
	public double waterProportion; // ˮ��
	public double crudeAsh; // �ֻҷ�
	
	public String comment;
	
	public AbstractPig() {
		super();
	}
	
	public AbstractPig(int ID) {
		super(ID);
	}
}
