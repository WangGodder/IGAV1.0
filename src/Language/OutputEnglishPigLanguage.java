package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputEnglishPigLanguage {

	public static void main(String[] args) {
		PigLanguage language = new PigLanguage("English");
		
		language.furtherColor = new String[] {
			"black", "white", "maroon", "black and white"	
		};
		language.bodyLengthLabel = "body length";
		language.bodyHeightLabel = "body height";
		language.weightLabel = "Weight";
		language.bustLabel = "chest circumference";
		language.carcassWeightLabel = "Carcass weight";
		language.slaughterRateLabel = "slaughter rate";
		language.backfatThicknessOfAverageLabel = "Average backfat thickness";
		language.backfatThicknessOfSixSevenLabel = "6-7 rib backfill thick";
		language.skinThicknessLabel = "Thick skin";
		language.musculiOculiLabel = "Eye muscle area";
		language.meatFactorLabel = "Lean meat rate";
		language.meatColorLabel = "Flesh color";
		language.marblingLabel = "Marble pattern";
		language.PHLabel = "pH(24h)";
		language.crudeProteinLabel = "Crude protein";
		language.imfLabel = "Intramuscular fat";
		language.waterProportionLabel = "Moisture";
		language.crudeAshLabel = "Coarse ash";
		language.furtherColorLabel = "coat colour";

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
			PigLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
