package com.tedredington.apartment-finder.model;

public enum CraigslistAreas {

    US("United States"),
    CANADA("Canada"),
    EUROPE("Europe"),
    APAC_AND_ME("Asia Pacific and Middle East"),
    OCEANA("Oceana"),
    LATAM("Latan America and the Caribbean"),
    AFRICA("Africa");

    private final String description;

    private CraigslistAreas(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static enum States {
        AL("Alabama", CraigslistAreas.US),
        AK("Alaska", CraigslistAreas.US),
        AS("American Samoa", CraigslistAreas.US),
        AZ("Arizona", CraigslistAreas.US),
        AR("Arkansas", CraigslistAreas.US),
        CA("California", CraigslistAreas.US),
        CO("Colorado", CraigslistAreas.US),
        CT("Connecticut", CraigslistAreas.US),
        DE("Delaware", CraigslistAreas.US),
        DC("Washington DC", CraigslistAreas.US),
        FL("Florida", CraigslistAreas.US),
        GA("Georgia", CraigslistAreas.US),
        GU("Guam", CraigslistAreas.US),
        HI("Hawaii", CraigslistAreas.US),
        ID("Idaho", CraigslistAreas.US),
        IL("Illinois", CraigslistAreas.US),
        IN("Indiana", CraigslistAreas.US),
        IA("Idaho", CraigslistAreas.US),
        KS("Kansas", CraigslistAreas.US),
        KY("Kentucky", CraigslistAreas.US),
        LA("Louisiana", CraigslistAreas.US),
        ME("Maine", CraigslistAreas.US),
        MD("Maryland", CraigslistAreas.US),
        MA("Massachusetts", CraigslistAreas.US),
        MI("Michigan", CraigslistAreas.US),
        MN("Minnesota", CraigslistAreas.US),
        MS("Mississippi", CraigslistAreas.US),
        MO("Missouri", CraigslistAreas.US),
        MT("Montana", CraigslistAreas.US),
        NE("Nebraska", CraigslistAreas.US),
        NV("Nevada", CraigslistAreas.US),
        NH("New Hampshire", CraigslistAreas.US),
        NJ("New Jersey", CraigslistAreas.US),
        NM("New Mexico", CraigslistAreas.US),
        NY("New York", CraigslistAreas.US),
        NC("North Carolina", CraigslistAreas.US),
        ND("North Dakota", CraigslistAreas.US),
        MP("Northern Mariana IS", CraigslistAreas.US),
        OH("Ohio", CraigslistAreas.US),
        OK("Oklahoma", CraigslistAreas.US),
        OR("Oregon", CraigslistAreas.US),
        PA("Pennsylvania", CraigslistAreas.US),
        PR("Puerto Rico", CraigslistAreas.US),
        RI("Rhode Island", CraigslistAreas.US),
        SC("South Carolina", CraigslistAreas.US),
        SD("South Dakota", CraigslistAreas.US),
        TN("Tennessee", CraigslistAreas.US),
        TX("Texas", CraigslistAreas.US),
        UT("Utah", CraigslistAreas.US),
        VT("Vermont", CraigslistAreas.US),
        VA("Virginia", CraigslistAreas.US),
        VI("Virgin Islands", CraigslistAreas.US),
        WA("Washington", CraigslistAreas.US),
        WV("West Virginia", CraigslistAreas.US),
        WI("Wisconsin", CraigslistAreas.US),
        WY("Wyoming", CraigslistAreas.US);

        private final String stateName;
        private final CraigslistAreas craigslistAreas;

        private States(String stateName, CraigslistAreas craigslistAreas) {
            this.stateName = stateName;
            this.craigslistAreas = craigslistAreas;
        }

        public String getDescription() {
            return stateName;
        }
    }

    public static enum CanadianProvinces {
        NL("Newfoundland and Labrador",CANADA),
        PE("Prince Edward Island", CANADA),
        NS("Nova Scotia",CANADA),
        NB("New Brunswick",CANADA),
        QC("Quebec",CANADA),
        ON("Ontario",CANADA),
        MB("Manitoba",CANADA),
        SK("Saskatchewan",CANADA),
        AB("Alberta",CANADA),
        BC("British Columbia",CANADA),
        YT("Yukon",CANADA),
        NT("Northwest Territories",CANADA),
        NU("Nunavut",CANADA);


        private final String provinceName;
        private final CraigslistAreas craigslistAreas;

        private CanadianProvinces(String provinceName, CraigslistAreas craigslistAreas) {
            this.provinceName = provinceName;
            this.craigslistAreas = craigslistAreas;
        }

        public String getProvinceName() {
            return provinceName;
        }
    }

}
