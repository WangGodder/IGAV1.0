/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:57:29
 */
package Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseCattleLanguage {

	public static void main(String[] args) {
		CattleLanguage language =new CattleLanguage("Chinese");
		
		language.furtherColorCandidate = new String[] {
			"红色", "黄色", "黑色", "棕色", "紫色", "灰色", "褐色", "橙黄色", "黄红色",
			"棕黄色", "青色", "灰白色", "枣红色", "黄褐色"
		};
		language.cavelCandidate = new String[] {
			"无", "倒八字角", "铃铃角", "小园环角", "龙门角", "扁担角", "长角", "短角",
			"一字形", "迎风角", "平角", "鹰爪角", "绵羊角", "顺风角", "毛笋角", "叉角",
			"笋角", "铃铛角", "小角", "胡萝卜角", "芋头角", "小园环角", "羊叉角", "挑担角","大圆环角"
		};
		language.acromionCandidate = new String[] {
			"无", "高峰型", "肥峰型"
		};
		
		language.bodyLengthLabel = "体长";
		language.weightLabel = "体重";
		language.bodyHeightLabel = "体高";
		language.bodyDipLengthLabel = "体斜长";
		language.killWeightLabel = "宰前活重";
		language.bustLabel = "胸围";
		language.cannonLabel = "管围";
		language.carcassWeightLabel = "胴体重";
		language.pureMeatLabel = "净肉率";
		language.skinThicknessLabel = "皮厚";
		language.skeletonWeightLabel = "骨骼重";
		language.musculiOculiLabel = "眼肌面积";
		language.slaughterRateLabel = "屠宰率";
		language.meatBoneRatioLabel = "肉骨率";
		language.cavelLabel = "牛角";
		language.acromionLabel = "肩峰";
		language.furtherColorLabel = "毛色";
		
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
			CattleLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
