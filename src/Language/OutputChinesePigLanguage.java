package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChinesePigLanguage {

	public static void main(String[] args) {
		PigLanguage language = new PigLanguage("Chinese");
		
		language.furtherColor = new String[] {
			"��ɫ", "��ɫ", "�غ�ɫ", "�ڰ����"	
		};
		language.bodyLengthLabel = "�峤";
		language.bodyHeightLabel = "���";
		language.weightLabel = "����";
		language.bustLabel = "��Χ";
		language.carcassWeightLabel = "������";
		language.slaughterRateLabel = "������";
		language.backfatThicknessOfAverageLabel = "ƽ�������";
		language.backfatThicknessOfSixSevenLabel = "6-7�߱����";
		language.skinThicknessLabel = "Ƥ��";
		language.musculiOculiLabel = "�ۼ����";
		language.meatFactorLabel = "������";
		language.meatColorLabel = "��ɫ";
		language.marblingLabel = "����ʯ��";
		language.PHLabel = "pH(24h)";
		language.crudeProteinLabel = "�ֵ���";
		language.imfLabel = "����֬��";
		language.waterProportionLabel = "ˮ��";
		language.crudeAshLabel = "�ֻҷ�";
		language.furtherColorLabel = "ëɫ";

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
				"���", "����", "��С", "����", "���", "�޸�", "����ļ�", "ѡ��ͼƬ", "�������","������ҳ��"};
		language.dateLabels = new String[] {
				"����", "��", "��", "��"};
		language.speicesLabel = "Ʒ��";
		language.sexLabel = "�Ա�";
		language.sexCandidate = new String[] {
				"����", "����"};
		language.ageLabels = new String[] {
				"����", "��"};
		language.localityLabels = new String[] {
				"�ɼ��ص�", "����", "γ��", "����"};
		language.commentLabel = "��ע";
		language.imageChooser = "ѡ��ͼƬ(ctrl��ѡ)";
		
		language.statusLabels = new String[] {
				"ͨ��ID���в���",
				"ID�����밢��������",
				" �ѱ��ҵ�",
				" ����δ����",
				" �Ѽ�������",
				"ȷ��Ҫ�������ݣ�ID = ",
				" �����Ѹ���",
				"ȷ��������ҳ��",
				"ȷ�����ID = ",
				"����ʧ��",
				"�Ƿ񵼳�excel�ļ��� �����txt�ļ�",
				"�����ɹ����ļ�λ���ļ��У�",
				"ͼƬ����ʧ��"
		};
		
		try {
			PigLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
