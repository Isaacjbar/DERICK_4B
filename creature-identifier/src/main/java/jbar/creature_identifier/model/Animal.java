package jbar.creature_identifier.model;

import lombok.Data;

@Data
public class Animal {
    private int specie;          // Especie como un int (1: Mammal, 2: Bird, etc.)
    private double size;         // Tamaño del animal en metros
    private int hasFur;          // 0 o 1 (0: No tiene pelo, 1: Tiene pelo)
    private int isAquatic;       // 0 o 1 (0: No acuático, 1: Acuático)
    private int isCarnivore;     // 0 o 1 (0: Herbívoro, 1: Carnívoro)
    private int isNocturnal;     // 0 o 1 (0: Diurno, 1: Nocturno)
    private int hasWings;        // 0 o 1 (0: No tiene alas, 1: Tiene alas)
    private int isDomesticated;  // 0 o 1 (0: No domesticado, 1: Domesticado)
    private int isEndangered;    // 0 o 1 (0: No en peligro, 1: En peligro)
    private int hasClaws;        // 0 o 1 (0: No tiene garras, 1: Tiene garras)
    private int canFly;          // 0 o 1 (0: No puede volar, 1: Puede volar)
}

