package petsuppliespets;

public class PetTest {

    public static void main(String[] args) {
        SortedADT sorted = new Pet();
        String pet;
        Integer option;
        do {
            System.out.println("0: Quit");
            System.out.println("1: Insert pets");
            System.out.println("2: Remove pets");
            System.out.println("3: Find pets");
            System.out.println("4: Display pets");
            System.out.println("5: Show traversals");
            option = Input.getInteger("option: ");
            switch (option) {
                case 0:
                    System.out.println("quitting program");
                    break;
                case 1:
                    pet = Input.getString("pet: ");
                    try {
                        sorted.insert(pet);
                        System.out.println("inserted");
                    } catch (SortedADT.NotUniqueException e) {
                        System.out.println("insert invalid - pet not unique");
                    }
                    break;
                case 2:
                    pet = Input.getString("pet: ");
                    try {
                        pet = (String) sorted.remove(pet);
                        System.out.println(pet + " removed");
                    } catch (SortedADT.NotFoundException e) {
                        System.out.println("remove invalid - pet not found");
                    }
                    break;
                case 3:
                    pet = Input.getString("pet: ");
                    try {
                        pet = (String) sorted.find(pet);
                        System.out.println(pet + " found");
                    } catch (SortedADT.NotFoundException e) {
                        System.out.println("pet not found");
                    }
                    break;
                case 4:
                    System.out.println(sorted);
                    break;
                case 5:
                    // downcast as method not part of the interface
                    System.out.println(((Pet) sorted).getTraversals());
                    break;
                default:
                    System.out.println("invalid option");
            }
        } while (option != 0);
    }

}
