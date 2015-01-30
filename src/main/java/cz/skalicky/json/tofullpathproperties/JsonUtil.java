package cz.skalicky.json.tofullpathproperties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class JsonUtil {

    private static final ObjectMapper prettyMapper;

    static {
        prettyMapper = new ObjectMapper();
        prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // @formatter:off
		prettyMapper.setVisibilityChecker(prettyMapper.getSerializationConfig()
				.getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.NONE)
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
				.withIsGetterVisibility(JsonAutoDetect.Visibility.ANY)
				.withGetterVisibility(JsonAutoDetect.Visibility.ANY)
				.withSetterVisibility(JsonAutoDetect.Visibility.ANY));
		// @formatter:on
    }

    private JsonUtil() {
    }

    public static String toFormattedString(final Object object) {
        try {
            return prettyMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
