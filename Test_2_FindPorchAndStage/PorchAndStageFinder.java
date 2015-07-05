package Test_2_FindPorchAndStage;

/**
 * PorchAndStageFinder serves for find a porch and a stage from some apartment number.
 * Known that house has nine stages, and on one stage has four apartments.
 */
public class PorchAndStageFinder {

    // parameters of house
    private int numApartmentsOnStage = 4;
    private int numberOfStages = 9;
    private int maxNumApartmentsOfPorch;
    // input parameter
    private int apartmentNumber;
    // results values
    private int porch;
    private int stage;

    public int getPorch() {
        return porch;
    }

    public int getStage() {
        return stage;
    }

    public PorchAndStageFinder(int apartmentNumber){
        this.apartmentNumber = apartmentNumber;
        // defining maximal number of apartments in one porch
        maxNumApartmentsOfPorch = numberOfStages * numApartmentsOnStage;
    }

    public void findPorchAndStage() {

        // defining porch number
        if (apartmentNumber % maxNumApartmentsOfPorch > 0) {
            porch = apartmentNumber / maxNumApartmentsOfPorch + 1;
        } else porch = apartmentNumber / maxNumApartmentsOfPorch;

        // defining stage number
            stage = ((apartmentNumber-1) % maxNumApartmentsOfPorch) / numApartmentsOnStage + 1;
    }

    // Test drive
    public static void main(String[] args) {
        PorchAndStageFinder porchAndStageFinder = new PorchAndStageFinder(72);
        porchAndStageFinder.findPorchAndStage();
        System.out.println("Porch - " + porchAndStageFinder.getPorch() + ", stage - " + porchAndStageFinder.getStage());
    }

}
