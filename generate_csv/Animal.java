public class Animal {
    private int specie;             // Código de la especie (ejemplo: 1 = Mamífero, 2 = Ave, etc.)
    private double size;            // Tamaño del animal (por ejemplo, peso o altura)

    // Propiedades binarias (0 o 1)
    private int hasFur;             // 1 = Tiene pelo, 0 = No tiene pelo
    private int isAquatic;          // 1 = Acuático, 0 = Terrestre
    private int isCarnivore;        // 1 = Carnívoro, 0 = Herbívoro
    private int isNocturnal;        // 1 = Nocturno, 0 = Diurno
    private int hasWings;           // 1 = Tiene alas, 0 = No tiene alas
    private int isDomesticated;     // 1 = Domesticado, 0 = Salvaje
    private int isEndangered;       // 1 = En peligro, 0 = No en peligro
    private int hasClaws;           // 1 = Tiene garras, 0 = No tiene garras
    private int canFly;             // 1 = Puede volar, 0 = No puede volar
    
    public Animal(int specie, double size, int hasFur, int isAquatic, int isCarnivore, int isNocturnal, int hasWings,
            int isDomesticated, int isEndangered, int hasClaws, int canFly) {
        this.specie = specie;
        this.size = size;
        this.hasFur = hasFur;
        this.isAquatic = isAquatic;
        this.isCarnivore = isCarnivore;
        this.isNocturnal = isNocturnal;
        this.hasWings = hasWings;
        this.isDomesticated = isDomesticated;
        this.isEndangered = isEndangered;
        this.hasClaws = hasClaws;
        this.canFly = canFly;
    }

    public Animal() {
        //TODO Auto-generated constructor stub
    }

    public int getSpecie() {
        return specie;
    }

    public void setSpecie(int specie) {
        this.specie = specie;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getHasFur() {
        return hasFur;
    }

    public void setHasFur(int hasFur) {
        this.hasFur = hasFur;
    }

    public int getIsAquatic() {
        return isAquatic;
    }

    public void setIsAquatic(int isAquatic) {
        this.isAquatic = isAquatic;
    }

    public int getIsCarnivore() {
        return isCarnivore;
    }

    public void setIsCarnivore(int isCarnivore) {
        this.isCarnivore = isCarnivore;
    }

    public int getIsNocturnal() {
        return isNocturnal;
    }

    public void setIsNocturnal(int isNocturnal) {
        this.isNocturnal = isNocturnal;
    }

    public int getHasWings() {
        return hasWings;
    }

    public void setHasWings(int hasWings) {
        this.hasWings = hasWings;
    }

    public int getIsDomesticated() {
        return isDomesticated;
    }

    public void setIsDomesticated(int isDomesticated) {
        this.isDomesticated = isDomesticated;
    }

    public int getIsEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(int isEndangered) {
        this.isEndangered = isEndangered;
    }

    public int getHasClaws() {
        return hasClaws;
    }

    public void setHasClaws(int hasClaws) {
        this.hasClaws = hasClaws;
    }

    public int getCanFly() {
        return canFly;
    }

    public void setCanFly(int canFly) {
        this.canFly = canFly;
    }
    
}
