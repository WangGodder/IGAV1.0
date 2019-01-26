package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChinesePigLanguage {

	public static void main(String[] args) {
		PigLanguage language = new PigLanguage("Chinese");
		
		language.furtherColor = new String[] {
			"黑色", "白色", "棕红色", "黑白相间"	
		};
		language.bodyLengthLabel = "体长";
		language.bodyHeightLabel = "体高";
		language.weightLabel = "体重";
		language.bustLabel = "胸围";
		language.carcassWeightLabel = "胴体重";
		language.slaughterRateLabel = "屠宰率";
		language.backfatThicknessOfAverageLabel = "平均背膘厚";
		language.backfatThicknessOfSixSevenLabel = "6-7肋背膘厚";
		language.skinThicknessLabel = "皮厚";
		language.musculiOculiLabel = "眼肌面积";
		language.meatFactorLabel = "瘦肉率";
		language.meatColorLabel = "肉色";
		language.marblingLabel = "大理石纹";
		language.PHLabel = "pH(24h)";
		language.crudeProteinLabel = "粗蛋白";
		language.imfLabel = "肌内脂肪";
		language.waterProportionLabel = "水分";
		language.crudeAshLabel = "粗灰分";
		language.furtherColorLabel = "毛色";

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
			PigLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
