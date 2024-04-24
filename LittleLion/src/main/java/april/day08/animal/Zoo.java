package april.day08.animal;



public class Zoo {
    Animal[] animals = new Animal[5];
    int animalsIndex = 0;

    public void addAnimal(april.day08.animal.Animal animal){
        if(animalsIndex < animals.length)
            animals[animalsIndex++] = animal;
        else
            System.out.println("이동물원은 더이상 동물이 들어올 수 없어요.ㅠㅠ");
    }

    public void makeAllSounds(){
        for(Animal animal:animals){
            if(animal != null)
                animal.makeSound();
        }
    }
}

