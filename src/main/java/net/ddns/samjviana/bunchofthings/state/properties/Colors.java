package net.ddns.samjviana.bunchofthings.state.properties;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.IStringSerializable;

public enum Colors implements IStringSerializable {
    WHITE("white"),
    ORANGE("orange"),
    MAGENTA("magenta"),
    LIGHT_BLUE("light_blue"),
    YELLOW("yellow"),
    LIME("lime"),
    PINK("pink"),
    GRAY("gray"),
    LIGHT_GRAY("light_gray"),
    CYAN("cyan"),
    PURPLE("purple"),
    BLUE("blue"),
    BROWN("brown"),
    GREEN("green"),
    RED("red"),
    BLACK("black");
     
    private final String name;
 
    private Colors(String name) {
        this.name = name;
    }
 
    public String toString() {
        return this.name;
    }
    
    @Override
    public String func_176610_l() {
        return this.name;
    }    
}