package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseBeeLanguage {

	public static void main(String[] args) {
		BeeLanguage language = new BeeLanguage("Chinese");
		
		language.colorCandidate = new String[] {
				"��ɫ", "�ڻ�ɫ", "�غ�ɫ", "�ں�ɫ", "��ɫ", "�ƻ�ɫ", "��ɫ", "��ɫ"
		};
		language.colorLabel = "��ɫ";
		language.mouthLengthLabel = "๳�	";
		language.foreWineLengthLabel = "ǰ�᳤";
		language.foreWineWidthLabel = "ǰ���";
		language.brachiumIndexLabel = "����ָ��";
		language.bellyBackboardOf34Label = "3+4���ڱ����ܳ� ";
		language.honeyWeightLabel = "����";
		language.royalJellyWeightLabel = "������";
		language.beePollenWeightLabel = "�廨��";
		language.propolisWeightLabel = "�佺";
		language.beewaxWeightLabel = "����";
		language.waterOfHoneyLabel = "���ۺ�ˮ�� ";
		
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
			BeeLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
