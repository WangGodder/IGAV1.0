package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseHorseLanguage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HorseLanguage language = new HorseLanguage("Chinese");
		
		language.furtherColorCandidate = new String[] {
				"��ë", "��ë", "��ë", "��ë", "��ë", "��ë", "�ú�ë",
				"����ë", "�ڿ���ë", "ɳɫ", "����", "����", "���ɫ"
		};
		language.weightLabel = "����";
		language.bodyLengthLabel = "�峤";
		language.bodyHeigthLabel = "���";
		language.bodyLengthExponentLabel = "�峤ָ��";
		language.bustLabel = "��Χ";
		language.bustExponentLabel = "��Χָ��";
		language.cannonLabel = "��Χ";
		language.cannonExponentLabel = "��Χָ��";
		language.slaughterRateLabel = "������";
		language.carcassMeatFactorLabel = "���徻����";
		language.meatBoneRatioLabel = "��Ǳ�";
		language.musculiOculiLabel = "�ۼ����";
		language.legMuscleThicknessLabel = "���ȼ����";
		language.waistMuscleThicknessLabel = "���������";
		language.legFatThicknessLabel = "����֬�����";
		language.waistFatThicknessLabel = "����֬�����";
		
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
			HorseLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
