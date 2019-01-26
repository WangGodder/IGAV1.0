package Animal;
/**
 * @author 王鑫祉 
 * @date : 2017年7月7日 下午3:40:38
 */
public abstract class AbstractSheet extends Animal implements java.io.Serializable {
	
	
	// The morphological characteristics
	public double headLength; // To record the head length
	public double headWidth; // To record the head width;
	public String headType; // big middle small
	
	public double earLength; // To record the ear length
	public double earWidth; // To record the ear width
	public String earCharacter; // To record the ear character
	
	public String foreheadType; // 额型（宽、平、窄、隆）
	
	public String noseCharacter; // To record the nose chararcter;

	public String limbsCharacter; // To record the limbs character
	
	public boolean isCavel; // To record is the sheep has the cavel
	public String cavelCharacter; // To record the cavel's characters
	
	public String neckCharacter; // To record the neck character
	public boolean isMeat;
	public boolean isWrinkle;
	public boolean isBeard;
	
	public String color; // To record the wool's color
	public String skinColor; // To record the sheep's skin color
	
	public double bodyLength; // To record the body's length
	public double bodyHeight; // To record the body's height
	public double bodyDipLength; 
	public double weight; // To record the weight
	public double bust; // To record the chest cricumference
	public double bustWidth;
	public double bustDepth;
	public double tailLength;
	public double tailWidth;
	public String tailType;
	
	public int farrowingNumber; // 产仔数
	
	public String comment; 
	
	public AbstractSheet() {
		super();
	}
	
	public AbstractSheet(int id) {
		super(id);
		
	}
}
