package de.focus_shift.jollyday.tests;

import de.focus_shift.jollyday.core.HolidayCalendar;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

class Iso3166Test {

  private static final List<String> noneIso3166Countries = List.of("DJ_STOXX", "LME", "NYSE", "TARGET", "XK");

  @Test
  void ensureThatAllCountryAreISO3166Conform() {
    final Set<String> isoCountries = Set.of(Locale.getISOCountries());

    stream(HolidayCalendar.values())
      .filter(holidayCalendar -> !noneIso3166Countries.contains(holidayCalendar.getId()))
      .forEach(holidayCalendar -> assertThat(holidayCalendar.getId()).isIn(isoCountries));
  }
}
