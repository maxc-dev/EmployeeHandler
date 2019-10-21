package org.com1027.formative.mc01584;

/**
 * @author Max Carter
 * @since 19/10/2019
 */
public class CompanyPosition {
    /** Name of the position. */
    private String positionName = null;

    /** Creates a new company position. */
    CompanyPosition() {}

    /**
     * Creates a new company position with a name.
     * @param positionName Name of the position.
     */
    CompanyPosition(String positionName) {
        setPositionName(positionName);
    }

    /**
     * Sets the name of the company position.
     * @param positionName Name of the position.
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * Gets the name of the company position.
     * @return Name of the position.
     */
    public String getPositionName() {
        return positionName;
    }
}
