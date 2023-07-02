package net.ddns.samjviana.bunchofthings.state.properties;

import net.minecraft.util.StringRepresentable;

public enum Colors implements StringRepresentable {
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
	public String getSerializedName() {
		return this.name;
	}
	
}
