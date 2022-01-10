package L05Polymorphism.Exercise.DemoRuntimePOLYMORPHISM;

public class Main {
    public static void main(String[] args) {



        // RUNTIME POLYMORPHISM използваме OVERRIDE-ване
        // РАЗЛИЧНА ИМПЛЕМЕНТАЦИЯ НА КЛАС, АБСТРАКТЕН КЛАС ИЛИ ИНТЕРФЕЙС

        ElectronicMusic myTechnoMusic = new Techno();
        myTechnoMusic.playMusic();

        ElectronicMusic myHouseMusic = new House();
        myHouseMusic.playMusic();

        // instanceof проверява какъв е обекта от дадена референция

        if (myHouseMusic instanceof House) {

        }


    }
}
