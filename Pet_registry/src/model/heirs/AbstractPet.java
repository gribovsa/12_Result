package model.heirs;

import model.AbstractAnimal;

/*todo
    В ПО Pet_registry класс не используется
    сделал в качестве примера для решения задания
 */

//Описывает абстрактное домашнее животное
public class AbstractPet extends AbstractAnimal {

    //Номер чипа
    private int chipNumber;

    public AbstractPet(int chipNumber) {
        this.chipNumber = chipNumber;
    }
}
