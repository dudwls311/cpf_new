/**
 * @version 3.2.0.1
 */
/**
 * Copyright 2012 Twitter, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua_parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Device parser using ua-parser regexes. Extracts device information from user agent strings.
 *
 * @author Steve Jiang (@sjiang) <gh at iamsteve com>
 */
public class DeviceParser {
  List<DevicePattern> patterns;
  private final Set<String> mobileUAFamilies, mobileOSFamilies;
  private final UserAgentParser uaParser;

  public DeviceParser(List<DevicePattern> patterns, UserAgentParser uaParser,
                      Set<String> mobileUAFamilies, Set<String> mobileOSFamilies) {
    this.patterns = patterns;
    this.uaParser = uaParser;
    this.mobileUAFamilies = mobileUAFamilies;
    this.mobileOSFamilies = mobileOSFamilies;
  }

  public Device parse(String agentString) {
    return parse(agentString, uaParser.parse(agentString).family);
  }

  public Device parse(String agentString, String userAgentFamily) {
    String device = null;
    for (DevicePattern p : patterns) {
      if ((device = p.match(agentString)) != null) {
        break;
      }
    }

    String osFamily = device == null ? "Other" : device;
    userAgentFamily = userAgentFamily == null ? "Other" : userAgentFamily;

    return new Device(device,
                      mobileUAFamilies.contains(userAgentFamily) || mobileOSFamilies.contains(osFamily),
                      (device != null && device.equals("Spider")));
  }

  public static DeviceParser fromList(List<Map> configList, UserAgentParser uaParser,
                                      Set<String> mobileUAFamilies, Set<String> mobileOSFamilies) {
    List<DevicePattern> configPatterns = new ArrayList<DevicePattern>();
    for (Map<String,String> configMap : configList) {
      configPatterns.add(DeviceParser.patternFromMap(configMap));
    }
    return new DeviceParser(configPatterns, uaParser, mobileUAFamilies, mobileOSFamilies);
  }

  protected static DevicePattern patternFromMap(Map<String, String> configMap) {
    String regex = configMap.get("regex");
    if (regex == null) {
      throw new IllegalArgumentException("Device is missing regex");
    }
    return new DevicePattern(Pattern.compile(regex),
                             configMap.get("device_replacement"));
  }

  protected static class DevicePattern {
    private final Pattern pattern;
    private final String familyReplacement;

    public DevicePattern(Pattern pattern, String familyReplacement) {
      this.pattern = pattern;
      this.familyReplacement = familyReplacement;
    }

    public String match(String agentString) {
      Matcher matcher = pattern.matcher(agentString);

      if (!matcher.find()) {
        return null;
      }

      String family = null;
      if (familyReplacement != null) {
        if (familyReplacement.contains("$1") && matcher.groupCount() >= 1 && matcher.group(1) != null) {
          family = familyReplacement.replaceFirst("\\$1", Matcher.quoteReplacement(matcher.group(1)));
        } else {
          family = familyReplacement;
        }
      } else if (matcher.groupCount() >= 1) {
        family = matcher.group(1);
      }
      return family;
    }
  }

}