package utils.helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataGen {

    private static final Logger log = LogManager.getLogger(DataGen.class);

    private static String name;
    private static String introDate;
    private static String discontDate;
    private static String companyName;

    private static String updatedName;
    private static String updatedIntroDate;
    private static String updatedDiscontDate;
    private static String updatedCompanyName;

    public static String getStrangeName() {
        return "!£&*(@)$_+=^-[];'#,./{}:~<>?|"; }

    public static String getName() {
        if (name == null) {
            name = RandomStringUtils.randomAlphanumeric(10);
            log.debug("name is: " + name);
        }
        return name;
    }

    public static String getIntroDate() {
        if (introDate == null) {
            introDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            log.debug("introDate is: " + introDate);
    }
        return introDate;
    }

    public static String getDiscontDate() {
        if (discontDate == null) {
            discontDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            log.debug("discontDate is: " + discontDate);
    }
        return discontDate;
    }

    public static String getFormattedIntroDate() {
        return LocalDate.parse(introDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    public static String getFormattedDiscontDate() {
        return LocalDate.parse(discontDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    public static String getCompanyName() {
        if (companyName == null) {
            companyName = "Nokia";
            log.debug("companyName is: " + companyName);
        }
        return companyName;
    }

    public static String getUpdatedName() {
        if (updatedName == null) {
            updatedName = RandomStringUtils.randomAlphanumeric(10);
            log.debug("updatedName is: " + updatedName);
        }
        return updatedName;
    }

    public static String getUpdatedIntroDate() {
        if (updatedIntroDate == null) {
            updatedIntroDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            log.debug("updatedIntroDate is: " + updatedIntroDate);
        }
        return updatedIntroDate;
    }

    public static String getUpdatedDiscontDate() {
        if (updatedDiscontDate == null) {
            updatedDiscontDate = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            log.debug("updatedDiscontDate is: " + updatedDiscontDate);
        }
        return updatedDiscontDate;
    }

    public static String getFormattedUpdatedIntroDate() {
        return LocalDate.parse(updatedIntroDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    public static String getFormattedUpdatedDiscontDate() {
        return LocalDate.parse(updatedDiscontDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    public static String getUpdatedCompanyName() {
        if (updatedCompanyName == null) {
            updatedCompanyName = "Nintendo";
            log.debug("updatedCompanyName is: " + updatedCompanyName);
        }
        return updatedCompanyName;
    }
}
