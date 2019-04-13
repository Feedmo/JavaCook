package reading.dsAndAlgos.codingInterviewGuide.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by ran
 */
public class CatDogQueue {
    private Queue<PetEnterQueue> dogs;
    private Queue<PetEnterQueue> cats;
    private long count;

    public CatDogQueue() {
        this.dogs= new LinkedList<>();
        this.cats= new LinkedList<>();
        this.count = 0;
    }

    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Cat extends Pet {
        public Cat(String type) {
            super("cat");
        }
    }
    class Dog extends Pet {
        public Dog(String type) {
            super("dog");
        }
    }

    class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getType() {
            return pet.getType();
        }
    }

    public void add(Pet pet) {
        switch (pet.getType()) {
            case "dog":
                this.dogs.add(new PetEnterQueue(pet, count++));
                break;
            case "cat":
                this.cats.add(new PetEnterQueue(pet, count++));
                break;
            default:
                throw new RuntimeException("err, not dog or cat");
        }
    }

    public Queue<Pet> pollAll() {
        Queue<Pet> pets = new LinkedList<>();
        while (!dogs.isEmpty() && !cats.isEmpty()) {
            if (dogs.poll().getCount() < cats.poll().getCount()) {
                pets.add(dogs.poll().getPet());
            } else {
                pets.add(cats.poll().getPet());
            }
        }

        if (dogs.isEmpty()) {
            while (!cats.isEmpty()) {
                pets.add(cats.poll().getPet());
            }
        }

        if (cats.isEmpty()) {
            while (!dogs.isEmpty()) {
                pets.add(dogs.poll().getPet());
            }
        }
        return pets;
    }

    public Dog pollDog() {
        if (dogs.isEmpty()) {
            throw new RuntimeException("odg queue is empty");
        } else {
            return (Dog) dogs.poll().getPet();
        }
    }

    public Cat pollCat() {
        if (cats.isEmpty()) {
            throw new RuntimeException("odg queue is empty");
        } else {
            return (Cat) cats.poll().getPet();
        }
    }

    // empty check ...
}
