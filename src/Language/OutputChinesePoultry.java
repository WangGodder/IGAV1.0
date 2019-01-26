package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChinesePoultry {

	public static void main(String[] args) {
		PoultryLanguage language = new PoultryLanguage("Chinese");
		
		language.eggColorCandidate = new String[] {
				"��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ"
		};
		language.neckCharacterCandidate = new String[] {
				"��ë�ḻ", "��ëϡ��", "ͺ��"
		};
		language.combCandidate = new String[] {
				"����", "����", "õ���", "���ҹ�", "��ë��", "��ë��", "V�͹�"
		};
		language.skinColorCandidate = new String[] {
				"��ɫ", "��ɫ", "��ɫ", "��ɫ", "����"
		};
		language.legCharacterCandidate = new String[] {
				"��", "��", "��"
		};
		language.bodyCharacterCandidate = new String[] {
				"����", "����", "����", "��Ϥ"
		};
		language.weightLabel = "����";
		language.bodyDipLengthLabel = "б�峤";
		language.bustWidthLabel = "�ؿ�";
		language.bustDepthLabel = "����";
		language.sternumLengthLabel = "���ǳ�";
		language.shinLengthLabel = "�ֳ�";
		language.shinCircumferenceLabel = "��Χ";
		language.pelvisWidthLabel = "����� ";
		language.killWeightLabel = "��ǰ����";
		language.slaughterWeightLabel = "������";
		language.slaughterRateLabel = "������";
		language.chamberHalfNetRateLabel = "�뾻����";
		language.chamberAllNetRateLabel = "ȫ������";
		language.legMuscleRateLabel = "�ȼ���";
		language.breastMuscleRateLabel = "�ؼ���";
		language.AFYLabel = "��֬�� ";
		language.eggWeightLabel = "����";
		language.eggShapeIndexLabel = "����ָ��";
		language.eggShellSERLabel = "����ǿ��";
		language.eggShellThicknessLabel = "���Ǻ��";
		language.eggColorLabel = "����ɫ��";
		language.yolkRateLabel = "���Ʊ��� ";
		language.earColorLabel = "��ɫ";
		language.mouthShapeLabel = "���";
		language.neckCharacterLabel = "����";
		language.combLabel = "����";
		language.skinColorLabel = "��ɫ";
		language.legCharacterLabel = "�Ⱦ�";
		language.clawColorLabel = "צɫ";
		language.webColorLabel = "��ɫ";
		language.bodyCharacterLabel = "����";
		
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
			PoultryLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
