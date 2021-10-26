package com.tedredington.apartment-finder.model;

public enum CraigslistSites {

    SAN_FRANCISCO("sfbay", CraigslistAreas.States.CA),
    ATLANTA("atlanta", CraigslistAreas.States.GA),
    SAVANNAH("savannah", CraigslistAreas.States.GA),
    CHICAGO("chicago", CraigslistAreas.States.IL);

    private final CraigslistAreas.States craigslistAreas;
    private String subdomain;

    private CraigslistSites(String subdomain, CraigslistAreas.States craigslistAreas) {
        this.craigslistAreas = craigslistAreas;
        this.subdomain = subdomain;
    }

    public String getSubdomain() {
        return subdomain;
    }
}
