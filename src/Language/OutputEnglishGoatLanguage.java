/**
 * @author 王鑫祉 
 * @date : 2017年7月17日 下午2:57:39
 */
package Language;
import java.util.*;
import java.util.Locale;

public class OutputEnglishGoatLanguage {

	public static void main(String[] args) {
		GoatLanguage language = new GoatLanguage("English");
		
		language.colorCandidate  = new String[]{
				"all-white", "all-black", "all-brown", "head-black", 
				"head-brown", "Spotted", "linen"};
		language.skinColorCandidate = new String[] {
				"white", "black", "pink", "red"};
		language.sexCandidate = new String[]{"male", "female"};
		language.cavelCandidate = new String[]{"yes", "none"};
		language.cavelShapeCandidate = new String[] {
				"Stout", "slender", "large helix", "small helix", 
				"arcuate", "sickle", "rotation", "upright",
				"inverted octagonal", "ginger", "small"};
		language.noseCandidate  = new String[]{
				"Uplift", "straight", "concave"};
		language.earCandidate = new String[]{
				"up-right", "droop"};
		language.neckCandidate = new String[]{
				"thick", "shrink", "long", "short"};
		language.limbsCandidate = new  String[]{
				"Stout", "slender", "tall legs", "short legs"};
		Locale[] list = Locale.getAvailableLocales();
		List<String> countries = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			String src = list[i].getDisplayCountry(new Locale("en_US"));
			if (src != null && src.length() != 0 && !countries.contains(src)) {
				countries.add(src);
			}
		}
		language.countryCandidate = new String[countries.size()];
		for (int i = 0; i < countries.size(); i++) {
			language.countryCandidate[i] = countries.get(i);
			System.out.println(countries.get(i));
		}
			
		System.out.println(countries.indexOf("China"));

		language.headTypeCandidate = new String[] {
				"big","middle","small"};
		language.foreheadCandidate = new String[] {
				"Wide", "flat","narrow","uplift"};
		language.tailTypeCandidate = new String[] {
				"Short fat tail", "long tail tail", "short thin tail",
				"fat buttocks tail", "long thin tail"};
		
		language.buttonNames = new String[]	 {
				"clear", "enlarge", "shrink", "search", "add", "change", "output file", "choose picture", 
				"quantity output", "back home"};
		language.dateLabels = new String[] {
				"date", "year", "month", "day"};
		language.speicesLabel = "speices";
		language.sexLabel = "gender";
		language.sexCandidate = new String[]{"male", "female"};
		language.ageLabels = new String[] {
				"age", "months"};
		language.localityLabels = new String[] {
				"locality", "region", "latitude", "longitude"};
		language.headLabels = new String[] {
				"head", "length", "width"
		};
		language.foreheadLabel = "forehead";
		language.cavelLabel = "cavel";
		language.earLabels = new String[] {
				"ear", "length", "width"};
		language.noseLabel = "nose";
		language.neckLabel = "neck";
		language.bodyLengthLabel = "body length";
		language.bodyHeightLabel = "body height";
		language.bodyDipLengthedLabel = "body oblique length";
		language.furtherColorLabel = "coat colour";
		language.skinColorLabel = "skin color";
		language.limbsLabel = "limbs";
		language.bustLabel = "chest circumference";
		language.bustWidthLabel = "bust width";
		language.bustDepthLabel = "bust depth";
		language.tailLabels = new String[] {
				"tail", "length", "width"
		};
		language.weightLabel = "weight";
		language.farrowLabel = "farrow number";
		language.commentLabel = "comment";
		
		language.neckCheckBox = new String[] {
				"meat", "wrinkle", "beard"};
		
		language.imageChooser = "choose picture (ctrl to multiple choice)";
		
		language.statusLabels = new String[] {
				"search by ID",
				"ID must be a number",
				" has been found",
				" data not exist",
				" data has been added",
				"Are you sure to change the data：ID = ",
				" data has been changed",
				"Are you sure to go home page？",
				"Are you sure to add data with ID = ",
				"export failure",
				"Do you want to export an excel file？ if 'No' will export a txt file",
				"Export successfully，The file is in：",
				"picture inport failure"
		};
				
		try {
			GoatLanguage.outputLanguage(language);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
