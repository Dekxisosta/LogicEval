package dev.dekxi.logic.ui;

/*===============================
 * BORDER CONFIGURATION / ENUM
 *===============================*/
/** Styles used for console formatting. Easier to maintain */
enum Border {
    /* Border directions with corresponding styles */
    VERTICAL_OUTER("||"),
    VERTICAL_INNER("|"),
    HORIZONTAL_OUTER("="),
    HORIZONTAL_INNER("-");

    /** Ensures style cannot be mutated */
    private final String style;

    /**
     * Package-private constructor to ensure fixed package scope <p></p>
     * @param style the style of the border
     */
    Border(String style) { this.style = style; }

    /**
     * Gets the corresponding style of the chosen enum constant <p></p>
     * @return style used for formatting tables
     */
    public String style() { return style; }
}
