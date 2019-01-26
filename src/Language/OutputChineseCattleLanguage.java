/**
 * @author ������ 
 * @date : 2017��7��17�� ����2:57:29
 */
package Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputChineseCattleLanguage {

	public static void main(String[] args) {
		CattleLanguage language =new CattleLanguage("Chinese");
		
		language.furtherColorCandidate = new String[] {
			"��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "�Ȼ�ɫ", "�ƺ�ɫ",
			"�ػ�ɫ", "��ɫ", "�Ұ�ɫ", "���ɫ", "�ƺ�ɫ"
		};
		language.cavelCandidate = new String[] {
			"��", "�����ֽ�", "�����", "С԰����", "���Ž�", "�ⵣ��", "����", "�̽�",
			"һ����", "ӭ���", "ƽ��", "ӥצ��", "�����", "˳���", "ë���", "���",
			"���", "������", "С��", "���ܲ���", "��ͷ��", "С԰����", "����", "������","��Բ����"
		};
		language.acromionCandidate = new String[] {
			"��", "�߷���", "�ʷ���"
		};
		
		language.bodyLengthLabel = "�峤";
		language.weightLabel = "����";
		language.bodyHeightLabel = "���";
		language.bodyDipLengthLabel = "��б��";
		language.killWeightLabel = "��ǰ����";
		language.bustLabel = "��Χ";
		language.cannonLabel = "��Χ";
		language.carcassWeightLabel = "������";
		language.pureMeatLabel = "������";
		language.skinThicknessLabel = "Ƥ��";
		language.skeletonWeightLabel = "������";
		language.musculiOculiLabel = "�ۼ����";
		language.slaughterRateLabel = "������";
		language.meatBoneRatioLabel = "�����";
		language.cavelLabel = "ţ��";
		language.acromionLabel = "���";
		language.furtherColorLabel = "ëɫ";
		
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
			CattleLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
