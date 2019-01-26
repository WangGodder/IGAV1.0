package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseBeeLanguage {

	public static void main(String[] args) {
		BeeLanguage language = new BeeLanguage("Chinese");
		
		language.colorCandidate = new String[] {
				"黑色", "黑灰色", "棕红色", "黑褐色", "褐色", "黄灰色", "棕色", "黄色"
		};
		language.colorLabel = "颜色";
		language.mouthLengthLabel = "喙长	";
		language.foreWineLengthLabel = "前翅长";
		language.foreWineWidthLabel = "前翅宽";
		language.brachiumIndexLabel = "肘脉指数";
		language.bellyBackboardOf34Label = "3+4腹节背板总长 ";
		language.honeyWeightLabel = "蜂蜜";
		language.royalJellyWeightLabel = "蜂王浆";
		language.beePollenWeightLabel = "峰花粉";
		language.propolisWeightLabel = "蜂胶";
		language.beewaxWeightLabel = "蜂蜡";
		language.waterOfHoneyLabel = "蜂蜜含水量 ";
		
		Locale[] list = Locale.getAvailableLocales();
		List<String> countries = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			String src = list[i].getDisplayCountry();
			if (src != null && src.length() != 0 && !countries.contains(src)) {
				countries.add(src);
				System.out.println(src);
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
			BeeLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
