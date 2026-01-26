package tw.edu.ntub.imd.birc.coursemanagement.util.json;

import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface ResponseData {
    JsonNode getData();
}
