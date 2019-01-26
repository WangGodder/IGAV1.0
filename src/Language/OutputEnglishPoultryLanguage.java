package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputEnglishPoultryLanguage {

	public static void main(String[] args) {
		PoultryLanguage language = new PoultryLanguage("English");
		
		language.eggColorCandidate = new String[] {
				"brown", "green", "white", "Pink", "blue"
		};
		language.neckCharacterCandidate = new String[] {
				"Feather rich", "Feather sparse", "Bald neck"
		};
		language.combCandidate = new String[] {
				"Single crown", "Bean crown", "Rose crown", "Walnut crown",
				"Feather crown", "Corner crown", "V-crown"
		};
		language.skinColorCandidate = new String[] {
				"black", "yellow", "white", "pink", "other"
		};
		language.legCharacterCandidate = new String[] {
				"Long", "medium", "short"
		};
		language.bodyCharacterCandidate = new String[] {
				"compact", "emaciated", "obesity", "slim"
		};
		language.weightLabel = "weight";
		language.bodyDipLengthLabel = "Body slant long";
		language.bustWidthLabel = "Chest width";
		language.bustDepthLabel = "Chest deep";
		language.sternumLengthLabel = "Long keel";
		language.shinLengthLabel = "Tibia long";
		language.shinCircumferenceLabel = "Tibia circumference";
		language.pelvisWidthLabel = "Pelvic width";
		language.killWeightLabel = "Slaughter activity";
		language.slaughterWeightLabel = "Slaughter heavy";
		language.slaughterRateLabel = "Slaughter rate";
		language.chamberHalfNetRateLabel = "Half net load rate";
		language.chamberAllNetRateLabel = "Full net rate";
		language.legMuscleRateLabel = "Leg muscle rate";
		language.breastMuscleRateLabel = "Breast rate";
		language.AFYLabel = "Abdominal fat rate";
		language.eggWeightLabel = "Egg weight";
		language.eggShapeIndexLabel = "Egg shape index";
		language.eggShellSERLabel = "Egg shell strength";
		language.eggShellThicknessLabel = "Egg shell thickness";
		language.eggColorLabel = "Egg shell color";
		language.yolkRateLabel = "Egg yolk ratio";
		language.earColorLabel = "Ear color";
		language.mouthShapeLabel = "Beak type";
		language.neckCharacterLabel = "Neck";
		language.combLabel = "Crown type";
		language.skinColorLabel = "color";
		language.legCharacterLabel = "Leg and neck";
		language.clawColorLabel = "Claw color";
		language.webColorLabel = "web color";
		language.bodyCharacterLabel = "size";

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
			PoultryLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
