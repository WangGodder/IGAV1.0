/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:57:39
 */
package Language;
import java.util.*;
import java.util.Locale;

public class OutputChineseGoatLanguage {

	public static void main(String[] args) {
		GoatLanguage language = new GoatLanguage("Chinese");
		
		language.colorCandidate  = new String[]{
				"全白", "全黑", "全褐", "头黑", "头褐", "体花", "麻"};
		language.skinColorCandidate = new String[] {
				"白", "黑", "粉", "红"};
		language.sexCandidate = new String[]{"male", "female"};
		language.cavelCandidate = new String[]{"有", "无"};
		language.cavelShapeCandidate = new String[] {
				"粗壮", "纤细", "大螺旋", "小螺旋", "弓形角", "镰刀形", "对旋角", "直立角",
				"倒八字", "姜角", "小角"};
		language.noseCandidate  = new String[]{
				"隆起", "平直", "凹陷"};
		language.earCandidate = new String[]{
				"直立", "下垂"};
		language.neckCandidate = new String[]{
				"粗", "细", "长", "短"};
		language.limbsCandidate = new  String[]{
				"粗", "细", "腿高", "腿矮"};
		Locale[] list = Locale.getAvailableLocales();
		List<String> countries = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			String src = list[i].getDisplayCountry();
			if (src != null && src.length() != 0 && !countries.contains(src)) {
				countries.add(src);
			}
		}
		language.countryCandidate = new String[countries.size()];
		for (int i = 0; i < countries.size(); i++) {
			language.countryCandidate[i] = countries.get(i);
		}
			
		System.out.println(countries.indexOf("中国"));
		
		language.sexCandidate = new String[] {
				"雄性", "雌性"};

		language.headTypeCandidate = new String[] {
				"大","中","小"};
		language.foreheadCandidate = new String[] {
				"宽", "平","窄","隆"};
		language.tailTypeCandidate = new String[] {
				"短脂尾", "长脂尾", "短瘦尾", "脂臀尾", "长瘦尾"};
		
		language.buttonNames = new String[]	 {
				"清空", "扩大", "缩小", "查找", "添加", "修改", "输出文件", "选择图片", "批量输出","返回主页面"};
		language.dateLabels = new String[] {
				"日期", "年", "月", "日"};
		language.speicesLabel = "品种";
		language.sexLabel = "性别";
		language.ageLabels = new String[] {
				"年龄", "月"};
		language.localityLabels = new String[] {
				"采集地点", "地区", "纬度", "经度"};
		language.headLabels = new String[] {
				"头部", "长", "宽"
		};
		language.foreheadLabel = "额";
		language.cavelLabel = "角";
		language.earLabels = new String[] {
				"耳", "长", "宽"};
		language.noseLabel = "鼻";
		language.neckLabel = "颈部";
		language.bodyLengthLabel = "体长";
		language.bodyHeightLabel = "体高";
		language.bodyDipLengthedLabel = "斜体长";
		language.furtherColorLabel = "毛色";
		language.skinColorLabel = "肤色";
		language.limbsLabel = "四肢";
		language.bustLabel = "胸围";
		language.bustWidthLabel = "胸宽";
		language.bustDepthLabel = "胸深";
		language.tailLabels = new String[] {
				"尾部", "长", "宽"
		};
		language.weightLabel = "体重";
		language.farrowLabel = "产羔数";
		language.commentLabel = "备注";
		
		language.neckCheckBox = new String[] {
				"肉垂", "皱纹", "胡须"};
		
		language.imageChooser = "选择图片(ctrl多选)";
		
		language.statusLabels = new String[] {
				"通过ID进行查找",
				"ID请输入阿拉伯数字",
				" 已被找到",
				" 数据未发现",
				" 已加入数据",
				"确定要更改数据：ID = ",
				" 数据已更改",
				"确定返回主页吗？",
				"确定添加ID = ",
				"导出失败",
				"是否导出excel文件？ 否将输出txt文件",
				"导出成功，文件位于文件夹：",
				"图片导入失败"
		};
				
		try {
			GoatLanguage.outputLanguage(language);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
