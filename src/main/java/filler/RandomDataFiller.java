package filler;


import entities.Animal;
import entities.Barrel;
import entities.Human;
import util.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomDataFiller<Entity> implements Filler<Entity> {
	private final String[] animalSpecies = {"слон", "тигр", "лев", "жираф", "зебра", "кенгуру", "коала", "медведь", "волк", "лиса", "бобр", "еж", "кабан", "олень", "лось", "антилопа", "козел", "овца", "корова", "лошадь", "осел", "верблюд", "буйвол", "носорог", "гиппопотам", "горилла", "шимпанзе", "орангутан", "панда", "ягуар", "гепард", "леопард", "пума", "рысь", "каракал", "манул", "енот", "барсук", "хорек", "выдра", "норка", "куница", "сурикат", "дикобраз", "тапир", "ленивец", "муравьед", "броненосец"};
	private final String[] animalEyeColor = {"голубой", "зеленый", "карий", "серый", "черный", "янтарный", "ореховый", "бирюзовый", "сапфировый", "лазурный", "изумрудный", "аквамариновый", "нефритовый", "оливковый", "медовый", "шоколадный", "вишневый", "фиалковый", "аметистовый", "серо-голубой", "серо-зеленый", "золотистый", "пепельный", "стальной", "платиновый", "бронзовый", "кобальтовый", "индиго", "лиловый", "лавандовый", "бордовый", "графитовый", "карамельный", "кофейный", "темно-карий", "темно-зеленый", "темно-синий", "темно-серый", "светло-карий", "светло-зеленый", "светло-голубой", "светло-серый", "персиковый", "пурпурный", "малиновый", "гранатовый", "сине-зеленый", "серо-карий"};
	private final String[] barrelContent = {"вино", "пиво", "вода", "масло", "мед", "соленья", "варенье", "уксус", "спирт", "квас", "сок", "жидкое мыло", "глицерин", "патока", "соус", "рыбий жир", "соляной раствор", "патока", "молоко", "кефир", "йогурт", "сливки", "сквашенное молоко", "брага", "сидр", "ликер", "ром", "виски", "водка", "коньяк", "текила", "джин", "бальзам", "настойка", "самогон", "протеины", "оливковое масло", "подсолнечное масло", "кунжутное масло", "арахисовое масло", "кокосовое масло", "рапсовое масло", "льняное масло", "горчичное масло", "виноградное масло", "масло авокадо", "масло грецкого ореха", "масло тыквенных семечек"};
	private final String[] barrelMade = {"дуб", "ясень", "кедр", "сосна", "ель", "береза", "бук", "орех", "акация", "каштан", "ольха", "лиственница", "тополь", "граб", "клён", "вишня", "яблоня", "груша", "тополь", "осина", "махагон", "тик", "пальма", "бамбук", "ротанг", "железо", "сталь", "нержавеющая сталь", "алюминий", "медь", "бронза", "латунь", "цинк", "олово", "свинец", "чугун", "бетон", "пластик", "полипропилен", "поливинилхлорид (ПВХ)", "стекловолокно", "карбон", "керамика", "глина", "фарфор", "стекло", "кварцит", "гранит"};
	private final String[] personSurname = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Егоров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семенов", "Голубев", "Виноградов", "Богданов", "Воробьев", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров", "Орлов", "Киселев", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев", "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров", "Борисов", "Королев", "Герасимов"};

	@Override
	public List fill(String entity) {
		int n = InputUtils.getInt("Количество: ");
		List entities = null;
		switch (entity) {
			case "animal":
				entities = new ArrayList<Animal>();
				for (int i = 0; i < n; i++) {

					String species = animalSpecies[(int) (Math.random() * animalSpecies.length)];
					String eyeColor = animalEyeColor[(int) (Math.random() * animalEyeColor.length)];
					boolean fur = Math.random() > 0.5 ? true : false;

                    /*if (!ValidationUtils.isValidAnimalData(species, eyeColor, fur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Animal.AnimalBuilder(species, eyeColor).fur(fur).build());

				}
				break;
			case "barrel":
				entities = new ArrayList<Barrel>();
				for (int i = 0; i < n; i++) {

					String storedMaterial = barrelContent[(int) (Math.random() * barrelContent.length)];
					String fromMaterial = barrelMade[(int) (Math.random() * barrelMade.length)];
					Integer volume = (int) (Math.random() * 600);

                   /* if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Barrel.BarrelBuilder(storedMaterial, fromMaterial, volume).build());

				}
				break;
			case "person":
				entities = new ArrayList<Human>();
				for (int i = 0; i < n; i++) {

					String gender = Math.random() > 0.5 ? "М" : "Ж";
					String secondName = personSurname[(int) (Math.random() * personSurname.length)] + (gender.equals("Ж") ? "а" : "");
					Integer age = (int) (Math.random() * 95) + 5;

                   /* if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Human.HumanBuilder(gender,secondName,age).build());

				}
				break;

		}

		return entities;
	}


}
