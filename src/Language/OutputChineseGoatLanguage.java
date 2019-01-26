/**
 * @author ������ 
 * @date : 2017��7��17�� ����2:57:39
 */
package Language;
import java.util.*;
import java.util.Locale;

public class OutputChineseGoatLanguage {

	public static void main(String[] args) {
		GoatLanguage language = new GoatLanguage("Chinese");
		
		language.colorCandidate  = new String[]{
				"ȫ��", "ȫ��", "ȫ��", "ͷ��", "ͷ��", "�廨", "��"};
		language.skinColorCandidate = new String[] {
				"��", "��", "��", "��"};
		language.sexCandidate = new String[]{"male", "female"};
		language.cavelCandidate = new String[]{"��", "��"};
		language.cavelShapeCandidate = new String[] {
				"��׳", "��ϸ", "������", "С����", "���ν�", "������", "������", "ֱ����",
				"������", "����", "С��"};
		language.noseCandidate  = new String[]{
				"¡��", "ƽֱ", "����"};
		language.earCandidate = new String[]{
				"ֱ��", "�´�"};
		language.neckCandidate = new String[]{
				"��", "ϸ", "��", "��"};
		language.limbsCandidate = new  String[]{
				"��", "ϸ", "�ȸ�", "�Ȱ�"};
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
			
		System.out.println(countries.indexOf("�й�"));
		
		language.sexCandidate = new String[] {
				"����", "����"};

		language.headTypeCandidate = new String[] {
				"��","��","С"};
		language.foreheadCandidate = new String[] {
				"��", "ƽ","խ","¡"};
		language.tailTypeCandidate = new String[] {
				"��֬β", "��֬β", "����β", "֬��β", "����β"};
		
		language.buttonNames = new String[]	 {
				"���", "����", "��С", "����", "���", "�޸�", "����ļ�", "ѡ��ͼƬ", "�������","������ҳ��"};
		language.dateLabels = new String[] {
				"����", "��", "��", "��"};
		language.speicesLabel = "Ʒ��";
		language.sexLabel = "�Ա�";
		language.ageLabels = new String[] {
				"����", "��"};
		language.localityLabels = new String[] {
				"�ɼ��ص�", "����", "γ��", "����"};
		language.headLabels = new String[] {
				"ͷ��", "��", "��"
		};
		language.foreheadLabel = "��";
		language.cavelLabel = "��";
		language.earLabels = new String[] {
				"��", "��", "��"};
		language.noseLabel = "��";
		language.neckLabel = "����";
		language.bodyLengthLabel = "�峤";
		language.bodyHeightLabel = "���";
		language.bodyDipLengthedLabel = "б�峤";
		language.furtherColorLabel = "ëɫ";
		language.skinColorLabel = "��ɫ";
		language.limbsLabel = "��֫";
		language.bustLabel = "��Χ";
		language.bustWidthLabel = "�ؿ�";
		language.bustDepthLabel = "����";
		language.tailLabels = new String[] {
				"β��", "��", "��"
		};
		language.weightLabel = "����";
		language.farrowLabel = "������";
		language.commentLabel = "��ע";
		
		language.neckCheckBox = new String[] {
				"�ⴹ", "����", "����"};
		
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
			GoatLanguage.outputLanguage(language);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
