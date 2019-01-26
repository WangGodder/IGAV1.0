package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OutputEnglishBeeLanguage {

	public static void main(String[] args) {
	BeeLanguage language = new BeeLanguage("English");
		
		language.colorCandidate = new String[] {
				"black", "dark Grey", "maroon", "dark brown", "brown", 
				"Yellowish gray", "brown", "yellow"
		};
		language.colorLabel = "color";
		language.mouthLengthLabel = "Beak long	";
		language.foreWineLengthLabel = "Front wing long";
		language.foreWineWidthLabel = "Front wing wide";
		language.brachiumIndexLabel = "Elbow pulse index";
		language.bellyBackboardOf34Label = "3 + 4 abdomen backplane total length ";
		language.honeyWeightLabel = "honey";
		language.royalJellyWeightLabel = "Royal jelly";
		language.beePollenWeightLabel = "Bee pollen";
		language.propolisWeightLabel = "Propolis";
		language.beewaxWeightLabel = "beeswax";
		language.waterOfHoneyLabel = "Honey moisture content ";
		
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
			System.out.println(countries.get(i));
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
			BeeLanguage.outputLanguage(language);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
