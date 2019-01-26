package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputEnglishHorseLanguage {

	public static void main(String[] args) {
		HorseLanguage language = new HorseLanguage("English");
		
		language.furtherColorCandidate = new String[] {
				"Green hair", "Hairy hair", "Black hair", "Chestnut hair",
				"Hairy", "Rabbit brown hair",
				"Sea monkey hair", "Black Chestnut", "Sand color", "Silver mane",
				"Galaxy", "Mouse gray"
		};
		language.furtherColorLabel = "Coat color";
		language.weightLabel = "Weight";
		language.bodyLengthLabel = "body height";
		language.bodyHeigthLabel = "body length";
		language.bodyLengthExponentLabel = "Body length index";
		language.bustLabel = "chest circumference";
		language.bustExponentLabel = "Bust Index";
		language.cannonLabel = "tube circumference";
		language.cannonExponentLabel = "Tube circumference index";
		language.slaughterRateLabel = "Slaughter rate";
		language.carcassMeatFactorLabel = "Carcass meat and meat rate";
		language.meatBoneRatioLabel = "meat and bone ratio";
		language.musculiOculiLabel = "eye muscle area";
		language.legMuscleThicknessLabel = "thigh muscle thick";
		language.waistMuscleThicknessLabel = "waist Muscle thick";
		language.legFatThicknessLabel = "thigh Fat thickness";
		language.waistFatThicknessLabel = "waist Fat thickness";
		
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
		language.commentLabel = "comment";
		
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
		}
		

		language.imageChooser = "choose picture (ctrl to multiple choice)";
		
		language.statusLabels = new String[] {
				"search by ID",
				"ID must be a number",
				" has been found",
				" data not exist",
				" data has been added",
				"Are you sure to change the data£ºID = ",
				" data has been changed",
				"Are you sure to go home page£¿",
				"Are you sure to add data with ID = ",
				"export failure",
				"Do you want to export an excel file£¿ if 'No' will export a txt file",
				"Export successfully£¬The file is in£º",
				"picture inport failure"
		};
		
		try {
			HorseLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
