package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseHorseLanguage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HorseLanguage language = new HorseLanguage("Chinese");
		
		language.furtherColorCandidate = new String[] {
				"青毛", "骝毛", "黑毛", "栗毛", "花毛", "斑毛", "兔褐毛",
				"海骝毛", "黑克栗毛", "沙色", "银鬃", "银河", "鼠灰色"
		};
		language.weightLabel = "体重";
		language.bodyLengthLabel = "体长";
		language.bodyHeigthLabel = "体高";
		language.bodyLengthExponentLabel = "体长指数";
		language.bustLabel = "胸围";
		language.bustExponentLabel = "胸围指数";
		language.cannonLabel = "管围";
		language.cannonExponentLabel = "管围指数";
		language.slaughterRateLabel = "屠宰率";
		language.carcassMeatFactorLabel = "胴体净肉率";
		language.meatBoneRatioLabel = "肉骨比";
		language.musculiOculiLabel = "眼肌面积";
		language.legMuscleThicknessLabel = "大腿肌肉厚";
		language.waistMuscleThicknessLabel = "腰部肌肉厚";
		language.legFatThicknessLabel = "大腿脂肪厚度";
		language.waistFatThicknessLabel = "腰部脂肪厚度";
		
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
		language.buttonNames = new String[]	 {
				"清空", "扩大", "缩小", "查找", "添加", "修改", "输出文件", "选择图片", "批量输出","返回主页面"};
		language.dateLabels = new String[] {
				"日期", "年", "月", "日"};
		language.speicesLabel = "品种";
		language.sexLabel = "性别";
		language.sexCandidate = new String[] {
				"雄性", "雌性"};
		language.ageLabels = new String[] {
				"年龄", "月"};
		language.localityLabels = new String[] {
				"采集地点", "地区", "纬度", "经度"};
		language.commentLabel = "备注";
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
			HorseLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
