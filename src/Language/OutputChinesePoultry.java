package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChinesePoultry {

	public static void main(String[] args) {
		PoultryLanguage language = new PoultryLanguage("Chinese");
		
		language.eggColorCandidate = new String[] {
				"褐色", "绿色", "白色", "粉色", "青色"
		};
		language.neckCharacterCandidate = new String[] {
				"羽毛丰富", "羽毛稀疏", "秃颈"
		};
		language.combCandidate = new String[] {
				"单冠", "豆冠", "玫瑰冠", "胡桃冠", "羽毛冠", "羽毛冠", "V型冠"
		};
		language.skinColorCandidate = new String[] {
				"黑色", "黄色", "白色", "粉色", "其他"
		};
		language.legCharacterCandidate = new String[] {
				"长", "中", "短"
		};
		language.bodyCharacterCandidate = new String[] {
				"紧凑", "瘦弱", "肥胖", "纤悉"
		};
		language.weightLabel = "体重";
		language.bodyDipLengthLabel = "斜体长";
		language.bustWidthLabel = "胸宽";
		language.bustDepthLabel = "胸深";
		language.sternumLengthLabel = "龙骨长";
		language.shinLengthLabel = "胫长";
		language.shinCircumferenceLabel = "胫围";
		language.pelvisWidthLabel = "骨盆宽 ";
		language.killWeightLabel = "宰前活量";
		language.slaughterWeightLabel = "屠体重";
		language.slaughterRateLabel = "屠宰率";
		language.chamberHalfNetRateLabel = "半净膛率";
		language.chamberAllNetRateLabel = "全净膛率";
		language.legMuscleRateLabel = "腿肌率";
		language.breastMuscleRateLabel = "胸肌率";
		language.AFYLabel = "腹脂率 ";
		language.eggWeightLabel = "蛋重";
		language.eggShapeIndexLabel = "蛋形指数";
		language.eggShellSERLabel = "蛋壳强度";
		language.eggShellThicknessLabel = "蛋壳厚度";
		language.eggColorLabel = "蛋壳色泽";
		language.yolkRateLabel = "蛋黄比率 ";
		language.earColorLabel = "耳色";
		language.mouthShapeLabel = "喙型";
		language.neckCharacterLabel = "脖颈";
		language.combLabel = "冠型";
		language.skinColorLabel = "肤色";
		language.legCharacterLabel = "腿颈";
		language.clawColorLabel = "爪色";
		language.webColorLabel = "蹼色";
		language.bodyCharacterLabel = "体型";
		
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
			PoultryLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
