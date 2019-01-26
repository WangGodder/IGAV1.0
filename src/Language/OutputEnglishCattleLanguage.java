package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputEnglishCattleLanguage {

	public static void main(String[] args) {
CattleLanguage language =new CattleLanguage("English");
		
		language.furtherColorCandidate = new String[] {
			"red", "yellow", "black", "brown", "purple", "gary", "orage", 
			"yellow and red",
			"brownish yellow", "bule", "gray", "red dates", "tan"
		};
		language.cavelCandidate = new String[] {
			"no", "inverted character", "Bell bells", "Small round corner", 
			"Longmen angle", "Pole angle", "Long angle", "Short angle",
			"One shape", "Wind angle", "Flat angle", "Eagle claw angle",
			"Sheep angle", "Downwind angle", "Tufted corners", "Fork angle",
			"Bamboo shoots", "Bells angle", "Small angle", "Radish corner",
			"Taro angle", "Sheep fork angle", "Pick the corner", "Large ring angle"
		};
		language.acromionCandidate = new String[] {
			"no", "peak type", "fertilizer type"
		};
		
		language.bodyLengthLabel = "body length";
		language.weightLabel = "weight";
		language.bodyHeightLabel = "body height";
		language.bodyDipLengthLabel = "body oblique length";
		language.killWeightLabel = "live-weight";
		language.bustLabel = "chest circumference";
		language.cannonLabel = "tube circumference";
		language.carcassWeightLabel = "carcass weight";
		language.pureMeatLabel = "pure meat percentage";
		language.skinThicknessLabel = "skin thickness";
		language.skeletonWeightLabel = "bone weight";
		language.musculiOculiLabel = "eye muscle area";
		language.slaughterRateLabel = "slaughter rate";
		language.meatBoneRatioLabel = "meat and bone ratio";
		language.cavelLabel = "horns";
		language.acromionLabel = "shoulder";
		language.furtherColorLabel = "coat colour";
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
			CattleLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
