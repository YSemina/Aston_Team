package org.example.filler;


import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Person;
import org.example.util.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomDataFiller<Entity> implements Filler<Entity> {
	private final String[] animalSpecies = {"слон", "тигр", "лев", "жираф", "зебра", "кенгуру", "коала", "медведь", "волк", "лиса", "бобр", "еж", "кабан", "олень", "лось", "антилопа", "козел", "овца", "корова", "лошадь", "осел", "верблюд", "буйвол", "носорог", "гиппопотам", "горилла", "шимпанзе", "орангутан", "панда", "ягуар", "гепард", "леопард", "пума", "рысь", "каракал", "манул", "енот", "барсук", "хорек", "выдра", "норка", "куница", "сурикат", "дикобраз", "тапир", "ленивец", "муравьед", "броненосец"};
	private final String[] animalEyeColor = {"голубой", "зеленый", "карий", "серый", "черный", "янтарный", "ореховый", "бирюзовый", "сапфировый", "лазурный", "изумрудный", "аквамариновый", "нефритовый", "оливковый", "медовый", "шоколадный", "вишневый", "фиалковый", "аметистовый", "серо-голубой", "серо-зеленый", "золотистый", "пепельный", "стальной", "платиновый", "бронзовый", "кобальтовый", "индиго", "лиловый", "лавандовый", "бордовый", "графитовый", "карамельный", "кофейный", "темно-карий", "темно-зеленый", "темно-синий", "темно-серый", "светло-карий", "светло-зеленый", "светло-голубой", "светло-серый", "персиковый", "пурпурный", "малиновый", "гранатовый", "сине-зеленый", "серо-карий"};
	private final String[] barrelContent = {"вино", "пиво", "вода", "масло", "мед", "соленья", "варенье", "уксус", "спирт", "квас", "сок", "жидкое мыло", "глицерин", "патока", "соус", "рыбий жир", "соляной раствор", "патока", "молоко", "кефир", "йогурт", "сливки", "сквашенное молоко", "брага", "сидр", "ликер", "ром", "виски", "водка", "коньяк", "текила", "джин", "бальзам", "настойка", "самогон", "протеины", "оливковое масло", "подсолнечное масло", "кунжутное масло", "арахисовое масло", "кокосовое масло", "рапсовое масло", "льняное масло", "горчичное масло", "виноградное масло", "масло авокадо", "масло грецкого ореха", "масло тыквенных семечек"};
	private final String[] barrelMade = {"дуб", "ясень", "кедр", "сосна", "ель", "береза", "бук", "орех", "акация", "каштан", "ольха", "лиственница", "тополь", "граб", "клён", "вишня", "яблоня", "груша", "тополь", "осина", "махагон", "тик", "пальма", "бамбук", "ротанг", "железо", "сталь", "нержавеющая сталь", "алюминий", "медь", "бронза", "латунь", "цинк", "олово", "свинец", "чугун", "бетон", "пластик", "полипропилен", "поливинилхлорид (ПВХ)", "стекловолокно", "карбон", "керамика", "глина", "фарфор", "стекло", "кварцит", "гранит"};
	private final String[] personSurname = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Егоров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семенов", "Голубев", "Виноградов", "Богданов", "Воробьев", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров", "Орлов", "Киселев", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев", "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров", "Борисов", "Королев", "Герасимов"};

//	private final String[] animalSpecies = {"elephant", "tiger", "lion", "giraffe", "zebra", "kangaroo", "koala", "bear", "wolf", "fox", "beaver", "hedgehog", "boar", "deer", "elk", "antelope", "goat", "sheep", "cow", "horse", "donkey", "camel", "buffalo", "rhinoceros", "hippopotamus", "gorilla", "chimpanzee", "orangutan", "panda", "jaguar", "cheetah", "leopard", "puma", "lynx", "caracal", "manul", "raccoon", "badger", "ferret", "otter", "mink", "marten", "meerkat", "porcupine", "tapir", "sloth", "anteater", "armadillo"};
//	private final String[] animalEyeColor = {"blue", "green", "brown", "gray", "black", "amber", "walnut", "turquoise", "sapphire", "azure", "emerald", "aquamarine", "jade", "olive", "honey", "chocolate", "cherry", "violet", "amethyst", "gray-blue", "gray-green", "gold", "ash", "steel", "platinum", "bronze", "cobalt", "indigo", "mauve", "lavender", "burgundy", "graphite", "caramel", "coffee", "dark brown", "dark green", "dark blue", "dark gray", "light brown", "light green", "light blue", "light gray", "peach", "magenta", "crimson", "garnet", "blue - green", "gray - blue"};
//	private final String[] barrelContent = {"wine", "beer", "water", "oil", "honey", "pickles", "jam", "vinegar", "alcohol", "kvass", "juice", "liquid soap", "glycerin", "molasses", "sauce", "fish oil", "salt solution", "molasses", "milk", "kefir", "yogurt", "cream", "fermented milk", "brogue", "cider", "liquor", "rum", "whiskey", "vodka", "brandy", "tequila", "gin", "balsam", "tincture", "moonshine", "protein", "olive oil", "sunflower oil", "sesame oil", "peanut oil", "coconut oil", "rapeseed oil", "flaxseed oil", "mustard oil", "grapeseed oil", "avocado oil", "walnut oil", "pumpkin seed oil"};
//
//	private final String[] barrelMade = {"oak", "ash", "cedar", "pine", "spruce", "birch", "beech", "walnut", "acacia", "chestnut", "alder", "larch", "poplar", "hornbeam", "maple", "cherry", "apple", "pear", "poplar", "aspen", "mahogany", "teak", "palm", "bamboo", "rattan", "iron", "steel", "stainless steel", "aluminum", "copper", "bronze", "brass", "zinc", "tin", "lead", "cast iron", "concrete", "plastic", "polypropylene", "polyvinyl chloride(PVC)", "fiberglass", "carbon", "ceramic", "clay", "porcelain", "glass", "quartzite", "granite"};
//	private final String[] personSurname = {"Ivanov", "Petrov", "Sidorov", "Kuznetsov", "Smirnov", "Popov", "Lebedev", "Kozlov", "Novikov", "Morozov", "Egorov", "Volkov", "Solovyov", "Vasilyev", "Zaitsev", "Pavlov", "Semyonov", "Golubev", "Vinogradov", "Bogdanov", "Vorobyov", "Fedorov", "Mikhailov", "Belyaev", "Tarasov", "Belov", "Komarov", "Orlov", "Kiselev", "Makarov",  "Andreev",  "Kovalev",  "Ilyin",  "Gusev",  "Titov",  "Kuzmin",  "Kudryavtsev", "Baranov", "Kulikov", "Alekseev", "Stepanov", "Yakovlev", "Sorokin", "Sergeyev", "Romanov", "Zakharov", "Borisov", "Korolev", "Gerasimov"};

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
					boolean hasFur = Math.random() > 0.5 ? true : false;

                    /*if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Animal.Builder()
							.species(species)
							.eyeColor(eyeColor)
							.hasFur(hasFur)
							.build());
				}
				break;
			case "barrel":
				entities = new ArrayList<Barrel>();
				for (int i = 0; i < n; i++) {

					String content = barrelContent[(int) (Math.random() * barrelContent.length)];
					String made = barrelMade[(int) (Math.random() * barrelMade.length)];
					Integer volume = (int) (Math.random() * 600);

                   /* if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Barrel.Builder()
							.content(content)
							.made(made)
							.volume(volume)
							.build());
				}
				break;
			case "person":
				entities = new ArrayList<Person>();
				for (int i = 0; i < n; i++) {

					String gender = Math.random() > 0.5 ? "М" : "Ж";
					String surname = personSurname[(int) (Math.random() * personSurname.length)] + (gender.equals("Ж") ? "a" : "");
					Integer age = (int) (Math.random() * 95) + 5;

                   /* if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                        System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                        i--;
                        continue;
                    }*/

					entities.add(new Person.Builder()
							.gender(gender)
							.surname(surname)
							.age(age)
							.build());
				}
				break;

		}

		return entities;
	}


}
