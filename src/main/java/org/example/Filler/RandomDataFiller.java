package org.example.filler;


import org.example.entity.Animal;
import org.example.util.InputUtils;
import org.example.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomDataFiller<Entity> implements Filler<Entity> {
    private final String[] animalSpecies = {"слон", "тигр", "лев", "жираф", "зебра", "кенгуру", "коала", "медведь", "волк", "лиса", "бобр", "еж", "кабан", "олень", "лось", "антилопа", "козел", "овца", "корова", "лошадь", "осел", "верблюд", "буйвол", "носорог", "гиппопотам", "горилла", "шимпанзе", "орангутан", "панда", "ягуар", "гепард", "леопард", "пума", "рысь", "каракал", "манул", "енот", "барсук", "хорек", "выдра", "норка", "куница", "сурикат", "дикобраз", "тапир", "ленивец", "муравьед", "броненосец"};
    private final String[] animalEyeColor = {"голубой", "зеленый", "карий", "серый", "черный", "янтарный", "ореховый", "бирюзовый", "сапфировый", "лазурный", "изумрудный", "аквамариновый", "нефритовый", "оливковый", "медовый", "шоколадный", "вишневый", "фиалковый", "аметистовый", "серо-голубой", "серо-зеленый", "золотистый", "пепельный", "стальной", "платиновый", "бронзовый", "кобальтовый", "индиго", "лиловый", "лавандовый", "бордовый", "графитовый", "карамельный", "кофейный", "темно-карий", "темно-зеленый", "темно-синий", "темно-серый", "светло-карий", "светло-зеленый", "светло-голубой", "светло-серый", "персиковый", "пурпурный", "малиновый", "гранатовый", "сине-зеленый", "серо-карий"};

    @Override
    public List fill(String entity) {
        int n = InputUtils.getInt("Количество: ");
        List<Animal> entities;
        entities= new ArrayList<Animal>();
        for (int i = 0; i < n; i++) {

            String species = animalSpecies[(int) (Math.random() * animalSpecies.length)];
            String eyeColor = animalEyeColor[(int) (Math.random() * animalEyeColor.length)];
            boolean hasFur = Math.random() > 0.5 ? true : false;

            if (!ValidationUtils.isValidAnimalData(species, eyeColor, hasFur)) {
                System.out.println("Введены недопустимые данные. Пожалуйста, попробуйте еще раз.");
                i--;
                continue;
            }

            entities.add(new Animal.Builder()
                    .species(species)
                    .eyeColor(eyeColor)
                    .hasFur(hasFur)
                    .build());
        }
        return  entities;
    }
}
