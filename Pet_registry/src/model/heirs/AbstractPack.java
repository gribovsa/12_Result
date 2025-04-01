package model.heirs;

import model.AbstractAnimal;

/*todo
    В ПО Pet_registry класс не используется
    сделал в качестве примера для решения задания
 */

//Описывает абстрактное вьючное животное
public class AbstractPack extends AbstractAnimal {

    //Грузоподъемность животного, кг
    private int loadCapacity;

    public AbstractPack(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
