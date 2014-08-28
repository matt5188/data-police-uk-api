package uk.police.data.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import uk.police.data.api.schema.NeighbourhoodBoundary;
import uk.police.data.api.schema.Point;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class NeighbourhoodBoundryDeserializer extends StdDeserializer<NeighbourhoodBoundary> {

    private static final long serialVersionUID = 1L;

    protected NeighbourhoodBoundryDeserializer() {
        super(NeighbourhoodBoundary.class);
    }

    @Override
    public NeighbourhoodBoundary deserialize(JsonParser parser, DeserializationContext ctx) throws IOException,
            JsonProcessingException {
        NeighbourhoodBoundary result = new NeighbourhoodBoundary();
        Point[] points = parser.getCodec().readValue(parser, Point[].class);
        result.setPoints(Arrays.asList(points));
        return result;
    }
}
