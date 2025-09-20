package calculator.dto;

public class ParsedResult {
  private final String customSeparator;
  private final String mainString;

  public ParsedResult(String customSeparator, String mainString) {
    this.customSeparator = customSeparator;
    this.mainString = mainString;
  }

  public String getCustomSeparator() {
    return customSeparator;
  }

  public String getMainString() {
    return mainString;
  }
}
